/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expenseitem.ReadExpenseItemPanel;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ReadExpenseReportPanel extends ReadComposite {

    private static ReadExpenseReportPanel instance;
    private static Logger logger = Logger.getLogger(ReadExpenseItemPanel.class.getName());
    protected List<ReadExpenseItemPanel> readItemsPanels = new ArrayList<ReadExpenseItemPanel>();
    protected HorizontalPanel attachmentsPanel = new HorizontalPanel();

    protected static HTML generalInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">General Expense Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML expenseInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">Expense Details</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML expenseReceiptInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">Expense Receipts</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    HTML emptyLine = new HTML("<br/>");

    EnumField expenseFormType;
    StringField location;
    DateField startDate;
    DateField endDate;
    StringField projectName;
    StringField projectNumber;

    public static ReadExpenseReportPanel instance() {
        return instance;
    }

    public ReadExpenseReportPanel(String id) {
        initReadComposite(id, "ExpenseReport", OfficeWelcome.constants);
        populateComments();
    }

    protected final void populateComments() {
        entityActionsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport"));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected void addWidgets() {
        addEnumField(EXPENSE_FORM_TYPE, true, true, ExpenseFormType.names(), Alignment.HORIZONTAL);
        expenseFormType = (EnumField) fields.get(EXPENSE_FORM_TYPE);
        entityFieldsPanel.add(generalInfo);
        addField(LOCATION, true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        location = (StringField) fields.get(LOCATION);
        addField(START_DATE, true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        startDate = (DateField) fields.get(START_DATE);
        addField(END_DATE, true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        endDate = (DateField) fields.get(END_DATE);
        addField(PROJECT_NAME, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        projectName = (StringField) fields.get(PROJECT_NAME);
        addField(PROJECT_NUMBER, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        projectNumber = (StringField) fields.get(PROJECT_NUMBER);
        entityFieldsPanel.add(expenseInfo);
        alignFields();
    }

    @Override
    protected void configure() {
        expenseFormType.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        location.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        startDate.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        endDate.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        projectName.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        projectNumber.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        generalInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        expenseInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        expenseReceiptInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        logger.info(entity.toString());
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity(EXPENSE_FORM_TYPE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(LOCATION, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(START_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(END_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(PROJECT_NAME, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(PROJECT_NUMBER, entity, DataType.STRING_FIELD);
        JSONArray expenseItems = JSONUtils.toJSONArray(entity.get(EXPENSE_ITEMS));
        populateExpenseItems(expenseItems);
        JSONArray expenseReceipts = JSONUtils.toJSONArray(entity.get(EXPENSE_RECEIPT));
        if (expenseReceipts != null) {
            populateExpenseReceipt(expenseReceipts);
        }
    }

    protected void populateExpenseItems(JSONArray items) {
        if (expenseFormType.getValue().equals("GENERAL_EXPENSE")) {
            entityFieldsPanel.add(new ReadAllExpenseItemsPanel(items, true));
        } else {
            entityFieldsPanel.add(new ReadAllExpenseItemsPanel(items, false));
        }
    }

    protected void populateExpenseReceipt(JSONArray items) {
        entityFieldsPanel.add(new ReadAllExpenseReceiptsPanel(items));
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE);
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/process/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport" + "/" + getEntityId();
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expensereport/" + entityId;
    }
}
