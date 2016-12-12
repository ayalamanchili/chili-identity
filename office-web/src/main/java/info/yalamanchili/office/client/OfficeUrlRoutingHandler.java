/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

import com.google.common.base.Splitter;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.admin.hr.ReadAllProspectsPanel;
import info.yalamanchili.office.client.advancerequisition.ReadAllAdvanceRequisitionPanel;
import info.yalamanchili.office.client.contracts.ReadAllContractsPanel;
import info.yalamanchili.office.client.expense.chkreq.ReadAllImmigrationCheckRequisitionPanel;
import info.yalamanchili.office.client.expense.travelauthorization.ReadAllTravelAuthorizationPanel;
import info.yalamanchili.office.client.expensereports.ReadAllExpenseReportsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.home.tasks.ReadTaskPanel;
import info.yalamanchili.office.client.onboarding.ReadAllEmployeeOnBoardingPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPanel;
import info.yalamanchili.office.client.profile.employee.ReadAllEmployeesPanel;
import info.yalamanchili.office.client.profile.selfservice.ReadAllServiceTicketsPanel;
import info.yalamanchili.office.client.profile.statusreport.ReadStatusReportPanel;
import info.yalamanchili.office.client.time.ReadAllOutOfOfficePanel;
import info.yalamanchili.office.client.time.consultant.ReadAllConsultantTimeSheetsPanel;
import info.yalamanchili.office.client.time.corp.ReadAllCorporateTimeSheetPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author phani
 */
public class OfficeUrlRoutingHandler implements ValueChangeHandler<String> {

    public static Logger logger = Logger.getLogger(OfficeUrlRoutingHandler.class.getName());

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String urltoken = event.getValue();
        logger.info("------------urltoken:" + urltoken + ":");
        Map<String, String> params = splitQuery(urltoken);
        logger.info("---------Params:" + params);
        if (params.containsKey("entity")) {
            switch (params.get("entity")) {
                case "info.chili.bpm.types.Task":
                    taskNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.hr.Prospect":
                    prospectNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition":
                    checkRequisitionNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.expense.AdvanceRequisition":
                    advanceRequisitionNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport":
                    expenseReportNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization":
                    travelAuthorizationNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.profile.ClientInformation":
                    clientInformationNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.selfserv.ServiceTicket":
                    selfServiceNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.employee.statusreport.StatusReport":
                    statusReportNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.profile.Address":
                    addressesNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.time.CorporateTimeSheet":
                    corporateTimeNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.time.ConsultantTimeSheet":
                    ConsultantTimeNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding":
                    onboardingTimeNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.time.OutOfOfficeRequest":
                    outOfOfficeNavigation(params);
                    break;
                case "info.yalamanchili.office.entity.profile.Employee":
                    officeEmployeeProfileNavigation(params);
                //TODO add navigation to add entities that have comment
            }
        }
    }

    protected void commentNavigation(Map<String, String> params) {

    }
    
    protected void officeEmployeeProfileNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().myOfficePanel, true);
        ReadAllEmployeesPanel readAllEmployeesPanel = new ReadAllEmployeesPanel(new JSONArray());
        readAllEmployeesPanel.viewClicked(params.get("id"));
    }

    protected void prospectNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().myOfficePanel, false);
        ReadAllProspectsPanel readAllProspects = new ReadAllProspectsPanel(new JSONArray());
        readAllProspects.viewClicked(params.get("id"));
    }

    protected void checkRequisitionNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().expensePanel, false);
        ReadAllImmigrationCheckRequisitionPanel readAllCheckRequisition = new ReadAllImmigrationCheckRequisitionPanel(new JSONArray());
        readAllCheckRequisition.viewClicked(params.get("id"));
    }

    protected void advanceRequisitionNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().expensePanel, false);
        ReadAllAdvanceRequisitionPanel readAllAdvanceRequisition = new ReadAllAdvanceRequisitionPanel(new JSONArray());
        readAllAdvanceRequisition.viewClicked(params.get("id"));
    }

    protected void expenseReportNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().expensePanel, false);
        ReadAllExpenseReportsPanel readAllExpense = new ReadAllExpenseReportsPanel(new JSONArray());
        readAllExpense.viewClicked(params.get("id"));
    }

    protected void travelAuthorizationNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().expensePanel, false);
        ReadAllTravelAuthorizationPanel readAlltravelauthorization = new ReadAllTravelAuthorizationPanel(new JSONArray());
        readAlltravelauthorization.viewClicked(params.get("id"));
    }

    protected void clientInformationNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().reportingPanel, false);
        ReadAllContractsPanel readAllcontracts = new ReadAllContractsPanel(new JSONArray());
        readAllcontracts.viewClicked(params.get("id"));
    }

    protected void selfServiceNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().homePanel, false);
        ReadAllServiceTicketsPanel readAllserviceTicket = new ReadAllServiceTicketsPanel(new JSONArray());
        readAllserviceTicket.viewClicked(params.get("id"));
    }

    protected void statusReportNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().homePanel, false);
        TabPanel.instance().homePanel.entityPanel.clear();
        TabPanel.instance().homePanel.entityPanel.add(new ReadStatusReportPanel(params.get("id")));
    }

    protected void addressesNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().myOfficePanel, false);
        ReadAllAddressesPanel readalladdress = new ReadAllAddressesPanel(new JSONArray());
        readalladdress.viewClicked(params.get("id"));
    }

    protected void corporateTimeNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().timePanel, false);
        ReadAllCorporateTimeSheetPanel readallcorporatetimesheet = new ReadAllCorporateTimeSheetPanel(new JSONArray());
        readallcorporatetimesheet.viewClicked(params.get("id"));
    }

    protected void ConsultantTimeNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().timePanel, false);
        ReadAllConsultantTimeSheetsPanel readallConsultanttimesheet = new ReadAllConsultantTimeSheetsPanel(new JSONArray().toString());
        readallConsultanttimesheet.viewClicked(params.get("id"));
    }

    protected void onboardingTimeNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().myOfficePanel, false);
        ReadAllEmployeeOnBoardingPanel readallonboarding = new ReadAllEmployeeOnBoardingPanel(new JSONArray());
        readallonboarding.viewClicked(params.get("id"));
    }
    
    protected void outOfOfficeNavigation(Map<String, String> params) {
        TabPanel.instance().tabPanel.selectTab(TabPanel.instance().timePanel, false);
        ReadAllOutOfOfficePanel readAllOutOfOffice = new ReadAllOutOfOfficePanel(new JSONArray());
        readAllOutOfOffice.viewClicked(params.get("id"));
    }

    protected void taskNavigation(Map<String, String> params) {
        TabPanel.instance().homePanel.entityPanel.clear();
        if (params.get("id") != null) {
            String url = OfficeWelcome.constants.root_url() + "bpm/viewtask/" + params.get("id");
            HttpService.HttpServiceAsync.instance().doGet(url, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onFailure(Throwable err) {
                            super.onFailure(err);
                            TabPanel.instance().homePanel.entityPanel.add(new ReadAllTasks());
                        }

                        @Override
                        public void onResponse(String response) {
                            JSONObject task = (JSONObject) JSONParser.parseLenient(response);
                            TabPanel.instance().homePanel.entityPanel.add(new ReadTaskPanel(task, false));
                        }
                    });
        }
    }
    
//TODO move to commons
    public static Map<String, String> splitQuery(String url) {
        return Splitter.on('&').trimResults().withKeyValueSeparator("=").split(url.split("\\?")[1]);
    }
}
