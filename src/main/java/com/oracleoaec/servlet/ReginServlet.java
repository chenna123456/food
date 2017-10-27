package com.oracleoaec.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.dao.VipDao;
import com.oracleoaec.daoImp.VipDaoImp;
import com.oracleoaec.entity.Vip;

public class ReginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		String muser = request.getParameter("muser");
		
		String mphone = request.getParameter("mphone");
		
		String pwd = request.getParameter("mpwd1");
		
		String imgcode = request.getParameter("ImgCode");
		
		String driName = request.getParameter("driName");
		
		String maddress = request.getParameter("maddress");
		
		String address=driName+","+maddress;
		
		String yzm = (String) request.getSession().getAttribute("yzm");
		
		if(!yzm.equals(imgcode)){
			response.sendRedirect("Regin.html");
		}else{
			Vip vip = new Vip();
			
			vip.setUserName(muser);
			
			vip.setPwd(pwd);
			
			vip.setPoint(200);
			
			vip.setAddress(address);
			
			vip.setPhone(mphone);
			
			vip.setMoney(new BigDecimal(0.00));
			
			vip.setHeadImage("");
			
			VipDao vipDaoImp = new VipDaoImp();
			
			vipDaoImp.InsertVipInfo(vip);
			
			request.getRequestDispatcher("Login.html").forward(request, response);
		}
		
	}

}
