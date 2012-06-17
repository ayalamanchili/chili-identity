/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.gwt.GenericPopup;

/**
 *
 * @author yalamanchili
 */
public class UpdateAddressPopupPanel extends UpdateAddressPanel {

    public UpdateAddressPopupPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.instance().hide();
        //TOOD refresh
    }
}
