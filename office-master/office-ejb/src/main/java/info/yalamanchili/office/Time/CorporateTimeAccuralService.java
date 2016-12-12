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
import info.chili.email.Email;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Branch;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
    public static final String DEACTIVATE_PTO_NOTIFICATION_GROUP = "Deactivate_Pto_Notification_Group";

    //TODO avoid duplicate creation
    public void accureMonthlyTime() {
        NotificationGroup ng = NotificationGroupDao.instance().findByName(DEACTIVATE_PTO_NOTIFICATION_GROUP);
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        Date today = new Date();
        loop1:
        for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 10000, OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
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
            CorporateTimeSheet ptoAccruedTS = dao.getPTOAccruedTimeSheet(emp);
            if (ptoAccruedTS != null) {
                BigDecimal beforeHours = ptoAccruedTS.getHours();
                //India Team
                if (Branch.Hyderabad.equals(emp.getBranch())) {
                    int diffInMonths = DateUtils.differenceInMonths(startDate, new Date());
                    if (diffInMonths > 6) {
                        //After probation period employee leave 
                        // after 6 months if employee joined in first 15 days of the month
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
                        int day = Integer.parseInt(simpleDateFormat.format(startDate));
                        //1.5 day leave will be added to current month last day
                        if (diffInMonths > 7) {
                            ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.indiaTeamMonthlyAccrual));
                        } else {
                            if (((diffInMonths == 7)) & (day >= 1 && day <= 15)) {
                                ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.indiaTeamMonthlyAccrual));
                            }
                        }
                    }
                } else {
                    //All Other Branches
                    if (today.before(DateUtils.getNextDay(startDate, 30))) {
                        //New employee less than a month
                        Long daysWorkedInMonth = DateUtils.differenceInDays(startDate, today);
                        ptoAccruedTS.setHours(DateUtils.getProratedHours(TimeAccuralConstants.lessThanOneYearHoursAccural, new BigDecimal("30"), new BigDecimal(daysWorkedInMonth)));
                    } else if (today.before(DateUtils.getNextYear(startDate, 1))) {
                        if (ptoAccruedTS.getHours().add(TimeAccuralConstants.getPTOAccuredHours(TimeAccuralConstants.lessThanOneYearHoursAccural, emp)).compareTo(TimeAccuralConstants.lessThanOneYearAccuralMax(emp)) >= 0) {
                            ptoAccruedTS.setHours(TimeAccuralConstants.lessThanOneYearAccuralMax(emp));
                        } else {
                            ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.getPTOAccuredHours(TimeAccuralConstants.lessThanOneYearHoursAccural, emp)));
                        }
                    } else if (today.after(DateUtils.getNextYear(startDate, 1)) && today.before(DateUtils.getNextYear(startDate, 5))) {
                        if (ptoAccruedTS.getHours().add(TimeAccuralConstants.getPTOAccuredHours(TimeAccuralConstants.twoToFourYearsHoursAccural, emp)).compareTo(TimeAccuralConstants.twoToFourYearsHoursAccuralMax(emp)) >= 0) {
                            ptoAccruedTS.setHours(TimeAccuralConstants.twoToFourYearsHoursAccuralMax(emp));
                        } else {
                            ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.getPTOAccuredHours(TimeAccuralConstants.twoToFourYearsHoursAccural, emp)));
                        }
                    } else if (today.after(DateUtils.getNextYear(startDate, 5)) && today.before(DateUtils.getNextYear(startDate, 10))) {
                        if (ptoAccruedTS.getHours().add(TimeAccuralConstants.getPTOAccuredHours(TimeAccuralConstants.fiveToTenYearsHoursAccural, emp)).compareTo(TimeAccuralConstants.fiveToTenYearsHoursAccuralMax(emp)) >= 0) {
                            ptoAccruedTS.setHours(TimeAccuralConstants.fiveToTenYearsHoursAccuralMax(emp));
                        } else {
                            ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.getPTOAccuredHours(TimeAccuralConstants.fiveToTenYearsHoursAccural, emp)));
                        }
                    } else if (today.after(DateUtils.getNextYear(startDate, 10))) {
                        if (ptoAccruedTS.getHours().add(TimeAccuralConstants.getPTOAccuredHours(TimeAccuralConstants.moreThanTenYearsHoursAccural, emp)).compareTo(TimeAccuralConstants.moreThanTenYearsHoursAccuralMax(emp)) >= 0) {
                            ptoAccruedTS.setHours(TimeAccuralConstants.moreThanTenYearsHoursAccuralMax(emp));
                        } else {
                            ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.getPTOAccuredHours(TimeAccuralConstants.moreThanTenYearsHoursAccural, emp)));
                        }
                    }
                }
                dao.getEntityManager().merge(ptoAccruedTS);
                dao.addTimeSheetUpdateComment("System Monthly Update: ", beforeHours, ptoAccruedTS);
            }
        }
        sendEmailNotification("");
    }

    protected boolean hasMoreThanOneYearService(Employee emp) {
        //TODO possible bug for leap year???
        if (emp.getStartDate() != null && DateUtils.getNextYear(emp.getStartDate(), 1).before(new Date())) {
            return true;
        } else {
            return false;
        }
    }

    protected void sendEmailNotification(String msg) {
        Email email = new Email();
        email.addTo(OfficeServiceConfiguration.instance().getAdminEmail());
        email.setSubject("Successfully complete Monthly Leave Accrual on " + new Date());
        email.setBody(msg);
        MessagingService.instance().sendEmail(email);
    }

    public void revertRecentPTOAccruedChanges() {
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 5000, OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
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

    public void addCarryForwardLeaves() {
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 5000, OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            if (emp.getStartDate() == null) {
                continue;
            }
            if (Branch.Hyderabad.equals(emp.getBranch())) {
                CorporateTimeSheet ptoAccruedTS = dao.getPTOAccruedTimeSheet(emp);
                if (ptoAccruedTS != null) {

                    BigDecimal carryForward = new BigDecimal("40");
                    if (ptoAccruedTS.getHours().doubleValue() >= 40) {
                        ptoAccruedTS.setHours(carryForward);
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours());
                    }
                }
            }
        }
    }

    public static CorporateTimeAccuralService instance() {
        return SpringContext.getBean(CorporateTimeAccuralService.class);
    }

}
