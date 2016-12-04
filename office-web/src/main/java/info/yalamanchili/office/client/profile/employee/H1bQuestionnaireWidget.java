/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author radhika.mukkala
 */
public class H1bQuestionnaireWidget extends UpdateComposite implements ClickHandler {

    protected String invitationCode;
    private static H1bQuestionnaireWidget instance;
    private String pageWithNo;

    protected Button page1L = new Button("1");
    protected Button page2L = new Button("2");
    protected Button page3L = new Button("3");
    protected Button page4L = new Button("4");
    protected Button page5L = new Button("5");
    protected Button page6L = new Button("6");

    HorizontalPanel pagesPanel = new HorizontalPanel();

    public H1bQuestionnaireWidget(String inviteCode, String pageWithNo) {
        this.pageWithNo = pageWithNo;
        if (inviteCode.contains("?type")) {
            this.invitationCode = inviteCode.substring(0, inviteCode.indexOf("?"));
        } else {
            this.invitationCode = inviteCode;
        }
        instance = this;
        initUpdateComposite(inviteCode, "H1BQuestionnaire", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
    }

    @Override
    protected void addListeners() {
        page1L.addClickHandler(this);
        page2L.addClickHandler(this);
        page3L.addClickHandler(this);
        page4L.addClickHandler(this);
        page5L.addClickHandler(this);
        page6L.addClickHandler(this);
    }

    @Override
    protected void configure() {
        pagesPanel.setSpacing(10);
        page1L.setTitle("Go to Personal Information, "
                + "Education Details - II, "
                + "Alien Number, "
                + "Education Details - I, "
                + "Other Names Information");
        page2L.setTitle("Go to Birth and Passport Info, "
                + "Current Job Info, "
                + "I94 Info, "
                + "Citizenship Info, "
                + "Prior work Exp., Miscellaneous Info");
        page3L.setTitle("Go to Current U.S. Address, Foreign Address");
        page4L.setTitle("Go to Deportation Info, Prev. Visa Info, Visa filing Info");
        page5L.setTitle("Go to Consulate info");
        page6L.setTitle("Go to Applicant and Stay Period Info");
        loadPage();
    }
    
    private void loadPage(){
        switch(pageWithNo){
            case "page1":
                entityActionsPanel.add(new ReadH1bPage1Panel(invitationCode));
                break;
            case "page2":
                entityActionsPanel.add(new ReadH1bPage2Panel(invitationCode));
                break;
        }
    }

    @Override
    protected void addWidgets() {
        pagesPanel.add(page1L);
        pagesPanel.add(page2L);
        pagesPanel.add(page3L);
        pagesPanel.add(page4L);
        pagesPanel.add(page5L);
        pagesPanel.add(page6L);
        entityFieldsPanel.add(pagesPanel);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigration/send-h1b-questionnaire";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(page1L)) {
            entityActionsPanel.clear();
            entityFieldsPanel.add(pagesPanel);
            entityActionsPanel.add(new ReadH1bPage1Panel(invitationCode));
        }
        if (event.getSource().equals(page2L)) {
            entityActionsPanel.clear();
            entityFieldsPanel.add(pagesPanel);
            entityActionsPanel.add(new ReadH1bPage2Panel(invitationCode));
        }
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        return null;
    }

    @Override
    protected void updateButtonClicked() {
    }

    @Override
    protected void postUpdateSuccess(String result) {
    }
}