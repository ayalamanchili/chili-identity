/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.yalamanchili.office.Time.TimeJobService;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class OfficeServiceJobConfiguration {

    @ManagedOperation
    public void syncTimeSheetPeriods() {
        TimeJobService.instance().syncTimeSheetPeriods();
    }

    @ManagedOperation
    public void processYearlyEarnedTimeSheets() {
        TimeJobService.instance().processCorpEmpYearlyEarnedTimeSheets();
    }

    @ManagedOperation
    public void approveNewCorpEmployeeTimeSheets() {
        TimeJobService.instance().approveNewCorpEmployeeTimeSheets();
    }

    @ManagedOperation
    public void syncNotificationGroupsForRoles() {
        NotificationGroupDao.instance().syncNotificationGroupsForRoles();
    }
}
