package org.com.cay.dao.impl;

import java.util.List;

import org.com.cay.dao.ProductDAO;
import org.com.cay.entity.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from Product";

		Query query = session.createQuery(hql);
		List<Product> products = (List<Product>) query.list();
		return products;
	}

	@Override
	public void modifyProducts(List<Product> products,
			List<Integer> modifyAmounts) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			for (Product product : products) {
				int preAmounts = product.getAmounts();
				int modifyAmount = modifyAmounts.get(products.indexOf(product));

				if (preAmounts + modifyAmount < 0)
					throw new InvalidataNumberException("数值错误");

				product.setAmounts(preAmounts + modifyAmount);
				session.update(product);
			}
			tx.commit();
		} catch (InvalidataNumberException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}

	}

}

class InvalidataNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidataNumberException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
