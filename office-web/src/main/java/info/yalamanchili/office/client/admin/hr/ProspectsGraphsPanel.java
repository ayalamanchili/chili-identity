/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.corechart.PieChart;

/**
 *
 * @author phani
 */
//TODO try to make a generic chart
public class ProspectsGraphsPanel extends Composite {

    protected FlowPanel panel = new FlowPanel();

    public ProspectsGraphsPanel(JSONObject graphDto) {
        initWidget(panel);
        displayCharts(graphDto);
    }

    protected void displayCharts(final JSONObject graphsDto) {
        ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
        chartLoader.loadApi(() -> {
            panel.add(getSummaryChart());
            showProspectsGraphs(graphsDto);
        });
    }

    protected void showProspectsGraphs(JSONObject graphsDto) {
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "PetitionFor");
        dataTable.addColumn(ColumnType.NUMBER, "Number");
        dataTable.addRows(2);
        dataTable.setValue(0, 0, PetitionFor.Client_Project.name());
        dataTable.setValue(1, 0, PetitionFor.In_House.name());
        dataTable.setValue(0, 1, Integer.valueOf(graphsDto.get(PetitionFor.Client_Project.name()).isNumber().toString()));
        dataTable.setValue(1, 1, Integer.valueOf(graphsDto.get(PetitionFor.In_House.name()).isNumber().toString()));
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
