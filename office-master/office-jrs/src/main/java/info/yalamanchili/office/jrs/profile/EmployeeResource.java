/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dto.profile.EmergencyContactDto;
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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/employee")
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
    @Path("/read/{id}")
    public info.yalamanchili.office.dto.profile.Employee readEmployee(@PathParam("id") Long id) {
        return mapper.map(getDao().findById(id), info.yalamanchili.office.dto.profile.Employee.class);
    }

    @GET
    @Path("/{id}")
    @Override
    public Employee read(Long id) {
        return null;
    }

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

    @PUT
    @Path("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void delete(@PathParam("id") Long id) {
        super.delete(id);
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
        //If skillset not present create a empty skillset so certifications and skills can be added.
        if (emp.getSkillSet() == null) {
            SkillSet ss = new SkillSet();
            emp.setSkillSet(ss);
        }
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
        emp.setSkillSet(skillSetUpdated);
        emp = em.merge(emp);
        profileNotificationservice.skillSetUpdatedNotification(emp);
        return emp.getSkillSet().getId().toString();
    }
    /* Preferences*/

    @GET
    @Path("/preferences/{empId}")
    public Preferences getPreferences(@PathParam("empId") long empId) {
        Employee emp = (Employee) getDao().findById(empId);
        return emp.getPreferences();

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
        //email = getDao().getEntityManager.(emp, email);
        email = employeeDao.updatePrimaryEmail(emp, email);
        emp.addEmail(email);
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

    /**
     * Get Client Information
     *
     * @param id
     * @param start
     * @param limit
     * @return
     */
    @GET
    @Path("/clientinformation/{id}/{start}/{limit}")
    public ClientInformationTable getClientInformations(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        ClientInformationTable tableObj = new ClientInformationTable();
        Employee emp = (Employee) getDao().findById(id);
        List<ClientInformation> clientInfoDtos = new ArrayList<ClientInformation>();
        for (ClientInformation entity : emp.getClientInformations()) {
            clientInfoDtos.add(entity);
        }
        tableObj.setEntities(clientInfoDtos);
        tableObj.setSize((long) emp.getClientInformations().size());
        return tableObj;
    }

    /**
     * Add Client Information
     *
     * @param empId
     * @param clientInformation
     */
    @PUT
    @Path("/clientinformation/{empId}")
    public void addClientInformation(@PathParam("empId") Long empId, ClientInformation clientInformation) {
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
        List<EmergencyContactDto> emergencyContacts = new ArrayList<EmergencyContactDto>();
        for (EmergencyContact ec : emp.getEmergencyContacts()) {
            emergencyContacts.add(EmergencyContactDto.map(mapper, ec));
        }
        tableObj.setEntities(emergencyContacts);
        tableObj.setSize((long) emp.getEmergencyContacts().size());
        return tableObj;
    }

    @PUT
    @Path("/emergencycontact/{empId}")
    public void addEmergencyContact(@PathParam("empId") Long empId, EmergencyContactDto ecDto) {
        EmergencyContactService emergencyContactService = (EmergencyContactService) SpringContext.getBean("emergencyContactService");
        emergencyContactService.addEmergencyContact(empId, ecDto);
    }

    @GET
    @Path("/searchEmployee/{start}/{limit}")
    public List<info.yalamanchili.office.dto.profile.Employee> searchEmployee(@PathParam("start") int start,
            @PathParam("limit") int limit, @QueryParam("text") String text) {
        List<info.yalamanchili.office.dto.profile.Employee> employees = new ArrayList<info.yalamanchili.office.dto.profile.Employee>();
        for (Object empObj : getDao().search(text, start, limit, true)) {
            employees.add(info.yalamanchili.office.dto.profile.Employee.map(mapper, (Employee) empObj));
        }
        return employees;
    }

    @PUT
    @Path("/searchEmployee/{start}/{limit}")
    public List<info.yalamanchili.office.dto.profile.Employee> searchEmployee(Employee entity, @PathParam("start") int start, @PathParam("limit") int limit) {
        List<info.yalamanchili.office.dto.profile.Employee> employees = new ArrayList<info.yalamanchili.office.dto.profile.Employee>();
        for (Object empObj : getDao().search(entity, start, limit)) {
            employees.add(info.yalamanchili.office.dto.profile.Employee.map(mapper, (Employee) empObj));
        }
        return employees;
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
