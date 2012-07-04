package info.yalamanchili.office.client.social;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.rpc.HttpService;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

public class EmployeePostsPanel extends ALComposite {

    private static Logger logger = Logger.getLogger(EmployeePostsPanel.class.getName());
    FlowPanel mainPanel = new FlowPanel();

    public EmployeePostsPanel() {
        init(mainPanel);
        loadEmployeePosts();
    }

    protected void loadEmployeePosts() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeFeedURL(0, 10), OfficeWelcome.instance().getHeaders(),
                true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                showEmployeePosts(result);
            }
        });
    }

    protected void showEmployeePosts(String result) {
        JSONObject postsResp = (JSONObject) JSONParser.parseLenient(result);
        JSONArray posts = JSONUtils.toJSONArray(postsResp.get("post"));
        for (int i = 0; i < posts.size(); i++) {
            mainPanel.add(new ReadPostWidget((JSONObject) posts.get(i),true));
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

    protected String getEmployeeFeedURL(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "social/employeefeed/" + start.toString() + "/" + limit.toString();
    }
}
