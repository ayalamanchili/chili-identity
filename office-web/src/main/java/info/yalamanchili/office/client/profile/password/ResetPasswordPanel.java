/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.password;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.PasswordField;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService;

/**
 *
 * @author raghu
 */
public class ResetPasswordPanel extends CreateComposite {

    public ResetPasswordPanel(CreateCompositeType type) {

        super(type);
        initCreateComposite("ResetPassword", OfficeWelcome.constants);
        create.setText("Reset Password");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject rstpassword = new JSONObject();
        assignEntityValueFromField("newPassword", rstpassword);
        rstpassword.put("userName",new JSONString("dummy"));
        rstpassword.put("oldPassword",new JSONString("abcde"));
        return rstpassword;
    }

    @Override
    protected void createButtonClicked() {
        PasswordField newpassword = (PasswordField) fields.get("newPassword");

        PasswordField confirmpassword = (PasswordField) fields.get("confirmPassword");

        if (newpassword.getPassword().equals(confirmpassword.getPassword())) {
            HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new AsyncCallback<String>() {
                        @Override
                        public void onFailure(Throwable arg0) {
                            new ResponseStatusWidget().show("Reset Password Failed");
                        }

                        @Override
                        public void onSuccess(String userString) {
                            if (userString != null && userString.trim().length() > 0) {
                                new ResponseStatusWidget().show("Reset Password Successful");
                            } else {
                                new ResponseStatusWidget().show("Reset Password Failed");
                            }

                        }
                    });
        } else {
            new ResponseStatusWidget().show("New password and Confirm Password are not same");
        }
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
        addField("newPassword", false, true, DataType.PASSWORD_FIELD);
        addField("confirmPassword", false, true, DataType.PASSWORD_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "admin/resetpassword/" + TreeEmployeePanel.instance().getEntityId();
    }
}
