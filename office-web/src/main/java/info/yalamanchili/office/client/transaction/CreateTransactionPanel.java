/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.transaction;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateTransactionPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateTransactionPanel.class.getName());

    public CreateTransactionPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Expenses", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("paymentInfo", entity);
        assignEntityValueFromField("amount", entity);
        assignEntityValueFromField("postedDate", entity);
        assignEntityValueFromField("transactionType", entity);
        assignEntityValueFromField("transactionStatus", entity);
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
        new ResponseStatusWidget().show("Transaction Successfully Created");
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
        addField("paymentInfo", false, true, DataType.STRING_FIELD);
        addField("amount", false, true, DataType.CURRENCY_FIELD);
        addField("postedDate", false, true, DataType.DATE_FIELD);
        String[] transactionType = {"CREDIT", "DEBIT", "OTHER"};
        addEnumField("transactionType", false, true, transactionType);
        String[] transactionStatus = {"SAVED", "PENDING", "APPROVED", "COMPLETE", "CANCELED"};
        addEnumField("transactionStatus", false, true, transactionStatus);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "transaction";
    }
}
