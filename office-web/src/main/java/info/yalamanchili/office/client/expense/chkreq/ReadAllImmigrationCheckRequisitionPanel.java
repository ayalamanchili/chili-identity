/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.chkreq;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
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
    public ReadAllImmigrationCheckRequisitionPanel(JSONArray result) {
        instance = this;
        initTable("ImmigrationCheckRequisition", result, OfficeWelcome.constants);
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
    public void cancelClicked(final String entityId) {
        if (Window.confirm("Are you sure you want to submit a void check request?")) {
            HttpService.HttpServiceAsync.instance().doGet(getCancelURL(entityId), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            new ResponseStatusWidget().show("Cancel request has been submitted");
                            TabPanel.instance().expensePanel.entityPanel.clear();
                            TabPanel.instance().expensePanel.entityPanel.add(new ReadAllImmigrationCheckRequisitionPanel());
                        }
                    });
        }
    }

    private String getCancelURL(String id) {
        return OfficeWelcome.constants.root_url() + "checkrequisition/check-request-void/" + id;
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
            if (emp != null) {
                table.setText(i, 1, JSONUtils.toString(emp, "firstName"));
                if (emp.get("company") != null) {
                    table.setText(i, 4, JSONUtils.toString(emp.get("company"), "name"));
                }
            } else {
                table.setText(i, 1, JSONUtils.toString(entity, "employeeName"));
                if (entity.get("companyName") != null) {
                    table.setText(i, 4, (JSONUtils.toString(entity, "companyName")));
                }
            }
            setEnumColumn(i, 2, entity, ImmigrationCaseType.class.getSimpleName(), "caseType");
            table.setText(i, 3, JSONUtils.toString(entity, "attorneyName"));
            table.setText(i, 5, FormatUtils.formarCurrency(JSONUtils.toString(entity, "amount")));
            table.setText(i, 6, DateUtils.formatDate(JSONUtils.toString(entity, "requestedDate")));
            setEnumColumn(i, 7, entity, ImmigrationCheckRequisitionStatus.class.getSimpleName(), "status");
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
                        new ResponseStatusWidget().show("Copy created. Please update and save.");
                        TabPanel.instance().expensePanel.entityPanel.clear();
                        TabPanel.instance().expensePanel.entityPanel.add(new UpdateImmigrationCheckRequisitionPanel(JSONParser.parseLenient(arg0).isObject()));
                    }
                });
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        String status = JSONUtils.toString(entity, "status");
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_H1B_IMMIGRATION)) {
            if (ImmigrationCheckRequisitionStatus.PENDING_APPROVAL.name().equals(status)) {
                createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.PRINT,TableRowOptionsWidget.OptionsType.COPY);
            } else if (ImmigrationCheckRequisitionStatus.COMPLETE.name().equals(status)) {
                createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.PRINT, TableRowOptionsWidget.OptionsType.COPY,TableRowOptionsWidget.OptionsType.CANCEL);
            } else {
                createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.PRINT, TableRowOptionsWidget.OptionsType.COPY);
            }

        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.PRINT);
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
    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadImmigrationCheckRequisitionPanel(JSONUtils.toString(getEntity(id), "id")), Window.getClientWidth() / 3, 0).show();
    }
    @Override
    protected boolean enablePersistedQuickView(){
        return true;
    }
}
