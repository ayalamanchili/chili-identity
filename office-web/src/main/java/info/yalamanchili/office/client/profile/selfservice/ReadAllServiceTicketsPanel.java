/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

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
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllServiceTicketsPanel extends CRUDReadAllComposite {
    
    private static Logger logger = Logger.getLogger(ReadAllServiceTicketsPanel.class.getName());
    public static ReadAllServiceTicketsPanel instance;
    
    public ReadAllServiceTicketsPanel(String employeeId) {
        instance = this;
        this.parentId = employeeId;
        initTable("SelfService", OfficeWelcome.constants);
    }
    
    public ReadAllServiceTicketsPanel() {
        instance = this;
        initTable("SelfService", OfficeWelcome.constants);
    }
    
    @Override
    public void viewClicked(String entityId) {
        if (this.parentId == null) {
            TabPanel.instance().homePanel.entityPanel.clear();
            TabPanel.instance().homePanel.entityPanel.add(new ReadServiceTicketPanel(entityId));
        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadServiceTicketPanel(entityId));
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
    
    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.constants.root_url() + "selfservice/delete/" + entityId;
    }
    
    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Service Ticket");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllServiceTicketsPanel());
    }
    
    @Override
    public void updateClicked(String entityId) {
    }
    
    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllSelfServiceURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
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
        table.setText(0, 1, getKeyValue("Subject"));
        table.setText(0, 2, getKeyValue("Description"));
        table.setText(0, 3, getKeyValue("Type"));
        table.setText(0, 4, getKeyValue("Status"));
        table.setText(0, 5, getKeyValue("Department"));
        table.setText(0, 6, getKeyValue("Assigned To"));
        table.setText(0, 7, getKeyValue("CreatedTimeStamp"));
        
    }
    
    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.formatEnumString(entity, "subject"));
            table.setText(i, 2, JSONUtils.formatEnumString(entity, "description"));
            table.setText(i, 3, JSONUtils.toString(entity, "type"));
            table.setText(i, 4, JSONUtils.toString(entity, "status"));
            setEnumColumn(i, 5, entity.get("departmentAssigned").isObject(), "role", "rolename");
            if (entity.get("assignedTo") != null) {
                table.setText(i, 6, JSONUtils.toString(entity.get("assignedTo").isObject(), "firstName"));
            }
            table.setText(i, 7, DateUtils.getFormatedDate(JSONUtils.toString(entity, "createdTimeStamp"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
        }
    }
    
    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin()) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }
    
    private String getReadAllSelfServiceURL(Integer start, String limit) {
        if (this.parentId == null) {
            return OfficeWelcome.constants.root_url() + "selfservice/tickets/currentuser/" + start.toString() + "/" + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "selfservice/tickets/" + TreeEmployeePanel.instance().getEntityId() + "/" + start.toString() + "/" + limit.toString();
        }
    }
    
    @Override
    protected boolean showDocumentationLink() {
        return true;
    }
    
    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "selfservice/open-ticket.html";
    }
}
