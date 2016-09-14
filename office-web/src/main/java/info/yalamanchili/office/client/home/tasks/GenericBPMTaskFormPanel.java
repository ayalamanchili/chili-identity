/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author ayalamanchili
 */
public class GenericBPMTaskFormPanel extends GenericBPMFormPanel {

    protected String taskId;
    public FlowPanel tablePanel;

    public GenericBPMTaskFormPanel(final String taskName, final String taskId, JSONArray array) {
        initCreateComposite(taskName, OfficeWelcome.constants2);
        HttpService.HttpServiceAsync.instance().doGet(getTaskFormPropertiesURL(taskId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        //TODO weird return check
                        if (result != null && !result.trim().toString().equals("null")) {
                            GenericBPMTaskFormPanel.this.taskId = taskId;
                            GenericBPMTaskFormPanel.this.formProperties = JSONUtils.convertFormProperties(result);
                            addWidgets();
                        }
                    }
                });
    }

    public GenericBPMTaskFormPanel(final String taskName, final String taskId, JSONArray array, FlowPanel tablePanel) {
        this.tablePanel = tablePanel;
        initCreateComposite(taskName, OfficeWelcome.constants2);
        HttpService.HttpServiceAsync.instance().doGet(getTaskFormPropertiesURL(taskId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        //TODO weird return check
                        if (result != null && !result.trim().toString().equals("null")) {
                            GenericBPMTaskFormPanel.this.taskId = taskId;
                            GenericBPMTaskFormPanel.this.formProperties = JSONUtils.convertFormProperties(result);
                            addWidgets();
                        }
                    }
                });
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Task Completed");
        if (tablePanel != null) {
            tablePanel.clear();
        }
        TabPanel.instance().getHomePanel().entityPanel.clear();
        TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks());
    }

    protected String getTaskFormPropertiesURL(String taskId) {
        return OfficeWelcome.constants.root_url() + "bpm/task_form_properties/" + taskId;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bpm/completetask/" + taskId;
    }
}
