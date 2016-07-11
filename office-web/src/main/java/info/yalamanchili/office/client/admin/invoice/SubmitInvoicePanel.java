/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import java.util.logging.Logger;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author Bhavana.Atluri
 */
public class SubmitInvoicePanel extends CreateComposite {

    private Logger logger = Logger.getLogger(UpdateInvoicePanel.class.getName());

    protected static SubmitInvoicePanel instance;
    protected String id;
    protected String clientInfoId;

    public SubmitInvoicePanel(String id, String clientInfoId, CreateCompositeType type) {
        super(type); // to add Invoice Sent date field
        this.id = id;
        this.clientInfoId = clientInfoId;
        instance = this;
        initCreateComposite("Invoice", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("invoiceSentDate", entity);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        // TODO Auto-generated method stub
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Submitted Invoice Information");
        ReadAllInvoicePanel.instance.refresh();
        GenericPopup.instance().hide();
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
    }

    @Override
    protected void addWidgets() {
        addField("invoiceSentDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "invoice/submit-invoice/" + id;
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        DateField sentDate = (DateField) fields.get("invoiceSentDate");
        if (sentDate.getDate() == null) {
            sentDate.setMessage("Sent date can not be null");
            return false;
        }
        return true;
    }
}
