/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

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
class SearchTravelAuthPanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchTravelAuthPanel.class.getName());

    public SearchTravelAuthPanel() {
        init("Search", "TravelAuthorization", OfficeWelcome.constants);
        advancedSearchDP.setOpen(true);
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().expensePanel.sidePanelTop.setHeight("100%");
    }

    @Override
    protected void populateSearchSuggestBox() {
    }

    protected String getnameDropDownUrl() {
        //TODO think about the limit
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=firstName";
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
        HttpService.HttpServiceAsync.instance().doGet(getnameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("employee");
                sb.loadData(values.values());
            }
        });
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
        addField("employee", DataType.STRING_FIELD);
        addEnumField("status", false, false, TravelAuthorizationStatus.names());
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONObject employee = new JSONObject();
        assignEntityValueFromField("employee", employee, "firstName");
        assignEntityValueFromField("status", entity);
        entity.put("employee", employee);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void search(String searchText) {
    }

    @Override
    protected void search(JSONObject entity) {
        HttpService.HttpServiceAsync.instance().doPut(getSearchURI(0, 10), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        processSearchResult(result);
                    }
                });
    }

    @Override
    protected void postSearchSuccess(JSONArray result) {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllTravelAuthorizationPanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "travel-authorization/search/" + searchText + "/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "travel-authorization/search-travelauth/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected boolean disableRegularSearch() {
        return true;
    }

    @Override
    protected void addListeners() {
    }
}