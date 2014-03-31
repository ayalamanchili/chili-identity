/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.home.tasks.GenericBPMStartFormPanel;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.technologyGroup.SelectTechnologyGroupWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateSkillSetPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateSkillSetPanel.class.getName());
    SelectPracticeWidget practiceF = new SelectPracticeWidget(false, false);
    ClickableLink newPracticeL = new ClickableLink("Practice not present? submit request");
    SelectTechnologyGroupWidget technoglogyGroupF = new SelectTechnologyGroupWidget(false, false);
    ClickableLink newTGL = new ClickableLink("Technolgoy not present? submit request");
    FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "SkillSet", "resumeUrl", "SkillSet/resumeUrl", true) {
        @Override
        public void onUploadComplete() {
            postUpdateSuccess(null);
        }

        @Override
        public void onFileUploadError() {
            Window.alert("File Size exceeded. MaxLimit:20MB");
        }
    };

    public UpdateSkillSetPanel(JSONObject entity) {
        initUpdateComposite(entity, "SkillSet", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject skillSet = new JSONObject();
        skillSet.put("practice", practiceF.getSelectedObject());
        skillSet.put("technologyGroup", technoglogyGroupF.getSelectedObject());
        if (!resumeUploadPanel.isEmpty()) {
            skillSet.put("resumeUrl", resumeUploadPanel.getFileName());
        }
        return skillSet;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        uploadResume(arg0);
                    }
                });

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("practice", entity, null);
        assignFieldValueFromEntity("technologyGroup", entity, null);
    }

    protected void uploadResume(String entityId) {
        resumeUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee Skill Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadSkillSetPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
        newPracticeL.addClickHandler(this);
        newTGL.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addDropDown("practice", practiceF);
        entityFieldsPanel.add(newPracticeL);
        addDropDown("technologyGroup", technoglogyGroupF);
        entityFieldsPanel.add(newTGL);
        entityFieldsPanel.add(resumeUploadPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        super.onClick(event);
        if (event.getSource().equals(newPracticeL)) {
            new GenericPopup(new GenericBPMStartFormPanel("AddNewPracticeRequest", "add_new_practice_request")).show();
        }
        if (event.getSource().equals(newTGL)) {
            new GenericPopup(new GenericBPMStartFormPanel("AddNewTechnologyRequest", "add_new_technology_request")).show();
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + TreeEmployeePanel.instance().getEntityId();
    }
}
