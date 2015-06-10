/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author benerji.v
 */
public class ReadImmigrationCheckRequisitionPanel extends ReadComposite {

    private static ReadImmigrationCheckRequisitionPanel instance;
    private static Logger logger = Logger.getLogger(ReadImmigrationCheckRequisitionPanel.class.getName());
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);

    public static ReadImmigrationCheckRequisitionPanel instance() {
        return instance;
    }

    public ReadImmigrationCheckRequisitionPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    public ReadImmigrationCheckRequisitionPanel(String id) {
        instance = this;
        initReadComposite(id, "ImmigrationCheckRequisition", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                        populateComments(JSONUtils.toJSONArray(entity.get("items")));
                    }
                });
    }

    protected void populateComments(JSONArray items) {
        entityFieldsPanel.add(new ReadAllImmigrationCheckRequisitionItems(items));
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("requestedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("neededByDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("employee", true, false, DataType.STRING_FIELD);
        addField("amount", true, false, DataType.CURRENCY_FIELD);
        addField("requestedDate", true, false, DataType.DATE_FIELD);
        addField("neededByDate", true, false, DataType.DATE_FIELD);
        addEnumField("status", true, false, ImmigrationCheckRequisitionStatus.names());
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "checkrequisition/" + getEntityId();
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_EXPENSE);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition" + "/" + getEntityId();
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/process/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }

}
