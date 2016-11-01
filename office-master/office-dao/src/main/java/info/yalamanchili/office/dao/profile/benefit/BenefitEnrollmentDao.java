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
import info.yalamanchili.office.dao.profile.insurance.HealthInsuranceWaiverDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.benefits.BenefitEnrollment;
import info.yalamanchili.office.entity.profile.insurance.HealthInsuranceWaiver;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    public BenefitEnrollment findById(Long id) {
        BenefitEnrollment entity = super.findById(id);
        if (entity == null) {
            return null;
        }
        entity.setHealthInsuranceWaiver(HealthInsuranceWaiverDao.instance().find(entity));
        return entity;
    }

//    @Override
//    public BenefitEnrollment save(BenefitEnrollment entity) {
//        HealthInsuranceWaiver healthWaiver = entity.getHealthInsuranceWaiver();
//        entity = super.save(entity);
//        if (healthWaiver != null) {
//            HealthInsuranceWaiverDao.instance().save(healthWaiver, entity);
//        }
//        return entity;
//    }

    public List<BenefitEnrollment> getBenefitEnrollment(Employee emp, int start, int limit) {
        Query query = getEntityManager().createQuery("from " + BenefitEnrollment.class.getCanonicalName() + " benefit where benefit.employee=:employeeParam ", BenefitEnrollment.class);
        query.setParameter("employeeParam", emp);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public Long getBenefitEnrollmentSize(Employee emp, int start, int limit) {
        Query query = getEntityManager().createQuery("select count (*) from " + BenefitEnrollment.class.getCanonicalName() + " benefit where benefit.employee=:employeeParam", Long.class);
        query.setParameter("employeeParam", emp);
        return (Long) query.getSingleResult();

    }

    public List<BenefitEnrollment> queryForEmployee(Long employeeId, Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + BenefitEnrollment.class.getCanonicalName() + " as benefit where benefit.employee.id=:employeeIdParam ", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

}
