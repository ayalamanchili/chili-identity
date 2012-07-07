/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.EmergencyContactDao;
import info.yalamanchili.office.dto.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmergencyContact;
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
public class EmergencyContactService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;

    public void addEmergencyContact(Long empId, info.yalamanchili.office.dto.profile.EmergencyContact ec) {
        Employee emp = (Employee) em.find(Employee.class, empId);
        //TODO user mapper
        //Email
        Email email = new Email();
        email.setEmail(ec.getEmail());
        email.setPrimaryEmail(Boolean.TRUE);
        //phone
        Phone phone = new Phone();
        phone.setPhoneNumber(ec.getPhoneNumber());
        //contact
        Contact contact = new Contact();
        contact.setFirstName(ec.getFirstName());
        contact.setLastName(ec.getLastName());
        contact.setSex(ec.getSex());
        contact.addEmail(email);
        contact.addPhone(phone);
        contact = em.merge(contact);
        //emergencycontact
        EmergencyContact emergencyCnt = new EmergencyContact();
        emergencyCnt.setEcPrimary(ec.isEcPrimary());
        emergencyCnt.setRelation(ec.getRelation());
        emergencyCnt.setContact(contact);
        emergencyCnt.setEmployee(emp);
        em.merge(emergencyCnt);
    }
}
