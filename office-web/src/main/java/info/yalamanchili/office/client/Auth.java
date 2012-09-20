package info.yalamanchili.office.client;

public class Auth {
	private enum ROLES {
		ROLE_USER, ROLE_HR, ROLE_ACCOUNTANT, ROLE_ADMIN,ROLE_PAYROLL
	}

	public static boolean isAdmin() {
		if (OfficeWelcome.instance().roles.contains(ROLES.ROLE_ADMIN.name())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isHR() {
		if (OfficeWelcome.instance().roles.contains(ROLES.ROLE_HR.name())) {
			return true;
		} else {
			return false;
		}
	}
        public static boolean isAccountant() {
		if (OfficeWelcome.instance().roles.contains(ROLES.ROLE_ACCOUNTANT.name())) {
			return true;
		} else {
			return false;
		}
	}
        public static boolean isPayroll() {
		if (OfficeWelcome.instance().roles.contains(ROLES.ROLE_PAYROLL.name())) {
			return true;
		} else {
			return false;
		}
	}
       
}
