/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.corechart.BarChart;
import info.chili.gwt.crud.GenericTableRowOptionsWidget;
import info.chili.gwt.crud.ReadAllComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class EmployeeRecruitedBWDatesChartPanel extends ReadAllComposite {

    private static Logger logger = Logger.getLogger(EmployeeRecruitedBWDatesChartPanel.class.getName());
    public static EmployeeRecruitedBWDatesChartPanel instance;

    public EmployeeRecruitedBWDatesChartPanel(JSONArray results) {
        instance = this;
        initTable("Contract", results, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
    }

    @Override
    public void createTableHeader() {
    }

    @Override
    protected void createOptionsWidget(GenericTableRowOptionsWidget rowOptionsWidget, int row, String id) {
    }

    @Override
    public void fillData(JSONArray entities) {
        ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
        chartLoader.loadApi(new Runnable() {
            @Override
            public void run() {
                basePanel.add(getSummaryChart());
                showLeavesSummaryChart();
            }
        });
    }
    private BarChart timeSummaryChart;

    private Widget getSummaryChart() {
        if (timeSummaryChart == null) {
            timeSummaryChart = new BarChart();
            timeSummaryChart.setPixelSize(1000, 600);
        }
        return timeSummaryChart;
    }

    protected void showLeavesSummaryChart() {
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "Name");
        dataTable.addColumn(ColumnType.NUMBER, "Employee Recruited By");

        Map<String, Integer> values = new HashMap<String, Integer>();
        String finalrecruiters = "";
        for (int j = 0; j < entities.size(); j++) {
            JSONObject obj = (JSONObject) entities.get(j);
            if (obj.containsKey("recruiter")) {
                String name = obj.get("recruiter").isString().stringValue();
                finalrecruiters = finalrecruiters.concat(name + ";");
            }
        }
        //int count = 0;
        String[] recs = finalrecruiters.split(";");
        List asList = Arrays.asList(recs);
        Set<String> mySet = new HashSet<String>(asList);
        for (String s : mySet) {
            values.put(s, Collections.frequency(asList, s));
        }
        dataTable.addRows(values.size());
        Set<String> keys = values.keySet();
        int i = 0;
        for (String key : keys) {
            dataTable.setValue(i, 0, key);
            dataTable.setValue(i, 1, values.get(key));
            i++;
        }
        for (int j = 0; j < entities.size(); j++) {
            if(dataTable.getValueString(j, 0).startsWith("a") || dataTable.getValueString(j, 0).startsWith("A")){
            }
        }
        // Draw the chart
        timeSummaryChart.draw(dataTable);
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
    }

    @Override
    public void onOptionsSelected(ClickEvent event, GenericTableRowOptionsWidget t) {
    }
}
