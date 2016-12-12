/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Command;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.CMenuBar;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ProspectMenu extends CMenuBar {

    private static Logger logger = Logger.getLogger(ProspectMenu.class.getName());
    static EnumField statusF = new EnumField(OfficeWelcome.constants, "status", "Prospect", false, false, ProspectStatus.names());

    @Override
    protected void configureMenu() {
        addMenuItem("All", "All", allMaintainenceCmd);
        addMenuItem("IN_PROGRESS", "IN_PROGRESS", inProgressMaintainenceCmd);
        addMenuItem("RECRUITING", "RECRUITING", recruitingMaintainenceCmd);
        addMenuItem("BENCH", "BENCH", benchMaintainenceCmd);
        addMenuItem("ONHOLD", "ONHOLD", onHoldMaintainenceCmd);
        addMenuItem("CLOSED_WON", "CLOSED_WON", closedWonMaintainenceCmd);
        addMenuItem("CLOSED_LOST", "CLOSED_LOST", closedLastMaintainenceCmd);
        addMenuItem("CLOSED_ONBOARDING_REQUESTED", "CLOSED_ONBOARDING_REQUESTED", closedOnboardingCmd);
    }
    static Command allMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            if (TabPanel.instance().getMyOfficePanel().entityPanel.getWidgetCount() > 0) {
                TabPanel.instance().getMyOfficePanel().entityPanel.remove(1);
            }
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER,Auth.ROLE.ROLE_ON_BOARDING_MGR,Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
                TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllProspectsPanel());
                TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new ProspectsSidePanel());
            }
        }
    };
    static Command inProgressMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        if (TabPanel.instance().getMyOfficePanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getMyOfficePanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER,Auth.ROLE.ROLE_ON_BOARDING_MGR,Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("IN_PROGRESS"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
    static Command recruitingMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        if (TabPanel.instance().getMyOfficePanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getMyOfficePanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER,Auth.ROLE.ROLE_ON_BOARDING_MGR,Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("RECRUITING"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
    static Command benchMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        if (TabPanel.instance().getMyOfficePanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getMyOfficePanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER,Auth.ROLE.ROLE_ON_BOARDING_MGR,Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("BENCH"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
    static Command onHoldMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        if (TabPanel.instance().getMyOfficePanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getMyOfficePanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER,Auth.ROLE.ROLE_ON_BOARDING_MGR,Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("ONHOLD"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
    static Command closedWonMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        if (TabPanel.instance().getMyOfficePanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getMyOfficePanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER,Auth.ROLE.ROLE_ON_BOARDING_MGR,Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("CLOSED_WON"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
    static Command closedLastMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        if (TabPanel.instance().getMyOfficePanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getMyOfficePanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER,Auth.ROLE.ROLE_ON_BOARDING_MGR,Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("CLOSED_LOST"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };

    public static void getProspects(JSONObject entity) {
        HttpService.HttpServiceAsync.instance().doPut(getStatusSearchURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                            new ResponseStatusWidget().show("No Results");
                            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new ProspectsSidePanel());
                            JSONArray results = new JSONArray();
                            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsPanel(results, false, false));
                        } else {
                            //TODO use size and entities attributes
                            JSONObject resObj = JSONParser.parseLenient(result).isObject();
                            String key = (String) resObj.keySet().toArray()[0];
                            JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                            JSONObject result1 = results.get(0).isObject();
                            if (result1.get("status").isString().stringValue().equals(ProspectStatus.CLOSED_WON.name())) {
                                TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsPanel(results, true, false));
                                TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new ProspectsSidePanel());
                            } else {
                                TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsPanel(results, false, false));
                                TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new ProspectsSidePanel());
                            }
                        }
                    }
                });
    }
    static Command closedOnboardingCmd = () -> {
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        if (TabPanel.instance().getMyOfficePanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getMyOfficePanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER,Auth.ROLE.ROLE_ON_BOARDING_MGR,Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("CLOSED_ONBOARDING_REQUESTED"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };

    protected static String getStatusSearchURI() {
        return OfficeWelcome.constants.root_url() + "prospect/prospect-status-search";
    }
}
