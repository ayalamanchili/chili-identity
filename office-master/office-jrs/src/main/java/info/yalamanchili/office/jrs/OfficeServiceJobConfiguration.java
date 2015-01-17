/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import info.yalamanchili.office.Time.AssociateTimeAccuralService;
import info.yalamanchili.office.Time.CorporateTimeAccuralService;
import info.yalamanchili.office.Time.TimeJobService;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.profile.SkillSetDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.employee.perfeval.PerformanceEvaluationQuestionsFactory;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class OfficeServiceJobConfiguration {

    @ManagedOperation
    public void processMonthlyTimeAccrual() {
        CorporateTimeAccuralService.instance().accureMonthlyTime();
        AssociateTimeAccuralService.instance().accureMonthlyConsTime();
    }

    @ManagedOperation
    public void processYearlyTimeAccrualForIndiaTeam() {
        CorporateTimeAccuralService.instance().accrueYearlyPTO();
    }

    @ManagedOperation
    public void revertRecentMonthlyTimeAccrual() {
        CorporateTimeAccuralService.instance().revertRecentPTOAccruedChanges();
        AssociateTimeAccuralService.instance().revertRecentPTOAccruedChanges();
    }

    @ManagedOperation
    public void syncPerformanceEvaluationQuestions() {
        PerformanceEvaluationQuestionsFactory.instance().syncQuestions();
    }

    @ManagedOperation
    public void syncNotificationGroupsForRoles() {
        NotificationGroupDao.instance().syncNotificationGroupsForRoles();
    }

    @ManagedOperation
    public void syncCorpEmployeeRoles() {
        EmployeeDao.instance().syncCorpEmployeeRoles();
    }

    @ManagedOperation
    public void sendTodaysLeaveNotifications() {
        TimeJobService.instance().sendTodaysLeaveNotifications();
    }

    @ManagedOperation
    public void syncUserCerts() {
        OfficeSecurityService.instance().syncUserCerts();
    }

    @ManagedOperation
    public void createCert(String employeeId) {
        OfficeSecurityService.instance().createUserCert(employeeId);
    }

    /**
     * indexes all resumes for all existing skill sets
     */
    @ManagedOperation
    public void indexAllResumes() {
        SkillSetDao.instance().indexAllResumes();
    }
}
