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

    protected FlowPanel panel = new FlowPanel();
    protected CreateEmployeePostWidget createEmployeePostWidget = new CreateEmployeePostWidget();
    protected ReadAllPostsPanel companyFeed = new ReadAllPostsPanel();

    public EmployeeFeedHome() {
        initWidget(panel);
        panel.add(createEmployeePostWidget);
        panel.add(companyFeed);
    }
}
