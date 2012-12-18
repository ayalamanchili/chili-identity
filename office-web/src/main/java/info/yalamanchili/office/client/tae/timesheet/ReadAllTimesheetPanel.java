/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.sow.ReadAllSOWPanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ReadAllTimesheetPanel extends ReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllTimesheetPanel.class.getName());
    public static ReadAllTimesheetPanel instance;
    
      public ReadAllTimesheetPanel() {
        instance = this;
        initTable("Timesheet", OfficeWelcome.constants);
    }

    public ReadAllTimesheetPanel(JSONArray array) {
        instance = this;
        initTable("Timesheet", array, OfficeWelcome.constants);
    }
     public ReadAllTimesheetPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Timesheet", OfficeWelcome.constants);
    }
    @Override
    public void preFetchTable(int start) {
          HttpService.HttpServiceAsync.instance().doGet(getReadAllTimesheetPanelURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }
  public String getReadAllTimesheetPanelURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "timesheet/" + start.toString() + "/" + limit.toString();
    }
    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("StartDate"));
        table.setText(0, 3, getKeyValue("EndDate"));
        table.setText(0, 4, getKeyValue("QBRate"));
        table.setText(0, 5, getKeyValue("QBHours"));
        table.setText(0, 6, getKeyValue("ADPRate"));
        table.setText(0, 7, getKeyValue("ADPHours"));
        table.setText(0, 8, getKeyValue("Notes"));
        table.setText(0, 9, getKeyValue("PayPeriod"));
    }

    @Override
    public void fillData(JSONArray entities) {
         for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity.get("employee"),"firstName"));
            table.setText(i, 2, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"),DateTimeFormat.PredefinedFormat.DATE_LONG));
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"),DateTimeFormat.PredefinedFormat.DATE_LONG));
            table.setText(i, 4, JSONUtils.toString(entity, "quickBooksRate"));
            table.setText(i, 5, JSONUtils.toString(entity, "quickBooksHours"));
            table.setText(i, 6, JSONUtils.toString(entity, "adpRate"));
            table.setText(i, 7, JSONUtils.toString(entity, "adpHours"));
            table.setText(i, 8, JSONUtils.toString(entity, "notes"));
            table.setText(i, 9, JSONUtils.toString(entity.get("timeSheetPeriod"),"name"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void viewClicked(String entityId) {
       
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
        return OfficeWelcome.instance().constants.root_url() + "timesheet/delete/" + entityId;
    }
    @Override
    public void postDeleteSuccess() {
       new ResponseStatusWidget().show("Successfully Deleted Time Sheet Information");
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ReadAllTimesheetPanel()); 
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new UpdateTimesheetPanel(getEntity(entityId)));
    }
    
}
