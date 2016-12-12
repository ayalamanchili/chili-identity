/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.employee;

import info.chili.gwt.composite.ALComposite;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;

public class EmployeeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(EmployeeSidePanel.class.getName());
    public FlowPanel employeeSidePanel = new FlowPanel();

    public EmployeeSidePanel() {
        init(employeeSidePanel);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        employeeSidePanel.add(new SearchEmployeePanel());
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
    }
}
