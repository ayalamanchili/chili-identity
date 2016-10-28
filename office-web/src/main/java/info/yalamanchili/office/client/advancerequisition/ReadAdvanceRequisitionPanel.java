/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancerequisition;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.advancetranscation.AdvanceRequisitionStatus;
import info.yalamanchili.office.client.expense.bnkacct.ReadBankAcctWidget;
import info.yalamanchili.office.client.expense.check.ReadCheckWidget;
import info.yalamanchili.office.client.expense.check.ReadCheckWidget.ReadCheckWidgetType;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAdvanceRequisitionPanel extends ReadComposite {

    private static ReadAdvanceRequisitionPanel instance;
    private static Logger logger = Logger.getLogger(ReadAdvanceRequisitionPanel.class.getName());
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);

    public static ReadAdvanceRequisitionPanel instance() {
        return instance;
    }

    public ReadAdvanceRequisitionPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "AdvanceRequisition", OfficeWelcome.constants);
    }

    public ReadAdvanceRequisitionPanel(String id) {
        instance = this;
        initReadComposite(id, "AdvanceRequisition", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                        populateComments();
                    }
                });

    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.expense.AdvanceRequisition"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("purpose", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("neededBy", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        if (entity.containsKey("check")) {
            entityFieldsPanel.add(new ReadCheckWidget(ReadCheckWidgetType.CHECK_MAILING_INFO, entity.get("check").isObject()));
        }
        if (entity.containsKey("bankAccount")) {
            entityFieldsPanel.add(new ReadBankAcctWidget(entity.get("bankAccount").isObject()));
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", selectEmployeeWidgetF);
        addField("purpose", true, false, DataType.STRING_FIELD);
        addField("amount", true, false, DataType.CURRENCY_FIELD);
        addField("neededBy", true, false, DataType.DATE_FIELD);
        addEnumField("status", true, false, AdvanceRequisitionStatus.names());
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "advancerequisition/" + getEntityId();
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(ROLE.ROLE_EXPENSE, Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.expense.AdvanceRequisition" + "/" + getEntityId();
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        TabPanel.instance().expensePanel.sidePanelTop.clear();
        TabPanel.instance().getExpensePanel().sidePanelTop.add(new AdvanceRequisitionSidePanel());
        return ReadAllAdvanceRequisitionPanel.instance;
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
