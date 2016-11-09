/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.reports;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Hemanth
 */
class ReadProjectSummaryReportPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadProjectSummaryReportPanel.class.getName());
    public static ReadProjectSummaryReportPanel instance;

    public ReadProjectSummaryReportPanel() {
        instance = this;
        initTable("Contract", OfficeWelcome.constants);
    }

    public ReadProjectSummaryReportPanel(JSONArray array) {
        instance = this;
        JSONObject entity = (JSONObject) array.get(0);
        String name = JSONUtils.toString(entity, "employee");
        initTable(name, array, OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {

    }

    @Override
    protected void onQuickView(int row, String id) {

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

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Client"));
        table.setText(0, 2, getKeyValue("Vendor"));
        table.setText(0, 3, getKeyValue("StartDate"));
        table.setText(0, 4, getKeyValue("EndDate"));
        table.setText(0, 5, getKeyValue("BillingRate"));
        table.setText(0, 6, getKeyValue("Gap Period"));
    }

    @Override
    public void fillData(JSONArray entities) {
        if (entities.size() == 2) {
            for (int i = 1, j = 1; i <= entities.size(); i++, j++) {
                JSONObject entit = (JSONObject) entities.get(j);
                JSONObject entity = (JSONObject) entities.get(i - 1);
                addOptionsWidget(i, entity);
                setTableColumns(i, entity);
                if (i == entities.size()) {
                    table.setText(i, 6, "NA");
                } else {
                    table.setText(i, 6, getGap(entit, entity));
                }
            }
        } else if (entities.size() > 1) {
            for (int i = 1, j = 1; i <= entities.size(); i++, j++) {
                JSONObject entit = (JSONObject) entities.get(j);
                JSONObject entity = (JSONObject) entities.get(i - 1);
                addOptionsWidget(i, entity);
                setTableColumns(i, entity);
                if (i == 1 || i == entities.size()) {
                    table.setText(i, 6, "NA");
                } else {
                    table.setText(i, 6, getGap(entit, entity));
                }
            }
        } else {
            for (int i = 1; i <= entities.size(); i++) {
                JSONObject entity = (JSONObject) entities.get(i - 1);
                addOptionsWidget(i, entity);
                setTableColumns(i, entity);
                table.setText(i, 6, "NA");
            }
        }

    }

    private void setTableColumns(int i, JSONObject entity) {
        table.setText(i, 1, JSONUtils.toString(entity, "client"));
        table.setText(i, 2, JSONUtils.toString(entity, "vendor"));
        table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
        table.setText(i, 4, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
        table.setText(i, 5, FormatUtils.formarCurrency(JSONUtils.toString(entity, "billingRate")));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {

    }

    @Override
    public void printClicked(String entityId) {

    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }

    private String getGap(JSONObject entit, JSONObject entity) {
        //Integer z = 0;
        String e = DateUtils.formatDate(JSONUtils.toString(entit, "endDate"));
        String s = DateUtils.formatDate(JSONUtils.toString(entity, "startDate"));
        //z = (int)( (e.getTime() - s.getTime()) / (1000 * 60 * 60 * 24));
        return e + " to " + s;
    }

}
