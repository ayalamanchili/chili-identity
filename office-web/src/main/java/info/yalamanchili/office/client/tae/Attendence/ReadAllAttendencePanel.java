/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.Attendence;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.time.corp.PTOAccruedHoursAdjustmentPanel;
import info.yalamanchili.office.client.time.corp.ReadCorporateTimeSheetPanel;
import info.yalamanchili.office.client.time.corp.UpdateCorporateTimeSheetPanel;
import java.util.logging.Logger;

/**
 *
 * @author benerji.v
 */
public class ReadAllAttendencePanel extends CRUDReadAllComposite implements ClickHandler{
    private static Logger logger = Logger.getLogger(ReadAllAttendencePanel.class.getName());
    public static ReadAllAttendencePanel instance;

    public ReadAllAttendencePanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Corporate Time Sheets", OfficeWelcome.constants);
    }

    public ReadAllAttendencePanel() {
        instance = this;
        initTable("My Time Sheets", OfficeWelcome.constants);
    }

    public ReadAllAttendencePanel(String title, JSONArray array) {
        instance = this;
        initTable(title, array, OfficeWelcome.constants);
    }
    protected boolean isEmployeesOnLeavePanel = false;

    public ReadAllAttendencePanel(String title, JSONArray array, boolean isEmployeesOnLeavePanel) {
        instance = this;
        this.isEmployeesOnLeavePanel = isEmployeesOnLeavePanel;
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
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllAttendencePanel(parentId));

    }

    @Override
    public void updateClicked(String entityId) {
        if (JSONUtils.toString(getEntity(entityId), "category").equals("PTO_ACCRUED")) {
            new GenericPopup(new PTOAccruedHoursAdjustmentPanel(parentId, getEntity(entityId))).show();
        } else {
            TabPanel.instance().timePanel.entityPanel.clear();
            TabPanel.instance().timePanel.entityPanel.add(new UpdateCorporateTimeSheetPanel(getEntity(entityId)));
        }
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

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        if (!isEmployeesOnLeavePanel) {
            table.setText(0, 2, getKeyValue("Category"));
        }
        table.setText(0, 3, getKeyValue("StartDate"));
        table.setText(0, 4, getKeyValue("EndDate"));
        table.setText(0, 5, getKeyValue("ReceptionTotal"));
        table.setText(0, 6, getKeyValue("ReceptionCubical"));
        table.setText(0, 7, getKeyValue("CubicalHours"));
        table.setText(0, 8, getKeyValue("2ndFloorTotal"));
        table.setText(0, 9, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get("employee");
            table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            if (!isEmployeesOnLeavePanel) {
                setEnumColumn(i, 2, entity, "category", "category");
            }
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 5, JSONUtils.toString(entity, "hours"));
            table.setText(i, 6, JSONUtils.formatEnumString(entity, "hours"));
            table.setText(i, 7, JSONUtils.formatEnumString(entity, "hours"));
            table.setText(i, 8, JSONUtils.formatEnumString(entity, "hours"));
            table.setText(i, 9, JSONUtils.formatEnumString(entity, "status"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    private String getDeleteURL(String entityId) {
                return OfficeWelcome.instance().constants.root_url() + "corporate-timesheet/delete/" + entityId;

    }

    private String getReadAllCorporateTimeSheetsURL(Integer start, String limit) {
        String queryStr = "?";
        if (AttendenceSidePanel.instance != null && AttendenceSidePanel.instance.categoryField.getValue() != null) {
            queryStr = queryStr + "&category=" + AttendenceSidePanel.instance.categoryField.getValue();
        }
        if (AttendenceSidePanel.instance != null && AttendenceSidePanel.instance.statusField.getValue() != null) {
            queryStr = queryStr + "&status=" + AttendenceSidePanel.instance.statusField.getValue();
        }
        if (parentId == null) {
            return OfficeWelcome.constants.root_url() + "corporate-timesheet/currentuser/" + start.toString() + "/" + limit.toString() + queryStr;
        } else {
            return OfficeWelcome.constants.root_url() + "corporate-timesheet/employee/" + parentId + "/" + start.toString() + "/" + limit.toString() + queryStr;
        }
    }

    
    
}
