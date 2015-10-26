/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.ClientInformationStatus;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Transactional
public class NewClientInfoAccountSubmit implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Object itemNumber = execution.getVariable("itemNumber");
        Object acctNotes = execution.getVariable("accountNotes");
        Object specialInvoiceInstructions = execution.getVariable("specialInvoiceInstructions");
        ClientInformation ci = (ClientInformation) execution.getVariable("clientInfo");
        ClientInformationDao dao = ClientInformationDao.instance();
        ci = dao.findById(ci.getId());
        if (ci != null) {
            if (itemNumber != null) {
                ci.setItemNumber(itemNumber.toString());
            }
            if (acctNotes != null) {
                if (ci.getNotes() != null && !ci.getNotes().isEmpty()) {
                    ci.setNotes(ci.getNotes() + acctNotes.toString());
                } else {
                    ci.setNotes(acctNotes.toString());
                }
            }
            Object signedWO = execution.getVariable("signedCopyOfWorkOrder");
            if (signedWO != null) {
                ci.setSignedCopyOfWorkOrder(Boolean.parseBoolean(signedWO.toString()));
            }
            if (specialInvoiceInstructions != null) {
                if (ci.getSpecialInvoiceInstructions() != null && !ci.getSpecialInvoiceInstructions().isEmpty()) {
                    ci.setSpecialInvoiceInstructions(ci.getSpecialInvoiceInstructions() + specialInvoiceInstructions.toString());
                } else {
                    ci.setSpecialInvoiceInstructions(specialInvoiceInstructions.toString());
                }
            }
            ci.setStatus(ClientInformationStatus.PENDING_HR_VERIFICATION);
            ci = dao.instance().save(ci);
        }
    }
}
