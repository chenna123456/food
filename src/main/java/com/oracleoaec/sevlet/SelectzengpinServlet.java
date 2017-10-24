package com.oracleoaec.sevlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.entity.Exchangegift;
import com.oracleoaec.service.ExchangeService;
import com.oracleoaec.serviceImp.ExchangeServiceImp;

public class SelectzengpinServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		ExchangeService es=new ExchangeServiceImp();
		
		String type = req.getParameter("type");
		System.out.println(type+"servlet");
		String pageNo = req.getParameter("pageNo");
		System.out.println(pageNo);
		String pageSize = req.getParameter("pageSize");
		String minPoint = req.getParameter("minPoint");
		String maxPoint = req.getParameter("maxPoint");
		
		Map<String, Object> map = es.findExchangegiftBySelect(type, pageNo, pageSize, minPoint, maxPoint);
		resp.getWriter().write(JSON.toJSONString(map));
	}

}
