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
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.JavaDelegate;
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
public class CorpEmpLeaveRequestProcess implements TaskListener, JavaDelegate {
    
    @Override
    public void notify(DelegateTask task) {
        if ("create".equals(task.getEventName())) {
            leaveRequestTaskCreated(task);
        }
        if ("complete".equals(task.getEventName())) {
            leaveRequestTaskCompleted(task);
        }
    }

    /**
     * Leave Request Created
     *
     * @param task
     */
    protected void leaveRequestTaskCreated(DelegateTask task) {
        assignTask(task);
        //TODO send notification email
    }
    
    protected void assignTask(DelegateTask task) {
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        List<CompanyContact> cnts = CompanyContactDao.instance().getCompanyContact(emp, "Reports_To");
        if (cnts.size() > 0) {
            task.setAssignee(cnts.get(0).getEmployee().getEmployeeId());
        } else {
            task.addCandidateGroup(OfficeRoles.ROLE_HR);
        }
    }

    /**
     * Leave Request Completed
     *
     * @param task
     */
    protected void leaveRequestTaskCompleted(DelegateTask task) {
        String status = (String) task.getExecution().getVariable("status");
        if ("approved".equals(status)) {
            leaveRequestApproved(task);
        }
        if ("rejected".equals(status)) {
            leaveRequestRejected(task);
        }
    }

    /**
     * Leave request Approved
     *
     * @param task
     */
    protected void leaveRequestApproved(DelegateTask task) {
        
    }

    /**
     * Leave request rejected
     *
     * @param task
     */
    protected void leaveRequestRejected(DelegateTask task) {
        
    }

    /**
     * Escalation Task
     *
     * @param execution
     */
    @Override
    public void execute(DelegateExecution execution) {
        
    }
}
