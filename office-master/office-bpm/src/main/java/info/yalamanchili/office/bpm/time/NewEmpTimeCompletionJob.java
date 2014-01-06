/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.time;

import java.util.Date;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 *
 * @author ayalamanchili
 */
public class NewEmpTimeCompletionJob implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        //TODO create prorated timesheets based on period
        //New Employee Two Month Completion Job
    }
}
