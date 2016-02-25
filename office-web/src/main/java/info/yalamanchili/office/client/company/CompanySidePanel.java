/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.company;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author chaitanya.k
 */
public class CompanySidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CompanySidePanel.class.getName());
    public FlowPanel companysidePanel = new FlowPanel();
//    ClickableLink createCompanyLink = new ClickableLink("Create Company");

    public CompanySidePanel() {
        init(companysidePanel);
    }

    @Override
    protected void addListeners() {
//        createCompanyLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN)) {
//            companysidePanel.add(createCompanyLink);
        }
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
//        if (clickEvent.getSource().equals(createCompanyLink)) 
        {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new CreateCompanyPanel(CreateCompositeType.CREATE));
        }
    }
}
