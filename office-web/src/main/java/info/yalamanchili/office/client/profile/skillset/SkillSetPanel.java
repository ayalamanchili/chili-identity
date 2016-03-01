/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class SkillSetPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(SkillSetPanel.class.getName());
    protected String employeeId;

    public SkillSetPanel(String empId) {
        this.employeeId = empId;
        init("SkillSet", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
    }

    @Override
    public void loadEntity() {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null && !response.isEmpty()) {
                            entity = (JSONObject) JSONParser.parseLenient(response);
                            TabPanel.instance().myOfficePanel.entityPanel.clear();
                            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_SALES_AND_MARKETING)) {
                                TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateSkillSetPanel(entity));
                            } else {
                                TabPanel.instance().myOfficePanel.entityPanel.add(new ReadSkillSetPanel(entity));
                            }
                        }
                    }
                });
    }

    @Override
    public void showEntity() {
    }

    public String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + employeeId;
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
