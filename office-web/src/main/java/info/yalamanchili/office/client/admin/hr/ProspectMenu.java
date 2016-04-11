/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.CMenuBar;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.LinkedHashMap;
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
    }
    static Command allMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER)) {
                TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllProspectsPanel());
                TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new ProspectsSidePanel());
            }
        }
    };
    static Command inProgressMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("IN_PROGRESS"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
    static Command recruitingMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("RECRUITING"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
    static Command benchMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("BENCH"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
    static Command onHoldMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("ONHOLD"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
    static Command closedWonMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("CLOSED_WON"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };
    static Command closedLastMaintainenceCmd = () -> {
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("CLOSED_LOST"));
            getProspects(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new SearchProspectsPanel());
        }
    };

    public static void getProspects(JSONObject entity) {
        HttpService.HttpServiceAsync.instance().doPut(getSearchURI(0, 1000), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                            new ResponseStatusWidget().show("No Results");
                            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new ProspectsSidePanel());
                        } else {
                            //TODO use size and entities attributes
                            JSONObject resObj = JSONParser.parseLenient(result).isObject();
                            String key = (String) resObj.keySet().toArray()[0];
                            JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsPanel(results));
                            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new ProspectsSidePanel());
                        }
                    }
                });
    }

    protected static String getSearchURI(Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "prospect/search-prospect/" + start.toString() + "/"
                + limit.toString());
    }

}
