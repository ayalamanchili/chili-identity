/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.updateBillingRate;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import info.yalamanchili.office.client.profile.cllientinfo.ReadClientInfoPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateUpdateBillingRatePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(CreateUpdateBillingRatePanel.class.getName());
    protected JSONObject clientInfo;
    protected JSONObject ci;
    protected boolean isSubOr1099 = false;

    public CreateUpdateBillingRatePanel(JSONObject clientInfo, JSONObject entity) {
        this.clientInfo = clientInfo;
        if (entity.get("employee") != null) {
            JSONObject employee = entity.get("employee").isObject();
            JSONObject employeeType = employee.get("employeeType").isObject();
            String type = JSONUtils.toString(employeeType, "name");
            if ((type.compareTo("1099 Contractor") == 0) || (type.compareTo("Subcontractor") == 0)) {
                isSubOr1099 = true;
            }
        }
        initUpdateComposite(entity, "UpdateBillingRate", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject billingRate = new JSONObject();
        assignEntityValueFromField("billingRate", billingRate);
        assignEntityValueFromField("overTimeBillingRate", billingRate);
        assignEntityValueFromField("effectiveDate", billingRate);
        assignEntityValueFromField("billingInvoiceFrequency", billingRate);
        if (isSubOr1099) {
            assignEntityValueFromField("subContractorPayRate", billingRate);
            assignEntityValueFromField("subContractorOverTimePayRate", billingRate);
            assignEntityValueFromField("subContractorInvoiceFrequency", billingRate);
        }
        return billingRate;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
//        assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
//        assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
//        assignFieldValueFromEntity("billingInvoiceFrequency", entity, DataType.ENUM_FIELD);
//        if (isSubOr1099) {
//            assignFieldValueFromEntity("subContractorPayRate", entity, DataType.CURRENCY_FIELD);
//            assignFieldValueFromEntity("subContractorOverTimePayRate", entity, DataType.CURRENCY_FIELD);
//            assignFieldValueFromEntity("subContractorInvoiceFrequency", entity, DataType.ENUM_FIELD);
//        }
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
                        logger.info("in arg0" + arg0);
                        postUpdateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void postUpdateSuccess(String result) {
        loadClientInformation();
    }

    protected void loadClientInformation() {
        HttpService.HttpServiceAsync.instance().doGet(getCIId(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        ci = (JSONObject) JSONParser.parseLenient(response);
                        readClientInformation(ci);
                    }
                });
    }

    protected void readClientInformation(JSONObject ci) {
        new ResponseStatusWidget().show("Successfully Updated Billing Rate Info");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadClientInfoPanel(ci));
        GenericPopup.instance().hide();
    }

    protected String getCIId() {
        return OfficeWelcome.constants.root_url() + "clientinformation/read/" + JSONUtils.toString(clientInfo, "id");
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN, ROLE.ROLE_BILLING_AND_INVOICING)) {
            addField("effectiveDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
            addField("billingRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        } else if (Auth.hasAnyOfRoles(ROLE.ROLE_BILLING_AND_INVOICING)) {
            addField("billingRate", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
            addField("overTimeBillingRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        } else if (Auth.hasAnyOfRoles(ROLE.ROLE_BILLING_AND_INVOICING)) {
            addField("overTimeBillingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN, ROLE.ROLE_BILLING_AND_INVOICING)) {
            addEnumField("billingInvoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        }
        if (isSubOr1099) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                addField("subContractorPayRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            } else if (Auth.hasAnyOfRoles(ROLE.ROLE_BILLING_AND_INVOICING)) {
                addField("subContractorPayRate", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            }
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                addField("subContractorOverTimePayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            } else if (Auth.hasAnyOfRoles(ROLE.ROLE_BILLING_AND_INVOICING)) {
                addField("subContractorOverTimePayRate", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            }
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN, ROLE.ROLE_BILLING_AND_INVOICING)) {
                addEnumField("subContractorInvoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
            }
        }
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (entity.get("billingRate") == null) {
            fields.get("billingRate").setMessage("BillRate can not be null");
            return false;
        }
        if (isSubOr1099 == true && entity.get("subContractorPayRate") == null) {
            fields.get("subContractorPayRate").setMessage("SubContractor PayRate can not be null");
            return false;
        }
        return true;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation/update-billing-rate/" + JSONUtils.toString(clientInfo, "id");
    }
}
