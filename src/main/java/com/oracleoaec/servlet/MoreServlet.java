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

public class MoreServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		ArticleDaoImp dao = new ArticleDaoImp();
		int allCount = dao.findAllCount();
		int pageSize = 10;
		String pageS = request.getParameter("page");
		int page;
		if(pageS==null||pageS.equals("")){
			page = 1;
		}else{
			page = Integer.parseInt(pageS);
		}
		int allPage = allCount%pageSize==0?allCount/pageSize:(allCount/pageSize)+1;
		List<Article> list = dao.findPages(page, pageSize);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("allPage", allPage);
		map.put("list", list);
		map.put("allCount", allCount);
		response.getWriter().write(JSON.toJSONString(map));
		
		
	}

}
