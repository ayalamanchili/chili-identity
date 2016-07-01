/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import java.util.logging.Logger;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.contracts.ReadContractsPanel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bhavana.Atluri
 */
public class SubmitInvoicePanel extends CreateComposite {

    private Logger logger = Logger.getLogger(UpdateInvoicePanel.class.getName());

    protected static SubmitInvoicePanel instance;
    protected String id;

    public SubmitInvoicePanel(String id, CreateCompositeType type) {
        super(type); // to add Invoice Sent date field
        this.id = id;
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
        logger.info("entity details:" + entity.toString());

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
        TabPanel.instance().reportingPanel.entityPanel.clear();
        GenericPopup.instance().hide();
        TabPanel.instance().reportingPanel.entityPanel.add(new ReadContractsPanel(id));
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
