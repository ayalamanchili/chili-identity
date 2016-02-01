/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import com.google.common.base.Splitter;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.home.tasks.ReadTaskPanel;
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
        if (urltoken.contains("home")) {
            if (urltoken.contains("mytasks")) {
                if (urltoken.contains("viewtask")) {
                    viewTask(urltoken, splitQuery(urltoken));
                }
            }
        }
    }
    
    protected void viewTask(String taskId, Map<String, String> params) {
        logger.info(params.toString());
        TabPanel.instance().homePanel.entityPanel.clear();
        if (params.get("id") != null) {
            String url = OfficeWelcome.constants.root_url() + "bpm/viewtask/" + params.get("id");
            HttpService.HttpServiceAsync.instance().doGet(url, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String response) {
                    logger.info("resp" + response);
                    JSONObject task = (JSONObject) JSONParser.parseLenient(response);
                    TabPanel.instance().homePanel.entityPanel.add(new ReadTaskPanel(task, false));
                }
            });
        }
    }
    
    public static Map<String, String> splitQuery(String url) {
        return Splitter.on('&').trimResults().withKeyValueSeparator("=").split(url.split("\\?")[1]);
    }
}
