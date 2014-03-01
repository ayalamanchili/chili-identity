/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.bpm.OfficeBPMService;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dto.time.CorporateTimeSummary;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("request")
public class CorporateTimeService {

    @Autowired
    protected CorporateTimeSheetDao corporateTimeSheetDao;

    public void submitLeaveRequest(CorporateTimeSheet entity) {
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("entity", entity);
        Employee emp = SecurityService.instance().getCurrentUser();
        vars.put("currentEmployee", emp);
        vars.put("summary", getYearlySummary(emp));
        OfficeBPMService.instance().startProcess("corp_emp_leave_request_process", vars);
    }

    public void cancelLeaveRequest(Long timesheetId) {
        CorporateTimeSheet ts = corporateTimeSheetDao.findById(timesheetId);
        if (TimeSheetStatus.Rejected.equals(ts.getStatus()) || TimeSheetStatus.Canceled.equals(ts.getStatus())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "timesheet.already.canceled.or.rejected", "Time Sheet is already canceled or rejected");
        }
        if (ts.getStartDate().before(new Date()) || ts.getEndDate().before(new Date())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.cancel.past.leave.request", "Cannot cancel past leave requests");
        }
        if (TimeSheetStatus.Pending.equals(ts.getStatus())) {
            OfficeBPMTaskService.instance().deleteAllTasksForProcessId(ts.getBpmProcessId(), true);
        }
        ts.setStatus(TimeSheetStatus.Canceled);
        corporateTimeSheetDao.save(ts);
        sendLeaveRequestCancelationNotice(ts);
    }

    protected void sendLeaveRequestCancelationNotice(CorporateTimeSheet ts) {
        Email email = new Email();
        Employee emp = SecurityService.instance().getCurrentUser();
        email.setTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRole.ROLE_HR_ADMINSTRATION.name()));
        email.addTo(emp.getPrimaryEmail().getEmail());
        Employee reportsTo = CompanyContactDao.instance().getReportsToContactForEmployee(emp);
        if (reportsTo != null) {
            email.addTo(reportsTo.getPrimaryEmail().getEmail());
        }
        email.setSubject("Leave Request has been canceled by employee");
        StringBuilder message = new StringBuilder();
        message.append("Details").append("\n");
        message.append("Employee:").append(ts.getEmployee().getFirstName()).append(" ").append(ts.getEmployee().getLastName()).append("\n");
        message.append("Timesheet Start Date:").append(ts.getStartDate()).append("\n");;
        message.append("Timesheet End Date:").append(ts.getEndDate()).append("\n");;
        message.append("Timesheet Category:").append(ts.getCategory()).append("\n");;
        message.append("Timesheet Status:").append(ts.getStatus()).append("\n");;
        message.append("Cancel Request Submitted By:").append(emp.getFirstName()).append(" ").append(emp.getLastName());
        email.setBody(message.toString());
        email.setHtml(Boolean.TRUE);
        MessagingService.instance().sendEmail(email);
    }

    public CorporateTimeSummary getYearlySummary(Employee employee) {
        CorporateTimeSummary summary = new CorporateTimeSummary();
        summary.setAvailablePersonalHours(getYearlyPeronalBalance(employee));
        summary.setAvailableSickHours(getYearlySickBalance(employee));
        summary.setAvailableVacationHours(getYearlyVacationBalance(employee));
        return summary;
    }

    public void checkAccessToEmployeeTime(Employee emp) {
        Employee currentUser = SecurityService.instance().getCurrentUser();
        if (emp.getEmployeeId().equals(currentUser.getEmployeeId())) {
            return;
        }
        Employee reportsToEmp = CompanyContactDao.instance().getReportsToContactForEmployee(emp);
        if (reportsToEmp != null && currentUser.getEmployeeId().equals(reportsToEmp.getEmployeeId())) {
            return;
        }
        if (SecurityService.instance().hasRole(OfficeRole.ROLE_HR_ADMINSTRATION.name())) {
            return;
        }
        throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "permission.error", "you do not have  permission to view this information");
    }

    public BigDecimal getYearlySickBalance(Employee employee) {
        BigDecimal earned = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Sick_Earned, TimeSheetStatus.Approved);
        BigDecimal spent = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Sick_Spent, TimeSheetStatus.Approved);
        return earned.subtract(spent);
    }

    public BigDecimal getYearlyPeronalBalance(Employee employee) {
        BigDecimal earned = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Personal_Earned, TimeSheetStatus.Approved);
        BigDecimal spent = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Personal_Spent, TimeSheetStatus.Approved);
        return earned.subtract(spent);
    }

    public BigDecimal getYearlyVacationBalance(Employee employee) {
        BigDecimal earned = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Vacation_Earned, TimeSheetStatus.Approved);
        BigDecimal spent = corporateTimeSheetDao.getHoursInCurrentYear(employee, TimeSheetCategory.Vacation_Spent, TimeSheetStatus.Approved);
        return earned.subtract(spent);
    }

    public static CorporateTimeService instance() {
        return SpringContext.getBean(CorporateTimeService.class);
    }
}
