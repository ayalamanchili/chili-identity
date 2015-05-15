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
import info.yalamanchili.office.entity.profile.EmployeeDocument;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author raghu.l
 */
@Repository
@Scope("prototype")
public class EmployeeDocumentDao extends CRUDDao<EmployeeDocument> {

    public EmployeeDocumentDao() {
        super(EmployeeDocument.class);
    }

    public List<EmployeeDocument> getDocuments(Long employeeId) {
        TypedQuery<EmployeeDocument> query = getEntityManager().createQuery("from " + EmployeeDocument.class.getCanonicalName() + " where employee.id=:employeeIdParam", EmployeeDocument.class);
        query.setParameter("employeeIdParam", employeeId);
        return query.getResultList();
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static EmployeeDocumentDao instance() {
        return SpringContext.getBean(EmployeeDocumentDao.class);
    }
}
