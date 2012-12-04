/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.beans.BeanMapper;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anu
 */
@Component
@Scope("request")
public class EmergencyContactService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected ProfileNotificationService profileNotificationService;

    //TODO try to consolidate add and update
    public void addEmergencyContact(Long empId, info.yalamanchili.office.dto.profile.EmergencyContact ec) {
        Employee emp = (Employee) em.find(Employee.class, empId);
        Contact contact = new Contact();
        contact.setFirstName(ec.getFirstName());
        contact.setLastName(ec.getLastName());
        contact.setSex(ec.getSex());
        //Email

        if ((ec.getEmail() != null) && (!ec.getEmail().isEmpty())) {
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
        emergencyCnt.setEcPrimary(ec.getEcPrimary());
        emergencyCnt.setRelation(ec.getRelation());
        emergencyCnt.setContact(contact);
        emergencyCnt.setEmployee(emp);
        em.merge(emergencyCnt);
        profileNotificationService.sendEmergencyContactUpdateNotification(emp);
    }

    public info.yalamanchili.office.dto.profile.EmergencyContact update(info.yalamanchili.office.dto.profile.EmergencyContact ec) {
        //TODO user dozer mapping?
        EmergencyContact ecEntity = em.find(EmergencyContact.class, ec.getId());
        ecEntity = (EmergencyContact) BeanMapper.merge(ec, ecEntity);
        //Contact
        ecEntity.getContact().setFirstName(ec.getFirstName());
        ecEntity.getContact().setLastName(ec.getLastName());
        ecEntity.getContact().setMiddleInitial(ec.getMiddleInitial());
        ecEntity.getContact().setSex(ec.getSex());
        //Email
        if ((ec.getEmail() != null) && (!ec.getEmail().isEmpty())) {
            if (ecEntity.getContact().getEmails().size() > 0) {
                ecEntity.getContact().getEmails().get(0).setEmail(ec.getEmail());
            } else {
                Email email = new Email();
                email.setEmail(ec.getEmail());
                email.setPrimaryEmail(Boolean.TRUE);
                ecEntity.getContact().addEmail(email);
            }
        } else if ((ec.getEmail() == null) || (ec.getEmail().isEmpty())) {
            if (ecEntity.getContact().getEmails().size() > 0) {
                Email email = ecEntity.getContact().getEmails().get(0);
                ecEntity.getContact().getEmails().remove(email);
                em.remove(email);
            }
        }
        //Phone
        if (ecEntity.getContact().getPhones().size() > 0) {
            ecEntity.getContact().getPhones().get(0).setPhoneNumber(ec.getPhoneNumber());
        }
        em.merge(ecEntity);
        profileNotificationService.sendEmergencyContactUpdateNotification(ecEntity.getEmployee());
        return ec;
    }
}
