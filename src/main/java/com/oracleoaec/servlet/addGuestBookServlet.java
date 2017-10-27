package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.daoImp.LeavemessageDaoImp;
import com.oracleoaec.entity.Leavemessage;
/*
 * author:刘飞
 * time:20171024
 * 添加留言信息
 * */
public class addGuestBookServlet extends HttpServlet{

	private static final long serialVersionUID = -2951909161952693122L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String title = request.getParameter("title");
		String vipName = request.getParameter("name");
		String vipUrl = request.getParameter("imgp");
		String content = request.getParameter("content");
		String email = request.getParameter("email");
		String qq = request.getParameter("qq");
		String homePage = request.getParameter("homePage");
		String moodUrl = request.getParameter("moodUrl");
		Leavemessage lm = new Leavemessage();
		Date uDate = new Date();
		Date sDate  = new java.sql.Date(uDate.getTime());
		lm.setPublishtime(sDate);
		lm.setContent(content);
		lm.setTitle(title);
		lm.setVipName(vipName);
		lm.setVipUrl(vipUrl);
		lm.setEmail(email);
		lm.setQq(qq);
		lm.setHomePage(homePage);
		lm.setMoodUrl(moodUrl);
		LeavemessageDaoImp daoImp = new LeavemessageDaoImp();
		int rows = daoImp.addLeavemessage(lm);
		//传到ajax
		response.getWriter().write(JSON.toJSONString(rows));
	}
}
