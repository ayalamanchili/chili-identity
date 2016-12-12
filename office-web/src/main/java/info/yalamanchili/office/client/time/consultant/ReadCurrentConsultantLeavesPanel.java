/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.consultant;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class ReadCurrentConsultantLeavesPanel extends Composite {

    protected FlowPanel panel = new FlowPanel();

    public ReadCurrentConsultantLeavesPanel() {
        initWidget(panel);
        HttpService.HttpServiceAsync.instance().doGet(getCurrentEmpLeavesUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                            panel.add(new ReadAllConsultantTimeSheetsPanel("Consultant Employees on Leave", new JSONArray(), true));
                        } else {
                            JSONObject resObj = JSONParser.parseLenient(result).isObject();
                            String key = (String) resObj.keySet().toArray()[0];
                            JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                            panel.add(new ReadAllConsultantTimeSheetsPanel("Consultant Employees on Leave", results, true));
                        }
                    }
                });
    }

    protected String getCurrentEmpLeavesUrl() {
        return OfficeWelcome.instance().constants.root_url() + "consultant-timesheet/current-leaves";
    }
    
}
