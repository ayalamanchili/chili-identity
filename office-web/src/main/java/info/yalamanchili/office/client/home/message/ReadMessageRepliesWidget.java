/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.message;

import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author ayalamanchili
 */
public class ReadMessageRepliesWidget extends ALComposite implements OpenHandler {

    DisclosurePanel repliesDisclosurePanel = new DisclosurePanel("View Replies");
    FlowPanel panel = new FlowPanel();
    String parentMessageId;
    Integer numberOfRepiles;

    public ReadMessageRepliesWidget(String parentPostId, Integer numberOfReplies) {
        this.parentMessageId = parentPostId;
        this.numberOfRepiles = numberOfReplies;
        init(repliesDisclosurePanel);
    }

    protected void getReplies() {
        HttpService.HttpServiceAsync.instance().doGet(getURL(parentMessageId), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                displayReplies(result);
            }
        });
    }

    protected void displayReplies(String result) {
        panel.clear();
        if (JSONParser.parseLenient(result).isNull() == null) {
            JSONObject msgRepliesResp = (JSONObject) JSONParser.parseLenient(result);
            JSONArray messageReplies = JSONUtils.toJSONArray(msgRepliesResp.get("Message"));
            for (int i = 0; i < messageReplies.size(); i++) {
                panel.add(new ReadMessagePanel((JSONObject) messageReplies.get(i)));
            }
        }
    }

    @Override
    protected void addListeners() {
        repliesDisclosurePanel.addOpenHandler(this);
    }

    @Override
    protected void configure() {
        repliesDisclosurePanel.addStyleName("readRepliesPanel");
    }

    @Override
    protected void addWidgets() {
        repliesDisclosurePanel.setContent(panel);
    }

    protected String getURL(String parentPostId) {
        return OfficeWelcome.instance().constants.root_url() + "message/getreplies/" + parentPostId;
    }

    @Override
    public void onOpen(OpenEvent event) {
        getReplies();
    }
}
