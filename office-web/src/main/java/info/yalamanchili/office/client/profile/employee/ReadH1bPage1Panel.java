/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadH1bPage1Panel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadH1bPage1Panel.class.getName());

    protected static ReadH1bPage1Panel instance;
    protected String invitationCode;

    UpdateEmpPersonalInfoPopupPanel personalInfoPopupPanel;
    UpdateCaseEducRecPopupPanel usEducRecPanel;
    UpdateAlienNoPopupPanel alienPopupPanel;
    UpdateOtherNamesInfoPopupPanel otherNamesPanel;
    UpdateEducationRecord1PopupPanel eduRecPanel;

    protected Button personalInfoEdit = new Button("Click here to Edit");
    protected Button OtherNamesInfoEdit = new Button("Click here to Add");
    protected Button eduInfo2Edit = new Button("Click here to Add");
    protected Button alienNoInfoEdit = new Button("Click here to Edit");
    protected Button eduInfo1Edit = new Button("Click here to Edit");

    HTML personalInfoNotes = new HTML("<p style=\"color:#F31212\">Note: <br/> 1. U.S. Social Security Number (Enter Numeric Characters only with out Hyphen) <br/> 2. Individual Tax Number (Enter Numeric Characters only with out Hyphen)</strong></p> \n");
    HTML eduInfo2Notes = new HTML("<p style=\"color:#F31212\">Note: If you have a CAP H-1B U.S. Master's Degree or Higher, provide the following information regarding the master's or higher degree the beneficiary has earned from a U.S. institution as defined in 20 U.S.C. 1001(a).</strong></p> \n");
    HTML otherNamesNotes = new HTML("<p style=\"color:#F31212\">Note: Provide all other names the beneficiary has used. Include nicknames, aliases, maiden name and names from all previous marriages.</strong></p> \n");

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
        personalInfoPopupPanel.populateFieldsFromEntity(entity);
        usEducRecPanel.populateFieldsFromEntity(entity);
        otherNamesPanel.populateFieldsFromEntity(entity);
        alienPopupPanel.populateFieldsFromEntity(entity);
        eduRecPanel.populateFieldsFromEntity(entity);
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
        //personal info
        entityFieldsPanel.add(personalInfoNotes);
        entityFieldsPanel.add(personalInfoEdit);
        personalInfoPopupPanel = new UpdateEmpPersonalInfoPopupPanel(entityId, true);
        entityFieldsPanel.add(personalInfoPopupPanel);

        //us edu record
        entityFieldsPanel.add(eduInfo2Notes);
        entityFieldsPanel.add(eduInfo2Edit);
        usEducRecPanel = new UpdateCaseEducRecPopupPanel(entityId, true);
        entityFieldsPanel.add(usEducRecPanel);

        //alien number
        entityFieldsPanel.add(alienNoInfoEdit);
        alienPopupPanel = new UpdateAlienNoPopupPanel(entityId, true);
        entityFieldsPanel.add(alienPopupPanel);

        entityFieldsPanel.add(eduInfo1Edit);
        eduRecPanel = new UpdateEducationRecord1PopupPanel(entityId, true);
        entityFieldsPanel.add(eduRecPanel);

        //other names info
        entityFieldsPanel.add(otherNamesNotes);
        entityFieldsPanel.add(OtherNamesInfoEdit);
        otherNamesPanel = new UpdateOtherNamesInfoPopupPanel(entityId, true);
        entityFieldsPanel.add(otherNamesPanel);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(personalInfoEdit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(personalInfoPopupPanel)));
            personalInfoPopupPanel = new UpdateEmpPersonalInfoPopupPanel(entityId, false);
            entityFieldsPanel.insert(personalInfoPopupPanel, entityFieldsPanel.getWidgetIndex(personalInfoEdit) + 1);
        }
        if (event.getSource().equals(eduInfo2Edit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(usEducRecPanel)));
            usEducRecPanel = new UpdateCaseEducRecPopupPanel(entityId, false);
            entityFieldsPanel.insert(usEducRecPanel, entityFieldsPanel.getWidgetIndex(eduInfo2Edit) + 1);
        }
        if (event.getSource().equals(alienNoInfoEdit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(alienPopupPanel)));
            alienPopupPanel = new UpdateAlienNoPopupPanel(entityId, false);
            entityFieldsPanel.insert(alienPopupPanel, entityFieldsPanel.getWidgetIndex(alienNoInfoEdit) + 1);
        }
        if (event.getSource().equals(OtherNamesInfoEdit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(otherNamesPanel)));
            otherNamesPanel = new UpdateOtherNamesInfoPopupPanel(entityId, false);
            entityFieldsPanel.insert(otherNamesPanel, entityFieldsPanel.getWidgetIndex(OtherNamesInfoEdit) + 1);
        }
        if (event.getSource().equals(eduInfo1Edit)) {
            entityFieldsPanel.remove(entityFieldsPanel.getWidget(entityFieldsPanel.getWidgetIndex(eduRecPanel)));
            eduRecPanel = new UpdateEducationRecord1PopupPanel(entityId, false);
            entityFieldsPanel.insert(eduRecPanel, entityFieldsPanel.getWidgetIndex(eduInfo1Edit) + 1);
        }
    }

    @Override
    protected String getURI() {
        return null;
    }
}