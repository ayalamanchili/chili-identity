/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.consultant;

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
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.time.corp.ReadCorporateTimeSheetPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllConsultantTimeSheetsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllConsultantTimeSheetsPanel.class.getName());
    public static ReadAllConsultantTimeSheetsPanel instance;

    public ReadAllConsultantTimeSheetsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("ConsultantTimeSheet", OfficeWelcome.constants);
    }

    public ReadAllConsultantTimeSheetsPanel() {
        instance = this;
        initTable("My Time Sheets", OfficeWelcome.constants);
    }

    public ReadAllConsultantTimeSheetsPanel(String title, JSONArray array) {
        instance = this;
        initTable(title, array, OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadConsultantTimeSheetPanel(entityId));
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
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllConsultantTimeSheetsPanel(parentId));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new UpdateConsultantTimeSheetPanel(getEntity(entityId)));
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
        if (ConsultantTimeSidePanel.instance != null && ConsultantTimeSidePanel.instance.categoryField.getValue() != null) {
            queryStr = queryStr + "&category=" + ConsultantTimeSidePanel.instance.categoryField.getValue();
        }
        if (ConsultantTimeSidePanel.instance != null && ConsultantTimeSidePanel.instance.statusField.getValue() != null) {
            queryStr = queryStr + "&status=" + ConsultantTimeSidePanel.instance.statusField.getValue();
        }
        if (parentId == null) {
            return OfficeWelcome.constants.root_url() + "consultant-timesheet/currentuser/" + start.toString() + "/" + limit.toString() + queryStr;
        } else {
            return OfficeWelcome.constants.root_url() + "consultant-timesheet/employee/" + parentId + "/" + start.toString() + "/" + limit.toString() + queryStr;
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
        table.setText(0, 7, getKeyValue("More"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get("employee");
            table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));;
            table.setText(i, 2, JSONUtils.toString(entity, "category"));
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 5, JSONUtils.toString(entity, "hours"));
            table.setText(i, 6, JSONUtils.toString(entity, "status"));
            FileField reportL = new FileField("Print", ChiliClientConfig.instance().getFileDownloadUrl() + "consultant-timesheet/report" + "&passthrough=true" + "&id=" + JSONUtils.toString(entity, "id"));
            table.setWidget(i, 7, reportL);
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_RELATIONSHIP, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "consultant-timesheet/delete/" + entityId;
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "timesheets/consultant-leave-request.html";
    }
}
