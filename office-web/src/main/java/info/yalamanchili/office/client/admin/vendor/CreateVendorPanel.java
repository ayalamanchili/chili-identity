/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class CreateVendorPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.admin.vendor.CreateVendorPanel.class.getName());

    public CreateVendorPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Vendors", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject vendor = new JSONObject();
        assignEntityValueFromField("name", vendor);
        assignEntityValueFromField("description", vendor);
        assignEntityValueFromField("vendorType", vendor);
        assignEntityValueFromField("website", vendor);
        assignEntityValueFromField("paymentTerms", vendor);
        assignEntityValueFromField("vendorinvFrequency", vendor);
        assignEntityValueFromField("vendorFees", vendor);
        assignEntityValueFromField("vendorinvDeliveryMethod", vendor);
        logger.info(vendor.toString());
        return vendor;
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
        if (GenericPopup.instance() != null) {
            GenericPopup.instance().hide();
        }
        new ResponseStatusWidget().show("Successfully Vendor Created");
        String id = JSONUtils.toString(JSONParser.parseLenient(result), "id");
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeVendorsPanel(id, entity));
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorsPanel(id));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("description", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("vendorType", false, false, VendorType.names(), Alignment.HORIZONTAL);
        addField("vendorFees", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("website", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("paymentTerms", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("vendorinvFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("vendorinvDeliveryMethod", false, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "vendor";
    }
}
