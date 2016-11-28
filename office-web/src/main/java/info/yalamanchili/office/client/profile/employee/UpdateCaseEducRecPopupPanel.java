/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
import info.yalamanchili.office.client.profile.address.UpdateAddressPanel;
import info.yalamanchili.office.client.profile.address.UpdateAddressWidget;
import info.yalamanchili.office.client.resources.OfficeImages;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateCaseEducRecPopupPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateCaseEducRecPopupPanel.class.getName());
    UpdateAddressWidget updateAddressWidget;
    CreateAddressWidget createAddrWidget;

    public UpdateCaseEducRecPopupPanel(String entityId) {
        initUpdateComposite(entityId, "EducationRecord", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject educationRecord = new JSONObject();
        assignEntityValueFromField("degreeOfStudy", educationRecord);
        assignEntityValueFromField("nameOfSchool", educationRecord);
        assignEntityValueFromField("typeOfUSDegree", educationRecord);
        assignEntityValueFromField("dateDegreeAwarded", educationRecord);
        if (updateAddressWidget != null) {
            JSONObject address = updateAddressWidget.populateEntityFromFields();
            String addressStr = getAddress(address);
            educationRecord.put("address", new JSONString(addressStr));
        }
        if (createAddrWidget != null) {
            JSONObject address = createAddrWidget.populateEntityFromFields();
            String addressStr = getAddress(address);
            educationRecord.put("address", new JSONString(addressStr));
        }
        entity.put("usEducRec", educationRecord);
        return entity;

    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(updateUSEduInfo(), entity.toString(),
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
        JSONObject educRec;
        if (entity.containsKey("usEducRec")) {
            educRec = entity.get("usEducRec").isObject();
        } else {
            educRec = new JSONObject();
        }
        assignFieldValueFromEntity("degreeOfStudy", educRec, DataType.STRING_FIELD);
        assignFieldValueFromEntity("nameOfSchool", educRec, DataType.STRING_FIELD);
        assignFieldValueFromEntity("typeOfUSDegree", educRec, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateDegreeAwarded", educRec, DataType.DATE_FIELD);
        if (educRec.containsKey("address") && educRec.get("address").isString().stringValue() != null) {
            JSONObject address = new JSONObject();
            String[] adressArr = educRec.get("address").isString().stringValue().split("-");
            if (adressArr.length == 5) {
                address.put("street1", new JSONString(adressArr[0].trim()));
                address.put("street2", new JSONString(""));
                address.put("city", new JSONString(adressArr[1].trim()));
                address.put("state", new JSONString(adressArr[2].trim()));
                address.put("country", new JSONString(adressArr[3].trim()));
                address.put("zip", new JSONString(adressArr[4].trim()));
            } else if (adressArr.length == 6) {
                address.put("street1", new JSONString(adressArr[0].trim()));
                address.put("street2", new JSONString(adressArr[1].trim()));
                address.put("city", new JSONString(adressArr[2].trim()));
                address.put("state", new JSONString(adressArr[3].trim()));
                address.put("country", new JSONString(adressArr[4].trim()));
                address.put("zip", new JSONString(adressArr[5].trim()));
            }
            updateAddressWidget = new UpdateAddressWidget(address, UpdateAddressPanel.UpdateAddressPanelType.MIN, false);
            entityFieldsPanel.add(updateAddressWidget);
        } else {
            createAddrWidget = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
            entityFieldsPanel.add(createAddrWidget);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId));
        new ResponseStatusWidget().show("Successfully  Updated US Education Record Info");
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("degreeOfStudy", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("nameOfSchool", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("typeOfUSDegree", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateDegreeAwarded", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected String getEducatnRecInfo() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/?invitationCode=" + entityId;
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getEducatnRecInfo(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String response) {
                        if (!response.trim().contains("<html>")) {
                            entity = (JSONObject) JSONParser.parseLenient(response);
                            populateFieldsFromEntity(entity);
                        } else {
                            entity = new JSONObject();
                        }
                    }
                });
    }

    protected String updateUSEduInfo() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/save-us-edu-info/" + entityId;
    }

    @Override
    protected String getURI() {
        return null;
    }

    private String getAddress(JSONObject address) {
        if (address.containsKey("street2")) {
            return address.get("street1").isString().stringValue().trim() + "-" + address.get("street2").isString().stringValue().trim() + "-" + address.get("city").isString().stringValue().trim() + "-" + address.get("state").isString().stringValue().trim() + "-" + address.get("country").isString().stringValue().trim() + "-" + address.get("zip").isString().stringValue().trim();
        } else {
            return address.get("street1").isString().stringValue().trim() + "-" + address.get("city").isString().stringValue().trim() + "-" + address.get("state").isString().stringValue().trim() + "-" + address.get("country").isString().stringValue().trim() + "-" + address.get("zip").isString().stringValue().trim();
        }
    }
}
