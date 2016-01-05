/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
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
import info.yalamanchili.office.client.contracts.ClientInformationStatus;
import info.yalamanchili.office.client.contracts.ReadContractsPanel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAllEndProjectPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEndProjectPanel.class.getName());
    public static ReadAllEndProjectPanel instance;

    public ReadAllEndProjectPanel() {
        instance = this;
        initTable("Contract", OfficeWelcome.constants);
    }

    public ReadAllEndProjectPanel(JSONArray array) {
        instance = this;
        initTable("Contract", array, OfficeWelcome.constants);
    }

    public ReadAllEndProjectPanel(String parentId) {
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
        table.setText(0, 2, getKeyValue("Recruiter"));
        table.setText(0, 3, getKeyValue("Vendor"));
        table.setText(0, 4, getKeyValue("BillRate"));
        table.setText(0, 5, getKeyValue("StartDate"));
        table.setText(0, 6, getKeyValue("EndDate"));
        table.setText(0, 7, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            OfficeWelcome.instance().logger.info("entity in fill data :" + i + " " + entity.toString());
            JSONObject emp = (JSONObject) entity.get("employee");
            JSONObject vendor = (JSONObject) entity.get("vendor");
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
            table.setText(i, 4, FormatUtils.formarCurrency(JSONUtils.toString(entity, "billingRate")));
            table.setText(i, 5, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            table.setText(i, 6, DateUtils.getFormatedDate(JSONUtils.toString(entity, "endDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            setEnumColumn(i, 7, entity, ClientInformationStatus.class.getSimpleName(), "status");

        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
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
