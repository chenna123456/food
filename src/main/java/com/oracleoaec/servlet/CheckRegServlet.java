package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.dao.VipDao;
import com.oracleoaec.daoImp.VipDaoImp;

public class CheckRegServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json;charset=utf-8");

		VipDao vipDaoImp = new VipDaoImp();

		String phone = request.getParameter("phone");

		Boolean used = vipDaoImp.findPhoneUsed(phone);

		response.getWriter().write(JSON.toJSONString(used));
		
	}
}
