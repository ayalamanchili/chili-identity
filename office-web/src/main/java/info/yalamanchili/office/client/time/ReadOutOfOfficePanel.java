/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class ReadOutOfOfficePanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadOutOfOfficePanel.class.getName());
    private static ReadOutOfOfficePanel instance;
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", true, false, Alignment.HORIZONTAL);

    public static ReadOutOfOfficePanel instance() {
        return instance;
    }

    public ReadOutOfOfficePanel(String id) {
        instance = this;
        initReadComposite(id, "OutOfOfficeRequest", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("outOfOfficeType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reason", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("time", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", selectEmployeeWidgetF);
        addEnumField("outOfOfficeType", true, false, OutOfOfficeType.names(), Alignment.HORIZONTAL);
        addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reason", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("time", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "out-of-office/" + getEntityId();
    }

}
