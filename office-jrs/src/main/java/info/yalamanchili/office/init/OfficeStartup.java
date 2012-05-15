package info.yalamanchili.office.init;

import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
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

		userUser();
		userAdmin();
	}

	/**
	 * 
	 */
	protected void initTestData() {
		// Employee
		Employee joeFullerEmp = new Employee();
		joeFullerEmp.setFirstName("joe");
		joeFullerEmp.setLastName("fuller");
		joeFullerEmp.setSex(Sex.MALE);
		joeFullerEmp.setSsn("123456789");
		joeFullerEmp.setStartDate(new Date());

		Address joeFullerAddress = new Address();
		joeFullerAddress.setAddressType(getHomeAddressType());
		joeFullerAddress.setStreet1("2110 wilkes ct");
		joeFullerAddress.setStreet2("apt 123");
		joeFullerAddress.setCity("Herndon");
		joeFullerAddress.setState("Virginia");
		joeFullerAddress.setCountry("USA");

		Email joeFullerPrimaryEmail = new Email();
		joeFullerPrimaryEmail.setEmailType(getPrimaryEmailType());
		joeFullerPrimaryEmail.setEmail("joefuller@gmail.com");

		Email joeFullerSecondaryEmail = new Email();
		joeFullerSecondaryEmail.setEmailType(getSecondaryEmailType());
		joeFullerSecondaryEmail.setEmail("joefullerSecondary@gmail.com");

		Phone joeFullerCellPhone = new Phone();
		joeFullerCellPhone.setPhoneNumber("7031112222");
		joeFullerCellPhone.setPhoneType(getCellPhoneType());

		joeFullerEmp.addPhone(joeFullerCellPhone);
		joeFullerEmp.addAddress(joeFullerAddress);
		joeFullerEmp.addEmail(joeFullerPrimaryEmail);
		joeFullerEmp.addEmail(joeFullerSecondaryEmail);
		joeFullerEmp = em.merge(joeFullerEmp);
		userUser().setContact(joeFullerEmp);
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
