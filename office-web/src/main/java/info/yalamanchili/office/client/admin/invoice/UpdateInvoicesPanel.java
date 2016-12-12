/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.crud.TUpdateComposite;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.contracts.ReadContractsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateInvoicesPanel extends UpdateComposite implements ChangeHandler {

    private Logger logger = Logger.getLogger(UpdateInvoicePanel.class.getName());
    protected ClickableLink addItemL = new ClickableLink("Add Invoice Item");
    protected List<UpdateInvoiceItemWidget> updateInvoiceItemPanel = new ArrayList<>();

    protected static UpdateInvoicesPanel instance;
    protected String id;
    protected boolean isUpdate;
    protected JSONObject invoice;
    protected String clientInfoId;

    public static UpdateInvoicesPanel instance() {
        return instance;
    }

    public UpdateInvoicesPanel(String id) {
        instance = this;
        initUpdateComposite(id, "Invoice", OfficeWelcome.constants2);
    }

    public UpdateInvoicesPanel(String id, boolean isUpdate) {
        this.id = id;
        instance = this;
        this.isUpdate = isUpdate;
        initUpdateComposite(id, "Invoice", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("itemNumber", entity);
        assignEntityValueFromField("invoiceFrequency", entity);
        JSONArray items = new JSONArray();
        int i = 0;
        for (TUpdateComposite panel : updateInvoiceItemPanel) {
            if (panel instanceof UpdateInvoiceItemWidget) {
                UpdateInvoiceItemWidget updatePanel = (UpdateInvoiceItemWidget) panel;
                items.set(i, updatePanel.populateEntityFromFields());
                i++;
            }
        }
        entity.put("invoiceItems", items);
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
        assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Invoice Information");
        TabPanel.instance().reportingPanel.entityPanel.clear();
        GenericPopup.instance().hide();
        TabPanel.instance().reportingPanel.entityPanel.add(new ReadContractsPanel(id));
    }

    @Override
    protected void addListeners() {
        addItemL.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("itemNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("invoiceFrequency", true, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        UpdateInvoiceItemWidget itemPanel = null;
        int i = updateInvoiceItemPanel.size();
        itemPanel = new UpdateInvoiceItemWidget(this, id, isUpdate, i);
        updateInvoiceItemPanel.add(itemPanel);
        entityFieldsPanel.add(itemPanel);
        entityFieldsPanel.add(addItemL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (isUpdate == true) {
            return OfficeWelcome.constants.root_url() + "invoice/update-Invoice/" + invoice.get("id").isString().stringValue();
        } else {
            return OfficeWelcome.constants.root_url() + "invoice/update-multiple-Invoice/" + id;
        }
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject entity1 = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity1);
                    }
                });
    }

    protected String getReadURI() {
        if (isUpdate == false) {
            return OfficeWelcome.constants.root_url() + "clientinformation/invoice/read/" + id;
        } else {
            return OfficeWelcome.constants.root_url() + "invoice/read/" + invoice.get("id").isString().stringValue();
        }
    }

    @Override
    public void onChange(ChangeEvent event) {

    }

    @Override
    protected Map<String, BaseField> getChildWidget(int childIndexWidget) {
        return updateInvoiceItemPanel.get(childIndexWidget).fields;
    }

    public void removePanel(int i) {
        if (updateInvoiceItemPanel.size() > 0) {
            updateInvoiceItemPanel.get(i).removeFromParent();
            updateInvoiceItemPanel.remove(i);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addItemL)) {
            UpdateInvoiceItemWidget itemPanel = null;
            int i = updateInvoiceItemPanel.size();
            itemPanel = new UpdateInvoiceItemWidget(this, id, isUpdate, i);
            updateInvoiceItemPanel.add(itemPanel);
            entityFieldsPanel.insert(itemPanel, entityFieldsPanel.getWidgetIndex(addItemL));
        }
        if (event.getSource().equals(update)) {
            super.onClick(event);
        }
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        List<String> invNumList = new ArrayList();
        for (int i = 0; i < updateInvoiceItemPanel.size(); i++) {
            UpdateInvoiceItemWidget get = updateInvoiceItemPanel.get(i);
            JSONObject item = get.populateEntityFromFields();
            if (item.containsKey("invoiceNumber")) {
                invNumList.add(item.get("invoiceNumber").isString().stringValue());
            }
        }
        final Set<String> dupInvSet = new HashSet();
        final Set<String> InvSet = new HashSet();
        for (String yourInt : invNumList) {
            if (!InvSet.add(yourInt)) {
                dupInvSet.add(yourInt);
            }
        }
        if (dupInvSet.size() > 0) {
            Window.alert("Invoice Number must be unique");
            return false;
        }
        return valid;
    }

}
