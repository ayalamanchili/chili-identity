/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.commons.EntityQueryUtils;
import info.chili.document.dao.SerializedEntityDao;
import info.chili.security.dao.CRoleDao;
import info.chili.security.domain.CRole;
import info.chili.security.domain.CUser;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.dao.profile.ContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
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
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.Preferences;
import info.yalamanchili.office.entity.profile.ext.Dependent;
import info.yalamanchili.office.entity.profile.ext.EmployeeAdditionalDetails;
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.entity.profile.onboarding.OnBoardingStatus;
import info.yalamanchili.office.profile.invite.InviteCodeGeneratorService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    //TODO remove extended
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected EmployeeService employeeService;
    @Autowired
    protected Mapper mapper;

    public void initiateOnBoarding(InitiateOnBoardingDto dto) {
        InviteCode code = InviteCodeGeneratorService.instance().generate(InvitationType.CLIENT_ONBOARDING, dto.getEmail(), new Date(), DateUtils.addDays(new Date(), 7), false);
        SerializedEntityDao.instance().save(dto, code.getClass().getCanonicalName(), code.getId());
        EmployeeOnBoarding onboarding = new EmployeeOnBoarding();
        onboarding.setEmail(dto.getEmail());
        onboarding.setStartedBy(OfficeSecurityService.instance().getCurrentUserName());
        onboarding.setStartedDate(new Date());
        onboarding.setStatus(OnBoardingStatus.Pending_Initial_Document_Submission);
        em.merge(onboarding);
        InviteCodeGeneratorService.instance().sendInviteCodeEmail(code);
    }

    public OnBoardingEmployeeDto getOnboardingInfo(String invitationCode) {
        String invCde = invitationCode.trim();
        InviteCode code = InviteCodeDao.instance().find(invCde);
        Contact cnt = ContactDao.instance().findByEmail(code.getEmail());
        OnBoardingEmployeeDto res = new OnBoardingEmployeeDto();
        res.setFirstName(cnt.getFirstName());
        res.setLastName(cnt.getLastName());
        return res;
    }

    public String onBoardEmployee(OnBoardingEmployeeDto employee) {
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
        String employeeId = employeeService.generateEmployeeId(employee.getFirstName(), employee.getLastName(), employee.getDateOfBirth());
        String generatepass = employeeService.generatepassword();
        String empType = emp.getEmployeeType().getName();
        if (empType.equals("Corporate Employee") || empType.equals("Employee")) {
            //Create CUser
            CUser user = mapper.map(employee, CUser.class);
            user.setPasswordHash(generatepass);
            user.setUsername(employeeId);
            user.setEnabled(true);
            if (empType.equals("Corporate Employee")) {
                user.addRole(CRoleDao.instance().findRoleByName(OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name()));
            }
            user.addRole((CRole) EntityQueryUtils.findEntity(em, CRole.class, "rolename", OfficeRoles.OfficeRole.ROLE_USER.name()));
            user = OfficeSecurityService.instance().createCuser(user);
            emp.setUser(user);
        }

        //Create employee with basic information
        emp.setEmployeeId(employeeId);
        Preferences prefs = new Preferences();
        prefs.setEnableEmailNotifications(Boolean.TRUE);
        emp.setPreferences(prefs);

        //Update Address for Employee
        Address address = new Address();
        address = employee.getAddress();
        emp.getAddresss().add(address);
        address.setContact(emp);

        Email email = new Email();
        email.setEmail(initiateDto.getEmail());
        email.setPrimaryEmail(true);
        emp.addEmail(email);

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
                Email em = new Email();
                em.setEmail(ec.getEmail());
                em.setPrimaryEmail(Boolean.TRUE);
                contact.addEmail(em);
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

        //Create BPM User
        if (emp.getEmployeeType().getName().equalsIgnoreCase("Corporate Employee")) {
            OfficeBPMIdentityService.instance().createUser(employeeId);
            Map<String, Object> obj = new HashMap<>();
            obj.put("entity", emp);
            obj.put("currentEmployee", OfficeSecurityService.instance().getCurrentUser());
            OfficeBPMService.instance().startProcess("on_boarding_employee_process", obj);
        }

        //Update BankAccount Information for Employee
        BankAccount bankAccount = new BankAccount();
        bankAccount = employee.getBankAccount();
        BankAccountDao.instance().save(bankAccount, emp.getId(), emp.getClass().getCanonicalName());

        //Update Dependent Information for Employee
        for (Dependent dependent : employee.getDependent()) {
            DependentDao.instance().save(dependent, emp.getId(), emp.getClass().getCanonicalName());
        }

        //Update Additional Information for Employee
        EmployeeAdditionalDetails employeeAdditionalDetails = new EmployeeAdditionalDetails();
        employeeAdditionalDetails = employee.getEmployeeAdditionalDetails();
        EmployeeAdditionalDetailsDao.instance().save(employeeAdditionalDetails, emp.getId(), emp.getClass().getCanonicalName());

        //create cert
        OfficeSecurityService.instance().createUserCert(emp, null, null);
        return emp.getId().toString();
    }

    public static EmployeeOnBoardingService instance() {
        return SpringContext.getBean(EmployeeOnBoardingService.class);
    }

}
