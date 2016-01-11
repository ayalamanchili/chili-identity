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
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.EmployeeDocumentDao;
import info.yalamanchili.office.dao.profile.ext.DependentDao;
import info.yalamanchili.office.dao.profile.ext.EmployeeAdditionalDetailsDao;
import info.yalamanchili.office.dao.profile.onboarding.EmployeeOnBoardingDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dto.onboarding.InitiateOnBoardingDto;
import info.yalamanchili.office.dto.onboarding.OnBoardingEmployeeDto;
import info.yalamanchili.office.dto.profile.EmergencyContactDto;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.DocumentType;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeDocument;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.entity.profile.onboarding.OnBoardingStatus;
import info.yalamanchili.office.profile.invite.InviteCodeGeneratorService;
import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang.time.DateUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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

    public void initiateOnBoarding(InitiateOnBoardingDto dto) {
        EmployeeOnBoarding eo = EmployeeOnBoardingDao.instance().findByEmail(dto.getEmail());
        if (eo != null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invitation.already.sent", "Onboarding Invitation Already Sent To This Email");
        } else {
            InviteCode code = InviteCodeGeneratorService.instance().generate(InvitationType.CLIENT_ONBOARDING, dto.getEmail(), new Date(), DateUtils.addDays(new Date(), 7), false);
            SerializedEntityDao.instance().save(dto, code.getClass().getCanonicalName(), code.getId());
            EmployeeOnBoarding onboarding = new EmployeeOnBoarding();
            onboarding.setEmail(dto.getEmail());
            onboarding.setStartedBy(OfficeSecurityService.instance().getCurrentUserName());
            onboarding.setStartedDate(new Date());
            onboarding.setStatus(OnBoardingStatus.Pending_Initial_Document_Submission);
            //to save onboarding only once
            onboarding = em.merge(onboarding);
            InviteCodeGeneratorService.instance().sendInviteCodeEmail(code);
            EmployeeOnBoardingDao.instance().save(onboarding);
        }
    }

    public OnBoardingEmployeeDto getOnboardingInfo(String invitationCode) {
        String invCde = invitationCode.trim();
        InviteCode code = InviteCodeDao.instance().find(invCde);
        Contact cnt;
        OnBoardingEmployeeDto res = new OnBoardingEmployeeDto();
        BankAccount account = new BankAccount();
        Address address;
        if (ContactDao.instance().findByEmail(code.getEmail()) != null) {
            cnt = ContactDao.instance().findByEmail(code.getEmail());
            if (cnt.getAddresss().size() > 0 && cnt.getAddresss().get(0) != null) {
                address = cnt.getAddresss().get(0);
                res.setAddress(address);
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

    public OnBoardingEmployeeDto onBoardEmployee(OnBoardingEmployeeDto employee) {
        Employee emp = mapper.map(employee, Employee.class);
        InviteCode code = InviteCodeDao.instance().find(employee.getInviteCode().trim());
        EmployeeOnBoarding onboarding = EmployeeOnBoardingDao.instance().findByEmail(code.getEmail());
        InitiateOnBoardingDto initiateDto = (InitiateOnBoardingDto) SerializedEntityDao.instance().findAndConvert(code.getClass().getCanonicalName(), code.getId());
        emp.setEmployeeType(em.find(EmployeeType.class, initiateDto.getEmployeeType().getId()));
        if (initiateDto.getCompany() != null) {
            emp.setCompany(em.find(Company.class, initiateDto.getCompany().getId()));
        }
        emp.setStartDate(initiateDto.getStartDate());
        emp.setWorkStatus(employee.getWorkStatus());
        emp.setSsn(employee.getSsn());
        emp.setBranch(initiateDto.getBranch());
        emp = employeeService.createCUser(emp);
        //Create employee with basic information
        emp = employeeService.createEmailAndOtherDefaults(emp, initiateDto.getEmail());
        //Create BPM User
        if (emp.getEmployeeType().getName().equalsIgnoreCase("Corporate Employee")) {
            employeeService.createBPMUser(emp);
        }
        //Update Address for Employee
        Address address;
        address = employee.getAddress();
        emp.getAddresss().add(address);
        address.setContact(emp);

        emp = EmployeeDao.instance().save(emp);
        emp = em.merge(emp);

        //Update Emergency Contact for Employee
        for (EmergencyContactDto ec : employee.getEmergencyContact()) {
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

        onboarding.setStatus(OnBoardingStatus.Pending_Document_Verification);
        onboarding.setEmployee(emp);
        em.merge(onboarding);

        //Update BankAccount Information for Employee
        BankAccount bankAccount;
        bankAccount = employee.getBankAccount();
        BankAccountDao.instance().save(bankAccount, emp.getId(), emp.getClass().getCanonicalName());

        //Update Dependent Information for Employee
        for (Dependent dependent : employee.getDependent()) {
            dependentDao.save(dependent, emp.getId(), emp.getClass().getCanonicalName());
        }
        //employee documents
        for (EmployeeDocument empDoc : employee.getDocuments()) {
            empDoc.setDocumentType(DocumentType.ON_BOARDING);
            empDoc.setEmployee(emp);
            empDoc.setId(employeeDocumentDao.save(empDoc).getId());
        }
        //Update Additional Information for Employee
        EmployeeAdditionalDetails employeeAdditionalDetails;
        employeeAdditionalDetails = employee.getEmployeeAdditionalDetails();
        EmployeeAdditionalDetailsDao.instance().save(employeeAdditionalDetails, emp.getId(), emp.getClass().getCanonicalName());
        //create cert
        OfficeSecurityService.instance().createUserCert(emp, null, null);
        //Email notification
        employeeService.sendNewEmployeeNotifiaction(emp);
        code.setExpiryDate(DateUtils.addDays(code.getExpiryDate(), -8));
        InviteCodeDao.instance().save(code);
        return employee;
    }

    public static EmployeeOnBoardingService instance() {
        return SpringContext.getBean(EmployeeOnBoardingService.class);
    }

}
