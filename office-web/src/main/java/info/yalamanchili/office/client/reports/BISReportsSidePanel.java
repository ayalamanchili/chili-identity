/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.common.base.Strings;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.project.SelectProjectWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.contracts.ClientInformationStatus;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;
import info.yalamanchili.office.client.profile.cllientinfo.ClientInformationCompany;
import info.yalamanchili.office.client.profile.cllientinfo.ConsultingServices;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class BISReportsSidePanel extends ALComposite implements ClickHandler, OpenHandler {

    SuggestBox employeeSbf = new SuggestBox(OfficeWelcome.constants, "firstName", "Employee", false, false);
    SuggestBox employeeSbl = new SuggestBox(OfficeWelcome.constants, "lastName", "Employee", false, false);
    
    MultiWordSuggestOracle data = new MultiWordSuggestOracle();
    
    protected SelectCompanyWidget selectCompnayWidget = new SelectCompanyWidget(false, false);
    protected SelectVendorWidget selectVendorWidget = new SelectVendorWidget(false, false);
    protected SelectClientWidget selectClientWidget = new SelectClientWidget(false, false);
    protected SelectSubcontractorWidget selectSubWidget = new SelectSubcontractorWidget(false, false);
    protected SelectProjectWidget selectProjectWidget = new SelectProjectWidget(false, false);
    protected SelectPracticeWidget selectPracticeWidget = new SelectPracticeWidget(false, false);
    
    protected DisclosurePanel masterDataReportsL = new DisclosurePanel("Consultants Master Data");
    protected DisclosurePanel myVendorL = new DisclosurePanel("Working Under Vendor");
    protected DisclosurePanel myClientL = new DisclosurePanel("Working Under Client");
    protected DisclosurePanel mySubContructorL = new DisclosurePanel("SubContractor Report");
    protected DisclosurePanel multipleProjectsL = new DisclosurePanel("Working On Multiple Projects");
    protected DisclosurePanel myJoinedL = new DisclosurePanel("Joined/Left in a Period");
    protected DisclosurePanel recruiterL = new DisclosurePanel("Employee Recruited By");
    protected DisclosurePanel myVlocationL = new DisclosurePanel("Vendors in a Location");
    protected DisclosurePanel myClocationL = new DisclosurePanel("Clients in a Location");
    protected DisclosurePanel mySlocationL = new DisclosurePanel("Subcontractors in a Location");
    protected DisclosurePanel empLocationL = new DisclosurePanel("Emp Working in a Location");
    protected DisclosurePanel serviceTypeL = new DisclosurePanel("Service Type Report");
    protected DisclosurePanel projEndL = new DisclosurePanel("Emp Projects Going To Start / End");
    protected ClickableLink activeCPDL = new ClickableLink("Employees Project Forecast Report");
    protected ClickableLink allProjectsForecastReport = new ClickableLink("All Projects Forecast Report");
    
    ClickableLink clearReportsL = new ClickableLink("clear");
    protected Button searchTasks = new Button("Search");
    protected Button reportTasks = new Button("Report");
    protected Button graphB = new Button("Graph");
    FlowPanel panel = new FlowPanel();
    
    FlowPanel masterDataPanel = new FlowPanel();
    FlowPanel clientPanel = new FlowPanel();
    FlowPanel vendorPanel = new FlowPanel();
    FlowPanel subContractorPanel = new FlowPanel();
    FlowPanel mProjectsPanel = new FlowPanel();
    FlowPanel recruiterPanel = new FlowPanel();
    FlowPanel joinedPanel = new FlowPanel();
    FlowPanel vLocationPanel = new FlowPanel();
    FlowPanel cLocationPanel = new FlowPanel();
    FlowPanel sLocationPanel = new FlowPanel();
    FlowPanel empLocPanel = new FlowPanel();
    FlowPanel servTypePanel = new FlowPanel();
    FlowPanel projEndPanel = new FlowPanel();
    
    HorizontalPanel hPanel = new HorizontalPanel();
    
    SelectEmployeeWithRoleWidget selectRecruiterW = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER, false, false);
    StringField employeeFirstNameField = new StringField(OfficeWelcome.constants, "employeeFirstName", "Contract", false, false);
    StringField employeeLatNameField = new StringField(OfficeWelcome.constants, "employeeLastName", "Contract", false, false);
    StringField itemNumberField = new StringField(OfficeWelcome.constants, "itemNumber", "Contract", false, false);
    String[] employeeTypeStrs = {"Corporate Employee", "Employee", "Subcontractor", "1099 Contractor", "W2 Contractor", "Intern-Seasonal Employee"};
    EnumField employeeTypeField = new EnumField(OfficeWelcome.constants, "employeeType", "Contract", false, false, employeeTypeStrs);
    EnumField projectStatusField = new EnumField(OfficeWelcome.constants, "status", "Contract", false, false, ClientInformationStatus.names());
    DateField projectStartDate = new DateField(OfficeWelcome.constants, "FromDate", "", false, false);
    DateField projectEndDate = new DateField(OfficeWelcome.constants, "ToDate", "", false, false);
    StringField cityField = new StringField(OfficeWelcome.constants, "city", "Contract", false, false);
    EnumField stateFeild = new EnumField(OfficeWelcome.constants, "state", "Contract", false, false, USAStatesFactory.getStates().toArray(new String[0]));
    EnumField companyField = new EnumField(OfficeWelcome.constants, "company", "Contract", false, false, ClientInformationCompany.names());
    EnumField invoiceField = new EnumField(OfficeWelcome.constants, "invoiceFrequency", "Contract", false, false, InvoiceFrequency.names());
    EnumField sectorField = new EnumField(OfficeWelcome.constants, "sectorsAndBUs", "Contract", false, false, ConsultingServices.getSectorsAndBusinessUnits().toArray(new String[0]));
    StringField vendorField = new StringField(OfficeWelcome.constants, "vendor", "Contract", false, false);
    ListBox li = new ListBox();
    ListBox projectEndLi = new ListBox();
    Label label = new Label(" Based");
    
    private static Logger logger = Logger.getLogger(BISReportsSidePanel.class.getName());
    
    public BISReportsSidePanel() {
        init(panel);
    }
    
    @Override
    protected void addListeners() {
        masterDataReportsL.addOpenHandler(this);
        myClientL.addOpenHandler(this);
        myVendorL.addOpenHandler(this);
        mySubContructorL.addOpenHandler(this);
        multipleProjectsL.addOpenHandler(this);
        myJoinedL.addOpenHandler(this);
        myVlocationL.addOpenHandler(this);
        myClocationL.addOpenHandler(this);
        mySlocationL.addOpenHandler(this);
        empLocationL.addOpenHandler(this);
        serviceTypeL.addOpenHandler(this);
        projEndL.addOpenHandler(this);
        recruiterL.addOpenHandler(this);
        searchTasks.addClickHandler(this);
        reportTasks.addClickHandler(this);
        graphB.addClickHandler(this);
        activeCPDL.addClickHandler(this);
        allProjectsForecastReport.addClickHandler(this);
    }
    
    @Override
    protected void configure() {
        li.addItem("Joined", "joined");
        li.addItem("Left", "left");
        projectEndLi.addItem("EndDate", "enddate");
        projectEndLi.addItem("StartDate", "startdate");
        HttpService.HttpServiceAsync.instance().doGet(getFirstNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                employeeSbf.loadData(values.values());
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getLastNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                employeeSbl.loadData(values.values());
            }
        });
    }
    
    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
            panel.add(masterDataReportsL);
            panel.add(myClientL);
            panel.add(myVendorL);
            panel.add(mySubContructorL);
            panel.add(recruiterL);
            panel.add(multipleProjectsL);
            panel.add(myJoinedL);
            panel.add(projEndL);
            panel.add(myVlocationL);
            panel.add(myClocationL);
            panel.add(mySlocationL);
            panel.add(empLocationL);
            panel.add(serviceTypeL);
            panel.add(activeCPDL);
            panel.add(allProjectsForecastReport);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_RECRUITER)) {
            panel.add(myClientL);
            panel.add(myVendorL);
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_BILLING_ADMIN)) {
            panel.add(projEndL);
            
        }
    }
    
    protected String getFirstNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=firstName";
    }
    
    protected String getLastNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=lastName";
    }
    
    public void loadSearchSuggestions(Collection<String> inputs) {
        data.addAll(inputs);
    }
    
    protected String getDropDownURL(Integer start, Integer limit, JSONObject entity) {
        return OfficeWelcome.constants.root_url() + "client/locations/dropdown/" + entity.get("id").toString().substring(1, 2) + "/" + start + "/" + limit;
    }
    
    @Override
    public void onClick(ClickEvent event) {
        String url = OfficeWelcome.constants.root_url() + "contract/search/0/10000";
        JSONObject entity = new JSONObject();
        if (employeeSbf != null && !Strings.isNullOrEmpty(employeeSbf.getValue())) {
            entity.put("employeeFirstName", new JSONString(employeeSbf.getValue()));
            url = url.concat("?employeeFirstName=" + employeeSbf.getValue());
        }
        if (employeeSbl != null && !Strings.isNullOrEmpty(employeeSbl.getValue())) {
            entity.put("employeeLastName", new JSONString(employeeSbl.getValue()));
            url = url.concat("?employeeLastName=" + employeeSbl.getValue());
        }
        if (itemNumberField != null && !Strings.isNullOrEmpty(itemNumberField.getValue())) {
            entity.put("itemNumber", new JSONString(itemNumberField.getValue()));
            url = url.concat("?itemNumber=" + itemNumberField.getValue());
        }
        if (employeeTypeField != null && !Strings.isNullOrEmpty(employeeTypeField.getValue())) {
            entity.put("employeeType", new JSONString(employeeTypeField.getValue()));
            url = url.concat("?employeeType=" + employeeTypeField.getValue());
        }
        if (projectStatusField != null && !Strings.isNullOrEmpty(projectStatusField.getValue())) {
            entity.put("status", new JSONString(projectStatusField.getValue()));
            url = url.concat("?status=" + projectStatusField.getValue());
        }
        if (selectVendorWidget != null && !Strings.isNullOrEmpty(selectVendorWidget.getSelectedObjectId())) {
            entity.put("vendor", new JSONString(selectVendorWidget.getSelectedObject().get("value").isString().stringValue()));
            url = url.concat("?vendor=" + selectVendorWidget.getSelectedObject().get("value").isString().stringValue());
        }
        if (companyField != null && !Strings.isNullOrEmpty(companyField.getValue())) {
            entity.put("company", new JSONString(companyField.getValue()));
            url = url.concat("?company=" + companyField.getValue());
        }
        if (invoiceField != null && !Strings.isNullOrEmpty(invoiceField.getValue())) {
            entity.put("invoiceFrequency", new JSONString(invoiceField.getValue()));
            url = url.concat("?invoiceFrequency=" + invoiceField.getValue());
        }
        if (selectPracticeWidget != null && !Strings.isNullOrEmpty(selectPracticeWidget.getSelectedObjectId())) {
            entity.put("practice", new JSONString(selectPracticeWidget.getSelectedObject().get("value").isString().stringValue()));
            url = url.concat("?practice=" + selectPracticeWidget.getSelectedObject().get("value").isString().stringValue());
        }
        if (event.getSource().equals(searchTasks)) {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            if (searchTasks.getParent().equals(masterDataPanel)) {
                if (entity.size() != 0) {
                    HttpService.HttpServiceAsync.instance().doPut(url, entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || JSONParser.parseLenient(result).isObject().size() == 0) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        //TODO use size and entities attributes
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllBisContractsPanel(results));
                                    }
                                }
                            });
                    clearFields();
                } else {
                    employeeSbf.setMessage("Required");
                }
            }
            
            if (searchTasks.getParent().equals(clientPanel)) {
                JSONObject obj = getClientObject();
                if (obj.containsKey("client")) {
                    url = url.concat("?client=" + selectClientWidget.getSelectedObject().get("value").isString().stringValue());
                    HttpService.HttpServiceAsync.instance().doPut(url, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        //TODO use size and entities attributes
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllClientReportPanel(results));
                                    }
                                }
                            });
                    clearFields();
                }
            }
            
            if (searchTasks.getParent().equals(vendorPanel)) {
                JSONObject obj = getVendorObject();
                if (obj.containsKey("vendor")) {
                    url = url.concat("?vendor=" + selectVendorWidget.getSelectedObject().get("value").isString().stringValue());
                    HttpService.HttpServiceAsync.instance().doPut(url, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        //TODO use size and entities attributes
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllVendorReportPanel(results));
                                    }
                                }
                            });
                    clearFields();
                }
            }
            if (searchTasks.getParent().equals(subContractorPanel)) {
               JSONObject obj = getSubContractorObject();
                if (obj.containsKey("subContractorName")) {
                    url = url.concat("?subContractorName=" + selectSubWidget.getSelectedObject().get("value").isString().stringValue());
                    HttpService.HttpServiceAsync.instance().doPut(url, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        //TODO use size and entities attributes
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllSubContractorPanel(results));
                                    }
                                }
                            });
                    clearFields();
                }
            }
            if (searchTasks.getParent().equals(servTypePanel)) {
                JSONObject obj = getServiceObject();               
                if (obj.containsKey("practice")) {
                    HttpService.HttpServiceAsync.instance().doPut(url, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        //TODO use size and entities attributes
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllServiceReportPanel(results));
                                    }
                                }
                            });
                    clearFields();
                }
            }
            if (searchTasks.getParent().equals(mProjectsPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                String mpurl = OfficeWelcome.constants.root_url() + "contract-report/multiple-cpds";
                HttpService.HttpServiceAsync.instance().doPut(mpurl, entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String result) {
                                if (result == null || JSONParser.parseLenient(result).isObject() == null || result.contains("entities") == false) {
                                    new ResponseStatusWidget().show("No Results");
                                } else {
                                    //TODO use size and entities attributes
                                    JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                    String key = (String) resObj.keySet().toArray()[0];
                                    JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                    TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllMultiPleProjectsPanel(results));
                                }
                            }
                        });
                clearFields();
            }
            if (searchTasks.getParent().equals(recruiterPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject obj = getRecruiterObject();
                String recruiterUrl = OfficeWelcome.constants.root_url() + "contract/recruiterSearch";
                if ((obj.containsKey("recruiter") == true) || (obj.containsKey("recruitedDateFrom") == true && obj.containsKey("recruitedDateTo") == true)) {
                    HttpService.HttpServiceAsync.instance().doPut(recruiterUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || JSONParser.parseLenient(result).isObject().size() == 0) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        //TODO use size and entities attributes
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllRecruiterPanel(results));
                                    }
                                }
                            });
                    clearFields();
                }
            }
            if (searchTasks.getParent().equals(joinedPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject obj = getBWDatesObject();
                if (obj.containsKey("startDate") == true && obj.containsKey("endDate") == true) {
                    DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
                    String empUrl = OfficeWelcome.constants.root_url() + "contract-report/search-emp-between-days/0/1000";
                    empUrl = empUrl.concat("?startDate=" + sdf.format(projectStartDate.getDate()));
                    empUrl = empUrl.concat("&endDate=" + sdf.format(projectEndDate.getDate()));
                    obj.put("value", new JSONString(li.getSelectedValue()));
                    empUrl = empUrl.concat("&value=" + li.getSelectedValue());
                    HttpService.HttpServiceAsync.instance().doPut(empUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || "0".equals(JSONParser.parseLenient(result).isObject().get("size").isString().stringValue())) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllEmployeesJoinedPanel(results));
                                    }
                                }
                            });
                    clearFields();
                }
            }
            if (searchTasks.getParent().equals(projEndPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject obj = getBWDatesObject();
                if (obj.containsKey("startDate") == true && obj.containsKey("endDate") == true) {
                    DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
                    String empUrl1 = OfficeWelcome.constants.root_url() + "contract-report/search-projects-between-days/0/1000";
                    empUrl1 = empUrl1.concat("?startDate=" + sdf.format(projectStartDate.getDate()));
                    empUrl1 = empUrl1.concat("&endDate=" + sdf.format(projectEndDate.getDate()));
                    obj.put("value", new JSONString(projectEndLi.getSelectedValue()));
                    empUrl1 = empUrl1.concat("&value=" + projectEndLi.getSelectedValue());
                    if (employeeTypeField != null && !Strings.isNullOrEmpty(employeeTypeField.getValue())) {
                        empUrl1 = empUrl1.concat("&employeeType=" + employeeTypeField.getValue());
                    }
                    HttpService.HttpServiceAsync.instance().doPut(empUrl1, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || "0".equals(JSONParser.parseLenient(result).isObject().get("size").isString().stringValue())) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllEndProjectPanel(results));
                                    }
                                }
                            });
                    clearFields();
                }
            }
            if (searchTasks.getParent().equals(vLocationPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject vLovation = new JSONObject();
                String lurl = OfficeWelcome.constants.root_url() + "vendor/search-vendor1/0/1000";
                if (cityField != null && !Strings.isNullOrEmpty(cityField.getValue())) {
                    vLovation.put("city", new JSONString(cityField.getValue()));
                    lurl = lurl.concat("?city=" + cityField.getValue());
                }
                if (stateFeild != null && !Strings.isNullOrEmpty(stateFeild.getValue())) {
                    vLovation.put("state", new JSONString(stateFeild.getValue()));
                    lurl = lurl.concat("?state=" + stateFeild.getValue());
                }
                if (vLovation.size() != 0) {
                    HttpService.HttpServiceAsync.instance().doPut(lurl, vLovation.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        //TODO use size and entities attributes
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllVendorLocationPanel(results));
                                    }
                                }
                            });
                    clearFields();
                } else {
                    cityField.setMessage("Required");
                }
            }
            if (searchTasks.getParent().equals(cLocationPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject cLovation = new JSONObject();
                String lurl = OfficeWelcome.constants.root_url() + "client/search-client1/0/1000";
                if (cityField != null && !Strings.isNullOrEmpty(cityField.getValue())) {
                    cLovation.put("city", new JSONString(cityField.getValue()));
                    lurl = lurl.concat("?city=" + cityField.getValue());
                }
                if (stateFeild != null && !Strings.isNullOrEmpty(stateFeild.getValue())) {
                    cLovation.put("state", new JSONString(stateFeild.getValue()));
                    lurl = lurl.concat("?state=" + stateFeild.getValue());
                }
                if (cLovation.size() != 0) {
                    HttpService.HttpServiceAsync.instance().doPut(lurl, cLovation.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        //TODO use size and entities attributes
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllClientLocationPanel(results));
                                    }
                                }
                            });
                    clearFields();
                } else {
                    cityField.setMessage("Required");
                }
            }
            if (searchTasks.getParent().equals(sLocationPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject sLovation = new JSONObject();
                String lurl = OfficeWelcome.constants.root_url() + "subcontractor/search-subcontractor1/0/1000";
                if (cityField != null && !Strings.isNullOrEmpty(cityField.getValue())) {
                    sLovation.put("city", new JSONString(cityField.getValue()));
                    lurl = lurl.concat("?city=" + cityField.getValue());
                }
                if (stateFeild != null && !Strings.isNullOrEmpty(stateFeild.getValue())) {
                    sLovation.put("state", new JSONString(stateFeild.getValue()));
                    lurl = lurl.concat("?state=" + stateFeild.getValue());
                }
                if (sLovation.size() != 0) {
                    HttpService.HttpServiceAsync.instance().doPut(lurl, sLovation.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        //TODO use size and entities attributes
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllSubcontractorLocationPanel(results));
                                    }
                                }
                            });
                    clearFields();
                } else {
                    cityField.setMessage("Required");
                }
            }
            
            if (searchTasks.getParent().equals(empLocPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                String empUrl = OfficeWelcome.constants.root_url() + "contract-report/emp-location-search/0/100";
                if (cityField != null && !Strings.isNullOrEmpty(cityField.getValue())) {
                    entity.put("city", new JSONString(cityField.getValue()));
                    empUrl = empUrl.concat("?city=" + cityField.getValue());
                }
                if (stateFeild != null && !Strings.isNullOrEmpty(stateFeild.getValue())) {
                    entity.put("state", new JSONString(stateFeild.getValue()));
                    empUrl = empUrl.concat("?state=" + stateFeild.getValue());
                }
                if (entity.size() != 0) {
                    HttpService.HttpServiceAsync.instance().doPut(empUrl, entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                        new ResponseStatusWidget().show("No Results");
                                    } else {
                                        //TODO use size and entities attributes
                                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                        String key = (String) resObj.keySet().toArray()[0];
                                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllEmployeeLocationPanel(results));
                                    }
                                }
                            });
                    clearFields();
                } else {
                    cityField.setMessage("Required");
                }
            }
        }
        if (event.getSource().equals(reportTasks)) {
            if (reportTasks.getParent().equals(cLocationPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject cLovation = getLocationObject();
                String clurl = OfficeWelcome.instance().constants.root_url() + "client/report";
                if (cLovation.size() != 0) {
                    HttpService.HttpServiceAsync.instance().doPut(clurl, cLovation.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                    clearFields();
                } else {
                    cityField.setMessage("Required");
                }
            }
            if (reportTasks.getParent().equals(vLocationPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject cLovation = getLocationObject();
                String vlurl = OfficeWelcome.instance().constants.root_url() + "vendor/report";
                if (cLovation.size() != 0) {
                    HttpService.HttpServiceAsync.instance().doPut(vlurl, cLovation.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                    clearFields();
                } else {
                    cityField.setMessage("Required");
                }
            }
            if (reportTasks.getParent().equals(subContractorPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject obj = getSubContractorObject();
                String surl = OfficeWelcome.instance().constants.root_url() + "contract/sub-contractor-report";
                if (obj.containsKey("subContractorName")) {
                    HttpService.HttpServiceAsync.instance().doPut(surl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                    clearFields();
                }
            }
            if (reportTasks.getParent().equals(servTypePanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject obj = getServiceObject();
                String surl = OfficeWelcome.instance().constants.root_url() + "contract/serviceType-report";
                if (obj.containsKey("practice")) {
                    HttpService.HttpServiceAsync.instance().doPut(surl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                    clearFields();
                }
            }
            if (reportTasks.getParent().equals(clientPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject obj = getClientObject();
                String wucUrl = OfficeWelcome.instance().constants.root_url() + "contract/client-report";
                if (obj.containsKey("client")) {
                    HttpService.HttpServiceAsync.instance().doPut(wucUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                    clearFields();
                }
            }
            if (reportTasks.getParent().equals(vendorPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject obj = getVendorObject();
                String wuvUrl = OfficeWelcome.instance().constants.root_url() + "contract/vendor-report";
                if (obj.containsKey("vendor")) {
                    HttpService.HttpServiceAsync.instance().doPut(wuvUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                    clearFields();
                }
            }
            if (reportTasks.getParent().equals(recruiterPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                JSONObject obj = getRecruiterObject();
                if ((obj.containsKey("recruiter") == true) || (obj.containsKey("recruitedDateFrom") == true && obj.containsKey("recruitedDateTo") == true)) {
                    String rurl = OfficeWelcome.instance().constants.root_url() + "contract/recruiter-report";
                    HttpService.HttpServiceAsync.instance().doPut(rurl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                    clearFields();
                }
            }
            if (reportTasks.getParent().equals(empLocPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                String rurl = OfficeWelcome.instance().constants.root_url() + "contract-report/emp-location-report";
                JSONObject cLovation = getLocationObject();
                if (cLovation.size() != 0) {
                    HttpService.HttpServiceAsync.instance().doPut(rurl, cLovation.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                    clearFields();
                } else {
                    cityField.setMessage("Required");
                }
            }
            if (reportTasks.getParent().equals(projEndPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
                JSONObject obj = getBWDatesObject();
                String empUrl1 = OfficeWelcome.constants.root_url() + "contract-report/search-projects-between-days-report";
                if (obj.containsKey("startDate") == true && obj.containsKey("endDate") == true) {
                    empUrl1 = empUrl1.concat("?startDate=" + sdf.format(projectStartDate.getDate()));
                    empUrl1 = empUrl1.concat("&endDate=" + sdf.format(projectEndDate.getDate()));
                    obj.put("value", new JSONString(projectEndLi.getSelectedValue()));
                    empUrl1 = empUrl1.concat("&value=" + projectEndLi.getSelectedValue());
                    if (employeeTypeField != null && !Strings.isNullOrEmpty(employeeTypeField.getValue())) {
                        empUrl1 = empUrl1.concat("&employeeType=" + employeeTypeField.getValue());
                    }
                    HttpService.HttpServiceAsync.instance().doGet(empUrl1, OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                    clearFields();
                }
            }
            if (reportTasks.getParent().equals(mProjectsPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                String mpurl = OfficeWelcome.constants.root_url() + "contract-report/multiple-cpds-report";
                HttpService.HttpServiceAsync.instance().doGet(mpurl, OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String result) {
                                new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                            }
                        });
                clearFields();
            }
            if (reportTasks.getParent().equals(joinedPanel)) {
                TabPanel.instance().getReportingPanel().entityPanel.clear();
                DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
                JSONObject obj = getBWDatesObject();
                String empUrl = OfficeWelcome.constants.root_url() + "contract-report/search-emp-between-days-report";
                if (obj.containsKey("startDate") == true && obj.containsKey("endDate") == true) {
                    empUrl = empUrl.concat("?startDate=" + sdf.format(projectStartDate.getDate()));
                    empUrl = empUrl.concat("&endDate=" + sdf.format(projectEndDate.getDate()));
                    empUrl = empUrl.concat("&value=" + li.getSelectedValue());
                    HttpService.HttpServiceAsync.instance().doGet(empUrl, OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                    clearFields();
                }
            }
        }
        if (event.getSource().equals(graphB)) {
            JSONObject obj = new JSONObject();
            obj.put("recruitedDateFrom", new JSONString(DateUtils.toDateString(projectStartDate.getDate())));
            obj.put("recruitedDateTo", new JSONString(DateUtils.toDateString(projectEndDate.getDate())));
            String chartUrl = OfficeWelcome.constants.root_url() + "contract/recruiterSearch";
            HttpService.HttpServiceAsync.instance().doPut(chartUrl, obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                new ResponseStatusWidget().show("no results");
                            } else {
                                TabPanel.instance().reportingPanel.entityPanel.clear();
                                //TODO use size and entities attributes
                                JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                String key = (String) resObj.keySet().toArray()[0];
                                JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                TabPanel.instance().reportingPanel.entityPanel.add(new EmployeeRecruitedBWDatesChartPanel(results));
                            }
                        }
                    });
            clearFields();
        }
        if (event.getSource().equals(activeCPDL)) {
            String activeCPDUrl = OfficeWelcome.constants.root_url() + "contract-report/active-employees-projects-forecast-report";
            HttpService.HttpServiceAsync.instance().doGet(activeCPDUrl, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                new ResponseStatusWidget().show("Report Will be Emailed to your Primary Email");
                            }
                        }
                    });
        }
        if (event.getSource().equals(allProjectsForecastReport)) {
            String activeCPDUrl = OfficeWelcome.constants.root_url() + "contract-report/all-employees-projects-forecast-report";
            HttpService.HttpServiceAsync.instance().doGet(activeCPDUrl, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                new ResponseStatusWidget().show("Report Will be Emailed to your Primary Email");
                            }
                        }
                    });
        }
    }
    
    @Override
    public void onOpen(OpenEvent event) {
        if (event.getSource().equals(masterDataReportsL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            masterDataPanel.add(employeeSbf);
            masterDataPanel.add(employeeSbl);
            masterDataPanel.add(itemNumberField);
            masterDataPanel.add(employeeTypeField);
            masterDataPanel.add(companyField);
            masterDataPanel.add(projectStatusField);
            masterDataPanel.add(invoiceField);
            masterDataPanel.add(selectVendorWidget);
            masterDataPanel.add(searchTasks);
            masterDataReportsL.setContent(masterDataPanel);
        }
        if (event.getSource().equals(myClientL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            clientPanel.add(selectClientWidget);
            clientPanel.add(searchTasks);
            clientPanel.add(reportTasks);
            myClientL.setContent(clientPanel);
        }
        if (event.getSource().equals(myVendorL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            vendorPanel.add(selectVendorWidget);
            vendorPanel.add(searchTasks);
            vendorPanel.add(reportTasks);
            myVendorL.setContent(vendorPanel);
        }
        if (event.getSource().equals(mySubContructorL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            subContractorPanel.add(selectSubWidget);
            subContractorPanel.add(searchTasks);
            subContractorPanel.add(reportTasks);
            mySubContructorL.setContent(subContractorPanel);
        }
        if (event.getSource().equals(multipleProjectsL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            mProjectsPanel.add(searchTasks);
            mProjectsPanel.add(reportTasks);
            multipleProjectsL.setContent(mProjectsPanel);
        }
        if (event.getSource().equals(myJoinedL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            joinedPanel.add(li);
            joinedPanel.add(projectStartDate);
            joinedPanel.add(projectEndDate);
            joinedPanel.add(searchTasks);
            joinedPanel.add(reportTasks);
            myJoinedL.setContent(joinedPanel);
        }
        if (event.getSource().equals(myVlocationL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            vLocationPanel.add(cityField);
            vLocationPanel.add(stateFeild);
            vLocationPanel.add(searchTasks);
            vLocationPanel.add(reportTasks);
            myVlocationL.setContent(vLocationPanel);
        }
        if (event.getSource().equals(recruiterL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            recruiterPanel.add(selectRecruiterW);
            recruiterPanel.add(projectStartDate);
            recruiterPanel.add(projectEndDate);
            recruiterPanel.add(searchTasks);
            recruiterPanel.add(reportTasks);
            recruiterPanel.add(graphB);
            recruiterL.setContent(recruiterPanel);
        }
        if (event.getSource().equals(myClocationL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            cLocationPanel.add(cityField);
            cLocationPanel.add(stateFeild);
            cLocationPanel.add(searchTasks);
            cLocationPanel.add(reportTasks);
            myClocationL.setContent(cLocationPanel);
        }
        if (event.getSource().equals(mySlocationL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            sLocationPanel.add(cityField);
            sLocationPanel.add(stateFeild);
            sLocationPanel.add(searchTasks);
            sLocationPanel.add(reportTasks);
            mySlocationL.setContent(sLocationPanel);
        }
        if (event.getSource().equals(serviceTypeL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            servTypePanel.add(selectPracticeWidget);
            servTypePanel.add(searchTasks);
            servTypePanel.add(reportTasks);
            serviceTypeL.setContent(servTypePanel);
        }
        if (event.getSource().equals(empLocationL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            empLocPanel.add(cityField);
            empLocPanel.add(stateFeild);
            empLocPanel.add(searchTasks);
            empLocPanel.add(reportTasks);
            empLocationL.setContent(empLocPanel);
        }
        if (event.getSource().equals(projEndL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            hPanel.add(projectEndLi);
            hPanel.add(label);
            projEndPanel.add(hPanel);
            projEndPanel.add(employeeTypeField);
            projEndPanel.add(projectStartDate);
            projEndPanel.add(projectEndDate);
            projEndPanel.add(searchTasks);
            projEndPanel.add(reportTasks);
            projEndL.setContent(projEndPanel);
        }
    }
    
    private void clearFields() {
        employeeSbf.clearText();
        employeeSbl.clearText();
        itemNumberField.setValue("");
        projectStartDate.setValue("");
        projectStartDate.clearMessage();
        projectEndDate.setValue("");
        projectEndDate.clearMessage();
        cityField.setValue("");
        sectorField.setValue("");
        companyField.listBox.setSelectedIndex(0);
        invoiceField.listBox.setSelectedIndex(0);
        selectVendorWidget.getListBox().setSelectedIndex(0);
        selectVendorWidget.clearMessage();
        selectPracticeWidget.getListBox().setSelectedIndex(0);
        selectPracticeWidget.clearMessage();
        selectClientWidget.getListBox().setSelectedIndex(0);
        selectClientWidget.clearMessage();
        employeeTypeField.listBox.setSelectedIndex(0);
        projectStatusField.listBox.setSelectedIndex(0);
        selectSubWidget.getListBox().setSelectedIndex(0);
        selectSubWidget.clearMessage();
        selectRecruiterW.getListBox().setSelectedIndex(0);
        selectRecruiterW.clearMessage();
        stateFeild.listBox.setSelectedIndex(0);
    }
    
    protected JSONObject getClientObject() {
        JSONObject client = new JSONObject();
        if (selectClientWidget.getSelectedObject() == null) {
            selectClientWidget.setMessage("Required");
        }
        if (selectClientWidget.getSelectedObject() != null) {
            client.put("client", new JSONString(selectClientWidget.getSelectedObject().get("value").isString().stringValue()));
        }
        return client;
    }
    
    protected JSONObject getVendorObject() {
        JSONObject vendor = new JSONObject();
        if (selectVendorWidget.getSelectedObject() == null) {
            selectVendorWidget.setMessage("Required");
        }
        if (selectVendorWidget.getSelectedObject() != null) {
            vendor.put("vendor", new JSONString(selectVendorWidget.getSelectedObject().get("value").isString().stringValue()));
        }
        return vendor;
    }
    
    protected JSONObject getServiceObject() {
        JSONObject service = new JSONObject();
        if (selectPracticeWidget.getSelectedObject() == null) {
            selectPracticeWidget.setMessage("Required");
        }
        if (selectPracticeWidget.getSelectedObject() != null) {
            service.put("practice", new JSONString(selectPracticeWidget.getSelectedObject().get("value").isString().stringValue()));
        }
        logger.info(service.toString());
        return service;
    }
    
    protected JSONObject getSubContractorObject() {
        JSONObject sub = new JSONObject();
        if (selectSubWidget.getSelectedObject() == null) {
            selectSubWidget.setMessage("Required");
        }
        if (selectSubWidget.getSelectedObject() != null) {
            sub.put("subContractorName", new JSONString(selectSubWidget.getSelectedObject().get("value").isString().stringValue()));
        }
        return sub;
    }
    
    protected JSONObject getLocationObject() {
        JSONObject cLovation = new JSONObject();
        if (cityField != null && !Strings.isNullOrEmpty(cityField.getValue())) {
            cLovation.put("city", new JSONString(cityField.getValue()));
        }
        if (stateFeild != null && !Strings.isNullOrEmpty(stateFeild.getValue())) {
            cLovation.put("state", new JSONString(stateFeild.getValue()));
        }
        return cLovation;
    }
    
    protected JSONObject getRecruiterObject() {
        JSONObject recruiter = new JSONObject();
        if (selectRecruiterW.getSelectedObject() == null && projectStartDate.getDate() == null && projectEndDate.getDate() == null) {
            selectRecruiterW.setMessage("Required");
        } else if (projectStartDate.getDate() != null && projectEndDate.getDate() == null) {
            projectEndDate.setMessage("Required");
            selectRecruiterW.clearMessage();
        } else if (projectEndDate.getDate() != null && projectStartDate.getDate() == null) {
            projectStartDate.setMessage("Required");
            selectRecruiterW.clearMessage();
        }
        if (selectRecruiterW.getSelectedObject() != null) {
            recruiter.put("recruiter", new JSONString(selectRecruiterW.getSelectedObject().get("value").isString().stringValue()));
        }
        if (projectStartDate.getDate() != null) {
            recruiter.put("recruitedDateFrom", new JSONString(DateUtils.toDateString(projectStartDate.getDate())));
        }
        if (projectEndDate.getDate() != null) {
            recruiter.put("recruitedDateTo", new JSONString(DateUtils.toDateString(projectEndDate.getDate())));
        }
        return recruiter;
    }
    
    protected JSONObject getBWDatesObject() {
        JSONObject date = new JSONObject();
        if (projectStartDate.getDate() == null) {
            projectStartDate.setMessage("Required");
        }
        if (projectEndDate.getDate() == null) {
            projectEndDate.setMessage("Required");
        }
        if (projectStartDate.getDate() != null) {
            date.put("startDate", new JSONString(DateUtils.toDateString(projectStartDate.getDate())));
        }
        if (projectEndDate.getDate() != null) {
            date.put("endDate", new JSONString(DateUtils.toDateString(projectEndDate.getDate())));
        }
        return date;
    }
}
