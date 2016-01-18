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
            panel.add(getPetetionForChart());
            panel.add(getEmployeerChart());
            panel.add(getPlacedByChart());
            showProspectsGraphs(graphsDto);
        });
    }

    protected void showProspectsGraphs(JSONObject graphsDto) {
        drawPetetionForChart(graphsDto);
        drawEmployeeTypeChart(graphsDto);
        drawPlacedByChart(graphsDto);
    }

    /**
     * EmployeeType for chart
     */
    protected void drawPlacedByChart(JSONObject graphsDto) {
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "PlacedBy");
        dataTable.addColumn(ColumnType.NUMBER, "Number");
        dataTable.addRows(3);
        dataTable.setValue(0, 0, PlacedBy.By_Recruiter.name());
        dataTable.setValue(1, 0, PlacedBy.Corporate_Solutions_Team.name());
        dataTable.setValue(2, 0, PlacedBy.Own_Placement.name());
        dataTable.setValue(0, 1, Integer.valueOf(graphsDto.get(PlacedBy.By_Recruiter.name()).isNumber().toString()));
        dataTable.setValue(1, 1, Integer.valueOf(graphsDto.get(PlacedBy.Corporate_Solutions_Team.name()).isNumber().toString()));
        dataTable.setValue(2, 1, Integer.valueOf(graphsDto.get(PlacedBy.Own_Placement.name()).isNumber().toString()));
        // Draw the chart
        placedByChart.draw(dataTable);
    }
    private PieChart placedByChart;

    private Widget getPlacedByChart() {
        if (placedByChart == null) {
            placedByChart = new PieChart();
        }
        return placedByChart;
    }

    /**
     * EmployeeType for chart
     */
    protected void drawEmployeeTypeChart(JSONObject graphsDto) {
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "EmployeeType");
        dataTable.addColumn(ColumnType.NUMBER, "Number");
        dataTable.addRows(2);
        dataTable.setValue(0, 0, TransferEmployeeType.Corporate_Employee.name());
        dataTable.setValue(1, 0, TransferEmployeeType.Field_Employee.name());
        dataTable.setValue(0, 1, Integer.valueOf(graphsDto.get(TransferEmployeeType.Corporate_Employee.name()).isNumber().toString()));
        dataTable.setValue(1, 1, Integer.valueOf(graphsDto.get(TransferEmployeeType.Field_Employee.name()).isNumber().toString()));
        // Draw the chart
        employeeTypeChart.draw(dataTable);
    }
    private PieChart employeeTypeChart;

    private Widget getEmployeerChart() {
        if (employeeTypeChart == null) {
            employeeTypeChart = new PieChart();
        }
        return employeeTypeChart;
    }

    /**
     * Petetion for chart
     */
    protected void drawPetetionForChart(JSONObject graphsDto) {
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "PetitionFor");
        dataTable.addColumn(ColumnType.NUMBER, "Number");
        dataTable.addRows(2);
        dataTable.setValue(0, 0, PetitionFor.Client_Project.name());
        dataTable.setValue(1, 0, PetitionFor.In_House.name());
        dataTable.setValue(0, 1, Integer.valueOf(graphsDto.get(PetitionFor.Client_Project.name()).isNumber().toString()));
        dataTable.setValue(1, 1, Integer.valueOf(graphsDto.get(PetitionFor.In_House.name()).isNumber().toString()));
        // Draw the chart
        petetionForChart.draw(dataTable);
    }
    private PieChart petetionForChart;

    private Widget getPetetionForChart() {
        if (petetionForChart == null) {
            petetionForChart = new PieChart();
        }
        return petetionForChart;
    }
}
