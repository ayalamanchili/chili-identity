/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author yalamanchili
 */
public class UpdateAddressPopupPanel extends UpdateAddressPanel {

    public UpdateAddressPopupPanel(JSONObject entity, UpdateAddressPanelType type) {
        super(entity, type);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee Address");
        GenericPopup.instance().hide();
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllAddressesPopupPanel(OfficeWelcome.instance().employeeId));
    }
}
