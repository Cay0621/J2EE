package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;
import entity.Product;

public class ProductDAO {
	
	public List<Product> findAll() throws Exception {
		List<Product> products = null;
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM t_product");
			
			products = new ArrayList<Product>();
			
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPic(rs.getString("pic"));
				p.setPrice(rs.getDouble("price"));
				p.setDesc(rs.getString("desc"));
				products.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeConnection(conn);
		}
		return products;
	}

	public Product findById(int id) throws Exception{
		// TODO Auto-generated method stub
		Connection conn = null;
		Product p = null;

		try {
			conn = DBUtils.getConnection();
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM t_product where id=" + id);
			
			if (rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPic(rs.getString("pic"));
				p.setPrice(rs.getDouble("price"));
				p.setDesc(rs.getString("desc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtils.closeConnection(conn);
		}
		return p;
	}
}
