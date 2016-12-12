/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.SuggestBox;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class SearchVendorPanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchVendorPanel.class.getName());

    public SearchVendorPanel() {
        init("Vendor Search", "Vendors", OfficeWelcome.constants2);
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

    protected String getnameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "vendor/dropdown/0/10000?column=id&column=name";
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
        HttpService.HttpServiceAsync.instance().doGet(getnameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("vendorName");
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
        addField("vendorName", DataType.STRING_FIELD);
        addEnumField("vendorType", false, false, VendorType.names());
        addField("city", DataType.STRING_FIELD);
        addEnumField("state", false, false, USAStatesFactory.getStates().toArray(new String[0]));
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("vendorName", entity);
        assignEntityValueFromField("vendorType", entity);
        assignEntityValueFromField("city", entity);
        assignEntityValueFromField("state", entity);
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
//                searchTB.setText("");
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
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorsPanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "vendor/search/" + start.toString() + "/"
                + limit.toString() + "/?text=" + searchText;
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "vendor/search-vendor/" + start.toString() + "/"
                + limit.toString();
    }
}
