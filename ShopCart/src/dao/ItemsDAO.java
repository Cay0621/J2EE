package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBHelper;

import entity.Items;

//商品业务逻辑类
public class ItemsDAO {

	// 获取所有商品信息
	public ArrayList<Items> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>(); // 商品集合
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				list.add(item);// 把商品添加到集合
			}
			return list; // 返回集合
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 释放结果集
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

	}

	// 根据商品的id获取商品信息
	public Items getItemsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items where id=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				return item;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
	}

	//获取最近浏览的前5条记录
	public ArrayList<Items> getViewList(String list) {
		//System.out.println("list:" + list);
		ArrayList<Items> itemlist = new ArrayList<Items>();
		int iCount = 5; //
		if (list != null && list.length() > 0) {
			String[] arr = list.split(",");
			//System.out.println("arr.length=" + arr.length);
			//
			if (arr.length >= 5) {
				for (int i = arr.length - 1; i >= arr.length - iCount; i--) {
					itemlist.add(getItemsById(Integer.parseInt(arr[i])));
				}
			} else {
				for (int i = arr.length - 1; i >= 0; i--) {
					itemlist.add(getItemsById(Integer.parseInt(arr[i])));
				}
			}
			return itemlist;
		} else {
			return null;
		}
	}

}
