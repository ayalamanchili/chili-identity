/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author Madhu.Badiginchala
 */
public class UpdateImmigrationCheckItemPanel extends UpdateComposite {
    
    UpdateImmigrationCheckRequisitionPanel parentPanel;
    ClickableLink deleteB = new ClickableLink("Remove Item");
    
    public UpdateImmigrationCheckItemPanel(UpdateImmigrationCheckRequisitionPanel parent, JSONObject entity) {
        this.parentPanel = parent;
        initUpdateComposite(entity, "ExpenseItem", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();        
        assignEntityValueFromField("itemName", entity);
        assignEntityValueFromField("itemDesc", entity);
        assignEntityValueFromField("amount", entity);        
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
        assignFieldValueFromEntity("itemName", entity, DataType.STRING_FIELD );
        assignFieldValueFromEntity("itemDesc", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Immigration Check Item");
        TabPanel.instance().expensePanel.entityPanel.clear();
//        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllImmigrationCheckRequisitionItems());
    }

    @Override
    protected void addListeners() {
        deleteB.addClickHandler(this);
    }

    @Override
    protected void configure() {
       update.setVisible(false);
    }

    @Override
    protected void addWidgets() {
        addField("itemName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("itemDesc", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("amount", false, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        alignFields();
        entityActionsPanel.add(deleteB);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
//        return OfficeWelcome.constants.root_url() + "checkrequisition";
    }

    @Override
    protected String getURI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
