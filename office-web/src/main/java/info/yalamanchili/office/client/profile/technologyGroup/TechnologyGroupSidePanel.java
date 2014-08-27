/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.technologyGroup;

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
 * @author Prashanthi
 */
public class TechnologyGroupSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(TechnologyGroupSidePanel.class.getName());
    public FlowPanel technologyGroupSidePanel = new FlowPanel();
    ClickableLink createTechnologyGroupLink = new ClickableLink("Create Technology Group");

    public TechnologyGroupSidePanel() {
        init(technologyGroupSidePanel);
    }

    @Override
    protected void addListeners() {
        createTechnologyGroupLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            technologyGroupSidePanel.add(createTechnologyGroupLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createTechnologyGroupLink)) {
            TabPanel.instance().recruitingPanel.entityPanel.clear();
            TabPanel.instance().recruitingPanel.entityPanel.add(new CreateTechnologyGroupPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
