/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.charts.client.ChartLoader;
import com.googlecode.gwt.charts.client.ChartPackage;
import com.googlecode.gwt.charts.client.ColumnType;
import com.googlecode.gwt.charts.client.DataTable;
import com.googlecode.gwt.charts.client.corechart.PieChart;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author phani
 */
//TODO try to make a generic chart
public class ProspectsGraphsPanel extends Composite {

    protected FlowPanel panel = new FlowPanel();
    protected Label petitionForL = new Label("Petition For Chart");
    protected Label employeerL = new Label("Transfer Employee Chart");
    protected Label placedByL = new Label("Placed By Chart");
    protected Label noOfReqReceivedL = new Label("No Of Requests Received");

    public ProspectsGraphsPanel(JSONObject graphDto) {
        initWidget(panel);
        displayCharts(graphDto);
    }

    protected void displayCharts(final JSONObject graphsDto) {
        ChartLoader chartLoader = new ChartLoader(ChartPackage.CORECHART);
        chartLoader.loadApi(() -> {
            panel.add(noOfReqReceivedL);
            panel.add(getReqReceivedChart());
            if (graphsDto.containsKey("PetitionUnknown")) {
                panel.add(petitionForL);
                panel.add(getPetetionForChart());
                panel.add(employeerL);
                panel.add(getEmployeerChart());
                panel.add(placedByL);
                panel.add(getPlacedByChart());
            }
            showProspectsGraphs(graphsDto);
        });
    }

    protected void showProspectsGraphs(JSONObject graphsDto) {
        if (graphsDto.containsKey("PetitionUnknown")) {
            drawPetetionForChart(graphsDto);
            drawEmployeeTypeChart(graphsDto);
            drawPlacedByChart(graphsDto);
        }
        drawNoOfReqChart(graphsDto);
    }

