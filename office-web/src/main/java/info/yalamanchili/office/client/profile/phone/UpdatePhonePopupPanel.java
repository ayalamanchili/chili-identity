/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.phone;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author yalamanchili
 */
public class UpdatePhonePopupPanel extends UpdatePhonePanel {

    public UpdatePhonePopupPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Update Phones Information");
        GenericPopup.instance().hide();
        TabPanel.instance().profilePanel.entityPanel.clear();
        TabPanel.instance().profilePanel.entityPanel.add(new ReadAllPhonesPopupPanel(OfficeWelcome.instance().employeeId));
    }
}
