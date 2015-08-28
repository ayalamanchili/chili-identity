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
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.profile.employee.CreateEmployeeOnboardingPanel;
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
                            new GenericPopup(new CreateEmployeeOnboardingPanel()).show();
                        }

                        @Override
                        public void onFailure(Throwable caught) {
//TODO throw validation messge
                        }
                    });
        }
        return false;
    }

    protected static String getInviteCodeValidateURI() {
        return OfficeWelcome.constants.root_url() + "invitecode/validate";
    }
}
