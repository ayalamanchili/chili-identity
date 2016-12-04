/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

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
public class UpdateOtherNamesInfoPopupPanel extends TUpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateOtherNamesInfoPopupPanel.class.getName());
    boolean isReadPanel = false;

    public UpdateOtherNamesInfoPopupPanel(String entityId) {
        initUpdateComposite(entityId, "OtherNamesInfo", OfficeWelcome.constants2);
    }

    public UpdateOtherNamesInfoPopupPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "OtherNamesInfo", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject otherNamesInfoObj = new JSONObject();
        assignEntityValueFromField("firstName", otherNamesInfoObj);
        assignEntityValueFromField("lastName", otherNamesInfoObj);
        assignEntityValueFromField("middleName", otherNamesInfoObj);
        entity.put("otherNamesInfo", otherNamesInfoObj);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(updateOtherNamesInfo(), entity.toString(),
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
        if (entity.containsKey("otherNamesInfo")) {
            JSONObject empPersoanlInfo = entity.get("otherNamesInfo").isObject();
            assignFieldValueFromEntity("firstName", empPersoanlInfo, DataType.STRING_FIELD);
            assignFieldValueFromEntity("lastName", empPersoanlInfo, DataType.STRING_FIELD);
            assignFieldValueFromEntity("middleName", empPersoanlInfo, DataType.STRING_FIELD);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId, "page1"));
        new ResponseStatusWidget().show("Successfully  Updated Other Names Info");
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
        StringField firstName = (StringField) fields.get("firstName");
        configureLabel(firstName.getLabel());
        StringField lastName = (StringField) fields.get("lastName");
        configureLabel(lastName.getLabel());
        StringField middleName = (StringField) fields.get("middleName");
        configureLabel(middleName.getLabel());
    }

    @Override
    protected void addWidgets() {
        addField("firstName", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("lastName", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        addField("middleName", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 3);
        alignFields(200);
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

    protected String updateOtherNamesInfo() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/save-other-names-info/" + entityId;
    }
}
