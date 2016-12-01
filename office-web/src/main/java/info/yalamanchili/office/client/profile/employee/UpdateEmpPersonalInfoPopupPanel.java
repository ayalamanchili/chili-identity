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
import com.google.gwt.user.client.ui.RootPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.onboarding.MaritalStatus;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.resources.OfficeImages;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateEmpPersonalInfoPopupPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateEmpPersonalInfoPopupPanel.class.getName());
    boolean isReadPanel = false;

    public UpdateEmpPersonalInfoPopupPanel(String entityId) {
        initUpdateComposite(entityId, "PersonalInfo", OfficeWelcome.constants);
    }

    public UpdateEmpPersonalInfoPopupPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "PersonalInfo", OfficeWelcome.constants);
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
    }

    @Override
    protected void addWidgets() {
        addField("empLastName", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("empFirstName", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("gender", isReadPanel, true, Sex.names(), Alignment.HORIZONTAL);
        addEnumField("maritalStatus", isReadPanel, true, MaritalStatus.names(), Alignment.HORIZONTAL);
        addField("email", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("workEmail", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ssn", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", isReadPanel, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
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