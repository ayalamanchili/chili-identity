/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Timer;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.SearchComposite;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
class SearchExpenseReportsPanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchExpenseReportsPanel.class.getName());

    public SearchExpenseReportsPanel() {
        init("Search", "ExpenseReports", OfficeWelcome.constants);
        advancedSearchDP.setOpen(true);
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().myOfficePanel.sidePanelTop.setHeight("100%");
    }

    @Override
    protected void populateSearchSuggestBox() {
    }

    protected String getFirstNameDropDownUrl() {
        //TODO think about the limit
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=firstName";
    }

    protected String getLastNameDropDownUrl() {
        //TODO think about the limit
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=lastName";
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
        HttpService.HttpServiceAsync.instance().doGet(getFirstNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("employeeFirstName");
                sb.loadData(values.values());
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getLastNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("employeeLastName");
                sb.loadData(values.values());
            }
        });
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        Timer timer = new Timer() {
            @Override
            public void run() {
                populateAdvancedSuggestBoxes();
            }
        };
        timer.schedule(2000);
    }

    @Override
    protected void addWidgets() {
        addField("employeeFirstName", DataType.STRING_FIELD);
        addField("employeeLastName", DataType.STRING_FIELD);
        addEnumField("status", false, false, ExpenseReportStatus.names());
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONObject employee = new JSONObject();
        assignEntityValueFromField("employeeFirstName", employee, "firstName");
        assignEntityValueFromField("employeeLastName", employee, "lastName");
        assignEntityValueFromField("status", entity);
        entity.put("employee", employee);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void search(String searchText) {
        if (getSearchText() != null) {
            HttpService.HttpServiceAsync.instance().doGet(getSearchURI(getSearchText(), 0, 1000),
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
        HttpService.HttpServiceAsync.instance().doPut(getSearchURI(0, 100), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        processSearchResult(result);
                    }
                });
    }

    @Override
    protected void postSearchSuccess(JSONArray result) {
        logger.info("result :" + result.toString());
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllExpenseReportsPanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "expensereport/search/" + searchText + "/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "expensereport/search-expensereport/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected boolean disableRegularSearch() {
        return true;
    }
}
