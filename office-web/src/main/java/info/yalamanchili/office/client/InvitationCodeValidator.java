/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import com.google.common.base.Strings;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.onboarding.EmployeeOnboardingPanel;
import java.util.List;

/**
 *
 * @author ayalamanchili
 */
public class InvitationCodeValidator {

    public static boolean validate(List<String> values) {
        if (values.size() == 1 && !Strings.isNullOrEmpty(values.get(0))) {
            JSONObject entity = new JSONObject();
            entity.put("invitationCode", new JSONString(values.get(0)));
            HttpService.HttpServiceAsync.instance().doPut(getInviteCodeValidateURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new AsyncCallback<String>() {
                        @Override
                        public void onSuccess(String arg0) {
                            RootPanel.get().clear();
                            RootPanel.get().add(new EmployeeOnboardingPanel(arg0));
                        }

                        @Override
                        public void onFailure(Throwable caught) {
                            //TODO throw validation messge
                            HTML error = new HTML("\n"
                                    + "<p style=\"border: 1px solid rgb(100, 100, 100); padding: 5px 10px; background: rgb(238, 238, 238);\">"
                                    + "<strong style=\"color:#EF520F; align: center\">Invitation Code Is Invalid Or Expired</strong></p>\n"
                                    + "\n"
                                    + "<ul>\n"
                                    + "</ul>");
                            RootPanel.get().clear();
                            error.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                            RootPanel.get().add(error);
                        }
                    });
        }
        return false;
    }

    protected static String getInviteCodeValidateURI() {
        return OfficeWelcome.constants.root_url() + "invitecode/validate";
    }
}
