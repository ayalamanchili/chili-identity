/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.utils.JSONUtils;

public class Auth {

    public enum ROLE {

        ROLE_USER, ROLE_HR, ROLE_EXPENSE, ROLE_ADMIN, ROLE_RECRUITER, ROLE_TIME, ROLE_RELATIONSHIP,ROLE_ACCOUNT_VIEW
    }

    public static boolean isAdmin() {
        if (OfficeWelcome.instance().roles.contains(ROLE.ROLE_ADMIN.name())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isHR() {
        if (OfficeWelcome.instance().roles.contains(ROLE.ROLE_HR.name())) {
            return true;
        } else {
            return false;
        }
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
        if (OfficeWelcome.instance().roles.contains(ROLE.ROLE_EXPENSE.name())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPayroll() {
        if (OfficeWelcome.instance().roles.contains(ROLE.ROLE_TIME.name())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isRelationshipTeam() {
        if (OfficeWelcome.instance().roles.contains(ROLE.ROLE_RELATIONSHIP.name())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean hasOnlyUserRole() {
        if (OfficeWelcome.instance().roles.size() == 1 && OfficeWelcome.instance().roles.contains(ROLE.ROLE_USER.name())) {
            return true;
        } else {
            return false;
        }
    }
    /*
     * return true for users with more that just user role
     */

    public static boolean hasNonUserRoles() {
        if (OfficeWelcome.instance().roles.size() > 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isCorporateEmployee() {
        if (JSONUtils.toString(OfficeWelcome.instance().employee.get("employeeType"), "name").equals("Corporate Employee")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSubContractor(JSONObject emp) {
        String empType = JSONUtils.toString(emp.get("employeeType"), "name");
        if (empType != null && empType.equals("Subcontractor")) {
            return true;
        }
        return false;
    }

    public static boolean is1099(JSONObject emp) {
        String empType = JSONUtils.toString(emp.get("employeeType"), "name");
        if (empType != null && empType.equals("1099")) {
            return true;
        }
        return false;
    }
}
