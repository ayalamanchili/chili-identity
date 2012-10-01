/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheetperiod;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.date.DateUtils;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.client.TreeClientPanel;
import java.util.logging.Logger;
/**
 *
 * @author bala
 */

public class ReadAllTimeSheetPeriodsPanel extends ReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllTimeSheetPeriodsPanel.class.getName());
    public static ReadAllTimeSheetPeriodsPanel instance;

    public ReadAllTimeSheetPeriodsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("TimeSheetPeriod", OfficeWelcome.constants);
    }

    public ReadAllTimeSheetPeriodsPanel() {
        instance = this;
        initTable("TimeSheetPeriod", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllTimeSheetPeriodsPanelURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
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
        //table.setText(0, 1, getKeyValue("Name"));
        //table.setText(0, 2, getKeyValue("Description"));
        table.setText(0, 1, getKeyValue("StartDate"));
        table.setText(0, 2, getKeyValue("EndDate"));
    }

    @Override
    public void fillData(JSONArray entities) {

        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            //table.setText(i, 1, JSONUtils.toString(entity, "name"));
            //table.setText(i, 2, JSONUtils.toString(entity, "description"));
            table.setText(i, 1, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_LONG));
            table.setText(i, 2, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_LONG));

            //table.setText(i, 5, JSONUtils.toString(entity, "client"));
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
        return OfficeWelcome.instance().constants.root_url() + "timesheetperiod/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {

        new ResponseStatusWidget().show("Successfully deleted TimeSheet Period Information");
        TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
        TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllTimeSheetPeriodsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().TimeandExpensePanel.sidePanelTop.clear();
//        TabPanel.instance().TimeandExpensePanel.sidePanelTop.add(new TreeClientPanel(entityId));
        TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
        //TabPanel.instance().TimeandExpensePanel.entityPanel.add(new UpdateProjectPanel(getEntity(entityId)));
    }

    public String getReadAllTimeSheetPeriodsPanelURL(Integer start, String limit) {
            return OfficeWelcome.constants.root_url() + "timesheetperiod/" + start.toString() + "/" + limit.toString();
    }
}