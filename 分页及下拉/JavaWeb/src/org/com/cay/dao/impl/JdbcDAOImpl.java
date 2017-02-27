package org.com.cay.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.com.cay.dao.JdbcDAO;
import org.com.cay.util.JdbcUtil;


public class JdbcDAOImpl implements JdbcDAO {

	@Override
	public boolean updateByPreparedStatement(String sql, List<?> params) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		if(params != null && !params.isEmpty())
		{
			for (int i = 0; i < params.size(); ++i){
				stmt.setObject(i + 1, params.get(i));
			}
		}
		int result = stmt.executeUpdate();
		flag = result > 0 ? true : false;
		JdbcUtil.closeConnection(conn);
		return flag;
	}

	@Override
	public List<Map<String, Object>> findResult(String sql, List<?> params) throws SQLException {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		if(params != null && !params.isEmpty())
		{
			for (int i = 0; i < params.size(); ++i){
				stmt.setObject(i + 1, params.get(i));
			}
		}
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rmd = rs.getMetaData();
		int cols = rmd.getColumnCount();
		while(rs.next()){
			Map<String, Object> map = new HashMap<String, Object>();
			for(int i = 0;i < cols; ++i){
				String cols_name = rmd.getColumnName(i + 1);
				Object cols_value = rs.getObject(cols_name);
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		
		if(stmt != null){
			stmt.close();
		}
		if(rs != null){
			rs.close();
		}
		
		JdbcUtil.closeConnection(conn);
		return list;
	}

}
