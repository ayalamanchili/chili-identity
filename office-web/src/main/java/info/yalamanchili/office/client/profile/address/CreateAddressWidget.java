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
public class CreateAddressWidget extends CreateAddressPanel {

    public CreateAddressWidget() {
        super(CreateCompositeType.CREATE);
        create.setVisible(false);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        return super.populateEntityFromFields();
    }
}
