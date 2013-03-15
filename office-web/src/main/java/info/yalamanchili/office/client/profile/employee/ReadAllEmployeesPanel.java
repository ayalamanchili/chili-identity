/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.ImageField;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.CRUDReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget.OptionsType;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllEmployeesPanel extends CRUDReadAllComposite {

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
                logger.info(result);
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
        table.setText(0, 2, getKeyValue("Last Name"));
        table.setText(0, 3, getKeyValue("Emp Id"));
        table.setText(0, 4, getKeyValue("Email"));
        table.setText(0, 5, getKeyValue("Phone"));
        table.setText(0, 6, getKeyValue("Sex"));
        table.setText(0, 7, getKeyValue("Image"));
//        table.setText(0, 8, getKeyValue("Start Date"));
        table.setText(0, 8, getKeyValue("Job Title"));
        table.setText(0, 9, getKeyValue("Type"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "firstName"));
            table.setText(i, 2, JSONUtils.toString(entity, "lastName"));
            table.setText(i, 3, JSONUtils.toString(entity, "employeeId"));
            table.setText(i, 4, JSONUtils.toString(entity, "email"));
            table.setText(i, 5, JSONUtils.toString(entity, "phoneNumber"));
            table.setText(i, 6, JSONUtils.toString(entity, "sex"));
            table.setWidget(i, 7, new ImageField("Picture", JSONUtils.toString(entity, "imageURL"), JSONUtils.toString(entity, "id"), 50, 50, false));
            table.setText(i, 8, JSONUtils.toString(entity, "jobTitle"));
            table.setText(i, 9, JSONUtils.toString(entity.get("employeeType"), "name"));
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
        TabPanel.instance().myOfficePanel.sidePanelTop.add(new TreeEmployeePanel(getEntity(entityId)));
    }

    @Override
    public void deleteClicked(String entityId) {
        if (Window.confirm("Are you sure? All Employee details will be deleted")) {
            HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String arg0) {
                    postDeleteSuccess();
                }
            });
        }
    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "employee/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Employee Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
        TabPanel.instance().myOfficePanel.sidePanelTop.add(new TreeEmployeePanel(getEntity(entityId)));
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateEmployeePanel(getEntity(entityId)));
    }
}
