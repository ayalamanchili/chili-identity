/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.time.LeaveRequestTimeCategory;
import info.yalamanchili.office.client.time.TimeSheetStatus;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllCorporateTimeSheetPanel extends CRUDReadAllComposite implements ClickHandler {
    
    private static Logger logger = Logger.getLogger(ReadAllCorporateTimeSheetPanel.class.getName());
    public static ReadAllCorporateTimeSheetPanel instance;
    
    public ReadAllCorporateTimeSheetPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Corporate Time Sheets", OfficeWelcome.constants);
    }
    
    public ReadAllCorporateTimeSheetPanel() {
        instance = this;
        initTable("My Time Sheets", OfficeWelcome.constants);
    }
    
    public ReadAllCorporateTimeSheetPanel(String title, JSONArray array) {
        instance = this;
        initTable(title, array, OfficeWelcome.constants);
    }
    
    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadCorporateTimeSheetPanel(entityId));
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
        new ResponseStatusWidget().show("Successfully Deleted Coporate Time Sheet Information");
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllCorporateTimeSheetPanel(parentId));
    }
    
    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new UpdateCorporateTimeSheetPanel(getEntity(entityId)));
    }
    
    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllCorporateTimeSheetsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }
    
    public String getReadAllCorporateTimeSheetsURL(Integer start, String limit) {
        String queryStr = "?";
        if (CorpoateTimeSidePanel.instance != null && CorpoateTimeSidePanel.instance.categoryField.getValue() != null) {
            queryStr = queryStr + "&category=" + CorpoateTimeSidePanel.instance.categoryField.getValue();
        }
        if (CorpoateTimeSidePanel.instance != null && CorpoateTimeSidePanel.instance.statusField.getValue() != null) {
            queryStr = queryStr + "&status=" + CorpoateTimeSidePanel.instance.statusField.getValue();
        }
        if (parentId == null) {
            return OfficeWelcome.constants.root_url() + "corporate-timesheet/currentuser/" + start.toString() + "/" + limit.toString() + queryStr;
        } else {
            return OfficeWelcome.constants.root_url() + "corporate-timesheet/employee/" + parentId + "/" + start.toString() + "/" + limit.toString() + queryStr;
        }
    }
    
    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("Category"));
        table.setText(0, 3, getKeyValue("StartDate"));
        table.setText(0, 4, getKeyValue("EndDate"));
        table.setText(0, 5, getKeyValue("Hours"));
        table.setText(0, 6, getKeyValue("Status"));
        table.setText(0, 7, getKeyValue("Cancel"));
        table.setText(0, 8, getKeyValue("Update"));
        table.setText(0, 9, getKeyValue("Print"));
    }
    
    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get("employee");
            table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            setEnumColumn(i, 2, entity, "category", "category");
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 5, JSONUtils.toString(entity, "hours"));
            table.setText(i, 6, JSONUtils.formatEnumString(entity, "status"));
            if (enableCancelRequest(entity)) {
                ClickableLink cancelL = new ClickableLink("Cancel Request");
                cancelL.setTitle(JSONUtils.toString(entity, "id"));
                cancelL.addClickHandler(this);
                table.setWidget(i, 7, cancelL);
            }
            if (enableUpdateRequest(entity)) {
                ClickableLink updateL = new ClickableLink("Update Request");
                updateL.setTitle(JSONUtils.toString(entity, "id"));
                updateL.addClickHandler(this);
                table.setWidget(i, 8, updateL);
            }
            FileField reportL = new FileField("Print", ChiliClientConfig.instance().getFileDownloadUrl() + "corporate-timesheet/report" + "&passthrough=true" + "&id=" + JSONUtils.toString(entity, "id"));
            table.setWidget(i, 9, reportL);
        }
    }
    
    protected boolean enableCancelRequest(JSONObject entity) {
        String status = JSONUtils.toString(entity, "status");
        String category = JSONUtils.toString(entity, "category");
        if (isMyTimeSheet(entity) && Arrays.asList(LeaveRequestTimeCategory.names()).contains(category) && !TimeSheetStatus.Canceled.name().equals(status)) {
            return true;
        } else {
            return false;
        }
    }
    
    protected boolean enableUpdateRequest(JSONObject entity) {
        String category = JSONUtils.toString(entity, "category");
        String status = JSONUtils.toString(entity, "status");
        if (isMyTimeSheet(entity) && Arrays.asList(LeaveRequestTimeCategory.names()).contains(category) && TimeSheetStatus.Pending.name().equals(status)) {
            return true;
        } else {
            return false;
        }
    }
    
    protected boolean isMyTimeSheet(JSONObject entity) {
        if (OfficeWelcome.instance().getCurrentUserEmpId().equals(JSONUtils.toString(entity.get("employee").isObject(), "employeeId"))) {
            return true;
        }
        return false;
    }
    
    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }
    
    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "corporate-timesheet/delete/" + entityId;
    }
    
    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource() instanceof ClickableLink) {
            ClickableLink link = (ClickableLink) event.getSource();
            if (link.getText().contains("Cancel")) {
                cancelLeaveRequest(link.getTitle());
            }
            if (link.getText().contains("Update")) {
                new GenericPopup(new CorpEmpLeaveRequestUpdatePanel(getEntity(link.getTitle()))).show();
            }
        } else {
            super.onClick(event);
        }
    }
    
    protected void cancelLeaveRequest(String requestId) {
        new GenericPopup(new CorpEmpLeaveRequestCancelPanel(requestId)).show();
    }
    
    @Override
    protected boolean showDocumentationLink() {
        return true;
    }
    
    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "timesheets/submit-leave-request.html";
    }
}
