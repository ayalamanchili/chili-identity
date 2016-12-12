/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.recruiting.reports;

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
import info.yalamanchili.office.client.practice.SelectPracticeWidget;
import info.yalamanchili.office.client.profile.skillset.ReadAllSkillSetsPanel;
import info.yalamanchili.office.client.profile.technologyGroup.SelectTechnologyGroupWidget;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class SkillSetSearchPanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SkillSetSearchPanel.class.getName());
    protected SelectPracticeWidget practiceWidget = new SelectPracticeWidget(false, false);
    protected SelectTechnologyGroupWidget tgWidget = new SelectTechnologyGroupWidget(false, false);

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
        addDropDown("practice", practiceWidget);
        addDropDown("technologyGroup", tgWidget);
        addField("skills", DataType.STRING_FIELD);
        addField("certifications", DataType.STRING_FIELD);
        addField("tags", DataType.STRING_FIELD);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        if (practiceWidget.getSelectedObject() != null) {
            entity.put("practice", practiceWidget.getSelectedObject().get("value"));
        }
        if (tgWidget.getSelectedObject() != null) {
            entity.put("technologyGroup", tgWidget.getSelectedObject().get("value"));
        }
        assignEntityValueFromField("skills", entity);
        assignEntityValueFromField("certifications", entity);
        assignEntityValueFromField("tags", entity);
        return entity;
    }

    @Override
    protected void search(String searchText) {
        HttpService.HttpServiceAsync.instance().doGet(getSearchURI(searchText, 0, 50),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
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
        TabPanel.instance().getRecruitingPanel().entityPanel.clear();
        TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllSkillSetsPanel(results));
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
        HttpService.HttpServiceAsync.instance().doGet(getSkillsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("skills");
                sb.loadData(values.values());
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getCertificationsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("certifications");
                sb.loadData(values.values());
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getTagsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("tags");
                sb.loadData(values.values());
            }
        });
    }

    protected String getSkillsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "skill/dropdown/0/10000?column=id&column=name";
    }

    protected String getCertificationsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "certification/dropdown/0/10000?column=id&column=name";
    }

    protected String getTagsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "skillsettag/dropdown/0/10000?column=id&column=name";
    }

}
