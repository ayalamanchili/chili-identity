/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcontractor;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.vendor.SubcontractorStatus;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;

/**
 *
 * @author anuyalamanchili
 */
public class UpdateSubcontractorPanel extends UpdateComposite {

    public UpdateSubcontractorPanel(JSONObject entity) {
        initUpdateComposite(entity, "Subcontractor", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        //assignEntityValueFromField("description", entity);
        assignEntityValueFromField("website", entity);
        assignEntityValueFromField("paymentTerms", entity);
        assignEntityValueFromField("invoiceFrequency", entity);
        assignEntityValueFromField("invoiceDeliveryMethod", entity);
        assignEntityValueFromField("coiEndDate", entity);
        assignEntityValueFromField("msaValDate", entity);
        assignEntityValueFromField("msaExpDate", entity);
        assignEntityValueFromField("terminationNoticePeriod", entity);
        assignEntityValueFromField("subcontractorStatus", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                postUpdateSuccess(arg0);
            }
        });
    }
    
    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.client.Subcontractor"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        // assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("website", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("paymentTerms", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("coiEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("msaValDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("msaExpDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("terminationNoticePeriod", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("subcontractorStatus", entity, DataType.ENUM_FIELD);
        populateComments();
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Subcontractor Information");
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new SubcontractorSidePanel());
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSubcontractorsPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        //addField("description", false, false, DataType.STRING_FIELD);
        addField("website", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("paymentTerms", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("invoiceFrequency", false, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("invoiceDeliveryMethod", false, true, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        addField("coiEndDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("terminationNoticePeriod", false, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addEnumField("subcontractorStatus", false, false, SubcontractorStatus.names(), Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "subcontractor";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        DateField coiEndDate = (DateField) fields.get("coiEndDate");
        DateField msaValDate = (DateField) fields.get("msaValDate");
        DateField msaExpDate = (DateField) fields.get("msaExpDate");
        if (coiEndDate.getDate() == null || "".equals(coiEndDate.getDate())) {
            coiEndDate.setMessage("Please enter the COI end date");
            valid = false;
        }
        if (msaValDate.getDate() == null || "".equals(msaValDate.getDate())) {
            msaValDate.setMessage("Please enter the MSA Validity Period from date");
            valid = false;
        }
        if (msaExpDate.getDate() == null || "".equals(msaExpDate.getDate())) {
            msaExpDate.setMessage("Please enter the MSA Validity Period to date");
            valid = false;
        }
        if (msaValDate.getDate() != null && msaExpDate.getDate() != null && msaValDate.getDate().after(msaExpDate.getDate())) {
            msaExpDate.setMessage("To Date must be after From Date");
            return false;
        }
        StringField nameF = (StringField) fields.get("name");
        if (nameF.getValue() == null || "".equals(nameF.getValue())) {
            nameF.setMessage("Please enter Sub Contractor Name");
            valid = false;
        }
        StringField paymentTermsF = (StringField) fields.get("paymentTerms");
        if (paymentTermsF.getValue() == null || "".equals(paymentTermsF.getValue())) {
            paymentTermsF.setMessage("Please enter  Payment Terms");
            valid = false;
        }
        EnumField invoiceFrequencyF = (EnumField) fields.get("invoiceFrequency");
        if (invoiceFrequencyF.getValue() == null || "".equals(invoiceFrequencyF.getValue())) {
            invoiceFrequencyF.setMessage("Please enter Invoice Frequency");
            valid = false;
        }
        EnumField invoiceDeliveryMethodF = (EnumField) fields.get("invoiceDeliveryMethod");
        if (invoiceDeliveryMethodF.getValue() == null || "".equals(invoiceDeliveryMethodF.getValue())) {
            invoiceDeliveryMethodF.setMessage("Please enter Invoice Delivery Method");
            valid = false;
        }
        IntegerField terminationNoticePeriodF = (IntegerField) fields.get("terminationNoticePeriod");
        if (terminationNoticePeriodF.getValue() == null || "".equals(terminationNoticePeriodF.getValue())) {
            terminationNoticePeriodF.setMessage("please enter Termination Notice Period");
            valid = false;
        }
        return valid;
    }

}
