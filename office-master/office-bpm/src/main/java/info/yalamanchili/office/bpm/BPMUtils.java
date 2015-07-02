/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.chili.spring.SpringContext;
import info.chili.bpm.types.Task;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.activiti.engine.TaskService;
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
        EmployeeDao employeeDao = EmployeeDao.instance();
        Set<String> emails = new HashSet<String>();
        if (delegateTask.getAssignee() != null && !delegateTask.getAssignee().isEmpty()) {
            if (employeeDao.findEmployeWithEmpId(delegateTask.getAssignee()) != null) {
                emails.add(EmployeeDao.instance().getPrimaryEmail(delegateTask.getAssignee()));
            }
        }
        List<String> roles = new ArrayList<String>();
        for (IdentityLink identityLink : delegateTask.getCandidates()) {
            if (identityLink.getGroupId() != null && !identityLink.getGroupId().isEmpty()) {
                roles.add(identityLink.getGroupId());
            }
            if (identityLink.getUserId() != null && !identityLink.getUserId().isEmpty()) {
                Employee emp = MailUtils.instance().findEmployeWithEmpId(identityLink.getUserId());
                if (emp != null && emp.getPrimaryEmail() != null) {
                    emails.add(employeeDao.getPrimaryEmail(emp));
                }
            }
        }
        if (roles.size() > 0) {
            emails.addAll(MailUtils.instance().getEmailsAddressesForRoles(roles.toArray(new String[roles.size()])));
        }
        return emails;
    }

//TODO merge with above
    public static Set<String> getCandidateEmails(org.activiti.engine.task.Task task) {
        TaskService bpmTaskService = (TaskService) SpringContext.getBean("bpmTaskService");
        Set<String> emails = new HashSet<String>();
        EmployeeDao employeeDao = EmployeeDao.instance();
        if (task.getAssignee() != null && !task.getAssignee().isEmpty()) {
            if (employeeDao.findEmployeWithEmpId(task.getAssignee()) != null) {
                emails.add(employeeDao.getPrimaryEmail(task.getAssignee()));
            }
        }
        List<String> roles = new ArrayList<String>();
        List<IdentityLink> identityLinks = bpmTaskService.getIdentityLinksForTask(task.getId());
        for (IdentityLink identityLink : identityLinks) {
            if (identityLink.getGroupId() != null && !identityLink.getGroupId().isEmpty()) {
                roles.add(identityLink.getGroupId());
            }
            if (identityLink.getUserId() != null && !identityLink.getUserId().isEmpty()) {
                Employee emp = MailUtils.instance().findEmployeWithEmpId(identityLink.getUserId());
                if (emp != null) {
                    String primaryEmail = employeeDao.getPrimaryEmail(emp);
                    if (primaryEmail != null) {
                        emails.add(emp.getPrimaryEmail().getEmail());
                    }
                }
            }
        }
        if (roles.size() > 0) {
            emails.addAll(MailUtils.instance().getEmailsAddressesForRoles(roles.toArray(new String[roles.size()])));
        }
        return emails;
    }

}
