/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.project;

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
 * @author Yogi
 */
public class ProjectSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.admin.project.ProjectSidePanel.class.getName());
    public FlowPanel projectsidepanel = new FlowPanel();
//    ClickableLink createprojectlink = new ClickableLink("Create Project");

    public ProjectSidePanel() {
        init(projectsidepanel);
    }

    @Override
    protected void addListeners() {
//        createprojectlink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_EXPENSE, Auth.ROLE.ROLE_TIME)) {
//            projectsidepanel.add(createprojectlink);
        }
        projectsidepanel.add(new SearchProjectsPanel());
    }

    @Override
    public void onClick(ClickEvent event) {
//        if (event.getSource().equals(createprojectlink)) 
        {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new CreateProjectPanel(CreateComposite.CreateCompositeType.CREATE, true));
        }
    }
}
