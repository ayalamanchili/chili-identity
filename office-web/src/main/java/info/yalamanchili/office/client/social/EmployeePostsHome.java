/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 *
 * @author anu
 */
public class EmployeePostsHome extends Composite {

    FlowPanel panel = new FlowPanel();
    EmployeePostsPanel employeePostsPanel = new EmployeePostsPanel();
    CreatePostWidget createPostWidget = new CreatePostWidget();

    public EmployeePostsHome() {
        initWidget(panel);
        panel.add(createPostWidget);
        panel.add(employeePostsPanel);
    }
}
