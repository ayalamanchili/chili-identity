/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.audit.AuditService;
import info.chili.commons.DateUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Transactional
public class CorporateTimeAccuralService {

    private final static Logger logger = Logger.getLogger(CorporateTimeAccuralService.class.getName());

    //TODO support for proration hours
    //TODO avoid duplicate creation
    public void accureMonthlyTime() {
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        Date today = new Date();
        for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 5000, OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            if (emp.getStartDate() == null) {
                continue;
            }
            Date startDate = emp.getStartDate();
            int numberOfMonthsCompleted = DateUtils.differenceInMonths(startDate, new Date());
            CorporateTimeSheet ptoAccruedTS = dao.getPTOAccruedTimeSheet(emp);
            if (ptoAccruedTS != null) {
                BigDecimal beforeHours = ptoAccruedTS.getHours();
                if (today.before(DateUtils.getNextDay(startDate, 30))) {
                    //New employee less than a month
                    Long daysWorkedInMonth = DateUtils.differenceInDays(startDate, today);
                    ptoAccruedTS.setHours(DateUtils.getProratedHours(TimeAccuralConstants.lessThanOneYearHoursAccural, new BigDecimal("30"), new BigDecimal(daysWorkedInMonth)));
                } else if (today.before(DateUtils.getNextYear(startDate, 1))) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.lessThanOneYearAccural(emp)).compareTo(TimeAccuralConstants.lessThanOneYearAccuralMax(emp)) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.lessThanOneYearAccuralMax(emp));
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.lessThanOneYearAccural(emp)));
                    }
                } else if (today.after(DateUtils.getNextYear(startDate, 1)) && today.before(DateUtils.getNextYear(startDate, 5))) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.twoToFourYearsHoursAccural(emp)).compareTo(TimeAccuralConstants.twoToFourYearsHoursAccuralMax(emp)) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.twoToFourYearsHoursAccuralMax(emp));
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.twoToFourYearsHoursAccural(emp)));
                    }
                } else if (today.after(DateUtils.getNextYear(startDate, 5)) && today.before(DateUtils.getNextYear(startDate, 10))) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.fiveToTenYearsHoursAccural(emp)).compareTo(TimeAccuralConstants.fiveToTenYearsHoursAccuralMax(emp)) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.fiveToTenYearsHoursAccuralMax(emp));
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.fiveToTenYearsHoursAccural(emp)));
                    }
                } else if (today.after(DateUtils.getNextYear(startDate, 10))) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.moreThanTenYearsHoursAccural(emp)).compareTo(TimeAccuralConstants.moreThanTenYearsHoursAccuralMax(emp)) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.moreThanTenYearsHoursAccuralMax(emp));
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.moreThanTenYearsHoursAccural(emp)));
                    }
                }
                dao.getEntityManager().merge(ptoAccruedTS);
                dao.addTimeSheetUpdateComment("System Montly Update: ", beforeHours, ptoAccruedTS);
            }
            sendEmailNotification("");
        }
    }

    protected void sendEmailNotification(String msg) {
        Email email = new Email();
        email.setTos(OfficeServiceConfiguration.instance().getFilteredEmailsAsSet());
        email.setSubject("Successfully complete Monthly Leave Accrual on " + new Date());
        email.setBody(msg);
        MessagingService.instance().sendEmail(email);
    }

    public void revertRecentPTOAccruedChanges() {
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 5000, OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            if (emp.getStartDate() == null) {
                continue;
            }
            CorporateTimeSheet ptoAccruedTS = dao.getPTOAccruedTimeSheet(emp);
            if (ptoAccruedTS.getId() != null) {
                CorporateTimeSheet previousVersion = (CorporateTimeSheet) AuditService.instance().mostRecentVersion(CorporateTimeSheet.class, ptoAccruedTS.getId());
                if (previousVersion != null) {
                    ptoAccruedTS.setHours(previousVersion.getHours());
                    dao.getEntityManager().merge(ptoAccruedTS);
                    dao.addTimeSheetUpdateComment("System Reverting recent Change: ", previousVersion.getHours(), ptoAccruedTS);
                }
            }
        }

    }

    public static CorporateTimeAccuralService instance() {
        return SpringContext.getBean(CorporateTimeAccuralService.class);
    }
}
