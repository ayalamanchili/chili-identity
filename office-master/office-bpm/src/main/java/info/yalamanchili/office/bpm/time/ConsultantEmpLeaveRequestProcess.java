/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class ConsultantEmpLeaveRequestProcess implements TaskListener {

    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            leaveRequestTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            leaveRequestTaskCompleted(task);
        }
    }

    protected void leaveRequestTaskCreated(DelegateTask task) {
        ConsultantTimeSheet ts = (ConsultantTimeSheet) task.getExecution().getVariable("leaveRequest");
        ts.setBpmProcessId(task.getExecution().getProcessInstanceId());
        ts = ConsultantTimeSheetDao.instance().save(ts);
        task.getExecution().setVariable("leaveRequest", ts);
        task.getExecution().setVariable("entityId", ts.getId());
        new GenericTaskCreateNotification().notify(task);
    }

    protected void leaveRequestTaskCompleted(DelegateTask task) {
        ConsultantTimeSheet ts = getTimeSheetFromTask(task);
        if (ts == null) {
            return;
        }
        String status = (String) task.getExecution().getVariable("status");
        ConsultantTimeSheetDao dao = ConsultantTimeSheetDao.instance();
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (status.equalsIgnoreCase("approved")) {
            if (ConsultantEmpLeaveRequestProcessBean.instance().validateLeaveRequest(ts.getEmployee(), ts)) {
                ts.setApprovedBy(currentUser.getEmployeeId());
            } else {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "no.enough.leaves", "No Enough leaves for employee. Please verify time summary and reject the task");
            }
            ts.setStatus(TimeSheetStatus.Approved);
            ts.setApprovedDate(new Date());
            if (ts.getCategory().equals(TimeSheetCategory.PTO_USED)) {
                dao.deductPTOUsedHours(ts);
            }
        } else {
            ts.setStatus(TimeSheetStatus.Rejected);
            //TODO should this be deleted?
        }
        ConsultantTimeSheetDao.instance().save(ts);
        new GenericTaskCompleteNotification().notify(task);
    }

    protected ConsultantTimeSheet getTimeSheetFromTask(DelegateTask task) {
        Long tsId = (Long) task.getExecution().getVariable("entityId");
        if (tsId != null) {
            return ConsultantTimeSheetDao.instance().findById(tsId);
        }
        return null;
    }
}
