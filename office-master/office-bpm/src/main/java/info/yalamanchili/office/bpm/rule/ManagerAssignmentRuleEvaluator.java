/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.rule;

import info.chili.bpm.domain.BPMTaskDelegateRule;
import info.chili.bpm.task.AbstractTaskDelegate;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.entity.profile.Employee;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class ManagerAssignmentRuleEvaluator extends AbstractTaskDelegate {

    @Override
    public void delegate(DelegateTask task, BPMTaskDelegateRule rule) {
        if (task.getExecution().getVariable("approvalManager") != null) {
            task.setAssignee((String) task.getExecution().getVariable("approvalManager"));
            return;
        }
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        Employee reportsToEmp = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        if (reportsToEmp != null) {
            task.setAssignee(reportsToEmp.getEmployeeId());
        } else {
            //TODO avoid hard coding
            task.setAssignee("aadmin");
        }
    }

}
