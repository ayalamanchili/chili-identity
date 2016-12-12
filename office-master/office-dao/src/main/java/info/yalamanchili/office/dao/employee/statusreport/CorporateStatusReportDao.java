/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.employee.statusreport;

import info.chili.dao.CRUDDao;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.TimePeriodDao;
import info.chili.email.Email;
import info.yalamanchili.office.entity.employee.statusreport.CorporateStatusReport;
import info.yalamanchili.office.entity.employee.statusreport.CropStatusReportStatus;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.model.time.TimePeriod;
import info.yalamanchili.office.security.AccessCheck;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author benerji.v
 */
@Repository
@Scope("prototype")
public class CorporateStatusReportDao extends CRUDDao<CorporateStatusReport> {

    @Transactional(readOnly = true)
    @Override
    public CorporateStatusReport findById(Long id) {
        CorporateStatusReport entity = getEntityManager().find(CorporateStatusReport.class, id);
        entity.setStatusReportPeriod(TimePeriodDao.instance().find(entity.getReportStartDate(), entity.getReportEndDate(), TimePeriod.TimePeriodType.Week));
        return entity;
    }

    public CorporateStatusReport getPreviousReport(Long id) {
        CorporateStatusReport entity = getEntityManager().find(CorporateStatusReport.class, id);
        TimePeriod tp = TimePeriodDao.instance().find(entity.getReportStartDate(), entity.getReportEndDate(), TimePeriod.TimePeriodType.Week);
        int x = 7;
        for (int i = 0; i < 5; i++) {
            CorporateStatusReport res = find(entity.getEmployee(), DateUtils.addDays(tp.getStartDate(), -x), DateUtils.addDays(tp.getEndDate(), -x));
            if (res != null) {
                return res;
            } else {
                x = x + 7;
            }
        }
        return null;
    }

