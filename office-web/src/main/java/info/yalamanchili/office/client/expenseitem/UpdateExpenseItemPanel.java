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
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;

/**
 *
 * @author Prasanthi.p
 */
public class UpdateExpenseItemPanel extends UpdateComposite {

    public UpdateExpenseItemPanel(JSONObject entity) {
        initUpdateComposite(entity, "ExpenseItem", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        assignEntityValueFromField("category", entity);
        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("amount", entity);
        assignEntityValueFromField("itemStartDate", entity);
        assignEntityValueFromField("itemEndDate", entity);
        assignEntityValueFromField("purpose", entity);
        assignEntityValueFromField("remarks", entity);
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
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("category", entity, null);
        assignFieldValueFromEntity("description", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("itemStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("itemEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("purpose", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("remarks", entity, DataType.TEXT_AREA_FIELD);
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
        update.setVisible(false);
    }

    @Override
    protected void addWidgets() {
        addDropDown("category", new SelectExpenseCategoryWidget(false, false));
        addField("description", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("amount", false, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("itemStartDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("itemEndDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("purpose", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("remarks", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem";
    }
}
