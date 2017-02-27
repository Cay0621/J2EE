package demo2.x.com;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import demo2.x.com.util.Demo2Tool;

public class Demo2Action extends ActionSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gotoUrl;

	public String getGotoUrl() {
		return gotoUrl;
	}

	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}

	public String mainHome() {
		HttpServletRequest request = ServletActionContext.getRequest();

		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("ssocookie")) {
					String result = Demo2Tool.doGet("http://check.x.com/sso/checkCookie.action", cookie.getName(),
							cookie.getValue());
					if (result.equals("1")) {
						return SUCCESS;
					}

				}
			}
		}

		gotoUrl = "http://demo2.x.com/demo2/main.action";
		return LOGIN;
	}
}
