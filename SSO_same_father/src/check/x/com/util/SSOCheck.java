package check.x.com.util;

public class SSOCheck {

	public static final String USERNAME = "admin";
	public static final String PASSWORD = "123";

	public static boolean checkLogin(String username, String password) {
		if (USERNAME.equals(username) && PASSWORD.equals(password))
			return true;
		else
			return false;
	}

	public static boolean checkCookie(String cookieName, String cookieValue) {
		if (cookieName.equals("ssocookie") && cookieValue.equals("sso")) {
			return true;
		}
		return false;
	}
}
