/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.json.client.JSONObject;

/**
 *
 * @author ayalamanchili
 */
public class UpdateAddressWidget extends UpdateAddressPanel {

    public UpdateAddressWidget(JSONObject entity, UpdateAddressPanelType type) {
        super(entity, type);
        update.setVisible(false);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        return super.populateEntityFromFields();
    }
}
