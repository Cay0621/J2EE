package org.com.cay.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.com.cay.dao.CostDAO;
import org.com.cay.entity.Cost;
import org.com.cay.entity.Pager;
import org.com.cay.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class HibernateCostDAOImpl implements CostDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Cost> findCost(Cost costModel, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		Pager<Cost> result = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();

		// 封装查询条件
		String name = costModel.getName();
		StringBuilder hql = new StringBuilder("from Cost where 1=1");
		StringBuilder countHql = new StringBuilder(
				"select count(id) as totalRecord from Cost where 1=1");

		if (name != null && !name.equals("")) {
			hql.append(" and name like :name");
			countHql.append(" and name like :name");
			paramMap.put("name", "%" + name + "%");
		}

		//
		int fromIndex = pageSize * (pageNum - 1);

		List<Cost> costList = new ArrayList<Cost>();
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			Query hqlQuery = session.createQuery(hql.toString());
			Query countHqlQuery = session.createQuery(countHql.toString());

			setQueryParams(hqlQuery, paramMap);
			setQueryParams(countHqlQuery, paramMap);

			hqlQuery.setFirstResult(fromIndex);
			hqlQuery.setMaxResults(pageSize);

			// 获取查询结果
			costList = hqlQuery.list();

			// 获取记录总条数
			int totalRecord = Integer.parseInt(countHqlQuery.uniqueResult().toString());

			int totalPages = totalRecord / pageSize;
			if (totalRecord % pageSize != 0)
				totalPages++;

			result = new Pager<Cost>(pageSize, pageNum, totalRecord,
					totalPages, costList);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据异常", e);
		} finally {
//			HibernateUtil.closeSession();
			if(session != null)
				session.close();
		}

		return result;
	}

	private void setQueryParams(Query query, Map<String, Object> paramMap) {
		if (paramMap != null && !paramMap.isEmpty()) {
			for (String key : paramMap.keySet()) {
				query.setParameter(key, paramMap.get(key));
			}
		}
	}

}
