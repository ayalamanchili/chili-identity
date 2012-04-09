/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ayalamanchili
 */
public abstract class CRUDDao<T> {

    protected Class entityCls;

    public CRUDDao(Class cls) {
        this.entityCls = cls;
    }

    public T findById(Long id) {
        return (T) getEntityManager().find(entityCls, id);
    }

    public List<T> query(int start, int limit) {
        Query findAllQuery = getEntityManager().createQuery(
                "from " + entityCls.getCanonicalName(), entityCls);
        return findAllQuery.getResultList();
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
