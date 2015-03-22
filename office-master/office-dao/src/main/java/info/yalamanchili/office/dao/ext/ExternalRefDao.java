/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.ext;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.jpa.AbstractEntity;
import info.chili.jpa.QueryUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.ext.ExternalRef;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayalamanchili
 */
@Repository
@Scope("prototype")
public class ExternalRefDao extends AbstractHandleEntityDao<ExternalRef> {

    @PersistenceContext
    protected EntityManager em;

    public AbstractEntity findReferenceEntity(String externalRefId) {
        ExternalRef externalRef = QueryUtils.findEntity(em, ExternalRef.class, "externalId", externalRefId);
        if (externalRef != null) {
            return em.find(Employee.class, externalRef.getTargetEntityId());
        } else {
            return null;
        }
    }

//    @Transactional(readOnly = true)
//    @Override
//    public AbstractEntity find(Long id, String targetClassName) {
//        TypedQuery<AbstractEntity> query = getEntityManager().createQuery("from " + targetClassName + " where id=:idParam", AbstractEntity.class);
//        query.setParameter("idParam", id);
//        if (query.getResultList().size() > 0) {
//            return query.getResultList().get(0);
//        } else {
//            //TODO throw exception
//            return null;
//        }
//    }
    @Override
    public ExternalRef save(ExternalRef source, AbstractEntity target) {
        return super.save(source, target);
    }

    public ExternalRefDao() {
        super(ExternalRef.class);
    }

    public static ExternalRefDao instance() {
        return SpringContext.getBean(ExternalRefDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
