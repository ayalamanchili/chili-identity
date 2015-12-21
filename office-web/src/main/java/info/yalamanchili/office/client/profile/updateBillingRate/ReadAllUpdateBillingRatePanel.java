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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadClientInfoPanel;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllUpdateBillingRatePanel extends CRUDReadAllComposite {

    private static ReadAllUpdateBillingRatePanel instance;

    public static ReadAllUpdateBillingRatePanel instance() {
        return instance;
    }

    public ReadAllUpdateBillingRatePanel() {
    }

    public ReadAllUpdateBillingRatePanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("BillingRate", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
    }

    public String getDeleteURL(String entityId) {
        return OfficeWelcome.constants.root_url() + "billing-rate/delete/" + entityId;
    }

    public void preDelete(String entityId) {
        if (Window.confirm("Only delete billing rate is data is entered incorrectly. Deleting will not update the existing rate.")) {
            deleteClicked(entityId);
        }
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess();
                    }
                });
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Billing Rate Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadClientInfoPanel(parentId));
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
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("PayRate"));
        table.setText(0, 2, getKeyValue("BillingRate"));
        table.setText(0, 3, getKeyValue("OverTimePayRate"));
        table.setText(0, 4, getKeyValue("OverTimeBillingRate"));
        table.setText(0, 5, getKeyValue("EffectiveDate"));
        table.setText(0, 6, getKeyValue("Updated By"));
        table.setText(0, 7, getKeyValue("Updated At"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "payRate"));
            table.setText(i, 2, JSONUtils.toString(entity, "billingRate"));
            table.setText(i, 3, JSONUtils.toString(entity, "overTimePayRate"));
            table.setText(i, 4, JSONUtils.toString(entity, "overTimeBillingRate"));
            table.setText(i, 5, DateUtils.getFormatedDate(JSONUtils.toString(entity, "effectiveDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            table.setText(i, 6, JSONUtils.toString(entity, "updatedBy"));
            table.setText(i, 7, JSONUtils.toString(entity, "updatedTs"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.DELETE, row, JSONUtils.toString(entity, "id"));
        }
    }

    private String getReadAllURL() {
        return OfficeWelcome.constants.root_url() + "clientinformation/billing-rates/" + parentId;
    }

    /**
     * common utility method
     */
    public void renderBillingRateHistory(final String clientInfoId, FlowPanel entityFieldsPanel) {
        final DisclosurePanel billingRatesDP = new DisclosurePanel("Billing Rate History");
        billingRatesDP.setWidth("100%");
        entityFieldsPanel.add(billingRatesDP);
        billingRatesDP.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                billingRatesDP.setContent(
                        new ReadAllUpdateBillingRatePanel(clientInfoId));

            }
        });
    }
}
