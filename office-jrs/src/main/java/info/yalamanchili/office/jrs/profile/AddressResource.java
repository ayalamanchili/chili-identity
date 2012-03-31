package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.entity.profile.Address;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Path("/address")
@Produces("application/json")
@Consumes("application/json")
@Component
@Transactional
public class AddressResource {

	@Autowired
	protected AddressDao addressDao;

	@GET
	@Path("/{id}")
	public Address read(@PathParam("id") Long id) {
		return addressDao.findById(id);
	}

	@GET
	@Path("/{start}/{limit}")
	public List<Address> readAll(@PathParam("start") int start,
			@PathParam("limit") int limit) {
		return addressDao.query(start, limit);
	}

	@POST
	public void save(Address address) {
		addressDao.save(address);
	}

}
