/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.commons.DateUtils;
import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Repository
@Scope("prototype")
public class OutOfOfficeDao extends CRUDDao<OutOfOfficeRequest> {
    
    private final static Logger logger = Logger.getLogger(OutOfOfficeDao.class.getName());

    @PersistenceContext
    protected EntityManager em;

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, key = "{#root.methodName,#start,#limit}")
    public List<OutOfOfficeRequest> query(int start, int limit) {
        TypedQuery<OutOfOfficeRequest> findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName(), entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Cacheable(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, key = "{#root.methodName,#employeeId,#start,#limit}")
    public List<OutOfOfficeRequest> queryForEmployee(Long employeeId, Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam ", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    public List<OutOfOfficeRequest> queryForCurrentWeekRequests(Integer start, Integer limit) {
        TypedQuery<OutOfOfficeRequest> query = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where (startDate <=:dateRangeEndParam ) and (endDate >=:dateRangeStartParam))", entityCls);
        query.setParameter("dateRangeStartParam", DateUtils.getNextDay(new Date(), -3), TemporalType.DATE);
        query.setParameter("dateRangeEndParam", DateUtils.getNextDay(new Date(), 3), TemporalType.DATE);
        return query.getResultList();
    }

    @Cacheable(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, key = "{#root.methodName,#employeeId}")
    public Long size(Long employeeId) {
        TypedQuery<Long> findAllQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam", Long.class);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        return findAllQuery.getSingleResult();
    }

    public OutOfOfficeDao() {
        super(OutOfOfficeRequest.class);
    }

    @Override
    @CacheEvict(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, allEntries = true)
    public OutOfOfficeRequest save(OutOfOfficeRequest entity) {
        return super.save(entity);
    }

    public static OutOfOfficeDao instance() {
        return SpringContext.getBean(OutOfOfficeDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public javax.persistence.Query getSearchQuery(EntityManager em, OutOfOfficeRequest entity) {
        String queryStr = createSearchQuery(entity);
        javax.persistence.Query query = em.createQuery(queryStr);
        query = getReportQueryWithParams(queryStr, query, entity);
        return query;
    }
    
    private Query getReportQueryWithParams(String qryStr, Query query, OutOfOfficeRequest entity) {
        if (qryStr.contains("startDateParam")) {
            query.setParameter("startDateParam", entity.getStartDate(), TemporalType.DATE);
        }
        if (qryStr.contains("endDateParam")) {
            query.setParameter("endDateParam", entity.getEndDate(), TemporalType.DATE);
        }
        if (qryStr.contains("statusParam")) {
            query.setParameter("statusParam", entity.getStatus().toString().trim());
        }
        if (qryStr.contains("outOfOfficeTypeParam")) {
            query.setParameter("outOfOfficeTypeParam", entity.getOutOfOfficeType().toString().trim());
        }
        if (qryStr.contains("firstNameParam")) {
            query.setParameter("firstNameParam", entity.getEmployee().getFirstName().trim());
        }
        if (qryStr.contains("lastNameParam")) {
            query.setParameter("lastNameParam", entity.getEmployee().getLastName().trim());
        }
        return query;
    }
    
    private String createSearchQuery(OutOfOfficeRequest entity) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT ").append("outOfOfficeRequest").append(" FROM ").append(OutOfOfficeRequest.class.getCanonicalName()).append(" ").append("outOfOfficeRequest");
        sb.append(" , ");
        sb.append(Employee.class.getCanonicalName()).append(" employee WHERE outofofficerequest.employee.id=employee.id");
        
        if (entity.getStartDate() != null) {
            sb.append(" AND startDate BETWEEN :startDateParam AND :endDateParam");
        }
        if (entity.getEndDate() != null) {
            sb.append(" OR endDate BETWEEN :startDateParam AND :endDateParam)");
        }
        if (entity.getStatus() != null) {
            sb.append(" AND status LIKE :statusParam ");
        }
        if (entity.getOutOfOfficeType()!= null) {
            sb.append(" AND outOfOfficeType LIKE :outOfOfficeTypeParam ");
        }
        if (entity.getEmployee() != null) {
            if(entity.getEmployee().getFirstName() != null){
                sb.append(" AND employee.firstName LIKE :firstNameParam ");
            }
            if(entity.getEmployee().getLastName() != null){
                sb.append(" AND employee.lastName LIKE :lastNameParam ");
            }
        }
        logger.info("search query : " + sb.toString());
        return sb.toString();
    }

}
