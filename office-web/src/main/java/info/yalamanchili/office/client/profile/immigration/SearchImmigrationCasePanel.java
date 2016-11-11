/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Timer;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
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
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false);
    protected SelectCompanyWidget companyWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);

    public SearchImmigrationCasePanel() {
        init("Search", "ImmigrationCase", OfficeWelcome.constants2);
        advancedSearchDP.setOpen(true);
        //TabPanel.instance().immigrationPanel.sidePanelTop.setHeight("100%");
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().immigrationPanel.sidePanelTop.setHeight("100%");
    }

    @Override
    protected void populateSearchSuggestBox() {
//        Timer timer = new Timer() {
//            @Override
//            public void run() {
//                HttpService.HttpServiceAsync.instance().doGet(getnameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
//                    @Override
//                    public void onResponse(String entityString) {
//                        Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
//                        if (values != null) {
//                            suggestionsMap = values;
//                            loadSearchSuggestions(values.values());
//                        }
//                    }
//                });
//            }
//        };
//        timer.schedule(1000);
    }

    protected String getnameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/search-suggestions";
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    private String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee&employee-type=Employee";
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
        advancedSearchPanel.add(employeeSB);
        addEnumField("sponsorType", false, true, SponsorType.names());
        addDropDown("company", companyWidget);
        addEnumField("immigrationCaseType", false, false, ImmigrationCaseType.names());
        addEnumField("immigrationCaseStatus", false, false, ImmigrationCaseStatus.names());
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        if (employeeSB.getSelectedObject() != null) {
            entity.put("employee", employeeSB.getSelectedObject());
        }
        if (companyWidget.getSelectedObject() != null) {
            entity.put("company", companyWidget.getSelectedObject());
        }
        assignEntityValueFromField("sponsorType", entity);
        assignEntityValueFromField("immigrationCaseType", entity);
        assignEntityValueFromField("immigrationCaseStatus", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void search(String searchText) {
//        if (getKey() == null) {
//            clearSearch();
//            new ResponseStatusWidget().show("No Employee Selected");
//
//        } else {
//            HttpService.HttpServiceAsync.instance().doGet(getSearchURI(getSearchText(), 0, 1000),
//                    OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
//                        @Override
//                        public void onResponse(String result) {
//                            processSearchResult(result);
//                        }
//                    });
//        }
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
        return true;
    }

    @Override
    protected void addListeners() {
    }
}
