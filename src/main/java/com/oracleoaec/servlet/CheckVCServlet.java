package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
/*
 * author:刘飞
 * time:20171025
 * 核对验证码是否正确
 * */
public class CheckVCServlet extends HttpServlet{
	
	private static final long serialVersionUID = -5379296337517450414L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		//从session中获取的验证码
		String vc2 = (String) request.getSession().getAttribute("code");
		//从ajax传来的验证码
		String vc1 = request.getParameter("vc1");
		//比较
		if(vc1.equalsIgnoreCase(vc2)){ //成功
			response.getWriter().write(JSON.toJSONString(1));
		}else {
			response.getWriter().write(JSON.toJSONString(0));
		}
		
	}
}
