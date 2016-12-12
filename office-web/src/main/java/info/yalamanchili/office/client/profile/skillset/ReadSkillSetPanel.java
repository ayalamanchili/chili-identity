/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import static com.axeiya.gwtckeditor.client.CKConfig.AVAILABLE_PLUGINS.table;
import com.google.gwt.json.client.JSONArray;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.FileField;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;
import info.yalamanchili.office.client.profile.technologyGroup.SelectTechnologyGroupWidget;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ReadSkillSetPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadSkillSetPanel.class.getName());
    protected String empId;
    SelectPracticeWidget practiceF = new SelectPracticeWidget(false, false);
    SelectTechnologyGroupWidget technologyGroupF = new SelectTechnologyGroupWidget(false, false);
    //Tags
    CaptionPanel tagsCP = new CaptionPanel("Tags");
    FlowPanel tagsPanel = new FlowPanel();
    RichTextArea tagsTA = new RichTextArea();
    //Skills
    CaptionPanel skillsCP = new CaptionPanel("Skills");
    FlowPanel skillsPanel = new FlowPanel();
    RichTextArea skillsTA = new RichTextArea();
    //Certifications
    CaptionPanel certCP = new CaptionPanel("Certifications");
    FlowPanel certPanel = new FlowPanel();
    RichTextArea certTA = new RichTextArea();
    private static ReadSkillSetPanel instance;

    public static ReadSkillSetPanel instance() {
        return instance;
    }

    public ReadSkillSetPanel() {
        instance = this;
    }

    public ReadSkillSetPanel(String empId) {
        instance = this;
        this.empId = empId;
        initReadComposite("SkillSet", OfficeWelcome.constants);
    }

    public ReadSkillSetPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "SkillSet", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        tagsTA.setWidth("100%");
        skillsTA.setWidth("100%");
        certTA.setWidth("100%");
        tagsTA.setEnabled(false);
        skillsTA.setEnabled(false);
        certTA.setEnabled(false);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void loadEntity(String entityId) {
        HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                onLoadSuccess(response);
            }
        });
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
        loadSkills();
    }

    protected String getTagsUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/tags/" + getEntityId();
    }

    protected void loadSkills() {
        HttpService.HttpServiceAsync.instance().doGet(getSkillsUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                if (entityString != null && !entityString.isEmpty()) {
                    skillsTA.setHTML(entityString);
                }
            }
        });
        loadCertfications();
    }

    protected String getSkillsUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/" + getEntityId();
    }

    protected void loadCertfications() {
        HttpService.HttpServiceAsync.instance().doGet(getCertificationssUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                if (entityString != null && !entityString.isEmpty()) {
                    certTA.setHTML(entityString);
                }
            }
        });
    }

    protected String getCertificationssUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/certifications/" + getEntityId();
    }

    protected void onLoadSuccess(String response) {
        logger.info("resume upload of skill set " + entity);
        if (response != null && !response.isEmpty()) {
            entity = (JSONObject) JSONParser.parseLenient(response);
            HttpService.HttpServiceAsync.instance().doGet(getResumes(entityId), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String entityString) {
                    if (entityString != null && !entityString.isEmpty()) {
                        JSONObject resumeURL = JSONParser.parseLenient(entityString).isObject();
                        JSONArray array = new JSONArray();
                        if (resumeURL != null) {
                            array.set(0, resumeURL);
                            populateResumes(array);
                        }
                    }
                }
            });
            populateFieldsFromEntity(entity);

        } else {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            if (Auth.isAdmin() || Auth.isHR()) {
                TabPanel.instance().myOfficePanel.entityPanel.add(new CreateSkillSetPanel(empId));
            } else {
                TabPanel.instance().myOfficePanel.entityPanel.add(new HTML("No SkillSet Information"));
            }
        }
    }

    protected String getResumes(String entityId) {
        return OfficeWelcome.constants.root_url() + "skillset/resumes/" + entityId;
    }

    protected void populateResumes(JSONArray items) {
        logger.info("populate Fields From Entity" + items);
        entityFieldsPanel.add(new ReadAllSkillSetFilesPanel(getEntityId(), items));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info("populate Fields From Entity" + entity);
        assignFieldValueFromEntity("practice", entity, null);
        assignFieldValueFromEntity("technologyGroup", entity, null);
        assignFieldValueFromEntity("lastUpdated", entity, DataType.DATE_FIELD);
        if (entity.containsKey("skillSetFile")) {
            JSONObject resumeURL = entity.get("skillSetFile").isObject();
            JSONArray array = new JSONArray();
            if (resumeURL != null) {
                array.set(0, resumeURL);
                populateResumes(array);
            }
        }
        //entityFieldsPanel.add(new SkillSetOptionsPanel(empId));
        loadTags();
    }

    @Override
    protected void addWidgets() {
        addField("lastUpdated", true, false, DataType.DATE_FIELD);
        addDropDown("practice", practiceF);
        addDropDown("technologyGroup", technologyGroupF);
        //Certifications
        certPanel.add(certTA);
        certCP.setContentWidget(certPanel);
        entityFieldsPanel.add(certCP);
        //Skills
        skillsPanel.add(skillsTA);
        skillsCP.setContentWidget(skillsPanel);
        entityFieldsPanel.add(skillsCP);
        //tags
        tagsPanel.add(tagsTA);
        tagsCP.setContentWidget(tagsPanel);
        entityFieldsPanel.add(tagsCP);
    }

    @Override
    public String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + empId;
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllSkillSetFilesPanel.instance;
    }    
    
    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "profile/skillset.html";
    }
}
