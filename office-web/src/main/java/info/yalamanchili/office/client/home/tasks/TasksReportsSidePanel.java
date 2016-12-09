/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class TasksReportsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(TasksReportsSidePanel.class.getName());

    protected FlowPanel panel = new FlowPanel();
    protected String url;
    ClickableLink tasksReportL = new ClickableLink("Corproate Employee Tasks Report");

    public TasksReportsSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        tasksReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        tasksReportL.setTitle("report with task name,owner, assine f all employees");
        TabPanel.instance().timePanel.sidePanelTop.setHeight("100%");

    }

    @Override
    protected void addWidgets() {
        panel.add(tasksReportL);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(tasksReportL)) {
            generateTaskReport();
        }

    }

    protected void generateTaskReport() {
        HttpService.HttpServiceAsync.instance().doGet(getTaskReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getTaskReportUrl() {
        return OfficeWelcome.constants.root_url() + "bpm/alltasks-reports/";
    }
}
