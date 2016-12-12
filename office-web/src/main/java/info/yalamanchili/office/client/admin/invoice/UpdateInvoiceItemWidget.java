/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.TCRUDComposite;
import info.chili.gwt.crud.TUpdateComposite;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.contracts.ReadContractsPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateInvoiceItemWidget extends TUpdateComposite implements ChangeHandler {

    private Logger logger = Logger.getLogger(UpdateInvoiceItemWidget.class.getName());
    ClickableLink deleteB = new ClickableLink("Remove Item");

    protected static UpdateInvoiceItemWidget instance;
    protected String id;
    private int index;
    protected UpdateInvoicesPanel parentPanel;
    protected boolean isUpdate;
    protected JSONObject invoice;
    protected String clientInfoId;
    DateField startDate;

    public List<TCRUDComposite> updateItemPanels = new ArrayList<>();

    public static UpdateInvoiceItemWidget instance() {
        return instance;
    }
 
    public UpdateInvoiceItemWidget(UpdateInvoicesPanel parentPanel, String id, boolean isUpdate, int idx) {
        this.id = id;
        instance = this;
        this.isUpdate = isUpdate;
        this.parentPanel = parentPanel;
        this.index = idx;
        initUpdateComposite(id, "Invoice", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("invoiceNumber", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("billingRate", entity);
        assignEntityValueFromField("overTimeBillingRate", entity);
        assignEntityValueFromField("hours", entity);
        assignEntityValueFromField("invoiceStatus", entity);
        assignEntityValueFromField("timeSheetStatus", entity);
        assignEntityValueFromField("notes", entity);
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
        if (entity.containsKey("clientInformation")) {
            JSONObject clientInformation = entity.get("clientInformation").isObject();
            assignFieldValueFromEntity("billingRate", clientInformation, DataType.CURRENCY_FIELD);
        } else {
            assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
        }
        if (isUpdate) {
            assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
            assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        }
        assignFieldValueFromEntity("invoiceNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("hours", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("invoiceStatus", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("timeSheetStatus", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
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
        deleteB.addClickHandler(this);
        startDate.getDatePicker().addChangeHandler(this);
    }

    @Override
    protected void configure() {
        update.setVisible(false);
        configureLabelNames();
    }

    protected void configureLabel(Label l) {
        l.removeStyleName("tfFieldHeader");
        l.setVisible(true);
    }

    @Override
    protected void addWidgets() {
        addField("invoiceNumber", false, true, DataType.STRING_FIELD, Alignment.VERTICAL, 1, 1);
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.VERTICAL, 1, 2);
        startDate = (DateField) fields.get("startDate");
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.VERTICAL, 1, 3);
        addField("billingRate", false, true, DataType.CURRENCY_FIELD, Alignment.VERTICAL, 1, 4);
        addField("overTimeBillingRate", false, false, DataType.CURRENCY_FIELD, Alignment.VERTICAL, 1, 5);
        addField("hours", false, true, DataType.CURRENCY_FIELD, Alignment.VERTICAL, 2, 1);
        if (isUpdate) {
            addEnumField("invoiceStatus", false, true, InvoiceStatus.names(), Alignment.VERTICAL, 2, 2);
        } else {
            addEnumField("invoiceStatus", false, true, InvoiceStatus.getValues(), Alignment.VERTICAL, 2, 2);
        }
        addEnumField("timeSheetStatus", false, true, TimeStatus.names(), Alignment.VERTICAL, 2, 3);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD, Alignment.VERTICAL, 2, 4);
        entityFieldsPanel.setWidget(2, 5, deleteB);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (isUpdate == true) {
            return OfficeWelcome.constants.root_url() + "invoice/update-Invoice/" + invoice.get("id").isString().stringValue();
        } else {
            return OfficeWelcome.constants.root_url() + "invoice/save/" + id;
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

    protected String getEffectiveBillingRateURI() {
        DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
        return OfficeWelcome.constants.root_url() + "contract/load-invoice-billingRate/" + id + "?startDate=" + sdf.format(startDate.getDate());
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (startDate.getDate() != null) {
            HttpService.HttpServiceAsync.instance().doGet(getEffectiveBillingRateURI(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String response) {
                            JSONObject billingRate = new JSONObject();
                            billingRate.put("billingRate", new JSONString(response));
                            assignFieldValueFromEntity("billingRate", billingRate, DataType.CURRENCY_FIELD);
                        }
                    });
        }
    }

    @Override
    public void onClick(ClickEvent event) {
         if (event.getSource().equals(deleteB)) {
            parentPanel.removePanel(index);
        }
        super.onClick(event);
    }

    protected String getDeleteURI() {
        return OfficeWelcome.constants.root_url() + "invoice/delete/" + getEntityId();
    }

    private void configureLabelNames() {
        StringField invoiceNumber = (StringField) fields.get("invoiceNumber");
        configureLabel(invoiceNumber.getLabel());
        DateField startDateF = (DateField) fields.get("startDate");
        configureLabel(startDateF.getLabel());
        DateField endDate = (DateField) fields.get("endDate");
        configureLabel(endDate.getLabel());
        CurrencyField billingRate = (CurrencyField) fields.get("billingRate");
        configureLabel(billingRate.getLabel());
        CurrencyField overTimeBillingRate = (CurrencyField) fields.get("overTimeBillingRate");
        configureLabel(overTimeBillingRate.getLabel());
        CurrencyField hours = (CurrencyField) fields.get("hours");
        configureLabel(hours.getLabel());
        EnumField invoiceStatus = (EnumField) fields.get("invoiceStatus");
        configureLabel(invoiceStatus.getLabel());
        EnumField timeSheetStatus = (EnumField) fields.get("timeSheetStatus");
        configureLabel(timeSheetStatus.getLabel());
        TextAreaField notes = (TextAreaField) fields.get("notes");
        configureLabel(notes.getLabel());
    }
}
