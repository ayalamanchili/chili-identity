/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.utils.JSONUtils;

public class Auth {

    public enum ROLE {

        ROLE_USER, ROLE_CORPORATE_EMPLOYEE, ROLE_HR, ROLE_EXPENSE, ROLE_ADMIN, ROLE_RECRUITER, ROLE_TIME, ROLE_DRIVE, ROLE_RELATIONSHIP,
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

    public static boolean isAdmin() {
        return OfficeWelcome.instance().roles.contains(ROLE.ROLE_ADMIN.name());
    }

    public static boolean isEmployee(JSONObject emp) {
        String employeeType = JSONUtils.toString(emp.get("employeeType"), "name");
        return employeeType.equals("Employee") || employeeType.equals("Corporate Employee") || employeeType.equals("Intern-Seasonal Employee");
    }

    public static boolean isHR() {
        return OfficeWelcome.instance().roles.contains(ROLE.ROLE_HR.name());
    }

    public static boolean hasAnyOfRoles(ROLE... roles) {
        for (ROLE role : roles) {
            if (OfficeWelcome.instance().roles.contains(role.name())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAccountant() {
        return OfficeWelcome.instance().roles.contains(ROLE.ROLE_EXPENSE.name());
    }

    public static boolean hasContractsRole() {
        return OfficeWelcome.instance().roles.contains(ROLE.ROLE_TIME.name());
    }

    public static boolean isRelationshipTeam() {
        return OfficeWelcome.instance().roles.contains(ROLE.ROLE_RELATIONSHIP.name());
    }

    public static boolean hasOnlyUserRole() {
        return OfficeWelcome.instance().roles.size() == 1 && OfficeWelcome.instance().roles.contains(ROLE.ROLE_USER.name());
    }
    /*
     * return true for users with more that just user role
     */

    public static boolean hasNonUserRoles() {
        return OfficeWelcome.instance().roles.size() > 1;
    }

    public static boolean isCorporateEmployee(JSONObject employee) {
        return JSONUtils.toString(employee.get("employeeType"), "name").trim().equals("Corporate Employee");
    }
    
    public static boolean isInternEmployee(JSONObject employee) {
        return JSONUtils.toString(employee.get("employeeType"), "name").trim().equals("Intern-Seasonal Employee");
    }    

    public static boolean isCorporateEmployee() {
        return OfficeWelcome.instance().roles.contains(ROLE.ROLE_CORPORATE_EMPLOYEE.name());
    }

    public static boolean isConsultantEmployee(JSONObject employee) {
        return JSONUtils.toString(employee.get("employeeType"), "name").trim().equals("Employee");
    }

    public static boolean isConsultantEmployee() {
        return JSONUtils.toString(OfficeWelcome.instance().employee.get("employeeType"), "name").equals("Employee");
    }

    public static boolean isSubContractor(JSONObject emp) {
        String empType = JSONUtils.toString(emp.get("employeeType"), "name");
        return empType != null && empType.trim().equals("Subcontractor");
    }

    public static boolean is1099(JSONObject emp) {
        String empType = JSONUtils.toString(emp.get("employeeType"), "name");
        return empType != null && empType.trim().equals("1099 Contractor");
    }

    public static boolean isW2Contractor(JSONObject emp) {
        String empType = JSONUtils.toString(emp.get("employeeType"), "name");
        return empType != null && empType.trim().equals("W2 Contractor");
    }

    public static boolean isW2Contractor() {
        return JSONUtils.toString(OfficeWelcome.instance().employee.get("employeeType"), "name").equals("W2 Contractor");
    }

    public static boolean isItDeveloper() {
        return OfficeWelcome.instance().roles.contains(ROLE.ROLE_IT_DEVELOPER.name());
    }

    public static String[] getAllRoles() {
        String[] roles = new String[ROLE.values().length];
        int i = 0;
        for (ROLE role : ROLE.values()) {
            roles[i] = role.name();
            i++;
        }
        return roles;
    }
}
