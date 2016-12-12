/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextArea;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
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
public class UpdateSkillSetPanel extends UpdateComposite implements GenericListener {

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
    ClickableLink newTGL = new ClickableLink("Technology not present? submit request");
    /**
     * resume
     */
    FileuploadField resumeUploadPanel = new FileuploadField(OfficeWelcome.constants, "SkillSet", "skillSetFile", "SkillSet/skillSetFile", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(res);
        }
    };
    JSONArray skillSetResumeURL = new JSONArray();
    /**
     * Skill Set Tags
     *
     */
    CaptionPanel tagsCP = new CaptionPanel("Tags");
    FlowPanel tagsPanel = new FlowPanel();
    SuggestBox tagsSB = new SuggestBox(OfficeWelcome.constants, "search", "SkillSetTag", false, false);
    Button addTagB = new Button("Add Tag");
    Button removeTagB = new Button("Remove Tag");
    TextArea tagsTA = new TextArea();
    ClickableLink createTagL = new ClickableLink("Create New Tag");

    /**
     * Skills
     *
     */
    CaptionPanel skillp = new CaptionPanel("Skills");
    FlowPanel skillpanel = new FlowPanel();
    SuggestBox skillSB = new SuggestBox(OfficeWelcome.constants, "Search Skill", "Skill", false, false);
    Button addSkill = new Button("Add Skill");
    Button removeSkill = new Button("Remove Skill");
    TextArea skillTa = new TextArea();
    ClickableLink newSkill = new ClickableLink("Skills not present? submit request");

    /*
     * Certifications
     *
     */
    CaptionPanel certp = new CaptionPanel("Certifications");
    FlowPanel certPanel = new FlowPanel();
    SuggestBox certSB = new SuggestBox(OfficeWelcome.constants, "Search Certifications", "Certification", false, false);
    Button addCert = new Button("Add Certification");
    Button removeCert = new Button("Remove Certification");
    TextArea certTA = new TextArea();
    ClickableLink newCert = new ClickableLink("Certifications not present? submit request");

    public UpdateSkillSetPanel(JSONObject entity) {
        initUpdateComposite(entity, "SkillSet", OfficeWelcome.constants);
        entityActionsPanel.add(certp);
        entityActionsPanel.add(skillp);
        entityActionsPanel.add(tagsCP);
        loadCertSuggestions();
        loadSkillSuggestions();
        loadTagSuggestions();
    }

    public UpdateSkillSetPanel() {
        initUpdateComposite("", "SkillSet", OfficeWelcome.constants);
        this.entityId = null;
        entityActionsPanel.add(certp);
        entityActionsPanel.add(skillp);
        entityActionsPanel.add(tagsCP);
        loadCertSuggestions();
        loadSkillSuggestions();
        loadTagSuggestions();
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                entity = (JSONObject) JSONParser.parseLenient(response);
                logger.info("populate Fields FromEntity" + entity);
                populateFieldsFromEntity(entity);
            }
        });
    }

    public String getReadURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + OfficeWelcome.instance().employeeId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity.put("practice", practiceF.getSelectedObject());
        entity.put("technologyGroup", technoglogyGroupF.getSelectedObject());
        assignEntityValueFromField("skillSetFileType", entity);
        int j = skillSetResumeURL.size();
        logger.info(skillSetResumeURL.toString());
        for (JSONString fileName : resumeUploadPanel.getFileNames()) {
            if (fileName != null && !fileName.stringValue().trim().isEmpty()) {
                JSONObject resume = new JSONObject();
                resume.put("fileURL", fileName);
                resume.put("name", entity.get("skillSetFileType"));
//                resume.put("name", new JSONString("File Name"));
                skillSetResumeURL.set(j, resume);
                j++;
            }
        }
        if (skillSetResumeURL.size() > 0) {
            entity.put("skillSetFile", skillSetResumeURL);
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
                entity = (JSONObject) JSONParser.parseLenient(arg0);
            }
        });

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info("populate Fields FromEntity 123" + entity);
        assignFieldValueFromEntity("practice", entity, null);
        assignFieldValueFromEntity("technologyGroup", entity, null);
        assignFieldValueFromEntity("skillSetFileType", entity, DataType.ENUM_FIELD);
        skillSetResumeURL = JSONUtils.toJSONArray(entity.get("skillSetFile"));
        if (skillSetResumeURL.size() > 0) {
            populateResumes(skillSetResumeURL);
        }
    }

    protected void populateResumes(JSONArray items) {
        if (TabPanel.instance().profilePanel.isVisible()) {
            entityFieldsPanel.insert(new ReadAllSkillSetFilesPanel(OfficeWelcome.instance().employeeId, items), entityFieldsPanel.getWidgetIndex(resumeUploadPanel) + 1);
        } else {
            entityFieldsPanel.insert(new ReadAllSkillSetFilesPanel(TreeEmployeePanel.instance().getEntityId(), items), entityFieldsPanel.getWidgetIndex(resumeUploadPanel) + 1);
        }
    }

    protected void uploadResume(String entityId) {
        JSONObject post = (JSONObject) JSONParser.parseLenient(entityId);
        JSONArray resumeURL = JSONUtils.toJSONArray(post.get("skillSetFile"));
        resumeUploadPanel.upload(resumeURL, "fileURL");
    }

    @Override
    protected void postUpdateSuccess(String result) {
        extractResumeContent();
        new ResponseStatusWidget().show("Successfully Updated Employee Skill Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateSkillSetPanel(entity));
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
        newSkill.addClickHandler(this);
        newCert.addClickHandler(this);
        addTagB.addClickHandler(this);
        removeTagB.addClickHandler(this);
        tagsSB.getSuggestBox().addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                if (event.getCharCode() == KeyCodes.KEY_ENTER) {
                    addTagClicked();
                }
                if (event.getCharCode() == KeyCodes.KEY_DELETE) {
                    removeTagClicked();
                }
            }
        });
        skillSB.getSuggestBox().addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                if (event.getCharCode() == KeyCodes.KEY_ENTER) {
                    addSkillClicked();
                }
                if (event.getCharCode() == KeyCodes.KEY_DELETE) {
                    removeSkillClicked();
                }
            }
        });
        certSB.getSuggestBox().addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent event) {
                if (event.getCharCode() == KeyCodes.KEY_ENTER) {
                    addCertClicked();
                }
                if (event.getCharCode() == KeyCodes.KEY_DELETE) {
                    removeCertClicked();
                }
            }
        });
        addSkill.addClickHandler(this);
        removeSkill.addClickHandler(this);
        addCert.addClickHandler(this);
        removeCert.addClickHandler(this);
        createTagL.addClickHandler(this);
        newCert.addClickHandler(this);
        newSkill.addClickHandler(this);
    }

    @Override
    protected void configure() {
        tagsTA.setWidth("100%");
        tagsTA.setEnabled(false);
        tagsTA.setVisibleLines(3);
        skillTa.setWidth("100%");
        skillTa.setEnabled(false);
        skillTa.setVisibleLines(3);
        certTA.setWidth("100%");
        certTA.setEnabled(false);
        certTA.setVisibleLines(3);
    }

    @Override
    protected void addWidgets() {
        addDropDown("practice", practiceF);
        entityFieldsPanel.add(newPracticeL);
        addDropDown("technologyGroup", technoglogyGroupF);
        entityFieldsPanel.add(newTGL);
        entityFieldsPanel.add(getLineSeperatorTag("Upload Resume and Certifications"));
        addEnumField("skillSetFileType", false, false, SkillSetFileType.names());
        entityFieldsPanel.add(resumeUploadPanel);
        //Tags
        tagsPanel.add(new HTML("<p><b>Add Tags that will reflect your niche skills. These are used by search engine for find new opportunities. </br> You can create new Tags as needed.</b></p>"));
        tagsPanel.add(tagsSB);
        tagsSB.addWidgetToFieldPanel(createTagL);
        tagsPanel.add(addTagB);
        tagsPanel.add(removeTagB);
        tagsPanel.add(tagsTA);
        tagsCP.setContentWidget(tagsPanel);
        //Skills
        skillpanel.add(skillSB);
        skillSB.addWidgetToFieldPanel(newSkill);
        skillpanel.add(addSkill);
        skillpanel.add(removeSkill);
        skillpanel.add(skillTa);
        skillp.setContentWidget(skillpanel);
        //Certifications
        certPanel.add(certSB);
        certSB.addWidgetToFieldPanel(newCert);
        certPanel.add(addCert);
        certPanel.add(removeCert);
        certPanel.add(certTA);
        certp.setContentWidget(certPanel);
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
        if (event.getSource().equals(newSkill)) {
            new GenericPopup(new GenericBPMStartFormPanel("AddNewSkillRequest", "add_new_skill_request"), newSkill.getAbsoluteLeft(), newSkill.getAbsoluteTop()).show();
        }
        if (event.getSource().equals(newCert)) {
            new GenericPopup(new GenericBPMStartFormPanel("AddNewCertificationsRequest", "add_new_certification_request"), newCert.getAbsoluteLeft(), newCert.getAbsoluteTop()).show();
        }
        if (event.getSource().equals(addTagB)) {
            addTagClicked();
        }
        if (event.getSource().equals(removeTagB)) {
            removeTagClicked();
        }
        if (event.getSource().equals(addSkill)) {
            addSkillClicked();
        }
        if (event.getSource().equals(removeSkill)) {
            removeSkillClicked();
        }
        if (event.getSource().equals(addCert)) {
            addCertClicked();
        }
        if (event.getSource().equals(removeCert)) {
            removeCertClicked();
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
        return OfficeWelcome.constants.root_url() + "skillsettag/add-tag/" + tagsSB.getValue() + "?skillSetId=" + getEntityId();
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
        return OfficeWelcome.constants.root_url() + "skillsettag/remove-tag/" + tagsSB.getValue() + "?skillSetId=" + getEntityId();
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
                    tagsTA.setText(entityString);
                } else {
                    tagsTA.setText("");
                }
            }
        });
    }

    protected String getTagsUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/tags/" + getEntityId();
    }

    protected String getTagsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/dropdown/0/10000?column=id&column=name";
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + TreeEmployeePanel.instance().getEntityId();
    }

    protected void addSkillClicked() {
        if (skillSB.getValue() == null && skillSB.getValue().isEmpty()) {
            return;
        }
        HttpService.HttpServiceAsync.instance().doPut(addSkillUrl(), null,
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                loadSkills();
                new ResponseStatusWidget().show("Skill Added");
            }
        });
        skillSB.clearText();
    }

    protected String addSkillUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/add/" + skillSB.getValue() + "?skillSetId=" + getEntityId();
    }

    protected void removeSkillClicked() {
        if (skillSB.getValue() == null && skillSB.getValue().isEmpty()) {
            return;
        }
        HttpService.HttpServiceAsync.instance().doPut(removeSkillUrl(), null,
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                loadSkills();
                new ResponseStatusWidget().show("Skill Removed");
            }
        });
        skillSB.clearText();
    }

    protected String removeSkillUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/remove/" + skillSB.getValue() + "?skillSetId=" + getEntityId();
    }

    protected void loadSkillSuggestions() {
        HttpService.HttpServiceAsync.instance().doGet(getSkillsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    skillSB.loadData(values);
                }
            }
        });
        loadSkills();
    }

    protected void loadSkills() {
        HttpService.HttpServiceAsync.instance().doGet(getSkillsUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                if (entityString != null && !entityString.isEmpty()) {
                    skillTa.setText(entityString);
                } else {
                    skillTa.setText("");
                }
            }
        });
    }

    protected String getSkillsUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/" + getEntityId();
    }

    protected String getSkillsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "skill/dropdown/0/10000?column=id&column=name";
    }

    protected void addCertClicked() {
        if (certSB.getValue() == null && certSB.getValue().isEmpty()) {
            return;
        }
        HttpService.HttpServiceAsync.instance().doPut(addCertUrl(), null,
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                loadCertfications();
                new ResponseStatusWidget().show("Certification Added");
            }
        });

        certSB.clearText();
    }

    protected String addCertUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/certifications/add/" + certSB.getValue() + "?skillSetId=" + getEntityId();
    }

    protected void removeCertClicked() {
        if (certSB.getValue() == null && certSB.getValue().isEmpty()) {
            return;
        }
        HttpService.HttpServiceAsync.instance().doPut(removeCertUrl(), null,
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                loadCertfications();
                new ResponseStatusWidget().show("Certification Removed");
            }
        });
        certSB.clearText();
    }

    protected String removeCertUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/certifications/remove/" + certSB.getValue() + "?skillSetId=" + getEntityId();
    }

    protected void loadCertSuggestions() {
        HttpService.HttpServiceAsync.instance().doGet(getCertDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    certSB.loadData(values);
                }
            }
        });
        loadCertfications();
    }

    protected void loadCertfications() {
        HttpService.HttpServiceAsync.instance().doGet(getCertificationssUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                if (entityString != null && !entityString.isEmpty()) {
                    certTA.setText(entityString);
                } else {
                    certTA.setText("");
                }
            }
        });
    }

    protected String getCertificationssUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/certifications/" + getEntityId();
    }

    protected String getCertDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "certification/dropdown/0/10000?column=id&column=name";
    }

    public void fireEvent() {
        loadTagSuggestions();
        loadSkillSuggestions();
        loadCertSuggestions();
    }
}
