/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.common.base.Strings;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.data.CanadaStatesFactory;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.contact.Branch;

/**
 *
 * @author hemalatha.duggirala
 */
public class AddressReportSidePanel extends ALComposite implements ClickHandler, ChangeHandler {

    protected FlowPanel panel = new FlowPanel();
    EnumField branchB = new EnumField(OfficeWelcome.constants, "branch", "Employee", false, false, Branch.names());
    StringField cityField = new StringField(OfficeWelcome.constants, "city", "Employee", false, false);
    EnumField countryField = new EnumField(OfficeWelcome.constants, "country", "Employee", false, true, CountryFactory.getCountries().toArray(new String[0]));
    EnumField stateField = new EnumField(OfficeWelcome.constants, "state", "Employee", false, true, USAStatesFactory.getStates().toArray(new String[0]));
    Button viewB = new Button("View");
    Button reportsB = new Button("Generate");

    public AddressReportSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        reportsB.addClickHandler(this);
        viewB.addClickHandler(this);
        if (countryField != null) {
            countryField.listBox.addChangeHandler(this);
        }
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(branchB);
        panel.add(cityField);
        panel.add(countryField);
        panel.add(stateField);
        panel.add(viewB);
        panel.add(reportsB);
    }

    @Override
    public void onClick(ClickEvent event) {
        JSONObject obj = getLocationObject();
        if (event.getSource().equals(reportsB)) {
             if (!Strings.isNullOrEmpty(obj.get("city").isString().stringValue()) || obj.keySet().size() > 1) {
            HttpService.HttpServiceAsync.instance().doPut(getEmpAddressReportUrl(), obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String result) {
                    new ResponseStatusWidget().show("Report will be emailed to your primary email");
                }
            });
             } 
            else {
                new ResponseStatusWidget().show("Please select atleast one item to proceed");
            }

            clearField();
            
        }

        if (event.getSource().equals(viewB)) {
             if (!Strings.isNullOrEmpty(obj.get("city").isString().stringValue()) || obj.keySet().size() > 1) {
            HttpService.HttpServiceAsync.instance().doPut(getEmpAddressReadAllUrl(), obj.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String result) {
                    if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                        new ResponseStatusWidget().show("No Results");
                    } else {
                        TabPanel.instance().reportingPanel.entityPanel.clear();
                        JSONObject resObj = JSONParser.parseLenient(result).isObject();
                        String key = (String) resObj.keySet().toArray()[0];
                        JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                        TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllAddressReportsPanel(results));
                    }
                }
            });
            } else {
                new ResponseStatusWidget().show("Please select atleast one item to proceed");
            }
            clearField();

        }
    }

    protected String getEmpAddressReportUrl() {
        return OfficeWelcome.constants.root_url() + "contract-report/emp-address-report";
    }

    protected String getEmpAddressReadAllUrl() {
        return OfficeWelcome.constants.root_url() + "contract-report/emp-address";
    }

    protected JSONObject getLocationObject() {
        JSONObject obj = new JSONObject();
        if (branchB.getValue() != null) {
            obj.put("branch", new JSONString(branchB.getValue()));
        }
        if (cityField.getValue() != null) {
            obj.put("city", new JSONString(cityField.getValue()));
        }
        if (stateField.getValue() != null) {
            obj.put("state", new JSONString(stateField.getValue()));
        }
        if (countryField.getValue() != null) {
            obj.put("country", new JSONString(countryField.getValue()));
        }
        return obj;
    }

    protected void clearField() {
        branchB.listBox.setSelectedIndex(0);
        cityField.setValue("");
        countryField.listBox.setSelectedIndex(0);
        stateField.listBox.setSelectedIndex(0);
    }

    public void onChange(ChangeEvent event) {
        switch (countryField.getValue()) {
            case "USA":
                stateField.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                break;
            case "INDIA":
                stateField.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                break;
            case "CANADA":
                stateField.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                break;
        }
    }
}
