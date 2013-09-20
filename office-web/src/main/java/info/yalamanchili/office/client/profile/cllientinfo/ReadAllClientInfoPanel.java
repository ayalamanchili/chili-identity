/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.i18n.client.DateTimeFormat;
import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget.OptionsType;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;

public class ReadAllClientInfoPanel extends CRUDReadAllComposite {

    private static ReadAllClientInfoPanel instance;

    public static ReadAllClientInfoPanel instance() {
        return instance;
    }

    public ReadAllClientInfoPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Client Information", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpServiceAsync.instance().doGet(getReadAllURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
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
        table.setText(0, 1, getKeyValue("Job Title"));
        table.setText(0, 2, getKeyValue("Client"));
        table.setText(0, 3, getKeyValue("Vendor"));
        table.setText(0, 4, getKeyValue("ItemNumber"));
        table.setText(0, 5, getKeyValue("BillingRate"));
        table.setText(0, 6, getKeyValue("InvoiceFrequency"));
        table.setText(0, 7, getKeyValue("StartDate"));
        table.setText(0, 8, getKeyValue("EndtDate"));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin() || Auth.isHR()) {
            createOptionsWidget(OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    // TODO move to composite
    public String getReadAllURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "employee/clientinformation/" + parentId + "/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadClientInfoPanel(getEntity(entityId)));
    }

    public String getDeleteURL(String entityId) {
        return OfficeWelcome.constants.root_url() + "clientinformation/delete/" + entityId;

    }

    @Override
    public void deleteClicked(String entityId) {
        HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                postDeleteSuccess();
            }
        });
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Reports To Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateClientInfoPanel(getEntity(entityId)));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            OfficeWelcome.instance().logger.info(entity.toString());
            table.setText(i, 1, JSONUtils.toString(entity, "consultantJobTitle"));
            if (entity.get("client") != null) {
                JSONObject client = entity.get("client").isObject();
                table.setText(i, 2, JSONUtils.toString(client, "name"));
            }
            if (entity.get("vendor") != null) {
                JSONObject vendor = entity.get("vendor").isObject();
                table.setText(i, 3, JSONUtils.toString(vendor, "name"));
            }
            table.setText(i, 4, JSONUtils.toString(entity, "itemNumber"));
            table.setText(i, 5, JSONUtils.toString(entity, "billingRate"));
            table.setText(i, 6, JSONUtils.toString(entity, "invoiceFrequency"));
            table.setText(i, 7, JSONUtils.toString(entity, "startDate"));
            table.setText(i, 8, JSONUtils.toString(entity, "endDate"));
        }
    }
}
