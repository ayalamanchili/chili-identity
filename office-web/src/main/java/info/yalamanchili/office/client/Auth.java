package info.yalamanchili.office.client;

public class Auth {
	private enum ROLES {
		USER, HR, ACCCOUNTS, ADMIN
	}

	public static boolean isAdmin() {
		if (OfficeWelcome.instance().roles.contains(ROLES.ADMIN.name())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isHR() {
		if (OfficeWelcome.instance().roles.contains(ROLES.HR.name())) {
			return true;
		} else {
			return false;
		}
	}
}
