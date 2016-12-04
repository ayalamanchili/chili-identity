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
public class UpdateI94InfoPanel extends TUpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateI94InfoPanel.class.getName());
    boolean isReadPanel = false;

    public UpdateI94InfoPanel(String entityId) {
        initUpdateComposite(entityId, "I94Info", OfficeWelcome.constants2);
    }

    public UpdateI94InfoPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "I94Info", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject i94InfoObj = new JSONObject();
        assignEntityValueFromField("i94RecordNumber", i94InfoObj);
        assignEntityValueFromField("presentNonImmiStatus", i94InfoObj);
        assignEntityValueFromField("dateOfLastArrival", i94InfoObj);
        assignEntityValueFromField("i94ValidFromDate", i94InfoObj);
        assignEntityValueFromField("statusDateExpires", i94InfoObj);
        entity.put("i94Info", i94InfoObj);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        JSONObject entity = populateEntityFromFields();
        HttpService.HttpServiceAsync.instance().doPut(updateI94Info(), entity.toString(),
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
        JSONObject i94Info = entity.get("i94Info").isObject();
        assignFieldValueFromEntity("i94RecordNumber", i94Info, DataType.STRING_FIELD);
        assignFieldValueFromEntity("presentNonImmiStatus", i94Info, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfLastArrival", i94Info, DataType.DATE_FIELD);
        assignFieldValueFromEntity("i94ValidFromDate", i94Info, DataType.DATE_FIELD);
        assignFieldValueFromEntity("statusDateExpires", i94Info, DataType.DATE_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId));
        new ResponseStatusWidget().show("Successfully  Updated I-94 Information");
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
        StringField i94Number = (StringField) fields.get("i94RecordNumber");
        configureLabel(i94Number.getLabel());
        DateField dateOfLastArr = (DateField) fields.get("dateOfLastArrival");
        configureLabel(dateOfLastArr.getLabel());
        DateField i94ValidDate = (DateField) fields.get("i94ValidFromDate");
        configureLabel(i94ValidDate.getLabel());
        DateField statusDateExp = (DateField) fields.get("statusDateExpires");
        configureLabel(statusDateExp.getLabel());
        StringField nonImgStatus = (StringField) fields.get("presentNonImmiStatus");
        configureLabel(nonImgStatus.getLabel());

    }

    @Override
    protected void addWidgets() {
        addField("i94RecordNumber", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("dateOfLastArrival", isReadPanel, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 1, 2);
        addField("presentNonImmiStatus", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 3);
        addField("i94ValidFromDate", isReadPanel, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 2, 1);
        addField("statusDateExpires", isReadPanel, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 2, 2);
        alignFields(200);
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

    protected String updateI94Info() {
        return URL.encode(OfficeWelcome.constants.root_url() + "immigrationcase/save-I94-info/" + entityId);
    }
}
