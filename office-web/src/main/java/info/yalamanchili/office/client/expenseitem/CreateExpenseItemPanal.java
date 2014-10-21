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
import info.yalamanchili.office.client.expensecategory.ExpenseCategorySidePanel;
import info.yalamanchili.office.client.expensecategory.ReadAllExpenseCategoryPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class CreateExpenseItemPanal extends CreateComposite {

    private Logger logger = Logger.getLogger(CreateExpenseItemPanal.class.getName());

    public CreateExpenseItemPanal(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("ExpenseItem", OfficeWelcome.constants);
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
        addField("category", false, true, DataType.ENUM_FIELD);
        addField("description", false, false, DataType.STRING_FIELD);
        addField("amount", false, true, DataType.INTEGER_FIELD);
        addField("purpose", false, false, DataType.STRING_FIELD);
        addField("itemStartDate", false, true, DataType.DATE_FIELD);
        addField("itemEndDate", false, false, DataType.DATE_FIELD);
        addField("remarks", false, true, DataType.STRING_FIELD);
        addField("expenseReport", false, false, DataType.ENUM_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem";

    }
}
