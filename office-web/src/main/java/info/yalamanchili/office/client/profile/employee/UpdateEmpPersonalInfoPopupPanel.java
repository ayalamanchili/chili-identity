/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.crud.TUpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.onboarding.MaritalStatus;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.resources.OfficeImages;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateEmpPersonalInfoPopupPanel extends TUpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateEmpPersonalInfoPopupPanel.class.getName());
    boolean isReadPanel = false;

    public UpdateEmpPersonalInfoPopupPanel(String entityId) {
        initUpdateComposite(entityId, "PersonalInfo", OfficeWelcome.constants2);
    }

    public UpdateEmpPersonalInfoPopupPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "PersonalInfo", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject personalInfoObj = new JSONObject();
        assignEntityValueFromField("empLastName", personalInfoObj);
        assignEntityValueFromField("empFirstName", personalInfoObj);
        assignEntityValueFromField("middleInitial", personalInfoObj);
        assignEntityValueFromField("gender", personalInfoObj);
        assignEntityValueFromField("maritalStatus", personalInfoObj);
        assignEntityValueFromField("email", personalInfoObj);
        assignEntityValueFromField("workEmail", personalInfoObj);
        assignEntityValueFromField("ssn", personalInfoObj);
        assignEntityValueFromField("dateOfBirth", personalInfoObj);
        entity.put("empPersonalInfo", personalInfoObj);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        JSONObject entity = populateEntityFromFields();
        HttpService.HttpServiceAsync.instance().doPut(updatePersonalInfo(), entity.toString(),
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
        JSONObject empPersoanlInfo = entity.get("empPersonalInfo").isObject();
        assignFieldValueFromEntity("empLastName", empPersoanlInfo, DataType.STRING_FIELD);
        assignFieldValueFromEntity("empFirstName", empPersoanlInfo, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", empPersoanlInfo, DataType.STRING_FIELD);
        assignFieldValueFromEntity("gender", empPersoanlInfo, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("maritalStatus", empPersoanlInfo, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("email", empPersoanlInfo, DataType.STRING_FIELD);
        assignFieldValueFromEntity("workEmail", empPersoanlInfo, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ssn", empPersoanlInfo, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", empPersoanlInfo, DataType.DATE_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId));
        new ResponseStatusWidget().show("Successfully  Updated Employee Personal Info");
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
        configureLabelNames();
        for (Map.Entry<String, BaseField> e : fields.entrySet()) {
            if (e.getValue() instanceof BaseFieldWithTextBox) {
                setVisibleLengthSize(e.getKey(), 25);
            }
        }
    }

    protected void configureLabel(Label l) {
        l.removeStyleName("tfFieldHeader");
        l.setVisible(true);
    }

    private void configureLabelNames() {
        StringField empLastName = (StringField) fields.get("empLastName");
        configureLabel(empLastName.getLabel());
        StringField empFirstName = (StringField) fields.get("empFirstName");
        configureLabel(empFirstName.getLabel());
        StringField middleInitial = (StringField) fields.get("middleInitial");
        configureLabel(middleInitial.getLabel());
        StringField email = (StringField) fields.get("email");
        configureLabel(email.getLabel());
        DateField dateOfBirth = (DateField) fields.get("dateOfBirth");
        configureLabel(dateOfBirth.getLabel());
        EnumField gender = (EnumField) fields.get("gender");
        configureLabel(gender.getLabel());
        EnumField maritalStatus = (EnumField) fields.get("maritalStatus");
        configureLabel(maritalStatus.getLabel());
        StringField workEmail = (StringField) fields.get("workEmail");
        configureLabel(workEmail.getLabel());
        StringField ssn = (StringField) fields.get("ssn");
        configureLabel(ssn.getLabel());
    }

    @Override
    protected void addWidgets() {
        addField("empLastName", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("empFirstName", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        addField("middleInitial", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 3);
        addField("email", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 1);
        addField("workEmail", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 2);
        addField("ssn", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 3);
        addEnumField("gender", isReadPanel, true, Sex.names(), Alignment.HORIZONTAL, 3, 1);
        addEnumField("maritalStatus", isReadPanel, true, MaritalStatus.names(), Alignment.HORIZONTAL, 3, 2);
        addField("dateOfBirth", isReadPanel, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 3, 3);
        doAlignFields(200);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-1?invitationCode=" + entityId;
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.trim().contains("<html>")) {
                            entity = (JSONObject) JSONParser.parseLenient(response);
                            populateFieldsFromEntity(entity);
                        } else {
                            entity = new JSONObject();
                        }
                    }
                });
    }

    protected String updatePersonalInfo() {
        return URL.encode(OfficeWelcome.constants.root_url() + "immigrationcase/save-personal-info/" + entityId);
    }
}
