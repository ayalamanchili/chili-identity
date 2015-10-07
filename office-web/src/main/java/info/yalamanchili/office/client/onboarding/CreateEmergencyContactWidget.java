/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.contact.Sex;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class CreateEmergencyContactWidget extends CreateComposite implements ClickHandler {

    private Logger logger = Logger.getLogger(CreateEmergencyContactWidget.class.getName());
    ClickableLink deleteB = new ClickableLink("Remove Emergency Contact");
    EmployeeOnboardingPanel parentPanel;
    HTML emptyLine = new HTML("<br/>");
    private int index;

    public CreateEmergencyContactWidget(CreateComposite.CreateCompositeType type, EmployeeOnboardingPanel parent, int idx) {
        super(type);
        initCreateComposite("EmergencyContact", OfficeWelcome.constants);
        this.index = idx;
        this.parentPanel = parent;
    }

    @Override
    protected void configure() {
        add.setVisible(false);
    }

    @Override
    protected void addListeners() {
        deleteB.addClickHandler(this);
    }

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", false, false, Sex.names(), Alignment.HORIZONTAL);
        addField("relation", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ecPrimary", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("email", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("countryCode", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", false, true, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("extension", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(emptyLine);
        entityActionsPanel.add(deleteB);
        alignFields();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(deleteB)) {
            parentPanel.removeEmergencyContactPanel(index);
        }
        super.onClick(event);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject emergencyCnt = new JSONObject();
        assignEntityValueFromField("firstName", emergencyCnt);
        assignEntityValueFromField("middleInitial", emergencyCnt);  
        assignEntityValueFromField("lastName", emergencyCnt);
        assignEntityValueFromField("sex", emergencyCnt);
        assignEntityValueFromField("relation", emergencyCnt);
        assignEntityValueFromField("ecPrimary", emergencyCnt);
        assignEntityValueFromField("email", emergencyCnt);
        assignEntityValueFromField("countryCode", emergencyCnt);
        assignEntityValueFromField("phoneNumber", emergencyCnt);
        assignEntityValueFromField("extension", emergencyCnt);
        logger.info(emergencyCnt.toString());
        return emergencyCnt;
    }

    @Override
    protected void createButtonClicked() {

    }

    @Override
    protected void addButtonClicked() {

    }

    @Override
    protected void postCreateSuccess(String result) {

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return " ";
    }

}
