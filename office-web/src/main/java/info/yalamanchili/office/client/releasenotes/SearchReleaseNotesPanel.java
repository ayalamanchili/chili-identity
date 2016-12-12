/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.releasenotes;

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
 * @author sudharani.bandaru
 */
public class SearchReleaseNotesPanel extends SearchComposite {
        
    private static Logger logger = Logger.getLogger(SearchReleaseNotesPanel.class.getName());
    
    public SearchReleaseNotesPanel() {
          init("ReleaseNotes Search", "userIds", OfficeWelcome.constants2);
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
        addField("endDate", DataType.DATE_FIELD);
        addField("roles", DataType.STRING_FIELD);
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("roles", entity);
        logger.info(entity.toString());
        return entity;
    } 
    
    @Override
    protected void search(String searchText) {

    }

    @Override
    protected void search(JSONObject entity) {
        HttpService.HttpServiceAsync.instance().doPut(getSearchURI(0, 100), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        processSearchResult(result);
                    }
                });
    }

    @Override
    protected void postSearchSuccess(JSONArray result) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllReleaseNotesPanel(result));
    }
    
    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return "";

    }
    
    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "releaseNotes/search";
    }

    @Override
    protected boolean disableRegularSearch() {
        return false;
    }

    
}

    
