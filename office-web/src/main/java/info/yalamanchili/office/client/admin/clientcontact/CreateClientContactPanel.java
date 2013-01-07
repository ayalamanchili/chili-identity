/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.clientcontact;

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

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("successfully added Client Contact");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientContactPanel(TreeClientPanel.instance().getEntityId()));
        TabPanel.instance().adminPanel.entityPanel.add(new ClientContactOptionsPanel());
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client/clientcontact/" + TreeClientPanel.instance().getEntityId();
    }
}
