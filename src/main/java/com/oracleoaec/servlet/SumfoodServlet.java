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
import com.oracleoaec.daoImp.CombinationfoodDaoImp;
import com.oracleoaec.entity.Combinationfood;
import com.oracleoaec.entity.Fixedfood;
import com.oracleoaec.util.FactoryDao;

public class SumfoodServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/json;charset=utf-8");
	PrintWriter out = response.getWriter();

	String type2 = request.getParameter("type2");

	List<Combinationfood> list = new CombinationfoodDaoImp().findCombinationfoodByType(type2);

	out.write(JSON.toJSON(list).toString());
    }
}
