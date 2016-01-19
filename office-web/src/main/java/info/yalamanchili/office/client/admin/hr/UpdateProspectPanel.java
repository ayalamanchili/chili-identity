/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateProspectPanel extends UpdateComposite implements ClickHandler, ChangeHandler {

    private Logger logger = Logger.getLogger(UpdateProspectPanel.class.getName());
    FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "Prospect", "resumeURL", "Prospect/resumeURL", false) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
        }
    };

    protected static UpdateProspectPanel instance;

    public static UpdateProspectPanel instance() {
        return instance;
    }

    public UpdateProspectPanel(JSONObject entity) {
        instance = this;
        initUpdateComposite(entity, "Prospect", OfficeWelcome.constants);
    }

    public UpdateProspectPanel(String id) {
        instance = this;
        initUpdateComposite(id, "Prospect", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                logger.info(response);
                entity = (JSONObject) JSONParser.parseLenient(response);
                if (entity.get("id") != null) {
                    entityFieldsPanel.add(getLineSeperatorTag("Status Information"));
                    addEnumField("status", false, false, ProspectStatus.names(), Alignment.HORIZONTAL);
                    statusField = (EnumField) fields.get("status");
                    statusField.listBox.addChangeHandler(instance);
                    alignFields();
                    if (ProspectStatus.CLOSED_WON.name().equals(JSONUtils.toString(getEntity(), "status"))) {
                        addProspectWonFields();
                    }
                }
                populateFieldsFromEntity(entity);
                populateComments();
            }
        });
    }

    protected void populateComments() {
        entityActionsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.hr.Prospect"));
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "prospect/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject address = new JSONObject();
        assignEntityValueFromField("street1", address);
        assignEntityValueFromField("street2", address);
        assignEntityValueFromField("city", address);
        assignEntityValueFromField("state", address);
        assignEntityValueFromField("country", address);
        assignEntityValueFromField("zip", address);
        if (address.size() > 0) {
            StringField street1F = (StringField) fields.get("street1");
            if (street1F.getValue() == null || street1F.getValue().isEmpty()) {
                street1F.setValue("TBD");
                assignEntityValueFromField("street1", address);
            }
            StringField cityF = (StringField) fields.get("city");
            if (cityF.getValue() == null || cityF.getValue().isEmpty()) {
                cityF.setValue("TBD");
                assignEntityValueFromField("city", address);
            }
            EnumField countryF = (EnumField) fields.get("country");
            if (countryF.getValue() == null || countryF.getValue().isEmpty()) {
                countriesF.selectValue("USA");
                assignEntityValueFromField("country", address);
            }
            EnumField stateF = (EnumField) fields.get("state");
            if (stateF.getValue() == null || stateF.getValue().isEmpty()) {
                statesF.selectValue("FL");
                assignEntityValueFromField("state", address);
            }
            entity.put("address", address);
        }
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("countryCode", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("dateOfBirth", entity);
        assignEntityValueFromField("referredBy", entity);
        assignEntityValueFromField("screenedBy", entity);
        assignEntityValueFromField("processDocSentDate", entity);
        assignEntityValueFromField("status", entity);
        if (fields.containsKey("petitionFiledFor")) {
            assignEntityValueFromField("petitionFiledFor", entity);
        }
        if (fields.containsKey("trfEmpType")) {
            assignEntityValueFromField("trfEmpType", entity);
        }
        if (fields.containsKey("placedBy")) {
            assignEntityValueFromField("placedBy", entity);
        }
        if (fields.containsKey("dateOfJoining")) {
            assignEntityValueFromField("dateOfJoining", entity);
        }
        if (!resumeUploadPanel.isEmpty()) {
            entity.put("resumeURL", resumeUploadPanel.getFileName());
        }
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
                uploadResume(arg0);
            }
        });
    }

    protected void uploadResume(String entityStr) {
        entity = JSONParser.parseLenient(entityStr).isObject();
        resumeUploadPanel.upload(JSONUtils.toString(entity, "id"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
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
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("referredBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("screenedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("processDocSentDate", entity, DataType.DATE_FIELD);
        if (entity.get("id") != null) {
            assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        }
        if (ProspectStatus.CLOSED_WON.name().equals(JSONUtils.toString(getEntity(), "status"))) {
            assignFieldValueFromEntity("petitionFiledFor", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("trfEmpType", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("placedBy", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("dateOfJoining", entity, DataType.DATE_FIELD);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Prospect Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateProspectPanel(getEntityId()));
    }

    EnumField statesF;
    EnumField countriesF;

    @Override
    protected void addListeners() {
        statesF.listBox.addChangeHandler(this);
    }

    @Override
    protected void configure() {
        countriesF.listBox.addChangeHandler(this);
        formatTextAreaFields();
    }

    protected void formatTextAreaFields() {
        for (Map.Entry entry : fields.entrySet()) {
            if (entry.getValue() instanceof TextAreaField) {
                TextAreaField textAreaField = (TextAreaField) entry.getValue();
                textAreaField.getTextbox().setCharacterWidth(75);
                textAreaField.getTextbox().setVisibleLines(6);
            }
        }
    }

    EnumField statusField;

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("email", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("countryCode", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", false, true, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("street1", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, false, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("referredBy", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("screenedBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("processDocSentDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(resumeUploadPanel);
        statesF = (EnumField) fields.get("state");
        countriesF = (EnumField) fields.get("country");
        alignFields();
    }

    protected void addProspectWonFields() {
        if (!fields.containsKey("petitionFiledFor")) {
            addEnumField("petitionFiledFor", false, false, PetitionFor.names(), Alignment.HORIZONTAL);
            addEnumField("trfEmpType", false, false, TransferEmployeeType.names(), Alignment.HORIZONTAL);
            addEnumField("placedBy", false, false, PlacedBy.names(), Alignment.HORIZONTAL);
            addField("dateOfJoining", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
            alignFields();
        }
    }

    protected void removeProspectWonFields() {
        if (fields.containsKey("petitionFiledFor")) {
            fields.get("petitionFiledFor").removeFromParent();
            fields.remove("petitionFiledFor");
        }
        if (fields.containsKey("trfEmpType")) {
            fields.get("trfEmpType").removeFromParent();
            fields.remove("trfEmpType");
        }
        if (fields.containsKey("placedBy")) {
            fields.get("placedBy").removeFromParent();
            fields.remove("placedBy");
        }
        if (fields.containsKey("dateOfJoining")) {
            fields.get("dateOfJoining").removeFromParent();
            fields.remove("dateOfJoining");
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (!getEntityId().isEmpty()) { 
            return OfficeWelcome.constants.root_url() + "prospect/update";
        } else {
            return OfficeWelcome.constants.root_url() + "prospect/save";
        }
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(countriesF.listBox)) {
            switch (countriesF.getValue()) {
                case "USA":
                    statesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "INDIA":
                    statesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                    break;
            }
        } else if (event.getSource().equals(statusField.listBox)) {
            if (statusField.getValue().equals(ProspectStatus.CLOSED_WON.name())) {
                addProspectWonFields();
            } else {
                removeProspectWonFields();
            }
        }
    }
    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if(entity.get("resumeURL")==null){
            resumeUploadPanel.setMessage("Please Select A File");
            return false;
        }
        return true;
    }
}
