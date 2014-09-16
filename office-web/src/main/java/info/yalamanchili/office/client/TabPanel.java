/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client;

import com.google.gwt.core.client.GWT;
import info.yalamanchili.office.client.profile.ProfileHome;
import info.yalamanchili.office.client.profile.MyOfficeMenu;
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
import info.yalamanchili.office.client.drive.DriveTreePanel;
import info.yalamanchili.office.client.help.HelpHome;
import info.yalamanchili.office.client.home.HomeStackPanel;
import info.yalamanchili.office.client.social.SocialMenu;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;
import info.yalamanchili.office.client.tae.timesheet.TimeMenu;
import info.yalamanchili.office.client.admin.client.ClientSidePanel;
import info.yalamanchili.office.client.admin.client.ReadAllClientsPanel;
import info.yalamanchili.office.client.advancerequisition.AdvanceRequisitionSidePanel;
import info.yalamanchili.office.client.advancerequisition.ReadAllAdvanceRequisitionPanel;
import info.yalamanchili.office.client.contracts.ContractsSidePanel;
import info.yalamanchili.office.client.contracts.ReadAllContractsPanel;
import info.yalamanchili.office.client.drive.SearchDrivePanel;
import info.yalamanchili.office.client.expense.ExpenseMenu;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.reports.ProfileReportsSidePanel;
import info.yalamanchili.office.client.profile.selfservice.ReadAllServiceTicketsPanel;
import info.yalamanchili.office.client.profile.skill.ReadAllSkillsPanel;
import info.yalamanchili.office.client.profile.skill.SkillSidePanel;
import info.yalamanchili.office.client.recruiting.RecruitingMenu;
import info.yalamanchili.office.client.reports.ReportsMenu;
import info.yalamanchili.office.client.time.consultant.ConsultantTimeSummaryPanel;
import info.yalamanchili.office.client.time.consultant.ConsultantTimeSummarySidePanel;
import info.yalamanchili.office.client.time.consultant.ReadAllConsultantTimeSheetsPanel;
import info.yalamanchili.office.client.time.consultant.ReadCurrentConsultantLeavesPanel;
import info.yalamanchili.office.client.time.corp.CorporateTimeSummarySidePanel;
import info.yalamanchili.office.client.time.corp.CorporateTimeSummaryPanel;
import info.yalamanchili.office.client.time.corp.ReadAllCorporateTimeSheetPanel;
import info.yalamanchili.office.client.time.corp.ReadCurrentCorpLeavesPanel;

public class TabPanel extends Composite implements SelectionHandler<Integer> {

    private static Logger logger = Logger.getLogger(TabPanel.class.getName());
    protected TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Unit.EM);
    public EntityLayout homePanel = new EntityLayout();
    public EntityLayout myOfficePanel = new EntityLayout();
    public EntityLayout timePanel = new EntityLayout();
    public EntityLayout expensePanel = new EntityLayout();
    public EntityLayout drivePanel = new EntityLayout();
    public EntityLayout socialPanel = new EntityLayout();
    public EntityLayout profilePanel = new EntityLayout();
    public EntityLayout adminPanel = new EntityLayout();
    public EntityLayout reportingPanel = new EntityLayout();
    public EntityLayout recruitingPanel = new EntityLayout();
    public EntityLayout helpPanel = new EntityLayout();

    public TabPanel() {
        instance = this;
        initWidget(tabPanel);
        tabPanel.addStyleName("tabPanel");
        tabPanel.add(homePanel, "Home", false);
        tabPanel.add(myOfficePanel, "My Office", false);
        tabPanel.add(timePanel, "Time", false);
        tabPanel.add(expensePanel, "Expense", false);
        tabPanel.add(drivePanel, "Drive", false);
        tabPanel.add(socialPanel, "Social", false);
        tabPanel.add(profilePanel, "Profile", false);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_TIME, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_EXPENSE)) {
            tabPanel.add(adminPanel, "Admin", false);
        }

        if (Auth.isCorporateEmployee()) {
            tabPanel.add(reportingPanel, "Reports", false);
        }

        if (Auth.hasAnyOfRoles(ROLE.ROLE_RECRUITER)) {
            tabPanel.add(recruitingPanel, "Recruiting", false);

        }
        tabPanel.add(helpPanel, "Help", false);
        tabPanel.addSelectionHandler(this);
        if (Auth.isCorporateEmployee()) {
            TabPanel.instance().tabPanel.selectTab(1);
        } else {
            tabPanel.selectTab(6);
        }
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
        if (tabPanel.getWidget(selectedTabIndex.getSelectedItem()).equals(recruitingPanel)) {
            GWT.runAsync(new RunAsyncCallback() {
                @Override
                public void onResponse() {
                    selectRecruitingPanel();
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
        homePanel.sidePanelTop.add(new HomeStackPanel());
        if (Auth.isCorporateEmployee()) {
            homePanel.entityPanel.add(new ReadAllTasks());
        } else {
            homePanel.entityPanel.add(new ReadAllServiceTicketsPanel());
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
        myOfficePanel.entityTitlePanel.add(new MyOfficeMenu());
        myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());
        myOfficePanel.sidePanelTop.add(new EmployeeSidePanel());
        myOfficePanel.sidePanelTop.setHeight("100%");

    }

    public void selectTimeTab() {
        timePanel.entityPanel.clear();
        timePanel.sidePanelTop.clear();
        if (Auth.isCorporateEmployee()) {
            timePanel.sidePanelTop.add(new CorporateTimeSummarySidePanel());
            timePanel.entityPanel.add(new CorporateTimeSummaryPanel());
            timePanel.entityPanel.add(new ReadAllCorporateTimeSheetPanel());
            timePanel.entityPanel.add(new ReadCurrentCorpLeavesPanel());
        } else if (Auth.isConsultantEmployee()) {
            timePanel.sidePanelTop.add(new ConsultantTimeSummarySidePanel());
            timePanel.entityPanel.add(new ConsultantTimeSummaryPanel());
            timePanel.entityPanel.add(new ReadAllConsultantTimeSheetsPanel());
            timePanel.entityPanel.add(new ReadCurrentConsultantLeavesPanel());
        }
        timePanel.entityTitlePanel.add(new TimeMenu());
    }

    public void selectExpenseTab() {
        expensePanel.entityPanel.clear();
        expensePanel.sidePanelTop.clear();
        expensePanel.entityTitlePanel.add(new ExpenseMenu());
        TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllAdvanceRequisitionPanel());
        TabPanel.instance().getExpensePanel().sidePanelTop.add(new AdvanceRequisitionSidePanel());
    }

    public void selectDriveTab() {
        drivePanel.entityPanel.clear();
        drivePanel.sidePanelTop.clear();
        drivePanel.sidePanelBottom.clear();
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
        reportingPanel.entityTitlePanel.add(new ReportsMenu());
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP)) {
            reportingPanel.sidePanelTop.add(new ProfileReportsSidePanel());
        }
    }

    public void selectRecruitingPanel() {
        recruitingPanel.entityPanel.clear();
        recruitingPanel.sidePanelTop.clear();
        recruitingPanel.sidePanelBottom.clear();
        recruitingPanel.entityTitlePanel.add(new RecruitingMenu());
        recruitingPanel.entityPanel.add(new ReadAllSkillsPanel());
        recruitingPanel.sidePanelTop.add(new SkillSidePanel());

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

    public EntityLayout getRecruitingPanel() {
        return recruitingPanel;
    }
}
