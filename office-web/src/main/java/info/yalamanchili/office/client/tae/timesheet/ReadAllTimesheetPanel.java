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
        table.setText(0, 1, getKeyValue("Mon(B)"));
        table.setText(0, 2, getKeyValue("Mon(P)"));
        table.setText(0, 3, getKeyValue("Tue(B)"));
        table.setText(0, 4, getKeyValue("Tue(P)"));
        table.setText(0, 5, getKeyValue("Wed(B)"));
        table.setText(0, 6, getKeyValue("Wed(P)"));
        table.setText(0, 7, getKeyValue("Thu(B)"));
        table.setText(0, 8, getKeyValue("Thu(P)"));
        table.setText(0, 9, getKeyValue("Fri(B)"));
        table.setText(0, 10, getKeyValue("Fri(P)"));
        table.setText(0, 11, getKeyValue("Sat(B)"));
        table.setText(0, 12, getKeyValue("Sat(P)"));
        table.setText(0, 13, getKeyValue("Sun(B)"));
        table.setText(0, 14, getKeyValue("Sun(P)"));
      
    }

    @Override
    public void fillData(JSONArray entities) {
         for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "mondayPaidHours"));
            table.setText(i, 2, JSONUtils.toString(entity, "mondayBilledHours"));
            table.setText(i, 3, JSONUtils.toString(entity, "tuesdayPaidHours"));
            table.setText(i, 4, JSONUtils.toString(entity, "tuesdayBilledHours"));
            table.setText(i, 5, JSONUtils.toString(entity, "wednesdayPaidHours"));
            table.setText(i, 6, JSONUtils.toString(entity, "wednesdayBilledHours"));
            table.setText(i, 7, JSONUtils.toString(entity, "thursdayPaidHours"));
            table.setText(i, 8, JSONUtils.toString(entity, "thursdayBilledHours"));
            table.setText(i, 9, JSONUtils.toString(entity, "fridayPaidHours"));
            table.setText(i, 10, JSONUtils.toString(entity, "fridayBilledHours"));
            table.setText(i, 11, JSONUtils.toString(entity, "saturdayPaidHours"));
            table.setText(i, 12, JSONUtils.toString(entity, "saturdayBilledHours"));
            table.setText(i, 13, JSONUtils.toString(entity, "sundayPaidHours"));
            table.setText(i, 14, JSONUtils.toString(entity, "sundayBilledHours"));
            
            
            
            
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
        TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
        TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllTimesheetPanel()); 
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
        TabPanel.instance().TimeandExpensePanel.entityPanel.add(new UpdateTimesheetPanel(getEntity(entityId)));
    }
    
}
