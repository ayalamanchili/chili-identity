/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import java.util.ArrayList;
import java.util.List;
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
    BooleanField forTime = new BooleanField(OfficeWelcome.constants, "doYouNeedtoWorkForPartial", "OutOfOffice", false, false, Alignment.HORIZONTAL);
    TextAreaField time = new TextAreaField(OfficeWelcome.constants, "time", "WorkFromHome", false, false, Alignment.HORIZONTAL);
    BooleanField recurring = new BooleanField(OfficeWelcome.constants, "doYouNeedRecurring", "OutOfOffice", false, false, Alignment.HORIZONTAL);
    TextAreaField recurringNotes = new TextAreaField(OfficeWelcome.constants, "recurringNotes", "WorkFromHome", false, false, Alignment.HORIZONTAL);

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
        if (forTime.getBox().getValue() == true) {
            logger.info("the value issssssssssssssssssss:" + forTime.getBox().getValue());
            assignEntityValueFromField("time", outOfOffice);
        }
        if (recurring.getBox().getValue() == true) {
            assignEntityValueFromField("recurringNotes", outOfOffice);
        }
        assignEntityValueFromField("notes", outOfOffice);
        assignEntityValueFromField("contactNo", outOfOffice);
        if (employeesMSB.getValues().size() > 0) {
            List<String> emps = new ArrayList();
            JSONArray employees = employeesMSB.getValues();
            for (int i = 0; i < employees.size(); i++) {
                JSONObject obj = employees.get(i).isObject();
                emps.add(obj.get("id").isString().stringValue());
            }
            JSONArray finalemps = new JSONArray();
            for (int i = 0; i < emps.size(); i++) {
                finalemps.set(i, new JSONString(emps.get(i)));
            }
            outOfOffice.put("employees", finalemps);
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
        forTime.getBox().addClickHandler(this);
        recurring.getBox().addClickHandler(this);
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
        entityFieldsPanel.add(forTime);
        entityFieldsPanel.add(recurring);
        addField("notes", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("contactNo", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
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
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(forTime.getBox())) {
            if (forTime.getValue() == true) {
                entityFieldsPanel.insert(time, 5);
            } else {
                entityFieldsPanel.remove(time);
            }
        }
        if (event.getSource().equals(recurring.getBox())) {
            if (recurring.getValue() == true) {
                entityFieldsPanel.insert(recurringNotes, 6);
            } else {
                entityFieldsPanel.remove(recurringNotes);
            }
        } else {
            super.onClick(event);
        }
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "out-of-office/submit-request";
    }

}
