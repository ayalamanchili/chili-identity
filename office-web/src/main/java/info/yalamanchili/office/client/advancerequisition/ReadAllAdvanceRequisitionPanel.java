/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancerequisition;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllAdvanceRequisitionPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllAdvanceRequisitionPanel.class.getName());
    public static ReadAllAdvanceRequisitionPanel instance;

    public ReadAllAdvanceRequisitionPanel() {
        instance = this;
        initTable("AdvanceRequisition", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
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
        new ResponseStatusWidget().show("Successfully Deleted AdvanceRequisition Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllAdvanceRequisitionPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new UpdateAdvanceRequisitionPanel(getEntity(entityId)));
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getadvanceURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
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
        table.setText(0, 1, getKeyValue("Purpose"));
        table.setText(0, 2, getKeyValue("Amount"));
        table.setText(0, 3, getKeyValue("NeededBy"));
        table.setText(0, 4, getKeyValue("DateRequested"));
        table.setText(0, 5, getKeyValue("PayrollFileNumber"));
        table.setText(0, 6, getKeyValue("Transaction"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "purpose"));
            table.setText(i, 2, JSONUtils.toString(entity, "amount"));
            table.setText(i, 3, JSONUtils.toString(entity, "neededBy"));
            table.setText(i, 4, JSONUtils.toString(entity, "dateRequested"));
            table.setText(i, 5, JSONUtils.toString(entity, "payrollFileNumber"));
            table.setText(i, 6, JSONUtils.toString(entity, "transaction"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "advancerequisition/delete/" + entityId;
    }

    private String getadvanceURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "advancerequisition/" + start.toString() + "/"
                + limit.toString();
    }
}
