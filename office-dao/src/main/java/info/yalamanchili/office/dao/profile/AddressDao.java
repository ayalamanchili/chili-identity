/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */
package info.yalamanchili.office.dao.profile;

import info.yalamanchili.dao.AbstractDao;
import info.yalamanchili.office.entity.profile.Address;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@Component
public class AddressDao implements AbstractDao<Address> {

	@PersistenceContext
	protected EntityManagerFactory emf;

	@Override
	public void delete(long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Address findById(Long id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Address.class, id);
	}

	@Override
	public List<Address> query(int start, int limit) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Address address = new Address();
		address.setCity("herndon");
		address.setCountry("usa");
		address.setState("va");
		address.setStreet1("2110 wilkes ct");
		address.setStreet2("apt 103");
		em.merge(address);
		em.getTransaction().commit();
		
		Query findAllQuery = em.createQuery(
				"from " + Address.class.getCanonicalName(), Address.class);
		return findAllQuery.getResultList();
	}

	@Override
	public void save(Address arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long size() {
		// TODO Auto-generated method stub
		return null;
	}

}
