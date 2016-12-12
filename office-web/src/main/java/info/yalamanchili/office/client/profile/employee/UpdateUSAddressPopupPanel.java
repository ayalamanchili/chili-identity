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
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.LongField;
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
public class UpdateUSAddressPopupPanel extends TUpdateComposite implements ChangeHandler {

    private static Logger logger = Logger.getLogger(UpdateUSAddressPopupPanel.class.getName());
    boolean isReadPanel = false;
    
    public UpdateUSAddressPopupPanel(String entityId) {
        initUpdateComposite(entityId, "Address", OfficeWelcome.constants2);
    }

    public UpdateUSAddressPopupPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "Address", OfficeWelcome.constants2);
        entityCaptionPanel.setCaptionHTML("Current US Address");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONArray addrArray = new JSONArray();
        JSONObject usAddrObj = new JSONObject();
        assignEntityValueFromField("street1", usAddrObj);
        assignEntityValueFromField("street2", usAddrObj);
        assignEntityValueFromField("city", usAddrObj);
        assignEntityValueFromField("state", usAddrObj);
        assignEntityValueFromField("country", usAddrObj);
        assignEntityValueFromField("zip", usAddrObj);
        assignEntityValueFromField("phoneNumber", usAddrObj);
        assignEntityValueFromField("workPhone", usAddrObj);
        assignEntityValueFromField("isHomeAddress", usAddrObj);
        addrArray.set(0, usAddrObj);
        entity.put("usForeignAddrInfo", addrArray);
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
        if (entity.containsKey("usForeignAddrInfo")) {
            JSONArray usAddrArray;
            JSONObject usAddrObj;
            if (entity.get("usForeignAddrInfo") instanceof JSONArray) {
                usAddrArray = entity.get("usForeignAddrInfo").isArray();
                for (int i = 0; i < usAddrArray.size(); i++) {
                    usAddrObj = usAddrArray.get(i).isObject();
                    if (getAddressType(usAddrObj).equals("US")) {
                        populateFields(usAddrObj);
                    }
                }
            } else if (entity.get("usForeignAddrInfo") instanceof JSONObject) {
                usAddrObj = entity.get("usForeignAddrInfo").isObject();
                if (getAddressType(usAddrObj).equals("US")) {
                    populateFields(usAddrObj);
                }
            }
        }
    }

    private String getAddressType(JSONObject address) {
        if (address != null) {
            return address.get("addressType").isObject().get("addressType").isString().stringValue();
        } else {
            return null;
        }
    }

    private void populateFields(JSONObject address) {
        assignFieldValueFromEntity("street1", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("street2", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("zip", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("city", address, DataType.STRING_FIELD);
        assignFieldValueFromEntity("state", address, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("country", address, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("phoneNumber", address, DataType.LONG_FIELD);
        assignFieldValueFromEntity("workPhone", address, DataType.LONG_FIELD);
        BooleanField isHomeAddress = (BooleanField) fields.get("isHomeAddress");
        if ("true".equalsIgnoreCase(JSONUtils.toString(address, "isHomeAddress"))) {
            isHomeAddress.setValue(true);
        } else if ("false".equalsIgnoreCase(JSONUtils.toString(address, "isHomeAddress"))) {
            isHomeAddress.setValid(false);
        }
    }


    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId, "page3"));
        new ResponseStatusWidget().show("Successfully  Updated US Address Information");
    }

    @Override
    protected void addListeners() {
        if (usCountriesF != null) {
            usCountriesF.listBox.addChangeHandler(this);
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
        LongField phoneNumber = (LongField) fields.get("phoneNumber");
        configureLabel(phoneNumber.getLabel());
        LongField workPhone = (LongField) fields.get("workPhone");
        configureLabel(workPhone.getLabel());
    }

    EnumField usStatesF;
    EnumField usCountriesF;

    @Override
    protected void addWidgets() {
        addField("street1", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("street2", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        addField("city", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 3);
        addEnumField("state", isReadPanel, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 2, 2);
        addEnumField("country", isReadPanel, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL, 2, 1);
        addField("zip", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 3);

        if (isReadPanel == false) {
            usStatesF = (EnumField) fields.get("state");
            usCountriesF = (EnumField) fields.get("country");
            usCountriesF.listBox.addChangeHandler(this);
            String service = usCountriesF.getValue();
            switch (service) {
                case "USA":
                    usStatesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "INDIA":
                    usStatesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "CANADA":
                    usStatesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                    break;
            }
        }
        addField("phoneNumber", isReadPanel, true, DataType.LONG_FIELD, Alignment.HORIZONTAL, 3, 1);
        addField("workPhone", isReadPanel, true, DataType.LONG_FIELD, Alignment.HORIZONTAL, 3, 2);
        addField("isHomeAddress", isReadPanel, true, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL, 3, 3);
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

    protected String updatePersonalInfo() {
        return URL.encode(OfficeWelcome.constants.root_url() + "address-info/save-us-address-info/" + entityId);
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (usCountriesF != null) {
            switch (usCountriesF.getValue()) {
                case "USA":
                    usStatesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "INDIA":
                    usStatesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "CANADA":
                    usStatesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                    break;
            }
        }
    }
}