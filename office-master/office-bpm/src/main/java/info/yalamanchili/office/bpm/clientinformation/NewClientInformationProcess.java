/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.clientinformation;

import info.chili.email.Email;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.rule.RuleBasedTaskDelegateListner;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Transactional
public class NewClientInformationProcess extends RuleBasedTaskDelegateListner {
    
    @Override
    public void processTask(DelegateTask task) {
        super.processTask(task);
        if ("create".equals(task.getEventName()) || "assignment".equals(task.getEventName())) {
            getRequestFromTask(task).setBpmProcessId(task.getExecution().getProcessInstanceId());
        }
        if ("complete".equals(task.getEventName())) {
            clientInforamtionTaskCompleted(task);
        }
    }
    
    protected void clientInforamtionTaskCompleted(DelegateTask task) {
        ClientInformation entity = getRequestFromTask(task);
        if (entity == null) {
            return;
        }
        //Notes
        String notes = (String) task.getExecution().getVariable("notes");
        CommentDao.instance().addComment(notes, entity);

        //Status
        String status = (String) task.getExecution().getVariable("status");
        String itemno = (String) task.getExecution().getVariable("itemNumber");
        if (task.getTaskDefinitionKey().equals("newClientInfoInvoicingAndBillingTask")) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ClientInformationStatus.PENDING_HR_VERIFICATION);
                sendNewClieniInformationNotification(entity, itemno);
            } else {
                entity.setStatus(ClientInformationStatus.CANCELED);
            }
        }
        if (task.getTaskDefinitionKey().equals("newClientInfoHRTask")) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ClientInformationStatus.COMPLETED);
            } else {
                entity.setStatus(ClientInformationStatus.CANCELED);
            }
        }
        ClientInformationDao.instance().save(entity);
    }
    
    @Async
    @Transactional
    public void sendNewClieniInformationNotification(ClientInformation ci, String itemNo) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        Email email = new Email();
        email.setTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_BILLING_AND_INVOICING.name()));
        email.setHtml(Boolean.TRUE);
        email.setSubject("New File/ project   : " + ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
        String messageText = " Client Information : ";
        messageText = messageText.concat(" \n  Client :  " + ci.getClient().getName());
        messageText = messageText.concat("\n  Item_No : " + itemNo);
        if (ci.getVendor() != null) {
            messageText = messageText.concat("\n Vendor  : " + ci.getVendor().getName());
        }
        if (ci.getSubcontractor() != null) {
            messageText = messageText.concat("\n Subcontractor :" + ci.getSubcontractor().getName());
        }
        if (ci.getCompany() != null) {
            messageText = messageText.concat("\n Company :" + ci.getCompany().name());
        }
        messageText = messageText.concat("\n Project Start Date :" + ci.getStartDate());
        messageText = messageText.concat("\n  Updated_By :" + emp.getFirstName() + " " + emp.getLastName());
        email.setBody(messageText);
        MessagingService.instance().sendEmail(email);
    }
    
    protected ClientInformation getRequestFromTask(DelegateTask task) {
        Long entityId = (Long) task.getExecution().getVariable("entityId");
        if (entityId != null) {
            return ClientInformationDao.instance().findById(entityId);
        }
        return null;
    }
    
}
