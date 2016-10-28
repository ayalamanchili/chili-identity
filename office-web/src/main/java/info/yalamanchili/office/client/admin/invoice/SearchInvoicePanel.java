/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.profile.cllientinfo.ClientInformationCompany;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Sudha
 */
public class SearchInvoicePanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchInvoicePanel.class.getName());
    protected Button reportB = new Button("Report");
    EnumField clientInformationCompany = new EnumField(OfficeWelcome.constants2, "clientInformationCompany", "Invoice", false, false, ClientInformationCompany.names());

    public SearchInvoicePanel() {
        init("Invoice Search", "Invoice", OfficeWelcome.constants2);
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
        addField("vendor", DataType.STRING_FIELD);
        advancedSearchPanel.add(clientInformationCompany);
        addField("invoiceNumber", DataType.STRING_FIELD);
        addField("itemNumber", DataType.STRING_FIELD);
        addField("startDate", DataType.DATE_FIELD);
        addField("endDate", DataType.DATE_FIELD);
        addField("invoiceDate", DataType.DATE_FIELD);
        addField("invoiceSentDate", DataType.DATE_FIELD);
        addEnumField("timeSheetStatus", false, false, TimeStatus.names());
        addEnumField("invoiceStatus", false, false, InvoiceStatus.names());
        mainPanel.add(reportB);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("vendor", entity);
        if (clientInformationCompany.getValue() != null) {
            entity.put("clientInformationCompany", new JSONString(clientInformationCompany.getValue()));
        } else {
            entity.put("clientInformationCompany", null);
        }
        assignEntityValueFromField("invoiceNumber", entity);
        assignEntityValueFromField("itemNumber", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("invoiceDate", entity);
        assignEntityValueFromField("invoiceSentDate", entity);
        assignEntityValueFromField("timeSheetStatus", entity);
        assignEntityValueFromField("invoiceStatus", entity);
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
        TabPanel.instance().getReportingPanel().entityPanel.clear();
        TabPanel.instance().getReportingPanel().entityPanel.add(new ReadAllInvoicePanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        if (getKey() != null) {
            return OfficeWelcome.constants.root_url() + "invoice/search-invoice-by-emp" + "/" + start.toString() + "/"
                    + limit.toString() + "?empId=" + getKey();
        } else {
            return OfficeWelcome.constants.root_url() + "invoice/search/" + searchText + "/" + start.toString() + "/"
                    + limit.toString();
        }
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return OfficeWelcome.constants.root_url() + "invoice/adv-search/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    protected void populateSearchSuggestBox() {
        HttpService.HttpServiceAsync.instance().doGet(getNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                suggestionsMap = JSONUtils.convertKeyValueStringPairs(entityString);
                loadSearchSuggestions(suggestionsMap.values());
            }
        });
    }

    @Override
    protected void populateAdvancedSuggestBoxes() {
        HttpService.HttpServiceAsync.instance().doGet(getVendorDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<Integer, String> values = JSONUtils.convertKeyValuePairs(entityString);
                SuggestBox sb = (SuggestBox) fields.get("vendor");
                sb.loadData(values.values());
            }
        });
    }

    protected String getVendorDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "vendor/dropdown/0/10000?column=id&column=name";
    }

    protected String getNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee&employee-type=Employee&employee-type=Subcontractor&employee-type=1099 Contractor&employee-type=W2 Contractor&includeAll=true";
    }

    @Override
    protected void onOpenAdvancedSearch() {
        super.onOpenAdvancedSearch();
        TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(reportB)) {
            DateField startDateF = (DateField) fields.get("startDate");
            DateField endDateF = (DateField) fields.get("endDate");
            if (startDateF.getDate() == null && endDateF.getDate() == null) {
                startDateF.setMessage("Required");
                endDateF.setMessage("Required");
            } else if (startDateF.getDate() != null && endDateF.getDate() == null) {
                endDateF.setMessage("Required");
            } else if (startDateF.getDate() == null && endDateF.getDate() != null) {
                startDateF.setMessage("Required");
            } else {
                JSONObject entity = new JSONObject();
                TabPanel.instance().getAdminPanel().entityPanel.clear();
                String empUrl = OfficeWelcome.constants.root_url() + "invoice/reports";
                assignEntityValueFromField("startDate", entity);
                assignEntityValueFromField("endDate", entity);
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
