/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ClientSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ClientSidePanel.class.getName());
    public FlowPanel clientsidepanel = new FlowPanel();
    ClickableLink createclientlink = new ClickableLink("Create Client");

    public ClientSidePanel() {
        init(clientsidepanel);
    }

    @Override
    protected void addListeners() {
        createclientlink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING)) {
            clientsidepanel.add(createclientlink);
        }
        clientsidepanel.add(new SearchClientpanel());
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createclientlink)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new CreateClientPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
