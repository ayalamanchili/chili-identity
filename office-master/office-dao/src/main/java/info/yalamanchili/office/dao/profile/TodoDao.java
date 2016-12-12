/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prashanthi
 */
@Repository
@Scope("prototype")
public class TodoDao extends CRUDDao {

    @PersistenceContext
    protected EntityManager em;

    public List<Todo> getToDoSettings(Employee employee) {
        Query q = getEntityManager().createQuery("from " + Todo.class.getCanonicalName() + " where employee=:employeeParam", Todo.class);
        q.setParameter("employeeParam", employee);
        return q.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public TodoDao() {
        super(Todo.class);
    }

    public static TodoDao instance() {
        return SpringContext.getBean(TodoDao.class);
    }
}
