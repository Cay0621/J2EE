package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;
import entity.User;

public class UserDAO {
	public User findByUsername(String username) {
		User user = null;
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM f_user WHERE username=?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, username);

			ResultSet rs = state.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(username);
				user.setPwd(rs.getString("pwd"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setGender(rs.getString("gender"));
				user.setPhone(rs.getString("phone"));
				user.setAsk(rs.getString("ask"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return user;
	}

	public int save(User user) {
		Connection conn = null;
		int id = 0;
		try {
			conn = DBUtils.getConnection();
			String sql = "INSERT INTO f_user(username,pwd,name,age,gender,phone,ask) VALUES(?,?,?,?,?,?,?)";

			// 第二个参数用来获取自动生成的键
			PreparedStatement state = conn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			state.setString(1, user.getUsername());
			state.setString(2, user.getPwd());
			state.setString(3, user.getName());
			state.setInt(4, user.getAge());
			state.setString(5, user.getGender());
			state.setString(6, user.getPhone());
			state.setString(7, user.getAsk());

			state.executeUpdate();

			// 获取自动生成的键
			ResultSet rs = state.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return id;
	}

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM f_user";
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPwd(rs.getString("pwd"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setGender(rs.getString("gender"));
				user.setPhone(rs.getString("phone"));
				user.setAsk(rs.getString("ask"));

				users.add(user);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return users;
	}

	public User findByUserId(int id) {
		User user = null;
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM f_user WHERE id=?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, id);

			ResultSet rs = state.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPwd(rs.getString("pwd"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setGender(rs.getString("gender"));
				user.setPhone(rs.getString("phone"));
				user.setAsk(rs.getString("ask"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return user;
	}
}
