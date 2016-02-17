/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;

/**
 *
 * @author raghu
 */
public class SkillSetOptionsPanel extends ALComposite implements ClickHandler {

    protected String employeeId;
    protected HorizontalPanel panel = new HorizontalPanel();
    protected Button updateSkillSetB = new Button("Update");

    public SkillSetOptionsPanel(String employeeId) {
        this.employeeId = employeeId;
        init(panel);
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_RECRUITER)) {
            panel.add(updateSkillSetB);
        }

    }

    @Override
    protected void addListeners() {
        updateSkillSetB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO move this to common css
        panel.setSpacing(5);

    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(updateSkillSetB)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            HttpService.HttpServiceAsync.instance().doGet(getSkillSetURI(),
                    OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String arg0) {
                    if (arg0 != null) {
                        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateSkillSetPanel((JSONObject) JSONParser.parseLenient(arg0)));
                    }
                }
            });
        }
    }

    protected String getSkillSetURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + TreeEmployeePanel.instance().getEntityId();
    }
}
