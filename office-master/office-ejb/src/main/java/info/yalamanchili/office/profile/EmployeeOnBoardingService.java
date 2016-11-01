/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.document.dao.SerializedEntityDao;
import info.chili.reporting.ReportGenerator;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.onboarding.OnBoardingEmployeeProcessBean;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.hr.ProspectCPDDao;
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.EmployeeDocumentDao;
import info.yalamanchili.office.dao.profile.EmployeeTypeDao;
import info.yalamanchili.office.dao.profile.ext.DependentDao;
import info.yalamanchili.office.dao.profile.ext.EmployeeAdditionalDetailsDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingSearchDto;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.onboarding.InitiateOnBoardingDto;
import info.yalamanchili.office.dto.onboarding.OnBoardingEmployeeDto;
import info.yalamanchili.office.dto.profile.EmergencyContactDto;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.DocumentType;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeDocument;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.entity.profile.onboarding.OnBoardingStatus;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.profile.invite.InviteCodeGeneratorService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.lang.time.DateUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component
@Scope("request")
public class EmployeeOnBoardingService {

    private final static Logger logger = Logger.getLogger(EmployeeOnBoardingService.class.getName());

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected EmployeeService employeeService;
    @Autowired
    protected Mapper mapper;
    @Autowired
    protected OnBoardingEmployeeProcessBean processBean;

