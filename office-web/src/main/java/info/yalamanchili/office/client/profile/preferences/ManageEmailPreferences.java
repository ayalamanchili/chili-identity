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
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.Map;

/**
 *
 * @author ayalamanchili
 */
public class ManageEmailPreferences extends ALComposite implements ClickHandler {
    
    CaptionPanel mainPanel = new CaptionPanel();
    FlowPanel panel = new FlowPanel();
    SuggestBox emailRulesSB = new SuggestBox(OfficeWelcome.constants, "name", "EmailPreferenceRule", false, false);
    Button createB = new Button("Create");
    
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
        panel.add(emailRulesSB);
        panel.add(createB);
        panel.add(new ReadAllUserEmailPreferences());
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
        return URL.encode(OfficeWelcome.constants.root_url() + "email_preferencerule/dropdown");
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
                        
                    }
                });
    }
    
    private String getAddRuleUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "email_preferencerule/add");
    }
    
}
