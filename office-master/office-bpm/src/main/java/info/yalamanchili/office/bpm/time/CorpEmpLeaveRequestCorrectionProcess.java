/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.email.GenericTaskCompleteNotification;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author ayalamanchili
 */
public class CorpEmpLeaveRequestCorrectionProcess implements TaskListener {

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
        new GenericTaskCompleteNotification().notify(task);
    }

    protected void assignLeaveRequestTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        List<CompanyContact> cnts = CompanyContactDao.instance().getCompanyContact(emp, "Reports_To");
        if (cnts.size() > 0) {
            task.setAssignee(cnts.get(0).getContact().getEmployeeId());
        }
        task.addCandidateGroup(OfficeRoles.OfficeRole.ROLE_HR_ADMINSTRATION.name());
    }
}
