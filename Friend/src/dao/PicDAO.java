package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtils;
import entity.Pic;

public class PicDAO {
	public void save(Pic pic) {
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();
			String sql = "INSERT INTO f_pic(picName,userId) VALUES(?,?)";

			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1, pic.getPicName());
			state.setInt(2, pic.getUserId());

			state.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
	}

	public List<Pic> findByUserId(int id) {
		List<Pic> pics = new ArrayList<Pic>();
		;
		Connection conn = null;

		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT * FROM f_pic WHERE id=?";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setInt(1, id);
			ResultSet rs = state.executeQuery();

			while (rs.next()) {
				Pic pic = new Pic();
				pic.setId(rs.getInt("id"));
				pic.setPicName(rs.getString("picName"));
				pic.setUserId(rs.getInt("userId"));

				pics.add(pic);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return pics;
	}
}
