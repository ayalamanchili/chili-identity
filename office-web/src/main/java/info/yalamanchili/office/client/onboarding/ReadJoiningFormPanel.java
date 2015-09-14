/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.contact.Sex;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadJoiningFormPanel extends ReadComposite {

private static Logger logger = Logger.getLogger(ReadJoiningFormPanel.class.getName());

    HTML emptyLine = new HTML("<br/>");

    public ReadJoiningFormPanel(JSONObject entity) {
        initReadComposite(entity, "JoiningForm", OfficeWelcome.constants);
    }

    public ReadJoiningFormPanel(String id) {
        initReadComposite(id, "JoiningForm", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        logger.info(entity.toString());
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        JSONObject employee = (JSONObject) entity.get("employee");
        JSONObject dependents = (JSONObject) entity.get("dependents");
        JSONObject empAddnlDetails = (JSONObject) entity.get("empAddnlDetails");
        JSONObject address = (JSONObject) entity.get("address");
        assignFieldValueFromEntity("firstName", employee, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", employee, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", employee, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", employee, DataType.DATE_FIELD);
        assignFieldValueFromEntity("sex", employee, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("street1", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("street2", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("city", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("country", address, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("state", address, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("zip", address, DataType.LONG_FIELD);
        assignFieldValueFromEntity("dfirstName", dependents, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dlastName", dependents, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ddateOfBirth", dependents, DataType.DATE_FIELD);
        assignFieldValueFromEntity("relationship", dependents, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("referredBy", empAddnlDetails, DataType.STRING_FIELD);
        assignFieldValueFromEntity("maritalStatus", empAddnlDetails, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("ethnicity", empAddnlDetails, DataType.ENUM_FIELD);
    }

    @Override
    protected void addListeners() {
        
    }

    @Override
    protected void configure() {
       
    }

    @Override
    protected void addWidgets() {
        addField("firstName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", true, true, Sex.names(), Alignment.HORIZONTAL);
        addField("street1", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", true, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", true, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Dependent's Information"));
        addField("dfirstName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dlastName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ddateOfBirth", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("relationship", true, true, Relationship.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Additional Information"));
        addField("referredBy", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("maritalStatus", true, true, MaritalStatus.names(), Alignment.HORIZONTAL);
        addEnumField("ethnicity", true, true, Ethnicity.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(emptyLine);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
       
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee-forms/joining-form/" + entityId;
    }
}
