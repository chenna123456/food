package com.oracleoaec.daoImp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oracleoaec.dao.OrderListInfoDao;
import com.oracleoaec.entity.Orderlistinfo;
import com.oracleoaec.util.DBUtil;

public class OrderListInfoDaoImp implements OrderListInfoDao {

	public Orderlistinfo findOrderInfoByOrderNo(String orderNo,String phone) {
		Orderlistinfo info = null;

		Connection conn = null;

		try {
			conn = DBUtil.getConnection();

			String sql = "select * from Orderlistinfo where orderNo=? and phone=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, orderNo);

			pstmt.setString(2, phone);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");

				String orderNum = rs.getString("orderNo");

				int vipId = rs.getInt("vipid");

				String vipName = rs.getString("vipName");

				String address = rs.getString("address");

				Date publishTime = rs.getTimestamp("publishTime");

				System.out.println("dao " + publishTime);

				String state = rs.getString("state");

				Date paymentTime = rs.getTimestamp("paymentTime");

				BigDecimal totalPrice = rs.getBigDecimal("totalprice");

				info = new Orderlistinfo(id, orderNum, vipId, vipName, address, phone, publishTime, state, paymentTime,
						totalPrice);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

		return info;
	}

	public List<Orderlistinfo> findOrderInfoByVipId(int vipId) {
		List<Orderlistinfo> list = new ArrayList<Orderlistinfo>();

		Connection conn = null;

		try {

			conn = DBUtil.getConnection();

			String sql = "select * from orderlistinfo where vipid=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vipId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");

				String orderNum = rs.getString("orderNo");

				String vipName = rs.getString("vipName");

				String address = rs.getString("address");

				Date publishTime = rs.getTimestamp("publishTime");

				String phone = rs.getString("phone");

				String state = rs.getString("state");

				Date paymentTime = rs.getTimestamp("paymentTime");

				BigDecimal totalPrice = rs.getBigDecimal("totalprice");

				Orderlistinfo info = new Orderlistinfo(id, orderNum, vipId, vipName, address, phone, publishTime, state,
						paymentTime, totalPrice);

				list.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

		return list;
	}

	public void OrderInfo(Orderlistinfo orderlistinfo) {
		// TODO Auto-generated method stub

	}

	public void addOrderlistinfo(Orderlistinfo orderlistinfo) {
		// TODO Auto-generated method stub

	}


}
