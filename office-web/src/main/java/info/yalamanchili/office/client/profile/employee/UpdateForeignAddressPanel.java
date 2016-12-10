/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
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
import info.chili.gwt.data.CanadaStatesFactory;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
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
public class UpdateForeignAddressPanel extends TUpdateComposite implements ChangeHandler {

    private static Logger logger = Logger.getLogger(UpdateForeignAddressPanel.class.getName());
    boolean isReadPanel = false;

    public UpdateForeignAddressPanel(String entityId) {
        initUpdateComposite(entityId, "Address", OfficeWelcome.constants);
    }

    public UpdateForeignAddressPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "Address", OfficeWelcome.constants);
        entityCaptionPanel.setCaptionHTML("Foreign Address");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject foreignAddr = new JSONObject();
        JSONArray foreignAddrArray = new JSONArray();
        assignEntityValueFromField("street1", foreignAddr);
        assignEntityValueFromField("street2", foreignAddr);
        assignEntityValueFromField("city", foreignAddr);
        assignEntityValueFromField("state", foreignAddr);
        assignEntityValueFromField("country", foreignAddr);
        assignEntityValueFromField("zip", foreignAddr);
        foreignAddrArray.set(0, foreignAddr);
        entity.put("usForeignAddrInfo", foreignAddr);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        JSONObject entity = populateEntityFromFields();
        HttpService.HttpServiceAsync.instance().doPut(updateForeignAddrInfo(), entity.toString(),
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
        if (entity.containsKey("usForeignAddrInfo")) {
            JSONArray usAddrArray;
            JSONObject foreignAddrObj;
            if (entity.get("usForeignAddrInfo") instanceof JSONArray) {
                usAddrArray = entity.get("usForeignAddrInfo").isArray();
                for (int i = 0; i < usAddrArray.size(); i++) {
                    foreignAddrObj = usAddrArray.get(i).isObject();
                    if (foreignAddrObj != null && foreignAddrObj.get("addressType").isObject().get("addressType").isString().stringValue().equalsIgnoreCase("foreign")) {
                        populateFields(foreignAddrObj);
                    }
                }
            } else {
                foreignAddrObj = entity.get("usForeignAddrInfo").isObject();
                if (foreignAddrObj != null && foreignAddrObj.get("addressType").isObject().get("addressType").isString().stringValue().equalsIgnoreCase("foreign")) {
                    populateFields(foreignAddrObj);
                }
            }
        }
    }

    private void populateFields(JSONObject address) {
        assignFieldValueFromEntity("street1", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("street2", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("zip", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("city", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("country", address, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("state", address, DataType.ENUM_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId, "page3"));
        new ResponseStatusWidget().show("Successfully Updated Foreign Address Information");
    }

    @Override
    protected void addListeners() {
        if (foreignCountriesF != null) {
            foreignCountriesF.listBox.addChangeHandler(this);
        }
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
        StringField street1 = (StringField) fields.get("street1");
        configureLabel(street1.getLabel());
        StringField street2 = (StringField) fields.get("street2");
        configureLabel(street2.getLabel());
        StringField city = (StringField) fields.get("city");
        configureLabel(city.getLabel());
        if (fields.get("state") instanceof EnumField) {
            EnumField state = (EnumField) fields.get("state");
            configureLabel(state.getLabel());
        }
        if (fields.get("state") instanceof StringField) {
            StringField state = (StringField) fields.get("state");
            configureLabel(state.getLabel());
        }
        EnumField country = (EnumField) fields.get("country");
        configureLabel(country.getLabel());
        StringField zip = (StringField) fields.get("zip");
        configureLabel(zip.getLabel());
    }
    EnumField foreignStatesF;
    EnumField foreignCountriesF;

    @Override
    protected void addWidgets() {
        addField("street1", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("street2", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        addField("city", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 3);
        addEnumField("state", isReadPanel, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 2, 2);
        addEnumField("country", isReadPanel, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL, 2, 1);
        addField("zip", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 3);
        if (isReadPanel == false) {
            foreignStatesF = (EnumField) fields.get("state");
            foreignCountriesF = (EnumField) fields.get("country");
            foreignCountriesF.listBox.addChangeHandler(this);
            String service = foreignCountriesF.getValue();
            switch (service) {
                case "USA":
                    foreignStatesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "INDIA":
                    foreignStatesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "CANADA":
                    foreignStatesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                    break;
            }
        }
        doAlignFields(200);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-3?invitationCode=" + entityId;
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

    protected String updateForeignAddrInfo() {
        return URL.encode(OfficeWelcome.constants.root_url() + "address-info/save-foreign-address-info/" + entityId);
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (foreignCountriesF != null) {
            switch (foreignCountriesF.getValue()) {
                case "USA":
                    foreignStatesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "INDIA":
                    foreignStatesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "CANADA":
                    foreignStatesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                    break;
            }
        }
    }
}