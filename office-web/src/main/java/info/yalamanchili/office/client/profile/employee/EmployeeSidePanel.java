/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.employee;

import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.office.client.Auth.ROLE;

public class EmployeeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(EmployeeSidePanel.class.getName());
    public FlowPanel employeeSidePanel = new FlowPanel();
    ClickableLink createEmployeeLink = new ClickableLink("Create Employee");
    ClickableLink createProjectLink = new ClickableLink("Create Project");

    public EmployeeSidePanel() {
        init(employeeSidePanel);
    }

    @Override
    protected void addListeners() {
        createEmployeeLink.addClickHandler(this);
        createProjectLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_SYSTEM_AND_NETWORK_ADMIN, ROLE.ROLE_CONTRACTS_ADMIN)) {
            employeeSidePanel.add(createEmployeeLink);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_CONTRACTS_ADMIN)) {
            employeeSidePanel.add(createProjectLink);
        }
        employeeSidePanel.add(new SearchEmployeePanel());
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(createEmployeeLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEmployeePanel(CreateCompositeType.CREATE));
        }
        if (clickEvent.getSource().equals(createProjectLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateProjectPanel(CreateCompositeType.CREATE));
        }
    }
}
