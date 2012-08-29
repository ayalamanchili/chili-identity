/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.*;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.profile.AddressResource.AddressTable;
import info.yalamanchili.office.jrs.profile.EmailResource.EmailTable;
import info.yalamanchili.office.jrs.profile.EmergencyContactResource.EmergencyContactTable;
import info.yalamanchili.office.jrs.profile.PhoneResource.PhoneTable;
import info.yalamanchili.office.jrs.profile.ClientInformationResource.ClientInformationTable;
import info.yalamanchili.office.profile.ClientInformationService;
import info.yalamanchili.office.profile.EmergencyContactService;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("employee")
@Component
@Transactional
@Scope("request")
public class EmployeeResource extends CRUDResource<Employee> {

    @Autowired
    public EmployeeDao employeeDao;
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected ProfileNotificationService profileNotificationservice;

    @GET
    @Path("/{start}/{limit}")
    public EmployeeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        List<info.yalamanchili.office.dto.profile.Employee> employees = new ArrayList<info.yalamanchili.office.dto.profile.Employee>();
        EmployeeTable tableObj = new EmployeeTable();
        for (Object empObj : getDao().query(start, limit)) {
            employees.add(info.yalamanchili.office.dto.profile.Employee.map(mapper, (Employee) empObj));
        }
        tableObj.setEntities(employees);
        tableObj.setSize(getDao().size());
        return tableObj;
    }


    /* Address */
    @GET
    @Path("/addresses/{id}/{start}/{limit}")
    public AddressTable getAddresses(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        AddressTable tableObj = new AddressTable();
        Employee emp = (Employee) getDao().findById(id);
        tableObj.setEntities(emp.getAddresss());
        tableObj.setSize((long) emp.getAddresss().size());
        return tableObj;
    }

    @PUT
    @Path("/address/{empId}")
    public void addAddress(@PathParam("empId") Long empId, Address address) {
        Employee emp = (Employee) getDao().findById(empId);
        if (address.getAddressType() != null) {
            AddressType addressType = getDao().getEntityManager().find(AddressType.class,
                    address.getAddressType().getId());
            address.setAddressType(addressType);
        }
        emp.addAddress(address);
    }

    /* SkillSet */
    @GET
    @Path("/skillset/{empId}")
    public SkillSet getSkillSet(@PathParam("empId") long empId) {
        Employee emp = (Employee) getDao().findById(empId);
        return emp.getSkillSet();

    }

    @PUT
    @Path("/skillset/{empId}")
    @Produces("application/text")
    public String addSkillSet(@PathParam("empId") Long empId, SkillSet skillset) {
        Employee emp = (Employee) getDao().findById(empId);
        SkillSet skillSetUpdated = emp.getSkillSet();
        if (skillSetUpdated != null) {
            skillSetUpdated.setResumeUrl(skillset.getResumeUrl());

        } else {
            skillSetUpdated = skillset;
        }
        skillSetUpdated.setLastUpdated(new Date());
        emp.setSkillSet(skillSetUpdated);
        emp = em.merge(emp);
        profileNotificationservice.skillSetUpdatedNotification(emp);
        return emp.getSkillSet().getId().toString();
    }

    /* Email */
    @GET
    @Path("/emails/{id}/{start}/{limit}")
    public EmailTable getEmails(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        EmailTable tableObj = new EmailTable();
        Employee emp = (Employee) getDao().findById(id);
        tableObj.setEntities(emp.getEmails());
        tableObj.setSize((long) emp.getEmails().size());
        return tableObj;
    }

    @PUT
    @Path("/email/{empId}")
    public void addEmail(@PathParam("empId") Long empId, Email email) {
        Employee emp = (Employee) getDao().findById(empId);

        if (email.getEmailType() != null) {
            EmailType emailType = getDao().getEntityManager().find(EmailType.class, email.getEmailType().getId());
            email.setEmailType(emailType);
        }
        email = UpdatePrimaryEmail(emp, email);
        emp.addEmail(email);
    }

    public Email UpdatePrimaryEmail(Employee emp, Email Newemail) {
        if (emp.getPrimaryEmail() == null) {
            Newemail.setPrimaryEmail(Boolean.TRUE);
        } else {
            if (Newemail.getPrimaryEmail()) {
                Email chkEmail = emp.getPrimaryEmail();
                chkEmail.setPrimaryEmail(Boolean.FALSE);
            }
        }
        return Newemail;

    }
    /* Phone */

    @GET
    @Path("/phones/{id}/{start}/{limit}")
    public PhoneTable getPhones(@PathParam("id") long id, @PathParam("start") int start, @PathParam("limit") int limit) {
        PhoneTable tableObj = new PhoneTable();
        Employee emp = (Employee) getDao().findById(id);
        tableObj.setEntities(emp.getPhones());
        tableObj.setSize((long) emp.getPhones().size());
        return tableObj;
    }

    @PUT
    @Path("/phone/{empId}")
    public void addPhone(@PathParam("empId") Long empId, Phone phone) {
        Employee emp = (Employee) getDao().findById(empId);
        if (phone.getPhoneType() != null) {
            PhoneType phoneType = getDao().getEntityManager().find(PhoneType.class, phone.getPhoneType().getId());
            phone.setPhoneType(phoneType);
        }
        emp.addPhone(phone);
    }

    /* ResportsTo */
    @GET
    @Path("/clientinformation/{id}/{start}/{limit}")
    public ClientInformationTable getClientInformations(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        ClientInformationTable tableObj = new ClientInformationTable();
        Employee emp = (Employee) getDao().findById(id);
        List<info.yalamanchili.office.dto.profile.ClientInformation> clientInfoDtos = new ArrayList<info.yalamanchili.office.dto.profile.ClientInformation>();
        for (ClientInformation entity : emp.getClientInformations()) {
            clientInfoDtos.add(info.yalamanchili.office.dto.profile.ClientInformation.map(mapper, entity));
        }
        tableObj.setEntities(clientInfoDtos);
        tableObj.setSize((long) emp.getClientInformations().size());
        return tableObj;
    }

    @PUT
    @Path("/clientinformation/{empId}")
    public void addClientInformation(@PathParam("empId") Long empId, info.yalamanchili.office.dto.profile.ClientInformation clientInformation) {
        ClientInformationService clientInformationService = (ClientInformationService) SpringContext.getBean("clientInformationService");
        clientInformationService.addClientInformation(empId, clientInformation);
    }

    /* Emergency Contact */
    @GET
    @Path("/emergencycontacts/{id}/{start}/{limit}")
    public EmergencyContactTable getEmergencyContacts(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        EmergencyContactTable tableObj = new EmergencyContactTable();
        Employee emp = (Employee) getDao().findById(id);
        List<info.yalamanchili.office.dto.profile.EmergencyContact> emergencyContacts = new ArrayList<info.yalamanchili.office.dto.profile.EmergencyContact>();
        for (EmergencyContact ec : emp.getEmergencyContacts()) {
            emergencyContacts.add(info.yalamanchili.office.dto.profile.EmergencyContact.map(mapper, ec));
        }
        tableObj.setEntities(emergencyContacts);
        tableObj.setSize((long) emp.getEmergencyContacts().size());
        return tableObj;
    }

    @PUT
    @Path("/emergencycontact/{empId}")
    public void addEmergencyContact(@PathParam("empId") Long empId, info.yalamanchili.office.dto.profile.EmergencyContact ec) {
        EmergencyContactService emergencyContactService = (EmergencyContactService) SpringContext.getBean("emergencyContactService");
        emergencyContactService.addEmergencyContact(empId, ec);
    }

    @Override
    public CRUDDao getDao() {
        return employeeDao;
    }

    @XmlRootElement
    @XmlType
    public static class EmployeeTable {

        protected Long size;
        protected List<info.yalamanchili.office.dto.profile.Employee> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<info.yalamanchili.office.dto.profile.Employee> getEntities() {
            return entities;
        }

        public void setEntities(List<info.yalamanchili.office.dto.profile.Employee> entities) {
            this.entities = entities;
        }
    }
}
