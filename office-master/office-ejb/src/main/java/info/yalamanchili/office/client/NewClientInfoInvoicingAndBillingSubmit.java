/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.entity.profile.Contact;
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
public class NewClientInfoInvoicingAndBillingSubmit implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Object itemNumber = execution.getVariable("itemNumber");
        String acctNotes = (String) execution.getVariable("accountNotes");
        Object specialInvoiceInstructions = execution.getVariable("specialInvoiceInstructions");
        Object timeSheetRequirement = execution.getVariable("timeSheetRequirement");
        Object subcontractorw4Filled = execution.getVariable("subcontractorw4Filled");
        Object subcontractCOI = execution.getVariable("subcontractCOI");
        ClientInformation ci = (ClientInformation) execution.getVariable("clientInfo");
        ClientInformationDao dao = ClientInformationDao.instance();
        ci = dao.findById(ci.getId());
        CommentDao.instance().addComment(acctNotes, ci);
        if (ci != null) {
            if (itemNumber != null) {
                ci.setItemNumber(itemNumber.toString());
            }
            Object signedWO = execution.getVariable("signedCopyOfWorkOrder");
            if (signedWO != null) {
                ci.setSignedCopyOfWorkOrder(Boolean.parseBoolean(signedWO.toString()));
            }
            if (subcontractorw4Filled != null) {
                ci.setSubcontractorw4Filled(Boolean.parseBoolean(subcontractorw4Filled.toString()));
            }

            if (subcontractCOI != null) {
                ci.setSubcontractCOI(Boolean.parseBoolean(subcontractCOI.toString()));
            }
            if (timeSheetRequirement != null) {
                ci.setTimeSheetRequirement(timeSheetRequirement.toString());
            }
            if (specialInvoiceInstructions != null) {
                if (ci.getSpecialInvoiceInstructions() != null && !ci.getSpecialInvoiceInstructions().isEmpty()) {
                    ci.setSpecialInvoiceInstructions(ci.getSpecialInvoiceInstructions() + specialInvoiceInstructions.toString());
                } else {
                    ci.setSpecialInvoiceInstructions(specialInvoiceInstructions.toString());
                }
            }
            execution.setVariable("clientInfo", ci);
            ci = dao.save(ci);
            StringBuilder cliAP = new StringBuilder();
            StringBuilder venAP = new StringBuilder();
            String clientAP = "";
            String vendorAP = "";
            for (Contact clientAPcontact : ci.getClientAPContacts()) {
                cliAP.append(clientAPcontact.details());
                cliAP.append(" ");
            }
            if (ci.getClientAPContacts() != null) {
                clientAP = cliAP.toString().replaceAll("br/", "");
            }
            for (Contact vendorAPcontact : ci.getVendorAPContacts()) {
                venAP.append(vendorAPcontact.details());
                venAP.append(" ");
            }
            if (ci.getVendorAPContacts() != null) {
                vendorAP = venAP.toString().replaceAll("br/", "");
            }
            execution.setVariable("clientAP", clientAP);
            execution.setVariable("vendorAP", vendorAP);
        }
    }
}
