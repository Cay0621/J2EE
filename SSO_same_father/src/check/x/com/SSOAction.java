package check.x.com;

import java.io.IOException;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import check.x.com.util.SSOCheck;

public class SSOAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String gotoUrl;

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doLogin() {
		boolean ok = SSOCheck.checkLogin(username, password);
		if (ok) {
			Cookie cookie = new Cookie("ssocookie", "sso");
			// 设置到父域
			cookie.setDomain(".x.com");
			// 设置到父域顶层
			cookie.setPath("/");
			ServletActionContext.getResponse().addCookie(cookie);

			return SUCCESS;
		}
		return null;
	}

	private String cookieName;
	private String cookieValue;

	public String getCookieName() {
		return cookieName;
	}

	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}

	public String getCookieValue() {
		return cookieValue;
	}

	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}

	public void checkCookie() throws IOException {
		boolean ok = SSOCheck.checkCookie(cookieName, cookieValue);
		String result = "0";
		if (ok) {
			result = "1";
		}

		ServletActionContext.getResponse().getWriter().print(result);
	}
}
