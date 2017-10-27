package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.entity.Navigation;
import com.oracleoaec.service.NavigationService;
import com.oracleoaec.serviceImp.NavigationServiceImp;

public class NavigationServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		NavigationService ns=new NavigationServiceImp();
		
		List<Navigation> list = ns.findAllNavigation();
		resp.getWriter().write(JSON.toJSONString(list));
	}

}
