/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.contact.Sex;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadProspectsPanel extends ReadComposite {

    private Logger logger = Logger.getLogger(ReadProspectsPanel.class.getName());

    private static ReadProspectsPanel instance;
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "screenedBy", "Employee", true, false);

    public static ReadProspectsPanel instance() {
        return instance;
    }

    public ReadProspectsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Prospect", OfficeWelcome.constants);
    }

    public ReadProspectsPanel(String id) {
        initReadComposite(id, "Prospect", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                        entityFieldsPanel.add(Utils.getLineSeperatorTag("Resume"));
                        String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(entity, "resumeURL") + "&entityId=" + JSONUtils.toString(entity, "id");
                        FileField fileField = new FileField(fileURL);
                        entityFieldsPanel.add(fileField);
                        populateComments();
                    }
                });
    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.hr.Prospect"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        JSONObject emp = (JSONObject) entity.get("employee");
        if (entity.get("address") != null) {
            JSONObject address = entity.get("address").isObject();
            assignFieldValueFromEntity("street1", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("street2", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("city", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("country", address, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("state", address, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("zip", address, DataType.LONG_FIELD);
        }
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("screenedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("extension", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("referredBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("processDocSentDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("firstName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("referredBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("email", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("countryCode", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("extension", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", true, false, Sex.names(), Alignment.HORIZONTAL);
        addField("street1", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", true, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", true, false, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("screenedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("processDocSentDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("status", true, false, ProspectStatus.names(), Alignment.HORIZONTAL);

        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "prospect/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.hr.Prospect" + "/" + getEntityId();
    }

}
