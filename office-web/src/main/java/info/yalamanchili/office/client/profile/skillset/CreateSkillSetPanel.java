/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
/**
 *
 * @author raghu
 */
public class CreateSkillSetPanel extends CreateComposite{
      public CreateSkillSetPanel(CreateComposite.CreateCompositeType type){
        super(type);
        initCreateComposite("SkillSet", OfficeWelcome.constants);
    }
      @Override
    protected void postCreateSuccess(String result) {
       

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
    }
         @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        
        return entity;
    }
          @Override
    protected void addWidgets() {
       
    }
          @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }
          @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" ;
    }
}
