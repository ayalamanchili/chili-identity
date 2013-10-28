/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author anuyalamanchili
 */
public class ReadClientInfoPopupPanel extends ReadClientInfoPanel {

    public ReadClientInfoPopupPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected boolean checkPermission() {
        return true;
    }

    protected JSONObject getEmployee() {
        return OfficeWelcome.instance().employee;
    }
}
