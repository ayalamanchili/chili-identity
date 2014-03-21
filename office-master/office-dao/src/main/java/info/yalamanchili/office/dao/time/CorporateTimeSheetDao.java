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
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anuyalamanchili
 */
@Repository
@Scope("prototype")
public class CorporateTimeSheetDao extends CRUDDao<CorporateTimeSheet> {

    public CorporateTimeSheetDao() {
        super(CorporateTimeSheet.class);
    }

    public void saveTimeSheet(Employee emp, TimeSheetCategory category, BigDecimal hours, Date startDate, Date endDate) {
        if (findTimeSheet(emp, category, hours, startDate, endDate) == null) {
            CorporateTimeSheet ts = new CorporateTimeSheet();
            ts.setEmployee(emp);
            ts.setCategory(category);
            ts.setHours(hours);
            ts.setStatus(TimeSheetStatus.Approved);
            ts.setStartDate(startDate);
            ts.setEndDate(endDate);
            super.save(ts);
        }
    }

    public CorporateTimeSheet findTimeSheet(Employee emp, TimeSheetCategory category, BigDecimal hours, Date startDate, Date endDate) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("from ").append(CorporateTimeSheet.class.getCanonicalName()).append(" where");
        queryStr.append(" category=:categoryParam");
        queryStr.append(" and startDate=:startDateParam");
        queryStr.append(" and endDate=:endDateParam");
        queryStr.append(" and hours=:hoursParam");
        queryStr.append(" and employee=:empParam");
        TypedQuery<CorporateTimeSheet> query = getEntityManager().createQuery(queryStr.toString(), CorporateTimeSheet.class);
        query.setParameter("categoryParam", category);
        query.setParameter("startDateParam", startDate, TemporalType.DATE);
        query.setParameter("endDateParam", endDate, TemporalType.DATE);
        query.setParameter("hoursParam", hours);
        query.setParameter("empParam", emp);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else {
            return null;
        }
    }

    public Long getTimeSheetsSizeForEmployee(Employee employee, TimeSheetStatus status, TimeSheetCategory category) {
        String queryStr = "select count(*) " + getTimeSheetsForEmployeeQuery(employee, status, category);
        Query query = getEntityManager().createQuery(queryStr);
        query.setParameter("employeeParam", employee);
        if (queryStr.contains("statusParam")) {
            query.setParameter("statusParam", status);
        }
        if (queryStr.contains("categoryParam")) {
            query.setParameter("categoryParam", category);
        }
        return (Long) query.getSingleResult();
    }

    public List<CorporateTimeSheet> getTimeSheetsEmployee(Employee employee, TimeSheetStatus status, TimeSheetCategory category, int start, int limit) {
        String queryStr = getTimeSheetsForEmployeeQuery(employee, status, category) + " order by startDate DESC ";
        Query query = getEntityManager().createQuery(queryStr);
        query.setParameter("employeeParam", employee);
        if (queryStr.contains("statusParam")) {
            query.setParameter("statusParam", status);
        }
        if (queryStr.contains("categoryParam")) {
            query.setParameter("categoryParam", category);
        }
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    protected String getTimeSheetsForEmployeeQuery(Employee employee, TimeSheetStatus status, TimeSheetCategory category) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("from ").append(CorporateTimeSheet.class.getCanonicalName()).append(" where employee=:employeeParam");
        if (status != null) {
            queryStr.append(" and status=:statusParam ");
        }
        if (category != null) {
            queryStr.append(" and category=:categoryParam");
        }
        return queryStr.toString();
    }

    public BigDecimal getHoursInCurrentYear(Employee employee, TimeSheetCategory category, TimeSheetStatus status) {
        TypedQuery<BigDecimal> query = getEntityManager().createQuery("select sum(hours) from " + CorporateTimeSheet.class.getCanonicalName() + " where employee=:employeeParam and category =:categoryParam and status=:statusParam and startDate >=:startDateParam and endDate <=:endDateParam", BigDecimal.class);
        query.setParameter("employeeParam", employee);
        query.setParameter("categoryParam", category);
        query.setParameter("statusParam", status);
        query.setParameter("startDateParam", DateUtils.getFirstDayOfCurrentYear(), TemporalType.DATE);
        query.setParameter("endDateParam", DateUtils.getLastDayCurrentOfYear(), TemporalType.DATE);
        if (query.getSingleResult() != null) {
            return query.getSingleResult();
        } else {
            return BigDecimal.ZERO;
        }
    }

    public List<CorporateTimeSheet> getCurrentCompanyLeaves() {
        TypedQuery<CorporateTimeSheet> query = getEntityManager().createQuery("from " + CorporateTimeSheet.class.getCanonicalName() + " where status=:statusParam and category IN (:categoryParam) and ((startDate <=:dateRangeEndParam ) and (endDate >=:dateRangeStartParam))", CorporateTimeSheet.class);
        query.setParameter("statusParam", TimeSheetStatus.Approved);
        query.setParameter("categoryParam", TimeSheetCategory.getLeaveSpentCategories());
        query.setParameter("dateRangeStartParam", DateUtils.getNextDay(new Date(), -1), TemporalType.DATE);
        query.setParameter("dateRangeEndParam", DateUtils.getNextDay(new Date(), 1), TemporalType.DATE);
        return query.getResultList();
    }

    public List<CorporateTimeSheet> getReport(SearchCorporateTimeSheetDto dto, int start, int limit) {
        String queryStr = getReportQueryString(dto);
        TypedQuery<CorporateTimeSheet> query = getEntityManager().createQuery(queryStr, CorporateTimeSheet.class);
        query = (TypedQuery<CorporateTimeSheet>) getReportQueryWithParams(queryStr, query, dto);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    protected Query getReportQueryWithParams(String qryStr, Query query, SearchCorporateTimeSheetDto dto) {
        query.setParameter("statusParam", TimeSheetStatus.Approved);
        if (qryStr.contains("startDateParam")) {
            query.setParameter("startDateParam", dto.getStartDate(), TemporalType.DATE);
        }
        if (qryStr.contains("endDateParam")) {
            query.setParameter("endDateParam", dto.getEndDate(), TemporalType.DATE);
        }
        if (qryStr.contains("empsWithRoleParam")) {
            List<Employee> emps = SecurityService.instance().getUsersWithRoles(0, 2000, dto.getRole().name());
            query.setParameter("empsWithRoleParam", emps);
        }
        return query;
    }

    protected String getReportQueryString(SearchCorporateTimeSheetDto dto) {
        StringBuilder reportQueryBuilder = new StringBuilder();
        reportQueryBuilder.append("from ").append(CorporateTimeSheet.class.getCanonicalName()).append(" where status=:statusParam ");
        if (dto.getStartDate() != null) {
            reportQueryBuilder.append(" and startDate>=:startDateParam ");
        }
        if (dto.getEndDate() != null) {
            reportQueryBuilder.append(" and endDate<=:endDateParam ");
        }
        if (dto.getRole() != null) {
            reportQueryBuilder.append(" and employee in (:empsWithRoleParam) ");
        }
        reportQueryBuilder.append(" order by startDate DESC ");
        return reportQueryBuilder.toString();
    }

    public List<CorporateTimeSheet> getTimeSheetsForEmployee(Employee employee, List<TimeSheetStatus> status, List<TimeSheetCategory> category) {
        TypedQuery query = getEntityManager().createQuery("from " + CorporateTimeSheet.class.getCanonicalName() + " where employee=:employeeParam and status in (:statusParam) and category in (:categoryParam)", CorporateTimeSheet.class);
        query.setParameter("employeeParam", employee);
        query.setParameter("statusParam", status);
        query.setParameter("categoryParam", category);
        return query.getResultList();
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static CorporateTimeSheetDao instance() {
        return SpringContext.getBean(CorporateTimeSheetDao.class);
    }

    @XmlRootElement
    @XmlType
    public static class CorporateTimeSheetTable {

        protected Long size;
        protected List<CorporateTimeSheet> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<CorporateTimeSheet> getEntities() {
            return entities;
        }

        public void setEntities(List<CorporateTimeSheet> entities) {
            this.entities = entities;
        }
    }
}
