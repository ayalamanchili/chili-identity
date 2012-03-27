
/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */
package info.yalamanchili.office.dao.profile;

import info.yalamanchili.dao.AbstractDao;
import info.yalamanchili.office.entity.profile.EmployeeType;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ejb.Stateless;
import org.apache.lucene.util.Version;
import info.yalamanchili.commons.DataType;
import info.yalamanchili.commons.ReflectionUtils;
import info.yalamanchili.commons.SearchUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.search.FullTextQuery;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */

@Stateless
public class EmployeeTypeDAO implements AbstractDao<EmployeeType> {

	protected EntityManager em;

	// @Override
	public EmployeeType findById(Long id) {
		return em.find(EmployeeType.class, id);
	}

	// @Override
	public void save(EmployeeType entity) {
		em.merge(entity);
	}

	// @Override
	public void delete(long id) {
		em.remove(id);
	}

	// @Override
	public List<EmployeeType> query(int start, int limit) {
		String query = "from " + EmployeeType.class.getCanonicalName();
		Query getEntitites = em.createQuery(query);
		getEntitites.setFirstResult(start);
		// TODO externalize the max results value
		getEntitites.setMaxResults(limit);
		return getEntitites.getResultList();
	}

	// @Override
	public Long size() {
		String query = "select count(entity) from "
				+ EmployeeType.class.getCanonicalName() + " entity";
		Query getEntitiesSize = em.createQuery(query);
		return (Long) getEntitiesSize.getSingleResult();
	}

	public List<String> getSuggestionsForName(String name, EmployeeType entity) {
		// TODO add GWTServlet Utils
		Query query = em.createQuery("");
		return query.getResultList();
	}

}
