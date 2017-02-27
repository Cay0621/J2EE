package org.com.cay.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.com.cay.dao.CostDAO;
import org.com.cay.dao.JdbcDAO;
import org.com.cay.entity.Cost;
import org.com.cay.entity.Pager;

/**
 * 使用sql语句
 * @author Cam
 *
 */
public class JdbcSqlCostDAOImpl implements CostDAO {

	@Override
	public Pager<Cost> findCost(Cost costModel, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		Pager<Cost> result = null;
		List<Object> paramList = new ArrayList<Object>();
		String name = costModel.getName();

		StringBuilder sql = new StringBuilder("select * from cost where 1=1");
		StringBuilder countsql = new StringBuilder("select count(id) as totalRecord from cost where 1=1");
		
		if (name != null && !name.equals("")) {
			sql.append(" and NAME like ?");
			countsql.append(" and NAME like ?");
			paramList.add("%" + name + "%");
		}
		
		int fromIndex = pageSize * (pageNum - 1);
		//mysql中的limit分页
		sql.append(" limit " + fromIndex + "," + pageSize);
		
		JdbcDAO dao = new JdbcDAOImpl();
		List<Cost> costList = new ArrayList<Cost>();
		try {
			List<Map<String, Object>> countResult = dao.findResult(countsql.toString(),
					paramList);
			Map<String, Object> countMap = countResult.get(0);
			
			int totalRecord = ((Number)countMap.get("totalRecord")).intValue();
			
			List<Map<String, Object>> costResult = dao.findResult(sql.toString(),
					paramList);
			if (costResult != null) {
				for (Map<String, Object> map : costResult) {
					Cost cost = new Cost(map);
					costList.add(cost);
				}
			}
			
			int totalPages = totalRecord / pageSize;
			if (totalRecord % pageSize != 0)
				totalPages++;
			
			result = new Pager<Cost>(pageSize, pageNum, totalRecord, totalPages, costList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据异常", e);
		}

		return result;
	}

}
