/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.fields.ImageField;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget.OptionsType;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTMLTable;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth.ROLE;

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
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadEmployeePanel(JSONUtils.toString(getEntity(id), "id")), Window.getClientWidth() / 3, 0).show();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("First Name"));
        table.setText(0, 2, getKeyValue("Last Name"));
        table.setText(0, 3, getKeyValue("Email"));
        if (Auth.isCorporateEmployee()) {
            table.setText(0, 4, getKeyValue("Phone"));
            table.setText(0, 5, getKeyValue("Job Title"));
            table.setText(0, 6, getKeyValue("Image"));
        } else {
            table.setText(0, 4, getKeyValue("Job Title"));
            table.setText(0, 5, getKeyValue("Image"));
        }

    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "firstName"));
            table.setText(i, 2, JSONUtils.toString(entity, "lastName"));
            table.setText(i, 3, JSONUtils.toString(entity, "email"));
            if (Auth.isCorporateEmployee()) {
                table.setText(i, 4, FormatUtils.formatPhoneNumber(JSONUtils.toString(entity, "phoneNumber")));
                table.setText(i, 5, JSONUtils.toString(entity, "jobTitle"));
                table.setWidget(i, 6, new ImageField("Picture", JSONUtils.toString(entity, "imageURL"), JSONUtils.toString(entity, "id"), 50, 50, false));
            } else {
                table.setText(i, 4, JSONUtils.toString(entity, "jobTitle"));
                table.setWidget(i, 5, new ImageField("Picture", JSONUtils.toString(entity, "imageURL"), JSONUtils.toString(entity, "id"), 50, 50, false));
            }
            Boolean status = JSONUtils.toBoolean(entity, "status");
            if (!status) {
                if (Auth.isEmployee(entity) || Auth.isCorporateEmployee(entity) || Auth.isInternEmployee(entity)) {
                    HTMLTable.RowFormatter rf = table.getRowFormatter();
                    rf.addStyleName(i, "y-gwt-ReadAllComposite-DeactiveRow");
                }
            }
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin()) {
            createOptionsWidget(OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_CONSULTANT_TIME_ADMIN, ROLE.ROLE_ON_BOARDING_MGR)) {
            createOptionsWidget(OptionsType.READ_UPDATE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(entityId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject entity = (JSONObject) JSONParser.parseLenient(response);
                        TabPanel.instance().myOfficePanel.entityPanel.clear();
                        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadEmployeePanel(entity));
                        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
                        TabPanel.instance().myOfficePanel.sidePanelTop.add(new TreeEmployeePanel(entity));
                    }
                });

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
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(entityId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject entity = (JSONObject) JSONParser.parseLenient(response);
                        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
                        TabPanel.instance().myOfficePanel.sidePanelTop.add(new TreeEmployeePanel(entity));
                        TabPanel.instance().myOfficePanel.entityPanel.clear();
                        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateEmployeePanel(entity));
                    }
                });

    }

    protected String getReadURI(String entityId) {
        return OfficeWelcome.constants.root_url() + "employee/" + entityId;
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_SYSTEM_AND_NETWORK_ADMIN, ROLE.ROLE_CONTRACTS_ADMIN)) {
            createButton.setText("Create Employee");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEmployeePanel(CreateComposite.CreateCompositeType.CREATE));
    }
}
