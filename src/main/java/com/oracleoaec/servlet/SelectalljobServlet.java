package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.service.NavigationService;
import com.oracleoaec.serviceImp.NavigationServiceImp;

public class SelectalljobServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		NavigationService ns=new NavigationServiceImp();
		
		String page = req.getParameter("page");
		String pageSize = req.getParameter("pageSize");
		
		Map<String, Object> map = ns.findjob(page, pageSize);
		resp.getWriter().write(JSON.toJSONString(map));
	}

}
