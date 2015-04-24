/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.Attendence;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.rpc.HttpService;
import static info.chili.gwt.utils.JSONUtils.getValueFromMap;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateTimeRecordPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateTimeRecordPanel.class.getName());

    FloatField receptionHours;
    FloatField secondFloorHours;
    FloatField cubicalHours;

    public UpdateTimeRecordPanel(JSONObject entity) {
        logger.info(entity.toString());
        initUpdateComposite(entity, "TimeRecord", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("category", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("status", entity);
        assignEntityValueFromField("hours", entity);
        assignEntityValueFromField("notes", entity);
        JSONObject tags = new JSONObject();

        JSONArray values = new JSONArray();
        JSONObject receptionEntry = new JSONObject();
        receptionEntry.put("key", new JSONString("Reception"));
        receptionEntry.put("value", new JSONString(receptionHours.getValue()));
        values.set(0, receptionEntry);
        JSONObject secondFloorEntry = new JSONObject();
        secondFloorEntry.put("key", new JSONString("2nd Floor"));
        secondFloorEntry.put("value", new JSONString(secondFloorHours.getValue()));
        values.set(1, secondFloorEntry);
        JSONObject cubicalEntry = new JSONObject();
        cubicalEntry.put("key", new JSONString("Cubical"));
        cubicalEntry.put("value", new JSONString(cubicalHours.getValue()));
        values.set(2, cubicalEntry);
        tags.put("entry", values);
        entity.put("tags", tags);

        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postUpdateSuccess(arg0);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
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
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Time Record Information");
        TabPanel.instance().timePanel.entityPanel.clear();
//        TabPanel.instance().timePanel.entityPanel.add(new ReadAllTimeRecordsPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addEnumField("status", false, false, TimeRecordStatus.names());
        addEnumField("category", false, false, TimeRecordCategory.names());
        addField("startDate", false, false, DataType.DATE_FIELD);
        addField("endDate", false, false, DataType.DATE_FIELD);
        addField("hours", false, true, DataType.FLOAT_FIELD);
        addField("reception", false, false, DataType.FLOAT_FIELD);
        addField("secondFloor", false, false, DataType.FLOAT_FIELD);
        addField("cubical", false, false, DataType.FLOAT_FIELD);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD);
        receptionHours = (FloatField) fields.get("reception");
        secondFloorHours = (FloatField) fields.get("secondFloor");
        cubicalHours = (FloatField) fields.get("cubical");
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timerecord";
    }
}
