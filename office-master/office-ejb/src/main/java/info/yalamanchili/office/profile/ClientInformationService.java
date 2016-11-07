/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import com.google.common.base.Strings;
import info.chili.commons.BeanMapper;
import info.chili.email.Email;
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.client.ContractService;
import info.yalamanchili.office.dao.client.ClientDao;
import info.yalamanchili.office.dao.client.ProjectDao;
import info.yalamanchili.office.dao.client.SubcontractorDao;
import info.yalamanchili.office.dao.client.VendorDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.hr.ClientInfoHandleEntityDao;
import info.yalamanchili.office.dao.hr.ProspectDao;
import info.yalamanchili.office.dao.practice.PracticeDao;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.dao.profile.BillingRateDao;
import info.yalamanchili.office.dao.profile.CiDocumentDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.CompanyDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.profile.ClientInformationDto;
import info.yalamanchili.office.dto.profile.ClientInformationSaveDto;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.hr.ProspectStatus;
import info.yalamanchili.office.entity.profile.BillingRate;
import info.yalamanchili.office.entity.profile.CIDocument;
import info.yalamanchili.office.entity.profile.ClientInfoHandleEntity;
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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    @Autowired
    protected ClientDao clientDao;

    @Autowired
    protected VendorDao vendorDao;

    public ClientInformationDto addClientInformation(Long empId, ClientInformationDto ciDto, Boolean submitForApproval, Long sourceId, String sourceName) {
        ClientInformation ci = mapper.map(ciDto, ClientInformation.class);

        Client client = null;
        Vendor vendor = null;
        Vendor middleVendor = null;
        Project project = new Project();
        Employee emp = null;
        if (empId != null) {
            emp = (Employee) em.find(Employee.class, empId);
            validate(ci, emp, submitForApproval);
        }
        String abbreviation = getCompanyAbbreviation(ciDto.getCompany());
        if (abbreviation == null || abbreviation.isEmpty()) {
            abbreviation = "SSTL";
        }
        client = clientDao.findById(ci.getClient().getId());
        ci.setClient(client);

        if (ci.getClientContact() != null) {
            ci.setClientContact(ContactDao.instance().findById(ci.getClientContact().getId()));
        }
        if (ci.getClientLocation() != null) {
            ci.setClientLocation(AddressDao.instance().findById(ci.getClientLocation().getId()));
        }
        ci.setClientAPContacts(null);
        for (Contact clientAPCnt : ciDto.getClientAPContacts()) {
            if (clientAPCnt.getId() != null) {
                ci.getClientAPContacts().add(ContactDao.instance().findById(clientAPCnt.getId()));
            }
        }
        if (ci.getVendor() != null) {
            vendor = vendorDao.findById(ci.getVendor().getId());
            ci.setVendor(vendor);
        }
        if (ci.getVendorContact() != null) {
            ci.setVendorContact(ContactDao.instance().findById(ci.getVendorContact().getId()));
        }
        ci.setVendorAPContacts(null);
        for (Contact vendorAPContact : ciDto.getVendorAPContacts()) {
            if (vendorAPContact.getId() != null) {
                ci.getVendorAPContacts().add(ContactDao.instance().findById(vendorAPContact.getId()));
            }
        }
        if (ci.getVendorLocation() != null) {
            ci.setVendorLocation(AddressDao.instance().findById(ci.getVendorLocation().getId()));
        }
        ci.setVendorRecruiters(null);
        for (Contact vendorRecruiter : ciDto.getVendorRecruiters()) {
            if (vendorRecruiter.getId() != null) {
                ci.getVendorRecruiters().add(ContactDao.instance().findById(vendorRecruiter.getId()));
            }
        }
        if (ci.getMiddleVendor() != null) {
            middleVendor = vendorDao.findById(ci.getMiddleVendor().getId());
            ci.setMiddleVendor(middleVendor);
        }
        ProjectDao projectDao = ProjectDao.instance();
        if (ci.getClientProject() != null) {
            project = projectDao.findById(ci.getClientProject().getId());
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
            ci.setSubcontractorContact(ContactDao.instance().findById(ci.getSubcontractorContact().getId()));
        }
        if (ci.getSubcontractorAddress() != null) {
            ci.setSubcontractorAddress(AddressDao.instance().findById(ci.getSubcontractorAddress().getId()));
        }
        if (vendor != null) {
            project.setVendor(vendor);
            client.getVendors().add(vendor);
            vendor.getClients().add(client);
            project.setPurchaseOrderNo(abbreviation + "PO" + projectName(vendor.getName()));
            vendorDao.save(vendor);
        }
        if (middleVendor != null) {
            project.setMiddleVendor(middleVendor);
            vendorDao.save(middleVendor);
        }
        if (ci.getEndDate() != null) {
            project.setEndDate(ci.getEndDate());
        }

        if (ci.getPractice() != null) {
            ci.setPractice(PracticeDao.instance().findById(ci.getPractice().getId()));
        }
        project.setStartDate(ci.getStartDate());
        project.setClient(client);
        project.setName(abbreviation + "PR" + projectName(client.getName()));
        project = projectDao.save(project);
        clientDao.save(client);
        project.setName(project.getName() + project.getId().toString());
        if (vendor != null) {
            project.setPurchaseOrderNo(project.getPurchaseOrderNo() + project.getId().toString());
        }
        if (ci.getSubcontractor() != null) {
            project.setSubContractorWorkOrderNo(project.getSubContractorWorkOrderNo() + project.getId().toString());
        }
        project = projectDao.save(project);
        ci.setClientProject(project);
        if (ci.isIsEndDateConfirmed() != null && ci.isIsEndDateConfirmed() == true) {
            ci.setIsEndDateConfirmed(true);
        } else {
            ci.setIsEndDateConfirmed(false);
        }
        //cidocument
        for (CIDocument doc : ci.getCidocument()) {
            if (!Strings.isNullOrEmpty(doc.getFileURL())) {
                doc.setClientInformation(ci);
            }
        }
        ci = clientInformationDao.save(ci);
        if (emp != null) {
            emp.addClientInformation(ci);
        }
        if (!Strings.isNullOrEmpty(sourceName)) {
            ClientInfoHandleEntity cpd = new ClientInfoHandleEntity();
            cpd.setSourceEntityId(sourceId);
            cpd.setSourceEntityName(sourceName);
            cpd.setTargetEntityId(ci.getId());
            cpd.setTargetEntityName(ClientInformation.class.getCanonicalName());
            ClientInfoHandleEntityDao.instance().save(cpd);
        }
        if (ciDto.getReason() != null) {
            CommentDao.instance().addComment("End Previous Project Reason: " + ciDto.getReason(), ci);
        }
        if (submitForApproval) {
            ci.setStatus(ClientInformationStatus.PENDING_CONTRACTS_VALIDATION);
            ci.setBpmProcessId(ClientInformationProcessBean.instance().startNewClientInfoProcess(ci, OfficeSecurityService.instance().getCurrentUser()));
        } else {
            ci.setStatus(ClientInformationStatus.PENDING_CONTRACTS_SUBMIT);
        }
        ciDto.setId(ci.getId());
        ci.setActive(Boolean.TRUE);
        ciDto.setCidocument(ci.getCidocument());
        return ciDto;
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

    public ClientInformationDto read(Long id) {
        return mapper.map(clientInformationDao.findById(id), ClientInformationDto.class);
    }

    public ClientInformationDto readCIForInvoice(Long id) {
        String queryStr = "SELECT NEW " + ClientInformationDto.class.getCanonicalName() + "(ci.id,ci.itemNumber,ci.billingRate,ci.overTimeBillingRate,ci.invoiceFrequency) from " + ClientInformation.class.getCanonicalName() + " ci where ci.id=:idParam";
        TypedQuery<ClientInformationDto> query = em.createQuery(queryStr, ClientInformationDto.class);
        query.setParameter("idParam", id);
        ClientInformationDto dto = query.getSingleResult();
        if (ContractService.instance().getEffectiveBillingRate(dto.getId()) != null) {
            dto.setBillingRate(ContractService.instance().getEffectiveBillingRate(dto.getId()));
        }
        return dto;
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
        Employee updatedByEmp = OfficeSecurityService.instance().getCurrentUser();
        billingRate.setUpdatedBy(updatedByEmp.getFirstName() + " " + updatedByEmp.getLastName());
        billingRate.setUpdatedTs(Calendar.getInstance().getTime());
        billingRate.setClientInformation(ci);
        BillingRateDao.instance().save(billingRate).getId().toString();
        ContractService.instance().sendBillingRateUpdatedEmail(ci, billingRate.getEffectiveDate(), billingRate.getUpdatedBy());
    }

    //merge save and addci methods
    public ClientInformationSaveDto update(ClientInformationSaveDto dto, Boolean submitForApproval) {
        ClientInformation ci = mapper.map(dto, ClientInformation.class);
        ClientInformation ciEntity = em.find(ClientInformation.class, ci.getId());
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
        validate(ci, ci.getEmployee(), submitForApproval);
        BeanMapper.merge(ci, ciEntity);
        Project project = ProjectDao.instance().findById(ci.getClientProject().getId());
        Client client;
        Vendor vendor = null;
        Vendor middleVendor = null;
        ciEntity.setClient(null);
        client = clientDao.findById(ci.getClient().getId());
        ciEntity.setClient(client);
        project.setName(abbreviation + "PR" + projectName(client.getName()));
        project.setName(project.getName() + project.getId().toString());
        ciEntity.setIsEndDateConfirmed((Objects.equals(Boolean.TRUE, ci.isIsEndDateConfirmed())));
        //Client Contact
        if (ci.getClientContact() == null) {
            ciEntity.setClientContact(null);
        } else {
            ciEntity.setClientContact(ContactDao.instance().findById(ci.getClientContact().getId()));
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
            ciEntity.setClientLocation(AddressDao.instance().findById(ci.getClientLocation().getId()));
        }
        if (ci.getVendor() == null) {
            ciEntity.setVendor(null);
        } else {
            vendor = vendorDao.findById(ci.getVendor().getId());
            ciEntity.setVendor(vendor);
            project.setPurchaseOrderNo(abbreviation + "PO" + projectName(vendor.getName()));
            project.setPurchaseOrderNo(project.getPurchaseOrderNo() + project.getId().toString());
            //Vendor Contact
            if (ci.getVendorContact() == null) {
                ciEntity.setVendorContact(null);
            } else {
                ciEntity.setVendorContact(ContactDao.instance().findById(ci.getVendorContact().getId()));
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
                ciEntity.setVendorLocation(AddressDao.instance().findById(ci.getVendorLocation().getId()));
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
                ciEntity.setSubcontractorContact(ContactDao.instance().findById(ci.getSubcontractorContact().getId()));
            }
            //Subcontractor location
            if (ci.getSubcontractorAddress() == null) {
                ciEntity.setSubcontractorAddress(null);
            } else {
                ciEntity.setSubcontractorAddress(AddressDao.instance().findById(ci.getSubcontractorAddress().getId()));
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
            ciEntity.setPractice(PracticeDao.instance().findById(ci.getPractice().getId()));
        }
        if (vendor != null) {
            project.setVendor(vendor);
            client.getVendors().add(vendor);
            vendor.getClients().add(client);
            vendorDao.save(vendor);
        }
        if (ci.getMiddleVendor() != null) {
            middleVendor = vendorDao.findById(ci.getMiddleVendor().getId());
            ciEntity.setMiddleVendor(middleVendor);
        }
        if (middleVendor != null) {
            project.setMiddleVendor(middleVendor);
            vendorDao.save(middleVendor);
        }
        project.setClient(client);

        for (CIDocument document : ci.getCidocument()) {
            if (document.getId() == null) {
                document.setClientInformation(ciEntity);
                ciEntity = clientInformationDao.getEntityManager().merge(ciEntity);
                ciEntity.getCidocument().add(document);
            } else {
                CiDocumentDao.instance().save(document);
            }
        }
        clientDao.save(client);
        project = ProjectDao.instance().save(project);
        ciEntity.setClientProject(project);
        ciEntity.setActive(dto.getActive());
        ciEntity = clientInformationDao.save(ciEntity);
        if (ClientInformationStatus.CANCELED.equals(ci.getStatus())) {
            ciEntity.setStatus(ClientInformationStatus.PENDING_CONTRACTS_VALIDATION);
            ci.setBpmProcessId(ClientInformationProcessBean.instance().startNewClientInfoProcess(ciEntity, OfficeSecurityService.instance().getCurrentUser()));
        }
        if (ClientInformationStatus.PENDING_CONTRACTS_SUBMIT.equals(ci.getStatus()) && submitForApproval) {
            ciEntity.setStatus(ClientInformationStatus.PENDING_CONTRACTS_VALIDATION);
            ci.setBpmProcessId(ClientInformationProcessBean.instance().startNewClientInfoProcess(ciEntity, OfficeSecurityService.instance().getCurrentUser()));
        }
        em.flush();
        ci = em.find(ClientInformation.class, ci.getId());
        return mapper.map(ci, ClientInformationSaveDto.class);
    }

    protected void validate(ClientInformation ci, Employee emp, Boolean submitForApproval) {
        if (emp.getEmployeeType().getName().equals(EmployeeType.SUBCONTRACTOR)) {
            ServiceInterceptor.instance().validateInput(ci, ClientInformation.SubcontractorChecks.class);
        }
        Vendor vendor = vendorDao.findById(ci.getVendor().getId());
        String vName = vendor.getName();
        if ("NA".equals(vName)) {
            ServiceInterceptor.instance().validateInput(ci, ClientInformation.VendorChecks.class);
        }
        if (submitForApproval) {
            ServiceInterceptor.instance().validateInput(ci, ClientInformation.SubmitChecks.class);
        }
        if (ci.getStatus() != null && !ClientInformationStatus.PENDING_CONTRACTS_SUBMIT.equals(ci.getStatus()) && !submitForApproval) {
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
        } else if (newname.length() <= 3) {
            acronym = newname.substring(0, newname.length());
        } else {
            acronym = newname.substring(0, 4);
        }

        Format formatter = new SimpleDateFormat("MMYY");
        Date todayDate = new Date();
        String MMYY = formatter.format(todayDate);

        String projectName = "-" + acronym + "-" + "TS" + MMYY + "-";
        return projectName.toUpperCase();
    }

    public void delete(Long id) {
        ClientInformation entity = clientInformationDao.findById(id);
        OfficeBPMTaskService.instance().deleteAllTasksForProcessId(entity.getBpmProcessId(), true);
        clientInformationDao.delete(id);
    }

    public ClientInformationDto addCPDToProspect(Long sourceId, String sourceName, ClientInformationDto cpdDto) {
        ClientInformationDto dto = addClientInformation(null, cpdDto, false, sourceId, sourceName);
        //pass source name in future if cpd tied to company, project etc..
        notifyContractsAdminTeam(dto, sourceId, sourceName);
        return dto;
    }

    private void notifyContractsAdminTeam(ClientInformationDto dto, Long sourceId, String sourceName) {
        //use swich case with source name to findv whether the contact, company, project etc...
        if (sourceName.equals("info.yalamanchili.office.entity.hr.Prospect")) {
            Contact contact = ContactDao.instance().findById(sourceId);
            Client client = ClientDao.instance().findById(dto.getClient().getId());
            Vendor vendor = VendorDao.instance().findById(dto.getVendor().getId());
            Email email = new Email();
            email.setHtml(Boolean.TRUE);
            email.setRichText(Boolean.TRUE);
            email.setTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_CONTRACTS_ADMIN.name()));
            email.setSubject("New CPD has created for prospect : " + contact.getFirstName() + " " + contact.getLastName());
            String messageText = "New CPD has created for prospect : " + contact.getFirstName() + " " + contact.getLastName();
            messageText = messageText.concat("<table border='0'>");
            messageText = messageText.concat("<tr><td><b>Prospect Name </b></td> <td>" + contact.getFirstName() + " " + contact.getLastName() + "</td></tr>");
            messageText = messageText.concat("<tr><td><b>Prospect Status </b></td> <td>" + ProspectStatus.CLOSED_WON.name() + "</td></tr>");
            messageText = messageText.concat("<tr><td><b>Client <b></td> <td>" + client.getName() + "</td></tr>");
            messageText = messageText.concat("<tr><td><b>Vendor </b> </td> <td>" + vendor.getName() + "</td></tr>");
            messageText = messageText.concat("<tr><td><b>Project Start Date </b> </td> <td>" + dto.getStartDate() + "</td></tr>");
            if (dto.getEndDate() != null) {
                messageText = messageText.concat("<tr><td><b>Project End Date </b> </td> <td>" + dto.getEndDate() + "</td></tr>");
            }
            email.setBody(messageText);
            MessagingService.instance().sendEmail(email);
        }
    }
}
