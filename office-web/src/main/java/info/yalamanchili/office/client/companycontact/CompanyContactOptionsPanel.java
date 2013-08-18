/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.companycontact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;

/**
 *
 * @author anuyalamanchili
 */
public class CompanyContactOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink addCompanyCntLink = new ClickableLink("Add Company Contact");

    public CompanyContactOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addCompanyCntLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO move this to common css
        panel.setSpacing(5);

    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP)) {
            panel.add(addCompanyCntLink);
        }
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(addCompanyCntLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateCompanyContactPanel(CreateComposite.CreateCompositeType.ADD));
        }
    }
}
