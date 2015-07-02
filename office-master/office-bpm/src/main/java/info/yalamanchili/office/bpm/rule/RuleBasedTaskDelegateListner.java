/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.rule;

import info.chili.bpm.task.AbstractRuleBasedTaskDelegateListner;
import info.yalamanchili.office.bpm.email.GenericTaskCreateNotification;
import org.activiti.engine.delegate.DelegateTask;

/**
 *
 * @author ayalamanchili
 */
public class RuleBasedTaskDelegateListner extends AbstractRuleBasedTaskDelegateListner {

    @Override
    public void processTask(DelegateTask task) {
        new GenericTaskCreateNotification().notify(task);
    }

}
