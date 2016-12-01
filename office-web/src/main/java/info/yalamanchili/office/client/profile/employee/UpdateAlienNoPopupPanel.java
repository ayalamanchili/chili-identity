/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
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
import info.yalamanchili.office.client.resources.OfficeImages;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class UpdateAlienNoPopupPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateAlienNoPopupPanel.class.getName());

    Button saveNextAlien = new Button("Save and Next");
    boolean saveNextalienValue = false;

    public UpdateAlienNoPopupPanel(String entityId) {
        initUpdateComposite(entityId, "AlienNo", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject alienNoObj = new JSONObject();
        assignEntityValueFromField("alienNumber", alienNoObj);
        entity.put("alienNumber", alienNoObj);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        JSONObject entity = populateEntityFromFields();
        HttpService.HttpServiceAsync.instance().doPut(updateAlienNumber(), entity.toString(),
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
        if (entity.containsKey("alienNumber")) {
            JSONObject alienNumber = entity.get("alienNumber").isObject();
            assignFieldValueFromEntity("alienNumber", alienNumber, DataType.STRING_FIELD);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId));
        if (saveNextalienValue == true) {
            new GenericPopup(new UpdateEducationRecord1PopupPanel(entityId), 200, 200).show();
        }
        new ResponseStatusWidget().show("Successfully  Updated Alien Number");
    }

    @Override
    protected void addListeners() {
        saveNextAlien.addClickHandler(this);
    }

    @Override
    protected void configure() {
        update.setText("Save");
    }

    @Override
    protected void addWidgets() {
        addField("alienNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityActionsPanel.add(saveNextAlien);
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

    protected String updateAlienNumber() {
        return URL.encode(OfficeWelcome.constants.root_url() + "immigrationcase/save-alien-info/" + entityId);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(saveNextAlien)) {
            saveNextalienValue = true;
            updateButtonClicked();
        }
        super.onClick(event);
    }
}
