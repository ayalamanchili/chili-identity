/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.gwt.i18n.client.DateTimeFormat;
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
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.contracts.ClientInformationStatus;
import info.yalamanchili.office.client.contracts.ReadContractsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllBisContractsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllBisContractsPanel.class.getName());
    public static ReadAllBisContractsPanel instance;

    public ReadAllBisContractsPanel() {
        instance = this;
        initTable("Contract", OfficeWelcome.constants);
    }

    public ReadAllBisContractsPanel(JSONArray array) {
        instance = this;
        initTable("Contract", array, OfficeWelcome.constants);
    }

    public ReadAllBisContractsPanel(String parentId) {
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
        new GenericPopup(new ReadContractsPanel(getEntity(id)), Window.getClientWidth() / 3, 0).show();
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
        table.setText(0, 3, getKeyValue("Client"));
        table.setText(0, 4, getKeyValue("Vendor"));
        table.setText(0, 5, getKeyValue("Middle Vendor"));
        table.setText(0, 6, getKeyValue("Frequency"));
        table.setText(0, 7, getKeyValue("StartDate"));
        table.setText(0, 8, getKeyValue("Status"));
        
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
            table.setText(i, 3, JSONUtils.toString(entity, "client"));
            table.setText(i, 4, JSONUtils.toString(entity, "vendor"));
            table.setText(i, 5, JSONUtils.toString(entity, "middleVendor"));
            setEnumColumn(i, 6, entity, InvoiceFrequency.class.getSimpleName(), "invoiceFrequency");
            table.setText(i, 7, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
            setEnumColumn(i, 8, entity, ClientInformationStatus.class.getSimpleName(), "status");
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.PRINT);
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

