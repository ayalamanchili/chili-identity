/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.preferences;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.Map;

/**
 *
 * @author ayalamanchili
 */
public class ManageEmailPreferences extends ALComposite implements ClickHandler {

    CaptionPanel mainPanel = new CaptionPanel();
    FlowPanel panel = new FlowPanel();
    SuggestBox emailRulesSB = new SuggestBox(OfficeWelcome.constants, "Rule Name", "EmailPreferenceRule", false, false);
    Button createB = new Button("Add");
    ReadAllUserEmailPreferences readAllUserEmailRules;
    HTML info = new HTML("<h4>You can add rules to disable certain email notifications:</h4>\n"
            + "<p><strong>Example</strong>:&nbsp;<span style=\"text-decoration: underline;\">If you dont want to receive status report submission emails from who report to you.</span></p>\n"
            + "<p>Search for \"<strong>Status</strong>\" as rule name and it it will show \"<strong>Disable Corporate Status Reports Emails</strong>\" which you can add to opt out.</p>\n"
            + "<p>&nbsp;</p>");

    public ManageEmailPreferences() {
        init(mainPanel);
    }

    @Override
    protected void addListeners() {
        createB.addClickHandler(this);
    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        mainPanel.setCaptionHTML("Manage Email Preferences");
        mainPanel.setContentWidget(panel);
//        panel.add(info);
        panel.add(emailRulesSB);
        panel.add(createB);
        readAllUserEmailRules = new ReadAllUserEmailPreferences();
        panel.add(readAllUserEmailRules);
        HttpService.HttpServiceAsync.instance().doGet(getEmailPreferencesRulesUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    emailRulesSB.loadData(values);
                }
            }
        });
    }

    private String getEmailPreferencesRulesUrl() {
        return OfficeWelcome.constants.root_url() + "email_preferencerule/dropdown";
    }

    @Override
    public void onClick(ClickEvent event) {
        createClicked();
    }

    public void createClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getAddRuleUrl(), emailRulesSB.getSelectedObject().toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                emailRulesSB.setValue("");
                new ResponseStatusWidget().show("Email rule added.");
                readAllUserEmailRules.refresh();
            }
        });
    }

    private String getAddRuleUrl() {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            return OfficeWelcome.constants.root_url() + "email_preferencerule/add?employeeId=" + JSONUtils.toString(TreeEmployeePanel.instance().getEntity(), "employeeId");
        } else {
            return OfficeWelcome.constants.root_url() + "email_preferencerule/add";
        }
    }

}
