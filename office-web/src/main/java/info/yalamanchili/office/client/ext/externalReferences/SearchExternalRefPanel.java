/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.externalReferences;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.SearchComposite;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class SearchExternalRefPanel extends SearchComposite {

    private static final Logger logger = Logger.getLogger(SearchExternalRefPanel.class.getName());

    public SearchExternalRefPanel() {
        init("External Refs Search", "ExternalRef", OfficeWelcome.constants);
    }

    @Override
    protected void populateSearchSuggestBox() {
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("source", DataType.STRING_FIELD);
        addField("externalId", DataType.STRING_FIELD);
        addField("targetEntityId", DataType.LONG_FIELD);
        addField("targetEntityName", DataType.STRING_FIELD);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("externalId", entity);
        assignEntityValueFromField("source", entity);
        assignEntityValueFromField("targetEntityId", entity);
        assignEntityValueFromField("targetEntityName", entity);
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
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllExternalRefPanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "external-ref/search/" + searchText + "/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "external-ref/search/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected boolean disableRegularSearch() {
        return true;
    }
}
