/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.message;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class MyMessagesPanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(MyMessagesPanel.class.getName());
    protected int start = 0;
    protected int limit = 5;
    FlowPanel panel = new FlowPanel();
    FlowPanel messagesPanel = new FlowPanel();
    Label showMoreL = new Label("load more");
    Set<String> messageIds = new HashSet<String>();

    public MyMessagesPanel() {
        init(panel);
        loadMessages();
    }

    public void loadMessages() {
        HttpService.HttpServiceAsync.instance().doGet(getMyMessagesURL(start, limit), OfficeWelcome.instance().getHeaders(),
                true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        showMessages(result);
                    }
                });
    }

    protected void showMessages(String result) {
        JSONObject messagesResp = (JSONObject) JSONParser.parseLenient(result).isObject();
        if (messagesResp != null) {
            JSONArray messages = JSONUtils.toJSONArray(messagesResp.get("Message"));
            if (messages.size() <= 0) {
                showMoreL.setText("No Messages");
            }
            for (int i = 0; i < messages.size(); i++) {
                JSONObject message = (JSONObject) messages.get(i);
                String postId = JSONUtils.toString(message, "id");
                if (!messageIds.contains(postId)) {
                    messageIds.add(postId);
                    messagesPanel.add(new ReadMessagePanel(message));
                }
            }
        }
    }

    @Override
    protected void addListeners() {
        showMoreL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        showMoreL.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        showMoreL.addStyleName("showMoreL");
    }

    @Override
    protected void addWidgets() {
        panel.add(messagesPanel);
        panel.add(showMoreL);
    }

    public void refresh() {
        //Temp fix until the proper logic for ordering the posts is in place.
        messagesPanel.clear();
        messageIds.clear();
        loadMessages();
    }

    protected String getMyMessagesURL(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "message/mymessages/" + start.toString() + "/" + limit.toString();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (showMoreL.equals(event.getSource())) {
            loadMore();
        }
    }

    protected void loadMore() {
        start = start + limit;
        loadMessages();
    }
}
