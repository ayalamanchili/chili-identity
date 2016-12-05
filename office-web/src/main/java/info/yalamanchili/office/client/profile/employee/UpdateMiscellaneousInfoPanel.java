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
 * @author Ramana.Lukalapu
 */
public class UpdateMiscellaneousInfoPanel extends TUpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateMiscellaneousInfoPanel.class.getName());
    boolean isReadPanel = false;

    public UpdateMiscellaneousInfoPanel(String entityId) {
        initUpdateComposite(entityId, "MiscellaneousInfo", OfficeWelcome.constants2);
    }

    public UpdateMiscellaneousInfoPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "MiscellaneousInfo", OfficeWelcome.constants2);
        entityCaptionPanel.setCaptionHTML("Miscellaneous Information");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject miscellaneousInfoObj = new JSONObject();
        assignEntityValueFromField("sevisNumber", miscellaneousInfoObj);
        assignEntityValueFromField("eadNumber", miscellaneousInfoObj);
        entity.put("misceInfo", miscellaneousInfoObj);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        JSONObject entity = populateEntityFromFields();
        HttpService.HttpServiceAsync.instance().doPut(updateMisceInfo(), entity.toString(),
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
        if (entity.containsKey("misceInfo")) {
            JSONObject miscellaneousInfo = entity.get("misceInfo").isObject();
            assignFieldValueFromEntity("sevisNumber", miscellaneousInfo, DataType.STRING_FIELD);
            assignFieldValueFromEntity("eadNumber", miscellaneousInfo, DataType.STRING_FIELD);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId, "page2"));
        new ResponseStatusWidget().show("Successfully  Updated Miscellaneous Information");
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
                setVisibleLengthSize(e.getKey(), 20);
            }
        }
    }

    protected void configureLabel(Label l) {
        l.removeStyleName("tfFieldHeader");
        l.setVisible(true);
    }

    private void configureLabelNames() {
        StringField sevisNum = (StringField) fields.get("sevisNumber");
        configureLabel(sevisNum.getLabel());
        StringField eadNum = (StringField) fields.get("eadNumber");
        configureLabel(eadNum.getLabel());

    }

    @Override
    protected void addWidgets() {
        addField("sevisNumber", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("eadNumber", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 1);
        alignFields(500);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-2?invitationCode=" + entityId;
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

    protected String updateMisceInfo() {
        return URL.encode(OfficeWelcome.constants.root_url() + "miscellaneous-info/save-miscellaneous-info/" + entityId);
    }
}