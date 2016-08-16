/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.crud.TCRUDComposite;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expenseitem.CreateExpenseItemPanel;
import info.yalamanchili.office.client.expenseitem.UpdateExpenseItemPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import static info.yalamanchili.office.client.expensereports.CreateExpenseReportPanel.receiptsInfo;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class UpdateExpenseReportPanel extends UpdateComposite implements ChangeHandler {

    private Logger logger = Logger.getLogger(UpdateExpenseReportPanel.class.getName());
    public List<TCRUDComposite> updateItemPanels = new ArrayList<>();
    protected ClickableLink addItemL = new ClickableLink("Add Expense Item");
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, false, Alignment.HORIZONTAL);
    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants2, "ExpenseReceipt", "", "ExpenseReceipt/fileURL", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
        }
    };
    FormPanel formPanel = new FormPanel();
    protected static HTML travelInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Travel Expense Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    protected static HTML generalInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">General Expense Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML expenseItemsInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Expense Items Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    protected static HTML expenseReceiptInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Expense Receipts</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    protected static HTML notes = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Note: Please mail expense original receipts to Tampa office.</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    HTML emptyLine = new HTML("<br/>");

    EnumField expenseFormType;
    StringField purpose;
    StringField destination;
    StringField nameOfReport;
    StringField cardHolderName = new StringField(OfficeWelcome.constants2, CARDHOLDERNAME, "ExpenseReport", false, true, Alignment.HORIZONTAL);
    StringField expensesMadeBy = new StringField(OfficeWelcome.constants2, EXPENSESMADEBY, "ExpenseReport", false, true, Alignment.HORIZONTAL);
    DateField startDate;
    DateField endDate;
    StringField projectName;
    StringField projectNumber;
    EnumField reImbursmentMethod;
    IntegerField payrollFileNumber = new IntegerField(OfficeWelcome.constants2, PAYROLLFILENUMBER, "ExpenseReport", false, false, Alignment.HORIZONTAL);
    DateField submittedDate = new DateField(OfficeWelcome.constants2, SUBMITTEDDATE, "ExpenseReport", false, false, Alignment.HORIZONTAL);
    EnumField departmentType;
    StringField otherDepartment;

    JSONArray expenseReceipts = new JSONArray();
    BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants2, "Submit", "ExpenseReport", false, false, Alignment.HORIZONTAL);

    protected static UpdateExpenseReportPanel instance;

    public static UpdateExpenseReportPanel instance() {
        return instance;
    }

    public UpdateExpenseReportPanel(String id) {
        instance = this;
        initUpdateComposite(id, "ExpenseReport", OfficeWelcome.constants2);
    }

    public UpdateExpenseReportPanel(JSONObject object) {
        instance = this;
        initUpdateComposite(object, "ExpenseReport", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                logger.info(response);
                entity = (JSONObject) JSONParser.parseLenient(response);
                if (ExpenseFormType.GENERAL_EXPENSE.name().equals(JSONUtils.toString(getEntity(), EXPENSE_FORM_TYPE))) {
                    addGeneralExpenseFields();
                }
                if ("Other".equals(JSONUtils.toString(getEntity(), DEPARTMENTTYPE))) {
                    otherDepartment.setVisible(true);
                }
                populateFieldsFromEntity(entity);
                populateComments();
            }
        });
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "expensereport/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField(EXPENSE_FORM_TYPE, entity);
        assignEntityValueFromField(PURPOSE, entity);
        assignEntityValueFromField(NAMEOFREPORT, entity);
        assignEntityValueFromField(DESTINATION, entity);
        assignEntityValueFromField(START_DATE, entity);
        assignEntityValueFromField(END_DATE, entity);
        assignEntityValueFromField(PROJECT_NAME, entity);
        assignEntityValueFromField(PROJECT_NUMBER, entity);
        assignEntityValueFromField(REIMBURSMENTMETHOD, entity);
        assignEntityValueFromField(COMMENTS, entity);
        assignEntityValueFromField(COMPANY, entity);
        assignEntityValueFromField(DEPARTMENTTYPE, entity);
        JSONArray items = new JSONArray();
        int i = 0;
        for (TCRUDComposite panel : updateItemPanels) {
            if (panel instanceof UpdateExpenseItemPanel) {
                UpdateExpenseItemPanel updatePanel = (UpdateExpenseItemPanel) panel;
                items.set(i, updatePanel.populateEntityFromFields());
                i++;
            } else if (panel instanceof CreateExpenseItemPanel) {
                CreateExpenseItemPanel createPanel = (CreateExpenseItemPanel) panel;
                items.set(i, createPanel.populateEntityFromFields());
                i++;
            }
        }
        entity.put(EXPENSE_ITEMS, items);
        int j = expenseReceipts.size();
        logger.info(expenseReceipts.toString());
        for (JSONString fileName : fileUploadPanel.getFileNames()) {
            if (fileName != null && !fileName.stringValue().trim().isEmpty()) {
                JSONObject expenseReceipt = new JSONObject();
                expenseReceipt.put("fileURL", fileName);
                expenseReceipt.put("name", new JSONString("File Name"));
                expenseReceipts.set(j, expenseReceipt);
                j++;
            }
        }
        if (expenseReceipts.size() > 0) {
            entity.put(EXPENSE_RECEIPT, expenseReceipts);
        }
        if (cardHolderName.getValue() != null) {
            entity.put(CARDHOLDERNAME, new JSONString(cardHolderName.getValue()));
        }
        if (expensesMadeBy.getValue() != null) {
            entity.put(EXPENSESMADEBY, new JSONString(expensesMadeBy.getValue()));
        }
        if (payrollFileNumber.getValue() != null) {
            entity.put(PAYROLLFILENUMBER, new JSONString(payrollFileNumber.getValue()));
        }
        if (submittedDate.getDate() != null) {
            entity.put(SUBMITTEDDATE, new JSONString(DateUtils.toDateString(submittedDate.getDate())));
        }
        if (fields.containsKey("company") && selectCompanyWidget.getSelectedObject() != null) {
            JSONObject company = selectCompanyWidget.getSelectedObject();
            company.put("name", company.get("value"));
            entity.put("company", company);
        }
        EnumField field1 = (EnumField) fields.get("departmentType");
        if (field1.getValue() != null && !field1.getValue().trim().isEmpty()) {
            entity.put("departmentType", new JSONString(field1.getValue()));
        } else {
            entity.put("departmentType", null);
        }
        if (otherDepartment.isVisible() == true) {
            entity.put(OTHERDEPARTMENT, new JSONString(otherDepartment.getValue()));
        }
        entity.put(OTHEREMPLOYEES, otherEmployees.getSelectedObjects());
        return entity;
    }

    protected final void populateComments() {
        if (!getEntityId().isEmpty()) {
            entityActionsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport"));
        }
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                uploadReceipts(arg0);
            }
        });
    }

    protected void uploadReceipts(String postString) {
        JSONObject post = (JSONObject) JSONParser.parseLenient(postString);
        fileUploadPanel.upload(JSONUtils.toJSONArray(post.get(EXPENSE_RECEIPT)), "fileURL");
    }

    @Override
    protected Map<String, BaseField> getChildWidget(int childIndexWidget) {
        return updateItemPanels.get(childIndexWidget).fields;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity(EXPENSE_FORM_TYPE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(PURPOSE, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(NAMEOFREPORT, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(DESTINATION, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(START_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(END_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(PROJECT_NAME, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(PROJECT_NUMBER, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(REIMBURSMENTMETHOD, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(DEPARTMENTTYPE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(OTHERDEPARTMENT, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(COMPANY, entity, null);
        assignFieldValueFromEntity(DEPARTMENTTYPE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(COMMENTS, entity, DataType.TEXT_AREA_FIELD);
        expenseReceipts = JSONUtils.toJSONArray(entity.get(EXPENSE_RECEIPT));
        if (expenseReceipts.size() > 0) {
            if (expenseReceipts != null) {
                populateExpenseReceipt(expenseReceipts);
            }
        }
        JSONArray expenseItems = JSONUtils.toJSONArray(entity.get(EXPENSE_ITEMS));
        populateExpenseItems(expenseItems);
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
        // populateComments();
    }

    protected void populateExpenseItems(JSONArray items) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isObject() != null) {
                UpdateExpenseItemPanel panel = new UpdateExpenseItemPanel(getEntityId(), items.get(i).isObject(), isGeneralExpenseItem());
                updateItemPanels.add(panel);
                entityFieldsPanel.insert(panel, entityFieldsPanel.getWidgetIndex(expenseItemsInfo) + 1);
            }
        }
    }

    protected void populateExpenseReceipt(JSONArray items) {
        entityFieldsPanel.insert(new ReadAllExpenseReceiptsPanel(getEntityId(), items), entityFieldsPanel.getWidgetIndex(receiptsInfo) + 1);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee Expense Form Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllExpenseReportsPanel());
    }

    @Override
    protected void addListeners() {
        addItemL.addClickHandler(this);
        reImbursmentMethod.listBox.addChangeHandler(this);
        departmentType.listBox.addChangeHandler(this);
        submitForApprovalF.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
        expenseFormType.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        purpose.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        startDate.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        endDate.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        projectName.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        projectNumber.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        reImbursmentMethod.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        generalInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        travelInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        expenseItemsInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        expenseReceiptInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        notes.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        otherDepartment.setVisible(false);
        otherEmployees.setVisible(true);
    }
    SelectEmployeeWidget otherEmployees = new SelectEmployeeWidget(OTHEREMPLOYEES, false, false, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };

    @Override
    protected void addWidgets() {
        addEnumField(EXPENSE_FORM_TYPE, true, true, ExpenseFormType.names(), Alignment.HORIZONTAL);
        expenseFormType = (EnumField) fields.get(EXPENSE_FORM_TYPE);
        addField(NAMEOFREPORT, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        nameOfReport = (StringField) fields.get(NAMEOFREPORT);
        addField(PURPOSE, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        purpose = (StringField) fields.get(PURPOSE);
        addField(DESTINATION, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        destination = (StringField) fields.get(DESTINATION);
        addField(START_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        startDate = (DateField) fields.get(START_DATE);
        addField(END_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        endDate = (DateField) fields.get(END_DATE);
        addField(PROJECT_NAME, false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        projectName = (StringField) fields.get(PROJECT_NAME);
        addField(PROJECT_NUMBER, false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        projectNumber = (StringField) fields.get(PROJECT_NUMBER);
        addEnumField(REIMBURSMENTMETHOD, false, true, ReImbursmentMethod.names(), Alignment.HORIZONTAL);
        reImbursmentMethod = (EnumField) fields.get(REIMBURSMENTMETHOD);
        addDropDown("company", selectCompanyWidget);
        addEnumField(DEPARTMENTTYPE, false, true, Department.names(), Alignment.HORIZONTAL);
        departmentType = (EnumField) fields.get(DEPARTMENTTYPE);
        addField(OTHERDEPARTMENT, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        otherDepartment = (StringField) fields.get(OTHERDEPARTMENT);
        addField(COMMENTS, false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(receiptsInfo);
        entityFieldsPanel.add(fileUploadPanel);
        entityFieldsPanel.add(expenseItemsInfo);
        entityActionsPanel.add(addItemL);
        entityActionsPanel.add(getLineSeperatorTag("I certify that all information in my expenses report is accurate and true."));
        entityActionsPanel.add(submitForApprovalF);
        submitForApprovalF.setValue(true);
        setButtonText("Submit");
        alignFields();
    }

    protected void addGeneralExpenseFields() {
        entityFieldsPanel.insert(otherEmployees, entityFieldsPanel.getWidgetIndex(receiptsInfo));
        entityFieldsPanel.insert(cardHolderName, entityFieldsPanel.getWidgetIndex(receiptsInfo));
        entityFieldsPanel.insert(expensesMadeBy, entityFieldsPanel.getWidgetIndex(receiptsInfo));
        entityFieldsPanel.insert(payrollFileNumber, entityFieldsPanel.getWidgetIndex(receiptsInfo));
        entityFieldsPanel.insert(submittedDate, entityFieldsPanel.getWidgetIndex(receiptsInfo));
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (!getEntityId().isEmpty()) {
            return OfficeWelcome.constants.root_url() + "expensereport/save?submitForApproval=" + submitForApprovalF.getValue();
        } else {
            return OfficeWelcome.constants.root_url() + "expensereport/submit?submitForApproval=" + submitForApprovalF.getValue();
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addItemL)) {
            CreateExpenseItemPanel panel = new CreateExpenseItemPanel(this, isGeneralExpenseItem());
            updateItemPanels.add(panel);
            entityFieldsPanel.add(panel);
        }
        if (submitForApprovalF.getValue()) {
            setButtonText("Submit");
        } else {
            setButtonText("Update");
        }
        if (event.getSource().equals(update)) {
            super.onClick(event);
        }
    }

    protected boolean isGeneralExpenseItem() {
        return expenseFormType.getValue().equals(ExpenseFormType.GENERAL_EXPENSE.name());
    }

    public void removePanel() {
        if (updateItemPanels.size() > 0) {
            int i = updateItemPanels.size();
            updateItemPanels.get(i - 1).removeFromParent();
            updateItemPanels.remove(i - 1);
        }
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(departmentType.listBox)) {
            if (departmentType.getValue().equals(Department.Other.name())) {
                otherDepartment.setVisible(true);
            } else {
                otherDepartment.setVisible(false);
            }
        }
    }
}
