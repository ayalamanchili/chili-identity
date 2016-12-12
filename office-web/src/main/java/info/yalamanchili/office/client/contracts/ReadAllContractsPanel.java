/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contracts;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.invoice.UpdateInvoicesPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllContractsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllContractsPanel.class.getName());
    public static ReadAllContractsPanel instance;
    String emp = null;

    public ReadAllContractsPanel() {
        instance = this;
        initTable("Contract", OfficeWelcome.constants);
    }

    public ReadAllContractsPanel(JSONArray array) {
        instance = this;
        initTable("Contract", array, OfficeWelcome.constants);
    }

    public ReadAllContractsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Contract", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().reportingPanel.entityPanel.clear();
        TabPanel.instance().reportingPanel.entityPanel.add(new ReadContractsPanel(entityId));
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadContractsPanel(id), Window.getClientWidth() / 4, 0).show();
    }

    @Override
    public void deleteClicked(String entityId) {
    }

    @Override
    public void postDeleteSuccess() {
    }

    @Override
    public void updateClicked(String entityId) {
    }

    @Override
    public void preFetchTable(int start) {
        // TODO externalize the limit size for read all
        HttpService.HttpServiceAsync.instance().doGet(getReadAllContractsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("ItemNo"));
        table.setText(0, 3, getKeyValue("Vendor"));
        table.setText(0, 4, getKeyValue("MiddleVendor"));
        table.setText(0, 5, getKeyValue("Client"));
//        table.setText(0, 5, getKeyValue("BillRate"));
//        table.setText(0, 6, getKeyValue("O.T.BillRate"));
        table.setText(0, 6, getKeyValue("Frequency"));
        table.setText(0, 7, getKeyValue("StartDate"));
//        table.setText(0, 9, getKeyValue("EndDate"));
        table.setText(0, 8, getKeyValue("Status"));
        if (Auth.hasAnyOfRoles(ROLE.ROLE_INVOICE_MANAGER)) {
            table.setText(0, 9, getKeyValue("Invoice"));
        }
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            OfficeWelcome.instance().logger.info(entity.toString());

            if (JSONUtils.toString(entity, "isActive").equalsIgnoreCase("true")) {
                table.getRowFormatter().setStyleName(i, "contractActive");
            }
            if (JSONUtils.toString(entity, "isEnded").equalsIgnoreCase("true")) {
                table.getRowFormatter().setStyleName(i, "contractEnded");
            }
            if (JSONUtils.toString(entity, "isStarted").equalsIgnoreCase("false")) {
                table.getRowFormatter().setStyleName(i, "contractNotStarted");
            }
            if (JSONUtils.toString(entity, "isReady").equalsIgnoreCase("false")) {
                table.getRowFormatter().setStyleName(i, "contractNotReady");
            }
            table.setText(i, 1, JSONUtils.toString(entity, "employee"));
            table.setText(i, 2, JSONUtils.toString(entity, "itemNumber"));
            table.setText(i, 3, JSONUtils.toString(entity, "vendor"));
            table.setText(i, 4, JSONUtils.toString(entity, "middleVendor"));
            table.setText(i, 5, JSONUtils.toString(entity, "client"));
            setEnumColumn(i, 6, entity, InvoiceFrequency.class.getSimpleName(), "invoiceFrequency");
//            table.setText(i, 5, FormatUtils.formarCurrency(JSONUtils.toString(entity, "billingRate")));
//            table.setText(i, 6, FormatUtils.formarCurrency(JSONUtils.toString(entity, "overTimeBillingRate")));
            table.setText(i, 7, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
//            table.setText(i, 9, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
            setEnumColumn(i, 8, entity, ClientInformationStatus.class.getSimpleName(), "status");
            if (Auth.hasAnyOfRoles(ROLE.ROLE_INVOICE_MANAGER)
                    && (entity.containsKey("status") && entity.get("status").isString().stringValue().equalsIgnoreCase("Completed")
                    || entity.containsKey("status") && entity.get("status").isString().stringValue().equalsIgnoreCase("Pending_Closing")
                    || entity.containsKey("status") && entity.get("status").isString().stringValue().equalsIgnoreCase("Closed"))) {
                ClickableLink invoiceLink = new ClickableLink("Create Invoice");
                invoiceLink.setTitle(JSONUtils.toString(entity, "id"));
                emp = JSONUtils.toString(entity, "employee");
                invoiceLink.addClickHandler((ClickEvent event) -> {
                    getInvoice(((ClickableLink) event.getSource()).getTitle());
                });
                table.setWidget(i, 9, invoiceLink);
            }
        }
    }

    protected void getInvoice(String entityId) {
        if (!entityId.isEmpty()) {
            new GenericPopup(new UpdateInvoicesPanel(entityId, false), 0, Window.getClientHeight() / 5).show();
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_FULL_VIEW, Auth.ROLE.ROLE_RECRUITER)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.PRINT);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
        }
    }

    @Override
    public void printClicked(String entityId) {
        Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "contract/reports" + "&passthrough=true" + "&id=" + entityId, "_blank", "");
    }

    private String getReadAllContractsURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "contract/" + start.toString() + "/" + limit.toString();
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }
}
