/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.BeanMapper;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.client.SubcontractorDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
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
        if (ci.getSubcontractor() != null) {
            Subcontractor subcontractor = SubcontractorDao.instance().findById(ci.getSubcontractor().getId());
            ci.setSubcontractor(subcontractor);
        }
        if (ci.getSubcontractorContact() != null) {
            Contact contact = ContactDao.instance().findById(ci.getSubcontractorContact().getId());
            ci.setSubcontractorContact(contact);
        }
        if (ci.getSubcontractorAddress() != null) {
            Address address = AddressDao.instance().findById(ci.getSubcontractorAddress().getId());
            ci.setSubcontractorAddress(address);
        }
        if (ci.isEndPreviousProject()) {
            updatePreviousProjectEndDate(emp, ci);
        }
        emp.addClientInformation(ci);
        startNewClientInfoProcess(ci);
    }

    protected void updatePreviousProjectEndDate(Employee emp, ClientInformation ci) {
        ClientInformation previousClientInformation = null;
        Query query = em.createQuery("from ClientInformation where employee =:emp order by startDate desc");
        query.setParameter("emp", emp);
        if (query.getResultList().size() > 0) {
            previousClientInformation = (ClientInformation) query.getResultList().get(0);
            previousClientInformation.setEndDate(ci.getPreviousProjectEndDate());
            em.merge(previousClientInformation);
        
          }
    }

    @Async
    protected void startNewClientInfoProcess(ClientInformation ci) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("clientInfo", ci);
        vars.put("currentEmployee", SecurityService.instance().getCurrentUser());
        OfficeBPMService.instance().startProcess("new_client_info_process", vars);
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
        if (ci.getSubcontractor() == null) {
            ciEntity.setSubcontractor(null);
        } else {
            Subcontractor subcontractor = SubcontractorDao.instance().findById(ci.getSubcontractor().getId());
            ciEntity.setSubcontractor(subcontractor);
            //Subciontractor contact
            if (ci.getSubcontractorContact() == null) {
                ciEntity.setSubcontractorContact(null);
            } else {
                Contact contact = ContactDao.instance().findById(ci.getSubcontractorContact().getId());
                ciEntity.setSubcontractorContact(contact);
            }
            //Subcontractor location
            if (ci.getSubcontractorAddress() == null) {
                ciEntity.setSubcontractorAddress(null);
            } else {
                Address address = AddressDao.instance().findById(ci.getSubcontractorAddress().getId());
                ciEntity.setSubcontractorAddress(address);
            }
        }
        if (ci.getRecruiter() == null) {
            ciEntity.setRecruiter(null);
        } else {
            Employee recruiter = EmployeeDao.instance().findById(ci.getRecruiter().getId());
            ciEntity.setRecruiter(recruiter);
        }
        ciEntity = clientInformationDao.save(ciEntity);
        return ci;
    }
}
