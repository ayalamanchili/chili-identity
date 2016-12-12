/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.admin.vendor.ClientStatus;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;

/**
 *
 * @author raghu
 */
public class UpdateClientPanel extends UpdateComposite {

    protected BooleanField isDirectClient;
    HTML directClientNote = new HTML("<h4 style=\"color:#427fed\">" + "For a  Direct "
            + "Client: Payment Terms, Invoice Frequency, Invoice Delivery Method"
            + "</br>MSA Validity Period From & To and "
            + "Termination Notice Period are also required!</h4>");

    public UpdateClientPanel(JSONObject entity) {
        initUpdateComposite(entity, "Client", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
//        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("website", entity);
        assignEntityValueFromField("directClient", entity);
        assignEntityValueFromField("paymentTerms", entity);
        assignEntityValueFromField("clientinvFrequency", entity);
        assignEntityValueFromField("clientFee", entity);
//        assignEntityValueFromField("maxClientFee", entity);
//        assignEntityValueFromField("minClientFee", entity);
        assignEntityValueFromField("msaValDate", entity);
        assignEntityValueFromField("msaExpDate", entity);
        assignEntityValueFromField("clientInvDeliveryMethod", entity);
        assignEntityValueFromField("terminationNoticePeriod", entity);
        assignEntityValueFromField("clientStatus", entity);
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
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.client.Client"));
    }
    
    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
//        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("website", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("directClient", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("paymentTerms", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientinvFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("clientFee", entity, DataType.FLOAT_FIELD);
        isDirectClient = (BooleanField) fields.get("directClient");
//        assignFieldValueFromEntity("maxClientFee", entity, DataType.FLOAT_FIELD);
//        assignFieldValueFromEntity("minClientFee", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("msaValDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("msaExpDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("clientInvDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("terminationNoticePeriod", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("clientStatus", entity, DataType.ENUM_FIELD);
        populateComments();
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Client");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientsPanel());
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new ClientSidePanel());
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
//        addField("description", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("website", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("directClient", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(directClientNote);
//        directClientNote.setVisible(false);
        addField("paymentTerms", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("clientinvFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("clientInvDeliveryMethod", false, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        addField("clientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
//        addField("maxClientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
//        addField("minClientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("terminationNoticePeriod", false, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addEnumField("clientStatus", false, false, ClientStatus.names(), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }
    
    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        valid = isMsaToDateAfterMsaFrom(valid);
        if (isDirectClient.getValue()) {
            valid = checkDirectClientValidations(valid);
        }
        return valid;
    }

    private boolean isMsaToDateAfterMsaFrom(boolean valid) {
        DateField msaValDate = (DateField) fields.get("msaValDate");
        DateField msaExpDate = (DateField) fields.get("msaExpDate");
        if (msaValDate.getDate() != null && msaExpDate.getDate() != null && msaValDate.getDate().after(msaExpDate.getDate())) {
            msaExpDate.setMessage("To Date must be after From Date");
            valid = false;
        }
        return valid;
    }

    private boolean checkDirectClientValidations(boolean valid) {
        StringField paymentTerms = (StringField) fields.get("paymentTerms");
        if (paymentTerms.getValue() == null || "".equals(paymentTerms.getValue())) {
            paymentTerms.setMessage("Please enter the Payment Terms");
            valid = false;
        }
        EnumField invoiceFrequency = (EnumField) fields.get("clientinvFrequency");
        if (invoiceFrequency.getValue() == null || "".equals(invoiceFrequency.getValue())) {
            invoiceFrequency.setMessage("Please select Invoice Frequency");
            valid = false;
        }
        EnumField invoiceDeliveryMentod = (EnumField) fields.get("clientInvDeliveryMethod");
        if (invoiceDeliveryMentod.getValue() == null || "".equals(invoiceDeliveryMentod.getValue())) {
            invoiceDeliveryMentod.setMessage("Please select Invoice Delivery Method");
            valid = false;
        }
//        FloatField clientFee = (FloatField) fields.get("clientFee");
//        if (clientFee.getValue() == null || "".equals(clientFee.getValue())) {
//            clientFee.setMessage("Please enter the Client Fee");
//            valid = false;
//        }
        DateField msaValDate = (DateField) fields.get("msaValDate");
        if (msaValDate.getDate() == null || "".equals(msaValDate.getDate())) {
            msaValDate.setMessage("MSA Period From cannot be Empty");
            valid = false;
        }
        DateField msaExpDate = (DateField) fields.get("msaExpDate");
        if (msaExpDate.getDate() == null || "".equals(msaExpDate.getDate())) {
            msaExpDate.setMessage("MSA Period To cannot be Empty");
            valid = false;
        }
        IntegerField termNoticePeriod = (IntegerField) fields.get("terminationNoticePeriod");
        if (termNoticePeriod.getValue() == null || "".equals(termNoticePeriod.getValue())) {
            termNoticePeriod.setMessage("Please enter the Termination Notice Period");
            valid = false;
        }
        return valid;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client";
    }
}
