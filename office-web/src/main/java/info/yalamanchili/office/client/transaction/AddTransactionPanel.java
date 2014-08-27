/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.transaction;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RadioButton;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.advancetranscation.TransactionStatus;
import info.yalamanchili.office.client.advancetranscation.TransactionType;
import info.yalamanchili.office.client.expense.bnkacct.CreateBankAcctWidget;
import info.yalamanchili.office.client.expense.check.CreateCheckWidget;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class AddTransactionPanel extends CreateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(AddTransactionPanel.class.getName());
    CreateCheckWidget createCheckWidget = new CreateCheckWidget(CreateCheckWidget.CreateCheckWidgetType.CHECK_MAILING_INFO);
    CreateBankAcctWidget createBankAccountWidget = new CreateBankAcctWidget();
    RadioButton passCheckInfo = new RadioButton("payment", "Add Check Information");
    RadioButton passBankAcctInfo = new RadioButton("payment", "Add Bank Account Information");

    protected String path;

    public AddTransactionPanel(String path) {
        super(CreateCompositeType.ADD);
        this.path = path;
        initCreateComposite("Transaction", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("paymentInfo", entity);
        assignEntityValueFromField("amount", entity);
        assignEntityValueFromField("postedDate", entity);
        assignEntityValueFromField("transactionType", entity);
        assignEntityValueFromField("transactionStatus", entity);
        if (passCheckInfo.getValue()) {
            entity.put("check", createCheckWidget.populateEntityFromFields());
        }
        if (passBankAcctInfo.getValue()) {
            entity.put("bankAccount", createBankAccountWidget.populateEntityFromFields());
        }
        logger.info("ddd" + entity);
        return entity;
    }

    @Override
    protected void addButtonClicked() {
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
    protected void createButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Transaction Successfully Created");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllTransactionPanel());
        TabPanel.instance().expensePanel.entityPanel.add(new TransactionOptionsWidget("advancerequisition/transaction/" + getEntityId()));
    }

    @Override
    protected void addListeners() {
        passBankAcctInfo.addClickHandler(this);
        passCheckInfo.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("paymentInfo", false, false, DataType.STRING_FIELD);
        addField("amount", false, true, DataType.CURRENCY_FIELD);
        addField("postedDate", false, false, DataType.DATE_FIELD);
        addEnumField("transactionType", false, true, TransactionType.names());
        addEnumField("transactionStatus", false, false, TransactionStatus.names());
        entityFieldsPanel.add(passBankAcctInfo);
        entityFieldsPanel.add(passCheckInfo);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + path;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(passBankAcctInfo)) {
            addBankAcctInformationWidget();
        } else if (event.getSource().equals(passCheckInfo)) {
            addCheckInformationWidget();
        } else {
            super.onClick(event);
        }
    }

    protected void addCheckInformationWidget() {
        if (createBankAccountWidget.isAttached()) {
            entityFieldsPanel.remove(createBankAccountWidget);
        }
        if (!createCheckWidget.isAttached()) {
            createCheckWidget = new CreateCheckWidget(CreateCheckWidget.CreateCheckWidgetType.CHECK_PAYMENT_INFO);
            entityFieldsPanel.add(createCheckWidget);
        }
    }

    protected void addBankAcctInformationWidget() {
        if (createCheckWidget.isAttached()) {
            entityFieldsPanel.remove(createCheckWidget);
        }
        if (!createBankAccountWidget.isAttached()) {
            createBankAccountWidget = new CreateBankAcctWidget();
            entityFieldsPanel.add(createBankAccountWidget);
        }
    }
}
