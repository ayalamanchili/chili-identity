/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.client;

import info.chili.audit.AuditChangeDto;
import info.chili.audit.AuditService;
import info.chili.email.Email;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.vendor.UpdateVendorNotificationProcess;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author Benarji.v
 */
public class UpdateClientNotificationProcess implements TaskListener {

    @Override
    public void notify(DelegateTask dt) {
        if ("create".equals(dt.getEventName())) {
            updateClientNotificationCreated(dt);
        }
    }

    private void updateClientNotificationCreated(DelegateTask dt) {
        notify(dt, Boolean.FALSE, OfficeRoles.OfficeRole.ROLE_CONTRACTS_ADMIN.name(), OfficeRoles.OfficeRole.ROLE_BILLING_ADMIN.name());
    }

    public void notify(DelegateTask delegateTask, Boolean notifyEmployee, String... notifyRoles) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        UpdateVendorNotificationProcess process = new UpdateVendorNotificationProcess();
        Employee currentEmployee = null;
        if (delegateTask.getExecution().getVariable("currentEmployee") != null) {
            currentEmployee = (Employee) delegateTask.getExecution().getVariable("currentEmployee");
        }
        Email email = new Email();
        email.setRichText(Boolean.TRUE);
        email.setTos(getEmails(notifyRoles));
        Client client = (Client) delegateTask.getExecution().getVariable("client");
        email.setSubject("Task Created:" + delegateTask.getName() + "" + "for" + client.getName());
        List<AuditChangeDto> changes = AuditService.instance().compareWithRecentVersion(client, client.getId());
        Map<String, Object> emailCtx = new HashMap<>();
        List<AuditChangeDto> newChanges = process.getChanges(changes);
        emailCtx.put("changes", newChanges);
        if (currentEmployee != null) {
            emailCtx.put("updatedBy", currentEmployee.getFirstName() + " " + currentEmployee.getLastName());
        }
        emailCtx.put("entity", "Client");
        email.setTemplateName("entity_change_template.html");
        email.setContext(emailCtx);
        email.setHtml(Boolean.TRUE);
        messagingService.sendEmail(email);
    }

    protected String getTaskLink(DelegateTask delegateTask) {
        StringBuilder sb = new StringBuilder();
        sb.append(OfficeServiceConfiguration.instance().getPortalWebUrl()).append("#?entity=info.chili.bpm.types.Task&id=").append(delegateTask.getId());
        return sb.toString();
    }

    public Set<String> getEmails(String... notifyRoles) {
        Set<String> emails = new HashSet();
        if (notifyRoles.length > 0) {
            emails.addAll(MailUtils.instance().getEmailsAddressesForRoles(notifyRoles));
        }
        return emails;
    }
}
