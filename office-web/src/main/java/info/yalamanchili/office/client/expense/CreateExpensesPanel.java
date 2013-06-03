/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateExpensesPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateExpensesPanel.class.getName());
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget(false, true);

    public CreateExpensesPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Expenses", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("amount", entity);
        assignEntityValueFromField("expenseDate", entity);
        entity.put("category", selectCategoryWidgetF.getSelectedObject());
        entity.put("employee", selectEmployeeWidgetF.getSelectedObject());
        logger.info("ddd" + entity);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
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
        new ResponseStatusWidget().show("Expense Successfully Created");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllExpensesPanel());
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
        addField("name", false, true, DataType.STRING_FIELD);
        addField("amount", false, true, DataType.CURRENCY_FIELD);
        addDropDown("category", selectCategoryWidgetF);
        addField("expenseDate", false, true, DataType.DATE_FIELD);
        addField("description", false, false, DataType.TEXT_AREA_FIELD);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expense";
    }
}
