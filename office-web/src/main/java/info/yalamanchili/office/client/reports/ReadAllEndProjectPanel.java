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
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
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
public class ReadAllEndProjectPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEndProjectPanel.class.getName());
    public static ReadAllEndProjectPanel instance;

    public ReadAllEndProjectPanel(JSONArray array) {
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
        table.setText(0, 2, getKeyValue("Recruiter"));
        table.setText(0, 3, getKeyValue("Vendor"));
        table.setText(0, 4, getKeyValue("SubContractor"));
        table.setText(0, 5, getKeyValue("BillRate"));
        table.setText(0, 6, getKeyValue("StartDate"));
        table.setText(0, 7, getKeyValue("EndDate"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get("employee");
            JSONObject vendor = (JSONObject) entity.get("vendor");
            if (entity.get("subcontractor") != null) {
                JSONObject subcontractor = (JSONObject) entity.get("subcontractor");
                table.setText(i, 4, JSONUtils.toString(subcontractor, "name"));
            }
            table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            JSONValue value = entity.get("recruiters");
            JSONObject object;
            JSONArray array;
            if (value != null) {
                if ((object = value.isObject()) != null) {
                    table.setText(i, 2, object.get("firstName").isString().stringValue() + " " + object.get("lastName").isString().stringValue());
                } else if ((array = value.isArray()) != null) {
                    String recruiters = "";
                    if (array != null) {
                        for (int index = 0; index <= array.size() - 1; index++) {
                            JSONObject obj = (JSONObject) JSONParser.parse(array.get(index).toString());
                            if (index <= array.size() - 2) {
                                recruiters = recruiters.concat(obj.get("firstName").isString().stringValue() + " " + obj.get("lastName").isString().stringValue() + " , ");
                            } else if (index == array.size() - 1) {
                                recruiters = recruiters.concat(obj.get("firstName").isString().stringValue() + " " + obj.get("lastName").isString().stringValue());
                            }
                        }
                        table.setText(i, 2, recruiters);
                    }
                }
            }
            table.setText(i, 3, JSONUtils.toString(vendor, "name"));
            table.setText(i, 5, FormatUtils.formarCurrency(JSONUtils.toString(entity, "billingRate")));
            table.setText(i, 6, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            table.setText(i, 7, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
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
