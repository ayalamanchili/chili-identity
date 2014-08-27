/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
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
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.rpc.HttpService;

/**
 *
 * @author Prashanthi
 */
class ForgotPasswordPopup extends Composite implements ClickHandler {

    FlowPanel panel = new FlowPanel();
    StringField empIdTb = new StringField(OfficeWelcome.constants, "employeeId", "ForgotPassword", false, true);
    Button forgotPasswordB = new Button("Send Password");

    public ForgotPasswordPopup() {
        initWidget(panel);
        panel.add(empIdTb);
        panel.add(forgotPasswordB);
        forgotPasswordB.addClickHandler(this);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(forgotPasswordB)) {
            HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            new ResponseStatusWidget().show("Temporary password has been send to:"+arg0);
                            GenericPopup.instance().hide();
                        }
                    });
        }
    }

    private String getURI() {
        return OfficeWelcome.constants.public_url() + "admin/forgotpassword/" + empIdTb.getValue();
    }
}
