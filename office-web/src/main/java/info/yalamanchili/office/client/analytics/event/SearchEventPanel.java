/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.analytics.event;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
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
 * @author benerji.v
 */
public class SearchEventPanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchEventPanel.class.getName());

    public SearchEventPanel() {
        init("Events Search", "Event", OfficeWelcome.constants);
    }

    @Override
    protected void populateSearchSuggestBox() {

    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
        HttpService.HttpServiceAsync.instance().doGet(getNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("user");
                sb.loadData(values.values());
            }
        });
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("user", DataType.STRING_FIELD);
        addField("name", DataType.STRING_FIELD);
        addField("type", DataType.STRING_FIELD);
        addField("clientInfo", DataType.STRING_FIELD);
        addField("input", DataType.STRING_FIELD);
        addField("output", DataType.STRING_FIELD);
        addField("startDate", DataType.DATE_FIELD);
        addField("endDate", DataType.DATE_FIELD);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("user", entity);
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("type", entity);
        assignEntityValueFromField("clientInfo", entity);
        assignEntityValueFromField("input", entity);
        assignEntityValueFromField("output", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void search(String searchText) {

    }

    @Override
    protected void search(JSONObject entity) {
        HttpService.HttpServiceAsync.instance().doPut(getSearchURL(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        processSearchResult(result);
                    }
                });
    }

    @Override
    protected void postSearchSuccess(JSONArray result) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllEventsPanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "chilli/analytics/search/" + searchText + "/" + start.toString() + "/"
                + limit.toString();

    }

    protected String getSearchURL() {
        return OfficeWelcome.constants.root_url() + "chili/analytics/events/search";
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "chilli/analytics/events/search";
    }

    private String getNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=employeeId";
    }

    @Override
    protected boolean disableRegularSearch() {
        return false;
    }
}
