/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contracts;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class SearchContractsPanel extends SearchComposite {

    protected SelectCompanyWidget selectCompnayWidget = new SelectCompanyWidget(false, false);

    private static Logger logger = Logger.getLogger(SearchContractsPanel.class.getName());

    public SearchContractsPanel() {
        init("Contract Search", "Contract", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("employeeFirstName", DataType.STRING_FIELD);
        addField("employeeLastName", DataType.STRING_FIELD);
        addField("itemNumber", DataType.STRING_FIELD);
        addField("client", DataType.STRING_FIELD);
        addField("vendor", DataType.STRING_FIELD);
        addField("subContractorName", DataType.STRING_FIELD);
        addField("startDate", DataType.DATE_FIELD);
        addField("endDate", DataType.DATE_FIELD);
        addField("city", DataType.STRING_FIELD);
        addEnumField("state", false, false, USAStatesFactory.getStates().toArray(new String[0]));
        addEnumField("invoiceFrequency", false, false, InvoiceFrequency.names());
        String[] employeeTypeStrs = {"Corporate Employee", "Employee", "Subcontractor", "1099 Contractor"};
        addEnumField("employeeType", false, false, employeeTypeStrs);
        addDropDown("company", selectCompnayWidget);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        assignEntityValueFromField("employeeFirstName", entity);
        assignEntityValueFromField("employeeLastName", entity);
        assignEntityValueFromField("itemNumber", entity);
        assignEntityValueFromField("client", entity);
        assignEntityValueFromField("vendor", entity);
        assignEntityValueFromField("subContractorName", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("city", entity);
        assignEntityValueFromField("state", entity);
        assignEntityValueFromField("invoiceFrequency", entity);
        assignEntityValueFromField("employeeType", entity);
        assignEntityValueFromField("company", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void search(String searchText) {
        HttpService.HttpServiceAsync.instance().doGet(getSearchURI(searchText, 0, 50),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        processSearchResult(result);
                    }
                });
    }

    @Override
    protected void search(JSONObject entity) {
        HttpService.HttpServiceAsync.instance().doPut(getSearchURI(0, 50), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        processSearchResult(result);
                    }
                });
    }

    @Override
    protected void postSearchSuccess(JSONArray results) {
        TabPanel.instance().getReportingPanel().entityPanel.clear();
        TabPanel.instance().getReportingPanel().entityPanel.add(new ReadAllContractsPanel(results));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "contract/search/" + start.toString() + "/"
                + limit.toString() + "?text=" + searchText;
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "contract/search/" + start.toString() + "/"
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

    protected String getFirstNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=firstName";
    }

    protected String getLastNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=lastName";
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
    }

}