    /**
     * EmployeeType for chart
     */
    protected void drawPlacedByChart(JSONObject graphsDto) {
        double number = 0;
        if (graphsDto.containsKey("PlacedByUnknown") == true) {
            number = graphsDto.get(PlacedBy.By_Recruiter.name()).isNumber().doubleValue() + graphsDto.get(PlacedBy.Corporate_Solutions_Team.name()).isNumber().doubleValue() + graphsDto.get(PlacedBy.Own_Placement.name()).isNumber().doubleValue() + graphsDto.get("PlacedByUnknown").isNumber().doubleValue();
        } else {
            number = graphsDto.get(PlacedBy.By_Recruiter.name()).isNumber().doubleValue() + graphsDto.get(PlacedBy.Corporate_Solutions_Team.name()).isNumber().doubleValue() + graphsDto.get(PlacedBy.Own_Placement.name()).isNumber().doubleValue();
        }
        placedByL.setText("Placed By Chart : (" + number + ")");
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "PlacedBy");
        dataTable.addColumn(ColumnType.NUMBER, "Number");
        dataTable.addRows(4);
        dataTable.setValue(0, 0, PlacedBy.By_Recruiter.name() + "(" + Integer.valueOf(graphsDto.get(PlacedBy.By_Recruiter.name()).isNumber().toString()) + ")");
        dataTable.setValue(1, 0, PlacedBy.Corporate_Solutions_Team.name() + "(" + Integer.valueOf(graphsDto.get(PlacedBy.Corporate_Solutions_Team.name()).isNumber().toString()) + ")");
        dataTable.setValue(2, 0, PlacedBy.Own_Placement.name() + "(" + Integer.valueOf(graphsDto.get(PlacedBy.Own_Placement.name()).isNumber().toString()) + ")");
        dataTable.setValue(3, 0, "Unknown" + "(" + Integer.valueOf(graphsDto.get("PlacedByUnknown").isNumber().toString()) + ")");
        dataTable.setValue(0, 1, Integer.valueOf(graphsDto.get(PlacedBy.By_Recruiter.name()).isNumber().toString()));
        dataTable.setValue(1, 1, Integer.valueOf(graphsDto.get(PlacedBy.Corporate_Solutions_Team.name()).isNumber().toString()));
        dataTable.setValue(2, 1, Integer.valueOf(graphsDto.get(PlacedBy.Own_Placement.name()).isNumber().toString()));
        dataTable.setValue(3, 1, Integer.valueOf(graphsDto.get("PlacedByUnknown").isNumber().toString()));

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
        double number = 0;
        if (graphsDto.containsKey("TrfEmpUnknown") == true) {
            number = graphsDto.get(TransferEmployeeType.Corporate_Employee.name()).isNumber().doubleValue() + graphsDto.get(TransferEmployeeType.Field_Employee.name()).isNumber().doubleValue() + graphsDto.get("TrfEmpUnknown").isNumber().doubleValue();
        } else {
            number = graphsDto.get(TransferEmployeeType.Corporate_Employee.name()).isNumber().doubleValue() + graphsDto.get(TransferEmployeeType.Field_Employee.name()).isNumber().doubleValue();
        }
        employeerL.setText("Transfer Employee Chart : (" + number + ")");
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "EmployeeType");
        dataTable.addColumn(ColumnType.NUMBER, "Number");
        dataTable.addRows(3);
        dataTable.setValue(0, 0, TransferEmployeeType.Corporate_Employee.name() + "(" + Integer.valueOf(graphsDto.get(TransferEmployeeType.Corporate_Employee.name()).isNumber().toString()) + ")");
        dataTable.setValue(1, 0, TransferEmployeeType.Field_Employee.name() + "(" + Integer.valueOf(graphsDto.get(TransferEmployeeType.Field_Employee.name()).isNumber().toString()) + ")");
        dataTable.setValue(2, 0, "Unknown" + "(" + Integer.valueOf(graphsDto.get("TrfEmpUnknown").isNumber().toString()) + ")");
        dataTable.setValue(0, 1, Integer.valueOf(graphsDto.get(TransferEmployeeType.Corporate_Employee.name()).isNumber().toString()));
        dataTable.setValue(1, 1, Integer.valueOf(graphsDto.get(TransferEmployeeType.Field_Employee.name()).isNumber().toString()));
        dataTable.setValue(2, 1, Integer.valueOf(graphsDto.get("TrfEmpUnknown").isNumber().toString()));
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
        double number = 0;
        if (graphsDto.containsKey("PetitionUnknown") == true) {
            OfficeWelcome.logger.info("petition chart");
            number = graphsDto.get(PetitionFor.Client_Project.name()).isNumber().doubleValue() + graphsDto.get(PetitionFor.In_House.name()).isNumber().doubleValue() + graphsDto.get("PetitionUnknown").isNumber().doubleValue();
        } else {
            number = graphsDto.get(PetitionFor.Client_Project.name()).isNumber().doubleValue() + graphsDto.get(PetitionFor.In_House.name()).isNumber().doubleValue();
        }
        petitionForL.setText("Petition For Chart : (" + number + ")");
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "PetitionFor");
        dataTable.addColumn(ColumnType.NUMBER, "Number");
        dataTable.addRows(3);
        dataTable.setValue(0, 0, PetitionFor.Client_Project.name() + "(" + Integer.valueOf(graphsDto.get(PetitionFor.Client_Project.name()).isNumber().toString()) + ")");
        dataTable.setValue(1, 0, PetitionFor.In_House.name() + "(" + Integer.valueOf(graphsDto.get(PetitionFor.In_House.name()).isNumber().toString()) + ")");
        dataTable.setValue(2, 0, "Unknown" + "(" + Integer.valueOf(graphsDto.get("PetitionUnknown").isNumber().toString()) + ")");
        dataTable.setValue(0, 1, Integer.valueOf(graphsDto.get(PetitionFor.Client_Project.name()).isNumber().toString()));
        dataTable.setValue(1, 1, Integer.valueOf(graphsDto.get(PetitionFor.In_House.name()).isNumber().toString()));
        dataTable.setValue(2, 1, Integer.valueOf(graphsDto.get("PetitionUnknown").isNumber().toString()));
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

    /**
     * No Of Req Received Chart
     */
    protected void drawNoOfReqChart(JSONObject graphsDto) {
        double number = graphsDto.get(ProspectStatus.IN_PROGRESS.name()).isNumber().doubleValue() + graphsDto.get(ProspectStatus.RECRUITING.name()).isNumber().doubleValue() + graphsDto.get(ProspectStatus.BENCH.name()).isNumber().doubleValue() + graphsDto.get(ProspectStatus.ONHOLD.name()).isNumber().doubleValue() + graphsDto.get(ProspectStatus.CLOSED_WON.name()).isNumber().doubleValue() + graphsDto.get(ProspectStatus.CLOSED_LOST.name()).isNumber().doubleValue();
        noOfReqReceivedL.setText("No Of Req. Received : (" + number + ")");
        DataTable dataTable = DataTable.create();
        dataTable.addColumn(ColumnType.STRING, "NoOfReqReceived");
        dataTable.addColumn(ColumnType.NUMBER, "Number");
        dataTable.addRows(6);
        dataTable.setValue(0, 0, ProspectStatus.IN_PROGRESS.name() + "(" + Integer.valueOf(graphsDto.get(ProspectStatus.IN_PROGRESS.name()).isNumber().toString()) + ")");
        dataTable.setValue(1, 0, ProspectStatus.RECRUITING.name() + "(" + Integer.valueOf(graphsDto.get(ProspectStatus.RECRUITING.name()).isNumber().toString()) + ")");
        dataTable.setValue(2, 0, ProspectStatus.BENCH.name() + "(" + Integer.valueOf(graphsDto.get(ProspectStatus.BENCH.name()).isNumber().toString()) + ")");
        dataTable.setValue(3, 0, ProspectStatus.ONHOLD.name() + "(" + Integer.valueOf(graphsDto.get(ProspectStatus.ONHOLD.name()).isNumber().toString()) + ")");
        dataTable.setValue(4, 0, ProspectStatus.CLOSED_WON.name() + "(" + Integer.valueOf(graphsDto.get(ProspectStatus.CLOSED_WON.name()).isNumber().toString()) + ")");
        dataTable.setValue(5, 0, ProspectStatus.CLOSED_LOST.name() + "(" + Integer.valueOf(graphsDto.get(ProspectStatus.CLOSED_LOST.name()).isNumber().toString()) + ")");

        dataTable.setValue(0, 1, Integer.valueOf(graphsDto.get(ProspectStatus.IN_PROGRESS.name()).isNumber().toString()));
        dataTable.setValue(1, 1, Integer.valueOf(graphsDto.get(ProspectStatus.RECRUITING.name()).isNumber().toString()));
        dataTable.setValue(2, 1, Integer.valueOf(graphsDto.get(ProspectStatus.BENCH.name()).isNumber().toString()));
        dataTable.setValue(3, 1, Integer.valueOf(graphsDto.get(ProspectStatus.ONHOLD.name()).isNumber().toString()));
        dataTable.setValue(4, 1, Integer.valueOf(graphsDto.get(ProspectStatus.CLOSED_WON.name()).isNumber().toString()));
        dataTable.setValue(5, 1, Integer.valueOf(graphsDto.get(ProspectStatus.CLOSED_LOST.name()).isNumber().toString()));

        // Draw the chart
        noOfReqChart.draw(dataTable);
    }
    private PieChart noOfReqChart;

    private Widget getReqReceivedChart() {
        if (noOfReqChart == null) {
            noOfReqChart = new PieChart();
        }
        return noOfReqChart;
    }
}
