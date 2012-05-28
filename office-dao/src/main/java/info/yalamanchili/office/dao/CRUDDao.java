/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao;

import info.yalamanchili.commons.DataType;
import info.yalamanchili.commons.ReflectionUtils;
import info.yalamanchili.commons.SearchUtils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;
import org.hibernate.search.jpa.FullTextEntityManager;

/**
 * 
 * @author ayalamanchili
 */
public abstract class CRUDDao<T> {

	private static final Log log = LogFactory.getLog(CRUDDao.class);

	protected Class entityCls;

	public CRUDDao(Class cls) {
		this.entityCls = cls;
	}

	public T findById(Long id) {
		return (T) getEntityManager().find(entityCls, id);
	}

	public List<T> query(int start, int limit) {
		Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName(), entityCls);
		findAllQuery.setFirstResult(start);
		findAllQuery.setMaxResults(limit);
		return findAllQuery.getResultList();
	}

	public List<T> queryByParams(int start, int limit, String... params) {
		// TODO implement the query by params
		return query(start, limit);
	}

	// TODO update the depreciated methods
	public List<T> search(String searchText, int start, int limit) {
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
				.createFullTextEntityManager(getEntityManager());
		String[] fields = ReflectionUtils.getBeanProperties(entityCls, DataType.STRING);
		log.info(fields);
		org.apache.lucene.search.Query luceneQuery = SearchUtils.getLuceneQuery(searchText, new StandardAnalyzer(
				Version.LUCENE_30), fields);
		javax.persistence.Query searchQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, entityCls);
		searchQuery.setFirstResult(start);
		searchQuery.setMaxResults(limit);
		return searchQuery.getResultList();
	}

	public T save(T entity) {
		return getEntityManager().merge(entity);
	}

	public void delete(Long id) {
		getEntityManager().remove(findById(id));
	}

	public Long size() {
		Query sizeQuery = getEntityManager().createQuery("select count (*) from " + entityCls.getCanonicalName());
		return (Long) sizeQuery.getSingleResult();
	}

	public abstract EntityManager getEntityManager();
}
