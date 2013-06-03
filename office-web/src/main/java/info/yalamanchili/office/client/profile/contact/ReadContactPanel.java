/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.contact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;
import info.yalamanchili.office.client.profile.phone.ReadPhonePanel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
//TODO
public class ReadContactPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(UpdateContactPanel.class.getName());
    protected List<ReadPhonePanel> readPhoneWidgets = new ArrayList<ReadPhonePanel>();
    protected JSONArray phones = new JSONArray();

    public ReadContactPanel(JSONObject entity) {
        if (entity.get("phones") != null) {
            phones = JSONUtils.toJSONArray(entity.get("phones"));
        }
        initReadComposite(entity, "Contact", OfficeWelcome.constants);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        for (int i = 0; i < phones.size(); i++) {
            addCreatePhonePanel((JSONObject) phones.get(i));
        }
    }

    @Override
    protected void configure() {
    }

    protected void addCreatePhonePanel(JSONObject entity) {
        ReadPhonePanel readPhonePanel = new ReadPhonePanel(entity);
        entityFieldsPanel.add(readPhonePanel);
        readPhoneWidgets.add(readPhonePanel);
    }

    @Override
    protected void addWidgets() {
        addField("firstName", true, true, DataType.STRING_FIELD);
        addField("middleInitial", true, false, DataType.STRING_FIELD);
        addField("lastName", true, true, DataType.STRING_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", true, false, strs);
        addField("email", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "contact";
    }

    @Override
    public void loadEntity(String entityId) {   
    }

    @Override
    protected void addListeners() {
    }
}
