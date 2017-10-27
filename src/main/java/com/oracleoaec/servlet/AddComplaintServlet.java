package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.entity.Vip;
import com.oracleoaec.service.ComplaintService;
import com.oracleoaec.serviceImp.ComplaintServiceImp;

public class AddComplaintServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		ComplaintService cs=new ComplaintServiceImp();
		HttpSession session = req.getSession();
		String codeSess = (String)session.getAttribute("code");
		
		String code = req.getParameter("code");
		if(code==null||code.equals(codeSess)){
		resp.getWriter().write(JSON.toJSONString(1));
		}else{
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String realname = req.getParameter("realname");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		Vip vip = (Vip)session.getAttribute("vipinfo");
		Integer vipId = vip.getId();
		int i = cs.addComplaint(title, content, realname, gender, vipId, address);
		resp.getWriter().write(JSON.toJSONString(i));
		}
		
	}

}
