package info.yalamanchili.office.jrs;

import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.Employee;
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
		initUsers();
		initRefData();
		initTestData();
	}

	protected void initUsers() {

		CRole userRole = new CRole();
		userRole.setRolename("ROLE_USER");
		userRole = em.merge(userRole);

		CRole adminRole = new CRole();
		adminRole.setRolename("ROLE_ADMIN");
		adminRole = em.merge(adminRole);

		CUser user = new CUser();
		user.setUsername("user");
		user.setPasswordHash("user");
		user.setEnabled(true);
		user.addRole(userRole);
		em.merge(user);

		CUser admin = new CUser();
		admin.setUsername("admin");
		admin.setPasswordHash("admin");
		admin.setEnabled(true);
		admin.addRole(adminRole);
		em.merge(admin);
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

		Email joeFullerPrimaryEmail = new Email();
		joeFullerPrimaryEmail.setEmailType(getPrimaryEmailType());
		joeFullerPrimaryEmail.setEmail("joefuller@gmail.com");

		Email joeFullerSecondaryEmail = new Email();
		joeFullerSecondaryEmail.setEmailType(getSecondaryEmailType());
		joeFullerSecondaryEmail.setEmail("joefullerSecondary@gmail.com");

		joeFullerEmp.addAddress(joeFullerAddress);
		joeFullerEmp.addEmail(joeFullerPrimaryEmail);
		joeFullerEmp.addEmail(joeFullerSecondaryEmail);
		joeFullerEmp = em.merge(joeFullerEmp);
	}

	protected void initRefData() {
		getHomeAddressType();
		getPrimaryEmailType();
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
}
