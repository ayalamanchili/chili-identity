/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.common.base.Strings;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ProspectsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ProspectsSidePanel.class.getName());
    public FlowPanel sidepanel = new FlowPanel();
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "assignedTo", "Employee", false, false);
    SuggestBox caseManagerSB = new SuggestBox(OfficeWelcome.constants, "caseManager", "Employee", false, false);
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, false);
    Button reportB = new Button("Reports");
    Button graphsB = new Button("Graphs");
    EnumField statusF = new EnumField(OfficeWelcome.constants2, "status", "Prospect", false, false, ProspectStatus.names(), Alignment.VERTICAL);
    DateField startDateF = new DateField(OfficeWelcome.constants, "joiningDateFrom", "Prospect", false, false, Alignment.VERTICAL);
    DateField endDateF = new DateField(OfficeWelcome.constants, "joiningDateTo", "Prospect", false, false, Alignment.VERTICAL);
    DateField createDateFromF = new DateField(OfficeWelcome.constants, "createdDateFrom", "Prospect", false, false, Alignment.VERTICAL);
    DateField createDateToF = new DateField(OfficeWelcome.constants, "createdDateTo", "Prospect", false, false, Alignment.VERTICAL);
    ClickableLink stageProgressL = new ClickableLink("Stage Progress Report");

    public ProspectsSidePanel() {
        init(sidepanel);
    }

    @Override
    protected void addListeners() {
        reportB.addClickHandler(this);
        graphsB.addClickHandler(this);
        stageProgressL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        employeeSB.getLabel().getElement().getStyle().setWidth(193, Style.Unit.PX);
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                    caseManagerSB.loadData(values);
                }
            }
        });
    }

    private String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_CORPORATE_EMPLOYEE + "/0/10000";
    }

    @Override
    protected void addWidgets() {
        sidepanel.add(new SearchProspectsPanel());
        sidepanel.add(Utils.getLineSeperatorTag("Reports and Graphs"));
        sidepanel.add(statusF);
        sidepanel.add(employeeSB);
        sidepanel.add(caseManagerSB);
        sidepanel.add(selectCompanyWidget);
        sidepanel.add(createDateFromF);
        sidepanel.add(createDateToF);
        sidepanel.add(startDateF);
        sidepanel.add(endDateF);
        sidepanel.add(reportB);
        sidepanel.add(graphsB);
        sidepanel.add(stageProgressL);
    }

    public JSONObject getObject() {
        JSONObject obj = new JSONObject();
        if ((statusF.getValue() == null) && (startDateF.getDate() == null) && (endDateF.getDate() == null) && (employeeSB.getValue() == null) && (caseManagerSB.getValue() == null) && (selectCompanyWidget.getSelectedObject() == null)) {
            statusF.setMessage("Required");
            startDateF.clearMessage();
            endDateF.clearMessage();
        } else if (startDateF.getDate() != null && endDateF.getDate() == null) {
            endDateF.setMessage("Required");
            statusF.clearMessage();
        } else if (endDateF.getDate() != null && startDateF.getDate() == null) {
            startDateF.setMessage("Required");
            statusF.clearMessage();
        }
        if (statusF.getValue() != null) {
            obj.put("status", new JSONString(statusF.getValue()));
        }
        if (startDateF.getDate() != null) {
            obj.put("joiningDateFrom", new JSONString(DateUtils.toDateString(startDateF.getDate())));
        }
        if (endDateF.getDate() != null) {
            obj.put("joiningDateTo", new JSONString(DateUtils.toDateString(endDateF.getDate())));
        }
        if (createDateFromF.getDate() != null) {
            obj.put("createdDateFrom", new JSONString(DateUtils.toDateString(createDateFromF.getDate())));
        }
        if (createDateToF.getDate() != null) {
            obj.put("createdDateTo", new JSONString(DateUtils.toDateString(createDateToF.getDate())));
        }
        if (employeeSB != null && !Strings.isNullOrEmpty(employeeSB.getValue())) {
            obj.put("assignedTo", employeeSB.getSelectedObject().get("id").isString());
        }
        if (caseManagerSB != null && !Strings.isNullOrEmpty(caseManagerSB.getValue())) {
            obj.put("caseManager", caseManagerSB.getSelectedObject().get("id").isString());
        }
        if (selectCompanyWidget.getSelectedObject() != null && !Strings.isNullOrEmpty(selectCompanyWidget.getSelectedObject().get("id").isString().stringValue())) {
            obj.put("company", new JSONString(selectCompanyWidget.getSelectedObject().get("value").isString().stringValue()));
        }
        return obj;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(reportB)) {
            JSONObject obj = getObject();
            if ((obj.containsKey("status") == true) || (obj.containsKey("joiningDateFrom") == true && obj.containsKey("joiningDateTo") == true) || 
                    (obj.containsKey("assignedTo") == true) || obj.containsKey("caseManager") == true || obj.containsKey("company") == true ||
                    (obj.containsKey("createdDateFrom") == true && obj.containsKey("createdDateTo") == true)) {
                String reportUrl = OfficeWelcome.instance().constants.root_url() + "prospect/report";
                HttpService.HttpServiceAsync.instance().doPut(reportUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String result) {
                                boolean isClosedWon = false;
                                if ((obj.containsKey("status") == true && obj.get("status").isString().stringValue().equals(ProspectStatus.CLOSED_WON.name())) || (obj.containsKey("joiningDateFrom")) || (obj.containsKey("joiningDateFrom"))) {
                                    isClosedWon = true;
                                }
                                new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                String key = (String) resObj.keySet().toArray()[0];
                                JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                TabPanel.instance().myOfficePanel.entityPanel.clear();
                                TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsReportPanel(results, isClosedWon));
                            }
                        });
                statusF.clearMessage();
                startDateF.clearMessage();
                endDateF.clearMessage();
                caseManagerSB.clearMessage();
                employeeSB.clearMessage();
            }
        }
        if (event.getSource().equals(graphsB)) {
            JSONObject obj = getObject();
            if (obj.containsKey("status") || (obj.containsKey("createdDateFrom") == true && obj.containsKey("createdDateTo") == true)) {
                String graphUrl = OfficeWelcome.instance().constants.root_url() + "prospect/graph";
                HttpService.HttpServiceAsync.instance().doPut(graphUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String result) {
                                logger.info(result);
                                JSONObject graphObj = JSONParser.parseLenient(result).isObject();
                                GenericPopup popup = new GenericPopup(new ProspectsGraphsPanel(graphObj));
                                popup.setPixelSize(600, 900);
                                popup.show();
                            }
                        });
            }
        }
        if (event.getSource().equals(stageProgressL)) {
            HttpService.HttpServiceAsync.instance().doGet(getStageProgressReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            logger.info(result);
                            new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                        }
                    });
        }
    }

    private String getStageProgressReportUrl() {
        return OfficeWelcome.constants.root_url() + "prospect/stageProgressReport";
    }
}
