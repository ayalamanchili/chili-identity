/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.releasenotes;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author sudharani.b
 */
public class ReadReleaseNotesPanel extends ReadComposite {

    private static ReadReleaseNotesPanel instance;
    private static Logger logger = Logger.getLogger(ReadReleaseNotesPanel.class.getName());

    public static ReadReleaseNotesPanel instance() {
        return instance;
    }

    public ReadReleaseNotesPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ReleaseNotes", OfficeWelcome.constants2);
    }

    public ReadReleaseNotesPanel(String id) {
        instance = this;
        initReadComposite(id, "ReleaseNotes", OfficeWelcome.constants2);
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
        assignFieldValueFromEntity("summary", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("details", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("effectiveDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("userIds", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("roles", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("moreInformationLink", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("acknowledgedIds", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("summary", true, false, DataType.TEXT_AREA_FIELD);
        addField("details", true, false, DataType.TEXT_AREA_FIELD);
        addField("effectiveDate", true, false, DataType.DATE_FIELD);
        addField("endDate", true, false, DataType.DATE_FIELD);
        addField("userIds", true, false, DataType.TEXT_AREA_FIELD);
        addField("roles", true, false, DataType.TEXT_AREA_FIELD);
        addField("moreInformationLink", true, false, DataType.TEXT_AREA_FIELD);
        addField("acknowledgedIds", true, false, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllReleaseNotesPanel.instance;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "releaseNotes/" + entityId;
    }
}
