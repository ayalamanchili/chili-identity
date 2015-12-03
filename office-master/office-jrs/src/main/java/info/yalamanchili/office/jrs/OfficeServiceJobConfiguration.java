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
import info.yalamanchili.office.dao.time.TimePeriodDao;
import info.yalamanchili.office.email.ReceiveEmailsService;
import info.yalamanchili.office.employee.perfeval.PerformanceEvaluationQuestionsFactory;
import info.yalamanchili.office.employee.probeval.ProbationPeriodEvaluationQuestionsFactory;
import info.yalamanchili.office.expense.expenserpt.ExpenseReportService;
import info.yalamanchili.office.reports.profile.ProfileReportsService;
import info.yalamanchili.office.toolbox.ClientContactDataTool;
import info.yalamanchili.office.toolbox.ClientDataTool;
import info.yalamanchili.office.toolbox.SubContractorContactDataTool;
import info.yalamanchili.office.toolbox.SubContractorDataTool;
import info.yalamanchili.office.toolbox.VendorContactDataTool;
import info.yalamanchili.office.toolbox.VendorDataTool;
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
    public void revertRecentMonthlyTimeAccrual() {
        CorporateTimeAccuralService.instance().revertRecentPTOAccruedChanges();
        AssociateTimeAccuralService.instance().revertRecentPTOAccruedChanges();
    }

    @ManagedOperation
    public void syncPerformanceEvaluationQuestions() {
        PerformanceEvaluationQuestionsFactory.instance().syncQuestions();
    }

    @ManagedOperation
    public void syncProbationPRDEvaluationQuestions() {
        ProbationPeriodEvaluationQuestionsFactory.instance().syncProbationQuestions();
    }

    @ManagedOperation
    public void syncNotificationGroupsForRoles() {
        NotificationGroupDao.instance().syncNotificationGroupsForRoles();
    }

    @ManagedOperation
    public void syncNotSubmitted() {
//        CorporateStatusReportDao.instance().notSubmittedReport();
    }

    @ManagedOperation
    public void syncNotificationGroupForRetirementPlanOptIns() {
        NotificationGroupDao.instance().syncRetirementPlanOptInNotificationGroup();
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

    @ManagedOperation
    public void sycnTimePeriods() {
        TimePeriodDao.instance().syncWeeklyTimePeriods();
    }

    @ManagedOperation
    public void sendIncompleteProfileEmails() {
        ProfileReportsService.instance().sendMissingProfileInfoEmail();
    }

    @ManagedOperation
    public void receiveEmails() {
        ReceiveEmailsService.instance().processNewMessages();
    }

    @ManagedOperation
    public void bisClientTableMigration() {
        ClientDataTool.instance().migrateClientData();
    }

    @ManagedOperation
    public void bisVendorTableMigration() {
        VendorDataTool.instance().migrateVendorData();
    }

    @ManagedOperation
    public void bisSubContractorTableMigration() {
        SubContractorDataTool.instance().migrateSubContractorData();
    }

    @ManagedOperation
    public void bisClientContactMigration() {
        ClientContactDataTool.instance().migrateClientContactData();
    }

    @ManagedOperation
    public void bisVendorContactMigration() {
        VendorContactDataTool.instance().migrateVendorContactData();
    }

    @ManagedOperation
    public void bisSubContractorContactMigration() {
        SubContractorContactDataTool.instance().migrateSubContractorContactData();
    }

    @ManagedOperation
    public void refreshExpenseReportBPMProcessEntities() {
        ExpenseReportService.instance().refreshExpenseReportBPMProcessEntities();
    }
}
