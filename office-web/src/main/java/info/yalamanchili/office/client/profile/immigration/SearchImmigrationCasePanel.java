/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Timer;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.expense.chkreq.ImmigrationCaseStatus;
import info.yalamanchili.office.client.expense.chkreq.ImmigrationCaseType;
import info.yalamanchili.office.client.expense.chkreq.SponsorType;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.yalamanchili.office.client.profile.immigration.immigrationcase.ReadAllImmigrationCasePanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class SearchImmigrationCasePanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchImmigrationCasePanel.class.getName());
    protected SelectCompanyWidget companyWidget = new SelectCompanyWidget(false, false, Alignment.VERTICAL);
    EnumField sponsorType = new EnumField(OfficeWelcome.constants2, "sponsorType", "ImmigrationCase", false, false, SponsorType.names());
    EnumField caseType = new EnumField(OfficeWelcome.constants2, "immigrationCaseType", "ImmigrationCase", false, false, ImmigrationCaseType.names());
    EnumField caseStatus = new EnumField(OfficeWelcome.constants2, "immigrationCaseStatus", "ImmigrationCase", false, false, ImmigrationCaseStatus.names());

    public SearchImmigrationCasePanel() {
        init("Search", "ImmigrationCase", OfficeWelcome.constants2);
        advancedSearchDP.setOpen(true);
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().immigrationPanel.sidePanelTop.setHeight("100%");
    }

    @Override
    protected void populateSearchSuggestBox() {
        Timer timer = new Timer() {
            @Override
            public void run() {
                HttpService.HttpServiceAsync.instance().doGet(getnameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String entityString) {
                        Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                        if (values != null) {
                            suggestionsMap = values;
                            loadSearchSuggestions(values.values());
                        }
                    }
                });
            }
        };
        timer.schedule(1000);
    }

    protected String getnameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/search-suggestions";
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("company", companyWidget);
        advancedSearchPanel.add(sponsorType);
        advancedSearchPanel.add(caseType);
        advancedSearchPanel.add(caseStatus);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        if (companyWidget.getSelectedObject() != null) {
            entity.put("company", companyWidget.getSelectedObject());
        }
        if (sponsorType.getValue() != null) {
            entity.put("sponsorType", new JSONString(sponsorType.getValue()));
        }
        if (caseType.getValue() != null) {
            entity.put("immigrationCaseType", new JSONString(caseType.getValue()));
        }
        if (caseStatus.getValue() != null) {
            entity.put("immigrationCaseStatus", new JSONString(caseStatus.getValue()));
        }
        return entity;
    }

    @Override
    protected void search(String searchText) {
        if (getKey() == null) {
            clearSearch();
            new ResponseStatusWidget().show("No Employee Selected");
        } else {
            HttpService.HttpServiceAsync.instance().doGet(getSearchURI(getSearchText(), 0, 1000),
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
        TabPanel.instance().getImmigrationPanel().entityPanel.clear();
        TabPanel.instance().getImmigrationPanel().entityPanel.add(new ReadAllImmigrationCasePanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "immigrationcase/search/" + getKey();
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "immigrationcase/search-case/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected boolean disableRegularSearch() {
        return false;
    }

    @Override
    protected void addListeners() {
    }
}