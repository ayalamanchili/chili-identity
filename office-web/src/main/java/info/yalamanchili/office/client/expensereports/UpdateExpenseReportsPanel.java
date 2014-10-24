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
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expenseitem.SelectExpenseItemWidget;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;

/**
 *
 * @author Prasanthi.p
 */
public class UpdateExpenseReportsPanel extends UpdateComposite {

    public UpdateExpenseReportsPanel(JSONObject entity) {
        initUpdateComposite(entity, "ExpenseReports", OfficeWelcome.constants);
    }
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);
    SelectExpenseItemWidget selectExpenseItemWidgetF = new SelectExpenseItemWidget(false, true);

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
        return Expensereports;
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
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("expenseItems", entity, null);
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("submittedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("department", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("paidDate", entity, DataType.DATE_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee ExpenseCategory Information");
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
        addField("name", false, true, DataType.ENUM_FIELD);
        addField("description", false, false, DataType.STRING_FIELD);
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, false, DataType.DATE_FIELD);
        addField("submittedDate", false, true, DataType.DATE_FIELD);
        addField("department", false, false, DataType.STRING_FIELD);
        addField("paidDate", false, true, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expensereport";
    }
}
