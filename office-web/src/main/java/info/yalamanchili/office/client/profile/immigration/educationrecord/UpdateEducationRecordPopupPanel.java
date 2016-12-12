/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.educationrecord;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author Sudha
 */
public class UpdateEducationRecordPopupPanel extends UpdateEducationRecordPanel {

    public UpdateEducationRecordPopupPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "educationrecord/save/" + OfficeWelcome.instance().employeeId;
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Education Record Information");
        GenericPopup.instance().hide();
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllEducationRecordPopupPanel(OfficeWelcome.instance().employeeId));
    }
}
