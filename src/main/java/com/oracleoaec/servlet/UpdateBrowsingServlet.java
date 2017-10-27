package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracleoaec.dao.ArticleDao;
import com.oracleoaec.daoImp.ArticleDaoImp;

public class UpdateBrowsingServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String idS = request.getParameter("id");
		int id = Integer.parseInt(idS);
		String browsingS = request.getParameter("browsing");
		int browsing = Integer.parseInt(browsingS);
		ArticleDaoImp dao = new ArticleDaoImp();
		dao.updateBrowsing(browsing, id);
	}

}
