/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CorporateStatusReportSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CorporateStatusReportSidePanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected CaptionPanel mainPanel = new CaptionPanel();
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false);
    SelectTimePeriodWidget statusReportPeriodF = new SelectTimePeriodWidget(false, true);
    EnumField statusF = new EnumField(OfficeWelcome.constants, "status", "CorporateStatusReport",
            false, false, CropStatusReportStatus.names(), Alignment.VERTICAL);
    Button searchB = new Button("Search");
    ClickableLink reminderB = new ClickableLink("Send Reminder");

    public CorporateStatusReportSidePanel() {
        init(mainPanel);
    }

    @Override
    protected void addListeners() {
        searchB.addClickHandler(this);
        reminderB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        mainPanel.setCaptionHTML("StatusReports");
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    private String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee";
    }

    @Override
    protected void addWidgets() {
        mainPanel.setContentWidget(panel);
        panel.add(employeeSB);
        panel.add(statusReportPeriodF);
        panel.add(statusF);
        panel.add(searchB);
        panel.add(new HTML("<hr>"));
        panel.add(reminderB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(searchB)) {
            search();
        }
        if (event.getSource().equals(reminderB)) {
            sendRemainder();
        }
    }

    protected JSONObject populateEntity() {
        JSONObject entity = new JSONObject();
        if (employeeSB.getSelectedObject() != null) {
            entity.put("employee", employeeSB.getSelectedObject());
        }
        if (statusReportPeriodF.getSelectedObject() != null) {
            entity.put("statusReportPeriod", statusReportPeriodF.getSelectedObject());
        }
        if (statusF.getValue() != null) {
            entity.put("status", new JSONString(statusF.getValue()));
        }
        return entity;
    }

    protected void sendRemainder() {
        HttpService.HttpServiceAsync.instance().doPut(sendRemainderUrl(), populateEntity().toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Remainder Email Sent");
            }
        });
    }

    protected void search() {
        HttpService.HttpServiceAsync.instance().doPut(searchReportsUrl(), populateEntity().toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                clear();
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                    new ResponseStatusWidget().show("no results");
                } else {
                    //TODO use size and entities attributes
                    JSONObject resObj = JSONParser.parseLenient(result).isObject();
                    String key = (String) resObj.keySet().toArray()[0];
                    JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                    TabPanel.instance().getReportingPanel().entityPanel.add(new ReadAllCorporateStatusReportsPanel("Status Report Results", results));
                }
            }
        });
    }

    protected void clear() {

    }

    protected String searchReportsUrl() {
        return OfficeWelcome.instance().constants.root_url() + "corporate-statusreport/search";
    }

    protected String sendRemainderUrl() {
        return OfficeWelcome.instance().constants.root_url() + "corporate-statusreport/not-submitted-reminder";
    }
}
