/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

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
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
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
        initTable("Invoice", OfficeWelcome.constants);
    }
    
    public ReadAllInvoicePanel(boolean displayAll) {
        instance = this;
        this.displayALL = displayAll;
        initTable("Invoice", OfficeWelcome.constants);
    }
    static JSONObject invoice;
    
    public ReadAllInvoicePanel(JSONObject invoice) {
        instance = this;
        this.invoice = invoice;
        initTable("Invoice", OfficeWelcome.constants);
    }
    
    public ReadAllInvoicePanel(JSONObject invoice, String clientInfoId) {
        instance = this;
        this.clientInfoId = clientInfoId;
        this.invoice = invoice;
        initTable("Invoice", OfficeWelcome.constants);
    }
    
    public ReadAllInvoicePanel(JSONArray array) {
        instance = this;
        displayALL = true;
        logger.info("ddddddd" + array.toString());
        initTable("Invoice", array, OfficeWelcome.constants);
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
        table.setText(0, 3, getKeyValue("InvoiceNumber"));
        table.setText(0, 4, getKeyValue("StartDate"));
        table.setText(0, 5, getKeyValue("EndDate"));
        table.setText(0, 6, getKeyValue("InvoiceDate"));
        table.setText(0, 7, getKeyValue("BillingRate"));
        table.setText(0, 8, getKeyValue("overTimeBillingRate"));
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
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 5, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 6, DateUtils.getFormatedDate(JSONUtils.toString(entity, "invoiceDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 7, FormatUtils.formarCurrency(JSONUtils.toString(entity, "billingRate")));
            table.setText(i, 8, FormatUtils.formarCurrency(JSONUtils.toString(entity, "overTimeBillingRate")));
        }
    }
    
    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (displayALL == false) {
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
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
        logger.info("invoice obj is.... " + invoice);
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
    
    @Override
    protected void configureCreateButton() {
        if (displayALL == false) {
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
}
