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
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.crud.TUpdateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.fields.TextAreaField;
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
public class UpdateRelativesStayPeriodInfo extends TUpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateRelativesStayPeriodInfo.class.getName());
    boolean isReadPanel = false;

    public UpdateRelativesStayPeriodInfo(String entityId) {
        initUpdateComposite(entityId, "RelativesStayInfo", OfficeWelcome.constants2);
    }

    public UpdateRelativesStayPeriodInfo(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "RelativesStayInfo", OfficeWelcome.constants2);
        entityCaptionPanel.setCaptionHTML("Relatives Stay Period Information");
    }

    BooleanField otherCitizenshipL;

    EnumField countryL;

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject relativeStayObj = new JSONObject();
        assignEntityValueFromField("name", relativeStayObj);
        assignEntityValueFromField("fromDate", relativeStayObj);
        assignEntityValueFromField("toDate", relativeStayObj);
        assignEntityValueFromField("immigrantStatus", relativeStayObj);
        assignEntityValueFromField("purpose", relativeStayObj);
        relativeStayObj.put("otherCitizenship", new JSONString(otherCitizenshipL.getValue().toString()));
        assignEntityValueFromField("country", relativeStayObj);
        entity.put("stayPeriodInfo", relativeStayObj);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        JSONObject entity = populateEntityFromFields();
        HttpService.HttpServiceAsync.instance().doPut(updateRelativeStayPeriodInfo(), entity.toString(),
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
        if (entity.containsKey("stayPeriodInfo")) {
            JSONObject relativeStayInfo = entity.get("stayPeriodInfo").isObject();
            assignFieldValueFromEntity("name", relativeStayInfo, DataType.STRING_FIELD);
            assignFieldValueFromEntity("fromDate", relativeStayInfo, DataType.DATE_FIELD);
            assignFieldValueFromEntity("toDate", relativeStayInfo, DataType.DATE_FIELD);
            assignFieldValueFromEntity("immigrantStatus", relativeStayInfo, DataType.STRING_FIELD);
            assignFieldValueFromEntity("purpose", relativeStayInfo, DataType.TEXT_AREA_FIELD);
            if (relativeStayInfo.get("otherCitizenship").isString().stringValue().equalsIgnoreCase("true")) {
                countryL.setVisible(true);
                otherCitizenshipL.setValue(true);
                assignFieldValueFromEntity("country", relativeStayInfo, DataType.ENUM_FIELD);
            } else {
                otherCitizenshipL.setValue(false);
            }
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId, "page5"));
        new ResponseStatusWidget().show("Successfully  Updated Relatives Stay Period Information");
    }

    @Override
    protected void addListeners() {
        otherCitizenshipL.getBox().addClickHandler(this);
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
        countryL.setVisible(false);
    }

    protected void configureLabel(Label l) {
        l.removeStyleName("tfFieldHeader");
        l.setVisible(true);
    }

    private void configureLabelNames() {
        StringField nameL = (StringField) fields.get("name");
        configureLabel(nameL.getLabel());
        DateField fromDateL = (DateField) fields.get("fromDate");
        configureLabel(fromDateL.getLabel());
        DateField toDateL = (DateField) fields.get("toDate");
        configureLabel(toDateL.getLabel());
        countryL = (EnumField) fields.get("country");
        configureLabel(countryL.getLabel());
        StringField immigrantStatusL = (StringField) fields.get("immigrantStatus");
        configureLabel(immigrantStatusL.getLabel());
        TextAreaField purposeL = (TextAreaField) fields.get("purpose");
        configureLabel(purposeL.getLabel());
    }

    @Override
    protected void addWidgets() {
        addField("name", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("fromDate", isReadPanel, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 1, 2);
        addField("toDate", isReadPanel, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 1, 3);
        addField("immigrantStatus", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 1);
        addField("purpose", isReadPanel, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL, 2, 2);
        otherCitizenshipL = new BooleanField(OfficeWelcome.constants2, "During the past five years, have you or any accompanying family members lived in a [[Country]] other than the [[Country]] of your citizenship for more than 6 months?", "RelativesStayInfo", isReadPanel, false, Alignment.HORIZONTAL);
        entityFieldsPanel.setWidget(3, 1, otherCitizenshipL);
        addEnumField("country", isReadPanel, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL, 4, 1);
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

    protected String updateRelativeStayPeriodInfo() {
        return URL.encode(OfficeWelcome.constants.root_url() + "stayperiod-details/save-stayperiod-info/" + entityId);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (otherCitizenshipL.getValue()) {
            countryL.setVisible(true);
        } else {
            countryL.setVisible(false);
        }
        super.onClick(event);
    }

}
