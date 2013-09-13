/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client;

import com.google.gwt.core.client.GWT;
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
import info.chili.gwt.callback.RunAsyncCallback;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.admin.AdminMenu;
import info.yalamanchili.office.client.drive.DriveEntityPanel;
import info.yalamanchili.office.client.drive.DriveTreePanel;
import info.yalamanchili.office.client.help.HelpHome;
import info.yalamanchili.office.client.home.HomeStackPanel;
import info.yalamanchili.office.client.social.SocialMenu;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;
import info.yalamanchili.office.client.tae.TAEMenu;
import info.yalamanchili.office.client.admin.client.ClientSidePanel;
import info.yalamanchili.office.client.admin.client.ReadAllClientsPanel;
import info.yalamanchili.office.client.drive.SearchDrivePanel;
import info.yalamanchili.office.client.expense.ExpenseMenu;
import info.yalamanchili.office.client.expense.ExpensesSidePanel;
import info.yalamanchili.office.client.expense.ReadAllExpensesPanel;
import info.yalamanchili.office.client.home.message.MyMessagesPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.reporting.ReportingMenu;
import info.yalamanchili.office.client.tae.timesheet.CurrentEmployeeTimeSummaryPanel;
import info.yalamanchili.office.client.tae.timesheet.ReadAllTimesheetPanel;
import info.yalamanchili.office.client.tae.timesheet.TimeSheetSidePanel;

public class TabPanel extends Composite implements SelectionHandler<Integer> {

    private static Logger logger = Logger.getLogger(TabPanel.class.getName());
    protected TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Unit.EM);
    public EntityLayout homePanel = new EntityLayout();
    public EntityLayout socialPanel = new EntityLayout();
    public EntityLayout myOfficePanel = new EntityLayout();
    public EntityLayout timePanel = new EntityLayout();
    public EntityLayout expensePanel = new EntityLayout();
    public EntityLayout drivePanel = new EntityLayout();
    public EntityLayout profilePanel = new EntityLayout();
    public EntityLayout adminPanel = new EntityLayout();
    public EntityLayout reportingPanel = new EntityLayout();
    public EntityLayout helpPanel = new EntityLayout();

    public TabPanel() {
        instance = this;
        initWidget(tabPanel);
        tabPanel.addStyleName("tabPanel");
        tabPanel.add(homePanel, "Home", false);
        tabPanel.add(socialPanel, "Social", false);
        tabPanel.add(myOfficePanel, "My Office", false);
        tabPanel.add(timePanel, "Time", false);
        //TODO under construction
//        if (Auth.hasAnyOfRoles(ROLE.ROLE_EXPENSE, ROLE.ROLE_ADMIN, ROLE.ROLE_TIME, ROLE.ROLE_HR)) {
//            tabPanel.add(expensePanel, "Expense", false);
//        }
        tabPanel.add(drivePanel, "Drive", false);
        tabPanel.add(profilePanel, "Profile", false);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_EXPENSE, ROLE.ROLE_ADMIN, ROLE.ROLE_TIME, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_EXPENSE)) {
            tabPanel.add(adminPanel, "Admin", false);
        }
        if (Auth.isCorporateEmployee()) {
            tabPanel.add(reportingPanel, "Reporting", false);
        }
        tabPanel.add(helpPanel, "Help", false);
        tabPanel.addSelectionHandler(this);
        tabPanel.selectTab(2);
    }

    @Override
    public void onSelection(SelectionEvent<Integer> selectedTabIndex) {
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(homePanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onResponse() {
                    selectHomeTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(socialPanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onResponse() {
                    selectSocialTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(myOfficePanel)) {
            selectMyOfficeTab();
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(timePanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onResponse() {
                    selectTimeTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(expensePanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onResponse() {
                    selectExpenseTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(drivePanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onResponse() {
                    selectDriveTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(profilePanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onResponse() {
                    selectProfileTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(adminPanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onResponse() {
                    selectAdminTab();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(reportingPanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onResponse() {
                    selectReportingPanel();
                }
            });
        }
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(helpPanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onResponse() {
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
        if (Auth.hasOnlyUserRole()) {
            homePanel.entityPanel.add(new MyMessagesPanel());
        } else {
            homePanel.entityPanel.add(new ReadAllTasks());
        }
    }

    public void selectSocialTab() {
        socialPanel.entityPanel.clear();
        socialPanel.sidePanelTop.clear();
        socialPanel.entityTitlePanel.add(new SocialMenu());
        socialPanel.entityPanel.add(new EmployeeFeedHome());
    }

    public void selectMyOfficeTab() {
        myOfficePanel.entityPanel.clear();
        myOfficePanel.sidePanelTop.clear();
        myOfficePanel.entityTitlePanel.add(new ProfileMenu());
        myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());
        myOfficePanel.sidePanelTop.add(new EmployeeSidePanel());


    }

    public void selectTimeTab() {
        timePanel.entityPanel.clear();
        timePanel.sidePanelTop.clear();
        timePanel.entityTitlePanel.add(new TAEMenu());
        if (Auth.hasOnlyUserRole()) {
            timePanel.entityPanel.add(new CurrentEmployeeTimeSummaryPanel());
        } else if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_TIME)) {
            timePanel.entityPanel.add(new ReadAllTimesheetPanel());
            timePanel.sidePanelTop.add(new TimeSheetSidePanel());
        }
    }

    public void selectExpenseTab() {
        expensePanel.entityPanel.clear();
        expensePanel.sidePanelTop.clear();
        expensePanel.entityTitlePanel.add(new ExpenseMenu());
        expensePanel.entityPanel.add(new ReadAllExpensesPanel());
        expensePanel.sidePanelTop.add(new ExpensesSidePanel());
    }

    public void selectDriveTab() {
        drivePanel.entityPanel.clear();
        drivePanel.sidePanelTop.clear();
        drivePanel.sidePanelBottom.clear();
        drivePanel.entityPanel.add(new DriveEntityPanel());
        drivePanel.sidePanelTop.add(new DriveTreePanel());
        drivePanel.sidePanelBottom.add(new SearchDrivePanel());
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

    public void selectReportingPanel() {
        reportingPanel.entityPanel.clear();
        reportingPanel.sidePanelTop.clear();
        reportingPanel.entityTitlePanel.add(new ReportingMenu());
//        adminPanel.entityPanel.add(new ReadAllClientsPanel());
//        adminPanel.sidePanelTop.add(new ClientSidePanel());
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

    public EntityLayout getTimePanel() {
        return timePanel;
    }

    public EntityLayout getExpensePanel() {
        return expensePanel;
    }

    public EntityLayout getProfilePanel() {
        return profilePanel;
    }

    public EntityLayout getReportingPanel() {
        return reportingPanel;
    }

    public EntityLayout getAdminPanel() {
        return adminPanel;
    }
}
