package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.dao.OrderFoodDao;
import com.oracleoaec.dao.OrderListInfoDao;
import com.oracleoaec.daoImp.OrderFoodDaoImp;
import com.oracleoaec.daoImp.OrderListInfoDaoImp;
import com.oracleoaec.entity.Orderfood;
import com.oracleoaec.entity.Orderlistinfo;

public class OrderdetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json;charset=utf-8");

		String orderNo = (String) request.getSession().getAttribute("orderNo");

		String phone = (String) request.getSession().getAttribute("phone");

		// System.out.println(phone + "....");

		OrderListInfoDao orderFoodDaoImp = new OrderListInfoDaoImp();

		OrderFoodDao listInfoDaoImp = new OrderFoodDaoImp();

		List<Orderfood> orderList = listInfoDaoImp.findOrderFoodByorderNo(orderNo);// 用订单号查处订单的信息(收货人)

		Orderlistinfo orderInfo = orderFoodDaoImp.findOrderInfoByOrderNo(orderNo, phone);// 用订单号查处订单的信息(菜品)

		if (orderInfo == null) {
			response.sendRedirect("Select.html");
		} else {
			HashMap<String, Object> map = new HashMap<String, Object>();

			map.put("orderInfo", orderInfo);

			map.put("orderList", orderList);

			response.getWriter().write(JSON.toJSONString(map));

			// System.out.println(JSON.toJSONString(map));

		}

	}
}
