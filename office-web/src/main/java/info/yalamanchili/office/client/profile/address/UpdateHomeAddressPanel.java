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
public class UpdateHomeAddressPanel extends UpdateAddressPanel {

    public UpdateHomeAddressPanel(JSONObject entity) {
        super(entity, UpdateAddressPanelType.MIN);
    }

}
