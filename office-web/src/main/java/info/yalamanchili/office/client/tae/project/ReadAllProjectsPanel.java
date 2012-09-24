/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.project;

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
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.client.TreeClientPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadAllProjectsPanel extends ReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllProjectsPanel.class.getName());
    public static ReadAllProjectsPanel instance;

  
    public ReadAllProjectsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Project", OfficeWelcome.constants);
    }
    public ReadAllProjectsPanel() {
        instance = this;
        initTable("Project", OfficeWelcome.constants);
    }
    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllProjectsPanelURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });

    }

    public String getReadAllProjectsPanelURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "project/" + start.toString() + "/" + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("Description"));
        table.setText(0, 3, getKeyValue("StartDate"));
        table.setText(0, 4, getKeyValue("EndDate"));
       // table.setText(0, 5, getKeyValue("Client"));
    }

    @Override
    public void fillData(JSONArray entities) {

        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            table.setText(i, 2, JSONUtils.toString(entity, "description"));
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_LONG));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_LONG));
            
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
        return OfficeWelcome.instance().constants.root_url() + "project/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {

        new ResponseStatusWidget().show("Successfully deleted Projects Information");
        TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
        TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllProjectsPanel(TreeClientPanel.instance().getEntityId()));
    }

    @Override
    public void updateClicked(String entityId) {
    }
}
