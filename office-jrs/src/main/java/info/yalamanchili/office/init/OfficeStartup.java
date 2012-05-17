package info.yalamanchili.office.init;

import info.yalamanchili.commons.DateUtils;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.EmergencyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
import info.yalamanchili.office.entity.profile.ReportsTo;
import info.yalamanchili.office.entity.profile.Sex;
import info.yalamanchili.office.entity.security.CRole;
import info.yalamanchili.office.entity.security.CUser;

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
		userPrimaryEmail.setEmailType(getPrimaryEmailType());
		userPrimaryEmail.setEmail("user@gmail.com");

		Email userSecondaryEmail = new Email();
		userSecondaryEmail.setEmailType(getSecondaryEmailType());
		userSecondaryEmail.setEmail("user_secondary@gmail.com");

		Phone joeFullerCellPhone = new Phone();
		joeFullerCellPhone.setPhoneNumber("7031112222");
		joeFullerCellPhone.setPhoneType(getCellPhoneType());

		userEmp.addPhone(joeFullerCellPhone);
		userEmp.addAddress(userAddress);
		userEmp.addEmail(userPrimaryEmail);
		userEmp.addEmail(userSecondaryEmail);
		userEmp.addReportsTo(userReportsTo());
		userEmp.addEmergencyContact(userEmergencyContact());
		userEmp = em.merge(userEmp);
		userUser().setEmployee(userEmp);

		// Admin Employee

	}

	protected void initRefData() {
		// Address Types
		getHomeAddressType();
		// Email Types
		getPrimaryEmailType();
		getSecondaryEmailType();
		// Phone Types
		getCellPhoneType();
		getHomePhoneType();
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

	protected EmailType getPrimaryEmailType() {
		Query getEmailType = em.createQuery("from " + EmailType.class.getCanonicalName()
				+ " where emailType=:emailTypeParam");
		getEmailType.setParameter("emailTypeParam", "PRIMARY");
		if (getEmailType.getResultList().size() > 0) {
			return (EmailType) getEmailType.getResultList().get(0);
		} else {
			EmailType homeEmailType = new EmailType();
			homeEmailType.setEmailType("PRIMARY");
			return em.merge(homeEmailType);
		}
	}

	protected EmailType getSecondaryEmailType() {
		Query getEmailType = em.createQuery("from " + EmailType.class.getCanonicalName()
				+ " where emailType=:emailTypeParam");
		getEmailType.setParameter("emailTypeParam", "SECONDARY");
		if (getEmailType.getResultList().size() > 0) {
			return (EmailType) getEmailType.getResultList().get(0);
		} else {
			EmailType homeEmailType = new EmailType();
			homeEmailType.setEmailType("SECONDARY");
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

	public ReportsTo userReportsTo() {
		Contact userReportToContact = new Contact();
		userReportToContact.setFirstName("user reports to");
		userReportToContact.setLastName("user reports to last name");
		userReportToContact.setSex(Sex.MALE);
		userReportToContact = em.merge(userReportToContact);

		ReportsTo reportsTo = new ReportsTo();
		reportsTo.setContact(userReportToContact);
		reportsTo.setRtPrimary(true);
		reportsTo.setReportsToRole("Manager");
		return em.merge(reportsTo);
	}

	public EmergencyContact userEmergencyContact() {
		Contact userEmergencyContact = new Contact();
		userEmergencyContact.setFirstName("user emergency contact");
		userEmergencyContact.setLastName("user emergency contact last name");
		userEmergencyContact.setSex(Sex.MALE);
		userEmergencyContact = em.merge(userEmergencyContact);

		EmergencyContact emergencyContact = new EmergencyContact();
		emergencyContact.setContact(userEmergencyContact);
		emergencyContact.setEcPrimary(true);
		emergencyContact.setRelation("Wife");
		return em.merge(emergencyContact);
	}

	protected <T> T findEntity(Class<?> entity, String paramName, String paramValue) {
		Query query = em.createQuery("from " + entity.getCanonicalName() + " where " + paramName + "='" + paramValue
				+ "'", entity);
		if (query.getResultList().size() > 0) {
			return (T) query.getResultList().get(0);
		} else {
			return null;
		}
	}

	protected CRole userRole() {
		if (findEntity(CRole.class, "rolename", "ROLE_USER") == null) {
			CRole userRole = new CRole();
			userRole.setRolename("ROLE_USER");
			return em.merge(userRole);
		}
		return findEntity(CRole.class, "rolename", "ROLE_USER");
	}

	protected CRole hrRole() {
		if (findEntity(CRole.class, "rolename", "ROLE_HR") == null) {
			CRole userRole = new CRole();
			userRole.setRolename("ROLE_HR");
			return em.merge(userRole);
		}
		return findEntity(CRole.class, "rolename", "ROLE_HR");
	}

	protected CRole accountsRole() {
		if (findEntity(CRole.class, "rolename", "ROLE_ACCOUNTS") == null) {
			CRole userRole = new CRole();
			userRole.setRolename("ROLE_ACCOUNTS");
			return em.merge(userRole);
		}
		return findEntity(CRole.class, "rolename", "ROLE_ACCOUNTS");
	}

	protected CRole adminRole() {
		if (findEntity(CRole.class, "rolename", "ROLE_ADMIN") == null) {
			CRole userRole = new CRole();
			userRole.setRolename("ROLE_ADMIN");
			return em.merge(userRole);
		}
		return findEntity(CRole.class, "rolename", "ROLE_ADMIN");
	}

	protected CUser userUser() {
		if (findEntity(CUser.class, "username", "user") == null) {
			CUser userUser = new CUser();
			userUser.setUsername("user");
			userUser.setPasswordHash("user");
			userUser.addRole(userRole());
			userUser.setEnabled(true);
			return em.merge(userUser);
		}
		return findEntity(CUser.class, "username", "user");
	}

	protected CUser userAdmin() {
		if (findEntity(CUser.class, "username", "admin") == null) {
			CUser userUser = new CUser();
			userUser.setUsername("admin");
			userUser.setPasswordHash("admin");
			userUser.setEnabled(true);
			userUser.addRole(userRole());
			userUser.addRole(adminRole());
			return em.merge(userUser);
		}
		return findEntity(CUser.class, "username", "admin");
	}

}
