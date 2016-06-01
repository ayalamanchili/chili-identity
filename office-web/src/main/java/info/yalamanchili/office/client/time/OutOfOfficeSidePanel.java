/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class OutOfOfficeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(OutOfOfficeSidePanel.class.getName());
    public FlowPanel outOfOfficeSidePanel = new FlowPanel();
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false);
    Button viewB = new Button("View");
    ClickableLink currentWeek = new ClickableLink("Current Week Requests");

    public OutOfOfficeSidePanel() {
        init(outOfOfficeSidePanel);
    }

    @Override
    protected void addListeners() {
        viewB.addClickHandler(this);
        currentWeek.addClickHandler(this);
    }

    @Override
    protected void configure() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_HR)) {
            return;
        }
        Timer timer = new Timer() {
            @Override
            public void run() {
                loadEmployeeSuggestions();
            }
        };
        timer.schedule(2000);
    }

    protected void loadEmployeeSuggestions() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                logger.info(entityString);
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ACCOUNTS_PAYABLE, Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS, Auth.ROLE.ROLE_CEO)) {
            outOfOfficeSidePanel.add(new SearchOutOfOfficePanel());
            outOfOfficeSidePanel.add(currentWeek);
        } else {
            outOfOfficeSidePanel.add(Utils.getLineSeperatorTag("Search"));
            outOfOfficeSidePanel.add(employeeSB);
            outOfOfficeSidePanel.add(viewB);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(viewB)) {
            TabPanel.instance().timePanel.entityPanel.clear();
            TabPanel.instance().timePanel.entityPanel.add(new ReadAllOutOfOfficePanel(getOfficeURL(0, "10")));
        }
        if (event.getSource().equals(currentWeek)) {
            TabPanel.instance().timePanel.entityPanel.clear();
            TabPanel.instance().timePanel.entityPanel.add(new ReadAllOutOfOfficePanel(getCurrentWeekURL(0, "10")));
        }
    }

    private String getOfficeURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "out-of-office/" + employeeSB.getKey() + "/" + start.toString() + "/"
                + limit.toString();
    }

    private String getCurrentWeekURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "out-of-office/current-week/" + start.toString() + "/"
                + limit.toString();
    }

    private String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_USER.name() + "/0/10000");
    }
}
