/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.util.List;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class CorpEmpLeaveRequestCancelProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            leaveRequestCorrectionTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            leaveRequestCorrectionTaskCompleted(task);
        }
    }

    protected void leaveRequestCorrectionTaskCreated(DelegateTask task) {
        assignLeaveRequestTask(task);
        new GenericTaskCreateNotification().notify(task);
    }

    protected void leaveRequestCorrectionTaskCompleted(DelegateTask task) {
        CorporateTimeSheet ts = (CorporateTimeSheet) task.getExecution().getVariable("entity");
        Employee currentUser = SecurityService.instance().getCurrentUser();
        if (ts != null) {
            if (currentUser.getEmployeeId().equals(ts.getEmployee().getEmployeeId())) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.timesheet", "You cannot approve your timesheet");
            }
            String status = (String) task.getExecution().getVariable("status");
            if ("approved".equals(status)) {
                leaveCancelRequestApproved(ts);
            }
        }
        new GenericTaskCompleteNotification().notify(task);
    }

    protected void leaveCancelRequestApproved(CorporateTimeSheet ts) {
        ts.setStatus(TimeSheetStatus.Canceled);
        CorporateTimeSheetDao.instance().save(ts);
        if (ts.getBpmProcessId() != null && !ts.getBpmProcessId().isEmpty()) {
            deleteApprovalTask(ts.getBpmProcessId());
        }
    }

    protected void deleteApprovalTask(String processId) {
        OfficeBPMTaskService taskServcie = OfficeBPMTaskService.instance();
        List<Task> tasks = taskServcie.getTasksForProcessId(processId);
        if (tasks.size() > 0) {
            OfficeBPMTaskService.instance().deleteTask(tasks.get(0).getId());
        }
    }

    protected void assignLeaveRequestTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        List<CompanyContact> cnts = CompanyContactDao.instance().getCompanyContact(emp, "Reports_To");
        if (cnts.size() > 0) {
            task.addCandidateUser(cnts.get(0).getContact().getEmployeeId());
        }
        task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name());
    }
}
