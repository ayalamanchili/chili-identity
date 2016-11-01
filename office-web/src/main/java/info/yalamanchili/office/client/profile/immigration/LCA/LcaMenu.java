/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.LCA;

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
public class LcaMenu extends CMenuBar {

    private static Logger logger = Logger.getLogger(LcaMenu.class.getName());
    static EnumField statusF = new EnumField(OfficeWelcome.constants, "status", "LCA", false, false, LCAStatus.names());

    @Override
    protected void configureMenu() {
        addMenuItem("All", "All", allLcaMaintainenceCmd);
        addMenuItem("Pending", "Pending", pendingLcaMaintainenceCmd);
        addMenuItem("Certified", "Certified", certifiedMaintainenceCmd);
        addMenuItem("Certified_Spare", "Certified_Spare", certifiedSpareMaintainenceCmd);
        addMenuItem("Withdrawn", "Withdrawn", withdrawnMaintainenceCmd);
    }
    static Command allLcaMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getImmigrationPanel().sidePanelTop.clear();
            if (TabPanel.instance().getImmigrationPanel().entityPanel.getWidgetCount() > 0) {
                TabPanel.instance().getImmigrationPanel().entityPanel.remove(1);
            }
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
                TabPanel.instance().getImmigrationPanel().entityPanel.add(new ReadAllLCAPanel());
                TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new LcaSidePanel());
            }
        }
    };
    static Command pendingLcaMaintainenceCmd = () -> {
        TabPanel.instance().getImmigrationPanel().sidePanelTop.clear();
        if (TabPanel.instance().getImmigrationPanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getImmigrationPanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("Pending"));
            getLcas(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new LcaSidePanel());
            TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new SearchLcaPanel());
        }
    };
    static Command certifiedMaintainenceCmd = () -> {
        TabPanel.instance().getImmigrationPanel().sidePanelTop.clear();
        if (TabPanel.instance().getImmigrationPanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getImmigrationPanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("Certified"));
            getLcas(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new SearchLcaPanel());
        }
    };
    static Command certifiedSpareMaintainenceCmd = () -> {
        TabPanel.instance().getImmigrationPanel().sidePanelTop.clear();
        if (TabPanel.instance().getImmigrationPanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getImmigrationPanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("CertifiedSpare"));
            getLcas(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new SearchLcaPanel());
        }
    };
    static Command withdrawnMaintainenceCmd = () -> {
        TabPanel.instance().getImmigrationPanel().sidePanelTop.clear();
        if (TabPanel.instance().getImmigrationPanel().entityPanel.getWidgetCount() > 0) {
            TabPanel.instance().getImmigrationPanel().entityPanel.remove(1);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            JSONObject entity = new JSONObject();
            entity.put("status", new JSONString("Withdrawn"));
            getLcas(entity);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
            TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new SearchLcaPanel());
        }
    };

    public static void getLcas(JSONObject entity) {
        HttpService.HttpServiceAsync.instance().doPut(getStatusSearchURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                            new ResponseStatusWidget().show("No Results");
                            TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new LcaSidePanel());
                            JSONArray results = new JSONArray();
                            TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllLCAPanel(results, false, false));
                        } else {
                            //TODO use size and entities attributes
                            JSONObject resObj = JSONParser.parseLenient(result).isObject();
                            String key = (String) resObj.keySet().toArray()[0];
                            JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                            JSONObject result1 = results.get(0).isObject();
                            if (result1.get("status").isString().stringValue().equals(LCAStatus.Certified_Spare.name())) {
                                TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllLCAPanel(results, true, false));
                                TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new LcaSidePanel());
                            } else {
                                TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllLCAPanel(results, false, false));
                                TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new LcaSidePanel());
                            }
                        }
                    }
                });
    }

    protected static String getStatusSearchURI() {
        return OfficeWelcome.constants.root_url() + "lca/lca-status-search";
    }
}
