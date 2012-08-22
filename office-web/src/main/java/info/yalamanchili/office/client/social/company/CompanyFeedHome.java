/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social.company;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.social.ReadAllPostsPanel;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;

/**
 *
 * @author ayalamanchili
 */
public class CompanyFeedHome extends Composite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    protected ReadAllPostsPanel companyFeed = new ReadAllPostsPanel();
    protected ClickableLink createCompanyPostL = new ClickableLink("Create System  Soft Post");

    public CompanyFeedHome() {
        instance = this;
        initWidget(panel);
        createCompanyPostL.addClickHandler(this);
        if (Auth.isAdmin()) {
            panel.add(createCompanyPostL);
        }
        panel.add(companyFeed);
    }

    public void refresh() {
        companyFeed.refresh();
    }
    private static CompanyFeedHome instance;

    public static CompanyFeedHome instance() {
        return instance;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (createCompanyPostL.equals(event.getSource())) {
            TabPanel.instance().socialPanel.entityPanel.clear();
            TabPanel.instance().socialPanel.entityPanel.add(new CreateCompanyPostWidget());
        }
    }
}
