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
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Sadipan.B
 */
public class CreateImmigrationCheckItemPanel extends CreateComposite implements ClickHandler {

    private Logger logger = Logger.getLogger(CreateImmigrationCheckItemPanel.class.getName());
    CreateImmigrationCheckRequisitionPanel parentPanel;
    ClickableLink deleteB = new ClickableLink("Remove Item");

    public CreateImmigrationCheckItemPanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("CheckRequisitionItem", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("itemName", entity);
        assignEntityValueFromField("itemDesc", entity);
        assignEntityValueFromField("amount", entity);
        return entity;
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
    protected void createButtonClicked() {
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
    }

    @Override
    protected void addListeners() {
        deleteB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        create.setVisible(false);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return null;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(deleteB)) {
            this.removeFromParent();
            CreateImmigrationCheckRequisitionPanel.instance().checkItemPanels.remove(this);
            if (entityId != null) {
                HttpService.HttpServiceAsync.instance().doPut(getDeleteURI(), entity.toString(),
                        OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String arg0) {
                                new ResponseStatusWidget().show("Successfully Deleted Employee ExpenseItem Information");
                            }
                        });
            }
        }
        super.onClick(event);
    }

    protected String getDeleteURI() {
        return OfficeWelcome.constants.root_url() + "checkrequisition/delete/" + getEntityId();
    }
}
