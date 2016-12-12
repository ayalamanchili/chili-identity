/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.recruiting.reports;

import com.google.common.base.Strings;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.skillset.ReadAllSkillSetsPanel;

/**
 *
 * @author ayalamanchili
 */
public class ResumeSearchWidget extends ALComposite implements ClickHandler {

    protected CaptionPanel panel = new CaptionPanel("Resume Search");
    protected FlowPanel mainPanel = new FlowPanel();
    StringField searchTextSB = new StringField(OfficeWelcome.constants, "Search", "SkillSet", false, true);
    Button searchB = new Button("search");
    ClickableLink createSkillSetReportLink = new ClickableLink("Employee SkillSet Report");

    public ResumeSearchWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        searchB.addClickHandler(this);
        createSkillSetReportLink.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        panel.setContentWidget(mainPanel);
        mainPanel.add(searchTextSB);
        mainPanel.add(searchB);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CEO, Auth.ROLE.ROLE_ADMIN)) {
            mainPanel.add(createSkillSetReportLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(searchB)) {
            searchClicked();
        }
        if (event.getSource().equals(createSkillSetReportLink)) {
            generateEmployeeSkillSetReport();
        }
    }

    protected void generateEmployeeSkillSetReport() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeSkillSetReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getEmployeeSkillSetReportUrl() {
        return OfficeWelcome.constants.root_url() + "recruiting-reports/employee-skill-report";
    }

    protected void searchClicked() {
        if (Strings.isNullOrEmpty(searchTextSB.getValue())) {
            return;
        }
        HttpService.HttpServiceAsync.instance().doGet(getResumeSearchUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        searchTextSB.setValue("");
                        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                            new ResponseStatusWidget().show("no results");
                        } else {
                            //TODO use size and entities attributes
                            JSONObject resObj = JSONParser.parseLenient(result).isObject();
                            String key = (String) resObj.keySet().toArray()[0];
                            JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                            TabPanel.instance().recruitingPanel.entityPanel.clear();
                            TabPanel.instance().recruitingPanel.entityPanel.add(new ReadAllSkillSetsPanel(results));
                        }
                    }
                });
    }

    protected String getResumeSearchUrl() {
        return OfficeWelcome.constants.root_url() + "skillset/search-resumes/0/100?searchText=" + searchTextSB.getValue();
    }
}
