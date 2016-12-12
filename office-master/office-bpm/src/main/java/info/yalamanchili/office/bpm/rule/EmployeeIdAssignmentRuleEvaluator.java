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
import java.util.ArrayList;
import java.util.Arrays;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class EmployeeIdAssignmentRuleEvaluator extends AbstractTaskDelegate {

    @Override
    public void delegate(DelegateTask task, BPMTaskDelegateRule rule) {
        String[] ids = rule.getAttributeData().split(",");
        if (ids.length == 1) {
            task.setAssignee(ids[0]);
        } else if (ids.length > 1) {
            for(String employeeId:new ArrayList<>(Arrays.asList(ids))){
                task.addCandidateUser(employeeId);
            }
        }
    }
}
