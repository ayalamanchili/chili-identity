/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.init;

import com.google.gson.Gson;
import info.chili.bpm.domain.BPMTaskDelegateRule;
import info.chili.commons.DateUtils;
import info.chili.commons.EntityQueryUtils;
import info.chili.jpa.QueryUtils;
import info.chili.security.SecurityService;
import info.chili.security.SecurityUtils;
import info.chili.security.domain.CIPAddress;
import info.chili.security.domain.CIPAddressType;
import info.chili.security.domain.CUser;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.config.OfficeSecurityConfiguration;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Project;
import info.yalamanchili.office.entity.client.StatementOfWork;
import info.yalamanchili.office.entity.client.Subcontractor;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.company.CompanyContactType;
import info.yalamanchili.office.entity.drive.Folder;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseCategory;
import info.yalamanchili.office.entity.ext.ExternalRef;
import info.yalamanchili.office.entity.practice.Practice;
import info.yalamanchili.office.entity.privacy.PrivacyData;
import info.yalamanchili.office.entity.privacy.PrivacyMode;
import info.yalamanchili.office.entity.privacy.PrivacySetting;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Certification;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
import info.yalamanchili.office.entity.profile.Preferences;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.Skill;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.profile.SkillSetFile;
import info.yalamanchili.office.entity.profile.TechnologyGroup;
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.InviteType;
import info.yalamanchili.office.entity.social.Post;
import info.yalamanchili.office.config.PaylocityConfigurtion;
import info.yalamanchili.office.entity.profile.ClientStatus;
import info.yalamanchili.office.entity.profile.SubcontractorStatus;
import info.yalamanchili.office.entity.profile.VendorStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OfficeStartup {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected MongoOperations mongoTemplate;

    protected CUser userUser;
    protected CUser rohanUser;
    protected CUser pavanUser;
    protected CUser shristiUser;
    protected CUser adminUser;
    protected Employee userEmp;
    protected Employee adminEmp;
    protected Employee rohanEmp;
    protected Employee pavanEmp;
    protected Employee shristiEmp;
    protected Company sstechCmp;
    protected Folder driveFolder;

    protected void startup() {
        OfficeServiceConfiguration config = (OfficeServiceConfiguration) SpringContext.getBean("officeServiceConfiguration");
        OfficeSecurityService.instance().syncOfficeRoles();
        //This data is required in production
        initSecurity();
        if (config.getInitRefData()) {
            initUsers();
            AclDataInit aclDataInit = SpringContext.getBean(AclDataInit.class);
            aclDataInit.initAclRefData();
            initRefData();
            initSampleEmployees();
        }
        //This is not required in prod mode
        if (config.getInitTestData()) {
            initTestData();
        }
        //Run sync tasks
//        TimeJobService.instance().syncTimeSheetPeriods();
        OfficeBPMIdentityService.instance().syncUsersAndRoles();
//        NotificationGroupDao.instance().syncNotificationGroupsForRoles();
    }

    protected void initSecurity() {
        SecurityService security = SecurityService.instance();
        OfficeSecurityConfiguration securityconfig = OfficeSecurityConfiguration.instance();
        security.initKeyStore(securityconfig.getKeyStoreType(), securityconfig.getKeyStoreName(), securityconfig.getKeyStorePassword(), securityconfig.getKeyStorePath());
        security.initSecurityProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    protected void initUsers() {
        userUser();
        userAdmin();
        userRohan();
        userPavan();
        userShristi();
    }

    protected void initSampleEmployees() {
        // User Employee
        userEmp = new Employee();
        userEmp.setEmployeeId("useruser");
        userEmp.setFirstName("user");
        userEmp.setLastName("user");
        userEmp.setDateOfBirth(DateUtils.getNextYear(new Date(), -1));
        userEmp.setSex(Sex.MALE);
        userEmp.setStartDate(new Date());
        userEmp.setEmployeeType(getEmployeeType());

        Preferences userPrefs = new Preferences();
        userPrefs.setEnableEmailNotifications(Boolean.TRUE);
        userEmp.setPreferences(userPrefs);

        Address userAddress = new Address();
        userAddress.setAddressType(getHomeAddressType());
        userAddress.setStreet1("2110 wilkes ct");
        userAddress.setStreet2("apt 123");
        userAddress.setCity("Herndon");
        userAddress.setState("VA");
        userAddress.setCountry("USA");
        userAddress.setZip("123456");

        Email userPrimaryEmail = new Email();
        userPrimaryEmail.setEmailType(getWorkEmailType());
        userPrimaryEmail.setPrimaryEmail(true);
        userPrimaryEmail.setEmail("useruser@yopmail.com");

        Email userSecondaryEmail = new Email();
        userSecondaryEmail.setPrimaryEmail(false);
        userSecondaryEmail.setEmailType(getPersonalEmailType());
        userSecondaryEmail.setEmail("user_secondary@yopmail.com");

        Phone userCellPhone = new Phone();
        userCellPhone.setPhoneNumber("7031112222");
        userCellPhone.setPhoneType(getCellPhoneType());

        userEmp.addPhone(userCellPhone);
        userEmp.addAddress(userAddress);
        userEmp.addEmail(userPrimaryEmail);
        userEmp.addEmail(userSecondaryEmail);
//        userEmp.addClientInformation(userClientInfo());
        userEmp.addEmergencyContact(userEmergencyContact());
        userEmp.setUser(userUser);
        userEmp = em.merge(userEmp);

        // Admin Employee
        adminEmp = new Employee();
        adminEmp.setEmployeeId("adminadmin");
        adminEmp.setFirstName("admin");
        adminEmp.setLastName("admin");
        adminEmp.setDateOfBirth(DateUtils.getNextYear(new Date(), -3));
        adminEmp.setSex(Sex.FEMALE);
        adminEmp.setStartDate(DateUtils.getNextYear(new Date(), -2));
        adminEmp.setEmployeeType(getCorporateEmployeeType());

        Preferences adminPrefs = new Preferences();
        adminPrefs.setEnableEmailNotifications(Boolean.TRUE);
        adminEmp.setPreferences(adminPrefs);

        Address adminAddress = new Address();
        adminAddress.setAddressType(getOfficeAddressType());
        adminAddress.setStreet1("2110 wilkes ct");
        adminAddress.setStreet2("apt 123");
        adminAddress.setCity("Herndon");
        adminAddress.setState("VA");
        adminAddress.setCountry("USA");
        adminAddress.setZip("123456");

        Email adminPrimaryEmail = new Email();
        adminPrimaryEmail.setEmailType(getWorkEmailType());
        adminPrimaryEmail.setPrimaryEmail(true);

        adminPrimaryEmail.setEmail("adminadmin@yopmail.com");

        Email adminSecondaryEmail = new Email();
        adminSecondaryEmail.setEmailType(getPersonalEmailType());
        adminSecondaryEmail.setPrimaryEmail(false);
        adminSecondaryEmail.setEmail("adminadmin1@yopmail.com");

        Phone adminCellPhone = new Phone();
        adminCellPhone.setPhoneNumber("7038889999");
        adminCellPhone.setPhoneType(getCellPhoneType());

        adminEmp.addPhone(adminCellPhone);
        adminEmp.addAddress(adminAddress);
        adminEmp.addEmail(adminPrimaryEmail);
        adminEmp.addEmail(adminSecondaryEmail);
        adminEmp.setUser(adminUser);
        adminEmp = em.merge(adminEmp);

        SkillSet userSkillSet = new SkillSet();
        userSkillSet.setLastUpdated(new Date());
        SkillSetFile resume1 = new SkillSetFile();
        Set<SkillSetFile> resume = new HashSet<>();
        resume.add(resume1);
        userSkillSet.setSkillSetFile(resume);
        userSkillSet.getCertifications().add(getDOTNETCertification());
        userSkillSet.getSkills().add(getJavaSkill());
        userSkillSet.getSkills().add(getDOTNETSkill());
        userSkillSet.setPractice(getDevelopmentPractice());
        userSkillSet.setTechnologyGroup(getIBMTG());
        userSkillSet = em.merge(userSkillSet);

        userEmp.setSkillSet(userSkillSet);
        userEmp = em.merge(userEmp);

        // Social
        Post userPost1 = new Post();
        userPost1.setPostTimeStamp(new Date());
        userPost1.setPostContent("this is my first post by user");
        userPost1.setEmployee(userEmp);
        userPost1 = em.merge(userPost1);

        Post userPostReply1 = new Post();
        userPostReply1.setPostContent("this is a sample reply to user post by admin");
        userPostReply1.setPostTimeStamp(new Date());
        userPostReply1.setEmployee(adminEmp);
        userPostReply1.setParentPost(userPost1);
        userPostReply1 = em.merge(userPostReply1);

        Post userPost2 = new Post();
        userPost2.setPostTimeStamp(new Date());
        userPost2.setPostContent("<h3>This is a Sample System Soft news letter</h3><b>this is my company post by admin</b>");
        userPost2.setEmployee(userEmp);
        userPost2.setCompany(sstechCmp);
        userPost2 = em.merge(userPost2);

        rohanEmp = new Employee();
        rohanEmp.setEmployeeId("racharya");
        rohanEmp.setFirstName("Rohan");
        rohanEmp.setLastName("Acharya");
        rohanEmp.setDateOfBirth(DateUtils.getNextYear(new Date(), -1));
        rohanEmp.setSex(Sex.MALE);
        rohanEmp.setStartDate(new Date());
        rohanEmp.setEmployeeType(getEmployeeType());

        Preferences userPref = new Preferences();
        userPref.setEnableEmailNotifications(Boolean.TRUE);
        rohanEmp.setPreferences(userPref);

        Address userAddres = new Address();
        userAddres.setAddressType(getHomeAddressType());
        userAddres.setStreet1("2110 wilkes ct");
        userAddres.setStreet2("apt 123");
        userAddres.setCity("Herndon");
        userAddres.setState("VA");
        userAddres.setCountry("USA");
        userAddres.setZip("123456");

        Email userPrimaryEmails = new Email();
        userPrimaryEmails.setEmailType(getWorkEmailType());
        userPrimaryEmails.setPrimaryEmail(true);
        userPrimaryEmails.setEmail("racharya@yopmail.com");

        Email userSecondaryEmails = new Email();
        userSecondaryEmails.setPrimaryEmail(false);
        userSecondaryEmails.setEmailType(getPersonalEmailType());
        userSecondaryEmails.setEmail("user_secondary@yopmail.com");

        Phone userCellPhones = new Phone();
        userCellPhones.setPhoneNumber("4564564562");
        userCellPhones.setPhoneType(getCellPhoneType());

        rohanEmp.addPhone(userCellPhones);
        rohanEmp.addAddress(userAddres);
        rohanEmp.addEmail(userPrimaryEmails);
        rohanEmp.addEmail(userSecondaryEmails);
        rohanEmp.addEmergencyContact(userEmergencyContact());
        rohanEmp.setUser(rohanUser);
        rohanEmp = em.merge(rohanEmp);

        pavanEmp = new Employee();
        pavanEmp.setEmployeeId("padapala");
        pavanEmp.setFirstName("Pavan Kumar");
        pavanEmp.setLastName("Adapala");
        pavanEmp.setDateOfBirth(DateUtils.getNextYear(new Date(), -1));
        pavanEmp.setSex(Sex.MALE);
        pavanEmp.setStartDate(new Date());
        pavanEmp.setEmployeeType(getEmployeeType());

        Preferences userPrefes = new Preferences();
        userPrefes.setEnableEmailNotifications(Boolean.TRUE);
        pavanEmp.setPreferences(userPrefes);

        Address userAddreess = new Address();
        userAddreess.setAddressType(getHomeAddressType());
        userAddreess.setStreet1("2110 wilkes ct");
        userAddreess.setStreet2("apt 123");
        userAddreess.setCity("Herndon");
        userAddreess.setState("VA");
        userAddreess.setCountry("USA");
        userAddreess.setZip("123456");

        Email userPraimaryEmails = new Email();
        userPraimaryEmails.setEmailType(getWorkEmailType());
        userPraimaryEmails.setPrimaryEmail(true);
        userPraimaryEmails.setEmail("padapala@yopmail.com");

        Email userSecondaryEmailes = new Email();
        userSecondaryEmailes.setPrimaryEmail(false);
        userSecondaryEmailes.setEmailType(getPersonalEmailType());
        userSecondaryEmailes.setEmail("user_secondary@yopmail.com");

        Phone userCellPhoness = new Phone();
        userCellPhoness.setPhoneNumber("8122290672");
        userCellPhoness.setPhoneType(getCellPhoneType());

        pavanEmp.addPhone(userCellPhoness);
        pavanEmp.addAddress(userAddreess);
        pavanEmp.addEmail(userPraimaryEmails);
        pavanEmp.addEmail(userSecondaryEmailes);
        pavanEmp.addEmergencyContact(userEmergencyContact());
        pavanEmp.setUser(pavanUser);
        pavanEmp = em.merge(pavanEmp);

        shristiEmp = new Employee();
        shristiEmp.setEmployeeId("sadhikari");
        shristiEmp.setFirstName("Shristi");
        shristiEmp.setLastName("Adhikari");
        shristiEmp.setDateOfBirth(DateUtils.getNextYear(new Date(), -1));
        shristiEmp.setSex(Sex.MALE);
        shristiEmp.setStartDate(new Date());
        shristiEmp.setEmployeeType(getEmployeeType());

        Preferences userPre = new Preferences();
        userPre.setEnableEmailNotifications(Boolean.TRUE);
        shristiEmp.setPreferences(userPre);

        Address useraddress = new Address();
        useraddress.setAddressType(getHomeAddressType());
        useraddress.setStreet1("2110 wilkes ct");
        useraddress.setStreet2("apt 123");
        useraddress.setCity("Herndon");
        useraddress.setState("VA");
        useraddress.setCountry("USA");
        useraddress.setZip("123456");

        Email userPrimaryemails = new Email();
        userPrimaryemails.setEmailType(getWorkEmailType());
        userPrimaryemails.setPrimaryEmail(true);
        userPrimaryemails.setEmail("sadhikari@yopmail.com");

        Email userSecondaryemails = new Email();
        userSecondaryemails.setPrimaryEmail(false);
        userSecondaryemails.setEmailType(getPersonalEmailType());
        userSecondaryemails.setEmail("user_secondary@yopmail.com");

        Phone userCellphones = new Phone();
        userCellphones.setPhoneNumber("4195811199");
        userCellphones.setPhoneType(getCellPhoneType());

        shristiEmp.addPhone(userCellphones);
        shristiEmp.addAddress(useraddress);
        shristiEmp.addEmail(userPrimaryemails);
        shristiEmp.addEmail(userSecondaryemails);
        shristiEmp.addEmergencyContact(userEmergencyContact());
        shristiEmp.setUser(shristiUser);
        shristiEmp = em.merge(shristiEmp);

        BPMTaskDelegateRule rule = new BPMTaskDelegateRule();
        rule.setBpmProcessId("status_report_approval_process");
        rule.setBpmTaskId("statusReportEEMApprovalTask");
        rule.setRuleName("alphabetRangeRuleEvaluator");
        rule.addAttribute(new Entry("range1Start", "a"));
        rule.addAttribute(new Entry("range1End", "z"));
        rule.addAttribute(new Entry("range1Assignee", "adminadmin"));
        Gson gson = new Gson();
        rule.setAttributeData(gson.toJson(rule.getAttributes()));
        em.merge(rule);

        BPMTaskDelegateRule rule1 = new BPMTaskDelegateRule();
        rule1.setBpmProcessId("travel_authorization_process");
        rule1.setBpmTaskId("travelAuthorizationManagerApprovalTask");
        rule1.setRuleName("managerAssignmentRuleEvaluator");
        em.merge(rule1);

        BPMTaskDelegateRule rule2 = new BPMTaskDelegateRule();
        rule2.setBpmProcessId("expense_report_process");
        rule2.setBpmTaskId("expenseReportMgrApprovalTask");
        rule2.setRuleName("managerAssignmentRuleEvaluator");
        em.merge(rule2);

        BPMTaskDelegateRule rule3 = new BPMTaskDelegateRule();
        rule3.setBpmProcessId("immigration_check_requisition_process");
        rule3.setBpmTaskId("checkRequestApprovalTask");
        rule3.setRuleName("employeeIdAssignmentRuleEvaluator");
        rule3.setAttributeData("adminadmin");
        em.merge(rule3);
//rule to assign project off boarding task to list of employees
        BPMTaskDelegateRule rule4 = new BPMTaskDelegateRule();
        rule4.setBpmProcessId("associate_project_offboarding_process");
        rule4.setBpmTaskId("projectOffBoardingTask");
        rule4.setRuleName("employeeIdAssignmentRuleEvaluator");
        rule4.setAttributeData("adminadmin,useruser");
        em.merge(rule4);
        //unpaid final approval rule
        BPMTaskDelegateRule rule5 = new BPMTaskDelegateRule();
        rule5.setBpmProcessId("corp_emp_leave_request_process");
        rule5.setBpmTaskId("unpaidLeaveFinalApprovalTask");
        rule5.setRuleName("employeeIdAssignmentRuleEvaluator");
        rule5.setAttributeData("adminadmin,useruser");
        em.merge(rule5);
        //client information task rule 
        BPMTaskDelegateRule rule6 = new BPMTaskDelegateRule();
        rule6.setBpmProcessId("new_client_info_process");
        rule6.setBpmTaskId("newClientInfoInvoicingAndBillingTask");
        rule6.setRuleName("employeeIdAssignmentRuleEvaluator");
        rule6.setAttributeData("adminadmin,useruser");
        em.merge(rule6);
        //client information task rule 
        BPMTaskDelegateRule rule7 = new BPMTaskDelegateRule();
        rule7.setBpmProcessId("new_client_info_process");
        rule7.setBpmTaskId("newClientInfoHRTask");
        rule7.setRuleName("employeeIdAssignmentRuleEvaluator");
        rule7.setAttributeData("adminadmin,useruser");
        em.merge(rule7);
        //client information task rule 
        BPMTaskDelegateRule rule8 = new BPMTaskDelegateRule();
        rule8.setBpmProcessId("advance_requisition_process");
        rule8.setBpmTaskId("advanceRequisitionFinalApprovalTask");
        rule8.setRuleName("employeeIdAssignmentRuleEvaluator");
        rule8.setAttributeData("adminadmin,useruser");
        em.merge(rule8);
        //client information task rule 
        BPMTaskDelegateRule rule9 = new BPMTaskDelegateRule();
        rule9.setBpmProcessId("new_client_info_process");
        rule9.setBpmTaskId("newClientInfoContractValidation");
        rule9.setRuleName("employeeIdAssignmentRuleEvaluator");
        rule9.setAttributeData("adminadmin,useruser");
        em.merge(rule9);
        //project Offboarding task rule 
        BPMTaskDelegateRule rule10 = new BPMTaskDelegateRule();
        rule10.setBpmProcessId("associate_project_offboarding_process");
        rule10.setBpmTaskId("projectOffboardingValidationTask");
        rule10.setRuleName("employeeIdAssignmentRuleEvaluator");
        rule10.setAttributeData("adminadmin,useruser");
        em.merge(rule10);
    }

    /**
     * This data must be present in the DB for all other functions
     */
    protected void initRefData() {
        // Company
        if (QueryUtils.findEntity(em, Company.class, "name", Company.SSTECH_LLC) == null) {
            sstechCmp = new Company();
            sstechCmp.setName(Company.SSTECH_LLC);
            sstechCmp = em.merge(sstechCmp);
        }
        //DriveFolder
        if (QueryUtils.findEntity(em, Folder.class, "name", "DRIVE") == null) {
            driveFolder = new Folder();
            driveFolder.setName("DRIVE");
            driveFolder.setDescription("Root folder for System Soft Drive");
            driveFolder = em.merge(driveFolder);
        }

        // Address Types
        getHomeAddressType();
        getOtherAddressType();
        // Email Types
        getWorkEmailType();
        getPersonalEmailType();
        // Phone Types
        getCellPhoneType();
        getHomePhoneType();
        //Employee Type
        getCorporateEmployeeType();
        getInternEmployeeType();
        getEmployeeType();
        getSubContractorEmployeeType();
        get1099EmployeeType();
        getW2EmployeeType();
    }

    protected void initTestData() {
        //Practice
        getDevelopmentPractice();
        getIBMTG();
        //Skills
        getJavaSkill();
        getDOTNETSkill();
        //Company Contact Type
        getCompanyContactReportsTo();
        getCompanyContactPerf();
        getCompanyContactsupervisor();
        //vendor
        techSysVendor();
        sstechSubcontractor();
        //Certifications
        getJAVACertification();
        getDOTNETCertification();
        //Expenses
        getAirFareExpenseCategory();
        getAutoExpenseCategory();
        getClientExpenseCategory();
        getHotelExpenseCategory();
        getMisExpenseCategory();
        getPersonalAutoCategory();
        getGeneralCategory();
        //TAE
        techSysClient();

        Folder hrFolder = new Folder();
        hrFolder.setName("HR");
        hrFolder.setParent(driveFolder);
        em.merge(hrFolder);

        //Test privacy setting
        PrivacySetting privacySetting = new PrivacySetting();
        privacySetting.setPrivacyData(PrivacyData.EMAILS);
        privacySetting.setPrivacyMode(PrivacyMode.PUBLIC);
        privacySetting.setEmployee(userEmp);
        em.merge(privacySetting);

        //Invite Type on boarding
        InviteType invititationType = new InviteType();
        invititationType.setInvitationType(InvitationType.CLIENT_ONBOARDING);
        invititationType.setDescription("Employee On Boarding");
//        invititationType.setEmailTemplateName("on-boardng-invite-email.xhtml");
        mongoTemplate.save(invititationType);

        CIPAddress ipAddress = new CIPAddress();
        ipAddress.setAddressType(CIPAddressType.GLOBAL_VALIDATED);
        ipAddress.setName("Local IP");
        ipAddress.setIpAddress("127.0.0.1");
        em.merge(ipAddress);

        CIPAddress ipAddress2 = new CIPAddress();
        ipAddress2.setAddressType(CIPAddressType.GLOBAL_VALIDATED);
        ipAddress2.setName("Local IPV6");
        ipAddress2.setIpAddress("0:0:0:0:0:0:0:1");
        em.merge(ipAddress2);

        ExternalRef bisRef = new ExternalRef();
        bisRef.setExternalId("666");
        bisRef.setSource("BIS");
        bisRef.setTargetEntityId(adminEmp.getId());
        bisRef.setTargetEntityName(Employee.class.getCanonicalName());
        em.merge(bisRef);

        ExternalRef paylocityEmployeeExtRef = new ExternalRef();
        paylocityEmployeeExtRef.setExternalId("1");
        paylocityEmployeeExtRef.setSource(PaylocityConfigurtion.PAYLOCITY);
        paylocityEmployeeExtRef.setTargetEntityId(adminEmp.getId());
        paylocityEmployeeExtRef.setTargetEntityName(Employee.class.getCanonicalName());
        em.merge(paylocityEmployeeExtRef);

        ExternalRef paylocityCompanyExtRef = new ExternalRef();
        paylocityCompanyExtRef.setExternalId("s2231");
        paylocityCompanyExtRef.setSource(PaylocityConfigurtion.PAYLOCITY);
        paylocityCompanyExtRef.setTargetEntityId(sstechCmp.getId());
        paylocityCompanyExtRef.setTargetEntityName(Company.class.getCanonicalName());
        em.merge(paylocityCompanyExtRef);
        //
    }

    protected AddressType getHomeAddressType() {
        Query getAddressType = em.createQuery("from " + AddressType.class.getCanonicalName()
                + " where addressType=:addressTypeParam");
        getAddressType.setParameter("addressTypeParam", "Home");
        if (getAddressType.getResultList().size() > 0) {
            return (AddressType) getAddressType.getResultList().get(0);
        } else {
            AddressType homeAddressType = new AddressType();
            homeAddressType.setAddressType("Home");
            return em.merge(homeAddressType);
        }
    }

    protected AddressType getOfficeAddressType() {
        Query getAddressType = em.createQuery("from " + AddressType.class.getCanonicalName()
                + " where addressType=:addressTypeParam");
        getAddressType.setParameter("addressTypeParam", "Office");
        if (getAddressType.getResultList().size() > 0) {
            return (AddressType) getAddressType.getResultList().get(0);
        } else {
            AddressType officeAddressType = new AddressType();
            officeAddressType.setAddressType("Office");
            return em.merge(officeAddressType);
        }
    }

    protected AddressType getOtherAddressType() {
        Query getAddressType = em.createQuery("from " + AddressType.class.getCanonicalName()
                + " where addressType=:addressTypeParam");
        getAddressType.setParameter("addressTypeParam", "Other");
        if (getAddressType.getResultList().size() > 0) {
            return (AddressType) getAddressType.getResultList().get(0);
        } else {
            AddressType officeAddressType = new AddressType();
            officeAddressType.setAddressType("Other");
            return em.merge(officeAddressType);
        }
    }

    protected EmailType getWorkEmailType() {
        Query getEmailType = em.createQuery("from " + EmailType.class.getCanonicalName()
                + " where emailType=:emailTypeParam");
        getEmailType.setParameter("emailTypeParam", "Work");
        if (getEmailType.getResultList().size() > 0) {
            return (EmailType) getEmailType.getResultList().get(0);
        } else {
            EmailType homeEmailType = new EmailType();
            homeEmailType.setEmailType("Work");
            return em.merge(homeEmailType);
        }
    }

    protected EmailType getPersonalEmailType() {
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

    protected PhoneType getCellPhoneType() {
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

    protected PhoneType getHomePhoneType() {
        Query getHomePhoneType = em.createQuery("from " + PhoneType.class.getCanonicalName()
                + " where phoneType=:phoneTypeParam");
        getHomePhoneType.setParameter("phoneTypeParam", "Home");
        if (getHomePhoneType.getResultList().size() > 0) {
            return (PhoneType) getHomePhoneType.getResultList().get(0);
        } else {
            PhoneType cellPhoneType = new PhoneType();
            cellPhoneType.setPhoneType("Home");
            return em.merge(cellPhoneType);
        }
    }

    protected Practice getDevelopmentPractice() {
        Query getPracticeQuery = em.createQuery("from " + Practice.class.getCanonicalName()
                + " where name=:nameParam");
        getPracticeQuery.setParameter("nameParam", "Application Development");
        if (getPracticeQuery.getResultList().size() > 0) {
            return (Practice) getPracticeQuery.getResultList().get(0);
        } else {
            Practice entity = new Practice();
            entity.setName("Application Development");
            return em.merge(entity);
        }
    }

    protected TechnologyGroup getIBMTG() {
        Query getQuery = em.createQuery("from " + TechnologyGroup.class.getCanonicalName()
                + " where name=:nameParam");
        getQuery.setParameter("nameParam", "IBM");
        if (getQuery.getResultList().size() > 0) {
            return (TechnologyGroup) getQuery.getResultList().get(0);
        } else {
            TechnologyGroup entity = new TechnologyGroup();
            entity.setName("IBM");
            return em.merge(entity);
        }
    }

    protected Skill getJavaSkill() {
        Query getSkillQuery = em.createQuery("from " + Skill.class.getCanonicalName()
                + " where name=:nameParam");
        getSkillQuery.setParameter("nameParam", "JAVA");
        if (getSkillQuery.getResultList().size() > 0) {
            return (Skill) getSkillQuery.getResultList().get(0);
        } else {
            Skill javaSkill = new Skill();
            javaSkill.setName("JAVA");
            javaSkill.setDescription("Java Programing Language");
            return em.merge(javaSkill);
        }
    }

    protected Skill getDOTNETSkill() {
        Query getSkillQuery = em.createQuery("from " + Skill.class.getCanonicalName()
                + " where name=:nameParam");
        getSkillQuery.setParameter("nameParam", "DOTNET");
        if (getSkillQuery.getResultList().size() > 0) {
            return (Skill) getSkillQuery.getResultList().get(0);
        } else {
            Skill javaSkill = new Skill();
            javaSkill.setName("DOTNET");
            javaSkill.setDescription("DOTNET Programing Language");
            return em.merge(javaSkill);
        }
    }

    protected Certification getJAVACertification() {
        Query getCertificationQuery = em.createQuery("from " + Certification.class.getCanonicalName()
                + " where name=:nameParam");
        getCertificationQuery.setParameter("nameParam", "JAVA_CERTIFICATION");
        if (getCertificationQuery.getResultList().size() > 0) {
            return (Certification) getCertificationQuery.getResultList().get(0);
        } else {
            Certification certification = new Certification();
            certification.setName("JAVA_CERTIFICATION");
            certification.setDescription("JAVA_CERTIFICATION from SUN");
            return em.merge(certification);
        }
    }

    protected Certification getDOTNETCertification() {
        Query getCertificationQuery = em.createQuery("from " + Certification.class.getCanonicalName()
                + " where name=:nameParam");
        getCertificationQuery.setParameter("nameParam", "DOTNET_CERTIFICATION");
        if (getCertificationQuery.getResultList().size() > 0) {
            return (Certification) getCertificationQuery.getResultList().get(0);
        } else {
            Certification certification = new Certification();
            certification.setName("DOTNET_CERTIFICATION");
            certification.setDescription("DOTNET_CERTIFICATION from Miscrosoft");
            return em.merge(certification);
        }
    }

    protected EmployeeType getInternEmployeeType() {
        Query getEmployeeTypeQuery = em.createQuery("from " + EmployeeType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", EmployeeType.INTERN_SEASONAL_EMPLOYEE);
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (EmployeeType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            EmployeeType employeetype = new EmployeeType();
            employeetype.setName(EmployeeType.INTERN_SEASONAL_EMPLOYEE);
            employeetype.setDescription("SSTECH Internal Employee");
            return em.merge(employeetype);
        }
    }

    protected EmployeeType getCorporateEmployeeType() {
        Query getEmployeeTypeQuery = em.createQuery("from " + EmployeeType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", EmployeeType.CORPORATE_EMPLOYEE);
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (EmployeeType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            EmployeeType employeetype = new EmployeeType();
            employeetype.setName(EmployeeType.CORPORATE_EMPLOYEE);
            employeetype.setDescription("SSTECH Internal Employee");
            return em.merge(employeetype);
        }
    }

    protected EmployeeType getSubContractorEmployeeType() {
        Query getEmployeeTypeQuery = em.createQuery("from " + EmployeeType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", EmployeeType.SUBCONTRACTOR);
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (EmployeeType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            EmployeeType employeetype = new EmployeeType();
            employeetype.setName(EmployeeType.SUBCONTRACTOR);
            employeetype.setDescription("SSTECH Subcontractor");
            return em.merge(employeetype);
        }
    }

    protected EmployeeType get1099EmployeeType() {
        Query getEmployeeTypeQuery = em.createQuery("from " + EmployeeType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", EmployeeType._1099_CONTRACTOR);
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (EmployeeType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            EmployeeType employeetype = new EmployeeType();
            employeetype.setName(EmployeeType._1099_CONTRACTOR);
            employeetype.setDescription("SSTECH 1099");
            return em.merge(employeetype);
        }
    }

    protected EmployeeType getW2EmployeeType() {
        Query getEmployeeTypeQuery = em.createQuery("from " + EmployeeType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", EmployeeType.W2_CONTRACTOR);
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (EmployeeType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            EmployeeType employeetype = new EmployeeType();
            employeetype.setName(EmployeeType.W2_CONTRACTOR);
            employeetype.setDescription("SSTECH W2");
            return em.merge(employeetype);
        }
    }

    protected EmployeeType getEmployeeType() {
        Query getEmployeeTypeQuery = em.createQuery("from " + EmployeeType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", EmployeeType.EMPLOYEE);
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (EmployeeType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            EmployeeType employeetype = new EmployeeType();
            employeetype.setName(EmployeeType.EMPLOYEE);
            employeetype.setDescription("SSTECH Consultant Employee");
            return em.merge(employeetype);
        }
    }

    protected ExpenseCategory getHotelExpenseCategory() {
        ExpenseCategory travelCategory = QueryUtils.findEntity(em, ExpenseCategory.class, "name", "Hotel");
        if (travelCategory == null) {
            ExpenseCategory employeetype = new ExpenseCategory();
            employeetype.setName("Hotel");
            employeetype.setDescription("Hotel Expenses");
            return em.merge(employeetype);
        } else {
            return travelCategory;
        }
    }

    protected ExpenseCategory getAirFareExpenseCategory() {
        ExpenseCategory perdiemCategory = QueryUtils.findEntity(em, ExpenseCategory.class, "name", "AirFare");
        if (perdiemCategory == null) {
            ExpenseCategory employeetype = new ExpenseCategory();
            employeetype.setName("AirFare");
            employeetype.setDescription("Air Fare Expenses");
            return em.merge(employeetype);
        } else {
            return perdiemCategory;
        }
    }

    protected ExpenseCategory getAutoExpenseCategory() {
        ExpenseCategory travelCategory = QueryUtils.findEntity(em, ExpenseCategory.class, "name", "Auto");
        if (travelCategory == null) {
            ExpenseCategory employeetype = new ExpenseCategory();
            employeetype.setName("Auto");
            employeetype.setDescription("Auto Rental Tolls, parking Taxi, Gas Expenses");
            return em.merge(employeetype);
        } else {
            return travelCategory;
        }
    }

    protected ExpenseCategory getClientExpenseCategory() {
        ExpenseCategory travelCategory = QueryUtils.findEntity(em, ExpenseCategory.class, "name", "ClientEntertainment");
        if (travelCategory == null) {
            ExpenseCategory employeetype = new ExpenseCategory();
            employeetype.setName("ClientEntertainment");
            employeetype.setDescription("Client Entertainment Expenses");
            return em.merge(employeetype);
        } else {
            return travelCategory;
        }
    }

    protected ExpenseCategory getMisExpenseCategory() {
        ExpenseCategory travelCategory = QueryUtils.findEntity(em, ExpenseCategory.class, "name", "Miscellaneous");
        if (travelCategory == null) {
            ExpenseCategory employeetype = new ExpenseCategory();
            employeetype.setName("Miscellaneous");
            employeetype.setDescription("Miscellaneous Expenses");
            return em.merge(employeetype);
        } else {
            return travelCategory;
        }
    }

    protected ExpenseCategory getGeneralCategory() {
        ExpenseCategory travelCategory = QueryUtils.findEntity(em, ExpenseCategory.class, "name", "General");
        if (travelCategory == null) {
            ExpenseCategory employeetype = new ExpenseCategory();
            employeetype.setName("General");
            employeetype.setDescription("General Expenses");
            return em.merge(employeetype);
        } else {
            return travelCategory;
        }
    }

    protected ExpenseCategory getPersonalAutoCategory() {
        ExpenseCategory travelCategory = QueryUtils.findEntity(em, ExpenseCategory.class, "name", "Personal Auto");
        if (travelCategory == null) {
            ExpenseCategory employeetype = new ExpenseCategory();
            employeetype.setName("Personal Auto");
            employeetype.setDescription("PesronalAuto Expenses");
            return em.merge(employeetype);
        } else {
            return travelCategory;
        }
    }

    protected CompanyContactType getCompanyContactReportsTo() {
        Query getEmployeeTypeQuery = em.createQuery("from " + CompanyContactType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", "Reports_To");
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (CompanyContactType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            CompanyContactType CompanyContact = new CompanyContactType();
            CompanyContact.setName("Reports_To");
            CompanyContact.setDescription("Reports_To Manager");
            return em.merge(CompanyContact);
        }
    }

    protected CompanyContactType getCompanyContactsupervisor() {
        Query getEmployeeTypeQuery = em.createQuery("from " + CompanyContactType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", "Supervisor");
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (CompanyContactType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            CompanyContactType CompanyContact = new CompanyContactType();
            CompanyContact.setName("Supervisor");
            CompanyContact.setDescription("Supervisor");
            return em.merge(CompanyContact);
        }
    }

    protected CompanyContactType getCompanyContactPerf() {
        Query getEmployeeTypeQuery = em.createQuery("from " + CompanyContactType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", "Perf_Eval_Manager");
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (CompanyContactType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            CompanyContactType CompanyContact = new CompanyContactType();
            CompanyContact.setName("Perf_Eval_Manager");
            CompanyContact.setDescription("Perf_Eval_Manager");
            return em.merge(CompanyContact);
        }
    }

    public EmergencyContact userEmergencyContact() {
        Phone userECPhone = new Phone();
        userECPhone.setPhoneNumber("1212121211");
        userECPhone = em.merge(userECPhone);

        Email userECEmail = new Email();
        userECEmail.setEmail("userec@yopmail.com");
        userECEmail.setPrimaryEmail(true);
        userECEmail = em.merge(userECEmail);

        Contact userEmergencyContact = new Contact();
        userEmergencyContact.setFirstName("user emergency contact");
        userEmergencyContact.setLastName("user emergency contact last name");
        userEmergencyContact.setSex(Sex.MALE);
        userEmergencyContact.addPhone(userECPhone);
        userEmergencyContact.addEmail(userECEmail);
        userEmergencyContact = em.merge(userEmergencyContact);

        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setContact(userEmergencyContact);
        emergencyContact.setEcPrimary(true);
        emergencyContact.setRelation("Wife");
        return em.merge(emergencyContact);
    }

    public Client techSysClient() {
        Client techSysClient = new Client();
        techSysClient.setName("Tech Systems");

        techSysClient.setClientStatus(ClientStatus.ACTIVE);
        Address clientLocation = new Address();
        clientLocation.setStreet1("2110 wilkes ct");
        clientLocation.setState("AL");
        clientLocation.setCity("Herndon");
        clientLocation.setCountry("USA");
        clientLocation.setZip("123456");

        techSysClient.addLocations(clientLocation);

        Contact clientContact = new Contact();
        clientContact.setFirstName("Client Contact");
        clientContact.setLastName("Client Contact");
        techSysClient.addContact(clientContact);

        Project techSysProj1 = new Project();
        techSysProj1.setName("ecomm project");
        techSysProj1.setStartDate(DateUtils.getNextMonth(new Date(), -6));
        techSysProj1.setEndDate(DateUtils.getNextMonth(new Date(), 6));
//        techSysClient.addProject(techSysProj1);
        techSysProj1.setClient(techSysClient);

        StatementOfWork techSysSow1 = new StatementOfWork();
        techSysSow1.setName("Tech Systems-ecomm proj--sow1");
        techSysSow1.setStartDate(new Date());
        techSysSow1.setEndDate(DateUtils.getNextMonth(new Date(), -3));
        techSysSow1.setBillRate(new BigDecimal("100.00"));
        techSysProj1.addSOW(techSysSow1);

        return em.merge(techSysClient);
    }

    public Vendor techSysVendor() {
        Vendor techSysVendor = new Vendor();
        techSysVendor.setName("Sstech");
        techSysVendor.setMsaValDate(new Date());
        techSysVendor.setMsaExpDate(DateUtils.getNextWeek(new Date(), 1));
        techSysVendor.setVendorStatus(VendorStatus.ACTIVE);

        Address vendorLocation = new Address();
        vendorLocation.setStreet1("2110 wilkes ct");
        vendorLocation.setState("AL");
        vendorLocation.setCity("Herndon");
        vendorLocation.setCountry("USA");
        vendorLocation.setZip("123456");

        techSysVendor.addLocations(vendorLocation);

        Contact vendorContact = new Contact();
        vendorContact.setFirstName("Vendor Contact");
        vendorContact.setLastName("Vendor Contact");
        techSysVendor.addContact(vendorContact);

        Contact accountPayContact = new Contact();
        accountPayContact.setFirstName("Vendor AccPay Contact");
        accountPayContact.setLastName("Vendor AccPay Contact");
        techSysVendor.addAcctPayContact(accountPayContact);

        return em.merge(techSysVendor);
    }

    public Subcontractor sstechSubcontractor() {
        Subcontractor subcntr = new Subcontractor();
        subcntr.setName("sstech sub contractor");
        subcntr.setSubcontractorStatus(SubcontractorStatus.ACTIVE);

        Contact subcontractorContact = new Contact();
        subcontractorContact.setFirstName("Subcontractor Contact");
        subcontractorContact.setLastName("Subcontractor Contact");
        subcntr.addContact(subcontractorContact);

        return em.merge(subcntr);
    }

    protected void userUser() {
        if (EntityQueryUtils.findEntity(em, CUser.class, "username", "useruser") == null) {
            CUser user = new CUser();
            user.setUsername("useruser");
            user.setPasswordHash(SecurityUtils.encodePassword("useruser", null));
            user.addRole(OfficeSecurityService.instance().getRole(OfficeRole.ROLE_USER));
            user.setEnabled(true);
            userUser = em.merge(user);
        }
    }

    protected void userAdmin() {
        if (EntityQueryUtils.findEntity(em, CUser.class, "username", "adminadmin") == null) {
            CUser user = new CUser();
            user.setUsername("adminadmin");
            user.setPasswordHash(SecurityUtils.encodePassword("adminadmin", null));
            user.setEnabled(true);
            for (OfficeRole role : OfficeRole.values()) {
                user.addRole(OfficeSecurityService.instance().getRole(role));
            }
            adminUser = em.merge(user);
        }
    }

    protected void userRohan() {
        if (EntityQueryUtils.findEntity(em, CUser.class, "username", "racharya") == null) {
            CUser user = new CUser();
            user.setUsername("racharya");
            user.setPasswordHash(SecurityUtils.encodePassword("racharya", null));
            user.addRole(OfficeSecurityService.instance().getRole(OfficeRole.ROLE_USER));
            user.setEnabled(true);
            rohanUser = em.merge(user);
        }
    }

    protected void userPavan() {
        if (EntityQueryUtils.findEntity(em, CUser.class, "username", "padapala") == null) {
            CUser user = new CUser();
            user.setUsername("padapala");
            user.setPasswordHash(SecurityUtils.encodePassword("padapala", null));
            user.addRole(OfficeSecurityService.instance().getRole(OfficeRole.ROLE_USER));
            user.setEnabled(true);
            pavanUser = em.merge(user);
        }
    }

    protected void userShristi() {
        if (EntityQueryUtils.findEntity(em, CUser.class, "username", "sadhikari") == null) {
            CUser user = new CUser();
            user.setUsername("sadhikari");
            user.setPasswordHash(SecurityUtils.encodePassword("sadhikari", null));
            user.addRole(OfficeSecurityService.instance().getRole(OfficeRole.ROLE_USER));
            user.setEnabled(true);
            shristiUser = em.merge(user);
        }
    }
}
