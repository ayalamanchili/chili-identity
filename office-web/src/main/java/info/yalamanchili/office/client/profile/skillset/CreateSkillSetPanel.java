/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.fields.StringField;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.FileUploadPanel;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateSkillSetPanel extends CreateComposite {
    
    private static Logger logger = Logger.getLogger(CreateSkillSetPanel.class.getName());
    FileUploadPanel resumeUploadPanel = new FileUploadPanel("Resume", "SkillSet/resumeUrl");
    
    public CreateSkillSetPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("SkillSet", OfficeWelcome.constants);
    }
    
    @Override
    protected void addWidgets() {
        addField("lastUpdated", true, false, DataType.DATE_FIELD);
        entityDisplayWidget.add(resumeUploadPanel);
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
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject skillSet = new JSONObject();
        assignEntityValueFromField("lastUpdated", skillSet);
        skillSet.put("resumeUrl", resumeUploadPanel.getFileName());
        return skillSet;
    }
    
    @Override
    protected void addButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }
                    
                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                        uploadResume(arg0);
                    }
                });
    }
    
    protected void uploadResume(String entityId) {
        logger.info(entityId);
        resumeUploadPanel.upload(entityId.trim());
    }
    
    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("successfully created skllset");
        TabPanel.instance().myOfficePanel.clear();
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + TreeEmployeePanel.instance().getEntityId();
    }
}
