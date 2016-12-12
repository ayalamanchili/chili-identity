/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.updateBillingRate;

import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Widget;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllUpdateBillingRatePanel extends CRUDReadAllComposite {

    private static ReadAllUpdateBillingRatePanel instance;
    protected boolean isSubOr1099 = false;

    public static ReadAllUpdateBillingRatePanel instance() {
        return instance;
    }

    public ReadAllUpdateBillingRatePanel() {
    }

    static JSONObject clientInfo;

    public ReadAllUpdateBillingRatePanel(JSONObject clientInformation) {
        instance = this;
        this.clientInfo = clientInformation;
        initTable("BillingRate", OfficeWelcome.constants);
    }

    public ReadAllUpdateBillingRatePanel(JSONObject clientInformation, boolean isSubOr1099) {
        instance = this;
        this.clientInfo = clientInformation;
        this.isSubOr1099 = isSubOr1099;
        initTable("BillingRate", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    public void preDelete(String entityId) {
    }

    @Override
    public void deleteClicked(String entityId) {
    }

    @Override
    public void postDeleteSuccess() {
    }

    @Override
    public void updateClicked(String entityId) {

    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllURL(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void createTableHeader() {
        table.setHeight("15");
        table.setText(0, 0, getKeyValue("Table_Action"));
        //      table.setText(0, 1, getKeyValue("PayRate"));
        table.setText(0, 1, getKeyValue("BillRate"));
        //      table.setText(0, 3, getKeyValue("OverTimePayRate"));
        table.setText(0, 2, getKeyValue("OTBillRate"));
        table.setText(0, 3, getKeyValue("Pattern"));
        if (isSubOr1099) {
            table.setText(0, 4, getKeyValue("SubConPay"));
            table.setText(0, 5, getKeyValue("SubConOTPay"));
            table.setText(0, 6, getKeyValue("SubConPattern"));
            table.setText(0, 7, getKeyValue("EffectiveDate"));
            table.setText(0, 8, getKeyValue("UpdatedBy"));
            table.setText(0, 9, getKeyValue("UpdatedAt"));
        } else {
            table.setText(0, 4, getKeyValue("EffectiveDate"));
            table.setText(0, 5, getKeyValue("UpdatedBy"));
            table.setText(0, 6, getKeyValue("UpdatedAt"));
        }

    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            //           table.setText(i, 1, JSONUtils.toString(entity, "payRate"));
            table.setText(i, 1, JSONUtils.toString(entity, "billingRate"));
            //           table.setText(i, 3, JSONUtils.toString(entity, "overTimePayRate"));
            table.setText(i, 2, JSONUtils.toString(entity, "overTimeBillingRate"));
            //table.setText(i, 3, JSONUtils.toString(entity, "billingInvoiceFrequency"));
            setEnumColumn(i, 3, entity, InvoiceFrequency.class.getSimpleName(), "billingInvoiceFrequency");
            if (isSubOr1099) {
                table.setText(i, 4, JSONUtils.toString(entity, "subContractorPayRate"));
                table.setText(i, 5, JSONUtils.toString(entity, "subContractorOverTimePayRate"));
                //table.setText(i, 6, JSONUtils.toString(entity, "subContractorInvoiceFrequency"));
                setEnumColumn(i, 6, entity, InvoiceFrequency.class.getSimpleName(), "subContractorInvoiceFrequency");
                table.setText(i, 7, DateUtils.getFormatedDate(JSONUtils.toString(entity, "effectiveDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
                table.setText(i, 8, JSONUtils.toString(entity, "updatedBy"));
                table.setText(i, 9, DateUtils.getFormatedDate(JSONUtils.toString(entity, "updatedTs"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            }
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "effectiveDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 5, JSONUtils.toString(entity, "updatedBy"));
            table.setText(i, 6, DateUtils.getFormatedDate(JSONUtils.toString(entity, "updatedTs"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
    }

    private String getReadAllURL() {
        return OfficeWelcome.constants.root_url() + "clientinformation/billing-rates/" + JSONUtils.toString(clientInfo, "id");
    }

    /**
     * common utility method
     *
     * @param clientInfoId
     * @param entityFieldsPanel
     * @return
     */
    public static Widget renderBillingRateHistory(final JSONObject clientInformation, final boolean isSubOr1099) {
        final DisclosurePanel billingRatesDP = new DisclosurePanel("Bill Rate History");
        billingRatesDP.setWidth("100%");
        billingRatesDP.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                billingRatesDP.setContent(
                        new ReadAllUpdateBillingRatePanel(clientInformation, isSubOr1099));

            }
        });
        return billingRatesDP;
    }

    public static Widget renderBillingRateHistory(final JSONObject clientInformation) {
        final DisclosurePanel billingRatesDP = new DisclosurePanel("Bill Rate History");
        billingRatesDP.setWidth("100%");
        billingRatesDP.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                billingRatesDP.setContent(
                        new ReadAllUpdateBillingRatePanel(clientInformation));

            }
        });
        return billingRatesDP;
    }
}
