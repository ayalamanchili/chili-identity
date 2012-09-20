package info.yalamanchili.office.client;

public class Auth {

    public enum ROLE {

        ROLE_USER, ROLE_HR, ROLE_ACCOUNTANT, ROLE_ADMIN, ROLE_RECRUITER, ROLE_PAYROLL
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
        if (OfficeWelcome.instance().roles.contains(ROLE.ROLE_ACCOUNTANT.name())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPayroll() {
        if (OfficeWelcome.instance().roles.contains(ROLE.ROLE_PAYROLL.name())) {
            return true;
        } else {
            return false;
        }
    }
}