    public void initiateOnBoarding(InitiateOnBoardingDto dto) {
        EmployeeOnBoarding eo = EmployeeOnBoardingDao.instance().findByEmail(dto.getEmail());
        if (eo != null && !eo.getStatus().equals(OnBoardingStatus.Rejected)) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invitation.already.sent", "Onboarding Invitation Already Sent To This Email");
        } else {
            InviteCode code = InviteCodeGeneratorService.instance().generate(InvitationType.CLIENT_ONBOARDING, dto.getEmail(), new Date(), DateUtils.addDays(new Date(), 7), false, dto);
            SerializedEntityDao.instance().save(dto, code.getClass().getCanonicalName(), code.getId());
            EmployeeOnBoarding onboarding = new EmployeeOnBoarding();
            onboarding.setEmail(dto.getEmail());
            onboarding.setStartedBy(OfficeSecurityService.instance().getCurrentUserName());
            onboarding.setStartedDate(dto.getStartDate());
            onboarding.setStatus(OnBoardingStatus.Pending_Initial_Document_Submission);
            onboarding.setEmpName(dto.getFirstName() + " " + dto.getLastName() + " - " + EmployeeTypeDao.instance().findById(dto.getEmployeeType().getId()).getName().trim() + " - " + dto.getJobTitle().trim());
            onboarding = em.merge(onboarding);
            InviteCodeGeneratorService.instance().sendInviteCodeEmail(code, dto);
            processBean.notifyBackgroundCheckTeam(EmployeeOnBoardingDao.instance().save(onboarding));
            if (dto.getComment() != null) {
                CommentDao.instance().addComment(dto.getComment(), onboarding);
            }
        }

    }

    public OnBoardingEmployeeDto getOnboardingInfo(String invitationCode) {
        String invCde = invitationCode.trim();
        InviteCode code = InviteCodeDao.instance().find(invCde);
        Contact cnt;
        OnBoardingEmployeeDto res = new OnBoardingEmployeeDto();
        BankAccount account = new BankAccount();
        Address address;
        Phone phone;
        if (ContactDao.instance().findByEmail(code.getEmail()) != null) {
            cnt = ContactDao.instance().findByEmail(code.getEmail());
            if (cnt.getAddresss().size() > 0 && cnt.getAddresss().get(0) != null) {
                address = cnt.getAddresss().get(0);
                res.setAddress(address);
            }
            if (cnt.getPhones().size() > 0 && cnt.getPhones().get(0) != null) {
                phone = cnt.getPhones().get(0);
                res.setPhoneNumber(phone.getPhoneNumber());
                if (phone.getCountryCode() != null) {
                    res.setCountryCode(phone.getCountryCode());
                }
            }
            res.setFirstName(cnt.getFirstName());
            res.setLastName(cnt.getLastName());
            res.setDateOfBirth(cnt.getDateOfBirth());
            if (cnt.getSex() != null) {
                res.setSex(cnt.getSex());
            }
            account.setAccountFirstName(cnt.getFirstName());
            account.setAccountLastName(cnt.getLastName());
            res.setBankAccount(account);
        }
        return res;
    }

    @Autowired
    protected DependentDao dependentDao;
    @Autowired
    protected EmployeeDocumentDao employeeDocumentDao;

    public OnBoardingEmployeeDto onBoardEmployee(OnBoardingEmployeeDto dto) {
        Employee emp = mapper.map(dto, Employee.class);
        InviteCode code = InviteCodeDao.instance().find(dto.getInviteCode().trim());
        EmployeeOnBoarding onboarding = EmployeeOnBoardingDao.instance().findByEmail(code.getEmail());
        InitiateOnBoardingDto initiateDto = (InitiateOnBoardingDto) SerializedEntityDao.instance().findAndConvert(code.getClass().getCanonicalName(), code.getId());
        emp.setEmployeeType(em.find(EmployeeType.class, initiateDto.getEmployeeType().getId()));
        emp.setJobTitle(initiateDto.getJobTitle());

        if (initiateDto.getCompany() != null) {
            emp.setCompany(em.find(Company.class, initiateDto.getCompany().getId()));
        }
        emp.setStartDate(initiateDto.getStartDate());
        emp.setWorkStatus(dto.getWorkStatus());
        emp.setSsn(dto.getSsn());
        emp.setBranch(initiateDto.getBranch());
        if (dto.getPhoneNumber() != null) {
            Phone empPhone = new Phone();
            empPhone.setPhoneNumber(dto.getPhoneNumber());
            if (dto.getCountryCode() != null) {
                empPhone.setCountryCode(dto.getCountryCode());
            }
            empPhone.setPhoneType(getCellPhoneType());
            emp.getPhones().add(empPhone);
            empPhone.setContact(emp);
        }
        emp = employeeService.createCUser(emp);
        //Create employee with basic information
        emp = employeeService.createEmailAndOtherDefaults(emp, initiateDto.getEmail());
        Email email = emp.getEmails().get(0);
        email.setEmailType(getPersonalEmailType());
        em.merge(emp);
        //Create BPM User
        if (emp.getEmployeeType().getName().equalsIgnoreCase(EmployeeType.CORPORATE_EMPLOYEE)) {
            employeeService.createBPMUser(emp, false);
        }
        //Update Address for Employee
        Address address;
        address = dto.getAddress();
        emp.getAddresss().add(address);
        address.setContact(emp);

        emp = EmployeeDao.instance().save(emp);
        emp = em.merge(emp);

        if (ContactDao.instance().findByEmail(code.getEmail()) != null) {
            Contact cnt = ContactDao.instance().findByEmail(code.getEmail());
            List<ClientInformation> cpds = null;//ProspectCPDDao.instance().getAllCpds(cnt.getId());
            List<ClientInformation> empCpds = new ArrayList();
            if (cpds != null && cpds.size() > 0) {
                for (ClientInformation cpd : cpds) {
                    cpd.setEmployee(emp);
                    empCpds.add(ClientInformationDao.instance().getEntityManager().merge(cpd));
                }
            }
            if (empCpds.size() > 0) {
                emp.setClientInformations(empCpds);
            }
        }

        //Update Emergency Contact for Employee
        for (EmergencyContactDto ec : dto.getEmergencyContact()) {
            Contact contact = new Contact();
            contact.setFirstName(ec.getFirstName());
            contact.setLastName(ec.getLastName());
            contact.setSex(ec.getSex());
            //Email

            if ((ec.getEmail() != null) && (!ec.getEmail().isEmpty())) {
                Email emil = new Email();
                emil.setEmail(ec.getEmail());
                emil.setPrimaryEmail(Boolean.TRUE);
                contact.addEmail(emil);
            }
            //phone
            if (ec.getPhoneNumber() != null) {
                Phone phone = new Phone();
                contact.addPhone(phone);
                phone.setPhoneNumber(ec.getPhoneNumber());
                phone.setCountryCode(ec.getCountryCode());
                phone.setExtension(ec.getExtension());
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
        }

        //Update Dependent Information for Employee
        for (Dependent dependent : dto.getDependent()) {
            Dependent dep = new Dependent();
            dep.setDfirstName(dependent.getDfirstName());
            dep.setDlastName(dependent.getDlastName());
            dep.setDdateOfBirth(dependent.getDdateOfBirth());
            dep.setRelationship(dependent.getRelationship());
            dep.setTargetEntityId(emp.getId());
            dep.setTargetEntityName(Employee.class.getCanonicalName());
            em.merge(dep);
        }

        onboarding.setStatus(OnBoardingStatus.Pending_Document_Verification);
        onboarding.setEmployee(emp);
        onboarding = em.merge(onboarding);

        //Create BPM User
        if (emp.getEmployeeType().getName().equalsIgnoreCase(EmployeeType.CORPORATE_EMPLOYEE) || emp.getEmployeeType().getName().equalsIgnoreCase(EmployeeType.EMPLOYEE) || emp.getEmployeeType().getName().equalsIgnoreCase(EmployeeType.INTERN_SEASONAL_EMPLOYEE)) {
            OfficeBPMIdentityService.instance().createUser(emp.getEmployeeId());
            Map<String, Object> obj = new HashMap<>();
            obj.put("entity", onboarding);
            obj.put("entityId", onboarding.getId());
            obj.put("employee", emp);
            onboarding.setBpmProcessId(OfficeBPMService.instance().startProcess("on_boarding_employee_process", obj));
            em.merge(onboarding);
        }
        //Update BankAccount Information for Employee
        BankAccount bankAccount;
        bankAccount = dto.getBankAccount();
        if (bankAccount.getAchBlocked() == null) {
            bankAccount.setAchBlocked(Boolean.FALSE);
        }
        BankAccountDao.instance().save(bankAccount, emp.getId(), emp.getClass().getCanonicalName());
        List<EmployeeDocument> docs = new ArrayList();
        for (EmployeeDocument empDoc : dto.getDocuments()) {
            empDoc.setDocumentType(DocumentType.ON_BOARDING);
            empDoc.setEmployee(emp);
            empDoc.setId(employeeDocumentDao.save(empDoc).getId());
            docs.add(empDoc);
        }
        dto.setDocuments(docs);
        //Update Additional Information for Employee
        EmployeeAdditionalDetails employeeAdditionalDetails;
        employeeAdditionalDetails = dto.getEmployeeAdditionalDetails();
        EmployeeAdditionalDetailsDao.instance().save(employeeAdditionalDetails, emp.getId(), emp.getClass().getCanonicalName());
        //create cert
        OfficeSecurityService.instance().createUserCert(emp, null, null);
        //Email notification
        employeeService.sendNewEmployeeNotifiaction(emp);
        InviteCodeDao.instance().invalidateCode(code);
        return dto;
    }

    public InitiateOnBoardingDto read(Long id) {
        EmployeeOnBoarding onboarding = EmployeeOnBoardingDao.instance().findById(id);
        Mapper mapper = (Mapper) SpringContext.getBean("mapper");
        InitiateOnBoardingDto dto = mapper.map(onboarding, InitiateOnBoardingDto.class);
        if (onboarding.getStatus() != null) {
            if (onboarding.getEmployee() != null) {
                Employee emp = onboarding.getEmployee();
                dto.setEmployeeType(emp.getEmployeeType());
                if (emp.getBranch() != null) {
                    dto.setBranch(emp.getBranch());
                }
                if (emp.getCompany() != null) {
                    dto.setCompany(emp.getCompany());
                }
                if (emp.getWorkStatus() != null) {
                    dto.setWorkStatus(emp.getWorkStatus());
                }
                if (emp.getJobTitle() != null) {
                    dto.setJobTitle(emp.getJobTitle());
                }
            }

            dto.setEmail(onboarding.getEmail());
            dto.setStartDate(onboarding.getStartedDate());
            dto.setBpmProcessId(onboarding.getBpmProcessId());
            dto.setStatus(onboarding.getStatus());
        }
        return dto;
    }

    public static EmployeeOnBoardingService instance() {
        return SpringContext.getBean(EmployeeOnBoardingService.class);
    }

    public List<EmployeeOnBoarding> getSearchEmpOnboarding(EmployeeOnBoardingSearchDto dto, int start, int limit) {
        List<EmployeeOnBoarding> emps = EmployeeOnBoardingDao.instance().getSearchOnboarding(dto);
        return emps;

    }

    @Async
    @Transactional
    public void reportsForOnBoarding(Date startDate, Date endDate, String email) {
        List<EmployeeOnBoarding> onboardings = new ArrayList();
        List<EmployeeOnBoardingReportDto> resultDtos = new ArrayList();
        onboardings.addAll(EmployeeOnBoardingDao.instance().getOboardingReportsForDates(startDate, endDate));
        for (EmployeeOnBoarding onboarding : onboardings) {
            resultDtos.add(EmployeeOnBoardingReportDto.map(mapper, onboarding));
        }
        String[] columnOrder = new String[]{"employee", "employeeType", "startDate", "email", "company", "branch"};
        MessagingService.instance().emailReport(ReportGenerator.generateExcelOrderedReport(resultDtos, "Onboarding Report", OfficeServiceConfiguration.instance().getContentManagementLocationRoot(), columnOrder), email);
    }

    private EmailType getPersonalEmailType() {
        Query getEmailType = em.createQuery("from " + EmailType.class.getCanonicalName()
                + " where emailType=:emailTypeParam");
        getEmailType.setParameter("emailTypeParam", "Personal");
        if (getEmailType.getResultList().size() > 0) {
            return (EmailType) getEmailType.getResultList().get(0);
        } else {
            EmailType homeEmailType = new EmailType();
            homeEmailType.setEmailType("Personal");
            return em.merge(homeEmailType);
        }
    }

    private PhoneType getCellPhoneType() {
        Query getCellPhoneType = em.createQuery("from " + PhoneType.class.getCanonicalName()
                + " where phoneType=:phoneTypeParam");
        getCellPhoneType.setParameter("phoneTypeParam", "Cell");
        if (getCellPhoneType.getResultList().size() > 0) {
            return (PhoneType) getCellPhoneType.getResultList().get(0);
        } else {
            PhoneType cellPhoneType = new PhoneType();
            cellPhoneType.setPhoneType("Cell");
            return em.merge(cellPhoneType);
        }
    }
}
