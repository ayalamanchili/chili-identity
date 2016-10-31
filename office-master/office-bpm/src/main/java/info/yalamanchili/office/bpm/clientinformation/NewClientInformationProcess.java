/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bpm.clientinformation;

import com.google.common.base.Strings;
import info.chili.email.Email;
import info.chili.service.jrs.exception.ServiceException;
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
import java.math.BigDecimal;
import org.activiti.engine.delegate.DelegateTask;
import org.apache.commons.lang.StringUtils;
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

        if (task.getTaskDefinitionKey().equals("newClientInfoContractValidation")) {
            String status = (String) task.getExecution().getVariable("status");
            String nottes = (String) task.getExecution().getVariable("nottes");
            CommentDao.instance().addComment("New Client Info Contract Validation Task: " + nottes, entity);
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ClientInformationStatus.PENDING_INVOICING_BILLING_APPROVAL);
                sendNewClieniInformationNotification(entity, nottes, task);
            } else {
                entity.setStatus(ClientInformationStatus.CANCELED);
            }
        }

        //Status
        String status = (String) task.getExecution().getVariable("status");
        String itemno = (String) task.getExecution().getVariable("itemNumber");
        if (task.getTaskDefinitionKey().equals("newClientInfoInvoicingAndBillingTask")) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ClientInformationStatus.PENDING_PAYROLL_VERIFICATION);
                sendNewClieniInformationNotification(entity, itemno, task);
            } else {
                entity.setStatus(ClientInformationStatus.CANCELED);
            }
        }
        if (task.getTaskDefinitionKey().equals("newClientInfoPayrollTask")) {
            String payratePercent = (String) task.getExecution().getVariable("payratePercent");
            String payrate = (String) task.getExecution().getVariable("payrate");
            String specialNotes = (String) task.getExecution().getVariable("specialNotes");
//            Integer payratePercentNum;
//            if ((!Strings.isNullOrEmpty(payrate) && !Strings.isNullOrEmpty(payratePercent)) || ((Strings.isNullOrEmpty(payrate) && Strings.isNullOrEmpty(payratePercent)))) {
//                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "task.invalid", "Please enter either payrate or payrate percentage. You can not enter both");
//            }
//            if (!StringUtils.isNumeric(payrate)) {
//                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "payrate.invalid", "Please enter valid payrate");
//            }
//            if (!StringUtils.isNumeric(payratePercent)) {
//                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "payratepercentage.invalid", "Please enter valid percentage");
//            }
//            if (!Strings.isNullOrEmpty(payratePercent)) {
//                payratePercentNum = Integer.valueOf(payratePercent);
//
//                if (payratePercentNum > 100 || payratePercentNum < 0) {
//                    throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "payratepercentage.not.number", "Please enter valid percentage between 0 and 100 eg: 80");
//                }
//            }
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ClientInformationStatus.PENDING_HR_VERIFICATION);
                if (StringUtils.isNotEmpty((payratePercent))) {
                    entity.setPayRatePercentage(Float.valueOf(payratePercent));
                }
                if (StringUtils.isNotEmpty((payrate))) {
                    entity.setPayRate(BigDecimal.valueOf(Long.valueOf(payrate)));
                }
                if (StringUtils.isNotEmpty(specialNotes)) {
                    CommentDao.instance().addComment("New Client Info Payroll Department Task: " + specialNotes, entity);
                }
            } else {
                entity.setStatus(ClientInformationStatus.CANCELED);
            }
        }
        if (task.getTaskDefinitionKey()
                .equals("newClientInfoSUBCTask")) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ClientInformationStatus.COMPLETED);
            } else {
                entity.setStatus(ClientInformationStatus.CANCELED);
            }
        }
        if (task.getTaskDefinitionKey()
                .equals("newClientInfoHRTask")) {
            if (status.equalsIgnoreCase("approved")) {
                entity.setStatus(ClientInformationStatus.COMPLETED);
            } else {
                entity.setStatus(ClientInformationStatus.CANCELED);
            }
        }
        ClientInformationDao.instance()
                .save(entity);
    }

    @Async
    @Transactional
    public void sendNewClieniInformationNotification(ClientInformation ci, String itemNo, DelegateTask task) {
        Employee emp = OfficeSecurityService.instance().getCurrentUser();
        Email email = new Email();
        email.setTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRoles.OfficeRole.ROLE_BILLING_AND_INVOICING.name()));
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.setSubject("New File/Project   : " + ci.getEmployee().getFirstName() + " " + ci.getEmployee().getLastName());
        String messageText = "<h3> <b> Client Information : </b> </h3> </br> ";
        messageText = messageText.concat("\n  <b> Client &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp : </b>  " + ci.getClient().getName() + "</br>");
        messageText = messageText.concat("\n  <b> Item_No  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp : </b> " + itemNo + "</br>");
        if (ci.getVendor() != null) {
            messageText = messageText.concat(" \n <b> Vendor  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp : </b> " + ci.getVendor().getName() + "</br>");
        }
        if (ci.getSubcontractor() != null) {
            messageText = messageText.concat("\n <b> Subcontractor &nbsp;&nbsp;&nbsp;&nbsp : </b>" + ci.getSubcontractor().getName() + "</br>");
        }
        if (ci.getCompany() != null) {
            messageText = messageText.concat("\n <b> Company  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp : </b> " + ci.getCompany().name() + "</br>");
        }
        messageText = messageText.concat("\n <b> Project Start Date  &nbsp :  </b> " + ci.getStartDate() + "</br>");
        messageText = messageText.concat("\n  <b> Updated_By &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp : </b> " + emp.getFirstName() + " " + emp.getLastName() + "</br>");
        if (task.getExecution().getVariable("specialInvoiceInstructions") != null) {
            messageText = messageText.concat("\n <b> Special Invoice Instructions : </b> " + task.getExecution().getVariable("specialInvoiceInstructions") + "</br>");
        }
        if (task.getExecution().getVariable("accountNotes") != null) {
            messageText = messageText.concat("\n <b> Account Notes : </b>" + task.getExecution().getVariable("accountNotes"));
        }
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
