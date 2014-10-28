/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expenseitem.SelectExpenseItemWidget;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class CreateExpenseReportsPanel extends CreateComposite {

    private Logger logger = Logger.getLogger(CreateExpenseReportsPanel.class.getName());
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);
    SelectExpenseItemWidget selectExpenseItemWidgetF = new SelectExpenseItemWidget(false, true);

    public CreateExpenseReportsPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("ExpenseReports", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject Expensereports = new JSONObject();
        entity.put("employee", selectEmployeeWidgetF.getSelectedObject());
        entity.put("expenseItems", selectExpenseItemWidgetF.getSelectedObject());
        assignEntityValueFromField("name", Expensereports);
        assignEntityValueFromField("description", Expensereports);
        assignEntityValueFromField("startDate", Expensereports);
        assignEntityValueFromField("endDate", Expensereports);
        assignEntityValueFromField("submittedDate", Expensereports);
        assignEntityValueFromField("department", Expensereports);
        assignEntityValueFromField("paidDate", Expensereports);
        logger.info(Expensereports.toString());
        return Expensereports;
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully ExpenseReports Created");
        TabPanel.instance().expensePanel.sidePanelTop.clear();
        TabPanel.instance().expensePanel.sidePanelTop.add(new ExpenseReportsSidePanel());
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllExpenseReportsPanel());
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
        addDropDown("expenseItems", selectExpenseItemWidgetF);
        addField("name", false, false, DataType.ENUM_FIELD);
        addField("description", false, false, DataType.STRING_FIELD);
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("submittedDate", false, false, DataType.DATE_FIELD);
        addField("department", false, false, DataType.STRING_FIELD);
        addField("paidDate", false, false, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expensereport";

    }
}
