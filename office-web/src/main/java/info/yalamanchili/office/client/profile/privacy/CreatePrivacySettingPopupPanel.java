/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.privacy;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author Prashanthi.P
 */
public class CreatePrivacySettingPopupPanel extends CreatePrivacySettingPanel {

    public CreatePrivacySettingPopupPanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Privacy Data");
        GenericPopup.instance().hide();
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllPrivacySettingPopupPanel(OfficeWelcome.instance().employeeId));
    }

    @Override
    protected String getEmployeeId() {
        return OfficeWelcome.instance().employeeId;
    }
}
