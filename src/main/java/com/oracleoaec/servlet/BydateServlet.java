package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.daoImp.PublicfoodDaoImp;
import com.oracleoaec.entity.Publicfood;

public class BydateServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String day=request.getParameter("day");
		
	//	System.out.println(day);
		PublicfoodDaoImp p =new PublicfoodDaoImp();
		List<Publicfood> li =p.byDatefind(day);
	    HashMap<String,Object> m =new    HashMap<String,Object>();
	    m.put("li", li);
		response.getWriter().write(JSON.toJSONString(m));
		
	}

}
