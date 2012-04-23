package info.yalamanchili.office.jrs;

import info.yalamanchili.office.entity.security.CRole;
import info.yalamanchili.office.entity.security.CUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OfficeStartup {

	@PersistenceContext
	protected EntityManager em;

	protected void startup() {
		initUsers();
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

}
