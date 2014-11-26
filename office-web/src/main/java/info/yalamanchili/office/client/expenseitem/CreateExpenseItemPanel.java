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
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class CreateExpenseItemPanel extends CreateComposite {
    
    private Logger logger = Logger.getLogger(CreateExpenseItemPanel.class.getName());
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, false);
    
    public CreateExpenseItemPanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("ExpenseItem", OfficeWelcome.constants);
    }
    
    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        entity.put("category", selectCategoryWidgetF.getSelectedObject());
        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("amount", entity);
        assignEntityValueFromField("itemStartDate", entity);
        assignEntityValueFromField("itemEndDate", entity);
        assignEntityValueFromField("purpose", entity);
        assignEntityValueFromField("remarks", entity);
        logger.info(entity.toString());
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
        create.setVisible(false);
    }
    
    @Override
    protected void addWidgets() {
        addDropDown("category", selectCategoryWidgetF);
        addField("description", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
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
