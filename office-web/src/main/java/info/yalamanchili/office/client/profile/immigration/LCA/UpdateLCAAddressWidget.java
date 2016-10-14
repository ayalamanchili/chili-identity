/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.LCA;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.profile.address.UpdateAddressPanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class UpdateLCAAddressWidget extends UpdateAddressPanel {

    private static Logger logger = Logger.getLogger(UpdateLCAAddressWidget.class.getName());
    public UpdateLCAAddressWidget(JSONObject entity, UpdateAddressPanel.UpdateAddressPanelType type) {
        super(entity, type);
        update.setVisible(false);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        return super.populateEntityFromFields();
    }

    @Override
    protected void populateComments() {
        
    }
    
}
