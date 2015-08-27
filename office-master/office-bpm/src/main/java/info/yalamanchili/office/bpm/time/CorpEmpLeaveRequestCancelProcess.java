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
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.util.List;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
@Transactional
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
        CorporateTimeSheet ts = getTimeSheetFromTask(task);
        if (ts == null) {
            return;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
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
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        if (ts.getCategory().equals(TimeSheetCategory.PTO_USED) && TimeSheetStatus.Approved.equals(ts.getStatus())) {
            dao.addPTOUsedHours(ts);
        }
        if (ts.getCategory().equals(TimeSheetCategory.TDL_PAID) && TimeSheetStatus.Approved.equals(ts.getStatus())) {
            dao.addPTOUsedHours(ts);
        }
        if (ts.getBpmProcessId() != null && !ts.getBpmProcessId().isEmpty()) {
            deleteApprovalTask(ts.getBpmProcessId());
        }
        ts.setStatus(TimeSheetStatus.Canceled);
        dao.save(ts);
    }

    protected void deleteApprovalTask(String processId) {
        OfficeBPMTaskService taskServcie = OfficeBPMTaskService.instance();
        taskServcie.deleteAllTasksForProcessId(processId, true);
    }

    protected CorporateTimeSheet getTimeSheetFromTask(DelegateTask task) {
        Long tsId = (Long) task.getExecution().getVariable("entityId");
        if (tsId != null) {
            return CorporateTimeSheetDao.instance().findById(tsId);
        }
        return null;
    }

    protected void assignLeaveRequestTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        List<CompanyContact> cnts = CompanyContactDao.instance().getCompanyContact(emp, "Reports_To");
        if (cnts.size() > 0) {
            String reportsTo = cnts.get(0).getContact().getEmployeeId();
            task.addCandidateUser(reportsTo);
            task.setOwner(reportsTo);
        }
        task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name());
    }
}
