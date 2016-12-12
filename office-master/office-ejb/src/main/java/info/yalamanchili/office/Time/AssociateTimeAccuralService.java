/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.audit.AuditService;
import info.chili.commons.DateUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.ConsultantTimeSheet;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Component
@Transactional
public class AssociateTimeAccuralService {

    public static final String DEACTIVATE_PTO_NOTIFICATION_GROUP = "Deactivate_Pto_Notification_Group";

    //TODO support for proration hours
    //TODO avoid duplicate creation
    public void accureMonthlyConsTime() {
        ConsultantTimeSheetDao dao = ConsultantTimeSheetDao.instance();
        Date today = new Date();
        NotificationGroup ng = NotificationGroupDao.instance().findByName(DEACTIVATE_PTO_NOTIFICATION_GROUP);
        loop1:
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Employee")) {
            if (ng != null) {
                for (Employee deactivateEmp : ng.getEmployees()) {
                    if (deactivateEmp.equals(emp)) {
                        continue loop1;
                    }
                }
            }
            if (emp.getStartDate() == null) {
                continue;
            }
            Date startDate = emp.getStartDate();
            int numberOfMonthsCompleted = DateUtils.differenceInMonths(startDate, new Date());
            ConsultantTimeSheet ptoAccruedTS = dao.getPTOAccruedTimeSheet(emp);
            if (ptoAccruedTS != null) {
                BigDecimal beforeHours = ptoAccruedTS.getHours();
                if (today.before(DateUtils.getNextDay(startDate, 30))) {
                    //New employee less than a month
                    Long daysWorkedInMonth = DateUtils.differenceInDays(startDate, today);
                    ptoAccruedTS.setHours(DateUtils.getProratedHours(TimeAccuralConstants.lessThanOneYearHoursAccural, new BigDecimal("30"), new BigDecimal(daysWorkedInMonth)));
                } else if (today.before(DateUtils.getNextYear(startDate, 1))) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.lessThanOneYearHoursAccural).compareTo(TimeAccuralConstants.lessThanOneYearHoursAccuralMax) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.lessThanOneYearHoursAccuralMax);
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.lessThanOneYearHoursAccural));
                    }

                } else if (today.after(DateUtils.getNextYear(startDate, 1)) && today.before(DateUtils.getNextYear(startDate, 5))) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.twoToFourYearsHoursAccural).compareTo(TimeAccuralConstants.twoToFourYearsHoursAccuralMax) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.twoToFourYearsHoursAccuralMax);
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.twoToFourYearsHoursAccural));
                    }
                } else if (today.after(DateUtils.getNextYear(startDate, 5)) && today.before(DateUtils.getNextYear(startDate, 10))) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.fiveToTenYearsHoursAccural).compareTo(TimeAccuralConstants.fiveToTenYearsHoursAccuralMax) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.fiveToTenYearsHoursAccuralMax);
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.fiveToTenYearsHoursAccural));

                    }
                } else if (today.after(DateUtils.getNextYear(startDate, 10))) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.moreThanTenYearsHoursAccural).compareTo(TimeAccuralConstants.moreThanTenYearsHoursAccuralMax) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.moreThanTenYearsHoursAccuralMax);
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.moreThanTenYearsHoursAccural));
                    }
                }
                BigDecimal afterHours = ptoAccruedTS.getHours();
                dao.getEntityManager().merge(ptoAccruedTS);
                CommentDao.instance().addComment("System update on " + new Date() + " from: " + beforeHours + " hours to:" + afterHours + " hours :difference: " + afterHours.subtract(beforeHours), ptoAccruedTS);
            }
        }
    }

    public void revertRecentPTOAccruedChanges() {
        ConsultantTimeSheetDao dao = ConsultantTimeSheetDao.instance();
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Employee")) {
            if (emp.getStartDate() == null) {
                continue;
            }
            ConsultantTimeSheet ptoAccruedTS = dao.getPTOAccruedTimeSheet(emp);
            if (ptoAccruedTS.getId() != null) {
                ConsultantTimeSheet previousVersion = (ConsultantTimeSheet) AuditService.instance().mostRecentVersion(ConsultantTimeSheet.class, ptoAccruedTS.getId());
                if (previousVersion != null) {
                    ptoAccruedTS.setHours(previousVersion.getHours());
                    dao.getEntityManager().merge(ptoAccruedTS);
                    dao.addTimeSheetUpdateComment("System Reverting recent Change: ", previousVersion.getHours(), ptoAccruedTS);
                }
            }
        }

    }

    public static AssociateTimeAccuralService instance() {
        return SpringContext.getBean(AssociateTimeAccuralService.class);
    }
}
