/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.clientcontact;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.contact.CreateContactPanel;
import info.yalamanchili.office.client.tae.client.TreeClientPanel;

/**
 *
 * @author anuyalamanchili
 */
public class CreateClientContactPanel extends CreateContactPanel {

    public CreateClientContactPanel(CreateCompositeType type) {
        super(type);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client/clientcontact/" + TreeClientPanel.instance().getEntityId();
    }
}
