/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class ReadCurrentCorpLeavesPanel extends Composite {

    protected FlowPanel panel = new FlowPanel();

    public ReadCurrentCorpLeavesPanel() {
        initWidget(panel);
        HttpService.HttpServiceAsync.instance().doGet(getCurrentEmpLeavesUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                            new ResponseStatusWidget().show("no results");
                        } else {
                            JSONObject resObj = JSONParser.parseLenient(result).isObject();
                            String key = (String) resObj.keySet().toArray()[0];
                            JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                            panel.add(new ReadAllCorporateTimeSheetPanel("Employees on Leave",results));
                        }
                    }
                });
    }

    protected String getCurrentEmpLeavesUrl() {
        return OfficeWelcome.instance().constants.root_url() + "corporate-timesheet/current-leaves";
    }
}
