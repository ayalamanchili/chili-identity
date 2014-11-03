/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import info.chili.commons.DateUtils;
import info.chili.dao.CRUDDao;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayalamanchili
 */
@Repository
@Scope("prototype")
public class ConsultantTimeSheetDao extends CRUDDao<ConsultantTimeSheet> {

    public ConsultantTimeSheetDao() {
        super(ConsultantTimeSheet.class);
    }

    public void saveTimeSheet(Employee emp, TimeSheetCategory category, BigDecimal hours, Date startDate, Date endDate) {
        if (findTimeSheet(emp, category, hours, startDate, endDate) == null) {
            ConsultantTimeSheet ts = new ConsultantTimeSheet();
            ts.setEmployee(emp);
            ts.setCategory(category);
            ts.setHours(hours);
            ts.setStatus(TimeSheetStatus.Approved);
            ts.setStartDate(startDate);
            ts.setEndDate(endDate);
            super.save(ts);
        }
    }

    @Override
    public ConsultantTimeSheet save(ConsultantTimeSheet entity) {
        if (!Strings.isNullOrEmpty(entity.getApprovedBy()) && EmployeeDao.instance().findEmployeWithEmpId(entity.getApprovedBy()) == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.approvedById", "Approved By must be a employee Id");
        }
        return super.save(entity);
    }

    public ConsultantTimeSheet findTimeSheet(Employee emp, TimeSheetCategory category, BigDecimal hours, Date startDate, Date endDate) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("from ").append(ConsultantTimeSheet.class.getCanonicalName()).append(" where");
        queryStr.append(" category=:categoryParam");
        queryStr.append(" and startDate=:startDateParam");
        queryStr.append(" and endDate=:endDateParam");
        queryStr.append(" and hours=:hoursParam");
        queryStr.append(" and employee=:empParam");
        TypedQuery<ConsultantTimeSheet> query = getEntityManager().createQuery(queryStr.toString(), ConsultantTimeSheet.class);
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

    public List<ConsultantTimeSheet> getTimeSheetsEmployee(Employee employee, TimeSheetCategory category, TimeSheetStatus status, int start, int limit) {
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
        queryStr.append("from ").append(ConsultantTimeSheet.class.getCanonicalName()).append(" where employee=:employeeParam");
        if (status != null) {
            queryStr.append(" and status=:statusParam ");
        }
        if (category != null) {
            queryStr.append(" and category=:categoryParam");
        }
        return queryStr.toString();
    }

    public List<ConsultantTimeSheet> getReport(SearchConsultantTimeSheetDto dto, int start, int limit) {
        List<SearchConsultantTimeSheetDto> summary = new ArrayList<SearchConsultantTimeSheetDto>();
        String queryStr = getReportQueryString(dto);
        TypedQuery<ConsultantTimeSheet> query = getEntityManager().createQuery(queryStr, ConsultantTimeSheet.class);
        query = (TypedQuery<ConsultantTimeSheet>) getReportQueryWithParams(queryStr, query, dto);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        Collections.sort(summary, new Comparator<SearchConsultantTimeSheetDto>() {
            @Override
            public int compare(SearchConsultantTimeSheetDto dto1, SearchConsultantTimeSheetDto dto2) {
                return dto1.getEmployee().compareTo(dto2.getEmployee());
            }
        });
        return query.getResultList();
    }

    protected Query getReportQueryWithParams(String qryStr, Query query, SearchConsultantTimeSheetDto dto) {
        if (qryStr.contains("startDateParam")) {
            query.setParameter("startDateParam", dto.getStartDate(), TemporalType.DATE);
        }
        if (qryStr.contains("endDateParam")) {
            query.setParameter("endDateParam", dto.getEndDate(), TemporalType.DATE);
        }
        if (qryStr.contains("statusParam")) {
            query.setParameter("statusParam", dto.getStatus());
        }
        if (qryStr.contains("categoryParam")) {
            query.setParameter("categoryParam", dto.getCategory());
        }
        return query;
    }

    protected String getReportQueryString(SearchConsultantTimeSheetDto dto) {
        StringBuilder reportQueryBuilder = new StringBuilder();
        reportQueryBuilder.append("from ").append(ConsultantTimeSheet.class.getCanonicalName()).append(" where ");
        if (dto.getStartDate() != null) {
            reportQueryBuilder.append("(startDate BETWEEN :startDateParam AND :endDateParam");
        }
        if (dto.getEndDate() != null) {
            reportQueryBuilder.append(" or endDate BETWEEN :startDateParam AND :endDateParam)");
        }
        if (dto.getStatus() != null) {
            reportQueryBuilder.append(" and status in (:statusParam) ");
        }
        if (dto.getCategory() != null) {
            reportQueryBuilder.append(" and category in (:categoryParam) ");
        }
        reportQueryBuilder.append(" order by startDate DESC ");
        return reportQueryBuilder.toString();
    }

    public List<ConsultantTimeSheet> getCurrentCompanyLeaves() {
        TypedQuery<ConsultantTimeSheet> query = getEntityManager().createQuery("from " + ConsultantTimeSheet.class.getCanonicalName() + " where status=:statusParam and category IN (:categoryParam) and ((startDate <=:dateRangeEndParam ) and (endDate >=:dateRangeStartParam))", ConsultantTimeSheet.class);
        query.setParameter("statusParam", TimeSheetStatus.Approved);
        query.setParameter("categoryParam", TimeSheetCategory.getLeaveSpentCategories());
        query.setParameter("dateRangeStartParam", DateUtils.getNextDay(new Date(), -30), TemporalType.DATE);
        query.setParameter("dateRangeEndParam", DateUtils.getNextDay(new Date(), 30), TemporalType.DATE);
        return query.getResultList();
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static ConsultantTimeSheetDao instance() {
        return SpringContext.getBean(ConsultantTimeSheetDao.class);
    }

    public BigDecimal getHoursInYear(Employee employee, TimeSheetCategory timeSheetCategory, TimeSheetStatus timeSheetStatus, Date yearDate) {
        return getHoursInYear(employee, Lists.newArrayList(timeSheetCategory), Lists.newArrayList(timeSheetStatus), yearDate);
    }

    public BigDecimal getHoursInYear(Employee employee, List<TimeSheetCategory> timeSheetCategory, TimeSheetStatus timeSheetStatus, Date yearDate) {
        return getHoursInYear(employee, timeSheetCategory, Lists.newArrayList(timeSheetStatus), yearDate);
    }

    public BigDecimal getHoursInYear(Employee employee, List<TimeSheetCategory> timeSheetCategory, List<TimeSheetStatus> timeSheetStatus, Date yearDate) {
        TypedQuery<BigDecimal> query = getEntityManager().createQuery("select sum(hours) from " + ConsultantTimeSheet.class.getCanonicalName() + " where employee=:employeeParam and category in (:categoryParam) and status in (:statusParam) and startDate >=:startDateParam and endDate <=:endDateParam", BigDecimal.class);
        query.setParameter("employeeParam", employee);
        query.setParameter("categoryParam", timeSheetCategory);
        query.setParameter("statusParam", timeSheetStatus);
        query.setParameter("startDateParam", DateUtils.getFirstDayOfYear(yearDate), TemporalType.DATE);
        query.setParameter("endDateParam", DateUtils.getLastDayOfYear(yearDate), TemporalType.DATE);
        if (query.getSingleResult() != null) {
            return query.getSingleResult();
        } else {
            return BigDecimal.ZERO;
        }
    }
}
