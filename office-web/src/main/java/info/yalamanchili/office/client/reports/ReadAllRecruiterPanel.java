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
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllRecruiterPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllRecruiterPanel.class.getName());
    public static ReadAllRecruiterPanel instance;

    public ReadAllRecruiterPanel(JSONArray array) {
        instance = this;
        initTable("Contract", array, OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
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
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("Client"));
        table.setText(0, 3, getKeyValue("Vendor"));
        table.setText(0, 4, getKeyValue("Start Date"));
        table.setText(0, 5, getKeyValue("End Date"));
        table.setText(0, 6, getKeyValue("Billing rate"));
        table.setText(0, 7, getKeyValue("BillRate Duration"));
        table.setText(0, 8, getKeyValue("Placement"));
        table.setText(0, 9, getKeyValue("Location"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "employee"));
            table.setText(i, 2, JSONUtils.toString(entity, "client"));
            table.setText(i, 3, JSONUtils.toString(entity, "vendor"));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            table.setText(i, 5, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            table.setText(i, 6, FormatUtils.formarCurrency(JSONUtils.toString(entity, "billingRate")));
            table.setText(i, 7, JSONUtils.toString(entity, "billingRateDuration"));
            table.setText(i, 8, JSONUtils.toString(entity, "recruiter"));
            table.setText(i, 9, JSONUtils.toString(entity, "clientLocation"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    protected boolean enableQuickView() {
        return false;
    }
}
