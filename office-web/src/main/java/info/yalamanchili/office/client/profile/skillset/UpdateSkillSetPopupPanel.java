/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author ayalamanchili
 */
public class UpdateSkillSetPopupPanel extends UpdateSkillSetPanel {

    public UpdateSkillSetPopupPanel(String employeeId) {
        super(employeeId);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated employee Skill Information");
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshSkillSetPanel();
    }
}
