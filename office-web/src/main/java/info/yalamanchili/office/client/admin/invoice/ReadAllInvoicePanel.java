/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Widget;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.contracts.ReadContractsPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllInvoicePanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllInvoicePanel.class.getName());
    public static ReadAllInvoicePanel instance;
    protected String clientInfoId;
    protected boolean displayALL = false;

    public ReadAllInvoicePanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Invoice", OfficeWelcome.constants2);
    }

    public ReadAllInvoicePanel(boolean displayAll) {
        instance = this;
        this.displayALL = displayAll;
        initTable("Invoice", OfficeWelcome.constants2);
    }
    static JSONObject invoice;
    static JSONArray invoices;

    public ReadAllInvoicePanel(JSONObject invoice) {
        instance = this;
        this.invoice = invoice;
        initTable("Invoice", OfficeWelcome.constants2);
    }

    public ReadAllInvoicePanel(JSONObject invoice, String clientInfoId) {
        instance = this;
        this.clientInfoId = clientInfoId;
        this.invoice = invoice;
        initTable("Invoice", OfficeWelcome.constants2);
    }

    public ReadAllInvoicePanel(JSONArray invoices, String clientInfoId) {
        instance = this;
        this.clientInfoId = clientInfoId;
        this.invoices = invoices;
        initTable("Invoice", invoices, OfficeWelcome.constants2);
    }

    public ReadAllInvoicePanel(JSONArray array) {
        instance = this;
        displayALL = true;
        initTable("Invoice", array, OfficeWelcome.constants2);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().reportingPanel.entityPanel.clear();
        TabPanel.instance().reportingPanel.entityPanel.add(new ReadInvoicePanel(entityId));
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                postDeleteSuccess();
            }
        });
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "invoice/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Invoice Information");
        TabPanel.instance().reportingPanel.entityPanel.clear();
        TabPanel.instance().reportingPanel.entityPanel.add(new ReadContractsPanel(clientInfoId));
    }

    @Override
    public void updateClicked(String entityId) {
        new GenericPopup(new UpdateInvoicePanel(clientInfoId, getEntity(entityId), true)).show();
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getInvocieURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                postFetchTable(result);
            }
        });
    }

    private String getInvocieURL(Integer start, String limit) {
        if (displayALL == false) {
            return OfficeWelcome.constants.root_url() + "invoice/" + clientInfoId + "/" + start.toString() + "/" + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "invoice/" + start.toString() + "/" + limit.toString();
        }
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("ItemNumber"));
        table.setText(0, 3, getKeyValue("Inv. Number"));
        table.setText(0, 4, getKeyValue("StartDate"));
        table.setText(0, 5, getKeyValue("EndDate"));
        table.setText(0, 6, getKeyValue("Hours"));
        table.setText(0, 7, getKeyValue("Bill Rate"));
        table.setText(0, 8, getKeyValue("O.T. Bill Rate"));
        table.setText(0, 9, getKeyValue("Invoice Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject clientInformation = entity.get("clientInformation").isObject();
            JSONObject employee = clientInformation.get("employee").isObject();
            table.setText(i, 1, JSONUtils.toString(employee, "firstName") + " " + JSONUtils.toString(employee, "lastName"));
            table.setText(i, 2, JSONUtils.toString(entity, "itemNumber"));
            table.setText(i, 3, JSONUtils.toString(entity, "invoiceNumber"));
            table.setText(i, 4, getFormattedDate(DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT)));
            table.setText(i, 5, getFormattedDate(DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT)));
            table.setText(i, 6, JSONUtils.toString(entity, "hours"));
            table.setText(i, 7, FormatUtils.formarCurrency(JSONUtils.toString(entity, "billingRate")));
            table.setText(i, 8, FormatUtils.formarCurrency(JSONUtils.toString(entity, "overTimeBillingRate")));
            if (Auth.hasAnyOfRoles(ROLE.ROLE_INVOICE_MANAGER) && (JSONUtils.toString(entity, "invoiceStatus").equalsIgnoreCase(InvoiceStatus.Confirmed.name()))) {
                ClickableLink invoiceLink = new ClickableLink("Submit Invoice");
                invoiceLink.setTitle(JSONUtils.toString(entity, "id"));
                invoiceLink.addClickHandler((ClickEvent event) -> {
                    submitInvoice(((ClickableLink) event.getSource()).getTitle(), clientInfoId);
                });
                table.setWidget(i, 9, invoiceLink);
            } else {
                table.setText(i, 9, JSONUtils.toString(entity, "invoiceStatus"));
            }
        }
    }

    protected void submitInvoice(String entityId, String clientInfoId) {
        if (!entityId.isEmpty()) {
            new GenericPopup(new SubmitInvoicePanel(entityId, clientInfoId, CreateCompositeType.ADD)).show();
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (displayALL == false) {
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS, Auth.ROLE.ROLE_INVOICE_MANAGER)) {
                createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
            } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS_FULL_VIEW)) {
                createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE);
            } else {
                createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE);
            }
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
        }
    }

    @Override
    public void copyClicked(final String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(OfficeWelcome.constants.root_url() + "invoice/clone/" + entityId, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                new ResponseStatusWidget().show("Copy created. Please update and save.");
                TabPanel.instance().reportingPanel.entityPanel.clear();
                TabPanel.instance().reportingPanel.entityPanel.add(new UpdateInvoicePanel(JSONParser.parseLenient(arg0).isObject()));
            }
        });
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadInvoicePanel(JSONUtils.toString(getEntity(id), "id")), Window.getClientWidth() / 3, 0).show();
    }

    public static Widget renderInvoiceHistory(final JSONObject invoice, final String clientInfoId) {
        final DisclosurePanel invoiceDP = new DisclosurePanel("Invoices History");
        invoiceDP.setWidth("100%");
        invoiceDP.setOpen(true);
        invoiceDP.setContent(
                new ReadAllInvoicePanel(invoice, clientInfoId));
        invoiceDP.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                invoiceDP.setContent(
                        new ReadAllInvoicePanel(invoice, clientInfoId));
            }
        });
        return invoiceDP;
    }

    public static Widget renderInvoices(final JSONArray invoices, final String clientInfoId) {
        final DisclosurePanel invoiceDP = new DisclosurePanel("Invoices History");
        invoiceDP.setWidth("100%");
        invoiceDP.setOpen(true);
        invoiceDP.setContent(
                new ReadAllInvoicePanel(invoices, clientInfoId));
        invoiceDP.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                invoiceDP.setContent(
                        new ReadAllInvoicePanel(invoices, clientInfoId));
            }
        });
        return invoiceDP;
    }

    @Override
    protected void configureCreateButton() {
        if (displayALL == false && Auth.hasAnyOfRoles(ROLE.ROLE_INVOICE_MANAGER)) {
            createButton.setText("Create Invoice");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        new GenericPopup(new UpdateInvoicePanel(clientInfoId, false)).show();
    }

    private String getFormattedDate(String date) {
        String[] dates = date.split("-");
        String formatteddate = "";
        formatteddate = formatteddate.concat(dates[dates.length - 2]).concat("/");
        formatteddate = formatteddate.concat(dates[dates.length - 1]).concat("/");
        formatteddate = formatteddate.concat(dates[0]);
        return formatteddate;
    }
}
