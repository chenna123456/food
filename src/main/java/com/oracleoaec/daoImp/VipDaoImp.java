package com.oracleoaec.daoImp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.oracleoaec.dao.VipDao;
import com.oracleoaec.entity.Vip;
import com.oracleoaec.util.DBUtil;

public class VipDaoImp implements VipDao {

	public Vip FindVipInfo(String name, String Userpwd) {
		Connection conn = null;

		Vip vip = null;

		try {

			conn = DBUtil.getConnection();

			String sql = "select * from Vip where username=? and pwd=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);

			pstmt.setString(2, Userpwd);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				String pwd = rs.getString("pwd");
				String address = rs.getString("address");
				Integer point = rs.getInt("point");
				String phone = rs.getString("phone");
				BigDecimal money = rs.getBigDecimal("money");
				String headImage = rs.getString("headimage");
				vip = new Vip(id, userName, pwd, address, point, phone, money, headImage);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

		return vip;

	}

	public void InsertVipInfo(Vip vip) {
		Connection conn = null;

		try {
			String sql = "insert into vip(userName,pwd,address,point,phone,money,headimage) VALUES(?,?,?,?,?,?,?)";

			conn = DBUtil.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vip.getUserName());

			pstmt.setString(2, vip.getPwd());

			pstmt.setString(3, vip.getAddress());

			pstmt.setInt(4, vip.getPoint());

			pstmt.setString(5, vip.getPhone());

			pstmt.setBigDecimal(6, vip.getMoney());

			pstmt.setString(7, vip.getHeadImage());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
	}

	public void UpdataVipInfo(Vip vip) {
		Connection conn = null;

		try {

			conn = DBUtil.getConnection();

			String sql = "update vip set username=?,pwd=?,address=?,phone=?,headImage=? where id=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vip.getUserName());

			pstmt.setString(2, vip.getPwd());

			pstmt.setString(3, vip.getAddress());

			pstmt.setString(4, vip.getPhone());

			pstmt.setString(5, vip.getHeadImage());

			pstmt.setInt(6, vip.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

	}

	public int findAllcount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Vip> findVip(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vip findVipById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean findPhoneUsed(String phone) {
		Boolean isExsit = false;

		Connection conn = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "select * from vip where phone=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, phone);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				isExsit = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

		return isExsit;
	}

}
