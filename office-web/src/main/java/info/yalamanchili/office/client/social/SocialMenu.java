/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social;

import com.google.gwt.user.client.Command;
import info.chili.gwt.widgets.CMenuBar;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.social.company.CompanyFeedHome;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;

/**
 *
 * @author raghu
 */
public class SocialMenu extends CMenuBar {

    private static boolean IsEmployeeFeedSelected = true;

    protected void configureMenu() {
        addMenuItem("Employee Feed", "Employee Feed", employeefeedCmd);
        addMenuItem("System Soft Feed", "System Soft Feed", systemsoftfeedCmd);
    }

    public static boolean isEmployeedFeedSelected() {
        return IsEmployeeFeedSelected;
    }

    public static boolean isCompanyFeedSelected() {
        return !IsEmployeeFeedSelected;
    }
    static Command employeefeedCmd = new Command() {
        public void execute() {
            IsEmployeeFeedSelected = true;
            TabPanel.instance().getSocialPanel().entityPanel.clear();
            TabPanel.instance().getSocialPanel().sidePanel.clear();
            TabPanel.instance().getSocialPanel().entityPanel.add(new EmployeeFeedHome());
        }
    };
    static Command systemsoftfeedCmd = new Command() {
        public void execute() {
            IsEmployeeFeedSelected = false;
            TabPanel.instance().getSocialPanel().entityPanel.clear();
            TabPanel.instance().getSocialPanel().sidePanel.clear();
            TabPanel.instance().getSocialPanel().entityPanel.add(new CompanyFeedHome());
        }
    };
}
