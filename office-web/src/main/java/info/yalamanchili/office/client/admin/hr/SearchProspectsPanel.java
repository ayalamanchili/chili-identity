/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Timer;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class SearchProspectsPanel extends SearchComposite implements ChangeHandler {

    private static Logger logger = Logger.getLogger(SearchProspectsPanel.class.getName());
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "assignedTo", "Employee", false, false);
    SuggestBox caseManagerSB = new SuggestBox(OfficeWelcome.constants, "caseManager", "Employee", false, false);
    protected SelectCompanyWidget selectCompnayWidget = new SelectCompanyWidget(false, false);
    EnumField statusF = new EnumField(OfficeWelcome.constants, "status", "Prospect", false, false, ProspectStatus.names());

    public SearchProspectsPanel() {
        init("Prospect Search", "Prospect", OfficeWelcome.constants);
        advancedSearchDP.setOpen(true);
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().myOfficePanel.sidePanelTop.setHeight("100%");
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
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getcaseManagnerIdsDropDownUrl1(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    caseManagerSB.loadData(values);
                }
            }
        });
        HttpService.HttpServiceAsync.instance().doGet(getcaseManagnerIdsDropDownUrl2(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    caseManagerSB.loadData(values);
                }
            }
        });
    }

    private String getcaseManagnerIdsDropDownUrl1() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_H1B_IMMIGRATION + "/0/10000");
    }

    private String getcaseManagnerIdsDropDownUrl2() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_GC_IMMIGRATION + "/0/10000");
    }

    private String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_RECRUITER + "/0/10000");
    }

    protected String getFirstNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "prospect/search-firstname";
    }

    protected String getLastNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "prospect/search-lastname";
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("firstName", DataType.STRING_FIELD);
        addField("lastName", DataType.STRING_FIELD);
        addField("referredBy", DataType.STRING_FIELD);
        advancedSearchPanel.add(employeeSB);
        advancedSearchPanel.add(caseManagerSB);
        addDropDown("company", selectCompnayWidget);
        addField("processDocSentDate", DataType.DATE_FIELD);
        addEnumField("petitionFiledFor", false, false, PetitionFor.names());
        addEnumField("trfEmpType", false, false, TransferEmployeeType.names());
        addEnumField("placedBy", false, false, PlacedBy.names());
        addField("dateOfJoining", DataType.DATE_FIELD);
        mainPanel.insert(statusF, mainPanel.getWidgetIndex(searchButton));
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONObject contact = new JSONObject();
        assignEntityValueFromField("firstName", contact);
        assignEntityValueFromField("lastName", contact);
        assignEntityValueFromField("referredBy", entity);
        if (employeeSB.getSelectedObject() != null) {
            entity.put("assigned", employeeSB.getSelectedObject().get("id"));
        }
        if (caseManagerSB.getSelectedObject() != null) {
            entity.put("manager", caseManagerSB.getSelectedObject().get("id"));
        }
        if (selectCompnayWidget.getSelectedObject() != null) {
            entity.put("company", selectCompnayWidget.getSelectedObject().get("id"));
        }
        assignEntityValueFromField("petitionFiledFor", entity);
        assignEntityValueFromField("placedBy", entity);
        assignEntityValueFromField("trfEmpType", entity);
        assignEntityValueFromField("dateOfJoining", entity);
        assignEntityValueFromField("processDocSentDate", entity);
        if (statusF.getValue() != null) {
            entity.put("status", new JSONString(statusF.getValue()));
            statusF.listBox.addChangeHandler(this);
        }
        entity.put("contact", contact);
        return entity;
    }

    @Override
    protected void search(String searchText) {
        if (getKey() == null) {
            clearSearch();
            new ResponseStatusWidget().show("No prospect selected");

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
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllProspectsPanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "prospect/search/" + getKey());
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "prospect/search-prospect/" + start.toString() + "/"
                + limit.toString());
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
        return OfficeWelcome.constants.root_url() + "prospect/search-suggestions";
    }

    @Override
    public void onChange(ChangeEvent event) {
        entity.put("status", new JSONString(statusF.getValue()));
        search(entity);
    }
}
