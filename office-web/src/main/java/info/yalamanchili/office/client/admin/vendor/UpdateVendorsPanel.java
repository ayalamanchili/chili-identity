/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class UpdateVendorsPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateVendorsPanel.class.getName());
    protected BooleanField submitForUpdateP = new BooleanField(OfficeWelcome.constants2, "Select To Update CPD's Payment Terms", "Vendors", false, false, Alignment.HORIZONTAL);
    protected BooleanField submitForUpdateF = new BooleanField(OfficeWelcome.constants2, "Select To Update CPD's Frequency", "Vendors", false, false, Alignment.HORIZONTAL);
    protected BooleanField submitForUpdateD = new BooleanField(OfficeWelcome.constants2, "Select To Update CPD's Invoice Delivery Method", "Vendors", false, false, Alignment.HORIZONTAL);

    public UpdateVendorsPanel(JSONObject entity) {
        initUpdateComposite(entity, "Vendors", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("website", entity);
        assignEntityValueFromField("paymentTerms", entity);
        assignEntityValueFromField("vendorinvFrequency", entity);
        assignEntityValueFromField("vendorinvDeliveryMethod", entity);
        assignEntityValueFromField("vendorFees", entity);
        assignEntityValueFromField("maxFees", entity);
        assignEntityValueFromField("minFees", entity);
        assignEntityValueFromField("msaValDate", entity);
        assignEntityValueFromField("msaExpDate", entity);
        assignEntityValueFromField("terminationNotice", entity);
//      assignEntityValueFromField("description", entity);
        assignEntityValueFromField("vendorType", entity);
        assignEntityValueFromField("coiEndDate", entity);
        assignEntityValueFromField("vendorStatus", entity);

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
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.client.Vendor"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("website", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("paymentTerms", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorinvFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("vendorinvDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("vendorFees", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("maxFees", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("minFees", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("msaValDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("msaExpDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("terminationNotice", entity, DataType.STRING_FIELD);
//      assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("coiEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("vendorStatus", entity, DataType.ENUM_FIELD);
        populateComments();
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Vendor Information");
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new VendorsSidePanel());
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorsPanel());
    }

    @Override
    protected void addListeners() {
        submitForUpdateF.getBox().addClickHandler(this);
        submitForUpdateP.getBox().addClickHandler(this);
        submitForUpdateD.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
        submitForUpdateF.setValue(false);
        submitForUpdateP.setValue(false);
        submitForUpdateD.setValue(false);
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("website", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("vendorType", false, true, VendorType.names(), Alignment.HORIZONTAL);
        addField("paymentTerms", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(submitForUpdateP);
        addEnumField("vendorinvFrequency", false, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(submitForUpdateF);
        addEnumField("vendorinvDeliveryMethod", false, true, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(submitForUpdateD);
        addField("vendorFees", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("maxFees", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("minFees", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("terminationNotice", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
//        addField("description", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("coiEndDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("vendorStatus", false, false, VendorStatus.names(), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "vendor/updatecpd" + "?submitForUpdateF=" + submitForUpdateF.getValue() + "&submitForUpdateP=" + submitForUpdateP.getValue() + "&submitForUpdateD=" + submitForUpdateD.getValue();
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        DateField msaValDate = (DateField) fields.get("msaValDate");
        DateField msaExpDate = (DateField) fields.get("msaExpDate");
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
        EnumField vendorTypeF = (EnumField) fields.get("vendorType");
        if (vendorTypeF.getValue() == null || "".equals(vendorTypeF.getValue())) {
            vendorTypeF.setMessage("Please enter Vendor Type ");
            valid = false;
        }
        StringField paymentTermsF = (StringField) fields.get("paymentTerms");
        if (paymentTermsF.getValue() == null || "".equals(paymentTermsF.getValue())) {
            paymentTermsF.setMessage("Please enter the Payment Terms");
            valid = false;
        }
        StringField terminationNoticeF = (StringField) fields.get("terminationNotice");
        if (terminationNoticeF.getValue() == null || "".equals(terminationNoticeF.getValue())) {
            terminationNoticeF.setMessage("Please enter the Termination Notice Period");
            valid = false;
        }
        EnumField vendorinvFrequencyF = (EnumField) fields.get("vendorinvFrequency");
        if (vendorinvFrequencyF.getValue() == null || "".equals(vendorinvFrequencyF.getValue())) {
            vendorinvFrequencyF.setMessage("Please enter Invoice Frequency ");
            valid = false;
        }
        EnumField vendorinvDeliveryMethodF = (EnumField) fields.get("vendorinvDeliveryMethod");
        if (vendorinvDeliveryMethodF.getValue() == null || "".equals(vendorinvDeliveryMethodF.getValue())) {
            vendorinvDeliveryMethodF.setMessage("Please enter Invoice Delivery Method ");
            valid = false;
        }
        return valid;
    }

}
