package info.yalamanchili.office.jrs.profile;

import info.yalamanchili.office.entity.profile.Address;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/address")
@Produces("application/json")
@Component
public class AddressResource {

	@Autowired
	protected EntityManagerFactory entityManagerFactory;

	@GET
	@Path("/{start}/{limit}")
	public List<Address> readAll(@PathParam("start") int start,
			@PathParam("limit") int limit) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Address address1 = new Address();
		address1.setStreet1("asdf");
		address1.setStreet2("street 3");
		address1 = em.merge(address1);
		em.getTransaction().commit();
		return em.createQuery("from Address").getResultList();
	}
}
