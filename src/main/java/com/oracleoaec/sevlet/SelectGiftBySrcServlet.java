package com.oracleoaec.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.entity.Exchangegift;
import com.oracleoaec.service.ExchangeService;
import com.oracleoaec.serviceImp.ExchangeServiceImp;

public class SelectGiftBySrcServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		ExchangeService es=new ExchangeServiceImp();
		String src = req.getParameter("giftsrc");
		Exchangegift ex = es.findGiftBySrc(src);
		System.out.println(ex);
		resp.getWriter().write(JSON.toJSONString(ex));
	}

}
