/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.clientcontact;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.client.TreeClientPanel;
import info.yalamanchili.office.client.profile.contact.UpdateContactPanel;

/**
 *
 * @author Ramana.Lukalapu
 */
public class UpdateClientAcctPayCntPanel extends UpdateContactPanel {

    public UpdateClientAcctPayCntPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Client Accounts Payable contact");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientAcctPayContacts(TreeClientPanel.instance().getEntityId()));
    }
}
