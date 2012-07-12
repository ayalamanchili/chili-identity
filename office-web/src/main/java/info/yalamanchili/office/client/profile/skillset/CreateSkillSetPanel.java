/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.fields.StringField;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.FileUploadPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateSkillSetPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateSkillSetPanel.class.getName());
    FileUploadPanel resumeUploadPanel = new FileUploadPanel("Resume", "resume");

    public CreateSkillSetPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("SkillSet", OfficeWelcome.constants);
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
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("successfully created skllset");
        TabPanel.instance().myOfficePanel.clear();
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject skillSet = new JSONObject();
        assignImageName();
        skillSet.put("resumeUrl", resumeUploadPanel.getFileName());
        logger.info(skillSet.toString());
        return skillSet;
    }

    protected void assignImageName() {
        resumeUploadPanel.setFileName("resume/" + TreeEmployeePanel.instance().getEntityId() + "_");
    }

    @Override
    protected void addButtonClicked() {
        resumeUploadPanel.upload();
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        logger.info(arg0);
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addWidgets() {
        entityDisplayWidget.add(resumeUploadPanel);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/"+TreeEmployeePanel.instance().getEntityId();
    }
}
