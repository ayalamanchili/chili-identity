/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.json.client.JSONArray;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.rpc.HttpService;

/**
 *
 * @author ayalamanchili
 */
public class GenericBPMTaskFormPanel extends GenericBPMFormPanel {

    protected String taskId;

    public GenericBPMTaskFormPanel(final String taskName, final String taskId, JSONArray array) {
        initCreateComposite(taskName, OfficeWelcome.constants);
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
