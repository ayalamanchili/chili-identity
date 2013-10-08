/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contracts;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.config.ChiliClientConfig;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.SearchComposite;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ContractsSidePanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(ContractsSidePanel.class.getName());

    public ContractsSidePanel() {
        init("Contracts Search", "Contract", OfficeWelcome.constants);
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
    }

    @Override
    protected void generateReportClicked() {
        generateReport(new JSONObject());
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        return entity;
    }

    @Override
    protected void search(String searchText) {
    }

    @Override
    protected void search(JSONObject entity) {
    }

    @Override
    protected void postSearchSuccess(JSONArray result) {
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "client/search/" + searchText + "/" + start.toString() + "/"
                + limit.toString());
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "client/search/" + start.toString() + "/"
                + limit.toString());
    }

    @Override
    public boolean enableGenerateReport() {
        return true;
    }

    @Override
    protected String getReportURL() {
        return ChiliClientConfig.instance().getFileDownloadUrl() + "contract/report" + "&format=" + getReportFormat();
    }
}
