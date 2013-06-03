/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.PasswordField;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;

/**
 *
 * @author raghu
 */
public class ChangePasswordPanel extends CreateComposite {

    public ChangePasswordPanel(CreateCompositeType type) {

        super(type);
        initCreateComposite("ChangePassword", OfficeWelcome.constants);
        create.setText("Change Password");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject chgpassword = new JSONObject();
        // assignEntityValueFromField("userName", chgpassword);
        assignEntityValueFromField("oldPassword", chgpassword);
        assignEntityValueFromField("newPassword", chgpassword);
        chgpassword.put("userName", new JSONString("dummy"));
        return chgpassword;
    }

    @Override
    protected void createButtonClicked() {

        PasswordField newpassword = (PasswordField) fields.get("newPassword");

        PasswordField confirmpassword = (PasswordField) fields.get("confirmPassword");

        if (newpassword.getPassword().equals(confirmpassword.getPassword())) {
            HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String userString) {
                            if (userString != null && userString.trim().length() > 0) {

                                GenericPopup.instance().hide();
                                JSONObject user = (JSONObject) JSONParser.parseLenient(userString);
                                new ResponseStatusWidget().show("Change Password Successful");
                                Window.Location.reload();
                            } else {
                                new ResponseStatusWidget().show("Change Password Failed");
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
//        addField("userName", false, true, DataType.STRING_FIELD);
        addField("oldPassword", false, true, DataType.PASSWORD_FIELD);
        addField("newPassword", false, true, DataType.PASSWORD_FIELD);
        addField("confirmPassword", false, true, DataType.PASSWORD_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "admin/changepassword/" + OfficeWelcome.instance().employeeId;
    }
}
