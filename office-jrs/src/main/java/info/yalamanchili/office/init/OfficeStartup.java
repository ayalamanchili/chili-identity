package info.yalamanchili.office.init;

import static info.yalamanchili.commons.EntityQueryUtils.findEntity;
import info.yalamanchili.commons.DateUtils;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Certification;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.profile.Skill;
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.entity.security.CRole;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.entity.social.Post;

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
    
    protected void startup() {
        initRolesAndUsers();
        initRefData();
        initTestData();
    }
    
    protected void initRolesAndUsers() {

        // Roles
        userRole();
        adminRole();
        hrRole();
        accountsRole();
        // users
        userUser();
        userAdmin();
    }

    /**
     *
     */
    protected void initTestData() {
        // User Employee
        Employee userEmp = new Employee();
        userEmp.setFirstName("user");
        userEmp.setLastName("user");
        userEmp.setDateOfBirth(DateUtils.getNextYear(new Date(), -1));
        userEmp.setSex(Sex.MALE);
        userEmp.setSsn("123456789");
        userEmp.setStartDate(new Date());
        
        Address userAddress = new Address();
        userAddress.setAddressType(getHomeAddressType());
        userAddress.setStreet1("2110 wilkes ct");
        userAddress.setStreet2("apt 123");
        userAddress.setCity("Herndon");
        userAddress.setState("Virginia");
        userAddress.setCountry("USA");
        
        Email userPrimaryEmail = new Email();
        userPrimaryEmail.setEmailType(getWorkEmailType());
        userPrimaryEmail.setPrimaryEmail(true);
        userPrimaryEmail.setEmail("user@gmail.com");
        
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
        userUser().setEmployee(userEmp);

        // Admin Employee
        Employee adminEmp = new Employee();
        adminEmp.setFirstName("admin");
        adminEmp.setLastName("admin");
        adminEmp.setDateOfBirth(DateUtils.getNextYear(new Date(), -3));
        adminEmp.setSex(Sex.FEMALE);
        adminEmp.setSsn("123456789");
        adminEmp.setStartDate(new Date());
        
        Address adminAddress = new Address();
        adminAddress.setAddressType(getHomeAddressType());
        adminAddress.setStreet1("2110 wilkes ct");
        adminAddress.setStreet2("apt 123");
        adminAddress.setCity("Herndon");
        adminAddress.setState("Virginia");
        adminAddress.setCountry("USA");
        
        Email adminPrimaryEmail = new Email();
        adminPrimaryEmail.setEmailType(getWorkEmailType());
        adminPrimaryEmail.setPrimaryEmail(true);
        adminPrimaryEmail.setEmail("yphanikumar@gmail.com");
        
        Email adminSecondaryEmail = new Email();
        adminSecondaryEmail.setEmailType(getPersonalEmailType());
        adminSecondaryEmail.setPrimaryEmail(false);
        adminSecondaryEmail.setEmail("admin_secondary@gmail.com");
        
        Phone adminCellPhone = new Phone();
        adminCellPhone.setPhoneNumber("7031112222");
        adminCellPhone.setPhoneType(getCellPhoneType());
        
        adminEmp.addPhone(userCellPhone);
        adminEmp.addAddress(adminAddress);
        adminEmp.addEmail(adminPrimaryEmail);
        adminEmp.addEmail(adminSecondaryEmail);
        adminEmp.addClientInformation(userClientInfo());
        adminEmp.addEmergencyContact(userEmergencyContact());
        adminEmp = em.merge(adminEmp);
        userAdmin().setEmployee(adminEmp);
        
        SkillSet userSkillSet = new SkillSet();
        userSkillSet.setLastUpdated(new Date());
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
    
    public CRole userRole() {
        if (findEntity(em, CRole.class, "rolename", "ROLE_USER") == null) {
            CRole userRole = new CRole();
            userRole.setRolename("ROLE_USER");
            return em.merge(userRole);
        }
        return findEntity(em, CRole.class, "rolename", "ROLE_USER");
    }
    
    public CRole hrRole() {
        if (findEntity(em, CRole.class, "rolename", "ROLE_HR") == null) {
            CRole userRole = new CRole();
            userRole.setRolename("ROLE_HR");
            return em.merge(userRole);
        }
        return findEntity(em, CRole.class, "rolename", "ROLE_HR");
    }
    
    public CRole accountsRole() {
        if (findEntity(em, CRole.class, "rolename", "ROLE_ACCOUNTS") == null) {
            CRole userRole = new CRole();
            userRole.setRolename("ROLE_ACCOUNTS");
            return em.merge(userRole);
        }
        return findEntity(em, CRole.class, "rolename", "ROLE_ACCOUNTS");
    }
    
    public CRole adminRole() {
        if (findEntity(em, CRole.class, "rolename", "ROLE_ADMIN") == null) {
            CRole userRole = new CRole();
            userRole.setRolename("ROLE_ADMIN");
            return em.merge(userRole);
        }
        return findEntity(em, CRole.class, "rolename", "ROLE_ADMIN");
    }
    
    protected CUser userUser() {
        if (findEntity(em, CUser.class, "username", "user") == null) {
            CUser userUser = new CUser();
            userUser.setUsername("user");
            userUser.setPasswordHash("user");
            userUser.addRole(userRole());
            userUser.setEnabled(true);
            return em.merge(userUser);
        }
        return findEntity(em, CUser.class, "username", "user");
    }
    
    protected CUser userAdmin() {
        if (findEntity(em, CUser.class, "username", "admin") == null) {
            CUser userUser = new CUser();
            userUser.setUsername("admin");
            userUser.setPasswordHash("admin");
            userUser.setEnabled(true);
            userUser.addRole(userRole());
            userUser.addRole(adminRole());
            return em.merge(userUser);
        }
        return findEntity(em, CUser.class, "username", "admin");
    }
}
