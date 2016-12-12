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
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.fields.DataType;
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
 * @author Ramana.Lukalapu
 */
public class UpdateConsulateInfoPanel extends TUpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateConsulateInfoPanel.class.getName());
    boolean isReadPanel = false;

    public UpdateConsulateInfoPanel(String entityId) {
        initUpdateComposite(entityId, "ConsulateInfo", OfficeWelcome.constants2);
    }

    public UpdateConsulateInfoPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "ConsulateInfo", OfficeWelcome.constants2);
        entityCaptionPanel.setCaptionHTML("Consulate Information");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject consulateInfoObj = new JSONObject();
        assignEntityValueFromField("city", consulateInfoObj);
        assignEntityValueFromField("country", consulateInfoObj);
        entity.put("consulateInfo", consulateInfoObj);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        JSONObject entity = populateEntityFromFields();
        HttpService.HttpServiceAsync.instance().doPut(updateConsulateInfo(), entity.toString(),
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
        if (entity.containsKey("consulateInfo")) {
            JSONObject consulateInfo = entity.get("consulateInfo").isObject();
            assignFieldValueFromEntity("city", consulateInfo, DataType.STRING_FIELD);
            assignFieldValueFromEntity("country", consulateInfo, DataType.ENUM_FIELD);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId, "page5"));
        new ResponseStatusWidget().show("Successfully  Updated Consulate Information");
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
        StringField sevisNum = (StringField) fields.get("city");
        configureLabel(sevisNum.getLabel());
        EnumField eadNum = (EnumField) fields.get("country");
        configureLabel(eadNum.getLabel());

    }

    @Override
    protected void addWidgets() {
        addField("city", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addEnumField("country", isReadPanel, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL, 1, 2);
        alignFields(150);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-5?invitationCode=" + entityId;
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

    protected String updateConsulateInfo() {
        return URL.encode(OfficeWelcome.constants.root_url() + "consulate-info/save-consulate-info/" + entityId);
    }
}
