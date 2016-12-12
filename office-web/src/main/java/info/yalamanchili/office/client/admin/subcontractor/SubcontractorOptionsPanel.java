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
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author anuyalamanchili
 */
public class SubcontractorOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink addSubcontractorLink = new ClickableLink("Add Subcontractor");

    public SubcontractorOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addSubcontractorLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            panel.add(addSubcontractorLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addSubcontractorLink)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new CreateSubcontractorPanel(CreateComposite.CreateCompositeType.ADD));
        }
    }
}
