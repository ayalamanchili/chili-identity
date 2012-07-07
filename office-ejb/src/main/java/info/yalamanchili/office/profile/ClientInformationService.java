/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.yalamanchili.office.config.ApplicationContextProvider;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author anu
 */
@Component
public class ClientInformationService {
    
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    
    public void addClientInformation(Long empId, info.yalamanchili.office.dto.profile.ClientInformation clientInformation) {
        Employee emp = (Employee) em.find(Employee.class, empId);
        
        Email email = new Email();
        email.setEmail(clientInformation.getEmail());
        email.setPrimaryEmail(Boolean.TRUE);
        
        Phone phone = new Phone();
        phone.setPhoneNumber(clientInformation.getPhoneNumber());
        
        Contact contact = new Contact();
        contact.setFirstName(clientInformation.getFirstName());
        contact.setLastName(clientInformation.getLastName());
        contact.setMiddleInitial(clientInformation.getMiddleInitial());
        contact.addPhone(phone);
        contact.addEmail(email);
        
        ClientInformation entity = new ClientInformation();
        entity.setReportsToRole(clientInformation.getReportsToRole());
        entity.setConsultantJobTitle(clientInformation.getConsultantJobTitle());
        entity.setRtPrimary(clientInformation.isRtPrimary());
        entity.setContact(contact);
        entity.setEmployee(emp);
        em.merge(entity);
    }
}
