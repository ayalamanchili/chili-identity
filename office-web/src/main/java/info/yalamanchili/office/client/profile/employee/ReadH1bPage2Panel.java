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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.onboarding.MaritalStatus;
import info.yalamanchili.office.client.profile.contact.Sex;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
class ReadH1bPage2Panel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadH1bPage2Panel.class.getName());

    protected static ReadH1bPage2Panel instance;
    protected String invitationCode;

    protected Button birth_passport_edit = new Button("Click here to Edit");
    protected Button job_edit = new Button("Click here to Edit");
    protected Button i94_edit = new Button("Click here to Edit");
    protected Button citizenship_edit = new Button("Click here to Edit");
    protected Button prior_work_exp_edit = new Button("Click here to Edit");
    protected Button misc_info_edit = new Button("Click here to Edit");

    HTML job_info_notes = new HTML("<p style=\"color:#F31212\">Note: Complete this section if filing for H-1B classification</strong></p> \n");
    HTML i94_notes = new HTML("<p style=\"color:#F31212\">Note: <br/> 1. If you are in the United States, complete the following. <br/> 2. I-94 Arrival-Departure Record Number (Enter Numeric characters only with out Hyphen)</strong></p> \n");

    protected static HTML birth_passport_info = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Birth And Passport Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML job_info = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Current Job Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML i94_info = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">I-94 Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML citizenship_Info = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Citizenship Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML prior_work_exp_info = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Prior Work Experience</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML misc_info = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Miscellaneous Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    public static ReadH1bPage2Panel instance() {
        return instance;
    }

    public ReadH1bPage2Panel(String invitationCode) {
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
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-2?invitationCode=" + entityId;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
    }

    @Override
    protected void addListeners() {
        birth_passport_edit.addClickHandler(this);
        job_edit.addClickHandler(this);
        i94_edit.addClickHandler(this);
        citizenship_edit.addClickHandler(this);
        prior_work_exp_edit.addClickHandler(this);
        misc_info_edit.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(birth_passport_info);
        entityFieldsPanel.add(birth_passport_edit);
        addField("hasValidPassport", true, true, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("passportNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("passportIssuedDate", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("passportExpiryDate", true, true, Sex.names(), Alignment.HORIZONTAL);
        addEnumField("passportCountryOfIssuance", true, true, MaritalStatus.names(), Alignment.HORIZONTAL);
        addField("dateOfBirth", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("stateOfBirth", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("countryOfBirth", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(job_info);
        entityFieldsPanel.add(job_info_notes);
        entityFieldsPanel.add(job_edit);
        addField("currentOccupation", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(i94_info);
        entityFieldsPanel.add(i94_notes);
        entityFieldsPanel.add(i94_edit);
        addField("i94RecordNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("presentNonImmiStatus", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfLastArrival", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("i94ValidFromDate", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Date Status Expires", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(citizenship_Info);
        entityFieldsPanel.add(citizenship_edit);
        addField("countryOfCitizenship", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(prior_work_exp_info);
        entityFieldsPanel.add(job_info_notes);
        entityFieldsPanel.add(prior_work_exp_edit);
        addField("workExpSummary", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(misc_info);
        entityFieldsPanel.add(misc_info_edit);
        addField("sevisNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("eadNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(birth_passport_edit)) {
            //new GenericPopup(new UpdateBirthPassportInfoPopupPanel(invitationCode), 50, Window.getClientHeight() / 5).show();
        }
        if (event.getSource().equals(job_edit)) {
            //new GenericPopup(new UpdateOtherNamesInfoPopupPanel(invitationCode), 50, Window.getClientHeight() * 2).show();
        }
        if (event.getSource().equals(i94_edit)) {
            //new GenericPopup(new UpdateAlienNoPopupPanel(entityId), 200, 1000).show();
        }
        if (event.getSource().equals(citizenship_edit)) {
            //ew GenericPopup(new UpdateCaseEducRecPopupPanel(entityId), 200, 650).show();
        }
        if (event.getSource().equals(prior_work_exp_edit)) {
            //new GenericPopup(new UpdateEducationRecord1PopupPanel(entityId), 200, 900).show();
        }
        if (event.getSource().equals(misc_info_edit)) {
            //new GenericPopup(new UpdateEducationRecord1PopupPanel(entityId), 200, 900).show();
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
