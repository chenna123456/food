package com.oracleoaec.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.entity.Vip;
import com.oracleoaec.service.ExchangeService;
import com.oracleoaec.serviceImp.ExchangeServiceImp;

public class AddGiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		ExchangeService es=new ExchangeServiceImp();
		
		String num = req.getParameter("num");
		System.out.println("servlet"+num);
		String giftsrc = req.getParameter("giftsrc");
		//Vip vip = (Vip)req.getSession().getAttribute("vipinfo");
		//Integer vipId = vip.getId();
		int vipId=1;
		es.addGift(giftsrc, vipId, num);
		resp.getWriter().write(JSON.toJSONString("成功"));
	}

}
