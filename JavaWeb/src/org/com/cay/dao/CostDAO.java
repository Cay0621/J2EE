package org.com.cay.dao;

import org.com.cay.entity.Cost;
import org.com.cay.entity.Pager;

public interface CostDAO {
	/***
	 * 
	 * @param costModel:封装查询条件
	 * @param pageNum：第几页
	 * @param pageSize：每页显示多少记录
	 * @return 查询结果
	 */
	public Pager<Cost> findCost(Cost costModel, int pageNum, int pageSize);
}
