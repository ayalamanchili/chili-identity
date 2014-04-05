/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author ayalamanchili
 */
public class UpdateSkillSetPopupPanel extends UpdateSkillSetPanel {

    public UpdateSkillSetPopupPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee Skill Information");
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshSkillSetPanel();
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + OfficeWelcome.instance().employeeId;
    }

    @Override
    protected String addTagUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "skillsettag/add-tag/" + tagsSB.getValue());
    }

    @Override
    protected String removeTagUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "skillsettag/remove-tag/" + tagsSB.getValue());
    }

    protected String getTagsUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/tags";
    }
}
