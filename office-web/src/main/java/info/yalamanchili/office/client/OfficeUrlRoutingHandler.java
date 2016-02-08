/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import com.google.common.base.Splitter;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.admin.hr.ReadAllProspectsPanel;
import info.yalamanchili.office.client.advancerequisition.ReadAllAdvanceRequisitionPanel;
import info.yalamanchili.office.client.expense.chkreq.ReadAllImmigrationCheckRequisitionPanel;
import info.yalamanchili.office.client.expense.travelauthorization.ReadAllTravelAuthorizationPanel;
import info.yalamanchili.office.client.expensereports.ReadAllExpenseReportsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.home.tasks.ReadTaskPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author phani
 */
public class OfficeUrlRoutingHandler implements ValueChangeHandler<String> {

    public static Logger logger = Logger.getLogger(OfficeUrlRoutingHandler.class.getName());

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String urltoken = event.getValue();
        logger.info("------------urltoken:" + urltoken + ":");
        Map<String, String> params = splitQuery(urltoken);
        logger.info("---------Params:" +params);
        if (params.containsKey("entity")) {
            switch (params.get("entity")) {
                case "info.chili.bpm.types.Task":
                    taskNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.hr.Prospect":
                    prospectNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition":
                    checkRequisitionNavigation(params);
                    break;
                //TODO add navigation to add entities that have comment
            }
        }
    }

    protected void commentNavigation(Map<String, String> params) {

    }

    protected void prospectNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().myOfficePanel);
        ReadAllProspectsPanel readAllProspects = new ReadAllProspectsPanel(new JSONArray());
        readAllProspects.viewClicked(params.get("id"));
    }
    
    protected void checkRequisitionNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().expensePanel);
        ReadAllImmigrationCheckRequisitionPanel readAllCheckRequisition = new ReadAllImmigrationCheckRequisitionPanel(new JSONArray());
        readAllCheckRequisition.viewClicked(params.get("id"));
    }
    
    protected void taskNavigation(Map<String, String> params) {
        TabPanel.instance().homePanel.entityPanel.clear();
        if (params.get("id") != null) {
            String url = OfficeWelcome.constants.root_url() + "bpm/viewtask/" + params.get("id");
            HttpService.HttpServiceAsync.instance().doGet(url, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onFailure(Throwable err) {
                            super.onFailure(err);
                            TabPanel.instance().homePanel.entityPanel.add(new ReadAllTasks());
                        }

                        @Override
                        public void onResponse(String response) {
                            JSONObject task = (JSONObject) JSONParser.parseLenient(response);
                            TabPanel.instance().homePanel.entityPanel.add(new ReadTaskPanel(task, false));
                        }
                    });
        }
    }

//TODO move to commons
    public static Map<String, String> splitQuery(String url) {
        return Splitter.on('&').trimResults().withKeyValueSeparator("=").split(url.split("\\?")[1]);
    }
}
