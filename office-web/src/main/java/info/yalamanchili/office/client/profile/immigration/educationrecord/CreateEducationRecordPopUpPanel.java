/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.educationrecord;

import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author Sudha
 */
public class CreateEducationRecordPopUpPanel extends CreateEducationRecordPanel {

    public CreateEducationRecordPopUpPanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "educationrecord/save/" + OfficeWelcome.instance().employeeId;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Employee Education Record");
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllEducationRecordPopupPanel(OfficeWelcome.instance().employeeId));
        GenericPopup.instance().hide();
    }

}
