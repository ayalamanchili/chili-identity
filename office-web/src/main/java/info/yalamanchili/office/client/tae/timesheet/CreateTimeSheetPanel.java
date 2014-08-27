/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.tae.timesheetperiod.SelectTimesheetPeriodWidget;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateTimeSheetPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.tae.timesheet.CreateTimeSheetPanel.class.getName());

    public CreateTimeSheetPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Timesheet", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("employee", entity);
        assignEntityValueFromField("timeSheetPeriod", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("adpHours", entity);
        assignEntityValueFromField("adpRate", entity);
        assignEntityValueFromField("quickBooksHours", entity);
        assignEntityValueFromField("quickBooksRate", entity);
        assignEntityValueFromField("notes", entity);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
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
        new ResponseStatusWidget().show("Timesheet Successfully Created");
        TabPanel.instance().timePanel.entityPanel.clear();
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectEmployeeWidget("Employee", false, true));
        addDropDown("timeSheetPeriod", new SelectTimesheetPeriodWidget(false, true));
        addField("adpHours", false, true, DataType.FLOAT_FIELD);
        addField("quickBooksHours", false, true, DataType.FLOAT_FIELD);
        addField("adpRate", false, false, DataType.CURRENCY_FIELD);
        addField("quickBooksRate", false, false, DataType.CURRENCY_FIELD);
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timesheet";
    }
}
