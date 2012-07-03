/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.config.ApplicationContextProvider;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.*;
import info.yalamanchili.office.jrs.CRUDResource;
import info.yalamanchili.office.jrs.profile.AddressResource.AddressTable;
import info.yalamanchili.office.jrs.profile.EmailResource.EmailTable;
import info.yalamanchili.office.jrs.profile.SkillSetResource.SkillSetTable;
import info.yalamanchili.office.jrs.profile.EmergencyContactResource.EmergencyContactTable;
import info.yalamanchili.office.jrs.profile.PhoneResource.PhoneTable;
import info.yalamanchili.office.jrs.profile.ClientInformationResource.ClientInformationTable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @GET
    @Path("/{start}/{limit}")
    public EmployeeTable table(@PathParam("start") int start, @PathParam("limit") int limit) {
        EmployeeTable tableObj = new EmployeeTable();
        tableObj.setEntities(getDao().query(start, limit));
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
    @Path("/skillset/{id}")
    public SkillSet getSkillSet(@PathParam("id") long id)
            {
       
        Employee emp = (Employee) getDao().findById(id);
        return emp.getSkillSet(); 
        
    }
      
     @PUT
    @Path("/addskillset/{empId}")
    public void addSkillSet(@PathParam("empId") Long empId, SkillSet skillset) {
        Employee emp = (Employee) getDao().findById(empId);
        emp.setSkillSet(skillset);
        
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
    
    public Email UpdatePrimaryEmail(Employee emp,Email Newemail)
    {
       if(emp.getPrimaryEmail()== null)
       {
         Newemail.setPrimaryEmail(Boolean.TRUE);
       }
       else
       {
         if(Newemail.getPrimaryEmail())
         {
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
            clientInfoDtos.add(mapClientInformation(entity));
        }
        tableObj.setEntities(clientInfoDtos);
        tableObj.setSize((long) emp.getClientInformations().size());
        return tableObj;
    }
    
    public info.yalamanchili.office.dto.profile.ClientInformation mapClientInformation(ClientInformation entity) {
        info.yalamanchili.office.dto.profile.ClientInformation clientInformation = mapper.map(entity, info.yalamanchili.office.dto.profile.ClientInformation.class);
        mapper.map(entity.getContact(), clientInformation);
        if (entity.getContact().getPhones().size() > 0) {
            mapper.map(entity.getContact().getPhones().get(0), clientInformation);
        }
        return clientInformation;
    }
    
    @PUT
    @Path("/clientinformation/{empId}")
    public void addClientInformation(@PathParam("empId") Long empId, info.yalamanchili.office.dto.profile.ClientInformation clientInformation) {
        Employee emp = (Employee) getDao().findById(empId);
        
        Phone phone = new Phone();
        phone.setPhoneNumber(clientInformation.getPhoneNumber());
        
        Contact contact = new Contact();
        contact.setFirstName(clientInformation.getFirstName());
        contact.setLastName(clientInformation.getLastName());
        contact.setMiddleInitial(clientInformation.getMiddleInitial());
        contact.addPhone(phone);
        
        ClientInformation entity = new ClientInformation();
        entity.setReportsToRole(clientInformation.getReportsToRole());
        entity.setRtPrimary(clientInformation.isRtPrimary());
        entity.setContact(contact);
        ClientInformationDao clientInformationDao = ApplicationContextProvider.getApplicationContext().getBean("clientInformationDao", ClientInformationDao.class);
        entity = clientInformationDao.save(entity);
        emp.addClientInformation(entity);
    }

    /* Emergency Contact */
    @GET
    @Path("/emergencycontacts/{id}/{start}/{limit}")
    public EmergencyContactTable getEmergencyContacts(@PathParam("id") long id, @PathParam("start") int start,
            @PathParam("limit") int limit) {
        EmergencyContactTable tableObj = new EmergencyContactTable();
        Employee emp = (Employee) getDao().findById(id);
        tableObj.setEntities(emp.getEmergencyContacts());
        tableObj.setSize((long) emp.getEmergencyContacts().size());
        return tableObj;
    }
    
    @PUT
    @Path("/emergencycontact/{empId}")
    public void addEmergencyContact(@PathParam("empId") Long empId, EmergencyContact entity) {
        Employee emp = (Employee) getDao().findById(empId);
        entity.setContact((Contact) getDao().save(entity.getContact()));
        emp.addEmergencyContact(entity);
    }
    
    @Override
    public CRUDDao getDao() {
        return employeeDao;
    }
    
    @XmlRootElement
    @XmlType
    public static class EmployeeTable {
        
        protected Long size;
        protected List<Employee> entities;
        
        public Long getSize() {
            return size;
        }
        
        public void setSize(Long size) {
            this.size = size;
        }
        
        @XmlElement
        public List<Employee> getEntities() {
            return entities;
        }
        
        public void setEntities(List<Employee> entities) {
            this.entities = entities;
        }
    }
}
