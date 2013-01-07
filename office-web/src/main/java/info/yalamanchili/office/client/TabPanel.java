package info.yalamanchili.office.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.ProfileMenu;
import info.yalamanchili.office.client.profile.ProfileSidePanel;
import info.yalamanchili.office.client.profile.employee.EmployeeSidePanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployeesPanel;

import java.util.logging.Logger;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.admin.AdminMenu;
import info.yalamanchili.office.client.drive.DriveEntityPanel;
import info.yalamanchili.office.client.drive.DriveTreePanel;
import info.yalamanchili.office.client.help.HelpHome;
import info.yalamanchili.office.client.home.HomeStackPanel;
import info.yalamanchili.office.client.home.message.ReadAllMessagePanel;
import info.yalamanchili.office.client.admin.notificationgroup.NotificationGroupSidePanel;
import info.yalamanchili.office.client.admin.notificationgroup.ReadAllNotificationGroupsPanel;
import info.yalamanchili.office.client.social.SocialMenu;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;
import info.yalamanchili.office.client.tae.TAEMenu;
import info.yalamanchili.office.client.admin.client.ClientSidePanel;
import info.yalamanchili.office.client.admin.client.ReadAllClientsPanel;
import info.yalamanchili.office.client.tae.timesheet.EmpTimeSummaryPanel;

public class TabPanel extends Composite implements SelectionHandler<Integer> {

    private static Logger logger = Logger.getLogger(TabPanel.class.getName());
    protected TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Unit.EM);
    public EntityLayout homePanel = new EntityLayout();
    public EntityLayout socialPanel = new EntityLayout();
    public EntityLayout myOfficePanel = new EntityLayout();
    public EntityLayout timeandExpensePanel = new EntityLayout();
    public EntityLayout drivePanel = new EntityLayout();
    public EntityLayout profilePanel = new EntityLayout();
    public EntityLayout adminPanel = new EntityLayout();
    public EntityLayout helpPanel = new EntityLayout();

    public TabPanel() {
        instance = this;
        initWidget(tabPanel);
        tabPanel.addStyleName("tabPanel");
        tabPanel.add(homePanel, "Home", false);
        tabPanel.add(socialPanel, "Social", false);
        tabPanel.add(myOfficePanel, "My Office", false);
        tabPanel.add(timeandExpensePanel, "Time", false);
        tabPanel.add(drivePanel, "Drive", false);
        tabPanel.add(profilePanel, "Profile", false);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_EXPENSE, ROLE.ROLE_ADMIN, ROLE.ROLE_TIME, ROLE.ROLE_EXPENSE)) {
            tabPanel.add(adminPanel, "Admin", false);
        }
        tabPanel.add(helpPanel, "Help", false);
        tabPanel.addSelectionHandler(this);
        tabPanel.selectTab(2);
    }

    @Override
    public void onSelection(SelectionEvent<Integer> selectedTabIndex) {
        logger.info(tabPanel.getWidget(selectedTabIndex.getSelectedItem()).toString());
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(homePanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Code download failed");
                }

                @Override
                public void onSuccess() {
                    selectHomeTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(socialPanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Code download failed");
                }

                @Override
                public void onSuccess() {
                    selectSocialTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(myOfficePanel)) {
            myOfficeTab();
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(timeandExpensePanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Code download failed");
                }

                @Override
                public void onSuccess() {
                    selectTimeandExpenseTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(drivePanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Code download failed");
                }

                @Override
                public void onSuccess() {
                    selectDriveTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(profilePanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Code download failed");
                }

                @Override
                public void onSuccess() {
                    selectProfileTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(adminPanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Code download failed");
                }

                @Override
                public void onSuccess() {
                    selectAdminTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(helpPanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Code download failed");
                }

                @Override
                public void onSuccess() {
                    selectHelpTab();
                }
            });
        }
    }
//TODO update selects to call the menu commands.

    public void selectHomeTab() {
        homePanel.entityPanel.clear();
        homePanel.sidePanelTop.clear();
        homePanel.sidePanelBottom.clear();
        homePanel.sidePanelBottom.add(new HomeStackPanel());
        homePanel.entityPanel.add(new ReadAllMessagePanel());
    }

    public void selectSocialTab() {
        socialPanel.entityPanel.clear();
        socialPanel.sidePanelTop.clear();
        socialPanel.entityTitlePanel.add(new SocialMenu());
//        socialPanel.sidePanelTop.add(new SocialSidePanel());
        socialPanel.entityPanel.add(new EmployeeFeedHome());
    }

    public void myOfficeTab() {
        myOfficePanel.entityPanel.clear();
        myOfficePanel.sidePanelTop.clear();
        myOfficePanel.entityTitlePanel.add(new ProfileMenu());
        myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());
        myOfficePanel.sidePanelTop.add(new EmployeeSidePanel());


    }

    public void selectTimeandExpenseTab() {
        timeandExpensePanel.entityPanel.clear();
        timeandExpensePanel.sidePanelTop.clear();
        timeandExpensePanel.entityTitlePanel.add(new TAEMenu());
        if (Auth.hasOnlyUserRole()) {
            timeandExpensePanel.entityPanel.add(new EmpTimeSummaryPanel());
        } else {
            timeandExpensePanel.entityPanel.add(new ReadAllClientsPanel());
            timeandExpensePanel.sidePanelTop.add(new ClientSidePanel());
        }


    }

    public void selectDriveTab() {
        drivePanel.entityPanel.clear();
        drivePanel.sidePanelTop.clear();
        drivePanel.entityPanel.add(new DriveEntityPanel());
        drivePanel.sidePanelTop.add(new DriveTreePanel());


    }

    public void selectProfileTab() {
        profilePanel.entityPanel.clear();
        profilePanel.sidePanelTop.clear();
        profilePanel.entityPanel.add(new ProfileHome());
        profilePanel.sidePanelTop.add(new ProfileSidePanel());
    }

    public void selectAdminTab() {
        adminPanel.entityPanel.clear();
        adminPanel.sidePanelTop.clear();
        adminPanel.entityTitlePanel.add(new AdminMenu());
        adminPanel.entityPanel.add(new ReadAllClientsPanel());
        adminPanel.sidePanelTop.add(new ClientSidePanel());
    }

    public void selectHelpTab() {
        helpPanel.entityPanel.clear();
        helpPanel.sidePanelTop.clear();
        helpPanel.entityPanel.add(new HelpHome());
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
        return timeandExpensePanel;
    }

    public EntityLayout getProfilePanel() {
        return profilePanel;
    }

    public EntityLayout getAdminPanel() {
        return adminPanel;
    }
}
