/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.profile.addresstype.SelectAddressTypeWidget;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author yalamanchili
 */
public class SearchEmployeePanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchEmployeePanel.class.getName());
    protected SelectAddressTypeWidget addressTypeWidget = new SelectAddressTypeWidget(false, false);

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
    protected void addWidgets() {
        addField("firstName", DataType.STRING_FIELD);
        addField("middleInitial", DataType.STRING_FIELD);
        addField("lastName", DataType.STRING_FIELD);
        addField("employeeId", DataType.STRING_FIELD);
        String[] employeeTypeStrs = {"CORPORATE_EMPLOYEE", "EMPLOYEE"};
        addEnumField("employeeType", false, false, employeeTypeStrs);
        addField("city", DataType.STRING_FIELD);
        addEnumField("state", false, false, USAStatesFactory.getStates().toArray(new String[0]));
        addDropDown("addressType", addressTypeWidget);
        addField("clientName", DataType.STRING_FIELD);
        addField("vendorName", DataType.STRING_FIELD);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("employeeId", entity);
        //employeetype
        JSONObject employeeType = new JSONObject();
        assignEntityValueFromField("employeeType", employeeType, "name");
        if (employeeType.size() > 0) {
            entity.put("employeeType", employeeType);
        }
        //populate address for search
        JSONArray addresses = new JSONArray();
        JSONObject address = new JSONObject();
        assignEntityValueFromField("city", address);
        assignEntityValueFromField("state", address);
        addresses.set(0, address);
        if (address.size() > 0) {
            entity.put("addresss", addresses);
             assignEntityValueFromField("addressType", entity);
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
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void search(String searchText) {
        if (getSearchText() != null) {
            HttpService.HttpServiceAsync.instance().doGet(getSearchURI(getSearchText(), 0, 150),
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
        HttpService.HttpServiceAsync.instance().doPut(getSearchURI(0, 150), entity.toString(),
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
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/searchEmployee/" + start.toString() + "/"
                + limit.toString() + "/?text=" + searchText);
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
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/1000?column=id&column=firstName";
    }

    protected String getLastNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/1000?column=id&column=lastName";
    }

    protected String getEmployeeIdDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/1000?column=id&column=employeeId";
    }
}
