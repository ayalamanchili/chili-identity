/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadTaskPanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadTaskPanel.class.getName());
    protected JSONObject task;
    protected String taskId;
    //Panels and widgets
    protected CaptionPanel captionPanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    Label nameL = new Label("Name");
    TextArea nameF = new TextArea();
    Label descriptionL = new Label("Description");
    TextArea descriptionF = new TextArea();
    //Actions
    Button claimB = new Button("Claim");
    Button resolveB = new Button("Resolve");
    Button completeB = new Button("Complete");

    public ReadTaskPanel(JSONObject task) {
        this.task = task;
        this.taskId = JSONUtils.toString(task, "id");
        init(captionPanel);
        populateValues();
        populateTaskForm();
    }

    private void populateValues() {
        nameF.setValue(JSONUtils.toString(task, "name"));
        descriptionF.setValue(JSONUtils.toString(task, "description"));
    }

    private void populateTaskForm() {
        HttpService.HttpServiceAsync.instance().doGet(getTaskFormPropertiesURL(taskId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                //TODO weird return check
                if (result != null && !result.trim().toString().equals("null")) {
                    panel.add(new GenericBPMTaskFormPanel("Task", taskId, JSONUtils.convertFormProperties(result)));
                } else {
                    //TODO add complete buttons
                }
            }
        });
    }

    @Override
    protected void addListeners() {
        claimB.addClickHandler(this);
        resolveB.addClickHandler(this);
        completeB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        nameF.setEnabled(false);
        descriptionF.setEnabled(false);
        nameF.setWidth("100%");
        descriptionF.setWidth("100%");
    }

    @Override
    protected void addWidgets() {
        captionPanel.setCaptionHTML("Task");
        captionPanel.setContentWidget(panel);
        panel.add(nameL);
        panel.add(nameF);
        panel.add(descriptionL);
        panel.add(descriptionF);
        panel.add(claimB);
        panel.add(resolveB);
        panel.add(completeB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(claimB)) {
            claimClicked();
        }
        if (event.getSource().equals(resolveB)) {
            resolveClicked();
        }
        if (event.getSource().equals(completeB)) {
            completeClicked();
        }
    }

    protected void claimClicked() {
        HttpService.HttpServiceAsync.instance().doGet(getClaimTaskURL(taskId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Task Claimed");
                TabPanel.instance().getHomePanel().entityPanel.clear();
                TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks());
            }
        });
    }

    protected void resolveClicked() {
        HttpService.HttpServiceAsync.instance().doGet(getResolveTaskURL(taskId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Task Resolved");
                TabPanel.instance().getHomePanel().entityPanel.clear();
                TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks());
            }
        });
    }

    protected void completeClicked() {
        HttpService.HttpServiceAsync.instance().doGet(getCompleteTaskURL(taskId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Task Completed");
                TabPanel.instance().getHomePanel().entityPanel.clear();
                TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks());
            }
        });
    }

    protected String getClaimTaskURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/claimtask/" + taskId;
    }

    protected String getResolveTaskURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/resolvetask/" + taskId;
    }

    protected String getCompleteTaskURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/completetask/" + taskId;
    }

    protected String getTaskFormPropertiesURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/task_form_properties/" + taskId;
    }
}
