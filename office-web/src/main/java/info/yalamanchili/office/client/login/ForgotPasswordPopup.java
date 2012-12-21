/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.login;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;

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
        }
    }

    protected String getUrl(String empId) {
        return null;
    }
}
