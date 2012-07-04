/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.social;

import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author ayalamanchili
 */
public class ReadRepliesWidget extends ALComposite implements OpenHandler {

    DisclosurePanel repliesDisclosurePanel = new DisclosurePanel("view replies");
    FlowPanel panel = new FlowPanel();
    String parentPostId;
    Long numberOfRepiles;

    public ReadRepliesWidget(String parentPostId, Long numberOfReplies) {
        this.parentPostId = parentPostId;
        this.numberOfRepiles = numberOfReplies;
        init(repliesDisclosurePanel);
    }

    protected void getReplies() {
        HttpService.HttpServiceAsync.instance().doGet(getURL(parentPostId), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                displayReplies(result);
            }
        });
    }

    protected void displayReplies(String result) {
        panel.clear();
        if (JSONParser.parseLenient(result).isNull() == null) {
            JSONObject postsResp = (JSONObject) JSONParser.parseLenient(result);
            JSONArray posts = JSONUtils.toJSONArray(postsResp.get("post"));
            for (int i = 0; i < posts.size(); i++) {
                panel.add(new ReadPostWidget((JSONObject) posts.get(i), false));
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
        return OfficeWelcome.instance().constants.root_url() + "social/replies/" + parentPostId;
    }

    @Override
    public void onOpen(OpenEvent event) {
        getReplies();
    }
}
