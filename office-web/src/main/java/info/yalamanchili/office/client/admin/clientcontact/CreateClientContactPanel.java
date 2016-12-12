/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.clientcontact;

import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.contact.CreateContactPanel;
import info.yalamanchili.office.client.admin.client.TreeClientPanel;

/**
 *
 * @author anuyalamanchili
 */
public class CreateClientContactPanel extends CreateContactPanel {

    public CreateClientContactPanel(CreateCompositeType type) {
        super(type);
    }
    
    String clientId;

    public CreateClientContactPanel(String clientId, CreateCompositeType type) {
        super(type);
        this.clientId = clientId;
    }

    @Override
    protected void postCreateSuccess(String result) {
        if (SelectClientContactWidget.instance() != null) {
            SelectClientContactWidget.instance().fireEvent();
        }
        GenericPopup.hideIfOpen();
        new ResponseStatusWidget().show("Successfully Added Client Contact");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientContactPanel(TreeClientPanel.instance().getEntityId()));
    }

    @Override
    protected String getURI() {
        if (clientId != null) {
            return OfficeWelcome.constants.root_url() + "client/clientcontact/" + clientId;
        } else {
        return OfficeWelcome.constants.root_url() + "client/clientcontact/" + TreeClientPanel.instance().getEntityId();
        }
    }    
}
