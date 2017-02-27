package org.com.cay.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.com.cay.dao.CostDAO;
import org.com.cay.dao.JdbcDAO;
import org.com.cay.entity.Cost;
import org.com.cay.entity.Pager;

public class SublistCostDAOImpl implements CostDAO {

	@Override
	public Pager<Cost> findCost(Cost costModel, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		List<Cost> costList = findAll(costModel);
		Pager<Cost> pager = new Pager<Cost>(pageNum, pageSize, costList);

		return pager;
	}

	// 模仿获取所有的数据
	public List<Cost> findAll(Cost costModel) {
		List<Cost> costList = new ArrayList<Cost>();
		List<Object> paramList = new ArrayList<Object>();
		String name = costModel.getName();

		StringBuilder sql = new StringBuilder("select * from cost where 1=1");
		if (name != null && !name.equals("")) {
			sql.append(" and NAME like ?");
			paramList.add("%" + name + "%");
		}

		JdbcDAO dao = new JdbcDAOImpl();
		try {
			List<Map<String, Object>> mapList = dao.findResult(sql.toString(),
					paramList);
			if (mapList != null) {
				for (Map<String, Object> map : mapList) {
					Cost cost = new Cost(map);
					costList.add(cost);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据异常", e);
		}

		return costList;
	}

}
