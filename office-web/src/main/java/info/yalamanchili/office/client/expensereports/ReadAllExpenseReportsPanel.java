/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

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
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.EMPLOYEE;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ReadAllExpenseReportsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllExpenseReportsPanel.class.getName());
    public static ReadAllExpenseReportsPanel instance;
    protected String url;

    public ReadAllExpenseReportsPanel() {
        instance = this;
        initTable("ExpenseReports", OfficeWelcome.constants);
    }

    public ReadAllExpenseReportsPanel(String url) {
        instance = this;
        this.url = url;
        initTable("ExpenseReports", OfficeWelcome.constants);
    }

    public ReadAllExpenseReportsPanel(JSONArray array) {
        instance = this;
        initTable("ExpenseReports", array, OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadExpenseReportPanel(entityId));

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
        new ResponseStatusWidget().show("Successfully Deleted Expense Reports Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllExpenseReportsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new UpdateExpenseReportPanel(entityId));
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllExpenseReportURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), false,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info("Info:" + result);
                postFetchTable(result);
            }
        });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table Action"));
        table.setText(0, 1, getKeyValue("Number"));
        table.setText(0, 2, getKeyValue("Name"));
        table.setText(0, 3, getKeyValue("Type"));
        table.setText(0, 4, getKeyValue("Start Date"));
        table.setText(0, 5, getKeyValue("End Date"));
        table.setText(0, 6, getKeyValue("Total Amount"));
        table.setText(0, 7, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, EXPENSE_REPORT_NUMBER));
            JSONObject emp = (JSONObject) entity.get(EMPLOYEE);
            table.setText(i, 2, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            setEnumColumn(i, 3, entity, ExpenseReportStatus.class.getSimpleName(), EXPENSE_FORM_TYPE);
            table.setText(i, 4, DateUtils.formatDate(JSONUtils.toString(entity, START_DATE)));
            table.setText(i, 5, DateUtils.formatDate(JSONUtils.toString(entity, END_DATE)));
            table.setText(i, 6, FormatUtils.formarCurrency(JSONUtils.toString(entity, TOTAL_EXPENSES)));
            setEnumColumn(i, 7, entity, ExpenseReportStatus.class.getSimpleName(), "status");
        }
    }

    @Override
    public void printClicked(String entityId) {
        Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "expensereport/report" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        String status = JSONUtils.toString(entity, "status");
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE, TableRowOptionsWidget.OptionsType.PRINT, TableRowOptionsWidget.OptionsType.COPY);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CEO, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE, Auth.ROLE.ROLE_GENERAL_EXPENSE_MANAGER)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.PRINT, TableRowOptionsWidget.OptionsType.COPY);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ACCOUNTS_PAYABLE)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.PRINT, TableRowOptionsWidget.OptionsType.COPY);
        } else if ((ExpenseReportStatus.PENDING_MANAGER_APPROVAL.name().equals(status)) || (ExpenseReportStatus.SAVED.name().equals(status))) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.PRINT, TableRowOptionsWidget.OptionsType.COPY);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.PRINT, TableRowOptionsWidget.OptionsType.COPY);
        }
    }

    @Override
    public void copyClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(OfficeWelcome.constants.root_url() + "expensereport/clone/" + entityId, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                logger.info(arg0);
                new ResponseStatusWidget().show("Copy created. Plase update and save.");
                TabPanel.instance().expensePanel.entityPanel.clear();
                TabPanel.instance().expensePanel.entityPanel.add(new UpdateExpenseReportPanel(JSONParser.parseLenient(arg0).isObject()));
            }
        });
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "expensereport/delete/" + entityId;
    }

    private String getReadAllExpenseReportURL(Integer start, String tableSize) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "expensereport/" + start.toString() + "/" + tableSize.toString();
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "expense/submitexpensereport.html";
    }

    @Override
    protected boolean autoShowDocumentation() {
        return true;
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadExpenseReportPanel(JSONUtils.toString(getEntity(id), "id")), Window.getClientWidth() / 3, 0).show();
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create Expense Report");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new CreateExpenseReportPanel(CreateComposite.CreateCompositeType.CREATE));
    }
}
