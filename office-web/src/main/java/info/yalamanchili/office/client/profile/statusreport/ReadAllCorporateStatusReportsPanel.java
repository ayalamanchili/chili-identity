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
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
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
        if (TabPanel.instance().homePanel.isVisible()) {
            table.setText(0, 5, getKeyValue("Copy"));
        }
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
            if (TabPanel.instance().homePanel.isVisible()) {
                ClickableLink copyL = new ClickableLink("Create Copy");
                copyL.setTitle(JSONUtils.toString(entity, "id"));
                copyL.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        createCopy(((ClickableLink) event.getSource()).getTitle());
                    }
                });
                table.setWidget(i, 5, copyL);
            }
        }
    }
    
    protected void createCopy(String entityId) {
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
        //TODO check permission
        if (TabPanel.instance().homePanel.isVisible()) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }
    
    @Override
    public void viewClicked(String entityId) {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadCorporateStatusReportPanel(getEntity(entityId)));
        }
        if (TabPanel.instance().homePanel.isVisible()) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadCorporateStatusReportPanel(getEntity(entityId)));
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
