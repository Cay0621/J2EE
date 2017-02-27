package org.com.cay.tag;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class DBConnectionTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String driver;
	private String url;
	private String username;
	private String password;
	private String sql;

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(url, username, password);

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				while (rs.next()) {
					pageContext.getOut().print(rs.getString("name") + "<br/>");
				}
			}
			return EVAL_PAGE;

		} catch (SQLException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return SKIP_PAGE;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// return super.doEndTag();
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}
