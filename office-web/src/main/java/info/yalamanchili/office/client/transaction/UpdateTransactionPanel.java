/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.transaction;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.advancetranscation.TransactionStatus;
import info.yalamanchili.office.client.advancetranscation.TransactionType;
import info.yalamanchili.office.client.expense.bnkacct.UpdateBankAcctWidget;
import info.yalamanchili.office.client.expense.check.UpdateCheckWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateTransactionPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateTransactionPanel.class.getName());
    
    UpdateCheckWidget updateCheckWidget;
    UpdateBankAcctWidget updateBankAcctWidget;

    public UpdateTransactionPanel(JSONObject entity) {
        initUpdateComposite(entity, "Transaction", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("paymentInfo", entity);
        assignEntityValueFromField("amount", entity);
        assignEntityValueFromField("postedDate", entity);
        assignEntityValueFromField("transactionType", entity);
        assignEntityValueFromField("transactionStatus", entity);
        if (updateCheckWidget != null) {
            entity.put("check", updateCheckWidget.populateEntityFromFields());
        }
        if (updateBankAcctWidget != null) {
            entity.put("bankAccount", updateBankAcctWidget.populateEntityFromFields());
        }
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
        assignFieldValueFromEntity("paymentInfo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("postedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("transactionType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("transactionStatus", entity, DataType.ENUM_FIELD);
        if (entity.containsKey("check")) {
            updateCheckWidget = new UpdateCheckWidget(UpdateCheckWidget.UpdateCheckWidgetType.CHECK_PAYMENT_INFO,entity.get("check").isObject());
            entityFieldsPanel.add(updateCheckWidget);
        }
        if (entity.containsKey("bankAccount")) {
            updateBankAcctWidget = new UpdateBankAcctWidget(entity.get("bankAccount").isObject());
            entityFieldsPanel.add(updateBankAcctWidget);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated Transaction Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllTransactionPanel());
    }

    @Override
    protected void addListeners() {
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
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "transaction";
    }
}
