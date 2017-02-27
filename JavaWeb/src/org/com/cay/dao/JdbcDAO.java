package org.com.cay.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface JdbcDAO {
	public boolean updateByPreparedStatement(String sql, List<?> params) throws SQLException;
	
	public List<Map<String, Object>> findResult(String sql, List<?> params) throws SQLException;
}
