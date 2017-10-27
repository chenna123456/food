package com.oracleoaec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.oracleoaec.daoImp.ArticleDaoImp;
import com.oracleoaec.daoImp.UpdateStatusDaoImp;
import com.oracleoaec.entity.Article;
import com.oracleoaec.entity.Status;
import com.oracleoaec.entity.Vip;

public class OppStaServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String aidS = request.getParameter("aid");
		HttpSession session = request.getSession();
		Vip vip = (Vip)session.getAttribute("vipInfo");
		int vid = vip.getId();
		int aid = Integer.parseInt(aidS);
		UpdateStatusDaoImp dao = new UpdateStatusDaoImp();
		Status st = dao.findBy(vid, aid);
		ArticleDaoImp article = new ArticleDaoImp();
		String oppS = request.getParameter("opp");
		int opp = Integer.parseInt(oppS);
		int sta = 0;
		if(st==null){
			st = new Status();
			st.setAid(aid);
			st.setVid(vid);
			st.setStatus(-1);
			dao.updateStatus(st);
			opp = opp+1;
			article.updateopp(opp, aid);;
		}else{
			if(st.getStatus()==-1){
				opp = opp+1;
				sta= st.getStatus()+1;
			
			}else if(st.getStatus()==0){
				opp=opp-1;
				sta = st.getStatus()-1;
			
		}
			article.updateopp(opp, aid);;
			dao.updateBy(st.getId(), sta);
			Article ar = article.findArticle(aid);
			response.getWriter().write(JSON.toJSONString(ar));
			
		}
	}
	

}
