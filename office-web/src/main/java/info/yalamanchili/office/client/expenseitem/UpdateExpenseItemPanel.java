/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expenseitem;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;
import info.yalamanchili.office.client.expensereports.SelectExpenseReportsWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class UpdateExpenseItemPanel extends UpdateComposite {

    private Logger logger = Logger.getLogger(UpdateExpenseItemPanel.class.getName());

    public UpdateExpenseItemPanel(JSONObject entity) {
        initUpdateComposite(entity, "ExpenseItem", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject ExpenseItem = new JSONObject();
        assignEntityValueFromField("category", ExpenseItem);
        assignEntityValueFromField("description", ExpenseItem);
        assignEntityValueFromField("amount", ExpenseItem);
        assignEntityValueFromField("purpose", ExpenseItem);
        assignEntityValueFromField("itemStartDate", ExpenseItem);
        assignEntityValueFromField("itemEndDate", ExpenseItem);
        assignEntityValueFromField("remarks", ExpenseItem);
        assignEntityValueFromField("expenseReport", ExpenseItem);
        logger.info(ExpenseItem.toString());
        return ExpenseItem;
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
        assignFieldValueFromEntity("expenseReport", entity, null);
        assignFieldValueFromEntity("category", entity, null);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("purpose", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("itemStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("itemEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("remarks", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee ExpenseItem Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllEpenseItemPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("category", new SelectExpenseCategoryWidget(false, true));
        addDropDown("expenseReport", new SelectExpenseReportsWidget(false, true));
        addField("description", false, false, DataType.STRING_FIELD);
        addField("amount", false, true, DataType.INTEGER_FIELD);
        addField("purpose", false, false, DataType.STRING_FIELD);
        addField("itemStartDate", false, true, DataType.DATE_FIELD);
        addField("itemEndDate", false, false, DataType.DATE_FIELD);
        addField("remarks", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem";
    }
}
