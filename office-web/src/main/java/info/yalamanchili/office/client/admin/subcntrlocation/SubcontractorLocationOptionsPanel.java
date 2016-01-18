/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcntrlocation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;

/**
 *
 * @author anuyalamanchili
 */
public class SubcontractorLocationOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink addSubcontractorLocLink = new ClickableLink("Add Subcontractor Location");

    public SubcontractorLocationOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addSubcontractorLocLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
            panel.add(addSubcontractorLocLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addSubcontractorLocLink)) {
            info.yalamanchili.office.client.TabPanel.instance().adminPanel.entityPanel.clear();
            info.yalamanchili.office.client.TabPanel.instance().adminPanel.entityPanel.add(new CreateSubcontractorLocationPanel(CreateComposite.CreateCompositeType.ADD));
        }
    }
}
