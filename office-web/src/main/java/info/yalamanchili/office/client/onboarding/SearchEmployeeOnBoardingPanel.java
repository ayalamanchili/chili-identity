/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import java.util.logging.Logger;

/**
 *
 * @author hemalatha.duggirala
 */
public class SearchEmployeeOnBoardingPanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchEmployeeOnBoardingPanel.class.getName());
    protected Button reportB = new Button("Report");
    DateField endDate = new DateField(OfficeWelcome.constants2, "endDate", "Onboarding", false, false);
    EnumField status = new EnumField(OfficeWelcome.constants2, "status", "Onboarding", false, false, OnBoardingStatus.names());

    public SearchEmployeeOnBoardingPanel() {
        init("OnBoarding Search", "InitiateOnBoarding", OfficeWelcome.constants);
    }

    @Override
    protected void populateSearchSuggestBox() {
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
    }

    @Override
    protected void addListeners() {
        reportB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employeeType", new SelectEmployeeTypeWidget(false, false, Alignment.VERTICAL));
        addDropDown("company", new SelectCompanyWidget(false, false));
        advancedSearchPanel.add(status);
        addField("startDate", DataType.DATE_FIELD);
        advancedSearchPanel.add(endDate);
        mainPanel.add(reportB);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        SelectComposite employeeTypeF = (SelectComposite) fields.get("employeeType");
        if (employeeTypeF.getSelectedObject() != null) {
            entity.put("employeeType", employeeTypeF.getSelectedObject().get("value"));
        } else {
            entity.put("employeeType", null);
        }
        SelectComposite companyField = (SelectComposite) fields.get("company");
        if (companyField.getSelectedObject() != null) {
            entity.put("company", companyField.getSelectedObject().get("value"));
        } else {
            entity.put("company", null);
        }
        if (status.getValue() != null) {
            entity.put("status", new JSONString(status.getValue()));
        } else {
            entity.put("status", null);
        }
        assignEntityValueFromField("startDate", entity);
        if (endDate.getDate() != null) {
            entity.put("endDate", new JSONString(DateUtils.toDateString(endDate.getDate())));
        }
        return entity;
    }

    @Override
    protected void search(String searchText) {
        if (getSearchText() != null) {
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
        TabPanel.instance().getMyOfficePanel().entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeeOnBoardingPanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        if (getKey() != null) {
            return OfficeWelcome.constants.root_url() + "on-board-employee/search-onboarding" + "/" + start.toString() + "/"
                    + limit.toString()+ "?empId=" + getKey();
        } else {
            return OfficeWelcome.constants.root_url() + "on-board-employee/search/" + searchText + "/" + start.toString() + "/"
                    + limit.toString();
        }
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "on-board-employee/search-onboarding/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().myOfficePanel.sidePanelTop.setHeight("100%");
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(reportB)) {
            DateField startDateF = (DateField) fields.get("startDate");
            if (startDateF.getDate() == null && endDate.getDate() == null) {
                startDateF.setMessage("Required");
                endDate.setMessage("Required");
            } else if (startDateF.getDate() != null && endDate.getDate() == null) {
                endDate.setMessage("Required");
            } else if (startDateF.getDate() == null && endDate.getDate() != null) {
                startDateF.setMessage("Required");
            } else {
                JSONObject entity = new JSONObject();
                entity.put("startDate", new JSONString(DateUtils.toDateString(startDateF.getDate())));
                entity.put("endDate", new JSONString(DateUtils.toDateString(endDate.getDate())));
                TabPanel.instance().getAdminPanel().entityPanel.clear();
                String empUrl = OfficeWelcome.constants.root_url() + "on-board-employee/reports";
                HttpService.HttpServiceAsync.instance().doPut(empUrl, entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                    }
                });
            }
        }
        super.onClick(event);
    }
}
