/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author ayalamanchili
 */
public class CreateSkillSetPopupPanel extends CreateSkillSetPanel {

    public CreateSkillSetPopupPanel(String employeeId) {
        super(employeeId);
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("successfully created skllset");
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshSkillSetPanel();
    }
}
