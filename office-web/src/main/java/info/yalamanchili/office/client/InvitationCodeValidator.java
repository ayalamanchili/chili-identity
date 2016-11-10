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
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.onboarding.EmployeeOnboardingPanel;
import info.yalamanchili.office.client.resources.OfficeImages;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author ayalamanchili
 */
public class InvitationCodeValidator {

    public static boolean validate(List<String> values) {
        if (values.size() == 1 && !Strings.isNullOrEmpty(values.get(0))) {
            JSONObject entity = new JSONObject();
            entity.put("invitationCode", new JSONString(values.get(0)));
            renderUI(entity, 1);
        }
        return false;
    }

    public static boolean validateParams(List<Entry> entryList) {
        if (entryList != null) {
            if (entryList.size() == 1) {
                Entry e = entryList.get(0);
                validate((List<String>) e.getValue());
            } else {
                JSONObject entity = new JSONObject();
                for (Entry e : entryList) {
                    String key = (String) e.getKey();
                    List<String> values = (List<String>) e.getValue();
                    if (values.size() == 1 && !Strings.isNullOrEmpty(values.get(0))) {
                        if (key.equalsIgnoreCase("invitecode")) {
                            entity.put("invitationCode", new JSONString(values.get(0)));
                        } else {
                            entity.put(key, new JSONString(values.get(0)));
                        }
                    }
                }
                renderUI(entity, entryList.size());
            }
        }
        return false;
    }

    public static void renderUI(JSONObject entity, int paramCount) {
        HttpService.HttpServiceAsync.instance().doPut(getInviteCodeValidateURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onSuccess(String arg0) {
                        RootPanel.get().clear();
                        RootPanel.get().removeFromParent();
                        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
                        if (entity.containsKey("invitationType") == true && entity.get("invitationType").isString().stringValue().equals("H1B_Questionnaire")) {
                            //RootPanel.get().add(new H1bQuestionnaireSentWidget(arg0));
                        } else {
                            RootPanel.get().add(new EmployeeOnboardingPanel(arg0));
                        }
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
                        RootPanel.get().removeFromParent();
                        error.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
                        RootPanel.get().add(error);
                    }
                });
    }

    protected static String getInviteCodeValidateURI() {
        return OfficeWelcome.constants.public_url() + "invitecode/validate";
    }
}
