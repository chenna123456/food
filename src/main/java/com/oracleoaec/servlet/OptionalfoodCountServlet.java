package com.oracleoaec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.daoImp.OptionalfoodDaoImp;

public class OptionalfoodCountServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/json;charset=utf-8");
	PrintWriter out = response.getWriter();
	
	String id = request.getParameter("id");
	
	Integer count = new OptionalfoodDaoImp().findOptionalfoodCount(Integer.parseInt(id));
	out.write(JSON.toJSON(count).toString());
    }
}
