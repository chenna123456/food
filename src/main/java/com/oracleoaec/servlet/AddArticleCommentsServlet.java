package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.daoImp.VipcommentDaoImp;
import com.oracleoaec.entity.Vipcomment;

public class AddArticleCommentsServlet extends HttpServlet{

	private static final long serialVersionUID = 4994183568178158373L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String title = request.getParameter("title");
		String vipName = request.getParameter("vipName");
		String content = request.getParameter("content");
		Date uDate = new Date();  //获取当前时间
		java.sql.Timestamp tDate = new java.sql.Timestamp(uDate.getTime());
		
		Vipcomment vc = new Vipcomment();
		vc.setaTitle(title);
		vc.setContent(content);
		vc.setVipname(vipName);
		vc.setLeaveTime(tDate);
		
		VipcommentDaoImp vcdi = new VipcommentDaoImp();
		int rows = vcdi.addVipcomment(vc);
		if (rows>0) { //成功返回1 
			response.getWriter().write(JSON.toJSONString(1));
		}else {
			response.getWriter().write(JSON.toJSONString(0));
		}
	}	
}
