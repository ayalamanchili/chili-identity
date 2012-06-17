/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.reportsto;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.ProfileHome;

/**
 *
 * @author yalamanchili
 */
public class UpdateReportsToPopupPanel extends UpdateReportsToPanel {

    public UpdateReportsToPopupPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.instance().hide();
        ProfileHome.instance().refreshReportsTo();
    }
}