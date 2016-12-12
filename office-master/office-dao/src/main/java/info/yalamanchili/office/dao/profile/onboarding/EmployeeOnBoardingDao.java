/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.onboarding;

import com.google.common.base.Strings;
import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
import info.yalamanchili.office.entity.profile.onboarding.OnBoardingStatus;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Madhu.Badiginchala
 */
@Repository
@Scope("prototype")
public class EmployeeOnBoardingDao extends CRUDDao<EmployeeOnBoarding> {

    public EmployeeOnBoardingDao() {
        super(EmployeeOnBoarding.class);
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public EmployeeOnBoarding findByEmail(String email) {
        try {
            TypedQuery<EmployeeOnBoarding> findQuery = em.createQuery("from " + EmployeeOnBoarding.class.getCanonicalName() + " as onboarding where email=:employeeEmailParam  and onboarding.status!='Rejected'", EmployeeOnBoarding.class);
            findQuery.setParameter("employeeEmailParam", email);
            return findQuery.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public EmployeeOnBoarding findByEmployeeId(Long id) {
        TypedQuery<EmployeeOnBoarding> findQuery = em.createQuery("from " + entityCls.getCanonicalName() + " where employee_id=:employeeIdParam", EmployeeOnBoarding.class);
        findQuery.setParameter("employeeIdParam", id);
        List<EmployeeOnBoarding> list = findQuery.getResultList();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public EmployeeOnBoarding findById(Long id) {
        TypedQuery<EmployeeOnBoarding> findQuery = em.createQuery("from " + entityCls.getCanonicalName() + " where id=:employeeIdParam ", EmployeeOnBoarding.class);
        findQuery.setParameter("employeeIdParam", id);
        return findQuery.getSingleResult();
    }

    public List<EmployeeOnBoarding> getEmployees(int start, int limit) {
        TypedQuery<EmployeeOnBoarding> query = em.createQuery("from " + EmployeeOnBoarding.class.getCanonicalName() + " order by startedDate DESC", EmployeeOnBoarding.class);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public List<EmployeeOnBoarding> getSearchOnboarding(EmployeeOnBoardingSearchDto dto) {
        TypedQuery<EmployeeOnBoarding> onboardingSearchQuery = em.createQuery(getSearchQuery(dto), EmployeeOnBoarding.class);
        if (dto.getStartDate() != null) {
            onboardingSearchQuery.setParameter("startDateParam", dto.getStartDate(), TemporalType.DATE);
        }
        return onboardingSearchQuery.getResultList();
    }

    protected String getSearchQuery(EmployeeOnBoardingSearchDto dto) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("SELECT onboarding from ").append(EmployeeOnBoarding.class.getCanonicalName()).append(" as onboarding");
        queryStr.append("  where ");
        if (!Strings.isNullOrEmpty(dto.getEmployeeType())) {
            queryStr.append("lower(onboarding.employee.employeeType.name) = '").append(dto.getEmployeeType().toLowerCase().trim()).append("' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getCompany())) {
            queryStr.append("onboarding.employee.company.name = '").append(dto.getCompany().trim()).append("' ").append(" and ");
        }
        if (!Strings.isNullOrEmpty(dto.getStatus())) {
            queryStr.append("onboarding.status = '").append(dto.getStatus().trim()).append("' ").append(" and ");
        }
        if (dto.getStartDate() != null) {
            queryStr.append("onboarding.startedDate =:startDateParam and '");
        }
        return queryStr.toString().substring(0, queryStr.toString().lastIndexOf("and"));
    }

    public static EmployeeOnBoardingDao instance() {
        return SpringContext.getBean(EmployeeOnBoardingDao.class);
    }

    public List<EmployeeOnBoarding> getOboardingReportsForDates(Date startDate, Date endDate) {
        Query findAllQuery = getEntityManager().createQuery("from " + EmployeeOnBoarding.class.getCanonicalName() + " onboarding where onboarding.status<>:statusParam AND onboarding.startedDate>=:startDateParam AND onboarding.startedDate<=:endDateParam ", entityCls);
        findAllQuery.setParameter("startDateParam", startDate);
        findAllQuery.setParameter("statusParam", OnBoardingStatus.Pending_Initial_Document_Submission);
        findAllQuery.setParameter("endDateParam", endDate);
        return findAllQuery.getResultList();
    }
}
