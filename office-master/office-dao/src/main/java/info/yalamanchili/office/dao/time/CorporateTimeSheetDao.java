/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import info.chili.commons.DateUtils;
import info.chili.commons.pdf.PDFUtils;
import info.chili.dao.CRUDDao;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.template.TemplateService;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;
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

    @Override
    public CorporateTimeSheet save(CorporateTimeSheet entity) {
        if (entity.getCategory().equals(TimeSheetCategory.PTO_ACCRUED) && entity.getId() == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.have.morethanone.pto-accrued", "Cannot have more than one PTO Accrued Timesheet");
        }
        return super.save(entity);
    }

    public void adjustPTODAccruedHours(CorporateTimeSheet entity, BigDecimal adjustmentHours, String adjustmentReason) {
        CorporateTimeSheet ptoAccruedTS = getPTOAccruedTimeSheet(entity.getEmployee());
        BigDecimal currentBalance = ptoAccruedTS.getHours();
        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(adjustmentHours));
        getEntityManager().merge(ptoAccruedTS);
        addTimeSheetUpdateComment("PTO Accrued Hours Manual Adjustment: Reason: " + adjustmentReason, currentBalance, ptoAccruedTS);
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

    public CorporateTimeSheet findTimeSheet(Employee emp, TimeSheetCategory category, Date startDate, Date endDate) {
        StringBuilder queryStr = new StringBuilder();
        queryStr.append("from ").append(CorporateTimeSheet.class.getCanonicalName()).append(" where");
        queryStr.append(" category=:categoryParam");
        queryStr.append(" and startDate=:startDateParam");
        queryStr.append(" and endDate=:endDateParam");
        queryStr.append(" and employee=:empParam");
        TypedQuery<CorporateTimeSheet> query = getEntityManager().createQuery(queryStr.toString(), CorporateTimeSheet.class);
        query.setParameter("categoryParam", category);
        query.setParameter("startDateParam", startDate, TemporalType.DATE);
        query.setParameter("endDateParam", endDate, TemporalType.DATE);
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
        queryStr.append("from ").append(CorporateTimeSheet.class.getCanonicalName()).append(" where employee=:employeeParam ");
        if (status != null) {
            queryStr.append(" and status=:statusParam ");
        }
        if (category != null) {
            queryStr.append(" and category=:categoryParam");
        }
        return queryStr.toString();
    }

    /**
     * deducts PTO Used hours on approval
     *
     * @param ts
     */
    public void deductPTOUsedHours(CorporateTimeSheet ts) {
        CorporateTimeSheet ptoAccruedTS = getPTOAccruedTimeSheet(ts.getEmployee());
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
    public void addPTOUsedHours(CorporateTimeSheet ts) {
        CorporateTimeSheet ptoAccruedTS = getPTOAccruedTimeSheet(ts.getEmployee());
        BigDecimal currentPTOBalance = ptoAccruedTS.getHours();
        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(ts.getHours()));
        getEntityManager().merge(ptoAccruedTS);
        addTimeSheetUpdateComment("System Update on approval", currentPTOBalance, ptoAccruedTS, ts);
    }

    public void addTimeSheetUpdateComment(String message, BigDecimal currentBalance, CorporateTimeSheet ptoAccruedTS, CorporateTimeSheet ptoUsedTS) {
        StringBuilder comment = new StringBuilder();
        comment.append(message).append("\n");
        comment.append("Current PTO Balance       : ").append(currentBalance).append("\n");
        comment.append("Hours Updated             : ").append(ptoUsedTS.getHours()).append("\n");
        comment.append("New  PTO Balance          : ").append(ptoAccruedTS.getHours()).append("\n");
        comment.append("Time Sheet Information    : ").append(ptoUsedTS.describe()).append("\n");
        CommentDao.instance().addComment(comment.toString(), ptoAccruedTS);
    }

    public void addTimeSheetUpdateComment(String message, BigDecimal currentBalance, CorporateTimeSheet ptoAccruedTS) {
        StringBuilder comment = new StringBuilder();
        comment.append(message).append("\n");
        comment.append("Current PTO Balance       : ").append(currentBalance).append("\n");
        comment.append("Hours Updated             : ").append(ptoAccruedTS.getHours().subtract(currentBalance)).append("\n");
        comment.append("New  PTO Balance          : ").append(ptoAccruedTS.getHours()).append("\n");
        CommentDao.instance().addComment(comment.toString(), ptoAccruedTS);
    }

    public CorporateTimeSheet getPTOAccruedTimeSheet(Employee emp) {
        CorporateTimeSheet ts = queryPTOAccruedTimeSheet(emp);
        if (ts != null) {
            return ts;
        } else {
            ts = new CorporateTimeSheet();
            ts.setEmployee(emp);
            ts.setCategory(TimeSheetCategory.PTO_ACCRUED);
            ts.setCreatedTimeStamp(new Date());
            ts.setStartDate(emp.getStartDate());
            ts.setEndDate(DateUtils.getNextYear(emp.getStartDate(), 100));
            ts.setHours(BigDecimal.ZERO);
            ts.setStatus(TimeSheetStatus.Approved);
            return getEntityManager().merge(ts);
        }
    }

    protected CorporateTimeSheet queryPTOAccruedTimeSheet(Employee emp) {
        TypedQuery<CorporateTimeSheet> query = getEntityManager().createQuery("from " + CorporateTimeSheet.class.getCanonicalName() + " where employee=:employeeParam and category =:categoryParam", CorporateTimeSheet.class);
        query.setParameter("categoryParam", TimeSheetCategory.PTO_ACCRUED);
        query.setParameter("employeeParam", emp);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        CorporateTimeSheet ts = findById(id);
        if (ts.getCategory().equals(TimeSheetCategory.PTO_ACCRUED)) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.delete.pto_accrued.timesheet", "Cannot delete PTO Accrued timesheet ");
        } else {
            delete(ts);
        }
    }

    public BigDecimal getHoursInYear(Employee employee, TimeSheetCategory timeSheetCategory, TimeSheetStatus timeSheetStatus, Date yearDate) {
        return getHoursInYear(employee, Lists.newArrayList(timeSheetCategory), Lists.newArrayList(timeSheetStatus), yearDate);
    }

    public BigDecimal getHoursInYear(Employee employee, List<TimeSheetCategory> timeSheetCategory, TimeSheetStatus timeSheetStatus, Date yearDate) {
        return getHoursInYear(employee, timeSheetCategory, Lists.newArrayList(timeSheetStatus), yearDate);
    }

    public BigDecimal getPTOAccruedInYear(Employee employee) {
        BigDecimal ptoHoursAccrued = BigDecimal.ZERO;
        if (getHoursInYear(employee, TimeSheetCategory.PTO_USED, TimeSheetStatus.Approved, new Date()) != null) {
            ptoHoursAccrued = ptoHoursAccrued.add(getPTOAccruedTimeSheet(employee).getHours().add(getHoursInYear(employee, TimeSheetCategory.PTO_USED, TimeSheetStatus.Approved, new Date())));
        }
        return ptoHoursAccrued;
    }

    public BigDecimal getHoursInYear(Employee employee, List<TimeSheetCategory> category, List<TimeSheetStatus> status, Date yearDate) {
        TypedQuery<BigDecimal> query = getEntityManager().createQuery("select sum(hours) from " + CorporateTimeSheet.class.getCanonicalName() + " where employee=:employeeParam and category in (:categoryParam) and status in (:statusParam) and startDate >=:startDateParam and endDate <=:endDateParam", BigDecimal.class);
        query.setParameter("employeeParam", employee);
        query.setParameter("categoryParam", category);
        query.setParameter("statusParam", status);
        query.setParameter("startDateParam", DateUtils.getFirstDayOfYear(yearDate), TemporalType.DATE);
        query.setParameter("endDateParam", DateUtils.getLastDayOfYear(yearDate), TemporalType.DATE);
        if (query.getSingleResult() != null) {
            return query.getSingleResult();
        } else {
            return BigDecimal.ZERO;
        }
    }

    public BigDecimal getHoursInMonth(Employee employee, List<TimeSheetCategory> category, List<TimeSheetStatus> status, Date monthDate) {
        TypedQuery<BigDecimal> query = getEntityManager().createQuery("select sum(hours) from " + CorporateTimeSheet.class.getCanonicalName() + " where employee=:employeeParam and category in (:categoryParam) and status in (:statusParam) and startDate >=:startDateParam and endDate <=:endDateParam", BigDecimal.class);
        query.setParameter("employeeParam", employee);
        query.setParameter("categoryParam", category);
        query.setParameter("statusParam", status);
        query.setParameter("startDateParam", DateUtils.getFirstDayOfMonth(monthDate), TemporalType.DATE);
        query.setParameter("endDateParam", DateUtils.getLastDayOfMonth(monthDate), TemporalType.DATE);
        if (query.getSingleResult() != null) {
            return query.getSingleResult();
        } else {
            return BigDecimal.ZERO;
        }
    }

    public List<CorporateTimeSheet> getCurrentCompanyLeaves() {
        List<TimeSheetStatus> statuses= new  ArrayList<TimeSheetStatus>();
        statuses.add(TimeSheetStatus.Approved);
        statuses.add(TimeSheetStatus.Pending);
        TypedQuery<CorporateTimeSheet> query = getEntityManager().createQuery("from " + CorporateTimeSheet.class.getCanonicalName() + " where status IN (:statusParam) and category IN (:categoryParam) and ((startDate <=:dateRangeEndParam ) and (endDate >=:dateRangeStartParam))", CorporateTimeSheet.class);
        query.setParameter("statusParam", statuses);
        query.setParameter("categoryParam", TimeSheetCategory.getLeaveSpentCategories());
        query.setParameter("dateRangeStartParam", DateUtils.getNextDay(new Date(), -1), TemporalType.DATE);
        query.setParameter("dateRangeEndParam", DateUtils.getNextDay(new Date(), 1), TemporalType.DATE);
        return query.getResultList();
    }

    public List<CorporateTimeSheet> getReport(SearchCorporateTimeSheetDto dto, int start, int limit) {
        List<Employee> emps = null;
        if (dto.getRole() != null) {
            emps = OfficeSecurityService.instance().getUsersWithRoles(0, 2000, dto.getRole().name());
        }
        String queryStr = getReportQueryString(dto, emps);
        TypedQuery<CorporateTimeSheet> query = getEntityManager().createQuery(queryStr, CorporateTimeSheet.class);
        query = (TypedQuery<CorporateTimeSheet>) getReportQueryWithParams(queryStr, query, dto, emps);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public Response getPDFReport(SearchCorporateTimeSheetDto dto) {
        String html = TemplateService.instance().process("corporate-time-report.xhtml", getReport(dto, 0, 10000));
        byte[] pdf = PDFUtils.convertToPDF(html);
        File file = new File(OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "corporate-ts-report.pdf");
        try {
            Files.write(pdf, file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return Response.ok("corporate-ts-report.pdf".getBytes()).header("content-disposition", "filename = corporate-ts-report.pdf")
                .header("Content-Length", "corporate-ts-report.pdf".length()).build();
    }

    protected Query getReportQueryWithParams(String qryStr, Query query, SearchCorporateTimeSheetDto dto, List<Employee> emps) {
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
        if (qryStr.contains("empsWithRoleParam")) {
            query.setParameter("empsWithRoleParam", emps);
        }
        if (qryStr.contains("branchParam")) {
            query.setParameter("branchParam", dto.getBranch());
        }
        return query;
    }

    protected String getReportQueryString(SearchCorporateTimeSheetDto dto, List<Employee> emps) {
        StringBuilder reportQueryBuilder = new StringBuilder();
        reportQueryBuilder.append("from ").append(CorporateTimeSheet.class.getCanonicalName()).append(" where ");
        if (dto.getStartDate() != null) {
            reportQueryBuilder.append("( startDate BETWEEN :startDateParam AND :endDateParam");
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
        if (emps != null && emps.size() > 0) {
            reportQueryBuilder.append(" and employee in (:empsWithRoleParam) ");
        }
        if (dto.getBranch() != null) {
            reportQueryBuilder.append(" and employee.branch in (:branchParam) ");
        }
        reportQueryBuilder.append(" order by employee.firstName, startDate DESC ");
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
    public static class CorporateTimeSheetTable implements java.io.Serializable {

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
