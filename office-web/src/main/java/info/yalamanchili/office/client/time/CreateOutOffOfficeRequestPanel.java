/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class CreateOutOffOfficeRequestPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateOutOffOfficeRequestPanel.class.getName());
    protected FlowPanel panel = new FlowPanel();

    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false, Alignment.HORIZONTAL);
    //BooleanField forTime = new BooleanField(OfficeWelcome.constants, "doYouNeedtoWorkForPartial", "OutOfOffice", false, false, Alignment.HORIZONTAL);
    //BooleanField recurring = new BooleanField(OfficeWelcome.constants, "doYouNeedRecurring", "OutOfOffice", false, false, Alignment.HORIZONTAL);

    public CreateOutOffOfficeRequestPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("OutOfOffice", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject outOfOffice = new JSONObject();
        assignEntityValueFromField("workType", outOfOffice);
        if (employeeSB.getSelectedObject() != null) {
            outOfOffice.put("employee", employeeSB.getSelectedObject());
        }
        assignEntityValueFromField("startDate", outOfOffice);
        assignEntityValueFromField("endDate", outOfOffice);
        assignEntityValueFromField("time", outOfOffice);
        assignEntityValueFromField("recurring", outOfOffice);
        assignEntityValueFromField("reason", outOfOffice);
        assignEntityValueFromField("contactNo", outOfOffice);
        JSONArray notifyEmployeesList = employeesMSB.getValues();
        if (notifyEmployeesList.size() > 0) {
            outOfOffice.put("notifyEmployees", notifyEmployeesList);
        }
        logger.info(outOfOffice.toString());
        return outOfOffice;
    }

    @Override
    protected void createButtonClicked() {
        logger.info("hellooooooo:" + entity.toString());
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Request Submitted Successfully");
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllOutOfOfficePanel());
    }

    @Override
    protected void addListeners() {
        //forTime.getBox().addClickHandler(this);
        //recurring.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
        HttpService.HttpServiceAsync.instance().doGet(getIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                logger.info(entityString);
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    protected String getIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_USER.name() + "/0/10000");
    }

    @Override
    protected void addWidgets() {
        addSuggestField("employee", employeeSB);
        addEnumField("workType", false, true, OutOfOfficeType.names(), Alignment.HORIZONTAL);
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("workForPartiatl", false, true, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("recurring", false, true, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("reason", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("contactNo", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("If you work for partital or if you want recurring please mention timings in the below time field"));
        addField("time", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Add members to be notified"));
        entityFieldsPanel.add(employeesMSB);
        alignFields();
    }

    MultiSelectSuggestBox employeesMSB = new MultiSelectSuggestBox() {
        @Override
        public void initTosSuggesBox() {
            HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String entityString) {
                    logger.info(entityString);
                    Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                    if (values != null) {
                        suggestionsBox.loadData(values);
                    }
                }
            });
        }
    };

    protected String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_USER.name() + "/0/10000");
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "out-of-office/submit-request";
    }

}
