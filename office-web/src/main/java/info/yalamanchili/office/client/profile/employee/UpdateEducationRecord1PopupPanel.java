/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.crud.TUpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.IntegerField;
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
public class UpdateEducationRecord1PopupPanel extends TUpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateEducationRecord1PopupPanel.class.getName());
    boolean isReadPanel;

    HTML eduInfo1Notes = new HTML("<p style=\"color:#F31212\">Beneficiary's Highest Level of Education</strong></p> \n");
    RadioButton levelOfEducation1 = new RadioButton("educationRecord", "NO DIPLOMA");
    RadioButton levelOfEducation2 = new RadioButton("educationRecord", "HIGH SCHOOL GRADUATE - high school DIPLOMA or the equivalent (for example ,GED)");
    RadioButton levelOfEducation3 = new RadioButton("educationRecord", "Some college credit, but less than one year");
    RadioButton levelOfEducation4 = new RadioButton("educationRecord", "One or more years of college, no degree");
    RadioButton levelOfEducation5 = new RadioButton("educationRecord", "Associate's degree (for example: AA, AS)");
    RadioButton levelOfEducation6 = new RadioButton("educationRecord", "Bachelor's degree (for example: BA, AB, BS)");
    RadioButton levelOfEducation7 = new RadioButton("educationRecord", "Master's degree (for example: MA, MS, MEng, MEd, MSW, MBA)");
    RadioButton levelOfEducation8 = new RadioButton("educationRecord", "Professional degree (for example: MD, DDS, DVM, LLB, JD)");
    RadioButton levelOfEducation9 = new RadioButton("educationRecord", "Doctorate degree (for example: PhD, EdD)");

    public UpdateEducationRecord1PopupPanel(String entityId) {
        initUpdateComposite(entityId, "EducationDetails", OfficeWelcome.constants2);
    }

    public UpdateEducationRecord1PopupPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "EducationDetails", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject eduDto = new JSONObject();
        assignEntityValueFromField("fieldOfStudy", eduDto);
        assignEntityValueFromField("noOfDependents", eduDto);
        eduDto.put("highestLevelOfEdu", new JSONString(getEducation()));
        entity.put("eduDto", eduDto);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        JSONObject entity = populateEntityFromFields();
        HttpService.HttpServiceAsync.instance().doPut(updateEduDetails(), entity.toString(),
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
        if (entity.containsKey("eduDto")) {
            JSONObject eduDto = entity.get("eduDto").isObject();
            assignFieldValueFromEntity("fieldOfStudy", eduDto, DataType.STRING_FIELD);
            assignFieldValueFromEntity("noOfDependents", eduDto, DataType.INTEGER_FIELD);
            if (eduDto.containsKey("highestLevelOfEdu")) {
                setEducation(eduDto.get("highestLevelOfEdu").isString().stringValue());
            }
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId, "page1"));
        new ResponseStatusWidget().show("Successfully  Updated Education Details");
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
        for (Map.Entry<String, BaseField> e : fields.entrySet()) {
            if (e.getValue() instanceof BaseFieldWithTextBox) {
                setVisibleLengthSize(e.getKey(), 25);
            }
        }
        configureLabelNames();
    }

    protected void configureLabel(Label l) {
        l.removeStyleName("tfFieldHeader");
        l.setVisible(true);
    }

    private void configureLabelNames() {
        StringField fieldOfStudy = (StringField) fields.get("fieldOfStudy");
        configureLabel(fieldOfStudy.getLabel());
        IntegerField noOfDependents = (IntegerField) fields.get("noOfDependents");
        configureLabel(noOfDependents.getLabel());
    }

    @Override
    protected void addWidgets() {
        addField("fieldOfStudy", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("noOfDependents", isReadPanel, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL, 1, 2);
        entityFieldsPanel.setWidget(2, 1, eduInfo1Notes);
        entityFieldsPanel.setWidget(3, 1, levelOfEducation1);
        entityFieldsPanel.setWidget(3, 2, levelOfEducation2);
        entityFieldsPanel.setWidget(4, 1, levelOfEducation3);
        entityFieldsPanel.setWidget(4, 2, levelOfEducation4);
        entityFieldsPanel.setWidget(5, 1, levelOfEducation5);
        entityFieldsPanel.setWidget(5, 2, levelOfEducation6);
        entityFieldsPanel.setWidget(6, 1, levelOfEducation7);
        entityFieldsPanel.setWidget(6, 2, levelOfEducation8);
        entityFieldsPanel.setWidget(7, 1, levelOfEducation9);
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

    protected String updateEduDetails() {
        return URL.encode(OfficeWelcome.constants.root_url() + "immigrationcase/save-edu-info/" + entityId);
    }

    private String getEducation() {
        String education = null;
        if (levelOfEducation1.isChecked()) {
            education = levelOfEducation1.getText();
        } else if (levelOfEducation2.isChecked()) {
            education = levelOfEducation2.getText();
        } else if (levelOfEducation3.isChecked()) {
            education = levelOfEducation3.getText();
        } else if (levelOfEducation4.isChecked()) {
            education = levelOfEducation4.getText();
        } else if (levelOfEducation5.isChecked()) {
            education = levelOfEducation5.getText();
        } else if (levelOfEducation6.isChecked()) {
            education = levelOfEducation6.getText();
        } else if (levelOfEducation7.isChecked()) {
            education = levelOfEducation7.getText();
        } else if (levelOfEducation8.isChecked()) {
            education = levelOfEducation8.getText();
        } else if (levelOfEducation9.isChecked()) {
            education = levelOfEducation9.getText();
        }
        return education;
    }

    private void setEducation(String eduName) {
        switch (eduName) {
            case "NO DIPLOMA":
                levelOfEducation1.setValue(true);
                break;
            case "HIGH SCHOOL GRADUATE - high school DIPLOMA or the equivalent (for example ,GED)":
                levelOfEducation2.setValue(true);
                break;
            case "Some college credit, but less than one year":
                levelOfEducation3.setValue(true);
                break;
            case "One or more years of college, no degree":
                levelOfEducation4.setValue(true);
                break;
            case "Associate's degree (for example: AA, AS)":
                levelOfEducation5.setValue(true);
                break;
            case "Bachelor's degree (for example: BA, AB, BS)":
                levelOfEducation6.setValue(true);
                break;
            case "Master's degree (for example: MA, MS, MEng, MEd, MSW, MBA)":
                levelOfEducation7.setValue(true);
                break;
            case "Professional degree (for example: MD, DDS, DVM, LLB, JD)":
                levelOfEducation8.setValue(true);
                break;
            case "Doctorate degree (for example: PhD, EdD)":
                levelOfEducation9.setValue(true);
                break;
        }
    }
}
