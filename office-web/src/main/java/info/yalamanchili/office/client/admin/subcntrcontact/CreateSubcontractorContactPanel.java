/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcntrcontact;

import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.subcontractor.TreeSubcontractorPanel;
import info.yalamanchili.office.client.profile.contact.CreateContactPanel;

/**
 *
 * @author anuyalamanchili
 */
public class CreateSubcontractorContactPanel extends CreateContactPanel {

    public CreateSubcontractorContactPanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Subcontractor Contact");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSubcontractorContactsPanel(TreeSubcontractorPanel.instance().getEntityId()));
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "subcontractor/contact/add/" + TreeSubcontractorPanel.instance().getEntityId();
    }
}
