/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expenseitem;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ReadAllEpenseItemPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEpenseItemPanel.class.getName());
    public static ReadAllEpenseItemPanel instance;

    public ReadAllEpenseItemPanel() {
        instance = this;
        initTable("ExpenseItem", OfficeWelcome.constants);
    }

    public ReadAllEpenseItemPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("ExpenseItem", OfficeWelcome.constants);
    }

    public ReadAllEpenseItemPanel(JSONArray array) {
        instance = this;
        initTable("ExpenseItem", array, OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadExpenseItemPanel(getEntity(entityId)));
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

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted ExpenseItem Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllEpenseItemPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
//        TabPanel.instance().expensePanel.entityPanel.add(new UpdateExpenseItemPanel(getEntity(entityId)));
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllExpenseItemURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info("INFO:" + result);
                postFetchTable(result);
            }
        });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("ItemStartDate"));
        table.setText(0, 2, getKeyValue("ItemEndDate"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, DateUtils.getFormatedDate(JSONUtils.toString(entity, "itemStartDate"), DateTimeFormat.PredefinedFormat.DATE_LONG));
            table.setText(i, 2, DateUtils.getFormatedDate(JSONUtils.toString(entity, "itemEndDate"), DateTimeFormat.PredefinedFormat.DATE_LONG));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "expenseitem/delete/" + entityId;
    }

    private String getReadAllExpenseItemURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "expenseitem/" + start.toString() + "/" + limit.toString();
    }
}
