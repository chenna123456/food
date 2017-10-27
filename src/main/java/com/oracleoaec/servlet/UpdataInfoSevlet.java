package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.dao.VipDao;
import com.oracleoaec.daoImp.VipDaoImp;
import com.oracleoaec.entity.Vip;

public class UpdataInfoSevlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");

		String name = request.getParameter("vipname");

		String driName = request.getParameter("driName");

		String addressMjz = request.getParameter("addressMjz");

		String pwd1Mjz = request.getParameter("pwd1Mjz");

		String phoneMjz = request.getParameter("phoneMjz");

		String heardImgMjz = request.getParameter("heardImgMjz");

		String CodeImgMjz = request.getParameter("CodeImgMjz");

		String yzm = (String) request.getSession().getAttribute("yzm");

		if (CodeImgMjz.equals(yzm)) {

			Vip vip = (Vip) request.getSession().getAttribute("vipInfo");

			vip.setAddress(driName + "," + addressMjz);

			vip.setPhone(phoneMjz);

			vip.setPwd(pwd1Mjz);

			vip.setUserName(name);

			vip.setHeadImage(heardImgMjz);

			VipDao vipDaoImp = new VipDaoImp();

			vipDaoImp.UpdataVipInfo(vip);

			request.getRequestDispatcher("Login.html").forward(request, response);
		} else {
			response.sendRedirect("VipCenter.html");
		}

	}
}
