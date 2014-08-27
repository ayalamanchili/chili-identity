/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employeetype;

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
 * @author bala
 */
public class EmployeeTypeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(EmployeeTypeSidePanel.class.getName());
    public FlowPanel employeeTypeSidePanel = new FlowPanel();
    ClickableLink createEmployeeTypeLink = new ClickableLink("Create EmployeeType");

    public EmployeeTypeSidePanel() {
        init(employeeTypeSidePanel);
    }

    @Override
    protected void addListeners() {
        createEmployeeTypeLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            employeeTypeSidePanel.add(createEmployeeTypeLink);
        }
        //skillSidePanel.add(new SearchskillPanel());
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(createEmployeeTypeLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEmployeeTypePanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}
