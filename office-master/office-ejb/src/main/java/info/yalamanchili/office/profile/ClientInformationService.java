/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.BeanMapper;
import info.chili.email.Email;
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.client.ContractService;
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
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.practice.Practice;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationCompany;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.service.ServiceInterceptor;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.Query;
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
    @Autowired
    protected CompanyDao companyDao;

    public void addClientInformation(Long empId, ClientInformationDto ciDto, Boolean submitForApproval) {
        ClientInformation ci = mapper.map(ciDto, ClientInformation.class);
        validate(ci, submitForApproval);
        Client client = null;
        Vendor vendor = null;
        Vendor middleVendor = null;
        Project project = new Project();
        Employee emp = (Employee) em.find(Employee.class, empId);
        String abbreviation = getCompanyAbbreviation(ciDto.getCompany());
        if (abbreviation == null || abbreviation.isEmpty()) {
            abbreviation = "SSTL";
        }
        client = ClientDao.instance().findById(ci.getClient().getId());
        ci.setClient(client);
        if (ci.getClientContact() != null) {
            Contact contact = ContactDao.instance().findById(ci.getClientContact().getId());
            ci.setClientContact(contact);
        }
        if (ci.getClientLocation() != null) {
            Address address = AddressDao.instance().findById(ci.getClientLocation().getId());
            ci.setClientLocation(address);
        }
        ci.setClientAPContacts(null);
        if (ciDto.getClientAPContacts() != null) {
            for (Contact clientAPCnt : ciDto.getClientAPContacts()) {
                if (clientAPCnt.getId() != null) {
                    ci.getClientAPContacts().add(ContactDao.instance().findById(clientAPCnt.getId()));
                }
            }
        }
        if (ci.getVendor() != null) {
            vendor = VendorDao.instance().findById(ci.getVendor().getId());
            ci.setVendor(vendor);
        }
        if (ci.getVendorContact() != null) {
            Contact contact = ContactDao.instance().findById(ci.getVendorContact().getId());
            ci.setVendorContact(contact);
        }
        ci.setVendorAPContacts(null);
        if (ciDto.getVendorAPContacts() != null) {
            for (Contact vendorAPContact : ciDto.getVendorAPContacts()) {
                if (vendorAPContact.getId() != null) {
                    ci.getVendorAPContacts().add(ContactDao.instance().findById(vendorAPContact.getId()));
                }
            }
        }

        if (ci.getVendorLocation() != null) {
            Address address = AddressDao.instance().findById(ci.getVendorLocation().getId());
            ci.setVendorLocation(address);
        }

        ci.setVendorRecruiters(null);
        if (ciDto.getVendorRecruiters() != null) {
            for (Contact vendorRecruiter : ciDto.getVendorRecruiters()) {
                if (vendorRecruiter.getId() != null) {
                    ci.getVendorRecruiters().add(ContactDao.instance().findById(vendorRecruiter.getId()));
                }
            }
        }

        if (ci.getMiddleVendor() != null) {
            middleVendor = VendorDao.instance().findById(ci.getMiddleVendor().getId());
            ci.setMiddleVendor(middleVendor);
        }
        if (ci.getClientProject() != null) {
            project = ProjectDao.instance().findById(ci.getClientProject().getId());
            ci.setClientProject(project);
        }
        ci.setRecruiters(null);
        for (Employee recruiter : ciDto.getRecruiters()) {
            if (recruiter.getId() != null) {
                ci.getRecruiters().add(EmployeeDao.instance().findById(recruiter.getId()));
            }
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
        ci.setClientProject(project);
        if (ci.isIsEndDateConfirmed() != null && ci.isIsEndDateConfirmed() == true) {
            ci.setIsEndDateConfirmed(true);
        } else {
            ci.setIsEndDateConfirmed(false);
        }
        ci = clientInformationDao.save(ci);
        emp.addClientInformation(ci);
        if (submitForApproval) {
            ci.setStatus(ClientInformationStatus.PENDING_INVOICING_BILLING_APPROVAL);
            ci.setBpmProcessId(startNewClientInfoProcess(ci));
        } else {
            ci.setStatus(ClientInformationStatus.PENDING_CONTRACTS_SUBMIT);
        }
    }
//TODO set these values

    protected String getCompanyAbbreviation(ClientInformationCompany company) {
        switch (company) {
            case ACO360:
                return "ACO360";
            case CapMark_Solutions:
                return "CAPM";
            case SSTECH_INC:
                return "SSTI";
            case SSTECH_LLC:
                return "SSTL";
            case SST_Canada:
                return "SSTC";
            case SST_PVT:
                return "SSTP";
            case Techpillars:
                return "TPLR";
            case CGS_INC:
                return "CGSI";
            default:
                return "SSTL";
        }
    }

    protected void updatePreviousProjectEndDate(Employee emp, ClientInformation ci) {
        ClientInformation previousClientInformation = null;
        Query query = em.createQuery("from ClientInformation where employee =:emp order by endDate desc");
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
        Employee emp = ci.getEmployee();
        if (ci.getBillingRates().isEmpty() && ci.getBillingRate() != null) {
            BillingRate firstBillingRate = new BillingRate();
            firstBillingRate.setBillingRate(ci.getBillingRate());
            firstBillingRate.setOverTimeBillingRate(ci.getOverTimeBillingRate());
            firstBillingRate.setBillingInvoiceFrequency(ci.getInvoiceFrequency());
            if (emp.getEmployeeType().getName().equals(EmployeeType.SUBCONTRACTOR)) {
                firstBillingRate.setSubContractorPayRate(ci.getSubcontractorPayRate());
                firstBillingRate.setSubContractorOverTimePayRate(ci.getSubcontractorOvertimePayRate());
                firstBillingRate.setSubContractorInvoiceFrequency(ci.getSubcontractorinvoiceFrequency());
            }
            if (emp.getEmployeeType().getName().equals(EmployeeType._1099_CONTRACTOR)) {
                firstBillingRate.setSubContractorPayRate(ci.getPayRate1099());
                firstBillingRate.setSubContractorOverTimePayRate(ci.getOverTimePayrate1099());
                firstBillingRate.setSubContractorInvoiceFrequency(ci.getInvoiceFrequency1099());
            }
            firstBillingRate.setEffectiveDate(ci.getStartDate());
            firstBillingRate.setClientInformation(ci);
            BillingRateDao.instance().save(firstBillingRate);
        }
        if (billingRate.getBillingRate() != null) {
            ci.setBillingRate(billingRate.getBillingRate());
        }
        if (billingRate.getOverTimeBillingRate() != null) {
            ci.setOverTimeBillingRate(billingRate.getOverTimeBillingRate());
        }
        if (billingRate.getBillingInvoiceFrequency() != null) {
            ci.setInvoiceFrequency(billingRate.getBillingInvoiceFrequency());
        }

        if (emp.getEmployeeType().getName().equals(EmployeeType.SUBCONTRACTOR)) {
            if (billingRate.getSubContractorPayRate() != null) {
                ci.setSubcontractorPayRate(billingRate.getSubContractorPayRate());
            }
            if (billingRate.getSubContractorOverTimePayRate() != null) {
                ci.setSubcontractorOvertimePayRate(billingRate.getSubContractorOverTimePayRate());
            }
            if (billingRate.getSubContractorInvoiceFrequency() != null) {
                ci.setSubcontractorinvoiceFrequency(billingRate.getSubContractorInvoiceFrequency());
            }
        }
        if (emp.getEmployeeType().getName().equals(EmployeeType._1099_CONTRACTOR)) {
            if (billingRate.getSubContractorPayRate() != null) {
                ci.setPayRate1099(billingRate.getSubContractorPayRate());
            }
            if (billingRate.getSubContractorOverTimePayRate() != null) {
                ci.setOverTimePayrate1099(billingRate.getSubContractorOverTimePayRate());
            }
            if (billingRate.getSubContractorInvoiceFrequency() != null) {
                ci.setInvoiceFrequency1099(billingRate.getSubContractorInvoiceFrequency());
            }
        }
        if (billingRate.getEffectiveDate().before(ci.getStartDate())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid Effective Date", "Effective Date can't be before Project Start Date");
        }
        billingRate.setUpdatedBy(OfficeSecurityService.instance().getCurrentUserName());
        billingRate.setUpdatedTs(Calendar.getInstance().getTime());
        billingRate.setClientInformation(ci);
        BillingRateDao.instance().save(billingRate).getId().toString();

    }

    protected void sendBillingRateUpdatedEmail(ClientInformation ci) {
        String[] roles = {OfficeRoles.OfficeRole.ROLE_BILLING_AND_INVOICING.name()};
        Email email = new Email();
        email.setTos(MailUtils.instance().getEmailsAddressesForRoles(roles));
        email.setSubject("Billing rate updated for :" + ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
        String messageText = " Updated Billing rate : ";
        messageText = messageText.concat("Billing Rate :" + ci.getBillingRate());
        messageText = messageText.concat("Pay Rate :" + ci.getPayRate());
        messageText = messageText.concat("Overtime Billing Rate :" + ci.getOverTimeBillingRate());
        messageText = messageText.concat("Overtime Pay Rate :" + ci.getOverTimePayRate());
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }

    protected String startNewClientInfoProcess(ClientInformation ci) {
        Map<String, Object> vars = new HashMap<>();
        vars.put("clientInfo", ci);
        vars.put("entityId", ci.getId());
        vars.put("contractDto", ContractService.instance().mapClientInformation(ci));
        vars.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
        return OfficeBPMService.instance().startProcess("new_client_info_process", vars);
    }

//merge save and addci methods
    public ClientInformation update(ClientInformation ci, Boolean submitForApproval) {
        ClientInformation ciEntity = em.find(ClientInformation.class, ci.getId());
        validate(ci, submitForApproval);
        String abbreviation = getCompanyAbbreviation(ci.getCompany());
        if (!ClientInformationStatus.PENDING_CONTRACTS_SUBMIT.equals(ci.getStatus()) && !submitForApproval) {
            if (ciEntity.getBillingRate() != null) {
                ci.setBillingRate(ciEntity.getBillingRate());
            }
            if (ciEntity.getOverTimeBillingRate() != null) {
                ci.setOverTimeBillingRate(ciEntity.getOverTimeBillingRate());
            }
            Employee emp = ciEntity.getEmployee();
            if (emp.getEmployeeType().getName().equals(EmployeeType.SUBCONTRACTOR)) {
                if (ciEntity.getSubcontractorPayRate() != null) {
                    ci.setSubcontractorPayRate(ciEntity.getSubcontractorPayRate());
                }
                if (ciEntity.getSubcontractorOvertimePayRate() != null) {
                    ci.setSubcontractorOvertimePayRate(ciEntity.getSubcontractorOvertimePayRate());
                }

            }
            if (emp.getEmployeeType().getName().equals(EmployeeType._1099_CONTRACTOR)) {
                if (ciEntity.getPayRate1099() != null) {
                    ci.setPayRate1099(ciEntity.getPayRate1099());
                }
                if (ciEntity.getOverTimePayrate1099() != null) {
                    ci.setOverTimePayrate1099(ciEntity.getOverTimePayrate1099());
                }

            }
        }
        BeanMapper.merge(ci, ciEntity);
        Project project = ProjectDao.instance().findById(ci.getClientProject().getId());
        Client client;
        Vendor vendor = null;
        Vendor middleVendor = null;
        ciEntity.setClient(null);
        client = ClientDao.instance().findById(ci.getClient().getId());
        ciEntity.setClient(client);
        project.setName(abbreviation + "PR" + projectName(client.getName()));
        project.setName(project.getName() + project.getId().toString());
        if (ci.isIsEndDateConfirmed() == true) {
            ciEntity.setIsEndDateConfirmed(true);
        } else {
            ciEntity.setIsEndDateConfirmed(false);
        }
        //Client Contact
        if (ci.getClientContact() == null) {
            ciEntity.setClientContact(null);
        } else {
            Contact contact = ContactDao.instance().findById(ci.getClientContact().getId());
            ciEntity.setClientContact(contact);
        }
        //Client Acct Pay Contact
        Set<Contact> newClientAPs = new HashSet();
        for (Contact con : ci.getClientAPContacts()) {
            if (con.getId() != null) {
                newClientAPs.add(ContactDao.instance().findById(con.getId()));
            }
        }
        ciEntity.setClientAPContacts(newClientAPs);
        //Client Location
        if (ci.getClientLocation() == null) {
            ciEntity.setClientLocation(null);
        } else {
            Address address = AddressDao.instance().findById(ci.getClientLocation().getId());
            ciEntity.setClientLocation(address);
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
            Set<Contact> newAPs = new HashSet();
            for (Contact con : ci.getVendorAPContacts()) {
                if (con.getId() != null) {
                    newAPs.add(ContactDao.instance().findById(con.getId()));
                }
            }
            ciEntity.setVendorAPContacts(newAPs);
            //Vendor Recruiter
            Set<Contact> venRecs = new HashSet();
            for (Contact con : ci.getVendorRecruiters()) {
                if (con.getId() != null) {
                    venRecs.add(ContactDao.instance().findById(con.getId()));
                }
            }
            ciEntity.setVendorRecruiters(venRecs);
            //Vendor Location
            if (ci.getVendorLocation() == null) {
                ciEntity.setVendorLocation(null);
            } else {
                Address address = AddressDao.instance().findById(ci.getVendorLocation().getId());
                ciEntity.setVendorLocation(address);
            }
        }
        if (ci.getEndDate() != null) {
            ciEntity.setEndDate(ci.getEndDate());
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
        Set<Employee> newRecs = new HashSet();
        for (Employee rec : ci.getRecruiters()) {
            if (rec.getId() != null) {
                newRecs.add(EmployeeDao.instance().findById(rec.getId()));
            }
        }
        ciEntity.setRecruiters(newRecs);
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
        if (ci.getMiddleVendor() != null) {
            middleVendor = VendorDao.instance().findById(ci.getMiddleVendor().getId());
            ciEntity.setMiddleVendor(middleVendor);
        }
        if (middleVendor != null) {
            project.setMiddleVendor(middleVendor);
            VendorDao.instance().save(middleVendor);
        }
        project.setClient(client);
        ClientDao.instance().save(client);
        project = ProjectDao.instance().save(project);
        ciEntity.setClientProject(project);
        ciEntity = clientInformationDao.save(ciEntity);
        if (ClientInformationStatus.PENDING_CONTRACTS_SUBMIT.equals(ci.getStatus()) && submitForApproval) {
            ciEntity.setStatus(ClientInformationStatus.PENDING_INVOICING_BILLING_APPROVAL);
            ci.setBpmProcessId(startNewClientInfoProcess(ci));
        }
        em.flush();
        ContractService.instance().sendClientinfoUpdatedEmail(ciEntity);
        return ci;
    }

    protected void validate(ClientInformation ci, Boolean submitForApproval) {
        if (submitForApproval) {
            ServiceInterceptor.instance().validateInput(ci, ClientInformation.SubmitChecks.class);
        }
    }

    private String projectName(String name) {
        String S = name.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = S.split("\\s+");
        String acronym = "";
        String newname = "";
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w!?&,]", "");
            acronym += words[i].substring(0, 1);
            newname += words[i];
        }

        if (acronym.length() >= 4) {
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
