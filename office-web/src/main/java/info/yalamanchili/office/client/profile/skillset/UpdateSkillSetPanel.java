/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.listeners.GenericListener;
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
import info.yalamanchili.office.client.recruiting.skillsettag.CreateSkillSetTagPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateSkillSetPanel extends UpdateComposite implements KeyPressHandler, GenericListener {

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
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
        }
    };

    /**
     * Skill Set Tags
     *
     */
    CaptionPanel tagsCP = new CaptionPanel("Tags");
    FlowPanel tagsPanel = new FlowPanel();
    SuggestBox tagsSB = new SuggestBox(OfficeWelcome.constants, "search", "SkillSetTag", false, false);
    Button addTagB = new Button("Add Tag");
    Button removeTagB = new Button("Remove Tag");
    RichTextArea tagsTA = new RichTextArea();
    ClickableLink createTagL = new ClickableLink("Create New Tag");

    public UpdateSkillSetPanel(JSONObject entity) {
        initUpdateComposite(entity, "SkillSet", OfficeWelcome.constants);
        entityActionsPanel.add(tagsCP);
        loadTagSuggestions();
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
        extractResumeContent();
        new ResponseStatusWidget().show("Successfully Updated Employee Skill Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadSkillSetPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    protected void extractResumeContent() {
        HttpService.HttpServiceAsync.instance().doGet(getExtractResumeUrl(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                    }
                });
    }

    protected String getExtractResumeUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/extract-resume/" + getEntityId();
    }

    @Override
    protected void addListeners() {
        newPracticeL.addClickHandler(this);
        newTGL.addClickHandler(this);
        addTagB.addClickHandler(this);
        removeTagB.addClickHandler(this);
        tagsSB.getSuggestBox().addKeyPressHandler(this);
        createTagL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        tagsTA.setWidth("100%");
    }

    @Override
    protected void addWidgets() {
        addDropDown("practice", practiceF);
        entityFieldsPanel.add(newPracticeL);
        addDropDown("technologyGroup", technoglogyGroupF);
        entityFieldsPanel.add(newTGL);
        entityFieldsPanel.add(resumeUploadPanel);
        //Tags
        tagsPanel.add(new HTML("<h5>Add Tags that will reflect your niche skills. These are used by search engine for recruiting purposes. </br> You can create new Tags as needed.</h5>"));
        tagsPanel.add(tagsSB);
        tagsSB.addWidgetToFieldPanel(createTagL);
        tagsPanel.add(addTagB);
        tagsPanel.add(removeTagB);
        tagsPanel.add(tagsTA);
        tagsCP.setContentWidget(tagsPanel);
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
        if (event.getSource().equals(createTagL)) {
            CreateSkillSetTagPanel createTagW = new CreateSkillSetTagPanel(getEntityId());
            createTagW.addListner(this);
            new GenericPopup(createTagW, createTagL.getAbsoluteLeft(), createTagL.getAbsoluteTop()).show();
        }
    }

    protected void addTagClicked() {
        if (tagsSB.getValue() == null && tagsSB.getValue().isEmpty()) {
            return;
        }
        HttpService.HttpServiceAsync.instance().doPut(addTagUrl(), null,
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        loadTags();
                        new ResponseStatusWidget().show("Tag Added");
                    }
                });
        tagsSB.clearText();
    }

    protected String addTagUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "skillsettag/add-tag/" + getEntityId() + "/" + tagsSB.getValue());
    }

    protected void removeTagClicked() {
        if (tagsSB.getValue() == null && tagsSB.getValue().isEmpty()) {
            return;
        }
        HttpService.HttpServiceAsync.instance().doPut(removeTagUrl(), null,
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        loadTags();
                        new ResponseStatusWidget().show("Tag Removed");
                    }
                });
        tagsSB.clearText();
    }

    protected String removeTagUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "skillsettag/remove-tag/" + getEntityId() + "/" + tagsSB.getValue());
    }

    protected void loadTagSuggestions() {
        HttpService.HttpServiceAsync.instance().doGet(getTagsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    tagsSB.loadData(values);
                }
            }
        });
        loadTags();
    }

    protected void loadTags() {
        HttpService.HttpServiceAsync.instance().doGet(getTagsUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                if (entityString != null && !entityString.isEmpty()) {
                    tagsTA.setHTML(entityString);
                }
            }
        });
    }

    protected String getTagsUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/tags/" + getEntityId();
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

    @Override
    public void onKeyPress(KeyPressEvent event) {
        int keyCode = event.getUnicodeCharCode();
        if (keyCode == 0) {
            // Probably Firefox
            keyCode = event.getNativeEvent().getKeyCode();
        }
        if (keyCode == KeyCodes.KEY_ENTER) {
            addTagClicked();
        }
        if (keyCode == KeyCodes.KEY_DELETE) {
            logger.info("delete clicked");
            removeTagClicked();
        }
    }

    public void fireEvent() {
        loadTagSuggestions();
    }

}
