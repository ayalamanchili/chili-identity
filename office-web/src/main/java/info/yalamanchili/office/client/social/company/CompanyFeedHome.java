/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social.company;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.social.ReadAllPostsPanel;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;

/**
 *
 * @author ayalamanchili
 */
public class CompanyFeedHome extends Composite {

    private static CompanyFeedHome instance;

    public static CompanyFeedHome instance() {
        return instance;
    }
    protected FlowPanel panel = new FlowPanel();
    protected CreateCompanyPostWidget createCompanyPostWidget = new CreateCompanyPostWidget();
    protected ReadAllPostsPanel companyFeed = new ReadAllPostsPanel();

    public CompanyFeedHome() {
        instance = this;
        initWidget(panel);
        if (Auth.isAdmin()) {
            panel.add(createCompanyPostWidget);
        }
        panel.add(companyFeed);
    }

    public void refresh() {
        companyFeed.refresh();
    }
}
