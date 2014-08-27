/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.social.company.CompanyFeedHome;
import info.yalamanchili.office.client.social.employee.EmployeeFeedHome;

/**
 *
 * @author anu
 */
public class SocialSidePanel extends ALComposite implements ClickHandler {

    FlowPanel panel = new FlowPanel();
//    private static boolean IsEmployeeFeedSelected = false;
    ClickableLink employeeFeedL = new ClickableLink("Employee Feed");
    ClickableLink companyFeedL = new ClickableLink("System Soft Feed");

    public SocialSidePanel() {
        init(panel);

    }

    @Override
    protected void configure() {
        panel.addStyleName("socialSidePanel");
    }

    @Override
    protected void addWidgets() {
        panel.add(employeeFeedL);
        panel.add(companyFeedL);
    }

    @Override
    protected void addListeners() {
        employeeFeedL.addClickHandler(this);
        companyFeedL.addClickHandler(this);
    }

    @Override
    public void onClick(ClickEvent event) {
//        if (event.getSource().equals(employeeFeedL)) {
//            IsEmployeeFeedSelected = true;
//            showEmployeeFeed();
//        } else if (event.getSource().equals(companyFeedL)) {
//            IsEmployeeFeedSelected = false;
//            showCompanyFeed();
//        }
    }

//    public static boolean isEmployeedFeedSelected() {
//        return IsEmployeeFeedSelected;
//    }
//
//    public static boolean isCompanyFeedSelected() {
//        return !IsEmployeeFeedSelected;
//    } 
    protected void showEmployeeFeed() {
        TabPanel.instance().socialPanel.entityPanel.clear();
        TabPanel.instance().socialPanel.entityPanel.add(new EmployeeFeedHome());
    }

    protected void showCompanyFeed() {
        TabPanel.instance().socialPanel.entityPanel.clear();
        TabPanel.instance().socialPanel.entityPanel.add(new CompanyFeedHome());
    }
}
