/**
 * test System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ayalamanchili
 */
public class OfficeRoles {

    public enum OfficeRole {

        ROLE_USER,
        ROLE_CORPORATE_EMPLOYEE,
        ROLE_ADMIN,
        ROLE_HR,
        ROLE_RECRUITER,
        ROLE_TIME, // Contracts?
        ROLE_EXPENSE,// Accounts?
        ROLE_DRIVE,
        ROLE_RELATIONSHIP,
        //NEW _ROLES
        ROLE_HR_ADMINSTRATION,
        ROLE_H1B_IMMIGRATION,
        ROLE_GC_IMMIGRATION,
        ROLE_PAYROLL_AND_BENIFITS,
        ROLE_ACCOUNTS_RECEIVABLE,
        ROLE_ACCOUNTS_PAYABLE,
        ROLE_SALES_AND_MARKETING,
        ROLE_CONTRACTS_ADMIN,
        ROLE_INFORMATION_TECHNOLOGY,
        ROLE_SYSTEM_AND_NETWORK_ADMIN,
        ROLE_CORPORATE_TIME_REPORTS,
        ROLE_CONSULTANT_TIME_REPORTS,
        ROLE_CONSULTANT_TIME_ADMIN,
        ROLE_IT_DEVELOPER,
        ROLE_CORPORATE_DATA,
        ROLE_PRB_EVALUATIONS_MANAGER,
        ROLE_HEALTH_INSURANCE_MANAGER,
        ROLE_BULK_IMPORT,
        ROLE_CHILI_ADMIN,
        ROLE_CRP_STATUS_RPT_MGR,
        ROLE_CEO,
        ROLE_ON_BOARDING_MGR,
        ROLE_E_VERIFY_MGR,
        ROLE_BACKGROUND_SCREENING_MGR,
        ROLE_GENERAL_EXPENSE_MANAGER,
        ROLE_TRAVEL_BOOKING_MANAGER,
        ROLE_SELFSERVICE_TRIAGE,
        ROLE_BIS_VIEW,
        ROLE_PROSPECTS_MANAGER,
        ROLE_CONTRACTS_FULL_VIEW,
        ROLE_BILLING_AND_INVOICING,
        ROLE_CONTRACTS,
        ROLE_BILLING_ADMIN,
        ROLE_CORPORATE_TIME_ADMIN,
        ROLE_INVOICE_MANAGER
    }
    public final static Map<String, String> rolesMessages = new HashMap<String, String>();

    static {
        rolesMessages.put(OfficeRole.ROLE_USER.name(), "User");
        rolesMessages.put(OfficeRole.ROLE_CORPORATE_EMPLOYEE.name(), "Corporate Employee");
        rolesMessages.put(OfficeRole.ROLE_ADMIN.name(), "Admin");
        rolesMessages.put(OfficeRole.ROLE_HR.name(), "HR");
        rolesMessages.put(OfficeRole.ROLE_RECRUITER.name(), "Recruiter");
        rolesMessages.put(OfficeRole.ROLE_TIME.name(), "Time");
        rolesMessages.put(OfficeRole.ROLE_EXPENSE.name(), "Expense");
        rolesMessages.put(OfficeRole.ROLE_DRIVE.name(), "Drive");
        rolesMessages.put(OfficeRole.ROLE_RELATIONSHIP.name(), "Engagement");
        rolesMessages.put(OfficeRole.ROLE_HR_ADMINSTRATION.name(), "HR Administration");
        rolesMessages.put(OfficeRole.ROLE_H1B_IMMIGRATION.name(), "H1B Immigration");
        rolesMessages.put(OfficeRole.ROLE_GC_IMMIGRATION.name(), "GC Immigration");
        rolesMessages.put(OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name(), "Payroll and Benefits");
        rolesMessages.put(OfficeRole.ROLE_ACCOUNTS_RECEIVABLE.name(), "Accounts Receivable");
        rolesMessages.put(OfficeRole.ROLE_ACCOUNTS_PAYABLE.name(), "Accounts Payable");
        rolesMessages.put(OfficeRole.ROLE_SALES_AND_MARKETING.name(), "Sales and Marketing");
        rolesMessages.put(OfficeRole.ROLE_CONTRACTS_ADMIN.name(), "Contracts Administration");
        rolesMessages.put(OfficeRole.ROLE_INFORMATION_TECHNOLOGY.name(), "Information Technology");
        rolesMessages.put(OfficeRole.ROLE_SYSTEM_AND_NETWORK_ADMIN.name(), "System and Network Administration");
        rolesMessages.put(OfficeRole.ROLE_CORPORATE_TIME_REPORTS.name(), "Corporate Time Reports");
        rolesMessages.put(OfficeRole.ROLE_CONSULTANT_TIME_ADMIN.name(), "Consultant Time Admin");
        rolesMessages.put(OfficeRole.ROLE_CONSULTANT_TIME_REPORTS.name(), "Consultant Time Reports");
        rolesMessages.put(OfficeRole.ROLE_IT_DEVELOPER.name(), "IT Developer");
        rolesMessages.put(OfficeRole.ROLE_CORPORATE_DATA.name(), "Corporate Data");
        rolesMessages.put(OfficeRole.ROLE_PRB_EVALUATIONS_MANAGER.name(), "Probation Evalations Manager");
        rolesMessages.put(OfficeRole.ROLE_HEALTH_INSURANCE_MANAGER.name(), "Health Insurance Manager");
        rolesMessages.put(OfficeRole.ROLE_BULK_IMPORT.name(), "Bulk Import Manager");
        rolesMessages.put(OfficeRole.ROLE_CHILI_ADMIN.name(), "Chili Admin");
        rolesMessages.put(OfficeRole.ROLE_CRP_STATUS_RPT_MGR.name(), " Status Report Manager");
        rolesMessages.put(OfficeRole.ROLE_CEO.name(), "CEO");
        rolesMessages.put(OfficeRole.ROLE_ON_BOARDING_MGR.name(), "On Boarding Manager");
        rolesMessages.put(OfficeRole.ROLE_E_VERIFY_MGR.name(), "E Verify Manager");
        rolesMessages.put(OfficeRole.ROLE_BACKGROUND_SCREENING_MGR.name(), "BackGround Screening Manager");
        rolesMessages.put(OfficeRole.ROLE_GENERAL_EXPENSE_MANAGER.name(), "General Expense Manager");
        rolesMessages.put(OfficeRole.ROLE_TRAVEL_BOOKING_MANAGER.name(), "Travel Booking Manager");
        rolesMessages.put(OfficeRole.ROLE_SELFSERVICE_TRIAGE.name(), "SelfService Triage");
        rolesMessages.put(OfficeRole.ROLE_BIS_VIEW.name(), "BIS View");
        rolesMessages.put(OfficeRole.ROLE_PROSPECTS_MANAGER.name(), "Prospects Manager");
        rolesMessages.put(OfficeRole.ROLE_CONTRACTS_FULL_VIEW.name(), "Contracts Full View");
        rolesMessages.put(OfficeRole.ROLE_BILLING_AND_INVOICING.name(), "Billing and Invoicing");
        rolesMessages.put(OfficeRole.ROLE_CONTRACTS.name(), "Contracts");
        rolesMessages.put(OfficeRole.ROLE_BILLING_ADMIN.name(), "Billing Admin");
        rolesMessages.put(OfficeRole.ROLE_CORPORATE_TIME_ADMIN.name(), "Corporate Time Admin");
        rolesMessages.put(OfficeRole.ROLE_INVOICE_MANAGER.name(), "Invoice Manager");        
    }
}
