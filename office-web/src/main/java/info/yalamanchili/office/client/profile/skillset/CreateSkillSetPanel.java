/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
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
    FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "SkillSet", "skillSetFile", "SkillSet/skillSetFile", false, true) {
        @Override
        public void onUploadComplete(String res) {
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
        entityFieldsPanel.add(resumeUploadPanel);
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
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
        skillSet.put("skillSetFile", resumeUploadPanel.getFileName());
        JSONArray resumeURL = new JSONArray();
        if (!resumeUploadPanel.isEmpty()) {
            int i = 0;
            for (JSONString fileName : resumeUploadPanel.getFileNames()) {
                if (fileName != null && !fileName.stringValue().trim().isEmpty()) {
                    JSONObject resume = new JSONObject();
                    resume.put("fileURL", fileName);
                    resume.put("name", new JSONString("File Name"));
                    resumeURL.set(i, resume);
                    i++;
                }
            }
        }
        if (resumeURL.size() > 0) {
            entity.put("skillSetFile", resumeURL);
        }
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
    protected boolean processClientSideValidations(JSONObject entity) {
        if (resumeUploadPanel.isEmpty()) {
            resumeUploadPanel.setMessage("Please select a file");
            return false;
        }
        return true;
    }
}
