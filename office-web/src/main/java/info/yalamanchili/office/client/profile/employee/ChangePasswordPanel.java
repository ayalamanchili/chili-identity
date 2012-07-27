/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.login.LoginPanel;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author raghu
 */
public class ChangePasswordPanel extends CreateComposite {

     public ChangePasswordPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("Change Password", OfficeWelcome.constants);
    }
    @Override
    protected JSONObject populateEntityFromFields() {
         JSONObject chgpassword = new JSONObject();
        assignEntityValueFromField("userName", chgpassword);
        assignEntityValueFromField("oldPassword", chgpassword);
        assignEntityValueFromField("newPassword", chgpassword);
        return chgpassword;
    }

    @Override
    protected void createButtonClicked() {
       HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                       new ResponseStatusWidget().show("Change Password failed");
                    }

                    @Override
                    public void onSuccess(String userString) {
                       if (userString != null && userString.trim().length() > 0) {
					
                                        
					JSONObject user = (JSONObject) JSONParser.parseLenient(userString);
                                        OfficeWelcome.instance().username = user.get("username").toString() ;
					OfficeWelcome.instance().password = user.get("passwordHash").toString();
					OfficeWelcome.instance().onMainModuleLoad(user);
				} else {
					new ResponseStatusWidget().show("Change Password failed");
				}
                        
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
        
    }

    @Override
    protected void postCreateSuccess(String result) {
      
    }

    @Override
    protected void addListeners() {
        
    }

    @Override
    protected void configure() {
       
    }

    @Override
    protected void addWidgets() {
        addField("userName", false, true, DataType.STRING_FIELD);
        addField("oldPassword", false, true, DataType.STRING_FIELD);
        addField("newPassword", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
       
    }

    @Override
    protected String getURI() {
       return OfficeWelcome.constants.root_url() + "admin/changepassword";
    }
    
}
