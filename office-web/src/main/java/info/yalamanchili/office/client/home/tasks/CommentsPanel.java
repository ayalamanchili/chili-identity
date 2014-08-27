/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextArea;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CommentsPanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CommentsPanel.class.getName());
    protected String taskId;
    protected DisclosurePanel panel = new DisclosurePanel("Comments");
    protected FlowPanel commentsPanel = new FlowPanel();
    protected TextArea commentTA = new TextArea();
    protected Button addCommentB = new Button("add Comment");

    public CommentsPanel(String taskId) {
        this.taskId = taskId;
        init(panel);
        panel.setContent(commentsPanel);
        panel.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                getComments();
            }
        });
    }

    protected void getComments() {
        HttpService.HttpServiceAsync.instance().doGet(getCommentsUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        populateComments(result);
                    }
                });
    }

    protected void populateComments(String commentsResponse) {
        commentsPanel.clear();
        addWidgets();
        if (commentsResponse != null && !commentsResponse.isEmpty()) {
            JSONObject table = (JSONObject) JSONParser.parseLenient(commentsResponse);
            if (table.get("entities") != null) {
                JSONArray comments = JSONUtils.toJSONArray(table.get("entities"));
                for (int i = 0; i < comments.size(); i++) {
                    commentsPanel.add(new ReadCommentPanel((JSONObject) comments.get(i)));
                }
            }

        }
    }

    public String getCommentsUrl() {
        return OfficeWelcome.constants.root_url() + "bpm/task/comments/" + taskId;
    }

    @Override
    protected void addListeners() {
        addCommentB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        commentTA.setWidth("100%");
    }

    @Override
    protected void addWidgets() {
        commentsPanel.add(commentTA);
        commentsPanel.add(addCommentB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addCommentB)) {
            JSONObject entity = new JSONObject();
            entity.put("taskId", new JSONString(taskId));
            entity.put("fullMessage", new JSONString(commentTA.getValue()));
            HttpService.HttpServiceAsync.instance().doPut(getAddCommentUrl(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            new ResponseStatusWidget().show("Successfully added Comment");
                            commentTA.setText("");
                            getComments();
                        }
                    });
        }
    }

    protected String getAddCommentUrl() {
        return OfficeWelcome.constants.root_url() + "bpm/addcomment";
    }
}
