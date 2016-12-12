/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author Ramana.Lukalapu
 */
public class CurrentWeekOutOfOfficeRequestsPanel extends Composite {

    protected FlowPanel panel = new FlowPanel();

    public CurrentWeekOutOfOfficeRequestsPanel() {
        initWidget(panel);
        Timer timer = new Timer() {
            @Override
            public void run() {
                getCurrentWeekRequests();
            }
        };
        timer.schedule(2000);

    }

    protected void getCurrentWeekRequests() {
        HttpService.HttpServiceAsync.instance().doGet(getCurrentEmpRequestsUrl(0, "5"), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                    panel.add(new ReadAllOutOfOfficePanel("Current Week Remote Requests", new JSONArray()));
                } else {
                    JSONObject resObj = JSONParser.parseLenient(result).isObject();
                    String key = (String) resObj.keySet().toArray()[0];
                    JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                    panel.add(new ReadAllOutOfOfficePanel("Current Week Remote Requests", results, true));
                }
            }
        });
    }

    protected String getCurrentEmpRequestsUrl(Integer start, String limit) {
        return OfficeWelcome.instance().constants.root_url() + "out-of-office/current-week/" + start.toString() + "/"
                + limit.toString();
    }
}
