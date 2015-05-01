/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

/**
 *
 * @author ayalamanchili
 */
public class UpdateHomeAddressPanel extends UpdateAddressPanel {

    public UpdateHomeAddressPanel(JSONObject entity) {
        super(entity, UpdateAddressPanelType.MIN);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = super.populateEntityFromFields();
        JSONObject addressType = new JSONObject();
        addressType.put("addressType", new JSONString("Home"));
        entity.put("addressType", addressType);
        return entity;
    }
}
