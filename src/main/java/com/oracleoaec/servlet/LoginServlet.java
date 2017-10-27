package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.dao.VipDao;
import com.oracleoaec.daoImp.VipDaoImp;
import com.oracleoaec.entity.Vip;

public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");

		String muser = request.getParameter("muser");

		String mpass = request.getParameter("mpass");

		String yzm = (String) request.getSession().getAttribute("yzm");

		// System.out.println(muser+mpass+yzm);

		String parameter = request.getParameter("ImgCode");

		VipDao vipDaoImp = new VipDaoImp();

		Vip vip = vipDaoImp.FindVipInfo(muser, mpass);

		if (vip == null||!parameter.equals(yzm)) {
			response.sendRedirect("Login.html");
		} else {
			request.getSession().setAttribute("vipInfo", vip);

			response.sendRedirect("VipCenter.html");
		}

	}
}
