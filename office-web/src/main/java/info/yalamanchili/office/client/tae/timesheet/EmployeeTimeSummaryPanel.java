/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class EmployeeTimeSummaryPanel extends ReadComposite {

    protected String employeeId;
    private static EmployeeTimeSummaryPanel instance;
    private static Logger logger = Logger.getLogger(EmployeeTimeSummaryPanel.class.getName());

    public static EmployeeTimeSummaryPanel instance() {
        return instance;
    }

    public EmployeeTimeSummaryPanel() {
        initReadComposite("TimeSummary", OfficeWelcome.constants);
    }

    public EmployeeTimeSummaryPanel(String employeeId) {
        this.employeeId = employeeId;
        initReadComposite("TimeSummary", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null && !response.isEmpty() && JSONParser.parseLenient(response).isObject() != null) {
                            entity = (JSONObject) JSONParser.parseLenient(response);
                            populateFieldsFromEntity(entity);
                        }
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("quickBooksHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("adpHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("adjustmentHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("balanceHours", entity, DataType.FLOAT_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("quickBooksHours", true, false, DataType.FLOAT_FIELD);
        addField("adpHours", true, false, DataType.FLOAT_FIELD);
        addField("adjustmentHours", true, false, DataType.FLOAT_FIELD);
        addField("balanceHours", true, false, DataType.FLOAT_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (employeeId != null) {
            return OfficeWelcome.constants.root_url() + "timesheet/summary/" + employeeId;
        } else {
            return OfficeWelcome.constants.root_url() + "timesheet/summary/currentuser";
        }
    }
}
