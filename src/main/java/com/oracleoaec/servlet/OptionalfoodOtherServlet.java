package com.oracleoaec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.dao.OptionalfoodDao;
import com.oracleoaec.daoImp.OptionalfoodDaoImp;
import com.oracleoaec.entity.Optionalfood;
import com.oracleoaec.util.FactoryDao;

public class OptionalfoodOtherServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/json;charset=utf-8");
	PrintWriter out = response.getWriter();
	
	Integer pageSize = 4;//每页显示4条
	String page = request.getParameter("page");
	String type = request.getParameter("type");
	
	 FactoryDao factory = new FactoryDao();
	 OptionalfoodDao dao = factory.getOptionalfoodDao();
	
	//返回根据菜品类型分类的集合
	List<Optionalfood> list2 = dao.findOptionalfoodByType(type, Integer.parseInt(page), pageSize);
	
	out.write(JSON.toJSON(list2).toString());
    }
}
