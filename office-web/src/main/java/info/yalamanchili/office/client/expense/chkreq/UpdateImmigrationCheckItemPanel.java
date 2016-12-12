/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.chkreq;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class UpdateImmigrationCheckItemPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateImmigrationCheckItemPanel.class.getName());
    ClickableLink deleteB = new ClickableLink("Remove Item");
    protected String parentId;

    public UpdateImmigrationCheckItemPanel(String parentId, JSONObject entity) {
        this.parentId = parentId;
        initUpdateComposite(entity, "CheckRequisitionItem", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
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
        assignFieldValueFromEntity("itemName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("itemDesc", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Immigration Check Item");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllImmigrationCheckRequisitionItems());
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
        addField("amount", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        alignFields();
        entityActionsPanel.add(deleteB);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return "";
    }

    protected String getDeleteURI() {
        return OfficeWelcome.constants.root_url() + "check-requisition-item/delete/" + getEntityId();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(deleteB)) {
            if (getEntityId() == null || getEntityId().isEmpty()) {
                this.removeFromParent();
                UpdateImmigrationCheckRequisitionPanel.instance().updateItemPanels.remove(this);
            } else {
                if (Window.confirm("Are you sure to delete the Check Item?")) {
                    HttpService.HttpServiceAsync.instance().doPut(getDeleteURI(), entity.toString(),
                            OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {

                                @Override
                                public void onResponse(String arg0) {
                                    new ResponseStatusWidget().show("Successfully Deleted Check Information");
                                    TabPanel.instance().expensePanel.entityPanel.clear();
                                    TabPanel.instance().expensePanel.entityPanel.add(new UpdateImmigrationCheckRequisitionPanel(parentId));
                                }
                            });
                }
            }
        }
        super.onClick(event);
    }

}
