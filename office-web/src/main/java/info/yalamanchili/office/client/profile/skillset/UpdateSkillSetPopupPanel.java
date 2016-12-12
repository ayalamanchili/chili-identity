/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author ayalamanchili
 */
public class UpdateSkillSetPopupPanel extends UpdateSkillSetPanel {

    public UpdateSkillSetPopupPanel() {
        super();
    }

    public UpdateSkillSetPopupPanel(JSONObject object) {
        super(object);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        extractResumeContent();
        new ResponseStatusWidget().show("Successfully Updated Employee Skill Information");
        HttpService.HttpServiceAsync.instance().doGet(getSkillSetUrl(OfficeWelcome.instance().employeeId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        TabPanel.instance().profilePanel.entityPanel.clear();
                        TabPanel.instance().profilePanel.entityPanel.add(new UpdateSkillSetPopupPanel(JSONParser.parseLenient(response).isObject()));
                    }
                });
    }

    private String getSkillSetUrl(String employeeId) {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + employeeId;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + OfficeWelcome.instance().employeeId;
    }

    @Override
    protected String addTagUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/add-tag/" + tagsSB.getValue();
    }

    @Override
    protected String removeTagUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/remove-tag/" + tagsSB.getValue();
    }

    @Override
    protected String getTagsUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/tags";
    }

    @Override
    protected String addSkillUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/add/" + skillSB.getValue();
    }

    @Override
    protected String removeSkillUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/remove/" + skillSB.getValue();
    }

    protected String getSkillsUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/skills/";
    }

    @Override
    protected String addCertUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/certifications/add/" + certSB.getValue();
    }

    @Override
    protected String removeCertUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/certifications/remove/" + certSB.getValue();
    }

    @Override
    protected String getCertificationssUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/certifications/";
    }

}
