package info.yalamanchili.office.client;

public class Auth {
	private enum ROLES {
		ROLE_USER, ROLE_HR, ROLE_ACCCOUNTS, ROLE_ADMIN
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
}
