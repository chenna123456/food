package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.daoImp.ArticleDaoImp;
import com.oracleoaec.entity.Article;

public class NoticeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		ArticleDaoImp dao = new ArticleDaoImp();
		List<Article> list = dao.findHotArticle(5);
		response.getWriter().write(JSON.toJSONString(list));
	}

}
