/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.updateBillingRate;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ClientInfoOptionsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadClientInfoPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateUpdateBillingRatePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(CreateUpdateBillingRatePanel.class.getName());
    protected String clientInfoId;

    public CreateUpdateBillingRatePanel(String clientInfoId, JSONObject entity) {
        this.clientInfoId = clientInfoId;
        initUpdateComposite(entity, "UpdateBillingRate", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject billingRate = new JSONObject();
        //      assignEntityValueFromField("payRate", billingRate);
        assignEntityValueFromField("billingRate", billingRate);
        //      assignEntityValueFromField("overTimePayRate", billingRate);
        assignEntityValueFromField("overTimeBillingRate", billingRate);
        assignEntityValueFromField("effectiveDate", billingRate);
        assignEntityValueFromField("billingInvoiceFrequency", billingRate);
        assignEntityValueFromField("subContractorPayRate", billingRate);
        assignEntityValueFromField("subContractorOverTimePayRate", billingRate);
        assignEntityValueFromField("subContractorInvoiceFrequency", billingRate);
        return billingRate;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        //      assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
        //      assignFieldValueFromEntity("overTimePayRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("billingInvoiceFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("subContractorPayRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("subContractorOverTimePayRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("subContractorInvoiceFrequency", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
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

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Billing Rate Info");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadClientInfoPanel(clientInfoId));
        GenericPopup.instance().hide();
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("effectiveDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        // addField("payRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("billingRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        // addField("overTimePayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("overTimeBillingRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addEnumField("billingInvoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addField("subContractorPayRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("subContractorOverTimePayRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addEnumField("subContractorInvoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation/update-billing-rate/" + clientInfoId;
    }
}
