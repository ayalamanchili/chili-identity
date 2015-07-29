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
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDComposite;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expenseitem.UpdateExpenseItemPanel;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class UpdateExpenseReportPanel extends UpdateComposite {

    private Logger logger = Logger.getLogger(UpdateExpenseReportPanel.class.getName());
    protected List<UpdateExpenseItemPanel> updateItemPanels = new ArrayList<UpdateExpenseItemPanel>();
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

    EnumField expenseFormPurpose;
    StringField name;
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
        if (expenseFormPurpose.getValue() != null) {
            entity.put(EXPENSE_FORM_PURPOSE, new JSONString(expenseFormPurpose.getValue()));
        }
        if (name.getValue() != null) {
            entity.put(NAME, new JSONString(name.getValue()));
        }
        if (location.getValue() != null) {
            entity.put(LOCATION, new JSONString(location.getValue()));
        }
        if (startDate.getDate() != null) {
            entity.put(START_DATE, new JSONString(DateUtils.toDateString(startDate.getDate())));
        }
        if (endDate.getDate() != null) {
            entity.put(END_DATE, new JSONString(DateUtils.toDateString(endDate.getDate())));
        }
        if (projectName.getValue() != null) {
            entity.put(PROJECT_NAME, new JSONString(projectName.getValue()));
        }
        if (projectNumber.getValue() != null) {
            entity.put(PROJECT_NUMBER, new JSONString(projectNumber.getValue()));
        }
        if (expenseReimbursePaymentMode.getValue() != null) {
            entity.put(EXPENSE_REIMBURSE_PMT_MODE, new JSONString(expenseReimbursePaymentMode.getValue()));
        }
        JSONArray items = new JSONArray();
        int i = 0;
        for (UpdateExpenseItemPanel panel : updateItemPanels) {
            items.set(i, panel.populateEntityFromFields());
            i++;
        }
        entity.put(EXPENSE_ITEMS, items);
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
        if (entity.get(EXPENSE_FORM_PURPOSE) != null) {
            expenseFormPurpose.selectValue(entity.get(EXPENSE_FORM_PURPOSE).isString().stringValue());
        }
        if (entity.get(NAME) != null) {
            name.setValue(entity.get(NAME).isString().stringValue());
        }
        if (entity.get(LOCATION) != null) {
            location.setValue(entity.get(LOCATION).isString().stringValue());
        }
        if (entity.get(START_DATE) != null) {
            startDate.setValue(entity.get(START_DATE).isString().stringValue());
        }
        if (entity.get(END_DATE) != null) {
            endDate.setValue(entity.get(END_DATE).isString().stringValue());
        }
        if (entity.get(PROJECT_NAME) != null) {
            projectName.setValue(entity.get(PROJECT_NAME).isString().stringValue());
        }
        if (entity.get(PROJECT_NUMBER) != null) {
            projectNumber.setValue(entity.get(PROJECT_NUMBER).isString().stringValue());
        }
        if (entity.get(EXPENSE_REIMBURSE_PMT_MODE) != null) {
            expenseReimbursePaymentMode.selectValue(entity.get(EXPENSE_REIMBURSE_PMT_MODE).isString().stringValue());
        }
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
    }

    @Override
    protected void configure() {
        expenseFormPurpose.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        name.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        location.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        startDate.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        endDate.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        projectName.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        projectNumber.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        expenseReimbursePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        generalInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        expenseInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    }

    @Override
    protected void addWidgets() {
        expenseFormPurpose = new EnumField(OfficeWelcome.constants,
                EXPENSE_FORM_PURPOSE, EXPENSE_REPORT, false, true, ExpenseFormPurpose.names(), Alignment.HORIZONTAL);
        expenseReimbursePaymentMode = new EnumField(OfficeWelcome.constants,
                EXPENSE_REIMBURSE_PMT_MODE, EXPENSE_REPORT, false, true, ExpenseReimbursePaymentMode.names(), Alignment.HORIZONTAL);
        name = new StringField(OfficeWelcome.constants, NAME, EXPENSE_REPORT, false, true, Alignment.HORIZONTAL);
        location = new StringField(OfficeWelcome.constants, LOCATION, EXPENSE_REPORT, false, true, Alignment.HORIZONTAL);
        startDate = new DateField(OfficeWelcome.constants, START_DATE, EXPENSE_REPORT, false, true, Alignment.HORIZONTAL);
        endDate = new DateField(OfficeWelcome.constants, END_DATE, EXPENSE_REPORT, false, true, Alignment.HORIZONTAL);
        projectName = new StringField(OfficeWelcome.constants, PROJECT_NAME, EXPENSE_REPORT, false, false, Alignment.HORIZONTAL);
        projectNumber = new StringField(OfficeWelcome.constants, PROJECT_NUMBER, EXPENSE_REPORT, false, false, Alignment.HORIZONTAL);
        name.getElement().getStyle().setProperty("float", "left");
        startDate.getElement().getStyle().setProperty("float", "left");
        projectName.getElement().getStyle().setProperty("float", "left");
        entityFieldsPanel.add(expenseFormPurpose);
        entityFieldsPanel.add(generalInfo);
        entityFieldsPanel.add(name);
        entityFieldsPanel.add(location);
        entityFieldsPanel.add(startDate);
        entityFieldsPanel.add(endDate);
        entityFieldsPanel.add(projectName);
        entityFieldsPanel.add(projectNumber);
        entityFieldsPanel.add(expenseReimbursePaymentMode);
        entityFieldsPanel.add(expenseInfo);
        alignFields();
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expensereport/save";
    }
}
