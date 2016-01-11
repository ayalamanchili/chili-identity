/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

/**
 *
 * @author radhika.mukkala
 */
/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.SearchComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class SearchProspectsPanel extends SearchComposite {

    private static Logger logger = Logger.getLogger(SearchProspectsPanel.class.getName());
    Button prospectsReport = new Button("Report");
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
    protected void populateSearchSuggestBox() {

    }

    @Override
    protected void populateAdvancedSuggestBoxes() {

    }

    @Override
    protected void addListeners() {
        prospectsReport.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("firstName", DataType.STRING_FIELD);
        addField("lastName", DataType.STRING_FIELD);
        addField("referredBy", DataType.STRING_FIELD);
        addField("processDocSentDate", DataType.DATE_FIELD);
        addField("email", DataType.STRING_FIELD);
        addField("phoneNumber", DataType.LONG_FIELD);
        mainPanel.add(statusF);
        mainPanel.add(searchButton);
        mainPanel.add(prospectsReport);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        JSONObject contact = new JSONObject();
        assignEntityValueFromField("firstName", contact);
        assignEntityValueFromField("lastName", contact);
        assignEntityValueFromField("referredBy", entity);
        assignEntityValueFromField("email", contact);
        assignEntityValueFromField("phoneNumber", contact);
        assignEntityValueFromField("processDocSentDate", entity);
        entity.put("status", new JSONString(statusF.getValue()));
        entity.put("contact", contact);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void search(String searchText) {

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
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllProspectsPanel(result));
    }

    @Override
    protected String getSearchURI(String searchText, Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "prospect/search/" + searchText + "/" + start.toString() + "/"
                + limit.toString());
    }

    @Override
    protected String getSearchURI(Integer start, Integer limit) {
        return URL.encode(OfficeWelcome.constants.root_url() + "prospect/search-prospect/" + start.toString() + "/"
                + limit.toString());
    }

    @Override
    protected boolean disableRegularSearch() {
        return true;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(prospectsReport)) {
            if (statusF.getValue() == null) {
                statusF.setMessage("Required");
            } else {
                statusF.clearMessage();
                String reportUrl = OfficeWelcome.instance().constants.root_url() + "prospect/report/" + statusF.getValue();
                HttpService.HttpServiceAsync.instance().doGet(reportUrl, OfficeWelcome.instance().getHeaders(), true,
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
