/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CorporateTimeSummaryPanel extends ReadComposite {

    protected String employeeId;
    private static CorporateTimeSummaryPanel instance;
    private static Logger logger = Logger.getLogger(CorporateTimeSummaryPanel.class.getName());

    public static CorporateTimeSummaryPanel instance() {
        return instance;
    }

    public CorporateTimeSummaryPanel() {
        initReadComposite("CorporateTimeSummary", OfficeWelcome.constants);
    }

    public CorporateTimeSummaryPanel(String employeeId) {
        this.employeeId = employeeId;
        initReadComposite("CorporateTimeSummary", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("availableSickHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("availablePersonalHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("availableVacationHours", entity, DataType.FLOAT_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("availableSickHours", true, false, DataType.FLOAT_FIELD);
        addField("availablePersonalHours", true, false, DataType.FLOAT_FIELD);
        addField("availableVacationHours", true, false, DataType.FLOAT_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (employeeId != null) {
            return OfficeWelcome.constants.root_url() + "corporate-timesheet/summary/" + employeeId;
        } else {
            return OfficeWelcome.constants.root_url() + "corporate-timesheet/summary";
        }
    }
}
