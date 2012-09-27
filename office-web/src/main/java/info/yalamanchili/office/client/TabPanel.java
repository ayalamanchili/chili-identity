package info.yalamanchili.office.client;

import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.ProfileMenu;
import info.yalamanchili.office.client.profile.ProfileSidePanel;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployeesPanel;

import java.util.logging.Logger;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.social.SocialSidePanel;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;
import info.yalamanchili.office.client.tae.TAEMenu;
import info.yalamanchili.office.client.tae.client.ClientSidePanel;
import info.yalamanchili.office.client.tae.client.ReadAllClientsPanel;
import info.yalamanchili.office.client.tae.project.ReadAllProjectsPanel;

public class TabPanel extends Composite implements SelectionHandler<Integer> {

    private static Logger logger = Logger.getLogger(TabPanel.class.getName());
    protected TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Unit.EM);
    public EntityLayout homePanel = new EntityLayout();
    public EntityLayout socialPanel = new EntityLayout();
    public EntityLayout myOfficePanel = new EntityLayout();
    public EntityLayout TimeandExpensePanel = new EntityLayout();
    public EntityLayout profilePanel = new EntityLayout();

    public TabPanel() {
        instance = this;
        initWidget(tabPanel);
        tabPanel.addStyleName("tabPanel");
        tabPanel.setHeight("5");
        tabPanel.add(homePanel, "Home", false);
        tabPanel.add(socialPanel, "Social", false);
        tabPanel.add(myOfficePanel, "My Office", false);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_EXPENSE, ROLE.ROLE_ADMIN, ROLE.ROLE_TIME)) {
            tabPanel.add(TimeandExpensePanel, "TimeSheet", false);
        }
        tabPanel.add(profilePanel, "Profile", false);
        tabPanel.addSelectionHandler(this);
        tabPanel.selectTab(2);
    }

    @Override
    public void onSelection(SelectionEvent<Integer> selectedTabIndex) {
        logger.info(tabPanel.getWidget(selectedTabIndex.getSelectedItem()).toString());
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(homePanel)) {
            selectHomeTab();
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(socialPanel)) {
            selectSocialTab();
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(myOfficePanel)) {
            selectAdminTab();
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(TimeandExpensePanel)) {
            selectTimeandExpenseTab();
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(profilePanel)) {
            selectProfileTab();
        }
    }

    public void selectHomeTab() {
        homePanel.clear();
    }

    public void selectSocialTab() {
        socialPanel.entityPanel.clear();
        socialPanel.sidePanelTop.clear();
        socialPanel.sidePanelTop.add(new SocialSidePanel());
        socialPanel.entityPanel.add(new EmployeeFeedHome());
    }

    public void selectAdminTab() {
        myOfficePanel.entityPanel.clear();
        myOfficePanel.sidePanelTop.clear();
        myOfficePanel.entityTitlePanel.add(new ProfileMenu());
        myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());
        myOfficePanel.sidePanelTop.add(new EmployeeSidePanel());


    }

    public void selectTimeandExpenseTab() {
        TimeandExpensePanel.entityPanel.clear();
        TimeandExpensePanel.sidePanelTop.clear();
        TimeandExpensePanel.entityTitlePanel.add(new TAEMenu());
        TimeandExpensePanel.entityPanel.add(new ReadAllClientsPanel());
        TimeandExpensePanel.sidePanelTop.add(new ClientSidePanel());


    }

    public void selectProfileTab() {
        profilePanel.entityPanel.clear();
        profilePanel.sidePanelTop.clear();
        profilePanel.entityPanel.add(new ProfileHome());
        profilePanel.sidePanelTop.add(new ProfileSidePanel());
    }
    private static TabPanel instance;

    public static TabPanel instance() {
        return instance;
    }

    public EntityLayout getHomePanel() {
        return homePanel;
    }

    public EntityLayout getSocialPanel() {
        return socialPanel;
    }

    public EntityLayout getMyOfficePanel() {
        return myOfficePanel;
    }

    public EntityLayout getTimeandExpensePanel() {
        return TimeandExpensePanel;
    }

    public EntityLayout getProfilePanel() {
        return profilePanel;
    }
}
