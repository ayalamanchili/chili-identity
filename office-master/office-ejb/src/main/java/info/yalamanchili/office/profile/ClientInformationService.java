/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;


import info.chili.beans.BeanMapper;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import javax.persistence.EntityManager;
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
public class ClientInformationService {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected ProfileNotificationService  ProfileNotificationService;


    public void addClientInformation(Long empId, info.yalamanchili.office.dto.profile.ClientInformation clientInformation) {
        Employee emp = (Employee) em.find(Employee.class, empId);
        Contact contact = new Contact();
        contact.setFirstName(clientInformation.getFirstName());
        contact.setLastName(clientInformation.getLastName());
        contact.setSex(clientInformation.getSex());
        //Email

        if (clientInformation.getEmail() != null) {
            Email email = new Email();
            email.setEmail(clientInformation.getEmail());
            email.setPrimaryEmail(Boolean.TRUE);
            contact.addEmail(email);
        }
        //phone
        if (clientInformation.getPhoneNumber() != null) {
            Phone phone = new Phone();
            contact.addPhone(phone);
            phone.setPhoneNumber(clientInformation.getPhoneNumber());
        }
        //contact
        contact = em.merge(contact);

        ClientInformation entity = new ClientInformation();
        entity.setReportsToRole(clientInformation.getReportsToRole());
        entity.setConsultantJobTitle(clientInformation.getConsultantJobTitle());
        entity.setRtPrimary(clientInformation.isRtPrimary());
        entity.setContact(contact);
        entity.setEmployee(emp);
        em.merge(entity);
        ProfileNotificationService.sendClientInformationUpdatedNotification(emp);
    }

    public info.yalamanchili.office.dto.profile.ClientInformation update(info.yalamanchili.office.dto.profile.ClientInformation ci) {
        //TODO implement mapping for contact,phone and email
        ClientInformation ciEntity = em.find(ClientInformation.class, ci.getId());
        ciEntity = (ClientInformation) BeanMapper.merge(ci, ciEntity);
                //Contact
        ciEntity.getContact().setFirstName(ci.getFirstName());
        ciEntity.getContact().setLastName(ci.getLastName());
        ciEntity.getContact().setMiddleInitial(ci.getMiddleInitial());
        ciEntity.getContact().setSex(ci.getSex());
        //Email
        if (ciEntity.getContact().getEmails().size() > 0) {
            ciEntity.getContact().getEmails().get(0).setEmail(ci.getEmail());
        }
        //Phone
        if (ciEntity.getContact().getPhones().size() > 0) {
            ciEntity.getContact().getPhones().get(0).setPhoneNumber(ci.getPhoneNumber());
        }
        em.merge(ciEntity);
        ProfileNotificationService.sendClientInformationUpdatedNotification(ciEntity.getEmployee());
        return ci;
    }
}
