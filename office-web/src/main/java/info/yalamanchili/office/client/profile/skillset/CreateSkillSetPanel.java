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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.home.tasks.GenericBPMStartFormPanel;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;
import info.yalamanchili.office.client.profile.technologyGroup.SelectTechnologyGroupWidget;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateSkillSetPanel extends CreateComposite {

    protected String employeeId;
    private static Logger logger = Logger.getLogger(CreateSkillSetPanel.class.getName());
    SelectPracticeWidget practiceF = new SelectPracticeWidget(false, false);
    SelectTechnologyGroupWidget technologyGroupF = new SelectTechnologyGroupWidget(false, false);
    protected Anchor addSkilltL = new Anchor("Skills not present? submit request");
    protected Anchor addCertificationL = new Anchor("Certifications not present? submit request");
    FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "SkillSet", "resumeUrl", "SkillSet/resumeUrl", true) {
        @Override
        public void onUploadComplete() {
            postCreateSuccess(null);
        }
    };

    public CreateSkillSetPanel(String employeeId) {
        super(CreateCompositeType.CREATE);
        this.employeeId = employeeId;
        initCreateComposite("SkillSet", OfficeWelcome.constants);
    }

    @Override
    protected void addWidgets() {
        addDropDown("practice", practiceF);
        addDropDown("technologyGroup", technologyGroupF);
        entityFieldsPanel.add(addSkilltL);
        entityFieldsPanel.add(addCertificationL);
        entityFieldsPanel.add(resumeUploadPanel);
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
        addSkilltL.addClickHandler(this);
        addCertificationL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        uploadResume(arg0);
                    }
                });
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject skillSet = new JSONObject();
        assignEntityValueFromField("lastUpdated", skillSet);
        skillSet.put("practice", practiceF.getSelectedObject());
        skillSet.put("technologyGroup", technologyGroupF.getSelectedObject());
        skillSet.put("resumeUrl", resumeUploadPanel.getFileName());
        return skillSet;
    }

    @Override
    protected void addButtonClicked() {
    }

    protected void uploadResume(String entityId) {
        resumeUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Created Skllset");
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + employeeId;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addSkilltL)) {
            new GenericPopup(new GenericBPMStartFormPanel("add_new_skill_request", "add_new_skill_request")).show();
        }
        if (event.getSource().equals(addCertificationL)) {
            new GenericPopup(new GenericBPMStartFormPanel("add_new_certification_request", "add_new_certificetion_request")).show();
        }
        super.onClick(event);
    }

    protected String getAddSkillRequestUrl() {
        return OfficeWelcome.constants.root_url() + "bpm/startprocess/add_new_skill_request";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (resumeUploadPanel.isEmpty()) {
            resumeUploadPanel.setMessage("Please select a file");
            return false;
        }
        return true;
    }
}
