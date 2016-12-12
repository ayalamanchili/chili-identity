/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.chkreq;

import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 *
 * @author benerji.v
 */
public class ReadImmigrationCheckRequisitionPanel extends ReadComposite {

    private static ReadImmigrationCheckRequisitionPanel instance;
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);
    private static Logger logger = Logger.getLogger(ReadImmigrationCheckRequisitionPanel.class.getName());
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", true, true, Alignment.HORIZONTAL);

    public static ReadImmigrationCheckRequisitionPanel instance() {
        return instance;
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
        JSONObject emp = (JSONObject) entity.get("employee");
        if (emp != null) {
            if (emp.get("company") != null) {
                JSONObject company = (JSONObject) emp.get("company");
                JSONValue name = company.get("name");
                entity.put("company", name);
            }
            employeeSB.setValue(emp.get("firstName").isString().stringValue());
        } else {
            employeeSB.setValue(JSONUtils.toString(entity, "employeeName"));
            if (entity.get("company") != null) {
                JSONObject company = (JSONObject) entity.get("company");
                JSONValue name = company.get("name");
                entity.put("company", name);
            };
        }
        assignFieldValueFromEntity("company", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("attorneyName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("mailingAddress", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("neededByDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("purpose", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("caseType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {
        employeeSB.getLabel().getElement().getStyle().setWidth(145, Style.Unit.PX);
        for (Entry<String, BaseField> e : fields.entrySet()) {
            if (e.getValue() instanceof BaseFieldWithTextBox) {
                setVisibleLengthSize(e.getKey(), 30);
            }
        }
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(employeeSB);
        addField("attorneyName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("mailingAddress", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("neededByDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("purpose", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addEnumField("caseType", true, true, ImmigrationCaseType.names(), Alignment.HORIZONTAL);
        addField("amount", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("company", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        alignFields();
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
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_EXPENSE, Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS);
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
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        return ReadAllImmigrationCheckRequisitionPanel.instance;
     }
}
