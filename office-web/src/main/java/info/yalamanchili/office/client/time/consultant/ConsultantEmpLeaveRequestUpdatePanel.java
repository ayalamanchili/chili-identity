/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.consultant;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.time.LeaveRequestTimeCategory;

/**
 *
 * @author ayalamanchili
 */
public class ConsultantEmpLeaveRequestUpdatePanel extends UpdateConsultantTimeSheetPanel {

    public ConsultantEmpLeaveRequestUpdatePanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity.put("employee", employeeF.getSelectedObject());
        assignEntityValueFromField("category", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("hours", entity);
        assignEntityValueFromField("notes", entity);
        return entity;
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("category", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("hours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        employeeF.getListBox().setEnabled(false);
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", employeeF);
        addEnumField("category", false, true, LeaveRequestTimeCategory.names());
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("hours", false, true, DataType.FLOAT_FIELD);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Request Submited, please wait for email notification within 48 hours");
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().getTimePanel().entityPanel.clear();
        TabPanel.instance().getTimePanel().entityPanel.add(new ConsultantTimeSummaryPanel());
        TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantTimeSheetsPanel());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN)) {
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadCurrentConsultantLeavesPanel());
        }
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "consultant-timesheet/update-leave-request";
    }
}
