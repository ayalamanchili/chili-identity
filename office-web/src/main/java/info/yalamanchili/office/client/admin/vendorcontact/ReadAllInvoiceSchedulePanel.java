/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public abstract class ReadAllInvoiceSchedulePanel extends CRUDReadAllComposite {

    protected static Logger logger = Logger.getLogger(ReadAllInvoiceSchedulePanel.class.getName());
    public static ReadAllInvoiceSchedulePanel instance;
    protected String targetClassName;

    public static ReadAllInvoiceSchedulePanel instance() {
        return instance;
    }

    public ReadAllInvoiceSchedulePanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("InvoiceSchedule", OfficeWelcome.constants2);
    }

    public ReadAllInvoiceSchedulePanel(String parentId, String targetClassName) {
        instance = this;
        this.parentId = parentId;
        this.targetClassName = targetClassName;
        initTable("InvoiceSchedule", OfficeWelcome.constants2);
    }

    public ReadAllInvoiceSchedulePanel() {
        instance = this;
        initTable("InvoiceSchedule", OfficeWelcome.constants2);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getSchedulesURL(start, OfficeWelcome.constants.tableSize()),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    protected abstract String getSchedulesURL(Integer start, String limit);

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Start Date"));
        table.setText(0, 2, getKeyValue("End Date"));
        table.setText(0, 3, getKeyValue("No of Days to Reminder Before"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 2, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 3, JSONUtils.toString(entity, "reminderDays"));
        }
    }

    @Override
    protected abstract void addOptionsWidget(int row, JSONObject entity);

    @Override
    public abstract void viewClicked(String entityId);

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

    protected abstract String getDeleteURL(String entityId);

    @Override
    public abstract void postDeleteSuccess();

    @Override
    public abstract void updateClicked(String entityId);
}
