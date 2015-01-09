/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.analytics;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
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
        init("Activity Search", "Activity", OfficeWelcome.constants);
    }

    @Override
    protected void populateSearchSuggestBox() {
        HttpService.HttpServiceAsync.instance().doGet(getnameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                loadSearchSuggestions(values.values());
            }
        });
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
        HttpService.HttpServiceAsync.instance().doGet(getnameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                loadSearchSuggestions(values.values());
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
        addField("userName", DataType.STRING_FIELD);
        addField("startDate", DataType.DATE_FIELD);
        addField("endDate", DataType.DATE_FIELD);
        addField("eventaName", DataType.DATE_FIELD);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("userName", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("eventaName", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void search(String searchText) {
        if (getSearchText() != null) {
            HttpService.HttpServiceAsync.instance().doGet(getSearchURI(getSearchText(), 0, 10),
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
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllEventsPanel());
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "analytics/search/" + searchText + "/" + start.toString() + "/"
                + limit.toString());

    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "analytics/search/" + start.toString() + "/"
                + limit.toString());
    }

    private String getnameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "analytics/dropdown/0/10000?column=id&column=name";
    }
}
