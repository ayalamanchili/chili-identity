/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class EmployeeTimeSummaryPanel extends ALComposite {

    private static Logger logger = Logger.getLogger(EmployeeTimeSummaryPanel.class.getName());
    protected String employeeId;
    protected CaptionPanel summaryCP = new CaptionPanel("Time Summary");
    protected FlowPanel summaryPanel = new FlowPanel();
    protected Label adpHoursL = new Label("ADP Hours");
    protected TextBox adpHoursTB = new TextBox();
    protected Label qbHoursL = new Label("QuickBooks Hours");
    protected TextBox qbHoursTB = new TextBox();

    public EmployeeTimeSummaryPanel() {
        init(summaryCP);
        fetchData();
    }

    public EmployeeTimeSummaryPanel(String employeeId) {
        this.employeeId = employeeId;
        init(summaryCP);
        fetchData();
    }

    public void fetchData() {
        HttpService.HttpServiceAsync.instance().doGet(getURL(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        if (result != null && !result.isEmpty()) {
                            JSONObject summary = JSONParser.parseLenient(result).isObject();
                            adpHoursTB.setText(JSONUtils.toString(summary, "adpHours"));
                            qbHoursTB.setText(JSONUtils.toString(summary, "quickBooksHours"));
                        }
                    }
                });
    }

    protected String getURL() {
        if (employeeId != null) {
            return OfficeWelcome.constants.root_url() + "timesheet/summary/" + employeeId;
        } else {
            return OfficeWelcome.constants.root_url() + "timesheet/summary/currentuser";
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        summaryPanel.add(adpHoursL);
        summaryPanel.add(adpHoursTB);
        summaryPanel.add(qbHoursL);
        summaryPanel.add(qbHoursTB);
        summaryCP.setContentWidget(summaryPanel);
    }
}
