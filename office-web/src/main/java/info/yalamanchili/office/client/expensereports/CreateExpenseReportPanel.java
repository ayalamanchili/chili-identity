/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RadioButton;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TCRUDComposite;
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
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.expenseitem.CreateExpenseItemPanel;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class CreateExpenseReportPanel extends CreateComposite implements ChangeHandler, BlurHandler {

    private Logger logger = Logger.getLogger(CreateExpenseReportPanel.class.getName());
    protected ClickableLink addItemL = new ClickableLink("Add Expense Item");
    RadioButton foryourself = new RadioButton("expenses", "FOR YOURSELF");
    RadioButton forsomeone = new RadioButton("expenses", "FOR SOMEONE");
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);
    public List<CreateExpenseItemPanel> expenseItemPanels = new ArrayList();
    SuggestBox approvalManager = new SuggestBox(OfficeWelcome.constants2, "approvalManager", "ApprovalManager", false, false, Alignment.HORIZONTAL);
    BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants2, "Submit", "ExpenseReport", false, false, Alignment.HORIZONTAL);
    boolean isGeneralExpenseItem = false;

    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants2, "ExpenseReceipt", "", "ExpenseReceipt/fileURL", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(null);
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
    protected static HTML receiptsInfo = new HTML("\n"
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
    protected static HTML approver = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Note: If you would like to specify other 'Approver' instead of 'Report_To' manager, please mention in the below field.</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    HTML emptyLine = new HTML("<br/>");

    EnumField expenseFormType;
    StringField location;
    StringField destination;
    StringField nameOfReport;
    StringField cardHolderName;
    StringField expensesMadeBy;
    DateField startDate;
    DateField endDate;
    StringField projectName;
    StringField projectNumber;
    EnumField expenseReimbursePaymentMode;
    DateField submittedDate;
    EnumField departmentType;
    StringField otherDepartment;
    IntegerField payrollFileNumber;

    protected static CreateExpenseReportPanel instance;
    FileUpload fileUpload = new FileUpload();
    protected String filePrefix;
    ClickableLink addMoreFiles = new ClickableLink("Add More");

    public static CreateExpenseReportPanel instance() {
        return instance;
    }

    public CreateExpenseReportPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        instance = this;
        initCreateComposite("ExpenseReport", OfficeWelcome.constants2);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected void addWidgets() {
        addEnumField(EXPENSE_FORM_TYPE, false, true, ExpenseFormType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(approver);
        entityFieldsPanel.add(approvalManager);
        entityFieldsPanel.add(generalInfo);
        expenseFormType = (EnumField) fields.get(EXPENSE_FORM_TYPE);
        entityFieldsPanel.add(travelInfo);
        entityFieldsPanel.add(foryourself);
        entityFieldsPanel.add(forsomeone);
        addDropDown(OTHEREMPLOYEES, otherEmployees);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_CORPORATE_EMPLOYEE)) {
            addField(NAMEOFREPORT, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        nameOfReport = (StringField) fields.get(NAMEOFREPORT);
        addField(LOCATION, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        location = (StringField) fields.get(LOCATION);
        addField(DESTINATION, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        destination = (StringField) fields.get(DESTINATION);
        addField(CARDHOLDERNAME, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        cardHolderName = (StringField) fields.get(CARDHOLDERNAME);
        addField(EXPENSESMADEBY, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        expensesMadeBy = (StringField) fields.get(EXPENSESMADEBY);
        addField(START_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        startDate = (DateField) fields.get(START_DATE);
        addField(END_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        endDate = (DateField) fields.get(END_DATE);
        addField(PROJECT_NAME, false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        projectName = (StringField) fields.get(PROJECT_NAME);
        addField(PROJECT_NUMBER, false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        projectNumber = (StringField) fields.get(PROJECT_NUMBER);
        addField(PAYROLLFILENUMBER, false, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        payrollFileNumber = (IntegerField) fields.get(PAYROLLFILENUMBER);
        addEnumField(REIMBURSMENTMETHOD, false, true, ExpenseReimbursePaymentMode.names(), Alignment.HORIZONTAL);
        expenseReimbursePaymentMode = (EnumField) fields.get(REIMBURSMENTMETHOD);
        addField(SUBMITTEDDATE, false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        submittedDate = (DateField) fields.get(SUBMITTEDDATE);
        addDropDown("company", selectCompanyWidget);
        addEnumField(DEPARTMENTTYPE, false, true, Department.names(), Alignment.HORIZONTAL);
        departmentType = (EnumField) fields.get(DEPARTMENTTYPE);
        addField(OTHERDEPARTMENT, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        otherDepartment = (StringField) fields.get(OTHERDEPARTMENT);
        addField(COMMENTS, false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(receiptsInfo);
        entityFieldsPanel.add(fileUploadPanel);
        entityFieldsPanel.add(expenseItemsInfo);
        CreateExpenseItemPanel panel = null;
        entityActionsPanel.add(addItemL);
        entityFieldsPanel.add(notes);
        panel = new CreateExpenseItemPanel(this, isGeneralExpenseItem);
        expenseItemPanels.add(panel);
        entityFieldsPanel.add(panel);
        entityActionsPanel.add(getLineSeperatorTag("I certify that all information in my expenses report is accurate and true."));
        entityActionsPanel.add(submitForApprovalF);
        submitForApprovalF.setValue(true);
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
        generalInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        travelInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        expenseItemsInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        receiptsInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        notes.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        approver.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        approvalManager.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH + 5, Style.Unit.PX);
        setButtonText("Submit");
        approvalManager.setVisible(false);
        approver.setVisible(false);
        otherDepartment.setVisible(false);
        otherEmployees.setVisible(false);
        HttpService.HttpServiceAsync.instance().doGet(getGeneralExpMgrIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    approvalManager.loadData(values);
                }
            }
        });
        formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
        formPanel.setMethod(FormPanel.METHOD_POST);
        fileUpload.setName(filePrefix);
        formPanel.setAction(getUploadUrl());
        addMoreFiles.addClickHandler(this);
        fileUpload.getElement().setAttribute("multiple", "multiple");
        String mimeType = "application/pdf,image/jpeg,image/pjpegs";
        fileUploadPanel.getFileUpload().getElement().setAttribute("multiple", "multiple");
        fileUploadPanel.getFileUpload().getElement().setPropertyString("accept", mimeType);
    }

    SelectEmployeeWidget otherEmployees = new SelectEmployeeWidget(OTHEREMPLOYEES, false, false, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };

    @Override
    protected void addListeners() {
        expenseFormType.listBox.addChangeHandler(this);
        departmentType.listBox.addChangeHandler(this);
        submitForApprovalF.getBox().addClickHandler(this);
        projectName.getTextbox().addBlurHandler(this);
        projectNumber.getTextbox().addBlurHandler(this);
        expenseReimbursePaymentMode.listBox.addChangeHandler(this);
        addItemL.addClickHandler(this);
        forsomeone.addClickHandler(this);
        foryourself.addClickHandler(this);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        if (approvalManager.getSelectedObject() != null) {
            entity.put("approvalManagerId", approvalManager.getSelectedObject().get("id").isString());
        }
        assignEntityValueFromField(EXPENSE_FORM_TYPE, entity);
        assignEntityValueFromField(LOCATION, entity);
        assignEntityValueFromField(NAMEOFREPORT, entity);
        assignEntityValueFromField(DESTINATION, entity);
        assignEntityValueFromField(EXPENSESMADEBY, entity);
        assignEntityValueFromField(CARDHOLDERNAME, entity);
        assignEntityValueFromField(START_DATE, entity);
        assignEntityValueFromField(END_DATE, entity);
        assignEntityValueFromField(PROJECT_NAME, entity);
        assignEntityValueFromField(PROJECT_NUMBER, entity);
        assignEntityValueFromField(REIMBURSMENTMETHOD, entity);
        assignEntityValueFromField(PAYROLLFILENUMBER, entity);
        assignEntityValueFromField(SUBMITTEDDATE, entity);
        assignEntityValueFromField(DEPARTMENTTYPE, entity);
        assignEntityValueFromField(OTHERDEPARTMENT, entity);
        assignEntityValueFromField(COMMENTS, entity);
        assignEntityValueFromField(COMPANY, entity);
        entity.put("foryourself", new JSONString(foryourself.getValue().toString()));
        entity.put("forsomeone", new JSONString(forsomeone.getValue().toString()));
        entity.put(OTHEREMPLOYEES, otherEmployees.getSelectedObjects());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            if (fields.containsKey("company") && selectCompanyWidget.getSelectedObject() != null) {
                JSONObject company = selectCompanyWidget.getSelectedObject();
                company.put("name", company.get("value"));
                entity.put("company", company);
            }
        }
        EnumField field1 = (EnumField) fields.get("departmentType");
        if (field1.getValue() != null && !field1.getValue().trim().isEmpty()) {
            entity.put("departmentType", new JSONString(field1.getValue()));
        } else {
            entity.put("departmentType", null);
        }
        if (otherDepartment.isVisible() == true) {
            entity.put("otherDepartment", new JSONString(otherDepartment.getValue()));
        }
        if (expenseItemPanels.size() > 0) {
            JSONArray items = new JSONArray();
            int i = 0;
            for (CreateExpenseItemPanel panel : expenseItemPanels) {
                items.set(i, panel.populateEntityFromFields());
                i++;
            }
            entity.put(EXPENSE_ITEMS, items);
        }
        JSONArray expenseReceipts = new JSONArray();
        if (!fileUploadPanel.isEmpty()) {
            int i = 0;
            for (JSONString fileName : fileUploadPanel.getFileNames()) {
                JSONObject expenseReceipt = new JSONObject();
                expenseReceipt.put("fileURL", fileName);
                expenseReceipt.put("name", new JSONString("File Name"));
                expenseReceipts.set(i, expenseReceipt);
                i++;
            }
        }
        entity.put(EXPENSE_RECEIPT, expenseReceipts);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                logger.info(arg0.getMessage());
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                uploadReceipts(arg0);
            }
        });
    }

    @Override
    protected void addButtonClicked() {
    }

    protected void uploadReceipts(String postString) {
        if (!fileUploadPanel.isEmpty()) {
            JSONObject post = (JSONObject) JSONParser.parseLenient(postString);
            JSONArray expenseReceipts = JSONUtils.toJSONArray(post.get(EXPENSE_RECEIPT));
            fileUploadPanel.upload(expenseReceipts, "fileURL");
        } else {
            postCreateSuccess(null);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addItemL)) {
            CreateExpenseItemPanel panel = null;
            panel = new CreateExpenseItemPanel(this, isGeneralExpenseItem);
            expenseItemPanels.add(panel);
            entityFieldsPanel.add(panel);
        }
        if (event.getSource().equals(forsomeone)) {
            otherEmployees.setVisible(true);
        }
        if (event.getSource().equals(foryourself)) {
            otherEmployees.setVisible(false);
        }
        if (submitForApprovalF.getValue()) {
            setButtonText("Submit");
        } else {
            setButtonText("Save");
        }
        super.onClick(event);
    }

    public void removePanel() {
        if (expenseItemPanels.size() > 0) {
            int i = expenseItemPanels.size();
            expenseItemPanels.get(i - 1).removeFromParent();
            expenseItemPanels.remove(i - 1);
        }
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Expense Form Successfully Created");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllExpenseReportsPanel());
    }

    protected void renderproject(boolean render) {
        projectName.setVisible(true);
        projectNumber.setVisible(true);
        location.setVisible(true);
        approvalManager.setVisible(false);
        generalInfo.setVisible(false);
        if (render == true) {
            entityFieldsPanel.remove(foryourself);
            entityFieldsPanel.remove(forsomeone);
            entityFieldsPanel.remove(otherEmployees);
            entityFieldsPanel.remove(cardHolderName);
            entityFieldsPanel.remove(expensesMadeBy);
            if (fields.containsKey(PAYROLLFILENUMBER)) {
                payrollFileNumber.setVisible(false);
            }
            if (fields.containsKey(SUBMITTEDDATE)) {
                submittedDate.setVisible(false);
            }
        }
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(expenseFormType.listBox)) {
            if (expenseFormType.getValue().equals(ExpenseFormType.GENERAL_EXPENSE.name())) {
                renderproject(false);
                isGeneralExpenseItem = true;
                approvalManager.setVisible(true);
                approver.setVisible(true);
                generalInfo.setVisible(true);
                travelInfo.setVisible(false);
                entityCaptionPanel.setCaptionHTML("General Expense form");
            } else if (expenseFormType.getValue().equals(ExpenseFormType.TRAVEL_EXPENSE.name())) {
                renderproject(true);
                isGeneralExpenseItem = false;
                isGeneralExpenseItem = false;
                travelInfo.setVisible(true);
                entityCaptionPanel.setCaptionHTML("Travel Expense form");
            }
            expenseFormType.setVisible(false);
        }
        if (event.getSource().equals(departmentType.listBox)) {
            if (departmentType.getValue().equals(Department.Other.name())) {
                otherDepartment.setVisible(true);
            } else {
                otherDepartment.setVisible(false);
            }
        }
    }

    @Override
    public void onBlur(BlurEvent event) {
    }

    protected String getUploadUrl() {
        return ChiliClientConfig.instance().getFileUploadUrl();
    }

    private String getGeneralExpMgrIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_GENERAL_EXPENSE_MANAGER.name() + "/0/10000");
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        if (expenseItemPanels.size() > 0 && (fileUploadPanel.getFileNames().size() <= 0 || fileUploadPanel.getFileNames().get(0).stringValue().isEmpty())) {
            return Window.confirm("Your expense report does not have any receipts attached so will not be processed. Are you sure you still want to submit?");
        }
        StringField cardHolderNames = (StringField) fields.get(CARDHOLDERNAME);
        if (cardHolderNames.getValue() == null) {
            cardHolderNames.setMessage("Card Holder Name can not be null");
            return false;
        }
        StringField expensesMadeBy = (StringField) fields.get(EXPENSESMADEBY);
        if (expensesMadeBy.getValue() == null) {
            expensesMadeBy.setMessage("Expense Made By can not be null");
            return false;
        }
        return valid;

    }

    @Override
    protected Map<String, BaseField> getChildWidget(int childIndexWidget) {
        return ((TCRUDComposite) expenseItemPanels.get(childIndexWidget)).fields;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expensereport/submit?submitForApproval=" + submitForApprovalF.getValue();
    }

}
