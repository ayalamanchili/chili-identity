/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
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
        new ResponseStatusWidget().show("Successfully Created Skllset");
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshSkillSetPanel();
    }
}
