/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

public class ReadAllClientInfoPanel extends CRUDReadAllComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadAllClientInfoPanel.class.getName());

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
    protected void addListeners() {
        super.addListeners();
    }

    @Override
    protected void configure() {
        super.configure();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Client"));
        table.setText(0, 2, getKeyValue("Vendor"));
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS)) {
            table.setText(0, 3, getKeyValue("ItemNo"));
            table.setText(0, 4, getKeyValue("BillRate"));
            table.setText(0, 5, getKeyValue("Frequency"));

        }
        table.setText(0, 6, getKeyValue("StartDate"));
        table.setText(0, 7, getKeyValue("EndDate"));
        table.setText(0, 8, getKeyValue("Status"));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, ROLE.ROLE_RECRUITER)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
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

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadClientInfoPanel(getEntity(id)), Window.getClientWidth() / 3, 0).show();
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
    protected boolean enablePersistedQuickView() {
        return true;
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

            if (entity.get("client") != null) {
                JSONObject client = entity.get("client").isObject();
                table.setText(i, 1, JSONUtils.toString(client, "name"));
            }
            if (entity.get("vendor") != null) {
                JSONObject vendor = entity.get("vendor").isObject();
                table.setText(i, 2, JSONUtils.toString(vendor, "name"));
            }
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP)) {
                table.setText(i, 3, JSONUtils.toString(entity, "itemNumber"));
                table.setText(i, 4, FormatUtils.formarCurrency(JSONUtils.toString(entity, "billingRate")));
                setEnumColumn(i, 5, entity, InvoiceFrequency.class.getSimpleName(), "invoiceFrequency");
            }
            table.setText(i, 6, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_LONG));
            table.setText(i, 7, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_LONG));
            table.setText(i, 8, JSONUtils.toString(entity, "status"));
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        super.onClick(event);
    }
}
