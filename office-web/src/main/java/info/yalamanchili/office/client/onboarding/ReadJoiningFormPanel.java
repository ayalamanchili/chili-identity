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
        JSONObject employee = (JSONObject) entity.get("emp");
        JSONObject dependent = (JSONObject) entity.get("dep");
        JSONObject empAddnlDetails = (JSONObject) entity.get("empAddnlDetails");
        assignFieldValueFromEntity("firstName", employee, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", employee, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", employee, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", employee, DataType.DATE_FIELD);
        assignFieldValueFromEntity("sex", employee, DataType.ENUM_FIELD);
//        assignFieldValueFromEntity("street1", entity, DataType.STRING_FIELD);
//        assignFieldValueFromEntity("street2", entity, DataType.STRING_FIELD);
//        assignFieldValueFromEntity("city", entity, DataType.STRING_FIELD);
//        assignFieldValueFromEntity("country", entity, DataType.ENUM_FIELD);
//        assignFieldValueFromEntity("state", entity, DataType.ENUM_FIELD);
//        assignFieldValueFromEntity("zip", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("dfirstName", dependent, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dlastName", dependent, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", dependent, DataType.DATE_FIELD);
        assignFieldValueFromEntity("relationship", dependent, DataType.ENUM_FIELD);
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
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", false, true, Sex.names(), Alignment.HORIZONTAL);
        addField("street1", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Dependent's Information"));
        addField("dfirstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dlastName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("relationship", false, true, Relationship.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Additional Information"));
        addField("referredBy", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("maritalStatus", false, true, MaritalStatus.names(), Alignment.HORIZONTAL);
        addEnumField("ethnicity", false, true, Ethnicity.names(), Alignment.HORIZONTAL);
//        countriesF = (EnumField) fields.get("country");
//        statesF = (EnumField) fields.get("state");
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
