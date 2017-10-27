package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.daoImp.ArticleDaoImp;
import com.oracleoaec.entity.Article;

public class FoodCultureServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		ArticleDaoImp dao = new ArticleDaoImp();
		String type = request.getParameter("type");
		int allCount = dao.finCountByType(type);
		String pageS = request.getParameter("page");
		String pageSizeS = request.getParameter("pageSize");
		int pageSize = Integer.parseInt(pageSizeS);
		int page ;
		if(pageS==null||pageS.equals(" ")){
			page = 1;
		}else{
			 page = Integer.parseInt(pageS);
		}
		
		
		int allPage = allCount%pageSize==0?allCount/pageSize:(allCount/pageSize)+1;
		List<Article> list = dao.findTitleByType(type, page, pageSize);
		
		List<Article> list1 = dao.findHotArticle(5);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("allPage", allPage);
		map.put("allCount", allCount);
		map.put("list1",list1);
		response.getWriter().write(JSON.toJSONString(map));
	}

}
