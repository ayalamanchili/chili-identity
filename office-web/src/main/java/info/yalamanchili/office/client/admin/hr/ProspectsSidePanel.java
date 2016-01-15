/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.corechart.PieChart;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ProspectsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ProspectsSidePanel.class.getName());
    public FlowPanel sidepanel = new FlowPanel();
    Button reportB = new Button("Reports");
    Button graphsB = new Button("Charts");
    EnumField statusF = new EnumField(OfficeWelcome.constants, "status", "Prospect", false, false, ProspectStatus.names(), Alignment.VERTICAL);
    DateField startDateF = new DateField(OfficeWelcome.constants, "joiningDateTo", "Prospect", false, false, Alignment.VERTICAL);
    DateField endDateF = new DateField(OfficeWelcome.constants, "joiningDateFrom", "Prospect", false, false, Alignment.VERTICAL);

    public ProspectsSidePanel() {
        init(sidepanel);
    }

    @Override
    protected void addListeners() {
        reportB.addClickHandler(this);
        graphsB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        sidepanel.add(new SearchProspectsPanel());
        sidepanel.add(Utils.getLineSeperatorTag("Report"));
        sidepanel.add(statusF);
        sidepanel.add(startDateF);
        sidepanel.add(endDateF);
        sidepanel.add(reportB);
        sidepanel.add(graphsB);
    }

    public JSONObject getObject() {
        JSONObject obj = new JSONObject();
        if (statusF.getValue() == null) {
            statusF.setMessage("Required");
        }
        if (statusF.listBox.getSelectedValue() != null) {
            obj.put("status", new JSONString(statusF.getValue()));
        }
        if (startDateF.getDate() != null) {
            obj.put("joiningDateFrom", new JSONString(DateUtils.toDateString(startDateF.getDate())));
        }
        if (endDateF.getDate() != null) {
            obj.put("joiningDateTo", new JSONString(DateUtils.toDateString(endDateF.getDate())));
        }
        return obj;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(reportB)) {
            JSONObject obj = getObject();
            if (obj.containsKey("status")) {
                String reportUrl = OfficeWelcome.instance().constants.root_url() + "prospect/report";
                HttpService.HttpServiceAsync.instance().doPut(reportUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String result) {
                                new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                            }
                        });
            }
        }
        if (event.getSource().equals(graphsB)) {
            JSONObject obj = getObject();
            if (obj.containsKey("status")) {
                String graphUrl = OfficeWelcome.instance().constants.root_url() + "prospect/graph";
                HttpService.HttpServiceAsync.instance().doPut(graphUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String result) {
                                logger.info(result);
                            }
                        });
            }
        }
    }

    protected void displayCharts(JSONObject graphsDto) {
        ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
        chartLoader.loadApi(new Runnable() {

            @Override
            public void run() {
//                entityFieldsPanel.insert(getSummaryChart(), entityFieldsPanel.getWidgetIndex(leaveRequestPolicy) + 1);
//                showLeavesSummaryChart();
            }
        });
    }

    protected void showLeavesSummaryChart(JSONObject graphsDto) {
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "Name");
        dataTable.addColumn(ColumnType.NUMBER, "Donuts eaten");
        dataTable.addRows(2);
        dataTable.setValue(0, 0, "PTO Available");
        dataTable.setValue(1, 0, "PTO Used");
        dataTable.setValue(0, 1, Double.valueOf(JSONUtils.toString(graphsDto, "availablePTOHours")));
        dataTable.setValue(1, 1, Double.valueOf(JSONUtils.toString(graphsDto, "usedPTOHours")));
        // Draw the chart
        timeSummaryChart.draw(dataTable);
    }
    private PieChart timeSummaryChart;

    private Widget getSummaryChart() {
        if (timeSummaryChart == null) {
            timeSummaryChart = new PieChart();
        }
        return timeSummaryChart;
    }
}
