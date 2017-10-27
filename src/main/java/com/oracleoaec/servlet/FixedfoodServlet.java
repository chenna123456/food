package com.oracleoaec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.dao.FixedfoodDao;
import com.oracleoaec.dao.OptionalfoodDao;
import com.oracleoaec.entity.Fixedfood;
import com.oracleoaec.util.FactoryDao;

public class FixedfoodServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/json;charset=utf-8");
	PrintWriter out = response.getWriter();

	String type2 = request.getParameter("type2");

	if (type2 == null || type2.equals("")) {
	    type2 = "经济套餐";
	}

	FactoryDao factory = new FactoryDao();
	FixedfoodDao fixfoodDao = factory.getFixedfoodDao();

	List<Fixedfood> list3 = fixfoodDao.findFixedfoodByType(type2);

	out.write(JSON.toJSON(list3).toString());
    }
}
