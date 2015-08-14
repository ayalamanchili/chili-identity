/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDComposite;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
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
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class UpdateExpenseReportPanel extends UpdateComposite {

    private Logger logger = Logger.getLogger(UpdateExpenseReportPanel.class.getName());
    protected List<UpdateExpenseItemPanel> updateItemPanels = new ArrayList<>();
    protected List<CreateExpenseItemPanel> expenseItemPanels = new ArrayList<>();
    protected ClickableLink addItemL = new ClickableLink("Add Expense Item");
    protected ClickableLink removeItemL = new ClickableLink("Remove Expense Item");
    protected static HTML generalInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">General Expense Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML expenseInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">Expense Items Information</strong></p>\n"
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
    EnumField expenseReimbursePaymentMode;

    public UpdateExpenseReportPanel(String id) {
        initUpdateComposite(id, "ExpenseReport", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info(response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);

                    }
                });
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "expensereport/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        BigDecimal totalExpensesAmount = BigDecimal.ZERO;
        assignEntityValueFromField(EXPENSE_FORM_TYPE, entity);
        assignEntityValueFromField(LOCATION, entity);
        assignEntityValueFromField(START_DATE, entity);
        assignEntityValueFromField(END_DATE, entity);
        assignEntityValueFromField(PROJECT_NAME, entity);
        assignEntityValueFromField(PROJECT_NUMBER, entity);
        assignEntityValueFromField(EXPENSE_REIMBURSE_PMT_MODE, entity);
        JSONArray items = new JSONArray();
        int i = 0;
        for (UpdateExpenseItemPanel panel : updateItemPanels) {
            items.set(i, panel.populateEntityFromFields());
            JSONObject entityObj = (JSONObject) items.get(i);
            if (!JSONUtils.toString(entityObj, AMOUNT).isEmpty()) {
                BigDecimal eAmount = new BigDecimal(JSONUtils.toString(entityObj, AMOUNT));
                totalExpensesAmount = totalExpensesAmount.add(eAmount);
            }
            i++;
        }
        if (expenseItemPanels.size() > 0) {
            for (CreateExpenseItemPanel panel : expenseItemPanels) {
                items.set(i, panel.populateEntityFromFields());
                JSONObject entityObj = (JSONObject) items.get(i);
                if (!JSONUtils.toString(entityObj, AMOUNT).isEmpty()) {
                    BigDecimal eAmount = new BigDecimal(JSONUtils.toString(entityObj, AMOUNT));
                    totalExpensesAmount = totalExpensesAmount.add(eAmount);
                }
                i++;
            }
        }
        entity.put(EXPENSE_ITEMS, items);
        entity.put(TOTAL_EXPENSES, new JSONString((totalExpensesAmount).abs().toString()));
        logger.info(entity.toString());
        return entity;
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
                        postUpdateSuccess(arg0);
                    }
                });
    }

    @Override
    protected CRUDComposite getChildWidget(int childIndexWidget) {
        return updateItemPanels.get(childIndexWidget);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity(EXPENSE_FORM_TYPE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(LOCATION, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(START_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(END_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(PROJECT_NAME, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(PROJECT_NUMBER, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(EXPENSE_REIMBURSE_PMT_MODE, entity, DataType.ENUM_FIELD);
        JSONArray expenseItems = JSONUtils.toJSONArray(entity.get("expenseItems"));
        populateExpenseItems(expenseItems);
    }

    protected void populateExpenseItems(JSONArray items) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isObject() != null) {
                UpdateExpenseItemPanel panel = new UpdateExpenseItemPanel(items.get(i).isObject());
                updateItemPanels.add(panel);
                entityFieldsPanel.add(panel);
            }
        }
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
        removeItemL.addClickHandler(this);
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
        expenseInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        addItemL.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        removeItemL.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    }

    @Override
    protected void addWidgets() {
        addEnumField(EXPENSE_FORM_TYPE, true, true, ExpenseFormType.names(), Alignment.HORIZONTAL);
        expenseFormType = (EnumField) fields.get(EXPENSE_FORM_TYPE);
        entityFieldsPanel.add(generalInfo);
        addField(LOCATION, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        location = (StringField) fields.get(LOCATION);
        addField(START_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        startDate = (DateField) fields.get(START_DATE);
        addField(END_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        endDate = (DateField) fields.get(END_DATE);
        addField(PROJECT_NAME, false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        projectName = (StringField) fields.get(PROJECT_NAME);
        addField(PROJECT_NUMBER, false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        projectNumber = (StringField) fields.get(PROJECT_NUMBER);
        addEnumField(EXPENSE_REIMBURSE_PMT_MODE, false, true, ExpenseReimbursePaymentMode.names(), Alignment.HORIZONTAL);
        expenseReimbursePaymentMode = (EnumField) fields.get(EXPENSE_REIMBURSE_PMT_MODE);
        entityFieldsPanel.add(expenseInfo);
        entityFieldsPanel.add(addItemL);
        entityFieldsPanel.add(removeItemL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expensereport/save";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addItemL)) {
            CreateExpenseItemPanel panel = null;
            if (expenseFormType.getValue().equals(ExpenseFormType.GENERAL_EXPENSE.name())) {
                panel = new CreateExpenseItemPanel(true);
            } else {
                panel = new CreateExpenseItemPanel();
            }
            expenseItemPanels.add(panel);
            entityFieldsPanel.add(panel);
        }
        if (event.getSource().equals(removeItemL)) {
            if (expenseItemPanels.size() > 0) {
                int i = expenseItemPanels.size();
                expenseItemPanels.get(i - 1).removeFromParent();
                expenseItemPanels.remove(i - 1);
            }
            if (updateItemPanels.size() > 0) {
                int i = updateItemPanels.size();
                updateItemPanels.get(i - 1).removeFromParent();
                updateItemPanels.remove(i - 1);
            }
        }
        super.onClick(event);
    }
}
