package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.dao.OrderListInfoDao;
import com.oracleoaec.daoImp.OrderListInfoDaoImp;
import com.oracleoaec.entity.Orderlistinfo;
import com.oracleoaec.entity.Vip;

public class UpdataVipInfoSevlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json;charset=utf-8");

		Vip vipInfo = (Vip) request.getSession().getAttribute("vipInfo");

		OrderListInfoDao foodDaoImp = new OrderListInfoDaoImp();
		List<Orderlistinfo> orderInfoByVipId = foodDaoImp.findOrderInfoByVipId(vipInfo.getId());

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("vipInfo", vipInfo);

		map.put("orderInfoByVipId", orderInfoByVipId);

		response.getWriter().write(JSON.toJSONString(map));

	}
}
