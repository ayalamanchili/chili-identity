/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.commons.DateUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
public class CorporateTimeAccuralService {

    //TODO support for proration hours
    //TODO avoid duplicate creation
    public void accureMonthlyTime() {
        CorporateTimeSheetDao dao = CorporateTimeSheetDao.instance();
        for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 5000, OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            if (emp.getStartDate() == null) {
                continue;
            }
            Date startDate = emp.getStartDate();
            int numberOfMonthsCompleted = DateUtils.differenceInMonths(new Date(), startDate);
            CorporateTimeSheet ptoAccruedTS = dao.getPTOAccruedTimeSheet(emp);
            if (ptoAccruedTS != null) {
                BigDecimal beforeHours = ptoAccruedTS.getHours();
                if (numberOfMonthsCompleted < 12) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.lessThanOneYearHoursAccural).compareTo(TimeAccuralConstants.lessThanOneYearHoursAccuralMax) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.lessThanOneYearHoursAccuralMax);
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.lessThanOneYearHoursAccural));
                    }

                } else if (numberOfMonthsCompleted >= 12 && numberOfMonthsCompleted < 60) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.twoToFourYearsHoursAccural).compareTo(TimeAccuralConstants.twoToFourYearsHoursAccuralMax) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.twoToFourYearsHoursAccuralMax);
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.twoToFourYearsHoursAccural));
                    }
                } else if (numberOfMonthsCompleted >= 60 && numberOfMonthsCompleted < 120) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.fiveToTenYearsHoursAccural).compareTo(TimeAccuralConstants.fiveToTenYearsHoursAccuralMax) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.fiveToTenYearsHoursAccuralMax);
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.twoToFourYearsHoursAccural));

                    }
                } else if (numberOfMonthsCompleted >= 120) {
                    if (ptoAccruedTS.getHours().add(TimeAccuralConstants.moreThanTenYearsHoursAccural).compareTo(TimeAccuralConstants.moreThanTenYearsHoursAccuralMax) >= 0) {
                        ptoAccruedTS.setHours(TimeAccuralConstants.moreThanTenYearsHoursAccuralMax);
                    } else {
                        ptoAccruedTS.setHours(ptoAccruedTS.getHours().add(TimeAccuralConstants.moreThanTenYearsHoursAccural));
                    }
                }
                BigDecimal afterHours = ptoAccruedTS.getHours();
                CommentDao.instance().addComment("System update on " + new Date() + " from: " + beforeHours + " hours to:" + afterHours + " hours :difference: " + afterHours.subtract(beforeHours), ptoAccruedTS);
            }
        }
    }

    public static CorporateTimeAccuralService instance() {
        return SpringContext.getBean(CorporateTimeAccuralService.class);
    }
}
