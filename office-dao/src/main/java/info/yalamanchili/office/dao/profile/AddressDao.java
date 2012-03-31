/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */
package info.yalamanchili.office.dao.profile;

import info.yalamanchili.dao.AbstractDao;
import info.yalamanchili.office.entity.profile.Address;

import java.util.List;

import javax.persistence.EntityManager;
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
	protected EntityManager em;

	@Override
	public void delete(long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Address findById(Long id) {
		return em.find(Address.class, id);
	}

	@Override
	public List<Address> query(int start, int limit) {
		Query findAllQuery = em.createQuery(
				"from " + Address.class.getCanonicalName(), Address.class);
		return findAllQuery.getResultList();
	}

	@Override
	public void save(Address address) {
		em.merge(address);
	}

	@Override
	public Long size() {
		// TODO Auto-generated method stub
		return null;
	}

}
