package info.yalamanchili.office.client.social;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.rpc.HttpService;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.office.client.social.company.ReadCompanyPostPanel;
import info.yalamanchili.office.client.social.employee.ReadEmployeePostPanel;
import java.util.HashSet;
import java.util.Set;

public class ReadAllPostsPanel extends ALComposite {

    private static Logger logger = Logger.getLogger(ReadAllPostsPanel.class.getName());
    FlowPanel panel = new FlowPanel();
    Set<String> postIds = new HashSet<String>();

    public ReadAllPostsPanel() {
        init(panel);
        loadPosts();
    }

    public void loadPosts() {
        HttpService.HttpServiceAsync.instance().doGet(getPostFeedURL(0, 10), OfficeWelcome.instance().getHeaders(),
                true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                showPosts(result);
            }
        });
    }

    protected void showPosts(String result) {
        JSONObject postsResp = (JSONObject) JSONParser.parseLenient(result);
        JSONArray posts = JSONUtils.toJSONArray(postsResp.get("post"));
        for (int i = 0; i < posts.size(); i++) {
            JSONObject post = (JSONObject) posts.get(i);
            String postId = JSONUtils.toString(post, "id");
            if (!postIds.contains(postId)) {
                postIds.add(postId);
                if (SocialSidePanel.isEmployeedFeedSelected()) {
                    panel.insert(new ReadEmployeePostPanel(post, true), 0);
                } else if (SocialSidePanel.isCompanyFeedSelected()) {
                    panel.insert(new ReadCompanyPostPanel(post, true), 0);
                }

            }
        }
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
    }

    public void refresh() {
        loadPosts();
    }

    protected String getPostFeedURL(Integer start, Integer limit) {
        if (SocialSidePanel.isEmployeedFeedSelected() == true) {
            return OfficeWelcome.constants.root_url() + "social/employeefeed/" + start.toString() + "/" + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "social/companyfeed/" + start.toString() + "/" + limit.toString();
        }
    }
}
