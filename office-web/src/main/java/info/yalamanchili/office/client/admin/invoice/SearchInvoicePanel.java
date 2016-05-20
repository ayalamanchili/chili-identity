/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Sudha
 */
public class SearchInvoicePanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchInvoicePanel.class.getName());

    public SearchInvoicePanel() {
        init("Invoice Search", "Invoice", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("invoiceNumber", DataType.STRING_FIELD);
        addField("itemNumber", DataType.STRING_FIELD);
        addField("startDate", DataType.DATE_FIELD);
        addField("endDate", DataType.DATE_FIELD);
        addEnumField("timeSheetStatus", false, false, TimeStatus.names());
        addEnumField("invoiceStatus", false, false, InvoiceStatus.names());
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("invoiceNumber", entity);
        assignEntityValueFromField("itemNumber", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("timeSheetStatus", entity);
        assignEntityValueFromField("invoiceStatus", entity);
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
        HttpService.HttpServiceAsync.instance().doPut(getSearchURI(0, 1000), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        processSearchResult(result);
                    }
                });
    }

    @Override
    protected void postSearchSuccess(JSONArray result) {
        TabPanel.instance().getReportingPanel().entityPanel.clear();
        TabPanel.instance().getReportingPanel().entityPanel.add(new ReadAllInvoicePanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        if (getKey() != null) {
            return URL.encode(OfficeWelcome.constants.root_url() + "invoice/search-invoice-by-emp" + "/" + start.toString() + "/"
                    + limit.toString()) + "?empId=" + getKey();
        } else {
            return URL.encode(OfficeWelcome.constants.root_url() + "invoice/search/" + searchText + "/" + start.toString() + "/"
                    + limit.toString());
        }
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "invoice/search/" + start.toString() + "/"
                + limit.toString());
    }

    @Override
    protected void populateSearchSuggestBox() {
        HttpService.HttpServiceAsync.instance().doGet(getNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                suggestionsMap = JSONUtils.convertKeyValueStringPairs(entityString);
                loadSearchSuggestions(suggestionsMap.values());
            }
        });
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
        HttpService.HttpServiceAsync.instance().doGet(getInvoiceNumberDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("invoiceNumber");
                sb.loadData(values.values());
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getItemNumberDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("itemNumber");
                sb.loadData(values.values());
            }
        });
    }

    protected String getInvoiceNumberDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "subcontractor/dropdown/0/10000?column=id&column=name";
    }

    protected String getItemNumberDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "vendor/dropdown/0/10000?column=id&column=name";
    }

    protected String getNameDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee&employee-type=Employee&employee-type=Subcontractor&employee-type=1099 Contractor&employee-type=W2 Contractor&includeAll=true");
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
    }
}
