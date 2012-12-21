/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.beans.BeanMapper;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import info.yalamanchili.office.entity.profile.Employee;
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
    protected ProfileNotificationService ProfileNotificationService;
    @Autowired
    protected ClientInformationDao clientInformationDao;

    public void addClientInformation(Long empId, ClientInformation ci) {
        Employee emp = (Employee) em.find(Employee.class, empId);
        if (ci.getClient() != null) {
            Client client = ClientDao.instance().findById(ci.getClient().getId());
            ci.setClient(client);
        }
        if (ci.getClientContact() != null) {
            Contact contact = ContactDao.instance().findById(ci.getClientContact().getId());
            ci.setClientContact(contact);
        }
        if (ci.getClientLocation() != null) {
            Address address = AddressDao.instance().findById(ci.getClientLocation().getId());
            ci.setClientLocation(address);
        }
        emp.addClientInformation(ci);
        ProfileNotificationService.sendClientInformationUpdatedNotification(emp);
    }

    public ClientInformation update(ClientInformation ci) {
        //TODO implement mapping for contact,phone and email
        ClientInformation ciEntity = em.find(ClientInformation.class, ci.getId());
        ciEntity = (ClientInformation) BeanMapper.merge(ci, ciEntity);
        //Contact
//        ciEntity.getContact().setFirstName(ci.getFirstName());
//        ciEntity.getContact().setLastName(ci.getLastName());
//        ciEntity.getContact().setMiddleInitial(ci.getMiddleInitial());
//        ciEntity.getContact().setSex(ci.getSex());
        //Email
//        if (ciEntity.getContact().getEmails().size() > 0) {
//            ciEntity.getContact().getEmails().get(0).setEmail(ci.getEmail());
//        }
//        //Phone
//        if (ciEntity.getContact().getPhones().size() > 0) {
//            ciEntity.getContact().getPhones().get(0).setPhoneNumber(ci.getPhoneNumber());
//            ciEntity.getContact().getPhones().get(0).setCountryCode(ci.getCountryCode());
//            ciEntity.getContact().getPhones().get(0).setExtension(ci.getExtension());
//        }
        em.merge(ciEntity);
        ProfileNotificationService.sendClientInformationUpdatedNotification(ciEntity.getEmployee());
        return ci;
    }
}
