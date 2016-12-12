/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllStatusReportPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllStatusReportPanel.class.getName());
    public static ReadAllStatusReportPanel instance;

    public ReadAllStatusReportPanel() {
        instance = this;
        initTable("StatusReport", OfficeWelcome.constants);
    }

    public ReadAllStatusReportPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("StatusReport", OfficeWelcome.constants);
    }
    public ReadAllStatusReportPanel(JSONArray result) {
        instance = this;
        initTable("StatusReport", result, OfficeWelcome.constants);
    }

    @Override
    protected void configureCreateButton() {
        if (TabPanel.instance().homePanel.isVisible()) {
            createButton.setText("Create Status Report");
            createButton.setVisible(true);
        }
    }

    @Override
    protected void createButtonClicked() {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateStatusReportPanel(parentId));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            TabPanel.instance().getHomePanel().entityPanel.add(new CreateStatusReportPanel());
        }

    }

    @Override
    public void viewClicked(String entityId) {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadStatusReportPanel(entityId));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadStatusReportPanel(entityId));
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
        new ResponseStatusWidget().show("Successfully Deleted Status Report Information");
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllStatusReportPanel(parentId));
        } else if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadAllStatusReportPanel());
        }
    }

    @Override
    public void updateClicked(String entityId) {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateStatusReportPanel(entityId));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new UpdateStatusReportPanel(entityId));
        }

    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllstatusPanelURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
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
        table.setText(0, 1, getKeyValue("Report Start Date"));
        table.setText(0, 2, getKeyValue("Report End Date"));
        table.setText(0, 3, getKeyValue("Stage"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, DateUtils.formatDate(JSONUtils.toString(entity, "reportStartDate")));
            table.setText(i, 2, DateUtils.formatDate(JSONUtils.toString(entity, "reportEndDate")));
            table.setText(i, 3, JSONUtils.toString(entity, "stage"));
        }
    }

    @Override
    public void copyClicked(final String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(OfficeWelcome.constants.root_url() + "statusreport/clone/" + entityId, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        logger.info(arg0);
                        new ResponseStatusWidget().show("Copy created. Plase update and save.");
                        TabPanel.instance().homePanel.entityPanel.clear();
                        TabPanel.instance().homePanel.entityPanel.add(new UpdateStatusReportPanel(JSONParser.parseLenient(arg0).isObject()));
                    }
                });
    }


    @Override
    public void printClicked(String entityId) {
        Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "statusreport/report" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP)) {
            createOptionsWidget(new TableRowOptionsWidget(JSONUtils.toString(entity, "id"), TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE, TableRowOptionsWidget.OptionsType.PRINT, TableRowOptionsWidget.OptionsType.COPY), row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(new TableRowOptionsWidget(JSONUtils.toString(entity, "id"), TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.PRINT, TableRowOptionsWidget.OptionsType.COPY), row, JSONUtils.toString(entity, "id"));
        }
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "statusreport/delete/" + entityId;
    }

    private String getReadAllstatusPanelURL(Integer start, String limit) {
        String url = OfficeWelcome.constants.root_url() + "statusreport/" + start.toString() + "/" + limit;
        if (parentId != null) {
            url = url + "?employeeId=" + parentId;
        }
        return url;
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        if (Auth.isCorporateEmployee()) {
            return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "statusreport/statusreportprocess.html";
        } else {
            return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "statusreport/statusreport.html";
        }
    }

    @Override
    protected boolean autoShowDocumentation() {
        return true;
    }
}
