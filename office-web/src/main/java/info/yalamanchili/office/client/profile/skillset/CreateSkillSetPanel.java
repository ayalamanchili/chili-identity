/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import java.util.logging.Logger;
import info.yalamanchili.office.client.gwt.FileUploadPanel;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.rpc.HttpService;
/**
 *
 * @author raghu
 */
public class CreateSkillSetPanel extends CreateComposite{
     private static Logger logger = Logger.getLogger(CreateSkillSetPanel.class.getName());
    FileUploadPanel empresumeUploadPanel = new FileUploadPanel("resume", "Date1");
      public CreateSkillSetPanel(CreateComposite.CreateCompositeType type){
        super(type);
        initCreateComposite("SkillSet", OfficeWelcome.constants);
    }
      @Override
    protected void postCreateSuccess(String result) {
       
        new ResponseStatusWidget().show("successfully created employee");
        TabPanel.instance().myOfficePanel.clear();
    }
      
       @Override
    protected void addButtonClicked() {
           
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
        // TODO Auto-generated method stub
             empresumeUploadPanel.upload();
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
                    }
                });
    }
         @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        
        return entity;
    }
          @Override
    protected void addWidgets() {
        addField("lastUpdated", true, true, DataType.DATE_FIELD);
        addField("resumeUrl", true, true, DataType.STRING_FIELD);
        entityDisplayWidget.add(empresumeUploadPanel);
    }
          @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }
          @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset" ;
    }
}
