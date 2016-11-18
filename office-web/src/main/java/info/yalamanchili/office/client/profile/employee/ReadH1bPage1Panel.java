/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.data.CanadaStatesFactory;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.onboarding.MaritalStatus;
import info.yalamanchili.office.client.profile.contact.Sex;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadH1bPage1Panel extends ReadComposite implements ClickHandler, ChangeHandler {

    private static Logger logger = Logger.getLogger(ReadH1bPage1Panel.class.getName());

    protected static ReadH1bPage1Panel instance;
    protected String invitationCode;
    EnumField statesF;
    EnumField countriesF;

    protected Button personalInfoEdit = new Button("Click here to Edit");
    protected Button OtherNamesInfoEdit = new Button("Click here to Add");
    protected Button eduInfo2Edit = new Button("Click here to Add");
    protected Button alienNoInfoEdit = new Button("Click here to Edit");
    protected Button eduInfo1Edit = new Button("Click here to Edit");

    HTML personalInfoNotes = new HTML("<p style=\"color:#F31212\">Note: <br/> 1. U.S. Social Security Number (Enter Numeric Characters only with out Hyphen) <br/> 2. Individual Tax Number (Enter Numeric Characters only with out Hyphen)</strong></p> \n");
    HTML eduInfo2Notes = new HTML("<p style=\"color:#F31212\">Note: If you have a CAP H-1B U.S. Master's Degree or Higher, provide the following information regarding the master's or higher degree the beneficiary has earned from a U.S. institution as defined in 20 U.S.C. 1001(a).</strong></p> \n");
    HTML otherNamesNotes = new HTML("<p style=\"color:#F31212\">Note: Provide all other names the beneficiary has used. Include nicknames, aliases, maiden name and names from all previous marriages.</strong></p> \n");

    protected static HTML personalInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Personal Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML eduInfo2 = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Education Details - II - I</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML eduInfo1 = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Education Details - I</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML alienNoInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Alien Number</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML otherNamesInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Other Names Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    public static ReadH1bPage1Panel instance() {
        return instance;
    }

    public ReadH1bPage1Panel(String invitationCode) {
        instance = this;
        initReadComposite(invitationCode, "H1BQuestionnaire", OfficeWelcome.constants2);
        entityCaptionPanel.setCaptionHTML("");
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(entityId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.trim().equals("null")) {
                            entity = (JSONObject) JSONParser.parseLenient(response);
                            populateFieldsFromEntity(entity);
                        }
                    }
                });
    }

    protected String getReadURI(String entityId) {
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/?invitationCode=" + entityId;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        JSONObject personalInfoOBJ = entity.get("empPersonalInfo").isObject();
        assignFieldValueFromEntity("empLastName", personalInfoOBJ, DataType.STRING_FIELD);
        assignFieldValueFromEntity("empFirstName", personalInfoOBJ, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", personalInfoOBJ, DataType.STRING_FIELD);
        assignFieldValueFromEntity("gender", personalInfoOBJ, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("maritalStatus", personalInfoOBJ, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("email", personalInfoOBJ, DataType.STRING_FIELD);
        assignFieldValueFromEntity("workEmail", personalInfoOBJ, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ssn", personalInfoOBJ, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", personalInfoOBJ, DataType.DATE_FIELD);
        //assignFieldValueFromEntity("firstName", personalInfo, DataType.STRING_FIELD);
        //assignFieldValueFromEntity("middleName", personalInfo, DataType.STRING_FIELD);
        //assignFieldValueFromEntity("lastName", personalInfo, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
        personalInfoEdit.addClickHandler(this);
        eduInfo2Edit.addClickHandler(this);
        OtherNamesInfoEdit.addClickHandler(this);
        if (countriesF != null) {
            countriesF.listBox.addChangeHandler(this);
        }
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(personalInfo);
        entityFieldsPanel.add(personalInfoNotes);
        entityFieldsPanel.add(personalInfoEdit);
        addField("empLastName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("empFirstName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("gender", true, true, Sex.names(), Alignment.HORIZONTAL);
        addEnumField("maritalStatus", true, true, MaritalStatus.names(), Alignment.HORIZONTAL);
        addField("email", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("workEmail", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ssn", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(eduInfo2);
        entityFieldsPanel.add(eduInfo2Notes);
        entityFieldsPanel.add(eduInfo2Edit);
        addField("nameOfSchool", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street1", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", true, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("city", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("state", true, false, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("dateDegreeAwarded", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("typeOfUSDegree", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("certificationObtained", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(alienNoInfo);
        entityFieldsPanel.add(alienNoInfoEdit);
        addField("alienNumber", true, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(eduInfo1);
        entityFieldsPanel.add(eduInfo1Edit);
        addField("fieldOfStudy", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("highestLevelOfEducation", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("noOfDependents", true, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(otherNamesInfo);
        entityFieldsPanel.add(otherNamesNotes);
        entityFieldsPanel.add(OtherNamesInfoEdit);
        addField("firstName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        statesF = (EnumField) fields.get("state");
        countriesF = (EnumField) fields.get("country");
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(personalInfoEdit)) {
            new GenericPopup(new UpdateEmpPersonalInfoPopupPanel(entityId), 50, Window.getClientHeight() / 5).show();
        }
//        if (event.getSource().equals(eduInfo2Edit)) {
//            new GenericPopup(new UpdateEducationRecordPopupPanel(entityId), 50, Window.getClientHeight() / 5).show();
//        }
    }

    protected String updateImmigrationInfo() {
        return URL.encode(OfficeWelcome.constants.root_url() + "immigrationcase/save-immigration-info/" + invitationCode);
    }

    @Override
    public void onChange(ChangeEvent event) {
        switch (countriesF.getValue()) {
            case "USA":
                statesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                break;
            case "INDIA":
                statesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                break;
            case "CANADA":
                statesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
        }
    }

    @Override
    protected String getURI() {
        return null;
    }
}
