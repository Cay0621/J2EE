package org.com.cay.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	static {
		Properties props = new Properties();
		try {
			props.load(JdbcUtil.class.getClassLoader().getResourceAsStream(
					"db.properties"));
			driver = props.getProperty("mysql.driver");
			url = props.getProperty("mysql.url");
			user = props.getProperty("mysql.user");
			password = props.getProperty("mysql.password");
			Class.forName(driver);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("读取配置文件异常");
		}

	}

	public static Connection getConnection() {
		Connection conn = null;
		try {			
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection conn = JdbcUtil.getConnection();
		System.out.println(conn);
	}
}
