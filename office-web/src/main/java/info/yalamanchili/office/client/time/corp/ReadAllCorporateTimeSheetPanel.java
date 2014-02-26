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
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
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
        initTable("CorporateTimeSheet", OfficeWelcome.constants);
    }

    public ReadAllCorporateTimeSheetPanel() {
        instance = this;
        initTable("CorporateTimeSheet", OfficeWelcome.constants);
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
        if (parentId == null) {
            return OfficeWelcome.constants.root_url() + "corporate-timesheet/currentuser/" + start.toString() + "/" + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "corporate-timesheet/employee/" + parentId + "/" + start.toString() + "/" + limit.toString();
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
        if (parentId == null) {
            table.setText(0, 7, getKeyValue("More"));
        }
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity.get("employee"), "firstName"));
            table.setText(i, 2, JSONUtils.toString(entity, "category"));
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 5, JSONUtils.toString(entity, "hours"));
            table.setText(i, 6, JSONUtils.toString(entity, "status"));
            if (parentId == null) {
                ClickableLink cancelL = new ClickableLink("Cancel Request");
                cancelL.setTitle(JSONUtils.toString(entity, "id"));
                cancelL.addClickHandler(this);
                table.setWidget(i, 7, cancelL);
            }
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR)) {
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
            ClickableLink cancelL = (ClickableLink) event.getSource();
            cancelLeaveRequest(cancelL.getTitle());
        } else {
            super.onClick(event);
        }
    }

    protected void cancelLeaveRequest(String requestId) {
        if (Window.confirm("Are you sure? You want to cancel the Leave Request")) {
            HttpService.HttpServiceAsync.instance().doGet(getCancelLeaveRequestUrl(requestId), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            new ResponseStatusWidget().show("Leave request has been canceled");
                            TabPanel.instance().getTimePanel().entityPanel.clear();
                            TabPanel.instance().getTimePanel().sidePanelTop.clear();
                            TabPanel.instance().getTimePanel().sidePanelTop.add(new CorporateTimeSummarySidePanel());
                            TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel());
                            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel());
                        }
                    });
        }
    }

    protected String getCancelLeaveRequestUrl(String requestId) {
        return OfficeWelcome.instance().constants.root_url() + "corporate-timesheet/cancel-leave-request/" + requestId;
    }
}
