/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class SearchVendorPanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchVendorPanel.class.getName());

    public SearchVendorPanel() {
        init("Vendor Search", "Vendor", OfficeWelcome.constants);
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
        addField("name", DataType.STRING_FIELD);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("name", entity);
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
//                searchTB.setText("");
                }
            });
        }
    }

    @Override
    protected void search(JSONObject entity) {
    }

    @Override
    protected void postSearchSuccess(JSONArray result) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorsPanel());
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "vendor/searchvendor/" + start.toString() + "/"
                + limit.toString() + "/?text=" + searchText);
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "vendor/searchvendor/" + start.toString() + "/"
                + limit.toString();
    }
}
