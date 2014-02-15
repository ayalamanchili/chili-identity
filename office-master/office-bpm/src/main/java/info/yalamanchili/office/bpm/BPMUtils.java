/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm;

import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.email.MailUtils;
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
                emails.add(identityLink.getUserId());
            }
        }
        if (roles.size() > 0) {
            emails.addAll(MailUtils.instance().getEmailsAddressesForRoles(roles.toArray(new String[roles.size()])));
        }
        return emails;
    }
}
