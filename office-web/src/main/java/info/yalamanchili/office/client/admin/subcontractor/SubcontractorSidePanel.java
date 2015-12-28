/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcontractor;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class SubcontractorSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(SubcontractorSidePanel.class.getName());
    public FlowPanel subcontractorSidePanel = new FlowPanel();
    ClickableLink createSubcontractorLink = new ClickableLink("Create Subcontractor");

    public SubcontractorSidePanel() {
        init(subcontractorSidePanel);
    }

    @Override
    protected void addListeners() {
        createSubcontractorLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS)) {
            subcontractorSidePanel.add(createSubcontractorLink);
        }
        subcontractorSidePanel.add(new SearchSubcontractorPanel());
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createSubcontractorLink)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new CreateSubcontractorPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
