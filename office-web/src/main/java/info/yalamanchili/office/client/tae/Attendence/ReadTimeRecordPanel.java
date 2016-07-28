/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.Attendence;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.rpc.HttpService;
import static info.chili.gwt.utils.JSONUtils.getValueFromMap;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author prasanthi.p
 */
public class ReadTimeRecordPanel extends ReadComposite {

    FloatField receptionHours;
    FloatField secondFloorHours;
    FloatField cubicalHours;
    private static ReadTimeRecordPanel instance;

    public static ReadTimeRecordPanel instance() {
        return instance;
    }

    public ReadTimeRecordPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "TimeRecord", OfficeWelcome.constants);
    }

    public ReadTimeRecordPanel(String id) {
        initReadComposite(id, "TimeRecord", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("category", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("hours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        receptionHours.setValue(getValueFromMap(entity.get("tags").isObject(), "Reception"));
        secondFloorHours.setValue(getValueFromMap(entity.get("tags").isObject(), "2nd Floor"));
        cubicalHours.setValue(getValueFromMap(entity.get("tags").isObject(), "Cubical"));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addEnumField("status", true, false, TimeRecordStatus.names());
        addEnumField("category", true, false, TimeRecordCategory.names());
        addField("startDate", true, false, DataType.DATE_FIELD);
        addField("endDate", true, false, DataType.DATE_FIELD);
        addField("hours", true, false, DataType.FLOAT_FIELD);
        addField("reception", true, false, DataType.FLOAT_FIELD);
        addField("secondFloor", true, false, DataType.FLOAT_FIELD);
        addField("cubical", true, false, DataType.FLOAT_FIELD);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD);
        receptionHours = (FloatField) fields.get("reception");
        secondFloorHours = (FloatField) fields.get("secondFloor");
        cubicalHours = (FloatField) fields.get("cubical");
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timerecord/" + entityId;
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        return ReadAllTimeRecordsPanel.instance;
    }
}
