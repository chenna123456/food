package com.oracleoaec.sevlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.service.ExchangeService;
import com.oracleoaec.serviceImp.ExchangeServiceImp;

public class SelectGiftlistServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		ExchangeService es=new ExchangeServiceImp();
		
		//Integer userId = (Integer) req.getSession().getAttribute("userId");
		 Integer vipId=1;
		 String page = req.getParameter("page");
		 String pageSize = req.getParameter("pageSize");
		 Map<String, Object> map = es.findGiftCarByVipId(page,pageSize,vipId);
		 System.out.println(map);
		 resp.getWriter().write(JSON.toJSONString(map));
		 
	}

}
