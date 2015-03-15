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
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public ConsultantTimeSheet save(ConsultantTimeSheet entity) {
        if (!Strings.isNullOrEmpty(entity.getApprovedBy()) && EmployeeDao.instance().findEmployeWithEmpId(entity.getApprovedBy()) == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.approvedById", "Approved By must be a employee Id");
        } else if (entity.getCategory().equals(TimeSheetCategory.PTO_ACCRUED) && entity.getId() == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.create.pto-accrued", "Cannot create PTO Accrued Timesheet");
        }
        return super.save(entity);
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
        String queryStr = getTimeSheetsForEmployeeQuery(employee, status, category) + " order by endDate DESC ";
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
        queryStr
                .append("from ").append(ConsultantTimeSheet.class
                        .getCanonicalName()).append(" where employee=:employeeParam");
        if (status
                != null) {
            queryStr.append(" and status=:statusParam ");
        }
        if (category
                != null) {
            queryStr.append(" and category=:categoryParam");
        }

        return queryStr.toString();
    }

    /**
     * deducts PTO Used hours on approval
     *
     * @param ts
     */
    public void deductPTOUsedHours(ConsultantTimeSheet ts) {
        ConsultantTimeSheet ptoAccruedTS = getPTOAccruedTimeSheet(ts.getEmployee());
        BigDecimal currentPTOBalance = ptoAccruedTS.getHours();
        ptoAccruedTS.setHours(ptoAccruedTS.getHours().subtract(ts.getHours()));
        getEntityManager().merge(ptoAccruedTS);
        addTimeSheetUpdateComment("System Update on approval", currentPTOBalance, ptoAccruedTS, ts);
    }

    /**
     * adds PTO Used hours back on approval of cancel requests so the hours are
     * added back to pool
     *
     * @param ts
     */
    public void addPTOUsedHours(ConsultantTimeSheet ts) {
        ConsultantTimeSheet ptoAccruedTS = getPTOAccruedTimeSheet(ts.getEmployee());
        BigDecimal currentPTOBalance = ptoAccruedTS.getHours();
        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(ts.getHours()));
        getEntityManager().merge(ptoAccruedTS);
        addTimeSheetUpdateComment("System Update on approval", currentPTOBalance, ptoAccruedTS, ts);
    }

    public void addTimeSheetUpdateComment(String message, BigDecimal currentBalance, ConsultantTimeSheet ptoAccruedTS, ConsultantTimeSheet ptoUsedTS) {
        StringBuilder comment = new StringBuilder();
        comment.append(message).append("\n");
        comment.append("Current PTO Balance       : ").append(currentBalance).append("\n");
        comment.append("Hours Updated             : ").append(ptoUsedTS.getHours()).append("\n");
        comment.append("New  PTO Balance          : ").append(ptoAccruedTS.getHours()).append("\n");
        CommentDao.instance().addComment(comment.toString(), ptoAccruedTS);
    }

    public void addTimeSheetUpdateComment(String message, BigDecimal currentBalance, ConsultantTimeSheet ptoAccruedTS) {
        StringBuilder comment = new StringBuilder();
        comment.append(message).append("\n");
        comment.append("Current PTO Balance       : ").append(currentBalance).append("\n");
        comment.append("Hours Updated             : ").append(ptoAccruedTS.getHours().subtract(currentBalance)).append("\n");
        comment.append("New  PTO Balance          : ").append(ptoAccruedTS.getHours()).append("\n");
        CommentDao.instance().addComment(comment.toString(), ptoAccruedTS);
    }

    @Override
    public void delete(Long id) {
        ConsultantTimeSheet ts = findById(id);
        if (ts.getCategory().equals(TimeSheetCategory.PTO_ACCRUED) && !OfficeSecurityService.instance().hasRole(OfficeRoles.OfficeRole.ROLE_ADMIN.name())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.delete.pto_accrued.timesheet", "Cannot delete PTO Accrued timesheet ");
        } else {
            delete(ts);
        }
    }

    public ConsultantTimeSheet getPTOAccruedTimeSheet(Employee emp) {
        ConsultantTimeSheet ts = queryPTOAccruedTimeSheet(emp);
        if (ts != null) {
            return ts;
        } else {
            ts = new ConsultantTimeSheet();
            ts.setEmployee(emp);
            ts.setCategory(TimeSheetCategory.PTO_ACCRUED);
            ts.setCreatedTimeStamp(new Date());
            if (emp.getStartDate() == null) {
                ts.setStartDate(new Date());
                ts.setEndDate(new Date());
            } else {
                ts.setStartDate(emp.getStartDate());
                ts.setEndDate(DateUtils.getNextYear(emp.getStartDate(), 100));
            }
            ts.setHours(BigDecimal.ZERO);
            ts.setStatus(TimeSheetStatus.Approved);
            return getEntityManager().merge(ts);
        }
    }

    @Transactional(readOnly = true)
    public ConsultantTimeSheet queryPTOAccruedTimeSheet(Employee emp) {
        TypedQuery<ConsultantTimeSheet> query = getEntityManager().createQuery("from " + ConsultantTimeSheet.class.getCanonicalName() + " where employee=:employeeParam and category =:categoryParam", ConsultantTimeSheet.class);
        query.setParameter("categoryParam", TimeSheetCategory.PTO_ACCRUED);
        query.setParameter("employeeParam", emp);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else {
            return null;
        }
    }

    public List<ConsultantTimeSheet> getReport(SearchConsultantTimeSheetDto dto, int start, int limit) {
        String queryStr = getReportQueryString(dto);
        TypedQuery<ConsultantTimeSheet> query = getEntityManager().createQuery(queryStr, ConsultantTimeSheet.class);
        query = (TypedQuery<ConsultantTimeSheet>) getReportQueryWithParams(queryStr, query, dto);
        query.setFirstResult(start);
        query.setMaxResults(limit);
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
        reportQueryBuilder.append(" order by employee.firstName, startDate DESC ");
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

    public BigDecimal getHours(Employee employee, TimeSheetCategory timeSheetCategory, TimeSheetStatus timeSheetStatus) {
        return getHours(employee, Lists.newArrayList(timeSheetCategory), Lists.newArrayList(timeSheetStatus));
    }

    public BigDecimal getHours(Employee employee, List<TimeSheetCategory> timeSheetCategory, List<TimeSheetStatus> timeSheetStatus) {
        TypedQuery<BigDecimal> query = getEntityManager().createQuery("select sum(hours) from " + ConsultantTimeSheet.class.getCanonicalName() + " where employee=:employeeParam and category in (:categoryParam) and status in (:statusParam)", BigDecimal.class);
        query.setParameter("employeeParam", employee);
        query.setParameter("categoryParam", timeSheetCategory);
        query.setParameter("statusParam", timeSheetStatus);
        if (query.getSingleResult() != null) {
            return query.getSingleResult();
        } else {
            return BigDecimal.ZERO;
        }
    }
}
