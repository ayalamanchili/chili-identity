/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.benefit;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.benefits.BenefitEnrollment;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Benarji.v
 */
@Repository
@Scope("prototype")
public class BenefitEnrollmentDao extends CRUDDao<BenefitEnrollment> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public BenefitEnrollment save(BenefitEnrollment entity) {
        entity = super.save(entity);
        return entity;
    }

    public BenefitEnrollmentDao() {
        super(BenefitEnrollment.class);
    }

    public static BenefitEnrollmentDao instance() {
        return SpringContext.getBean(BenefitEnrollmentDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
