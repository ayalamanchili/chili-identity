/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.login;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author Prashanthi
 */
class ForgotPasswordPopup extends Composite implements ClickHandler {
    
    FlowPanel panel = new FlowPanel();
    TextBox empIdTb = new TextBox();
    Button forgotPasswordB = new Button("Send Password");
    
    public ForgotPasswordPopup() {
        initWidget(panel);
    }
    
    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(forgotPasswordB)) {
            //call service here with empid in url (empIdTb.getText())
            HttpService.HttpServiceAsync.instance().doPut(getURI(), empIdTb.getText(), OfficeWelcome.instance().getHeaders(), true,
                    new AsyncCallback<String>() {
                        String SuccessMessage = "reset password of the employee";
                        
                        @Override
                        public void onFailure(Throwable arg0) {
                            Window.alert("Unsupported file extension");
                            
                        }
                        
                        @Override
                        public void onSuccess(String arg0) {
                            new ResponseStatusWidget().show(getSuccessMessage());
                        }
                        
                        private String getSuccessMessage() {
                            return SuccessMessage;
                        }
                    });
        }
    }
    
    protected String getUrl(String empId) {
        return null;
    }
    
    private String getURI() {
        return OfficeWelcome.constants.root_url() + "admin/resetpassword";
    }
}
