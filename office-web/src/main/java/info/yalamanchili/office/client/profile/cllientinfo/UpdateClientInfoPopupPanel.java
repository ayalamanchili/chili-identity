/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author yalamanchili
 */
public class UpdateClientInfoPopupPanel extends UpdateClientInfoPanel {

    public UpdateClientInfoPopupPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshClientInformation();
    }
}