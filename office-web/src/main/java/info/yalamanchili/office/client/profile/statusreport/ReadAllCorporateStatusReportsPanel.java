/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllCorporateStatusReportsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllCorporateStatusReportsPanel.class.getName());
    public static ReadAllCorporateStatusReportsPanel instance;
    protected boolean searchResultsTable = false;

    public ReadAllCorporateStatusReportsPanel() {
        initTable("StatusReports", OfficeWelcome.constants);
    }

    public ReadAllCorporateStatusReportsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
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
        if (parentId == null) {
            return OfficeWelcome.constants.root_url() + "corporate-statusreport/" + start.toString() + "/"
                    + limit;
        } else {
            return OfficeWelcome.constants.root_url() + "corporate-statusreport/" + start.toString() + "/"
                    + limit + "?employeeId=" + parentId;
        }
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
        table.setText(0, 5, getKeyValue("Compare"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            if (searchResultsTable) {
                table.setText(i, 1, JSONUtils.toString(entity, "employeeName"));
            }
            table.setText(i, 2, DateUtils.formatDate(JSONUtils.toString(entity, "reportStartDate")));
            table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "reportEndDate")));
            table.setText(i, 4, JSONUtils.toString(entity, "status"));
            //Compare
            if (TabPanel.instance().homePanel.isVisible()) {
                ClickableLink compareL = new ClickableLink("Compare");
                compareL.setTitle(JSONUtils.toString(entity, "id"));
                compareL.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        compare(((ClickableLink) event.getSource()).getTitle());
                    }
                });
                table.setWidget(i, 5, compareL);
            }
        }
    }

    protected void compare(String entityId) {
        if (!entityId.isEmpty()) {
            HttpService.HttpServiceAsync.instance().doGet(OfficeWelcome.constants.root_url() + "corporate-statusreport/diff/" + entityId, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            logger.info(arg0);
                            openPrintWindow(arg0);
                        }
                    });
        }
    }

    protected native void openPrintWindow(String contents) /*-{
     var printWindow = window.open("", "PrintWin");
     if (printWindow && printWindow.top) {
     printWindow.document.write(contents);
     } else {
     alert("Please allow popup's");
     }
     }-*/;

    @Override
    public void copyClicked(final String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(OfficeWelcome.constants.root_url() + "corporate-statusreport/clone/" + entityId, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        logger.info(arg0);
                        new ResponseStatusWidget().show("Copy created. Plase update and save.");
                        TabPanel.instance().homePanel.entityPanel.clear();
                        TabPanel.instance().homePanel.entityPanel.add(new CreateCorporateStatusReportPanel(JSONParser.parseLenient(arg0).isObject()));
                    }
                });
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (TabPanel.instance().homePanel.isVisible()) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE, TableRowOptionsWidget.OptionsType.COPY);
        } else if (TabPanel.instance().reportingPanel.isVisible()) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.COPY);
        }
    }

    @Override
    public void viewClicked(String entityId) {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadCorporateStatusReportPanel(entityId));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadCorporateStatusReportPanel(entityId));
        }
        if (TabPanel.instance().reportingPanel.isVisible() && !entityId.isEmpty()) {
            TabPanel.instance().reportingPanel.entityPanel.clear();
            TabPanel.instance().reportingPanel.entityPanel.add(new ReadCorporateStatusReportPanel(entityId));
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
        new ResponseStatusWidget().show("Successfully deleted status report");
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCorporateStatusReportsPanel(parentId));
        } else if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadAllCorporateStatusReportsPanel());
        }
    }

    @Override
    public void updateClicked(String entityId) {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateCorporateStatusReportPanel(TreeEmployeePanel.instance().getEntityId()));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new CreateCorporateStatusReportPanel(entityId));
        }

    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        if (!id.isEmpty()) {
            new GenericPopup(new ReadCorporateStatusReportPanel(id), Window.getClientWidth() / 3, 0).show();
        }
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "corporate-statusreport/delete/" + entityId;
    }

    @Override
    protected void configureCreateButton() {
        if (TabPanel.instance().homePanel.isVisible()) {
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().homePanel.entityPanel.clear();
        TabPanel.instance().homePanel.entityPanel.add(new CreateCorporateStatusReportPanel());
    }
}
