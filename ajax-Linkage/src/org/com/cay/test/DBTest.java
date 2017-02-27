package org.com.cay.test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.com.cay.dao.DBManager;
import org.junit.Test;

public class DBTest {

	@Test
	public void test() throws SQLException {
		Connection conn = DBManager.getInstance().getConnection();
		
		PreparedStatement stmt = conn.prepareStatement("select * from province");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("name"));
		}
		
		DbUtils.closeQuietly(conn);
	}

}
