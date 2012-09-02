/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.yalamanchili.mapper.BeanMapper;
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
        Contact contact = new Contact();
        contact.setFirstName(ec.getFirstName());
        contact.setLastName(ec.getLastName());
        contact.setSex(ec.getSex());
        //Email

        if (ec.getEmail() != null) {
            Email email = new Email();
            email.setEmail(ec.getEmail());
            email.setPrimaryEmail(Boolean.TRUE);
            contact.addEmail(email);
        }
        //phone
        if (ec.getPhoneNumber() != null) {
            Phone phone = new Phone();
            contact.addPhone(phone);
            phone.setPhoneNumber(ec.getPhoneNumber());
        }
        //contact
        contact = em.merge(contact);
        //emergencycontact
        EmergencyContact emergencyCnt = new EmergencyContact();
        emergencyCnt.setEcPrimary(ec.isEcPrimary());
        emergencyCnt.setRelation(ec.getRelation());
        emergencyCnt.setContact(contact);
        emergencyCnt.setEmployee(emp);
        em.merge(emergencyCnt);
    }

    public info.yalamanchili.office.dto.profile.EmergencyContact update(info.yalamanchili.office.dto.profile.EmergencyContact ec) {
        //TODO implement mapping for contact,phone and email
        EmergencyContact ecEntity = em.find(EmergencyContact.class, ec.getId());
        ecEntity = (EmergencyContact) BeanMapper.merge(ec, ecEntity);
        BeanMapper.merge(ecEntity.getContact(), ec);
        return ec;
    }
}
