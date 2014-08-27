/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social.employee;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.office.client.social.ReadAllPostsPanel;

/**
 *
 * @author ayalamanchili
 */
public class EmployeeFeedHome extends Composite {

    private static EmployeeFeedHome instance;

    public static EmployeeFeedHome instance() {
        return instance;
    }
    protected FlowPanel panel = new FlowPanel();
    protected CreateEmployeePostWidget createEmployeePostWidget = new CreateEmployeePostWidget();
    protected ReadAllPostsPanel employeeFeed = new ReadAllPostsPanel();

    public EmployeeFeedHome() {
        instance = this;
        initWidget(panel);
        panel.add(createEmployeePostWidget);
        panel.add(employeeFeed);
    }

    public void refresh() {
        employeeFeed.refresh();
    }
}
