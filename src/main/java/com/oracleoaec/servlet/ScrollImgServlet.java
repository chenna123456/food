package com.oracleoaec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.daoImp.ScrollImgDaoImp;
import com.oracleoaec.entity.ScrollImg;

public class ScrollImgServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		System.out.println("daole");
		ScrollImgDaoImp dao = new ScrollImgDaoImp();
		List<ScrollImg> list = dao.findImg();
		response.getWriter().write(JSON.toJSON(list).toString());
	}

}
