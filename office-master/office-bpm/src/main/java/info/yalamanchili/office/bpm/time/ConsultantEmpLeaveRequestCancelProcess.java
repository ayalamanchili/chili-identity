/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.OfficeBPMTaskService;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author prasanthi.p
 */
public class ConsultantEmpLeaveRequestCancelProcess implements TaskListener {

    @Override
    public void notify(DelegateTask dt) {
        if ("create".equals(dt.getEventName())) {
            leaveRequestCorrectionTaskCreated(dt);
        }
        if ("complete".equals(dt.getEventName())) {
            leaveRequestCorrectionTaskCompleted(dt);
        }
    }

    private void leaveRequestCorrectionTaskCreated(DelegateTask dt) {
        new GenericTaskCreateNotification().notify(dt);
    }

    private void leaveRequestCorrectionTaskCompleted(DelegateTask dt) {
        ConsultantTimeSheet cts = getTimeSheetFromTask(dt);
        if (cts == null) {
            return;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (currentUser.getEmployeeId().equals(cts.getEmployee().getEmployeeId())) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.self.approve.corp.timesheet", "You cannot approve your timesheet");
        }
        String status = (String) dt.getExecution().getVariable("status");
        if ("approved".equals(status)) {
            leaveCancelRequestApproved(cts);
        }
        new GenericTaskCompleteNotification().notify(dt);
    }

    protected void leaveCancelRequestApproved(ConsultantTimeSheet cts) {
        ConsultantTimeSheetDao dao = ConsultantTimeSheetDao.instance();
        if (cts.getCategory().equals(TimeSheetCategory.PTO_USED) && TimeSheetStatus.Approved.equals(cts.getStatus())) {
            dao.addPTOUsedHours(cts);
        }
        if (cts.getBpmProcessId() != null && !cts.getBpmProcessId().isEmpty()) {
            deleteApprovalTask(cts.getBpmProcessId());
        }
        cts.setStatus(TimeSheetStatus.Canceled);
        dao.save(cts);
    }

    protected void deleteApprovalTask(String processId) {
        OfficeBPMTaskService taskServcie = OfficeBPMTaskService.instance();
        taskServcie.deleteAllTasksForProcessId(processId, true);
    }

    protected ConsultantTimeSheet getTimeSheetFromTask(DelegateTask task) {
        Long tsId = (Long) task.getExecution().getVariable("entityId");
        if (tsId != null) {
            return ConsultantTimeSheetDao.instance().findById(tsId);
        }
        return null;
    }
}
