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
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.expenseitem.ReadExpenseItemPanel;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
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
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, false, Alignment.HORIZONTAL);
    CurrencyField totalPersonalCardExpenses = new CurrencyField(OfficeWelcome.constants2, "totalPersonalCardExpenses", "ExpenseReport", true, true, Alignment.HORIZONTAL);
    CurrencyField totalCorporateCardExpenses = new CurrencyField(OfficeWelcome.constants2, "totalCorporateCardExpenses", "ExpenseReport", true, true, Alignment.HORIZONTAL);
    CurrencyField totalExpenses = new CurrencyField(OfficeWelcome.constants2, "totalExpenses", "ExpenseReport", true, true, Alignment.HORIZONTAL);

    FormPanel formPanel = new FormPanel();
//    protected static HTML travelInfo = new HTML("\n"
//            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
//            + "<strong style=\"color:#555555\">Travel Expense Information</strong></p>\n"
//            + "\n"
//            + "<ul>\n"
//            + "</ul>");
//    protected static HTML generalInfo = new HTML("\n"
//            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
//            + "<strong style=\"color:#555555\">General Expense Information</strong></p>\n"
//            + "\n"
//            + "<ul>\n"
//            + "</ul>");
    protected static HTML expenseInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Expense Details</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML expenseReceiptInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Expense Receipts</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    HTML emptyLine = new HTML("<br/>");

    EnumField expenseFormType;
    StringField location;
    StringField destination;
    StringField nameOfReport;
    StringField cardHolderName = new StringField(OfficeWelcome.constants2, CARDHOLDERNAME, "ExpenseReport", true, true, Alignment.HORIZONTAL);
    StringField expensesMadeBy = new StringField(OfficeWelcome.constants2, EXPENSESMADEBY, "ExpenseReport", true, true, Alignment.HORIZONTAL);
    DateField startDate;
    DateField endDate;
    StringField projectName;
    StringField projectNumber;
    EnumField expenseReimbursePaymentMode;
    DateField submittedDate = new DateField(OfficeWelcome.constants2, SUBMITTEDDATE, "ExpenseReport", true, true, Alignment.HORIZONTAL);
    IntegerField payrollFileNumber = new IntegerField(OfficeWelcome.constants2, PAYROLLFILENUMBER, "ExpenseReport", true, true, Alignment.HORIZONTAL);
    EnumField departmentType;
    StringField otherDepartment;

    SelectEmployeeWidget otherEmployees = new SelectEmployeeWidget(OTHEREMPLOYEES, true, true, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };

    public static ReadExpenseReportPanel instance() {
        return instance;
    }

    public ReadExpenseReportPanel(String id) {
        initReadComposite(id, "ExpenseReport", OfficeWelcome.constants2);
    }

    protected final void populateComments() {
        entityActionsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport"));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected void addWidgets() {
        addEnumField(EXPENSE_FORM_TYPE, true, false, ExpenseFormType.names(), Alignment.HORIZONTAL);
        expenseFormType = (EnumField) fields.get(EXPENSE_FORM_TYPE);
//        entityFieldsPanel.add(generalInfo);
//        entityFieldsPanel.add(travelInfo);
        SelectEmployeeWidget otherEmployees = new SelectEmployeeWidget(OTHEREMPLOYEES, true, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        otherEmployees.setVisible(true);
        addField(NAMEOFREPORT, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        nameOfReport = (StringField) fields.get(NAMEOFREPORT);
        addField(LOCATION, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        location = (StringField) fields.get(LOCATION);
        addField(DESTINATION, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        destination = (StringField) fields.get(DESTINATION);
        addField(START_DATE, true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        startDate = (DateField) fields.get(START_DATE);
        addField(END_DATE, true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        endDate = (DateField) fields.get(END_DATE);
        addField(EXPENSE_REPORT_NUMBER, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField(PROJECT_NAME, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        projectName = (StringField) fields.get(PROJECT_NAME);
        addField(PROJECT_NUMBER, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        projectNumber = (StringField) fields.get(PROJECT_NUMBER);
        addEnumField(REIMBURSMENTMETHOD, true, false, ExpenseReimbursePaymentMode.names(), Alignment.HORIZONTAL);
        expenseReimbursePaymentMode = (EnumField) fields.get(REIMBURSMENTMETHOD);
        addDropDown("company", selectCompanyWidget);
        addEnumField(DEPARTMENTTYPE, true, false, Department.names(), Alignment.HORIZONTAL);
        departmentType = (EnumField) fields.get(DEPARTMENTTYPE);
        addField(OTHERDEPARTMENT, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        otherDepartment = (StringField) fields.get(OTHERDEPARTMENT);
        entityFieldsPanel.add(expenseInfo);
        entityFieldsPanel.add(totalExpenses);
        entityFieldsPanel.add(totalPersonalCardExpenses);
        entityFieldsPanel.add(totalCorporateCardExpenses);
        alignFields();
    }

    protected void addGeneralExpenseFields() {
        entityFieldsPanel.insert(otherEmployees, entityFieldsPanel.getWidgetIndex(expenseInfo));
        entityFieldsPanel.insert(cardHolderName, entityFieldsPanel.getWidgetIndex(expenseInfo));
        entityFieldsPanel.insert(expensesMadeBy, entityFieldsPanel.getWidgetIndex(expenseInfo));
        entityFieldsPanel.insert(payrollFileNumber, entityFieldsPanel.getWidgetIndex(expenseInfo));
        entityFieldsPanel.insert(submittedDate, entityFieldsPanel.getWidgetIndex(expenseInfo));
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
        expenseReimbursePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
//        generalInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//        travelInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        expenseInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        expenseReceiptInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        otherDepartment.setVisible(true);
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
                        if (ExpenseFormType.GENERAL_EXPENSE.name().equals(JSONUtils.toString(getEntity(), EXPENSE_FORM_TYPE))) {
                            addGeneralExpenseFields();
                        }
                        logger.info(entity.toString());
                        populateFieldsFromEntity(entity);
                        populateComments();
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity(EXPENSE_FORM_TYPE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(LOCATION, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(NAMEOFREPORT, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(DESTINATION, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(START_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(END_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(PROJECT_NAME, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(PROJECT_NUMBER, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(REIMBURSMENTMETHOD, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(EXPENSE_REPORT_NUMBER, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(DEPARTMENTTYPE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(OTHERDEPARTMENT, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(COMPANY, entity, null);
        if (entity.containsKey("totalPersonalCardExpenses")) {
            totalPersonalCardExpenses.setValue(FormatUtils.formarCurrency(entity.get("totalPersonalCardExpenses").isString().stringValue()));
        }
        if (entity.containsKey("totalCorporateCardExpenses")) {
            totalCorporateCardExpenses.setValue(FormatUtils.formarCurrency(entity.get("totalCorporateCardExpenses").isString().stringValue()));
        }
        if (entity.containsKey("totalExpenses")) {
            totalExpenses.setValue(FormatUtils.formarCurrency(entity.get("totalExpenses").isString().stringValue()));
        }
        JSONArray expenseItems = JSONUtils.toJSONArray(entity.get(EXPENSE_ITEMS));
        populateExpenseItems(expenseItems);
        JSONArray expenseReceipts = JSONUtils.toJSONArray(entity.get(EXPENSE_RECEIPT));
        if (expenseReceipts != null) {
            populateExpenseReceipt(expenseReceipts);
        }
        if (ExpenseFormType.GENERAL_EXPENSE.name().equals(JSONUtils.toString(entity, "expenseFormType"))) {
            if (entity.containsKey("otherEmployees")) {
                JSONArray otherEmps = JSONUtils.toJSONArray(entity.get("otherEmployees"));
                if (otherEmps.size() > 0) {
                    if (otherEmps != null) {
                        otherEmployees.setSelectedValues(entity.get("otherEmployees").isArray());
                    }
                }
            }
            if (entity.containsKey("cardHolderName")) {
                cardHolderName.setValue(entity.get("cardHolderName").isString().stringValue());
            }
            if (entity.containsKey("expensesMadeBy")) {
                expensesMadeBy.setValue(entity.get("expensesMadeBy").isString().stringValue());
            }
            if (entity.containsKey("submittedDate")) {
                submittedDate.setValue(JSONUtils.toString(entity, "submittedDate"));
            }
            if (entity.containsKey("payrollFileNumber")) {
                payrollFileNumber.setValue(entity.get("payrollFileNumber").isString().stringValue());
            }
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
        entityFieldsPanel.add(new ReadAllExpenseReceiptsPanel(getEntityId(), items));
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS);
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
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport" + "/" + getEntityId();
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expensereport/" + entityId;
    }
}
