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
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadTaskPanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadTaskPanel.class.getName());
    protected JSONObject task;
    protected String taskId;
    protected boolean completedTask;
    public FlowPanel tablePanel;
    //Panels and widgets
    protected CaptionPanel captionPanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    Label nameL = new Label("Name");
    TextBox nameF = new TextBox();
    Label descriptionL = new Label("Description");
    TextArea descriptionF = new TextArea();
    StringField assigneeField = new StringField(OfficeWelcome.constants, "assignee", "Task", true, false);
    DateField createTimeField = new DateField(OfficeWelcome.constants, "createdDate", "Task", true, false);
    DateField dueDateField = new DateField(OfficeWelcome.constants, "dueDate", "Task", true, false);
    //Actions

    Button resolveB = new Button("Resolve");
    Button completeB = new Button("Complete");
    Button acquireB = new Button("Acquire");
    Button releaseB = new Button("Release");
    Button deleteB = new Button("Delete");
    Button manageB = new Button("Manage");

    public ReadTaskPanel(JSONObject task, boolean completedTask) {
        this.task = task;
        this.taskId = JSONUtils.toString(task, "id");
        this.completedTask = completedTask;
        init(captionPanel);
        populateValuesAndRenderButtons();
        if (!completedTask) {
            populateTaskForm();
        }
    }

    public ReadTaskPanel(JSONObject task, boolean completedTask, FlowPanel tablePanel) {
        this.task = task;
        this.taskId = JSONUtils.toString(task, "id");
        this.completedTask = completedTask;
        this.tablePanel = tablePanel;
        init(captionPanel);
        populateValuesAndRenderButtons();
        if (!completedTask) {
            populateTaskForm();
        }
    }

    private void populateValuesAndRenderButtons() {
        nameF.setValue(JSONUtils.toString(task, "name"));
        descriptionF.setValue(JSONUtils.toString(task, "description"));
        assigneeField.setValue(JSONUtils.toString(task, "assignee"));
        createTimeField.setValue(JSONUtils.toString(task, "createTime"));
        if (JSONUtils.toString(task, "assignee").trim().length() > 0) {
            acquireB.setVisible(false);
        }
        //make all button invisible if historic task
        if (task.containsKey("deleteReason")) {
            acquireB.setVisible(false);
            releaseB.setVisible(completedTask);
            resolveB.setVisible(false);
            completeB.setVisible(false);
            deleteB.setVisible(false);
            manageB.setVisible(false);
        }
    }

    private void populateTaskForm() {
        HttpService.HttpServiceAsync.instance().doGet(getTaskFormPropertiesURL(taskId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        renderTaskFormPanel(result);
                    }
                });
    }

    protected void renderTaskFormPanel(String result) {
        if (result != null && !result.trim().toString().equals("null")) {
            if (tablePanel != null) {
                panel.add(new GenericBPMTaskFormPanel("Fill_the_form_and_complete_the_task", taskId, JSONUtils.convertFormProperties(result), tablePanel));
            } else {
                panel.add(new GenericBPMTaskFormPanel("Fill_the_form_and_complete_the_task", taskId, JSONUtils.convertFormProperties(result)));
            }
            completeB.setVisible(false);
            resolveB.setVisible(false);
        }
    }

    @Override
    protected void addListeners() {
        resolveB.addClickHandler(this);
        completeB.addClickHandler(this);
        acquireB.addClickHandler(this);
        resolveB.addClickHandler(this);
        deleteB.addClickHandler(this);
        manageB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        nameF.setEnabled(false);
        descriptionF.setEnabled(false);
        descriptionF.setVisibleLines(10);
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
        panel.add(assigneeField);
        panel.add(createTimeField);
        panel.add(dueDateField);
        panel.add(resolveB);
        panel.add(completeB);
        panel.add(acquireB);
        panel.add(releaseB);
        if (Auth.isAdmin()) 
            panel.add(deleteB);
        if(Auth.isAdmin() || Auth.isCorporateEmployee())
            panel.add(manageB);
        panel.add(new CommentsPanel(taskId));
    }

    @Override
    public void onClick(ClickEvent event) {
        GenericPopup.hideIfOpen();
        if (event.getSource().equals(resolveB)) {
            resolveClicked();
        }
        if (event.getSource().equals(completeB)) {
            completeClicked();
        }
        if (event.getSource().equals(acquireB)) {
            acquireClicked();
        }
        if (event.getSource().equals(releaseB)) {
            releaseClicked();
        }
        if (event.getSource().equals(deleteB)) {
            if (Window.confirm("Are you sure? you want to Delete")) {
                deleteClicked();
            }
        }
        if (event.getSource().equals(manageB)) {
            manageClicked();
        }
    }

    protected void acquireClicked() {
        HttpService.HttpServiceAsync.instance().doGet(getClaimTaskURL(taskId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Task Acquired");
                        if (tablePanel != null) {
                            tablePanel.clear();
                        }
                        TabPanel.instance().getHomePanel().entityPanel.clear();
                        TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks());
                    }
                });
    }

    protected void releaseClicked() {
        HttpService.HttpServiceAsync.instance().doGet(getReleaseTaskURL(taskId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Task Released");
                        if (tablePanel != null) {
                            tablePanel.clear();
                        }
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
                        if (tablePanel != null) {
                            tablePanel.clear();
                        }
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
                        if (tablePanel != null) {
                            tablePanel.clear();
                        }
                        TabPanel.instance().getHomePanel().entityPanel.clear();
                        TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks());
                    }
                });
    }

    protected void deleteClicked() {
        HttpService.HttpServiceAsync.instance().doGet(getDeleteTaskURL(taskId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Task Deleted");
                        if (tablePanel != null) {
                            tablePanel.clear();
                        }
                        TabPanel.instance().getHomePanel().entityPanel.clear();
                        TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks());
                    }
                });
    }

    protected void manageClicked() {
        new GenericPopup(new ManageTaskWidget(taskId)).show();
    }

    protected String getClaimTaskURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/claimtask/" + taskId;
    }

    protected String getReleaseTaskURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/release-task/" + taskId;
    }

    protected String getResolveTaskURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/resolvetask/" + taskId;
    }

    protected String getCompleteTaskURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/completetask/" + taskId;
    }

    protected String getDeleteTaskURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/deletetask/" + taskId;
    }

    protected String getTaskFormPropertiesURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/task_form_properties/" + taskId;
    }
}
