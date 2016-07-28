/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.transaction;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.advancetranscation.TransactionStatus;
import info.yalamanchili.office.client.advancetranscation.TransactionType;
import info.yalamanchili.office.client.expense.bnkacct.ReadBankAcctWidget;
import info.yalamanchili.office.client.expense.check.ReadCheckWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadTransactionPanel extends ReadComposite {

    private static ReadTransactionPanel instance;
    private static Logger logger = Logger.getLogger(ReadTransactionPanel.class.getName());

    public static ReadTransactionPanel instance() {
        return instance;
    }

    public ReadTransactionPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Transaction", OfficeWelcome.constants);
    }

    public ReadTransactionPanel(String id) {
        initReadComposite(id, "Transaction", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info("read ec6 response" + response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
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
            entityFieldsPanel.add(new ReadCheckWidget(ReadCheckWidget.ReadCheckWidgetType.CHECK_PAYMENT_INFO, entity.get("check").isObject()));
        }
        if (entity.containsKey("bankAccount")) {
            entityFieldsPanel.add(new ReadBankAcctWidget(entity.get("bankAccount").isObject()));
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("paymentInfo", true, false, DataType.STRING_FIELD);
        addField("amount", true, false, DataType.CURRENCY_FIELD);
        addField("postedDate", true, false, DataType.DATE_FIELD);
        addEnumField("transactionType", true, false, TransactionType.names());
        addEnumField("transactionStatus", true, false, TransactionStatus.names());
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "transaction";
    }
    
    @Override
    protected boolean enableBack() {
       return true;
    }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllTransactionPanel.instance;
    }
}
