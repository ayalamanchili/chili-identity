/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Timer;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
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
 * @author Ramana.Lukalapu
 */
public class SearchOutOfOfficePanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchOutOfOfficePanel.class.getName());
    EnumField officeType = new EnumField(OfficeWelcome.constants2, "outOfOfficeType", "OutOfOfficeRequest",
                false, false, OutOfOfficeType.names());

    public SearchOutOfOfficePanel() {
        init("Search", "OutOfOfficeRequest", OfficeWelcome.constants2);
        advancedSearchDP.setOpen(true);
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().timePanel.sidePanelTop.setHeight("100%");
    }

    @Override
    protected void populateSearchSuggestBox() {
    }

    protected String getFirstNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=firstName";
    }

    protected String getLastNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/dropdown/0/10000?column=id&column=lastName";
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
        addField("firstName", DataType.STRING_FIELD);
        addField("lastName", DataType.STRING_FIELD);
        addField("startDate", DataType.DATE_FIELD);
        addField("endDate", DataType.DATE_FIELD);
        fields.put("outOfOfficeType", officeType);
        advancedSearchPanel.add(officeType);
        addEnumField("status", false, false, OutOfOfficeRequestStatus.names());
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONObject employee = new JSONObject();
        assignEntityValueFromField("firstName", employee, "firstName");
        assignEntityValueFromField("lastName", employee, "lastName");
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("outOfOfficeType", entity);
        assignEntityValueFromField("status", entity);
        entity.put("employee", employee);
        return entity;
    }

    @Override
    protected void search(String searchText) {
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
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllOutOfOfficePanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "out-of-office/search/" + searchText + "/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "out-of-office/search-request/" + start.toString() + "/"
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
