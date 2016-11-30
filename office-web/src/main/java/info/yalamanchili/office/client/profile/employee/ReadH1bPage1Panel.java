/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
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
public class ReadH1bPage1Panel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadH1bPage1Panel.class.getName());

    protected static ReadH1bPage1Panel instance;
    protected String invitationCode;

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
        this.invitationCode = invitationCode;
        initReadComposite(invitationCode, "H1BQuestionnaire", OfficeWelcome.constants2);
        entityCaptionPanel.setCaptionHTML("");
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(entityId), OfficeWelcome.instance().getHeaders(), true,
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

    protected String getReadURI(String entityId) {
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-1?invitationCode=" + entityId;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        if (entity.containsKey("empPersonalInfo")) {
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
        }
        if (entity.containsKey("otherNamesInfo")) {
            JSONObject otherNamesInfoOBJ = entity.get("otherNamesInfo").isObject();
            assignFieldValueFromEntity("firstName", otherNamesInfoOBJ, DataType.STRING_FIELD);
            assignFieldValueFromEntity("middleName", otherNamesInfoOBJ, DataType.STRING_FIELD);
            assignFieldValueFromEntity("lastName", otherNamesInfoOBJ, DataType.STRING_FIELD);
        }
        if (entity.containsKey("usEducRec")) {
            JSONObject usEduRecInfoObj = entity.get("usEducRec").isObject();
            if (usEduRecInfoObj.containsKey("address") && usEduRecInfoObj.get("address").isString().stringValue() != null) {
                JSONObject address = new JSONObject();
                String[] adressArr = usEduRecInfoObj.get("address").isString().stringValue().split("-");
                if (adressArr.length == 5) {
                    address.put("street1", new JSONString(adressArr[0]));
                    address.put("street2", new JSONString(""));
                    address.put("city", new JSONString(adressArr[1]));
                    address.put("state", new JSONString(adressArr[2]));
                    address.put("country", new JSONString(adressArr[3]));
                    address.put("zip", new JSONString(adressArr[4]));
                } else if (adressArr.length == 6) {
                    address.put("street1", new JSONString(adressArr[0]));
                    address.put("street2", new JSONString(adressArr[1]));
                    address.put("city", new JSONString(adressArr[2]));
                    address.put("state", new JSONString(adressArr[3]));
                    address.put("country", new JSONString(adressArr[4]));
                    address.put("zip", new JSONString(adressArr[5]));
                }
                assignFieldValueFromEntity("street1", address, DataType.STRING_FIELD);
                assignFieldValueFromEntity("street2", address, DataType.STRING_FIELD);
                assignFieldValueFromEntity("country", address, DataType.STRING_FIELD);
                assignFieldValueFromEntity("city", address, DataType.STRING_FIELD);
                assignFieldValueFromEntity("state", address, DataType.STRING_FIELD);
                assignFieldValueFromEntity("zip", address, DataType.STRING_FIELD);
                assignFieldValueFromEntity("nameOfSchool", usEduRecInfoObj, DataType.STRING_FIELD);
                assignFieldValueFromEntity("dateDegreeAwarded", usEduRecInfoObj, DataType.DATE_FIELD);
                assignFieldValueFromEntity("typeOfUSDegree", usEduRecInfoObj, DataType.STRING_FIELD);
                assignFieldValueFromEntity("degreeOfStudy", usEduRecInfoObj, DataType.STRING_FIELD);
            }
            if (entity.containsKey("alienNumber")) {
                JSONObject alienNumber = entity.get("alienNumber").isObject();
                assignFieldValueFromEntity("alienNumber", alienNumber, DataType.STRING_FIELD);
            }
            if (entity.containsKey("eduDto")) {
                JSONObject eduDto = entity.get("eduDto").isObject();
                assignFieldValueFromEntity("fieldOfStudy", eduDto, DataType.STRING_FIELD);
                assignFieldValueFromEntity("highestLevelOfEdu", eduDto, DataType.TEXT_AREA_FIELD);
                assignFieldValueFromEntity("noOfDependents", eduDto, DataType.INTEGER_FIELD);

            }
        }
    }

    @Override
    protected void addListeners() {
        personalInfoEdit.addClickHandler(this);
        eduInfo2Edit.addClickHandler(this);
        OtherNamesInfoEdit.addClickHandler(this);
        alienNoInfoEdit.addClickHandler(this);
        eduInfo1Edit.addClickHandler(this);
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
        addField("city", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("state", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("country", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("zip", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateDegreeAwarded", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("typeOfUSDegree", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("degreeOfStudy", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(alienNoInfo);
        entityFieldsPanel.add(alienNoInfoEdit);
        addField("alienNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(eduInfo1);
        entityFieldsPanel.add(eduInfo1Edit);
        addField("fieldOfStudy", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("highestLevelOfEdu", true, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("noOfDependents", true, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(otherNamesInfo);
        entityFieldsPanel.add(otherNamesNotes);
        entityFieldsPanel.add(OtherNamesInfoEdit);
        addField("firstName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(personalInfoEdit)) {
            new GenericPopup(new UpdateEmpPersonalInfoPopupPanel(invitationCode), 200, 200).show();
        }
        if (event.getSource().equals(OtherNamesInfoEdit)) {
            new GenericPopup(new UpdateOtherNamesInfoPopupPanel(invitationCode), 200, 1350).show();
        }
        if (event.getSource().equals(alienNoInfoEdit)) {
            new GenericPopup(new UpdateAlienNoPopupPanel(entityId), 200, 1000).show();
        }
        if (event.getSource().equals(eduInfo2Edit)) {
            new GenericPopup(new UpdateCaseEducRecPopupPanel(entityId), 200, 650).show();
        }
        if (event.getSource().equals(eduInfo1Edit)) {
            new GenericPopup(new UpdateEducationRecord1PopupPanel(entityId), 200, 900).show();
        }
    }

    protected String updateImmigrationInfo() {
        return URL.encode(OfficeWelcome.constants.root_url() + "immigrationcase/save-immigration-info/" + invitationCode);
    }

    @Override
    protected String getURI() {
        return null;
    }
}
