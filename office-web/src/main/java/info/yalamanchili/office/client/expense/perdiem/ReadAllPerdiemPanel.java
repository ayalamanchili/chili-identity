/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.perdiem;

import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllPerdiemPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllPerdiemPanel.class.getName());
    public static ReadAllPerdiemPanel instance;
    protected String url;
    protected boolean isAmountPresent = false;

    public ReadAllPerdiemPanel() {
        instance = this;
        initTable("PerDiem", OfficeWelcome.constants2);
    }

    public ReadAllPerdiemPanel(String url) {
        instance = this;
        this.url = url;
        initTable("PerDiem", OfficeWelcome.constants2);
    }

    public ReadAllPerdiemPanel(JSONArray result) {
        instance = this;
        initTable("PerDiem", result, OfficeWelcome.constants2);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadPerdiemPanel(entityId));
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
        new ResponseStatusWidget().show("Successfully Deleted Perdiem Request");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllPerdiemPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        JSONObject entity = getEntity(entityId);
        if (entity.containsKey("amount")) {
            isAmountPresent = true;
        }
        TabPanel.instance().expensePanel.entityPanel.add(new UpdatePerDiemPanel(getEntity(entityId), isAmountPresent));
    }

    @Override
    public void printClicked(String entityId) {
        Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "perdiem/report" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllProspectsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), false,
                new ALAsyncCallback<String>() {
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
        table.setText(0, 2, getKeyValue("Perdiem Type"));
        table.setText(0, 3, getKeyValue("Perdiem Start Date"));
        table.setText(0, 4, getKeyValue("Perdiem End Date"));
        table.setText(0, 5, getKeyValue("Amount"));
        table.setText(0, 6, getKeyValue("Percentage"));
        table.setText(0, 7, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject employee = entity.get("employee").isObject();
            table.setText(i, 1, JSONUtils.toString(employee, "firstName") + " " + JSONUtils.toString(employee, "lastName"));
            if ("true".equals(entity.get("live50MilesAway").isString().stringValue())) {
                table.setText(i, 2, "Live 50 Miles Away");
            } else {
                table.setText(i, 2, "Maintain 2 Residences");
            }
            String startDate = getFormattedDate(DateUtils.getFormatedDate(JSONUtils.toString(entity, "perDiemStartDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            String endDate = getFormattedDate(DateUtils.getFormatedDate(JSONUtils.toString(entity, "perDiemEndDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            table.setText(i, 3, startDate);
            table.setText(i, 4, endDate);
            table.setText(i, 5, JSONUtils.toString(entity, "amount"));
            table.setText(i, 6, JSONUtils.toString(entity, "percentage"));
            setEnumColumn(i, 7, entity, PerDiemStatus.class.getSimpleName(), "status");
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE, TableRowOptionsWidget.OptionsType.PRINT);
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create PerDiem Request");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new PerDiemRequestPanel());
    }

    private String getReadAllProspectsURL(Integer start, String tableSize) {
        return OfficeWelcome.constants.root_url() + "perdiem/" + start.toString() + "/" + tableSize;
    }

    private String getFormattedDate(String date) {
        String[] dates = date.split("-");
        String formatteddate = "";
        formatteddate = formatteddate.concat(dates[dates.length - 2]).concat("/");
        formatteddate = formatteddate.concat(dates[dates.length - 1]).concat("/");
        formatteddate = formatteddate.concat(dates[0]);
        return formatteddate;
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "perdiem/delete/" + entityId;
    }
}
