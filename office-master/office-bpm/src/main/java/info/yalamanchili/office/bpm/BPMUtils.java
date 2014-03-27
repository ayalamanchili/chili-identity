/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.yalamanchili.office.bpm.types.Task;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.task.IdentityLink;

/**
 *
 * @author anuyalamanchili
 */
public class BPMUtils {

    public List<Task> getTasksforProcessid(String processId) {
        return OfficeBPMTaskService.instance().getTasksForProcessId(processId);
    }

    public Task getTaskForProcessId(String processId) {
        OfficeBPMTaskService taskService = OfficeBPMTaskService.instance();
        List<Task> tasks = taskService.getTasksForProcessId(processId);
        if (tasks.size() > 0) {
            return tasks.get(0);
        } else {
            return null;
        }
    }

    public static Set<String> getCandidateEmails(DelegateTask delegateTask) {
        Set<String> emails = new HashSet<String>();
        if (delegateTask.getAssignee() != null && !delegateTask.getAssignee().isEmpty()) {
            if (EmployeeDao.instance().findEmployeWithEmpId(delegateTask.getAssignee()) != null) {
                emails.add(EmployeeDao.instance().findEmployeWithEmpId(delegateTask.getAssignee()).getPrimaryEmail().getEmail());
            }
        }
        List<String> roles = new ArrayList<String>();
        for (IdentityLink identityLink : delegateTask.getCandidates()) {
            if (identityLink.getGroupId() != null && !identityLink.getGroupId().isEmpty()) {
                roles.add(identityLink.getGroupId());
            }
            if (identityLink.getUserId() != null && !identityLink.getUserId().isEmpty()) {
                Employee emp = MailUtils.instance().findEmployee(identityLink.getUserId());
                if (emp != null && emp.getPrimaryEmail() != null) {
                    emails.add(emp.getPrimaryEmail().getEmail());
                }
            }
        }
        if (roles.size() > 0) {
            emails.addAll(MailUtils.instance().getEmailsAddressesForRoles(roles.toArray(new String[roles.size()])));
        }
        return emails;
    }
}
