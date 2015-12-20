/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.clientcontact;

import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.client.TreeClientPanel;
import info.yalamanchili.office.client.profile.contact.CreateContactPanel;

/**
 *
 * @author Ramana.Lukalapu
 */
public class CreateClientAcctPayCntPanel extends CreateContactPanel {

    public CreateClientAcctPayCntPanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Client Account Payable Contact");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientAcctPayContacts(TreeClientPanel.instance().getEntityId()));
        TabPanel.instance().adminPanel.entityPanel.add(new ClientAcctPayCntOptionsPanel());
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client/acct-pay-contact/" + TreeClientPanel.instance().getEntityId();
    }
}

