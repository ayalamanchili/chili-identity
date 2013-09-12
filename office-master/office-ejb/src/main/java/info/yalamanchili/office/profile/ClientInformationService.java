/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.BeanMapper;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Vendor;
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
        if (ci.getVendor() != null) {
            Vendor vendor = VendorDao.instance().findById(ci.getVendor().getId());
            ci.setVendor(vendor);
        }
        if (ci.getVendorContact() != null) {
            Contact contact = ContactDao.instance().findById(ci.getVendorContact().getId());
            ci.setVendorContact(contact);
        }
        if (ci.getVendorLocation() != null) {
            Address address = AddressDao.instance().findById(ci.getVendorLocation().getId());
            ci.setVendorLocation(address);
        }
        if (ci.getRecruiter() != null) {
            Employee recruiter = EmployeeDao.instance().findById(ci.getRecruiter().getId());
            ci.setRecruiter(recruiter);
        }
        emp.addClientInformation(ci);
        ProfileNotificationService.sendClientInformationUpdatedNotification(emp);
    }

//merge save and addci methods
    public ClientInformation update(ClientInformation ci) {
        //TODO implement mapping for contact,phone and email
        ClientInformation ciEntity = em.find(ClientInformation.class, ci.getId());
        BeanMapper.merge(ci, ciEntity);
        if (ci.getClient() == null) {
            ciEntity.setClient(null);
        } else {
            Client client = ClientDao.instance().findById(ci.getClient().getId());
            ciEntity.setClient(client);
            //Client Contact
            if (ci.getClientContact() == null) {
                ciEntity.setClientContact(null);
            } else {
                Contact contact = ContactDao.instance().findById(ci.getClientContact().getId());
                ciEntity.setClientContact(contact);
            }
            //Client Location
            if (ci.getClientLocation() == null) {
                ciEntity.setClientLocation(null);
            } else {
                Address address = AddressDao.instance().findById(ci.getClientLocation().getId());
                ciEntity.setClientLocation(address);
            }
        }
        if (ci.getVendor() == null) {
            ciEntity.setVendor(null);
        } else {
            Vendor vendor = VendorDao.instance().findById(ci.getVendor().getId());
            ciEntity.setVendor(vendor);
            //Client Contact
            if (ci.getVendorContact() == null) {
                ciEntity.setVendorContact(null);
            } else {
                Contact contact = ContactDao.instance().findById(ci.getVendorContact().getId());
                ciEntity.setVendorContact(contact);
            }
            //Client Location
            if (ci.getVendorLocation() == null) {
                ciEntity.setVendorLocation(null);
            } else {
                Address address = AddressDao.instance().findById(ci.getVendorLocation().getId());
                ciEntity.setVendorLocation(address);
            }
        }
        if (ci.getRecruiter() == null) {
            ciEntity.setRecruiter(null);
        } else {
            Employee recruiter = EmployeeDao.instance().findById(ci.getRecruiter().getId());
            ciEntity.setRecruiter(recruiter);
        }
        ciEntity = clientInformationDao.save(ciEntity);
        ProfileNotificationService.sendClientInformationUpdatedNotification(ciEntity.getEmployee());
        return ci;
    }
}
