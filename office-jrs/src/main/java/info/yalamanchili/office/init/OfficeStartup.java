package info.yalamanchili.office.init;

import info.chili.spring.SpringContext;
import info.yalamanchili.commons.DateUtils;
import info.yalamanchili.commons.EntityQueryUtils;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Certification;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.Skill;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.security.CRole;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.entity.social.Post;
import info.yalamanchili.office.OfficeRoles;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OfficeStartup {

    @PersistenceContext
    protected EntityManager em;
    protected CUser userUser;
    protected CUser adminUser;
    protected CRole userRole;
    protected CRole hrRole;
    protected CRole adminRole;
    protected CRole recruiterRole;
    protected CRole accountantRole;
    protected CRole payrollRole;

    protected void startup() {
        OfficeServiceConfiguration config = (OfficeServiceConfiguration) SpringContext.getBean("officeServiceConfiguration");
        if (config.getInitRefData()) {
            initRoles();
            initUsers();
            initRefData();
            initTestData();
        }
    }

    protected void initRoles() {
        userRole();
        adminRole();
        hrRole();
        recruiterRole();
        expenseRole();
        payrollRole();
    }

    protected void initUsers() {
        userUser();
        userAdmin();
    }

    /**
     *
     */
    protected void initTestData() {

        Company c1 = new Company();
        c1.setName("sstech");
        c1 = em.merge(c1);


        // User Employee
        Employee userEmp = new Employee();
        userEmp.setEmployeeId("uuser");
        userEmp.setFirstName("user");
        userEmp.setLastName("user");
        userEmp.setDateOfBirth(DateUtils.getNextYear(new Date(), -1));
        userEmp.setSex(Sex.MALE);
        userEmp.setStartDate(new Date());
        userEmp.setEmployeeType(getInternalEmployeeType());

        Address userAddress = new Address();
        userAddress.setAddressType(getHomeAddressType());
        userAddress.setStreet1("2110 wilkes ct");
        userAddress.setStreet2("apt 123");
        userAddress.setCity("Herndon");
        userAddress.setState("VA");
        userAddress.setCountry("USA");

        Email userPrimaryEmail = new Email();
        userPrimaryEmail.setEmailType(getWorkEmailType());
        userPrimaryEmail.setPrimaryEmail(true);
        userPrimaryEmail.setEmail("prasanthissv@gmail.com");

        Email userSecondaryEmail = new Email();
        userSecondaryEmail.setPrimaryEmail(false);
        userSecondaryEmail.setEmailType(getPersonalEmailType());
        userSecondaryEmail.setEmail("user_secondary@gmail.com");

        Phone userCellPhone = new Phone();
        userCellPhone.setPhoneNumber("7031112222");
        userCellPhone.setPhoneType(getCellPhoneType());

        userEmp.addPhone(userCellPhone);
        userEmp.addAddress(userAddress);
        userEmp.addEmail(userPrimaryEmail);
        userEmp.addEmail(userSecondaryEmail);
        userEmp.addClientInformation(userClientInfo());
        userEmp.addEmergencyContact(userEmergencyContact());
        userEmp = em.merge(userEmp);

        userUser.setEmployee(userEmp);
        userUser = em.merge(userUser);
        // Admin Employee
        Employee adminEmp = new Employee();
        adminEmp.setEmployeeId("aadmin");
        adminEmp.setFirstName("admin");
        adminEmp.setLastName("admin");
        adminEmp.setDateOfBirth(DateUtils.getNextYear(new Date(), -3));
        adminEmp.setSex(Sex.FEMALE);
        adminEmp.setStartDate(new Date());
        adminEmp.setEmployeeType(getConsultantEmployeeType());

        Address adminAddress = new Address();
        adminAddress.setAddressType(getOfficeAddressType());
        adminAddress.setStreet1("2110 wilkes ct");
        adminAddress.setStreet2("apt 123");
        adminAddress.setCity("Herndon");
        adminAddress.setState("VA");
        adminAddress.setCountry("USA");

        Email adminPrimaryEmail = new Email();
        adminPrimaryEmail.setEmailType(getWorkEmailType());
        adminPrimaryEmail.setPrimaryEmail(true);

        adminPrimaryEmail.setEmail("prasanthi.p@sstech.mobi");

        Email adminSecondaryEmail = new Email();
        adminSecondaryEmail.setEmailType(getPersonalEmailType());
        adminSecondaryEmail.setPrimaryEmail(false);
        adminSecondaryEmail.setEmail("anu@yalamanchili.info");

        Phone adminCellPhone = new Phone();
        adminCellPhone.setPhoneNumber("7038889999");
        adminCellPhone.setPhoneType(getCellPhoneType());

        adminEmp.addPhone(adminCellPhone);
        adminEmp.addAddress(adminAddress);
        adminEmp.addEmail(adminPrimaryEmail);
        adminEmp.addEmail(adminSecondaryEmail);
        adminEmp = em.merge(adminEmp);

        adminUser.setEmployee(adminEmp);
        adminUser = em.merge(adminUser);

        SkillSet userSkillSet = new SkillSet();
        userSkillSet.setLastUpdated(new Date());
        userSkillSet.setResumeUrl("ResumeURL");
        userSkillSet.getCertifications().add(getDOTNETCertification());
        userSkillSet.getSkills().add(getJavaSkill());
        userSkillSet.getSkills().add(getDOTNETSkill());
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
        userPost2.setCompany(c1);
        userPost2 = em.merge(userPost2);

    }

    protected void initRefData() {
        // Address Types
        getHomeAddressType();
        // Email Types
        getWorkEmailType();
        getPersonalEmailType();
        // Phone Types
        getCellPhoneType();
        getHomePhoneType();
        //Skills
        getJavaSkill();
        getDOTNETSkill();
        //Certifications
        getJAVACertification();
        getDOTNETCertification();
        //Employee Type
        getInternalEmployeeType();
        getConsultantEmployeeType();
    }

    protected AddressType getHomeAddressType() {
        Query getAddressType = em.createQuery("from " + AddressType.class.getCanonicalName()
                + " where addressType=:addressTypeParam");
        getAddressType.setParameter("addressTypeParam", "HOME");
        if (getAddressType.getResultList().size() > 0) {
            return (AddressType) getAddressType.getResultList().get(0);
        } else {
            AddressType homeAddressType = new AddressType();
            homeAddressType.setAddressType("HOME");
            return em.merge(homeAddressType);
        }
    }

    protected AddressType getOfficeAddressType() {
        Query getAddressType = em.createQuery("from " + AddressType.class.getCanonicalName()
                + " where addressType=:addressTypeParam");
        getAddressType.setParameter("addressTypeParam", "OFFICE");
        if (getAddressType.getResultList().size() > 0) {
            return (AddressType) getAddressType.getResultList().get(0);
        } else {
            AddressType officeAddressType = new AddressType();
            officeAddressType.setAddressType("OFFICE");
            return em.merge(officeAddressType);
        }
    }

    protected EmailType getWorkEmailType() {
        Query getEmailType = em.createQuery("from " + EmailType.class.getCanonicalName()
                + " where emailType=:emailTypeParam");
        getEmailType.setParameter("emailTypeParam", "WORK");
        if (getEmailType.getResultList().size() > 0) {
            return (EmailType) getEmailType.getResultList().get(0);
        } else {
            EmailType homeEmailType = new EmailType();
            homeEmailType.setEmailType("WORK");
            return em.merge(homeEmailType);
        }
    }

    protected EmailType getPersonalEmailType() {
        Query getEmailType = em.createQuery("from " + EmailType.class.getCanonicalName()
                + " where emailType=:emailTypeParam");
        getEmailType.setParameter("emailTypeParam", "PERSONAL");
        if (getEmailType.getResultList().size() > 0) {
            return (EmailType) getEmailType.getResultList().get(0);
        } else {
            EmailType homeEmailType = new EmailType();
            homeEmailType.setEmailType("PERSONAL");
            return em.merge(homeEmailType);
        }
    }

    protected PhoneType getCellPhoneType() {
        Query getCellPhoneType = em.createQuery("from " + PhoneType.class.getCanonicalName()
                + " where phoneType=:phoneTypeParam");
        getCellPhoneType.setParameter("phoneTypeParam", "CELL");
        if (getCellPhoneType.getResultList().size() > 0) {
            return (PhoneType) getCellPhoneType.getResultList().get(0);
        } else {
            PhoneType cellPhoneType = new PhoneType();
            cellPhoneType.setPhoneType("CELL");
            return em.merge(cellPhoneType);
        }
    }

    protected PhoneType getHomePhoneType() {
        Query getHomePhoneType = em.createQuery("from " + PhoneType.class.getCanonicalName()
                + " where phoneType=:phoneTypeParam");
        getHomePhoneType.setParameter("phoneTypeParam", "HOME");
        if (getHomePhoneType.getResultList().size() > 0) {
            return (PhoneType) getHomePhoneType.getResultList().get(0);
        } else {
            PhoneType cellPhoneType = new PhoneType();
            cellPhoneType.setPhoneType("HOME");
            return em.merge(cellPhoneType);
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

    protected EmployeeType getInternalEmployeeType() {
        Query getEmployeeTypeQuery = em.createQuery("from " + EmployeeType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", "INTERNAL");
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (EmployeeType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            EmployeeType employeetype = new EmployeeType();
            employeetype.setName("INTERNAL");
            employeetype.setDescription("SSTECH Internal Employee");
            return em.merge(employeetype);
        }
    }

    protected EmployeeType getConsultantEmployeeType() {
        Query getEmployeeTypeQuery = em.createQuery("from " + EmployeeType.class.getCanonicalName()
                + " where name=:nameParam");
        getEmployeeTypeQuery.setParameter("nameParam", "CONSULTANT");
        if (getEmployeeTypeQuery.getResultList().size() > 0) {
            return (EmployeeType) getEmployeeTypeQuery.getResultList().get(0);
        } else {
            EmployeeType employeetype = new EmployeeType();
            employeetype.setName("CONSULTANT");
            employeetype.setDescription("SSTECH Consultant Employee");
            return em.merge(employeetype);
        }
    }

    public ClientInformation userClientInfo() {
        Phone userClientInfoContactPhone = new Phone();
        userClientInfoContactPhone.setPhoneNumber("1313131313");
        userClientInfoContactPhone = em.merge(userClientInfoContactPhone);

        Email userReportsToEmail = new Email();
        userReportsToEmail.setEmail("userreportsto@email.com");
        userReportsToEmail.setPrimaryEmail(true);

        Contact userClientInfoContact = new Contact();
        userClientInfoContact.setFirstName("user reports to");
        userClientInfoContact.setLastName("user reports to last name");
        userClientInfoContact.setSex(Sex.MALE);
        userClientInfoContact.addPhone(userClientInfoContactPhone);
        userClientInfoContact.addEmail(userReportsToEmail);
        userClientInfoContact = em.merge(userClientInfoContact);

        ClientInformation clientInfo = new ClientInformation();
        clientInfo.setContact(userClientInfoContact);
        clientInfo.setRtPrimary(true);
        clientInfo.setReportsToRole("Manager");
        clientInfo.setConsultantJobTitle("QA Qngineer");
        return em.merge(clientInfo);
    }

    public EmergencyContact userEmergencyContact() {
        Phone userECPhone = new Phone();
        userECPhone.setPhoneNumber("1212121211");
        userECPhone = em.merge(userECPhone);

        Email userECEmail = new Email();
        userECEmail.setEmail("userec@gmail.com");
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

    public void userRole() {
        if (EntityQueryUtils.findEntity(em, CRole.class, "rolename", OfficeRoles.ROLE_USER) == null) {
            CRole role = new CRole();
            role.setRolename(OfficeRoles.ROLE_USER);
            userRole = em.merge(role);
        }
    }

    public void hrRole() {
        if (EntityQueryUtils.findEntity(em, CRole.class, "rolename", OfficeRoles.ROLE_HR) == null) {
            CRole role = new CRole();
            role.setRolename(OfficeRoles.ROLE_HR);
            hrRole = em.merge(role);
        }
    }

    public void adminRole() {
        if (EntityQueryUtils.findEntity(em, CRole.class, "rolename", OfficeRoles.ROLE_ADMIN) == null) {
            CRole role = new CRole();
            role.setRolename(OfficeRoles.ROLE_ADMIN);
            adminRole = em.merge(role);
        }
    }

    public void recruiterRole() {
        if (EntityQueryUtils.findEntity(em, CRole.class, "rolename", OfficeRoles.ROLE_RECRUITER) == null) {
            CRole role = new CRole();
            role.setRolename(OfficeRoles.ROLE_RECRUITER);
            recruiterRole = em.merge(role);
        }
    }

    public void expenseRole() {
        if (EntityQueryUtils.findEntity(em, CRole.class, "rolename", OfficeRoles.ROLE_EXPENSE) == null) {
            CRole role = new CRole();
            role.setRolename(OfficeRoles.ROLE_EXPENSE);
            accountantRole = em.merge(role);
        }
    }

    public void payrollRole() {
        if (EntityQueryUtils.findEntity(em, CRole.class, "rolename", OfficeRoles.ROLE_TIME) == null) {
            CRole role = new CRole();
            role.setRolename(OfficeRoles.ROLE_TIME);
            payrollRole = em.merge(role);
        }
    }

    protected void userUser() {
        if (EntityQueryUtils.findEntity(em, CUser.class, "username", "useruser") == null) {
            CUser user = new CUser();
            user.setUsername("useruser");
            user.setPasswordHash("useruser");
            user.addRole(userRole);
            user.setEnabled(true);
            userUser = em.merge(user);
        }
    }

    protected void userAdmin() {
        if (EntityQueryUtils.findEntity(em, CUser.class, "username", "adminadmin") == null) {
            CUser user = new CUser();
            user.setUsername("adminadmin");
            user.setPasswordHash("adminadmin");
            user.setEnabled(true);
            user.addRole(userRole);
            user.addRole(adminRole);
            user.addRole(recruiterRole);
            user.addRole(accountantRole);
            adminUser = em.merge(user);
        }
    }
}
