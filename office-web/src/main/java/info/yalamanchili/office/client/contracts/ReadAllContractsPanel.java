/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contracts;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllContractsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllContractsPanel.class.getName());
    public static ReadAllContractsPanel instance;

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
        TabPanel.instance().reportingPanel.entityPanel.add(new ReadContractsPanel(getEntity(entityId)));
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
        table.setText(0, 2, getKeyValue("Client"));
        table.setText(0, 3, getKeyValue("Vendor"));
        table.setText(0, 4, getKeyValue("ItemNo"));
        table.setText(0, 5, getKeyValue("BillRate"));
        table.setText(0, 6, getKeyValue("O.T.BillRate"));
        table.setText(0, 7, getKeyValue("Frequency"));
        table.setText(0, 8, getKeyValue("StartDate"));
        table.setText(0, 9, getKeyValue("EndDate"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            OfficeWelcome.instance().logger.info(entity.toString());
            table.setText(i, 1, JSONUtils.toString(entity, "employee"));
            table.setText(i, 2, JSONUtils.toString(entity, "client"));
            table.setText(i, 3, JSONUtils.toString(entity, "vendor"));
            table.setText(i, 4, JSONUtils.toString(entity, "itemNumber"));
            table.setText(i, 5, FormatUtils.formarCurrency(JSONUtils.toString(entity, "billingRate")));
            table.setText(i, 6, FormatUtils.formarCurrency(JSONUtils.toString(entity, "overTimeBillingRate")));
            table.setText(i, 7, JSONUtils.toString(entity, "invoiceFrequency"));
            table.setText(i, 8, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            table.setText(i, 9, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));

        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    private String getReadAllContractsURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "contract/" + start.toString() + "/" + limit.toString();
    }

}
