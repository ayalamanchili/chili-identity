/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import com.google.common.io.Files;
import info.chili.commons.DateUtils;
import info.chili.commons.FileIOUtils;
import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.template.TemplateService;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Response;
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
        String queryStr = getReportQueryString(dto);
        TypedQuery<ConsultantTimeSheet> query = getEntityManager().createQuery(queryStr, ConsultantTimeSheet.class);
        query = (TypedQuery<ConsultantTimeSheet>) getReportQueryWithParams(queryStr, query, dto);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public Response getPDFReport(SearchConsultantTimeSheetDto dto) {
        String html = TemplateService.instance().process("consultant-time-report.xhtml", getReport(dto, 0, 10000));
        byte[] pdf = FileIOUtils.convertToPDF(html);
        File file = new File(OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "consultant-ts-report.pdf");
        try {
            Files.write(pdf, file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return Response.ok("consultant-ts-report.pdf".getBytes()).header("content-disposition", "inline; filename = consultant-ts-report.pdf")
                .header("Content-Length", "consultant-ts-report.pdf".length()).build();
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
            reportQueryBuilder.append(" startDate>=:startDateParam ");
        }
        if (dto.getEndDate() != null) {
            reportQueryBuilder.append(" and endDate<=:endDateParam ");
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
        TypedQuery<BigDecimal> query = getEntityManager().createQuery("select sum(hours) from " + ConsultantTimeSheet.class.getCanonicalName() + " where employee=:employeeParam and category =:categoryParam and startDate >=:startDateParam and endDate <=:endDateParam", BigDecimal.class);
        query.setParameter("employeeParam", employee);
        query.setParameter("categoryParam", timeSheetCategory);
        query.setParameter("startDateParam", DateUtils.getFirstDayOfYear(yearDate), TemporalType.DATE);
        query.setParameter("endDateParam", DateUtils.getLastDayOfYear(yearDate), TemporalType.DATE);
        if (query.getSingleResult() != null) {
            return query.getSingleResult();
        } else {
            return BigDecimal.ZERO;
        }
    }
}