    @Override
    public CorporateStatusReport save(CorporateStatusReport entity) {
        if (entity.getId() == null) {
            Employee emp = OfficeSecurityService.instance().getCurrentUser();
            if (find(emp, entity.getReportStartDate(), entity.getReportEndDate()) != null) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "status.report.exists", "Status Report with same dates already exists");
            }
            entity.setStatus(CropStatusReportStatus.Saved);
            entity.setEmployee(emp);
        }
        return super.save(entity);
    }

    public CorporateStatusReport find(Employee emp, Date startDate, Date endDate) {
        TypedQuery<CorporateStatusReport> query = em.createQuery("from " + CorporateStatusReport.class.getCanonicalName() + " where employee=:empParam and reportStartDate=:reportStartDateParam and reportEndDate=:reportEndDateParam", CorporateStatusReport.class);
        query.setParameter("empParam", emp);
        query.setParameter("reportStartDateParam", startDate);
        query.setParameter("reportEndDateParam", endDate);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else {
            return null;
        }
    }

    @AccessCheck(companyContacts = {"Perf_Eval_Manager", "Reports_To", "Supervisor"}, roles = {"ROLE_CRP_STATUS_RPT_MGR"}, strictOrderCheck = false)
    public List<CorporateStatusReport> getReports(Employee emp, int start, int limit) {
        TypedQuery<CorporateStatusReport> query = em.createQuery("from " + CorporateStatusReport.class.getCanonicalName() + " where employee=:empParam order by reportStartDate desc", CorporateStatusReport.class);
        query.setParameter("empParam", emp);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public Long getReportsSize(Employee emp, int start, int limit) {
        TypedQuery<Long> query = em.createQuery("select count(*) from " + CorporateStatusReport.class.getCanonicalName() + " where employee=:empParam", Long.class);
        query.setParameter("empParam", emp);
        return query.getSingleResult();
    }

    public List<CorporateStatusReport> search(CorporateStatusReportSearchDto dto) {
        if (dto.getStatus() != null && dto.getStatus().contains("NotSubmitted")) {
            return notSubmittedReport(dto);
        }
        String queryStr = getSearchReportsQuery(dto);
        TypedQuery<CorporateStatusReport> query = em.createQuery(queryStr, entityCls);
        if (queryStr.contains("employeeParam")) {
            query.setParameter("employeeParam", EmployeeDao.instance().findById(dto.getEmployee().getId()));
        }
        if (queryStr.contains("startDateParam")) {
            TimePeriod timePriod = TimePeriodDao.instance().fineOne(dto.getStatusReportPeriod().getId());
            query.setParameter("startDateParam", timePriod.getStartDate());
            query.setParameter("endDateParam", timePriod.getEndDate());
        }
        List<CorporateStatusReport> res = new ArrayList();
        for (CorporateStatusReport entity : query.getResultList()) {
            entity.setEmployeeName(entity.getEmployee().getFirstName() + " " + entity.getEmployee().getLastName());
            res.add(entity);
        }
        return res;
    }
    public static final String CORPORATE_STATUS_REPORT_GROUP = "Corporate_Status_Reports_Group";

    protected List<CorporateStatusReport> notSubmittedReport(CorporateStatusReportSearchDto dto) {
        List<CorporateStatusReport> res = new ArrayList();
        if (dto.getStatusReportPeriod() == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "timeperiod.not.present", "Please select a time period");
        }
        TimePeriod timePeriod = TimePeriodDao.instance().fineOne(dto.getStatusReportPeriod().getId());
        NotificationGroup ng = NotificationGroupDao.instance().findByName(CORPORATE_STATUS_REPORT_GROUP);
        if (ng == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "status.report.notificationgroup.dontnot.exist", CORPORATE_STATUS_REPORT_GROUP + " notification group does not exist");
        }
        for (Employee emp : ng.getEmployees()) {
            if (find(emp, timePeriod.getStartDate(), timePeriod.getEndDate()) == null) {
                if (emp.isActive() == true) {
                    CorporateStatusReport rpt = new CorporateStatusReport();
                    rpt.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
                    rpt.setReportStartDate(timePeriod.getStartDate());
                    rpt.setReportEndDate(timePeriod.getEndDate());
                    rpt.setStatus(CropStatusReportStatus.NotSubmitted);
                    res.add(rpt);
                }
            }
        }
        return res;
    }

    /**
     * this is invoked by the scheduler to send email remainders to all employee
     * in who did not submit status report for the last week
     *
     * @param dto
     * @return
     */
    public void notSubmittedEmailNotification() {
        Date date = DateUtils.addDays(new Date(), -7);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        date = calendar.getTime();
        Date startDate = info.chili.commons.DateUtils.firstDayOfWeek(date);
        Date endDate = info.chili.commons.DateUtils.lastDayOfWeek(date);

        Set<String> res = new HashSet();
        TimePeriod timePeriod = TimePeriodDao.instance().find(startDate, endDate, TimePeriod.TimePeriodType.Week);
        notSubmittedEmailNotification(timePeriod);
    }

    public void notSubmittedEmailNotification(CorporateStatusReportSearchDto dto) {
        Set<String> res = new HashSet();
        if (dto.getStatusReportPeriod() == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "timeperiod.not.present", "Please select a time period");
        }
        TimePeriod timePeriod = TimePeriodDao.instance().fineOne(dto.getStatusReportPeriod().getId());
        notSubmittedEmailNotification(timePeriod);
    }

    protected void notSubmittedEmailNotification(TimePeriod timePeriod) {
        Set<String> res = new HashSet();
        NotificationGroup ng = NotificationGroupDao.instance().findByName(CORPORATE_STATUS_REPORT_GROUP);
        if (ng == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "status.report.notificationgroup.dontnot.exist", CORPORATE_STATUS_REPORT_GROUP + " notification group does not exist");
        }
        for (Employee emp : ng.getEmployees()) {
            if (emp.isActive() && find(emp, timePeriod.getStartDate(), timePeriod.getEndDate()) == null) {
                res.add(emp.getPrimaryEmail().getEmail());
            }
        }
        Email email = new Email();
        email.setTos(res);
        email.setSubject("Weekly status report Not submitted reminder " + timePeriod.describe());
        String messageText = "Please submit your weekly status report";
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }

    protected String getSearchReportsQuery(CorporateStatusReportSearchDto dto) {
        StringBuilder query = new StringBuilder();
        query.append("from ").append(CorporateStatusReport.class.getCanonicalName()).append(" where ");
        if (dto.getEmployee() != null) {
            query.append("employee=:employeeParam ");
        }
        if (dto.getStatusReportPeriod() != null) {
            if (dto.getEmployee() != null) {
                query.append(" and ");
            }
            query.append("reportStartDate=:startDateParam").append(" and ");
            query.append("reportEndDate=:endDateParam");
        }
        query.append(" order by reportStartDate desc");
        return query.toString();
    }

    public CorporateStatusReportDao() {
        super(CorporateStatusReport.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static CorporateStatusReportDao instance() {
        return SpringContext.getBean(CorporateStatusReportDao.class);
    }

    @XmlRootElement
    @XmlType
    public static class CorporateStatusReportSearchDto {

        protected Employee employee;
        protected String status;
        protected TimePeriod statusReportPeriod;

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public TimePeriod getStatusReportPeriod() {
            return statusReportPeriod;
        }

        public void setStatusReportPeriod(TimePeriod statusReportPeriod) {
            this.statusReportPeriod = statusReportPeriod;
        }
    }
}
