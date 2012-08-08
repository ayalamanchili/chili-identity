/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.i18n.client.DateTimeFormat;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.ImageField;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget.OptionsType;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.gwt.date.DateUtils;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllEmployeesPanel extends ReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEmployeesPanel.class.getName());
    public static ReadAllEmployeesPanel instance;

    public ReadAllEmployeesPanel() {
        instance = this;
        initTable("Employee", OfficeWelcome.constants);
    }

    public ReadAllEmployeesPanel(JSONArray array) {
        instance = this;
        initTable("Employee", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        // TODO externalize the limit size for read all
        HttpServiceAsync.instance().doGet(getReadAllEmployeesURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });

    }

    public String getReadAllEmployeesURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "employee/" + start.toString() + "/" + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("First Name"));
        table.setText(0, 2, getKeyValue("Middle Name"));
        table.setText(0, 3, getKeyValue("Last Name"));
        table.setText(0, 4, getKeyValue("Email"));
        table.setText(0, 5, getKeyValue("Phone"));
        table.setText(0, 6, getKeyValue("Date of Birth"));
        table.setText(0, 7, getKeyValue("Sex"));
        table.setText(0, 8, getKeyValue("Image"));
        table.setText(0, 9, getKeyValue("Start Date"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "firstName"));
            table.setText(i, 2, JSONUtils.toString(entity, "middleInitial"));
            table.setText(i, 3, JSONUtils.toString(entity, "lastName"));
            table.setText(i, 4, JSONUtils.toString(entity, "email"));
            table.setText(i, 5, JSONUtils.toString(entity, "phoneNumber"));
            if (Auth.isAdmin() || Auth.isHR()) {
                table.setText(i, 6, DateUtils.getFormatedDate(JSONUtils.toString(entity, "dateOfBirth"), DateTimeFormat.PredefinedFormat.DATE_LONG));
            }
            table.setText(i, 7, JSONUtils.toString(entity, "sex"));
            table.setWidget(i, 8, new ImageField("Picture", JSONUtils.toString(entity, "imageURL"), JSONUtils.toString(entity, "id"), 50, 50, false));
            table.setText(i, 9, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_LONG));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin() || Auth.isHR()) {
            createOptionsWidget(OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadEmployeePanel(entityId));
        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
        TabPanel.instance().myOfficePanel.sidePanelTop.add(new TreeEmployeePanel(entityId));
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
        new ResponseStatusWidget().show("Successfully deleted Employee Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
        TabPanel.instance().myOfficePanel.sidePanelTop.add(new TreeEmployeePanel(entityId));
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateEmployeePanel(getEntity(entityId)));
    }
}
