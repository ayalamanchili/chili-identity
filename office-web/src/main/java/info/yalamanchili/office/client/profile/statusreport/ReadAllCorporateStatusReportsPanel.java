/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
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
 * @author ayalamanchili
 */
public class ReadAllCorporateStatusReportsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllCorporateStatusReportsPanel.class.getName());

    protected boolean searchResultsTable = false;

    public ReadAllCorporateStatusReportsPanel() {
        initTable("StatusReports", OfficeWelcome.constants);
    }

    public ReadAllCorporateStatusReportsPanel(String title, JSONArray array) {
        searchResultsTable = true;
        initTable(title, array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });

    }

    public String getURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "corporate-statusreport/" + start.toString() + "/"
                + limit;
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        if (searchResultsTable) {
            table.setText(0, 1, getKeyValue("Employee"));
        }
        table.setText(0, 2, getKeyValue("Start Date"));
        table.setText(0, 3, getKeyValue("End Date"));
        table.setText(0, 4, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            if (searchResultsTable) {
                table.setText(i, 1, JSONUtils.toString(entity, "employeeName"));
            }
            table.setText(i, 2, DateUtils.getFormatedDate(JSONUtils.toString(entity, "reportStartDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "reportEndDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 4, JSONUtils.toString(entity, "status"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        //TODO check permission
        if (searchResultsTable) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().homePanel.entityPanel.clear();
        TabPanel.instance().homePanel.entityPanel.add(new ReadCorporateStatusReportPanel(getEntity(entityId)));
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
        new ResponseStatusWidget().show("Successfully deleted status report");
        TabPanel.instance().homePanel.entityPanel.clear();
        TabPanel.instance().homePanel.entityPanel.add(new ReadAllCorporateStatusReportsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().homePanel.entityPanel.clear();
        TabPanel.instance().homePanel.entityPanel.add(new CreateCorporateStatusReportPanel(entityId));

    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "corporate-statusreport/delete/" + entityId;
    }

    @Override
    protected void configureCreateButton() {
        if (!searchResultsTable) {
            createButton.setVisible(true);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().homePanel.entityPanel.clear();
        TabPanel.instance().homePanel.entityPanel.add(new CreateCorporateStatusReportPanel());
    }
}
