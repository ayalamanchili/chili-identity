package info.yalamanchili.office.jrs;

import static info.yalamanchili.office.init.JPAUtils.findEntity;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.security.CRole;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.jms.MessagingService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("/admin")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
@Scope("request")
public class AdminResource {

	@Autowired
	protected SecurityService securityService;

	@Autowired
	protected Mapper mapper;

	@Autowired
	MessagingService messagingService;

	@Autowired
	public EmployeeDao employeeDao;

	@PersistenceContext
	EntityManager em;

	@Path("/login")
	@PUT
	public CUser login(CUser user) {
		return securityService.login(user);
	}

	@Path("/createuser")
	@PUT
	public void createUser(CUser user) {
		user.addRole((CRole) findEntity(em, CRole.class, "rolename", "ROLE_USER"));
		user.setEmployee(em.merge(user.getEmployee()));
		em.merge(user);
	}

	@Path("/test")
	@GET
	public void test() {
		messagingService.sendEmail("asdf@gmail.com", "asdf");
	}

}
