/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.PasswordField;
import info.chili.gwt.rpc.HttpService;

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
        assignEntityValueFromField("oldPassword", chgpassword);
        assignEntityValueFromField("newPassword", chgpassword);
        chgpassword.put("userName", new JSONString("dummy"));
        return chgpassword;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String userString) {
                        if (userString != null && userString.trim().length() > 0) {
                            new ResponseStatusWidget().show("Change Password Successful");
                            Timer t = new Timer() {
                                @Override
                                public void run() {
                                    Window.Location.reload();
                                }
                            };
                            t.schedule(3000);
                        } else {
                            new ResponseStatusWidget().show("Change Password Failed");
                        }
                    }
                }
        );
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        PasswordField newpassword = (PasswordField) fields.get("newPassword");
        PasswordField confirmpassword = (PasswordField) fields.get("confirmPassword");
        if (!newpassword.getPassword().equals(confirmpassword.getPassword())) {
            new ResponseStatusWidget().show("New password and Confirm Password are not same");
            return false;
        }
        return true;
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
