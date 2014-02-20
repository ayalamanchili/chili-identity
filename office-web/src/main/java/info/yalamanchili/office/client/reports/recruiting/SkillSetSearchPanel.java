/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports.recruiting;

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
import info.yalamanchili.office.client.profile.employee.ReadAllEmployeesPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class SkillSetSearchPanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SkillSetSearchPanel.class.getName());

    public SkillSetSearchPanel() {
        init("Skill Set Search", "SkillSet", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("practice", DataType.STRING_FIELD);
        addField("technologyGroup", DataType.STRING_FIELD);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        assignEntityValueFromField("practice", entity);
        assignEntityValueFromField("technologyGroup", entity);
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
        TabPanel.instance().getReportingPanel().entityPanel.add(new ReadAllEmployeesPanel(results));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "recruiting-reports/search-skillset?text=" + searchText;
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "recruiting-reports/search-skillset/";
    }

    @Override
    protected void populateSearchSuggestBox() {

    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
        HttpService.HttpServiceAsync.instance().doGet(getPracticeNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("practice");
                sb.loadData(values.values());
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getTechnologyGroupNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("technologyGroup");
                sb.loadData(values.values());
            }
        });
    }

    protected String getPracticeNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "practice/dropdown/0/10000?column=id&column=name";
    }

    protected String getTechnologyGroupNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "technologyGroup/dropdown/0/10000?column=id&column=name";
    }

}
