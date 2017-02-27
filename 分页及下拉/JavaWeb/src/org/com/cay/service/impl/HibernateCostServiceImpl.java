package org.com.cay.service.impl;

import org.com.cay.dao.CostDAO;
import org.com.cay.dao.impl.HibernateCostDAOImpl;
import org.com.cay.entity.Cost;
import org.com.cay.entity.Pager;
import org.com.cay.service.CostService;

public class HibernateCostServiceImpl implements CostService {

	private CostDAO costDAO;

	public CostDAO getCostDAO() {
		return costDAO;
	}

	public void setCostDAO(CostDAO costDAO) {
		this.costDAO = costDAO;
	}
	
	public HibernateCostServiceImpl() {
		// TODO Auto-generated constructor stub
		costDAO = new HibernateCostDAOImpl();
	}
	
	@Override
	public Pager<Cost> findCost(Cost costModel, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		Pager<Cost> result = costDAO.findCost(costModel, pageNum, pageSize);
		return result;
	}

}
