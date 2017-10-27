package com.oracleoaec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.dao.OptionalfoodDao;
import com.oracleoaec.entity.Optionalfood;
import com.oracleoaec.util.FactoryDao;

public class OptionalfoodServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/json;charset=utf-8");
	PrintWriter out = response.getWriter();
	
	 Integer pageSize = 4;//每页显示4条
	 String page = request.getParameter("page");
	 String type = request.getParameter("type");
	 String type2 = request.getParameter("type2");
	 String minPrice = request.getParameter("minPrice");
	 String maxPrice = request.getParameter("maxPrice");
	 System.out.println(page+"page");
	 System.out.println(type+"type");
	 System.out.println(type2+"type2");
	 System.out.println(minPrice+"minPrice");
	 System.out.println(maxPrice+"maxPrice");
	 Map<String,Object> map = new HashMap<String, Object>();
	 FactoryDao factory = new FactoryDao();
	 OptionalfoodDao dao = factory.getOptionalfoodDao();
	 
	 //返回根据类型、价格区间查找的菜品集合
	 List<Optionalfood> list = dao.findOptionalfoodByPrice
	 (type, Integer.parseInt(minPrice), Integer.parseInt(maxPrice),
		 Integer.parseInt(page), pageSize);
	 
	 //查询此类型菜品在价格区间内的数量     --  用来确定分页页数
	 Integer count = dao.findListSize(type, Integer.parseInt(minPrice), Integer.parseInt(maxPrice));
	 System.out.println();
	 Integer pages = count % 4 == 0 ? count/4 : count/4 + 1;
	 map.put("tenFood", list);
	 map.put("pages", pages);
	 out.write(JSON.toJSON(map).toString());
    }
}
