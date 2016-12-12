/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.social;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.rpc.HttpService;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import info.yalamanchili.office.client.social.company.ReadCompanyPostPanel;
import info.yalamanchili.office.client.social.employee.ReadEmployeePostPanel;
import java.util.HashSet;
import java.util.Set;

public class ReadAllPostsPanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadAllPostsPanel.class.getName());
    protected int start = 0;
    protected int limit = 5;
    FlowPanel panel = new FlowPanel();
    FlowPanel postsPanel = new FlowPanel();
    Label showMoreL = new Label("load more");
    Set<String> postIds = new HashSet<String>();

    public ReadAllPostsPanel() {
        init(panel);
        loadPosts();
    }

    public void loadPosts() {
        HttpService.HttpServiceAsync.instance().doGet(getPostFeedURL(start, limit), OfficeWelcome.instance().getHeaders(),
                true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        showPosts(result);
                    }
                });
    }

    protected void showPosts(String result) {
        JSONObject postsResp = (JSONObject) JSONParser.parseLenient(result).isObject();
        if (postsResp != null) {
            JSONArray posts = JSONUtils.toJSONArray(postsResp.get("post"));
            for (int i = 0; i < posts.size(); i++) {
                JSONObject post = (JSONObject) posts.get(i);
                String postId = JSONUtils.toString(post, "id");
                if (!postIds.contains(postId)) {
                    postIds.add(postId);
                    if (SocialMenu.isEmployeedFeedSelected()) {
                        postsPanel.add(new ReadEmployeePostPanel(post, true));
                    } else if (SocialMenu.isCompanyFeedSelected()) {
                        postsPanel.add(new ReadCompanyPostPanel(post, true));
                    }

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
        panel.add(postsPanel);
        panel.add(showMoreL);
    }

    public void refresh() {
        //Temp fix until the proper logic for ordering the posts is in place.
        postsPanel.clear();
        postIds.clear();
        loadPosts();
    }

    protected String getPostFeedURL(Integer start, Integer limit) {
        if (SocialMenu.isEmployeedFeedSelected() == true) {
            return OfficeWelcome.constants.root_url() + "social/employeefeed/" + start.toString() + "/" + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "social/companyfeed/" + start.toString() + "/" + limit.toString();
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (showMoreL.equals(event.getSource())) {
            loadMore();
        }
    }

    protected void loadMore() {
        start = start + limit;
        loadPosts();
    }
}
