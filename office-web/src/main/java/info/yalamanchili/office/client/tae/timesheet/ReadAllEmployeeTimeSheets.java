/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllEmployeeTimeSheets extends ReadAllTimesheetPanel {

    protected String employeeId;

    public ReadAllEmployeeTimeSheets(String employeeId) {
        this.employeeId = employeeId;
        preFetchTable(0);
    }

    @Override
    protected void preFetchData() {
    }

    @Override
    public String getReadAllTimesheetPanelURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "timesheet/employee/" + employeeId + "/" + start.toString() + "/" + limit.toString();

    }
}
