package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.service.WeekFoodsService;
import com.oracleoaec.serviceImp.WeekFoodsServiceImp;


public class LoaddaysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		
		WeekFoodsService ws=new WeekFoodsServiceImp();
		Map<String, Object> map = ws.findNowDate();
		
		resp.getWriter().write(JSON.toJSONString(map));
		System.out.println(map);
	}

}
