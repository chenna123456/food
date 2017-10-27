package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderListServletByPhone extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		String orderNo = request.getParameter("os_orderno");//获取订单号
		
		String phone = request.getParameter("os_phone");
		
		System.out.println(orderNo+phone);
		
		if(orderNo==null||orderNo.equals("")){
			response.sendRedirect("Select.html");
		}else{
			request.getSession().setAttribute("orderNo", orderNo);
			
			request.getSession().setAttribute("phone", phone);
			
			request.getRequestDispatcher("Orderdetail.html").forward(request, response);
		}
		
	}
}
