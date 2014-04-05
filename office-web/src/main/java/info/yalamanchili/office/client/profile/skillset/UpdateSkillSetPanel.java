/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.home.tasks.GenericBPMStartFormPanel;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.technologyGroup.SelectTechnologyGroupWidget;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateSkillSetPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateSkillSetPanel.class.getName());
    /**
     * Practice
     */
    SelectPracticeWidget practiceF = new SelectPracticeWidget(false, false);
    ClickableLink newPracticeL = new ClickableLink("Practice not present? submit request");
    /**
     * Technology Group
     */
    SelectTechnologyGroupWidget technoglogyGroupF = new SelectTechnologyGroupWidget(false, false);
    ClickableLink newTGL = new ClickableLink("Technolgoy not present? submit request");
    /**
     * resume
     */
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

    /**
     * Skill Set Tags
     *
     */
    SuggestBox tagsF = null;
    Button addTagB = new Button("Add Tag");
    Button removeTagB = new Button("Remove Tag");

    public UpdateSkillSetPanel(JSONObject entity) {
        initUpdateComposite(entity, "SkillSet", OfficeWelcome.constants);
        initTagsSuggestionBox();
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity.put("practice", practiceF.getSelectedObject());
        entity.put("technologyGroup", technoglogyGroupF.getSelectedObject());
        if (!resumeUploadPanel.isEmpty()) {
            entity.put("resumeUrl", resumeUploadPanel.getFileName());
        }
        return entity;
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
        addTagB.addClickHandler(this);
        removeTagB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        tagsF = (SuggestBox) fields.get("tags");
    }

    @Override
    protected void addWidgets() {
        addDropDown("practice", practiceF);
        entityFieldsPanel.add(newPracticeL);
        addDropDown("technologyGroup", technoglogyGroupF);
        entityFieldsPanel.add(newTGL);
        entityFieldsPanel.add(resumeUploadPanel);
        addField("tags", false, true, DataType.SUGGEST_FIELD);
        entityFieldsPanel.add(addTagB);
        entityFieldsPanel.add(removeTagB);
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
        if (event.getSource().equals(addTagB)) {
            addTagClicked();
        }
        if (event.getSource().equals(removeTagB)) {
            removeTagClicked();
        }
    }

    protected void addTagClicked() {
        HttpService.HttpServiceAsync.instance().doPut(addTagUrl(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Tag Added");
                    }
                });
    }

    protected String addTagUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "skillsettag/add-tag/" + getEntityId() + "/" + tagsF.getValue());
    }

    protected void removeTagClicked() {
        HttpService.HttpServiceAsync.instance().doPut(removeTagUrl(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Tag Removed");
                    }
                });
    }

    protected String removeTagUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "skillsettag/remove-tag/" + getEntityId() + "/" + tagsF.getValue());
    }

    protected void initTagsSuggestionBox() {
        HttpService.HttpServiceAsync.instance().doGet(getTagsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    tagsF.loadData(values);
                }
            }
        });
    }

    protected String getTagsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/dropdown/0/1000?column=id&column=name";
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + TreeEmployeePanel.instance().getEntityId();
    }
}
