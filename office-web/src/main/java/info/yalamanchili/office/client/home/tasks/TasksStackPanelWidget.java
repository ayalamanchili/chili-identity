/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.common.base.Strings;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author ayalamanchili
 */
public class TasksStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink myTasksL = new ClickableLink("My Tasks");
    protected ClickableLink completedTasksL = new ClickableLink("Completed Tasks");
    protected ClickableLink allTasksL = new ClickableLink("All Tasks");
    protected Button searchTasks = new Button("Search");

    public TasksStackPanelWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        myTasksL.addClickHandler(this);
        completedTasksL.addClickHandler(this);
        allTasksL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        searchTasks.addClickHandler(this);
    }

    StringField userField = null;

    StringField taskNameField = null;

    StringField taskIdField = null;
    
    StringField taskOwnerField = null;

    @Override
    protected void addWidgets() {
        mainPanel.add(myTasksL);
        if (Auth.isAdmin()) {
            mainPanel.add(completedTasksL);
            mainPanel.add(allTasksL);
            mainPanel.add(Utils.getLineSeperatorTag("Search Tasks"));

            userField = new StringField(OfficeWelcome.constants,
                    "user", "Task", false, false);

            taskNameField = new StringField(OfficeWelcome.constants,
                    "taskName", "Task", false, false);

            taskIdField = new StringField(OfficeWelcome.constants,
                    "taskId", "Task", false, false);
            
            taskOwnerField = new StringField(OfficeWelcome.constants,
                    "taskOwner", "Task", false, false);

            mainPanel.add(userField);
            mainPanel.add(taskNameField);
            mainPanel.add(taskIdField);
            mainPanel.add(taskOwnerField);
            mainPanel.add(searchTasks);
        }
        panel.add(mainPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(myTasksL)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            String myTasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/currentuser/";
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks(myTasksUrl, false));
        }
        if (event.getSource().equals(completedTasksL)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            String completedTasksUrl = OfficeWelcome.constants.root_url() + "bpm/history/tasks/";
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks(completedTasksUrl, false));
        }
        if (event.getSource().equals(allTasksL)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            String url = OfficeWelcome.constants.root_url() + "bpm/alltasks/";
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks(url, false));
        }
        if (event.getSource().equals(searchTasks)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            String url = OfficeWelcome.constants.root_url() + "bpm/tasks/search";
            JSONObject entity = new JSONObject();
            if (userField != null && !Strings.isNullOrEmpty(userField.getValue())) {
                entity.put("assignee", new JSONString(userField.getValue()));
            }
            if (taskNameField != null && !Strings.isNullOrEmpty(taskNameField.getValue())) {
                entity.put("name", new JSONString(taskNameField.getValue()));
            }
            if (taskIdField != null && !Strings.isNullOrEmpty(taskIdField.getValue())) {
                entity.put("id", new JSONString(taskIdField.getValue()));
            }
            if (taskOwnerField != null && !Strings.isNullOrEmpty(taskOwnerField.getValue())) {
                entity.put("owner", new JSONString(taskOwnerField.getValue()));
            }
            HttpService.HttpServiceAsync.instance().doPut(url, entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                new ResponseStatusWidget().show("no results");
                            } else {
                                //TODO use size and entities attributes
                                JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                String key = (String) resObj.keySet().toArray()[0];
                                JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks(results));
                            }

                        }
                    });
        }
    }

}
