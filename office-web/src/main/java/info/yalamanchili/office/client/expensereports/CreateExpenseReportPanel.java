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
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TCRUDComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.CurrencyField;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class CreateExpenseReportPanel extends CreateComposite implements ChangeHandler, BlurHandler, ValueChangeHandler {

    private Logger logger = Logger.getLogger(CreateExpenseReportPanel.class.getName());
    protected ClickableLink addItemL = new ClickableLink("Add Expense Item");
    RadioButton foryourself = new RadioButton("expenses", "FOR YOURSELF");
    RadioButton forsomeone = new RadioButton("expenses", "FOR SOMEONE");
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);
    public List<CreateExpenseItemPanel> expenseItemPanels = new ArrayList();
    SuggestBox approvalManager = new SuggestBox(OfficeWelcome.constants2, "approvalManager", "ExpenseReport", false, false, Alignment.HORIZONTAL);
    SuggestBox otherEmployees = new SuggestBox(OfficeWelcome.constants2, "otherEmployees", "ExpenseReport", false, false, Alignment.HORIZONTAL);
    BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants2, "Submit", "ExpenseReport", false, false, Alignment.HORIZONTAL);
    HTML tac = new HTML(" I " + OfficeWelcome.instance().getCurrentUserName() + " Acknowledge that all information in my expenses report is accurate and true \n");
    HTML tac1 = new HTML("\n Note: If you would like to specify other 'Approver' instead of 'Report_To' manager, please mention in the below field \n");
    boolean isGeneralExpenseItem = false;
    CheckBox confrmCB = new CheckBox();
    HorizontalPanel hPanel = new HorizontalPanel();
    CurrencyField totalPersonalCardExpenses = new CurrencyField(OfficeWelcome.constants2, "totalPersonalCardExpenses", "ExpenseReport", true, false, Alignment.HORIZONTAL);
    CurrencyField totalCorporateCardExpenses = new CurrencyField(OfficeWelcome.constants2, "totalCorporateCardExpenses", "ExpenseReport", true, false, Alignment.HORIZONTAL);
    CurrencyField totalExpenses = new CurrencyField(OfficeWelcome.constants2, "totalExpenses", "ExpenseReport", true, false, Alignment.HORIZONTAL);

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
    protected static HTML Acknowledgement = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Acknowledge</strong></p>\n"
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
    CreateExpenseItemPanel panel = null;
    boolean readyOnly;

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
        entityFieldsPanel.add(approvalManager);
        entityFieldsPanel.add(tac1);
        entityFieldsPanel.add(generalInfo);
        expenseFormType = (EnumField) fields.get(EXPENSE_FORM_TYPE);
        entityFieldsPanel.add(travelInfo);
        entityFieldsPanel.add(foryourself);
        entityFieldsPanel.add(forsomeone);
        entityFieldsPanel.add(otherEmployees);
        addField(NAMEOFREPORT, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
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
        entityFieldsPanel.add(expenseItemsInfo);
        entityActionsPanel.add(addItemL);
        panel = new CreateExpenseItemPanel(this, isGeneralExpenseItem);
        expenseItemPanels.add(panel);
        entityFieldsPanel.add(panel);
        entityActionsPanel.add(receiptsInfo);
        entityActionsPanel.insert(totalExpenses, entityActionsPanel.getWidgetIndex(receiptsInfo));
        entityActionsPanel.insert(totalCorporateCardExpenses, entityActionsPanel.getWidgetIndex(totalExpenses));
        entityActionsPanel.insert(totalPersonalCardExpenses, entityActionsPanel.getWidgetIndex(totalCorporateCardExpenses));
        entityActionsPanel.add(fileUploadPanel);
        entityActionsPanel.add(Acknowledgement);
        hPanel.add(confrmCB);
        hPanel.add(tac);
        entityActionsPanel.add(hPanel);
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
        Acknowledgement.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        approvalManager.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH + 5, Style.Unit.PX);
        otherEmployees.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH + 5, Style.Unit.PX);
        setButtonText("Submit");
        approvalManager.setVisible(false);
        otherEmployees.setVisible(false);
        otherDepartment.setVisible(false);
        HttpService.HttpServiceAsync.instance().doGet(getCorpEmpIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    approvalManager.loadData(values);
                    otherEmployees.loadData(values);
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
        totalPersonalCardExpenses.setValue(BigDecimal.ZERO.negate(), readOnly);
        totalCorporateCardExpenses.setValue(BigDecimal.ZERO.negate(), readOnly);
        totalExpenses.setValue(BigDecimal.ZERO.negate(), readOnly);
    }

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
        panel.expensePaymentMode.listBox.addBlurHandler(this);
        panel.amount.getTextbox().addValueChangeHandler(this);
        totalPersonalCardExpenses.getTextbox().addChangeHandler(this);
        totalCorporateCardExpenses.getTextbox().addChangeHandler(this);
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
        if (otherEmployees.getSelectedObject() != null) {
            entity.put("otherEmployees", otherEmployees.getSelectedObject());
        }
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
        entity.put("totalPersonalCardExpenses", new JSONString(totalPersonalCardExpenses.getCurrency().toString()));
        entity.put("totalCorporateCardExpenses", new JSONString(totalCorporateCardExpenses.getCurrency().toString()));
        entity.put("totalExpenses", new JSONString(totalExpenses.getCurrency().toString()));
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
            onChange();
            panel = new CreateExpenseItemPanel(this, isGeneralExpenseItem);
            expenseItemPanels.add(panel);
            entityFieldsPanel.add(panel);
            panel.expensePaymentMode.listBox.addBlurHandler(this);
            panel.amount.getTextbox().addValueChangeHandler(this);
            onChange();
        }

        if (event.getSource().equals(panel.deleteB)) {
            String amount = panel.amount.getValue();
            if (amount != null && !amount.isEmpty()) {
                totalPersonalCardExpenses.setValue(totalPersonalCardExpenses.getCurrency().subtract(new BigDecimal(amount)).toString());
            }
            onChange();
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

    private void removeItems() {
        if (expenseItemPanels.size() > 0) {
            for (int i = 0; i <= expenseItemPanels.size() - 1; i++) {
                CreateExpenseItemPanel itemPanel = expenseItemPanels.get(i);
                itemPanel.removeFromParent();
                expenseItemPanels.remove(itemPanel);
            }
            CreateExpenseItemPanel itemPanel = expenseItemPanels.get(expenseItemPanels.size() - 1);
            itemPanel.removeFromParent();
            expenseItemPanels.remove(itemPanel);
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
        if (render == true) {
            approvalManager.setVisible(false);
            generalInfo.setVisible(false);
            travelInfo.setVisible(true);
            entityFieldsPanel.remove(tac1);
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
        } else {
            approvalManager.setVisible(true);
            generalInfo.setVisible(true);
            travelInfo.setVisible(false);
            entityFieldsPanel.insert(tac1, entityFieldsPanel.getWidgetIndex(approvalManager));
            entityFieldsPanel.insert(foryourself, entityFieldsPanel.getWidgetIndex(generalInfo) + 1);
            entityFieldsPanel.insert(forsomeone, entityFieldsPanel.getWidgetIndex(foryourself) + 1);
            entityFieldsPanel.insert(otherEmployees, entityFieldsPanel.getWidgetIndex(forsomeone) + 1);
            entityFieldsPanel.insert(cardHolderName, entityFieldsPanel.getWidgetIndex(destination) + 1);
            entityFieldsPanel.insert(expensesMadeBy, entityFieldsPanel.getWidgetIndex(cardHolderName) + 1);
            payrollFileNumber.setVisible(true);
            submittedDate.setVisible(true);
        }
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(expenseFormType.listBox)) {
            if (expenseFormType.getValue().equals(ExpenseFormType.GENERAL_EXPENSE.name())) {
                renderproject(false);
                isGeneralExpenseItem = true;
                addExpenseItems();
                approvalManager.setVisible(true);
                generalInfo.setVisible(true);
                travelInfo.setVisible(false);
                entityCaptionPanel.setCaptionHTML("General Expense form");
            } else if (expenseFormType.getValue().equals(ExpenseFormType.TRAVEL_EXPENSE.name())) {
                renderproject(true);
                isGeneralExpenseItem = false;
                addExpenseItems();
                isGeneralExpenseItem = false;
                travelInfo.setVisible(true);
                entityCaptionPanel.setCaptionHTML("Travel Expense form");
            }
            expenseFormType.setVisible(true);
        }
        if (event.getSource().equals(departmentType.listBox)) {
            if (departmentType.getValue().equals(Department.Other.name())) {
                otherDepartment.setVisible(true);
            } else {
                otherDepartment.setVisible(false);
            }
        }
        if (event.getSource().equals(totalPersonalCardExpenses.getTextbox()) || event.getSource().equals(totalCorporateCardExpenses.getTextbox())) {
            onChange();
        }
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (panel.expensePaymentMode.listBox.getName() != null) {
            onChange();
        }
    }

    public void onChange() {
        String amountV = "";
        totalPersonalCardExpenses.setValue("");
        String amountC = "";
        totalCorporateCardExpenses.setValue("");
        BigDecimal finalExpenses = BigDecimal.ZERO;
        if (expenseItemPanels.size() > 0) {
            for (int i = 0; i < expenseItemPanels.size(); i++) {
                CreateExpenseItemPanel itemPanel = expenseItemPanels.get(i);
                if (itemPanel.amount.getCurrency() != null && itemPanel.expensePaymentMode.getValue().equalsIgnoreCase("Personal_Card")) {
                    amountV = itemPanel.amount.getValue();
                    if (!totalPersonalCardExpenses.getValue().isEmpty()) {
                        BigDecimal finalAmt = totalPersonalCardExpenses.getCurrency().add(new BigDecimal(amountV));
                        totalPersonalCardExpenses.setValue(finalAmt, readyOnly);
                        amountV = "";
                    } else {
                        totalPersonalCardExpenses.setValue(new BigDecimal(amountV), readyOnly);
                        amountV = "";
                    }
                } else if (itemPanel.amount.getCurrency() != null && itemPanel.expensePaymentMode.getValue().equalsIgnoreCase("Corporate_Card")) {
                    amountC = itemPanel.amount.getValue();
                    if (!totalCorporateCardExpenses.getValue().isEmpty()) {
                        BigDecimal finalAmt = totalCorporateCardExpenses.getCurrency().add(new BigDecimal(amountC));
                        totalCorporateCardExpenses.setValue(finalAmt, readyOnly);
                        amountC = "";
                    } else {
                        totalCorporateCardExpenses.setValue(new BigDecimal(amountC), readyOnly);
                        amountC = "";
                    }
                }
            }

            if (totalCorporateCardExpenses.getValue().isEmpty() && totalPersonalCardExpenses.getValue().isEmpty()) {
                totalPersonalCardExpenses.setValue(BigDecimal.ZERO.negate(), readOnly);
                totalCorporateCardExpenses.setValue(BigDecimal.ZERO.negate(), readOnly);
                totalExpenses.setValue(BigDecimal.ZERO.negate(), readOnly);
            } else if (totalCorporateCardExpenses.getValue().isEmpty()) {
                finalExpenses = totalPersonalCardExpenses.getCurrency();
                totalCorporateCardExpenses.setValue(BigDecimal.ZERO.negate(), readOnly);
            } else if (totalPersonalCardExpenses.getValue().isEmpty()) {
                finalExpenses = totalCorporateCardExpenses.getCurrency();
                totalPersonalCardExpenses.setValue(BigDecimal.ZERO.negate(), readOnly);
            } else {
                finalExpenses = totalPersonalCardExpenses.getCurrency().add(totalCorporateCardExpenses.getCurrency());
            }
            totalExpenses.setValue(finalExpenses, readOnly);
        } else {
            totalPersonalCardExpenses.setValue(finalExpenses.negate(), readOnly);
            totalCorporateCardExpenses.setValue(finalExpenses.negate(), readOnly);
            totalExpenses.setValue(finalExpenses.negate(), readOnly);
        }
    }

    protected String getUploadUrl() {
        return ChiliClientConfig.instance().getFileUploadUrl();
    }

    private String getCorpEmpIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_CORPORATE_EMPLOYEE.name() + "/0/10000";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        if (entity.get("expenseFormType") != null && entity.get("expenseFormType").isString().stringValue().equals(ExpenseFormType.GENERAL_EXPENSE.name())) {
            if (cardHolderName.getValue() == null || "".equals(cardHolderName.getValue())) {
                fields.get("cardHolderName").setMessage("Card Holder Name can not be null");
                return false;
            }
            if (expensesMadeBy.getValue() == null || "".equals(expensesMadeBy.getValue())) {
                fields.get("expensesMadeBy").setMessage("Expense Made By can not be null");
                return false;
            }
        }
        startDate = (DateField) fields.get("startDate");
        endDate = (DateField) fields.get("endDate");
        if (startDate.getDate() != null && endDate.getDate() != null && startDate.getDate().after(endDate.getDate())) {
            endDate.setMessage("End Date must be equal to or after Start Date");
            return false;
        }
        if (startDate.getDate() != null && endDate.getDate() != null && startDate.getDate().after(new Date())) {
            startDate.setMessage("Start Date must be equal to or before Current Date");
            return false;
        }
        if (startDate.getDate() != null && endDate.getDate() != null && endDate.getDate().after(new Date())) {
            endDate.setMessage("End Date must be equal to or before Current Date");
            return false;
        }
        if (expenseItemPanels.size() > 0) {
            DateField expenseDate = null;
            for (int i = 0; i < expenseItemPanels.size(); i++) {
                CreateExpenseItemPanel itemPanel = expenseItemPanels.get(i);
                expenseDate = (DateField) itemPanel.fields.get("expenseDate");
                if (expenseDate.getDate() != null && (expenseDate.getDate().before(startDate.getDate()) || expenseDate.getDate().after(endDate.getDate()))) {
                    itemPanel.fields.get("expenseDate").setMessage("Expense Item Date must be equal to or between Expense Start Date and End Date");
                    return false;
                }
            }
        }
        if (confrmCB.getValue() == false) {
            Window.alert("Please Check Acknowledge Check Box before you submit the expense report");
            return false;
        }
        if (expenseItemPanels.size() > 0 && (fileUploadPanel.getFileNames().size() <= 0 || fileUploadPanel.getFileNames().get(0).stringValue().isEmpty())) {
            return Window.confirm("Your expense report does not have any receipts attached so will not be processed. Are you sure you still want to submit?");
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

    private void addExpenseItems() {
        removeItems();
        expenseItemPanels.clear();
        CreateExpenseItemPanel panel;
        panel = null;
        panel = new CreateExpenseItemPanel(this, isGeneralExpenseItem);
        expenseItemPanels.add(panel);
        entityFieldsPanel.insert(panel, entityFieldsPanel.getWidgetIndex(addItemL));
        entityFieldsPanel.add(addItemL);
    }

    @Override
    public void onValueChange(ValueChangeEvent event) {
        onChange();
    }
}
