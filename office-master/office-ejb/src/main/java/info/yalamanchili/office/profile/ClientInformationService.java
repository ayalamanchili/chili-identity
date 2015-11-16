/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.BeanMapper;
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.client.ProjectDao;
import info.yalamanchili.office.dao.client.SubcontractorDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.practice.PracticeDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.BillingRateDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.profile.ClientInformationDto;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.practice.Practice;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import info.yalamanchili.office.entity.profile.Employee;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    protected CompanyDao companyDao;

    public void addClientInformation(Long empId, ClientInformationDto ciDto) {
        ClientInformation ci = mapper.map(ciDto, ClientInformation.class);

        Client client = null;
        Vendor vendor = null;
        Vendor middleVendor = null;
        Company company = null;
        Project project = new Project();
        String abbreviation = "";
        Employee emp = (Employee) em.find(Employee.class, empId);

        if (ciDto.getCompany() != null) {
            company = companyDao.findById(ciDto.getCompany().getId());
            emp.setCompany(company);
            emp = EmployeeDao.instance().save(emp);
            abbreviation = company.getAbbreviation();
        } else {
            company = emp.getCompany();
            if (company != null) {
                abbreviation = company.getAbbreviation();
            } else {
                abbreviation = "SSTL";
            }
        }

        if (abbreviation == null || abbreviation.isEmpty()) {
            abbreviation = "SSTL";
        }

        if (ci.getClient() != null) {
            client = ClientDao.instance().findById(ci.getClient().getId());
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
            vendor = VendorDao.instance().findById(ci.getVendor().getId());
            ci.setVendor(vendor);
        }
        if (ci.getVendorContact() != null) {
            Contact contact = ContactDao.instance().findById(ci.getVendorContact().getId());
            ci.setVendorContact(contact);
        }
        if (ci.getVendorAPContact() != null) {
            Contact contact = ContactDao.instance().findById(ci.getVendorAPContact().getId());
            ci.setVendorAPContact(contact);
        }
        if (ci.getVendorLocation() != null) {
            Address address = AddressDao.instance().findById(ci.getVendorLocation().getId());
            ci.setVendorLocation(address);
        }
        if (ci.getVendorRecruiter() != null) {
            Contact contact = ContactDao.instance().findById(ci.getVendorRecruiter().getId());
            ci.setVendorRecruiter(contact);
        }
        if (ci.getMiddleVendor() != null) {
            middleVendor = VendorDao.instance().findById(ci.getMiddleVendor().getId());
            ci.setMiddleVendor(middleVendor);
        }
        if (ci.getClientProject() != null) {
            project = ProjectDao.instance().findById(ci.getClientProject().getId());
            ci.setClientProject(project);
        }

        if (ci.getRecruiter() != null) {
            Employee recruiter = EmployeeDao.instance().findById(ci.getRecruiter().getId());
            ci.setRecruiter(recruiter);
        }
        if (ci.getSubcontractor() != null) {
            Subcontractor subcontractor = SubcontractorDao.instance().findById(ci.getSubcontractor().getId());
            ci.setSubcontractor(subcontractor);
            project.setSubContractorWorkOrderNo(abbreviation + "WO" + projectName(subcontractor.getName()));
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
        if (vendor != null) {
            project.setVendor(vendor);
            client.getVendors().add(vendor);
            vendor.getClients().add(client);
            project.setPurchaseOrderNo(abbreviation + "PO" + projectName(vendor.getName()));
            VendorDao.instance().save(vendor);
        }
        if (middleVendor != null) {
            project.setMiddleVendor(middleVendor);
            VendorDao.instance().save(middleVendor);
//            middleVendor.getClients().add(client);
        }
        if (ci.getEndDate() != null) {
            project.setEndDate(ci.getEndDate());
        }

        if (ci.getPractice() != null) {
            Practice practice = PracticeDao.instance().findById(ci.getPractice().getId());
            ci.setPractice(practice);
        }

        project.setStartDate(ci.getStartDate());
        project.setClient(client);
        project.setName(abbreviation + "PR" + projectName(client.getName()));
        project = ProjectDao.instance().save(project);
        ClientDao.instance().save(client);
        project.setName(project.getName() + project.getId().toString());
        if (vendor != null) {
            project.setPurchaseOrderNo(project.getPurchaseOrderNo() + project.getId().toString());
        }
        if (ci.getSubcontractor() != null) {
            project.setSubContractorWorkOrderNo(project.getSubContractorWorkOrderNo() + project.getId().toString());
        }
        project = ProjectDao.instance().save(project);
        ci.setStatus(ClientInformationStatus.PENDING_ACCOUNTS_VERIFICATION);
        ci.setClientProject(project);
        ci = clientInformationDao.save(ci);
        emp.addClientInformation(ci);
       // startNewClientInfoProcess(ci);
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

    /**
     * Method used to update billing rate info on a client info to track changes
     * with effective date
     *
     * @param clientInfoId
     * @param billingRate
     */
    public void updateBillingRate(Long clientInfoId, BillingRate billingRate) {
        ClientInformation ci = ClientInformationDao.instance().findById(clientInfoId);
        //Track the first change
        if (ci.getBillingRates().isEmpty() && ci.getBillingRate() != null) {
            BillingRate firstBillingRate = new BillingRate();
            firstBillingRate.setBillingRate(ci.getBillingRate());
            firstBillingRate.setPayRate(ci.getPayRate());
            firstBillingRate.setOverTimeBillingRate(ci.getOverTimeBillingRate());
            firstBillingRate.setOverTimePayRate(ci.getOverTimePayRate());
            firstBillingRate.setEffectiveDate(ci.getStartDate());
            firstBillingRate.setClientInformation(ci);
            BillingRateDao.instance().save(firstBillingRate);
        }
        ci.setBillingRate(billingRate.getBillingRate());
        ci.setPayRate(billingRate.getPayRate());
        ci.setOverTimeBillingRate(billingRate.getOverTimeBillingRate());
        ci.setOverTimePayRate(billingRate.getOverTimePayRate());
        if (billingRate.getEffectiveDate().before(ci.getStartDate())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid Effective Date", "Effective Date can't be before Project Start Date");
        }
        billingRate.setClientInformation(ci);
        BillingRateDao.instance().save(billingRate).getId().toString();
    }

    @Async
    protected void startNewClientInfoProcess(ClientInformation ci) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("clientInfo", ci);
        vars.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
        OfficeBPMService.instance().startProcess("new_client_info_process", vars);
    }

//merge save and addci methods
    public ClientInformation update(ClientInformation ci) {
        //TODO implement mapping for contact,phone and email
        ClientInformation ciEntity = em.find(ClientInformation.class, ci.getId());
        Employee emp = ciEntity.getEmployee();
        Company company = emp.getCompany();
        String abbreviation = "";
        if (company != null) {
            abbreviation = company.getAbbreviation();
        } else {
            abbreviation = "SSTL";
        }
        if (abbreviation == null || abbreviation.isEmpty()) {
            abbreviation = "SSTL";
        }
        BeanMapper.merge(ci, ciEntity);
        Project project = ProjectDao.instance().findById(ci.getClientProject().getId());
        Client client = null;
        Vendor vendor = null;
        Vendor middleVendor = null;

        if (ci.getClient() == null) {
            ciEntity.setClient(null);
        } else {
            client = ClientDao.instance().findById(ci.getClient().getId());
            ciEntity.setClient(client);
            project.setName(abbreviation + "PR" + projectName(client.getName()));
            project.setName(project.getName() + project.getId().toString());
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
            vendor = VendorDao.instance().findById(ci.getVendor().getId());
            ciEntity.setVendor(vendor);
            project.setPurchaseOrderNo(abbreviation + "PO" + projectName(vendor.getName()));
            project.setPurchaseOrderNo(project.getPurchaseOrderNo() + project.getId().toString());
            //Vendor Contact
            if (ci.getVendorContact() == null) {
                ciEntity.setVendorContact(null);
            } else {
                Contact contact = ContactDao.instance().findById(ci.getVendorContact().getId());
                ciEntity.setVendorContact(contact);
            }
            //Vendor Acct Pay Contact
            if (ci.getVendorAPContact() == null) {
                ciEntity.setVendorAPContact(null);
            } else {
                Contact contact = ContactDao.instance().findById(ci.getVendorAPContact().getId());
                ciEntity.setVendorAPContact(contact);
            }
            //Vendor Location
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
            project.setSubContractorWorkOrderNo(abbreviation + "WO" + projectName(subcontractor.getName()));
            project.setSubContractorWorkOrderNo(project.getSubContractorWorkOrderNo() + project.getId().toString());
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

        if (ci.getPractice() != null) {
            Practice practice = PracticeDao.instance().findById(ci.getPractice().getId());
            ciEntity.setPractice(practice);
        }

        if (vendor != null) {
            project.setVendor(vendor);
            client.getVendors().add(vendor);
            vendor.getClients().add(client);
            VendorDao.instance().save(vendor);
        }
        if (middleVendor != null) {
            project.setMiddleVendor(middleVendor);
            VendorDao.instance().save(middleVendor);
        }
        if (client != null) {
            project.setClient(client);
            ClientDao.instance().save(client);
        }

        project = ProjectDao.instance().save(project);
        ci.setClientProject(project);
        ciEntity = clientInformationDao.save(ciEntity);
        return ci;
    }

    private String projectName(String name) {
        String[] words = name.split("\\s+");
        String acronym = "";
        String newname = "";
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w!?&,]", "");
            acronym += words[i].substring(0, 1);
            newname += words[i];
        }

        if (acronym.length() > 4) {
            acronym = acronym.substring(0, 4);
        } else if (name.length() <= 3) {
            acronym = name.substring(0, name.length());
        } else {
            acronym = newname.substring(0, 4);
        }

        Format formatter = new SimpleDateFormat("MMYY");
        Date todayDate = new Date();
        String MMYY = formatter.format(todayDate);

        String projectName = "-" + acronym + "-" + "TS" + MMYY + "-";
        return projectName.toUpperCase();
    }
}
