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
import info.yalamanchili.office.client.social.EmployeePostsPanel;

public class TabPanel extends Composite implements SelectionHandler<Integer> {

    private static Logger logger = Logger.getLogger(TabPanel.class.getName());
    public final static Integer HOME_TAB = 0;
    public final static Integer SOCIAL_TAB = 1;
    public final static Integer MY_OFFICE_TAB = 2;
    protected TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Unit.EM);
    public EntityLayout homePanel = new EntityLayout();
    public EntityLayout socialPanel = new EntityLayout();
    public EntityLayout myOfficePanel = new EntityLayout();

    public TabPanel() {
        instance = this;
        initWidget(tabPanel);
        tabPanel.addStyleName("tabPanel");
        tabPanel.setHeight("5");
        tabPanel.add(homePanel, "Home", false);
        tabPanel.add(socialPanel, "Social", false);
        tabPanel.add(myOfficePanel, "My Office", false);
        tabPanel.selectTab(0);
        tabPanel.addSelectionHandler(this);
    }

    @Override
    public void onSelection(SelectionEvent<Integer> selectedTabIndex) {
        logger.info(selectedTabIndex.getSelectedItem().toString());
        if (selectedTabIndex.getSelectedItem().equals(HOME_TAB)) {
            selectHomeTab();
        }
        if (selectedTabIndex.getSelectedItem().equals(SOCIAL_TAB)) {
            selectProfileTab();
        }
        if (selectedTabIndex.getSelectedItem().equals(MY_OFFICE_TAB)) {
            selectAdminTab();
        }
    }

    public void selectHomeTab() {
        homePanel.clear();
    }

    public void selectProfileTab() {
        socialPanel.clear();
        socialPanel.entityPanel.add(new EmployeePostsPanel());
    }

    public void selectAdminTab() {
        myOfficePanel.clear();
        myOfficePanel.entityTitlePanel.add(new ProfileMenu());
        if (Auth.isAdmin() || Auth.isHR()) {
            myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());
            myOfficePanel.sidePanelTop.add(new EmployeeSidePanel());
        } else {
            myOfficePanel.entityPanel.add(new ProfileHome());
            myOfficePanel.sidePanelTop.add(new ProfileSidePanel());
        }

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
}
