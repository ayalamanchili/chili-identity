/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.dao.CRUDDao;
import info.chili.email.Email;
import info.chili.jpa.validation.Validate;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Branch;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.activiti.engine.task.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("secured/address")
@Component
@Scope("request")
public class AddressResource extends CRUDResource<Address> {

    @Autowired
    protected MailUtils mailUtils;
    @Autowired
    public AddressDao addressDao;
    @Autowired
    public EmployeeDao employeeDao;
    @Autowired
    protected OfficeSecurityService securityService;
    @Autowired
    protected ProfileNotificationService profileNotificationservice;

    @Override
    public CRUDDao getDao() {
        return addressDao;
    }

    @GET
    @Path("/{id}")
    @Transactional(readOnly = true)
    @Override
//    @AccessCheck(roles = {"ROLE_ADMIN", "ROLE_HR_ADMIN", "ROLE_HR", "ROLE_RELATIONSHIP", "ROLE_PAYROLL_AND_BENIFITS", "ROLE_HEALTH_INSURANCE_MANAGER", "ROLE_H1B_IMMIGRATION"}, strictOrderCheck = false, checkOnReturnObj = true, employeePropertyName = "employee")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR_ADMIN','ROLE_HR','ROLE_RELATIONSHIP','ROLE_PAYROLL_AND_BENIFITS','ROLE_HEALTH_INSURANCE_MANAGER','ROLE_H1B_IMMIGRATION','ROLE_USER')")
    public Address read(@PathParam("id") Long id) {
        return addressDao.findById(id);
    }

    @GET
    @Path("/options")
    @Produces("application/text")
    public String getManageAddressOptions(@QueryParam("id") Long employeeId) {
        Employee emp = null;
        if (employeeId != null) {
            emp = employeeDao.findById(employeeId);
        } else {
            emp = OfficeSecurityService.instance().getCurrentUser();
        }
        if (addressDao.getAddressByType(emp, "Home").size() > 0) {
            return "update";
        } else {
            return "create";
        }
    }

    @PUT
    @Validate
    @Path("/employee/")
    public Address saveEmployeeAddress(Address entity) {
        boolean notifyHealthInsurance = entity.isNotifyHealthInsurance();
        boolean notifyChange = entity.isNotifyChange();
        //Update existing home address
        if (entity.getContact() != null && entity.getAddressType() != null && entity.getAddressType().getAddressType() != null && entity.getAddressType().getAddressType().equals("Home") && addressDao.getAddressByType((Employee) entity.getContact(), "Home").size() > 0) {
            Address existingAddress = addressDao.getAddressByType((Employee) entity.getContact(), "Home").get(0);
            entity.setId(existingAddress.getId());
        }
        entity = save(entity);
        if (entity.getAddressType() != null && entity.getAddressType().getAddressType().equals("W2 Mailing")) {
            sendAddressChangeRequestSubmittedEmail(entity);
        }
        if (notifyChange == true) {
            if (!Branch.Hyderabad.equals(EmployeeDao.instance().findById(entity.getContact().getId()).getBranch())) {
                initiateAddressUpdateProcess(entity, null, notifyHealthInsurance);
            }
        }
        return entity;
    }

    public void sendAddressChangeRequestSubmittedEmail(Address address) {
        String[] roles = {OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name()};
        Email email = new Email();
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
        email.setSubject(" W2 Mailing Address Has Updated For :" + address.getContact().getFirstName() + " " + address.getContact().getLastName());
        String messageText = " <b>W2 Address for employee</b></br></br>" + "<b><i>Employee Name</i></b> :&nbsp;" + address.getContact().getFirstName() + " " + address.getContact().getLastName() + "</br>";
        messageText = messageText.concat("<b><i>Street1</i></b>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: " + address.getStreet1());
        if (address.getStreet2() != null) {
            messageText = messageText.concat("</br><b><i>Street2</i></b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: " + address.getStreet2());
        }
        messageText = messageText.concat("</br><b><i>City</i></b>    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: " + address.getCity() + "</br>");
        messageText = messageText.concat("<b><i>Country</i></b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : " + address.getCountry() + "</br>");
        messageText = messageText.concat("<b><i>State</i></b>   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: " + address.getState() + "</br>");
        messageText = messageText.concat("<b><i>Zip</i></b>     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: " + address.getZip());
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }

    public void initiateAddressUpdateProcess(Address entity, Employee emp, boolean notifyHealthInsurance) {
        validateExistingAddressUpdateRequest(entity.getId());
        if (emp == null) {
            emp = EmployeeDao.instance().findById(entity.getContact().getId());
        }
        if (entity.getAddressType().getAddressType().equals("Home")) {
            Map<String, Object> vars = new HashMap<>();
            vars.put("entity", entity);
            vars.put("entityId", entity.getId());
            vars.put("employeeName", emp.getFirstName() + " " + emp.getLastName());
            vars.put("company",emp.getCompany());
            vars.put("notifyHealthInsurance", notifyHealthInsurance);
            vars.put("allTasksCompleted", false);
            OfficeBPMService.instance().startProcess("home_address_update_process", vars);
        }
    }

    protected void validateExistingAddressUpdateRequest(Long addressId) {
        List<Task> tasks = OfficeBPMTaskService.instance().findTasksWithVariable("entityId", addressId);
        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("updateAddressPayrollTask")) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "update.request.pending", "Please wait for the existing request to complete. After which you can resubmit");
            }
        }
        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("updateHealthInsuranceTask")) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "update.request.pending", "Please wait for the existing request to complete. After which you can resubmit");
            }
        }
        for (Task task : tasks) {
            if (task.getTaskDefinitionKey().equals("updateAddressHRAdminTask")) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "update.request.pending", "Please wait for the existing request to complete. After which you can resubmit");
            }
        }
    }

    @PUT
    @Path("/delete/{id}")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
    }

    public static AddressResource instance() {
        return SpringContext.getBean(AddressResource.class);
    }

    @XmlRootElement
    @XmlType
    public static class AddressTable implements java.io.Serializable {

        protected Long size;
        protected List<Address> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<Address> getEntities() {
            return entities;
        }

        public void setEntities(List<Address> entities) {
            this.entities = entities;
        }
    }
}
