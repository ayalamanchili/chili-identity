package info.yalamanchili.office.jrs;

import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.jms.MessagingService;

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

	@Path("/login")
	@PUT
	public CUser login(CUser user) {

		return securityService.login(user);
	}

	@Path("/test")
	@GET
	public void test() {
		messagingService.sendEmail("asdf@gmail.com", "asdf");
	}

}
