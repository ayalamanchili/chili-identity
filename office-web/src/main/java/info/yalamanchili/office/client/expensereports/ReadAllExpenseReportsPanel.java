/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
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
        logger.info("in read all ");
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
        logger.info("in read all - prefetch");
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
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("Form_Type"));
        table.setText(0, 3, getKeyValue("Start_Date"));
        table.setText(0, 4, getKeyValue("End_Date"));
        table.setText(0, 5, getKeyValue("Total_Amount"));
        table.setText(0, 6, getKeyValue("Print"));
        table.setText(0, 7, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get(EMPLOYEE);
            table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            table.setText(i, 2, JSONUtils.toString(entity, EXPENSE_FORM_TYPE ));
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, START_DATE), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, END_DATE), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 5, FormatUtils.formarCurrency(JSONUtils.toString(entity, TOTAL_EXPENSES )));
            FileField reportL = new FileField("Print", ChiliClientConfig.instance().getFileDownloadUrl() + "expensereport/report" + "&passthrough=true" + "&id=" + JSONUtils.toString(entity, "id"));
            table.setWidget(i, 6, reportL);
            table.setText(i, 7, JSONUtils.formatEnumString(entity, "status"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        String status = JSONUtils.toString(entity, "status");
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CEO)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE, row, JSONUtils.toString(entity, "id"));
            if ((ExpenseReportStatus.PENDING_CEO_APPROVAL.name().equals(status))        || 
                (ExpenseReportStatus.PENDING_PAYROLL_APPROVAL.name().equals(status))    || 
                (ExpenseReportStatus.APPROVED.name().equals(status))                    || 
                (ExpenseReportStatus.REJECTED.name().equals(status))) {
                createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
            }
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ACCOUNTS_PAYABLE)) {
                createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE, row, JSONUtils.toString(entity, "id"));
            }
        }
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "expensereport/delete/" + entityId;
    }

    private String getReadAllExpenseReportURL(Integer start, String tableSize) {
           logger.info("in read all - getReadAllExpenseReportURL");
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "expensereport/" + start.toString() + "/" + tableSize.toString();
    }
}
