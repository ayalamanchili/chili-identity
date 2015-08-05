/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.statusreport;

import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.employee.statusreport.StatusReportDao;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.employee.statusreport.StatusReport;
import info.yalamanchili.office.entity.employee.statusreport.StatusReportStage;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Date;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author prasanthi.p
 */
public class StatusReportProcess extends RuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask dt) {
        super.processTask(dt);
        if ("complete".equals(dt.getEventName())) {
            StatusReport request = getRequestFromTask(dt);
            if (request == null) {
                return;
            }
            Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
            String notes = (String) dt.getExecution().getVariable("notes");
            String status = (String) dt.getExecution().getVariable("status");
            if (dt.getTaskDefinitionKey().equals("statusReportHRApprovalTask")) {
                if (status.equals("approved")) {
                    request.setStage(StatusReportStage.Pending_EEM_Approval);
                } else {
                    request.setStage(StatusReportStage.Pending_Employee_Correction);
                }
            }
            if (dt.getTaskDefinitionKey().equals("statusReportEEMApprovalTask")) {
                request.setStage(StatusReportStage.Complete);
                request.setApprovedBy(currentUser.getEmployeeId());
                request.setApprovedDate(new Date());
            }
            StatusReportDao.instance().save(request);
            CommentDao.instance().addComment(notes, request);

        }
    }

    protected StatusReport getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return StatusReportDao.instance().findById(entityId);
        }
        return null;
    }
}
