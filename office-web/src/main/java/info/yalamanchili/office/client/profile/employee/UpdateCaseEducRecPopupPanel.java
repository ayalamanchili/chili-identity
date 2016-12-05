/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.crud.TUpdateComposite;
import info.chili.gwt.data.CanadaStatesFactory;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.resources.OfficeImages;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateCaseEducRecPopupPanel extends TUpdateComposite implements ChangeHandler {

    private static Logger logger = Logger.getLogger(UpdateCaseEducRecPopupPanel.class.getName());
    boolean isReadPanel;
    EnumField statesF;
    EnumField countriesF;

    public UpdateCaseEducRecPopupPanel(String entityId) {
        initUpdateComposite(entityId, "EducationRecord", OfficeWelcome.constants2);
    }

    public UpdateCaseEducRecPopupPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "EducationRecord", OfficeWelcome.constants2);
        entityCaptionPanel.setCaptionHTML("US Education Details");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject educationRecord = new JSONObject();
        assignEntityValueFromField("degreeOfStudy", educationRecord);
        assignEntityValueFromField("nameOfSchool", educationRecord);
        assignEntityValueFromField("typeOfUSDegree", educationRecord);
        assignEntityValueFromField("dateDegreeAwarded", educationRecord);
        educationRecord.put("address", new JSONString(setAddress()));
        entity.put("usEducRec", educationRecord);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        JSONObject entity = populateEntityFromFields();
        HttpService.HttpServiceAsync.instance().doPut(updateUSEduInfo(), entity.toString(),
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
        JSONObject educRec;
        if (entity.containsKey("usEducRec")) {
            educRec = entity.get("usEducRec").isObject();
        } else {
            educRec = new JSONObject();
        }
        assignFieldValueFromEntity("degreeOfStudy", educRec, DataType.STRING_FIELD);
        assignFieldValueFromEntity("nameOfSchool", educRec, DataType.STRING_FIELD);
        assignFieldValueFromEntity("typeOfUSDegree", educRec, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateDegreeAwarded", educRec, DataType.DATE_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId, "page1"));
        new ResponseStatusWidget().show("Successfully  Updated US Education Record Info");
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        if (isReadPanel == false) {
            update.setText("Save");
            update.setVisible(true);
        } else {
            update.setVisible(false);
        }
        for (Map.Entry<String, BaseField> e : fields.entrySet()) {
            if (e.getValue() instanceof BaseFieldWithTextBox) {
                setVisibleLengthSize(e.getKey(), 25);
            }
        }
        configureLabelNames();
    }

    protected void configureLabel(Label l) {
        l.removeStyleName("tfFieldHeader");
        l.setVisible(true);
    }

    private void configureLabelNames() {
        StringField degreeOfStudy = (StringField) fields.get("degreeOfStudy");
        configureLabel(degreeOfStudy.getLabel());
        StringField nameOfSchool = (StringField) fields.get("nameOfSchool");
        configureLabel(nameOfSchool.getLabel());
        StringField typeOfUSDegree = (StringField) fields.get("typeOfUSDegree");
        configureLabel(typeOfUSDegree.getLabel());
        DateField dateDegreeAwarded = (DateField) fields.get("dateDegreeAwarded");
        configureLabel(dateDegreeAwarded.getLabel());
    }

    @Override
    protected void addWidgets() {
        addField("degreeOfStudy", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("nameOfSchool", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        addField("typeOfUSDegree", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 3);
        addField("dateDegreeAwarded", isReadPanel, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 2, 1);
        alignFields(200);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected String getEducatnRecInfo() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-1?invitationCode=" + entityId;
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getEducatnRecInfo(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String response) {
                        if (!response.trim().contains("<html>")) {
                            entity = (JSONObject) JSONParser.parseLenient(response);
                            populateFieldsFromEntity(entity);
                            if (entity.containsKey("usEducRec")) {
                                JSONObject educRec = entity.get("usEducRec").isObject();
                                if (educRec.get("address") != null) {
                                    String address = educRec.get("address").isString().stringValue();
                                    assignAddressFieldsFromEntity(address);
                                }
                            } else {
                                addAddress();
                            }
                        } else {
                            entity = new JSONObject();
                        }
                    }
                });
    }

    protected String updateUSEduInfo() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/save-us-edu-info/" + entityId;
    }

    @Override
    protected String getURI() {
        return null;
    }

    private void assignAddressFieldsFromEntity(String address) {
        if (address != null) {
            JSONObject addressObj = getAddress(address);
            addField("street1", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 2);
            addField("street2", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 3);
            addField("city", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 3, 1);
            addEnumField("country", isReadPanel, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL, 3, 2);
            JSONValue service = addressObj.get("country");
            switch (service.isString().stringValue()) {
                case "USA":
                    addEnumField("state", isReadPanel, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 3, 3);
                    break;
                case "INDIA":
                    addEnumField("state", isReadPanel, true, IndiaStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 3, 3);
                    break;
                case "CANADA":
                    addEnumField("state", isReadPanel, true, CanadaStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 3, 3);
                    break;
            }
            addField("zip", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 4, 1);
            doAlignFields(200);
            assignFieldValueFromEntity("street1", addressObj, DataType.STRING_FIELD);
            assignFieldValueFromEntity("street2", addressObj, DataType.STRING_FIELD);
            assignFieldValueFromEntity("zip", addressObj, DataType.STRING_FIELD);
            assignFieldValueFromEntity("city", addressObj, DataType.STRING_FIELD);
            assignFieldValueFromEntity("state", addressObj, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("country", addressObj, DataType.ENUM_FIELD);
            doConfigureAddress();
            alignFields();
        }else{
            addField("street1", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 2);
            addField("street2", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 3);
            addField("city", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 3, 1);
            addEnumField("country", isReadPanel, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL, 3, 2);
            addField("state", isReadPanel, true, DataType.ENUM_FIELD, Alignment.HORIZONTAL, 3, 3);
            addField("zip", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 4, 1);
            countriesF = (EnumField) fields.get("country");
            statesF = (EnumField) fields.get("state");
            doConfigureAddress();
            doAlignFields(200);
        }
    }

    private JSONObject getAddress(String address) {
        String[] addresses = address.split("-");
        JSONObject addressObj = new JSONObject();
        addressObj.put("street1", new JSONString(addresses[0]));
        addressObj.put("street2", new JSONString(addresses[1]));
        addressObj.put("city", new JSONString(addresses[2]));
        addressObj.put("country", new JSONString(addresses[3]));
        addressObj.put("state", new JSONString(addresses[4]));
        addressObj.put("zip", new JSONString(addresses[5]));
        return addressObj;
    }

    private String setAddress() {
        String address = "";
        StringField street1 = (StringField) fields.get("street1");
        StringField street2 = (StringField) fields.get("street2");
        StringField city = (StringField) fields.get("city");
        EnumField country = (EnumField) fields.get("country");
        EnumField state = (EnumField) fields.get("state");
        StringField zip = (StringField) fields.get("zip");
        address = address.concat(street1.getValue().trim()) + "-" + address.concat(street2.getValue().trim()) + "-" + address.concat(city.getValue().trim()) + "-" + address.concat(country.getValue().trim()) + "-" + address.concat(state.getValue().trim()) + "-" + address.concat(zip.getValue().trim());
        return address;
    }
    
    private void addAddress() {
        addField("street1", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 2);
        addField("street2", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 3);
        addField("city", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 3, 1);
        addField("state", isReadPanel, true, DataType.ENUM_FIELD, Alignment.HORIZONTAL, 3, 3);
        addEnumField("country", isReadPanel, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL, 3, 2);
        addEnumField("state", isReadPanel, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 3, 3);
        addField("zip", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 4, 1);
        statesF = (EnumField) fields.get("state");
        if (isReadPanel == false) {
            countriesF = (EnumField) fields.get("country");
            countriesF.listBox.addChangeHandler(this);
            String service = countriesF.getValue();
            switch (service) {
                case "USA":
                    addEnumField("state", isReadPanel, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 3, 3);
                    break;
                case "INDIA":
                    addEnumField("state", isReadPanel, true, IndiaStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 3, 3);
                    break;
                case "CANADA":
                    addEnumField("state", isReadPanel, true, CanadaStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 3, 3);
                    break;
            }
        }
        doConfigureAddress();
        doAlignFields(200);
    }
    
    private void doConfigureAddress(){
        StringField street1 = (StringField) fields.get("street1");
        configureLabel(street1.getLabel());
        StringField street2 = (StringField) fields.get("street2");
        configureLabel(street2.getLabel());
        StringField city = (StringField) fields.get("city");
        configureLabel(city.getLabel());
        EnumField state = (EnumField) fields.get("state");
        configureLabel(state.getLabel());
        EnumField country = (EnumField) fields.get("country");
        configureLabel(country.getLabel());
        StringField zip = (StringField) fields.get("zip");
        configureLabel(zip.getLabel());
    }

    @Override
    public void onChange(ChangeEvent event) {
        switch (countriesF.getValue()) {
            case "USA":
                statesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                break;
            case "INDIA":
                statesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                break;
            case "CANADA":
                statesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                break;
        }
    }
}
