/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.activity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class IssueTypeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(IssueTypeSidePanel.class.getName());
    public FlowPanel issueTypeSidePanel = new FlowPanel();
    ClickableLink createIssueTypeLink = new ClickableLink("Create IssueType");

    public IssueTypeSidePanel() {
        init(issueTypeSidePanel);
    }

    @Override
    protected void addListeners() {
        createIssueTypeLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            issueTypeSidePanel.add(createIssueTypeLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createIssueTypeLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateIssueTypePanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
