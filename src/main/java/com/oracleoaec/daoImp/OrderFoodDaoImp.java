package com.oracleoaec.daoImp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oracleoaec.dao.OrderFoodDao;
import com.oracleoaec.dao.OrderListInfoDao;
import com.oracleoaec.entity.Orderfood;
import com.oracleoaec.entity.Orderlistinfo;
import com.oracleoaec.util.DBUtil;

public class OrderFoodDaoImp implements OrderFoodDao {

	public Orderlistinfo findOrderInfoByOrderNo(String orderNo, String phone) {
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

	public void OrderInfo(Orderlistinfo orderlistinfo) {
		// TODO Auto-generated method stub

	}

	public void addOrderlistinfo(Orderlistinfo orderlistinfo) {
		// TODO Auto-generated method stub

	}

	public List<Orderfood> findOrderFoodByorderNo(String orderNo) {
		List<Orderfood> foodList = new ArrayList<Orderfood>();

		Connection conn = null;

		try {
			String sql = "select * from orderfood where orderNO=?";

			conn = DBUtil.getConnection();

			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, orderNo);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				Integer id = rs.getInt("id");

				String orderNum = rs.getString("orderNo");

				String foodName = rs.getString("foodName");

				BigDecimal price = rs.getBigDecimal("price");

				Integer number = rs.getInt("number");

				BigDecimal subtatol = rs.getBigDecimal("subtotal");

				Orderfood orderfood = new Orderfood(id, orderNum, foodName, price, number, subtatol);

				foodList.add(orderfood);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}

		return foodList;
	}

	public void addOrderFood(Orderfood orderFood) {
		// TODO Auto-generated method stub

	}

	public void updateOrderFood(Orderfood orderFood) {
		// TODO Auto-generated method stub

	}

	public void deleteOrderfood(String orderNo) {
		// TODO Auto-generated method stub

	}

}
