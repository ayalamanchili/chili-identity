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
import info.chili.gwt.crud.CreateComposite;
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
public class CreateExpenseItemPanal extends CreateComposite {

    private Logger logger = Logger.getLogger(CreateExpenseItemPanal.class.getName());
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);
    SelectExpenseReportsWidget selectExpenseReportsWidgetF = new SelectExpenseReportsWidget(false, true);

    public CreateExpenseItemPanal(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("ExpenseItem", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject ExpenseItem = new JSONObject();
        entity.put("category", selectCategoryWidgetF.getSelectedObject());
        entity.put("expenseReport", selectExpenseReportsWidgetF.getSelectedObject());
        assignEntityValueFromField("description", ExpenseItem);
        assignEntityValueFromField("amount", ExpenseItem);
        assignEntityValueFromField("itemStartDate", ExpenseItem);
        assignEntityValueFromField("itemEndDate", ExpenseItem);
        assignEntityValueFromField("purpose", ExpenseItem);
        assignEntityValueFromField("remarks", ExpenseItem);
        logger.info(ExpenseItem.toString());
        return ExpenseItem;
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
        new ResponseStatusWidget().show("Successfully ExpenseItem Created");
        TabPanel.instance().expensePanel.sidePanelTop.clear();
        TabPanel.instance().expensePanel.sidePanelTop.add(new ExpenseItemSidePanel());
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
        addDropDown("category", selectCategoryWidgetF);
        addDropDown("expenseReport", selectExpenseReportsWidgetF);
        addField("description", false, false, DataType.STRING_FIELD);
        addField("amount", false, true, DataType.INTEGER_FIELD);
        addField("itemStartDate", false, true, DataType.DATE_FIELD);
        addField("itemEndDate", false, false, DataType.DATE_FIELD);
        addField("purpose", false, false, DataType.RICH_TEXT_AREA);
        addField("remarks", false, true, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem";

    }
}
