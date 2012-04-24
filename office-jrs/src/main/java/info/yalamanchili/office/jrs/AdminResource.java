package info.yalamanchili.office.jrs;

import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.security.CUser;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("/admin")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
public class AdminResource {

	@Autowired
	protected SecurityService securityService;

	@Autowired
	protected Mapper mapper;

	@Path("/login")
	@PUT
	public CUser login(CUser user) {
		return mapper.map(securityService.login(user), CUser.class);
	}
}
