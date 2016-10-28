/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.profile.addresstype.SelectAddressTypeWidget;
import info.yalamanchili.office.client.profile.contact.Branch;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author yalamanchili
 */
public class SearchEmployeePanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchEmployeePanel.class.getName());
    protected SelectAddressTypeWidget addressTypeWidget = new SelectAddressTypeWidget(false, false);
    protected SelectCorpEmployeeWidget companyContactF = new SelectCorpEmployeeWidget(false, false);

    public SearchEmployeePanel() {
        init("Employees Search", "Employee", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().myOfficePanel.sidePanelTop.setHeight("100%");
    }

    @Override
    protected void addWidgets() {
        addField("firstName", DataType.STRING_FIELD);
        addField("middleInitial", DataType.STRING_FIELD);
        addField("lastName", DataType.STRING_FIELD);
        addField("employeeId", DataType.STRING_FIELD);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN)) {
            addField("startDate", DataType.DATE_FIELD);
            addField("endDate", DataType.DATE_FIELD);
        }
        addField("city", DataType.STRING_FIELD);
        addField("clientName", DataType.STRING_FIELD);
        addField("vendorName", DataType.STRING_FIELD);
        if (Auth.isCorporateEmployee()) {
            String[] employeeTypeStrs = {"Corporate Employee", "Employee", "Subcontractor", "1099 Contractor", "W2 Contractor", "Intern-Seasonal Employee"};
            addEnumField("employeeType", false, false, employeeTypeStrs);
            addEnumField("role", false, false, Auth.getAllRoles());
            addEnumField("branch", false, false, Branch.names());
        }
        addEnumField("state", false, false, USAStatesFactory.getStates().toArray(new String[0]));
        addDropDown("addressType", addressTypeWidget);
        addDropDown("companyContact", companyContactF);
        companyContactF.setLabelText("Company Contact");
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        //branch
        assignEntityValueFromField("branch", entity);
        assignEntityValueFromField("employeeId", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        if (Auth.isCorporateEmployee()) {
            //employeetype
            JSONObject employeeType = new JSONObject();
            assignEntityValueFromField("employeeType", employeeType, "name");
            if (employeeType.size() > 0) {
                entity.put("employeeType", employeeType);
            }
            //roles
            JSONObject user = new JSONObject();
            JSONArray roles = new JSONArray();
            JSONObject role = new JSONObject();
            assignEntityValueFromField("role", role, "rolename");
            if (role.size() > 0) {
                roles.set(0, role);
                user.put("roles", roles);
                entity.put("user", user);
            }
        }

        //populate address for search
        JSONArray addresses = new JSONArray();
        JSONObject address = new JSONObject();
        assignEntityValueFromField("city", address);
        assignEntityValueFromField("state", address);
        addresses.set(0, address);
        if (address.size() > 0) {
            entity.put("addresss", addresses);
            assignEntityValueFromField("addressType", address);
        }
        //client information
        JSONArray clientInfos = new JSONArray();
        JSONObject clientInfo = new JSONObject();
        //client
        JSONObject client = new JSONObject();
        assignEntityValueFromField("clientName", client, "name");
        if (client.size() > 0) {
            clientInfo.put("client", client);
        }
        //vendor
        JSONObject vendor = new JSONObject();
        assignEntityValueFromField("vendorName", vendor, "name");
        if (vendor.size() > 0) {
            clientInfo.put("vendor", vendor);
        }
        clientInfos.set(0, clientInfo);
        if (client.size() > 0 || vendor.size() > 0) {
            entity.put("clientInformations", clientInfos);
        }
        //search by company Contact
        JSONArray companyContacts = new JSONArray();
        JSONObject companyContact = new JSONObject();
        if (companyContactF.getSelectedObject() != null) {
            companyContact.put("contact", companyContactF.getSelectedObject());
            companyContacts.set(0, companyContact);
            entity.put("companyContacts", companyContacts);
        }
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void search(String searchText) {
        if (getSearchText() != null) {
            HttpService.HttpServiceAsync.instance().doGet(getSearchURI(getSearchText(), 0, 200),
                    OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            processSearchResult(result);
                        }
                    });
        }
    }

    @Override
    protected void search(JSONObject entity) {
        HttpService.HttpServiceAsync.instance().doPut(getSearchURI(0, 200), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        processSearchResult(result);
                    }
                });
    }

    @Override
    protected void postSearchSuccess(JSONArray results) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeesPanel(results));
    }

    @Override
    public boolean enableGenerateReport() {
        if (Auth.hasNonUserRoles()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN, Auth.ROLE.ROLE_SYSTEM_AND_NETWORK_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS)) {
            return OfficeWelcome.constants.root_url() + "employee/searchEmployee/" + start.toString() + "/"
                    + limit.toString() + "/?text=" + searchText + "&column=firstName&column=lastName&includeDeactivated=true";
        } else {
            return OfficeWelcome.constants.root_url() + "employee/searchEmployee/" + start.toString() + "/"
                    + limit.toString() + "/?text=" + searchText + "&column=firstName&column=lastName";
        }
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "employee/searchEmployee/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected void populateSearchSuggestBox() {
        HttpService.HttpServiceAsync.instance().doGet(getFirstNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                loadSearchSuggestions(values.values());
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getLastNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                loadSearchSuggestions(values.values());
            }
        });
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
        HttpService.HttpServiceAsync.instance().doGet(getFirstNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("firstName");
                sb.loadData(values.values());
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getLastNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("lastName");
                sb.loadData(values.values());
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("employeeId");
                sb.loadData(values.values());
            }
        });
    }

    protected String getFirstNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&employee-type=Corporate Employee&employee-type=Employee&employee-type=Subcontractor&employee-type=1099 Contractor&employee-type=W2 Contractor&includeAll=true";
    }

    protected String getLastNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=lastName&employee-type=Corporate Employee&employee-type=Employee&employee-type=Subcontractor&employee-type=1099 Contractor&employee-type=W2 Contractor&includeAll=true";
    }

    protected String getEmployeeIdDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=employeeId";
    }

    @Override
    protected String getReportURL() {
        return ChiliClientConfig.instance().getFileDownloadUrl() + "employee/search_employee_report" + "&passthrough=true" + "&format=" + getReportFormat();
    }
}
