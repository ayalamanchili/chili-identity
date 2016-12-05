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
        initUpdateComposite(entityId, "i94Record", OfficeWelcome.constants2);
    }

    public UpdateI94InfoPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "i94Record", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject i94InfoObj = new JSONObject();
        assignEntityValueFromField("i94RecordNumber", i94InfoObj);
        assignEntityValueFromField("dateofEntry", i94InfoObj);
        assignEntityValueFromField("portOfEntry", i94InfoObj);
        assignEntityValueFromField("i94ValidFromDate", i94InfoObj);
        assignEntityValueFromField("admitUntilDate", i94InfoObj);
        assignEntityValueFromField("classOfAdmission", i94InfoObj);
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
        if (entity.containsKey("i94Info")) {
            JSONObject i94Info = entity.get("i94Info").isObject();
            assignFieldValueFromEntity("i94RecordNumber", i94Info, DataType.STRING_FIELD);
            assignFieldValueFromEntity("dateofEntry", i94Info, DataType.DATE_FIELD);
            assignFieldValueFromEntity("portOfEntry", i94Info, DataType.STRING_FIELD);
            assignFieldValueFromEntity("i94ValidFromDate", i94Info, DataType.DATE_FIELD);
            assignFieldValueFromEntity("admitUntilDate", i94Info, DataType.DATE_FIELD);
            assignFieldValueFromEntity("classOfAdmission", i94Info, DataType.STRING_FIELD);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId, "page2"));
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
        DateField dateofEntry = (DateField) fields.get("dateofEntry");
        configureLabel(dateofEntry.getLabel());
        StringField portOfEntry = (StringField) fields.get("portOfEntry");
        configureLabel(portOfEntry.getLabel());
        DateField i94ValidDate = (DateField) fields.get("i94ValidFromDate");
        configureLabel(i94ValidDate.getLabel());
        DateField admitUntilDate = (DateField) fields.get("admitUntilDate");
        configureLabel(admitUntilDate.getLabel());
        StringField classOfAdmission = (StringField) fields.get("classOfAdmission");
        configureLabel(classOfAdmission.getLabel());
    }

    @Override
    protected void addWidgets() {
        addField("i94RecordNumber", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("dateofEntry", isReadPanel, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 1, 2);
        addField("portOfEntry", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 3);
        addField("i94ValidFromDate", isReadPanel, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 2, 1);
        addField("admitUntilDate", isReadPanel, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 2, 2);
        addField("classOfAdmission", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 3);
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
        return URL.encode(OfficeWelcome.constants.root_url() + "i94record/save-i94-info/" + entityId);
    }
}