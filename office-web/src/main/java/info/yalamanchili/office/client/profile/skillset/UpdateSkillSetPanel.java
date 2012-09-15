/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.FileUploadPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateSkillSetPanel extends UpdateComposite {
    
    private static Logger logger = Logger.getLogger(UpdateSkillSetPanel.class.getName());
    FileUploadPanel resumeUploadPanel = new FileUploadPanel(OfficeWelcome.constants, "SkillSet", "resumeUrl", "SkillSet/resumeUrl") {
        @Override
        public void onUploadComplete() {
            postUpdateSuccess(null);
        }
    };
    protected String employeeId;
    
    public UpdateSkillSetPanel(String employeeId) {
        this.employeeId = employeeId;
        initUpdateComposite(entity, "SkillSet", OfficeWelcome.constants);
        loadSkillSet();
    }
    
    protected void loadSkillSet() {
        HttpService.HttpServiceAsync.instance().doGet(getURI(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                if (arg0 != null) {
                    entity = (JSONObject) JSONParser.parseLenient(arg0);
                }
            }
        });
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject skillSet = new JSONObject();
        skillSet.put("resumeUrl", resumeUploadPanel.getFileName());
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
    }
    
    protected void uploadResume(String entityId) {
        resumeUploadPanel.upload(entityId.trim());
    }
    
    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated employee Skill Information");
//        TabPanel.instance().myOfficePanel.clear();
//        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadSkillSetPanel(result));
    }
    
    @Override
    protected void addListeners() {
    }
    
    @Override
    protected void configure() {
    }
    
    @Override
    protected void addWidgets() {
        entityDisplayWidget.add(resumeUploadPanel);
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + employeeId;
    }
}
