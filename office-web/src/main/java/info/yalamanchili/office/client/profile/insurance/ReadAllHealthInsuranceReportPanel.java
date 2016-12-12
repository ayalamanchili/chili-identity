/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllHealthInsuranceReportPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllHealthInsuranceReportPanel.class.getName());
    public static ReadAllHealthInsuranceReportPanel instance;

    public ReadAllHealthInsuranceReportPanel(JSONArray array) {
        instance = this;
        initTable("HealthInsurance", array, OfficeWelcome.constants2);
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
        table.setText(0, 0, getKeyValue("Employee"));
        table.setText(0, 1, getKeyValue("Year"));
        table.setText(0, 2, getKeyValue("Enrolled"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            table.setCellSpacing(5);
            JSONObject entity = (JSONObject) entities.get(i - 1);
            table.setText(i, 0, JSONUtils.toString(entity, "employee"));
            table.setText(i, 1, JSONUtils.toString(entity, "year"));
            table.setText(i, 2, JSONUtils.toString(entity, "enrolled"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
    }

    @Override
    protected boolean enableQuickView() {
        return false;
    }
}