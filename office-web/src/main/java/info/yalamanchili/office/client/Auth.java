package info.yalamanchili.office.client;

public class Auth {

    public enum ROLE {

        ROLE_USER, ROLE_HR, ROLE_EXPENSE, ROLE_ADMIN, ROLE_RECRUITER, ROLE_TIME
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

    public static boolean hasOnlyUserRole() {
        if (OfficeWelcome.instance().roles.size() == 1 && OfficeWelcome.instance().roles.contains(ROLE.ROLE_USER.name())) {
            return true;
        } else {
            return false;
        }
    }
}
