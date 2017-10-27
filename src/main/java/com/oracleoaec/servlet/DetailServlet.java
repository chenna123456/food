package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.dao.ArticleDao;
import com.oracleoaec.daoImp.ArticleDaoImp;
import com.oracleoaec.entity.Article;

public class DetailServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String idS = request.getParameter("id");
		int id = Integer.parseInt(idS);
		ArticleDaoImp dao = new ArticleDaoImp();
		Article article = dao.findArticle(id);
		response.getWriter().write(JSON.toJSONString(article));
	}

}
