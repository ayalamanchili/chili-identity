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
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import info.chili.gwt.crud.CRUDComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expenseitem.CreateExpenseItemPanel;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class CreateExpenseReportPanel extends CreateComposite {

    private Logger logger = Logger.getLogger(CreateExpenseReportPanel.class.getName());
    protected ClickableLink addItemL = new ClickableLink("Add Expense Item");
    protected ClickableLink removeItemL = new ClickableLink("Remove Expense Item");
    protected List<CreateExpenseItemPanel> expenseItemPanels = new ArrayList<>();

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

    public CreateExpenseReportPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("ExpenseReport", OfficeWelcome.constants);
    }

    EnumField expenseFormPurpose;
    StringField name;
    StringField location;
    DateField startDate;
    DateField endDate;
    StringField projectName;
    StringField projectNumber;
    EnumField expenseReimbursePaymentMode;

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected void addWidgets() {
        expenseFormPurpose = new EnumField(OfficeWelcome.constants,
                EXPENSE_FORM_PURPOSE, TRAVEL_EXPENSE, false, true, ExpenseFormPurpose.names(), Alignment.HORIZONTAL);
        expenseReimbursePaymentMode = new EnumField(OfficeWelcome.constants,
                EXPENSE_REIMBURSE_PMT_MODE, TRAVEL_EXPENSE, false, true, ExpenseReimbursePaymentMode.names(), Alignment.HORIZONTAL);
        name = new StringField(OfficeWelcome.constants, NAME, TRAVEL_EXPENSE, false, true, Alignment.HORIZONTAL);
        location = new StringField(OfficeWelcome.constants, LOCATION, TRAVEL_EXPENSE, false, true, Alignment.HORIZONTAL);
        startDate = new DateField(OfficeWelcome.constants, START_DATE, TRAVEL_EXPENSE, false, true, Alignment.HORIZONTAL);
        endDate = new DateField(OfficeWelcome.constants, END_DATE, TRAVEL_EXPENSE, false, true, Alignment.HORIZONTAL);
        projectName = new StringField(OfficeWelcome.constants, PROJECT_NAME, TRAVEL_EXPENSE, false, false, Alignment.HORIZONTAL);
        projectNumber = new StringField(OfficeWelcome.constants, PROJECT_NUMBER, TRAVEL_EXPENSE, false, false, Alignment.HORIZONTAL);
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
        entityFieldsPanel.add(addItemL);
//        entityFieldsPanel.add(removeItemL);
        alignFields();
    }

    @Override
    protected void configure() {
        expenseFormPurpose.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        name.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        location.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        startDate.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        endDate.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        projectName.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        projectNumber.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        expenseReimbursePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        generalInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        expenseInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        addItemL.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        removeItemL.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        setButtonText("Submit");
    }

    @Override
    protected void addListeners() {
        addItemL.addClickHandler(this);
        removeItemL.addClickHandler(this);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
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
        if (expenseItemPanels.size() > 0) {
            JSONArray items = new JSONArray();
            int i = 0;
            for (CreateExpenseItemPanel panel : expenseItemPanels) {
                items.set(i, panel.populateEntityFromFields());
                i++;
            }
            entity.put(EXPENSE_ITEMS, items);
        }
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
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addItemL)) {
            CreateExpenseItemPanel panel = new CreateExpenseItemPanel();
            expenseItemPanels.add(panel);
            entityFieldsPanel.add(panel);
        }
//        if (event.getSource().equals(removeItemL)) {
//            if (expenseItemPanels.size() > 0) {
//                int i = expenseItemPanels.size();
//                expenseItemPanels.remove(i);
//            }
//                
//            }
//        }
        super.onClick(event);
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Expense Form Successfully Created");
        TabPanel.instance().expensePanel.sidePanelTop.clear();
        TabPanel.instance().expensePanel.sidePanelTop.add(new ExpenseReportsSidePanel());
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllExpenseReportsPanel());
    }

    @Override
    protected CRUDComposite getChildWidget(int childIndexWidget) {
        return expenseItemPanels.get(childIndexWidget);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expensereport/save";

    }
}
