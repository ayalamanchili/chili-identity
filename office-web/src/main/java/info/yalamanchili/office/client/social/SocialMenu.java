/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.social.company.CompanyFeedHome;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;

/**
 *
 * @author raghu
 */
public class SocialMenu extends Composite {

    MenuBar tAEMenuBar = new MenuBar(false);
    FlowPanel panel = new FlowPanel();
    private static boolean IsEmployeeFeedSelected = true;

    public SocialMenu() {
        initWidget(tAEMenuBar);
        configureSocialMenu();
    }

    protected void configureSocialMenu() {
        tAEMenuBar.addItem("Employee Feed", employeefeedCmd);
        tAEMenuBar.addItem("System Soft Feed", systemsoftfeedCmd);
        tAEMenuBar.addStyleName("entityMenuBar");
    }

    public static boolean isEmployeedFeedSelected() {
        return IsEmployeeFeedSelected;
    }

    public static boolean isCompanyFeedSelected() {
        return !IsEmployeeFeedSelected;
    }
    Command employeefeedCmd = new Command() {
        public void execute() {
            IsEmployeeFeedSelected = true;
            TabPanel.instance().getSocialPanel().entityPanel.clear();
            TabPanel.instance().getSocialPanel().sidePanelTop.clear();
            TabPanel.instance().getSocialPanel().entityPanel.add(new EmployeeFeedHome());
        }
    };
    Command systemsoftfeedCmd = new Command() {
        public void execute() {
            IsEmployeeFeedSelected = false;
            TabPanel.instance().getSocialPanel().entityPanel.clear();
            TabPanel.instance().getSocialPanel().sidePanelTop.clear();
            TabPanel.instance().getSocialPanel().entityPanel.add(new CompanyFeedHome());
        }
    };
}
