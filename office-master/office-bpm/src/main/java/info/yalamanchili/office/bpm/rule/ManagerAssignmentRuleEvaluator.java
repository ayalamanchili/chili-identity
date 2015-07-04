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
import info.chili.bpm.types.Task;
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
    public Task getDelegationInfo(DelegateTask task, BPMTaskDelegateRule rule) {
        Task res = new Task();
        Employee emp = (Employee) task.getExecution().getVariable("currentEmployee");
        Employee reportsToEmp = CompanyContactDao.instance().getCompanyContactForEmployee(emp, "Reports_To");
        if (reportsToEmp != null) {
            res.setAssignee(reportsToEmp.getEmployeeId());
        } else {
            //TODO avoid hard coding
            res.setAssignee("aadmin");
        }
        return res;
    }

}
