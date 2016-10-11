/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.vendor;

import info.chili.audit.AuditChangeDto;
import info.chili.audit.AuditService;
import info.chili.email.Email;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.BPMUtils;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.client.Vendor;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.selfserv.TicketComment;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 *
 * @author Srinivas
 */
public class UpdateVendorNotificationProcess implements TaskListener {

    @Override
    public void notify(DelegateTask dt) {
        if ("create".equals(dt.getEventName())) {
            updateVendorNotificationCreated(dt);
        }
    }

    private void updateVendorNotificationCreated(DelegateTask dt) {
        notify(dt, Boolean.FALSE);
    }

    public void notify(DelegateTask delegateTask, Boolean notifyEmployee, String... notifyRoles) {
        MessagingService messagingService = (MessagingService) SpringContext.getBean("messagingService");
        Employee currentEmployee = null;
        if (delegateTask.getExecution().getVariable("currentEmployee") != null) {
            currentEmployee = (Employee) delegateTask.getExecution().getVariable("currentEmployee");
            //TODO is this needed?
            delegateTask.setOwner(currentEmployee.getFirstName() + " " + currentEmployee.getLastName());
        }
        Email email = new Email();
        email.setRichText(Boolean.TRUE);
        email.setTos(getEmails(delegateTask, notifyEmployee, notifyRoles));
        email.setSubject("Task Created:" + delegateTask.getName());

        //messageText = messageText.concat("<table><thead><tr><th><p>Updated Vendor Fields</p></th></tr></thead><tbody>");
        Vendor vendor = (Vendor) delegateTask.getExecution().getVariable("vendor");
        List<AuditChangeDto> changes = AuditService.instance().compareWithRecentVersion(vendor, vendor.getId());
        Map<String, Object> emailCtx = new HashMap<>();
        //List<TicketComment> comments = new ArrayList<>();
        //comments.addAll(comment.getTicket().getComments());
        //emailCtx.put("comments", comments);
        try{
        emailCtx.put("changes", changes);
        if(currentEmployee != null)
            emailCtx.put("updatedBy", currentEmployee.getFirstName()+" "+ currentEmployee.getLastName());
        emailCtx.put("entity", "Vendor");
        }catch(Exception e){
            e.printStackTrace();
        }
        email.setTemplateName("entity_change_template.html");
        email.setContext(emailCtx);
        
        //messageText = messageText.concat("<br/> <br/> &nbsp; <b>Please click on the below link to complete the task: </b> <br/> &nbsp; " + getTaskLink(delegateTask));
        email.setHtml(Boolean.TRUE);
        messagingService.sendEmail(email);
    }

    protected String getTaskLink(DelegateTask delegateTask) {
        StringBuilder sb = new StringBuilder();
        sb.append(OfficeServiceConfiguration.instance().getPortalWebUrl()).append("#?entity=info.chili.bpm.types.Task&id=").append(delegateTask.getId());
        return sb.toString();
    }

    public Set<String> getEmails(DelegateTask delegateTask, Boolean notifyEmployeeAlso, String... notifyRoles) {
        Set<String> emails = new HashSet();
        emails.addAll(BPMUtils.getCandidateEmails(delegateTask));
        if (notifyRoles.length > 0) {
            emails.addAll(MailUtils.instance().getEmailsAddressesForRoles(notifyRoles));
        }
        if (notifyEmployeeAlso) {
            Employee employee = (Employee) delegateTask.getExecution().getVariable("currentEmployee");
            if (employee != null) {
                emails.add(EmployeeDao.instance().getPrimaryEmail(employee.getId()));
            }
        }
        return emails;
    }

}
