/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.crud.TableRowOptionsWidget.OptionsType;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author benerji.v
 */
public class ReadAllImmigrationCheckRequisitionPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllImmigrationCheckRequisitionPanel.class.getName());
    public static ReadAllImmigrationCheckRequisitionPanel instance;
    protected String url;

    public ReadAllImmigrationCheckRequisitionPanel() {
        instance = this;
        initTable("ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    public ReadAllImmigrationCheckRequisitionPanel(String url) {
        instance = this;
        this.url = url;
        initTable("ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadImmigrationCheckRequisitionPanel(entityId));
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
        new ResponseStatusWidget().show("Successfully Deleted ImmigrationCheckRequisition Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllImmigrationCheckRequisitionPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new UpdateImmigrationCheckRequisitionPanel(entityId));
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getImmigrationCheckURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("CaseType"));
        table.setText(0, 3, getKeyValue("AttorneyName"));
        table.setText(0, 4, getKeyValue("Company"));
        table.setText(0, 5, getKeyValue("Amount"));
        table.setText(0, 6, getKeyValue("RequestedDate"));
        table.setText(0, 7, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get("employee");
            table.setText(i, 1, JSONUtils.toString(emp, "firstName"));
            table.setText(i, 2, JSONUtils.toString(entity, "caseType"));
            table.setText(i, 3, JSONUtils.toString(entity, "attorneyName"));
            if (emp.get("company") != null) {
                table.setText(i, 4, JSONUtils.toString(emp.get("company"), "name"));
            }

            table.setText(i, 5, FormatUtils.formarCurrency(JSONUtils.toString(entity, "amount")));
            table.setText(i, 6, DateUtils.getFormatedDate(JSONUtils.toString(entity, "requestedDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 7, JSONUtils.formatEnumString(entity, "status"));
        }
    }

    @Override
    public void printClicked(String entityId) {
        Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "checkrequisition/report" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
    }

    @Override
    public void copyClicked(final String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(OfficeWelcome.constants.root_url() + "checkrequisition/clone/" + entityId, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        logger.info(arg0);
                        new ResponseStatusWidget().show("Copy created. Plase update and save.");
                        TabPanel.instance().expensePanel.entityPanel.clear();
                        TabPanel.instance().expensePanel.entityPanel.add(new UpdateImmigrationCheckRequisitionPanel(entityId));
                    }
                });
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {

        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            createOptionsWidget(new TableRowOptionsWidget(JSONUtils.toString(entity, "id"), OptionsType.READ, OptionsType.UPDATE, OptionsType.DELETE, OptionsType.PRINT, OptionsType.COPY), row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(new TableRowOptionsWidget(JSONUtils.toString(entity, "id"), OptionsType.READ, OptionsType.PRINT, OptionsType.COPY), row, JSONUtils.toString(entity, "id"));
        }
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "checkrequisition/delete/" + entityId;
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create Check Requisition");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getExpensePanel().sidePanelTop.clear();
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new CreateImmigrationCheckRequisitionPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    private String getImmigrationCheckURL(Integer start, String limit) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "checkrequisition/" + start.toString() + "/"
                + limit.toString();
    }
}
