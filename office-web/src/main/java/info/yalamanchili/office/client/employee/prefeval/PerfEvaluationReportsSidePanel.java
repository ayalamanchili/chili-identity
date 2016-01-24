/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.employee.prefeval;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author ayalamanchili
 */
public class PerfEvaluationReportsSidePanel extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    protected Button generateRepB = new Button("Generate");
    protected Button viewRepB = new Button("View");
    protected Label yearL = new Label("Year");
    protected ListBox yearDD = new ListBox();

    public PerfEvaluationReportsSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        generateRepB.addClickHandler(this);
        viewRepB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        yearDD.addItem("2012", "2012");
        yearDD.addItem("2013", "2013");
        yearDD.addItem("2014", "2014");
        yearDD.addItem("2015", "2015");
        yearDD.addItem("2016", "2016");
        yearDD.addItem("2017", "2017");
    }

    @Override
    protected void addWidgets() {
        panel.add(yearL);
        panel.add(yearDD);
        panel.add(generateRepB);
        panel.add(viewRepB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(generateRepB)) {
            generatePerfEvaluationReport();
        }
        if (event.getSource().equals(viewRepB)) {
            viewPerfEvaluationReport();
        }
    }

    protected void generatePerfEvaluationReport() {
        HttpService.HttpServiceAsync.instance().doGet(getperfEvaluationReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected void viewPerfEvaluationReport() {
        HttpService.HttpServiceAsync.instance().doGet(getperfEvaluationReportViewUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        TabPanel.instance().reportingPanel.entityPanel.clear();
                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                        String key = (String) resObj.keySet().toArray()[0];
                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllPerfEvolutionsPanel(results));
                    }
                });
    }

    private String getperfEvaluationReportUrl() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/performance-evaluation-report?year=" + yearDD.getValue(yearDD.getSelectedIndex());
    }

    private String getperfEvaluationReportViewUrl() {
        return OfficeWelcome.constants.root_url() + "performance-evaluation/performance-evaluation-reportView?year=" + yearDD.getValue(yearDD.getSelectedIndex());
    }
}
