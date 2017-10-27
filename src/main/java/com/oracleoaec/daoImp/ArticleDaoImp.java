package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.ArticleDao;
import com.oracleoaec.entity.Article;
import com.oracleoaec.util.DBUtil;

public class ArticleDaoImp implements ArticleDao {
	public int findAllCount() {
		Connection con = DBUtil.getConnection();
		String sql = "select count(*) from article ";
		int a = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				a = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询总记录数失败",e);
		}finally{
			DBUtil.close(con);
		}
		return a;
	}

	public int finCountByType(String type) {
		Connection con = DBUtil.getConnection();
		String sql = "select count(*) from article where type=? ";
		int a = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				a = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询总记录数失败",e);
		}finally{
			DBUtil.close(con);
		}
		return a;
		
	}
	
	public List<Article> findTitleByType(String type, int page, int pageSize) {
		List<Article> list = new ArrayList<Article>();
		Connection con = DBUtil.getConnection();
		int page1 = (page-1)*pageSize;
		String sql = "select * from article where type=? limit ?,?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, type);
			ps.setInt(2, page1);
			ps.setInt(3, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Article a = new Article();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setType(rs.getString("type"));
				a.setWriter(rs.getString("writer"));
				a.setPublishtime(rs.getDate("publishtime"));
				a.setContent(rs.getString("content"));
				a.setCommentCount(rs.getInt("commentCount"));
				a.setBrowsingamount(rs.getInt("Browsingamount"));
				a.setSupportNum(rs.getInt("supportNum"));
				a.setOpposeNum(rs.getInt("opposeNum"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("分页查询失败",e);
		}finally{
			DBUtil.close(con);
		}
		return list;
	}

	public Article findArticle(int id) {
		Article a = null;
		Connection con = DBUtil.getConnection();
		String sql = "select * from article where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				a= new Article();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setType(rs.getString("type"));
				a.setWriter(rs.getString("writer"));
				a.setPublishtime(rs.getDate("publishtime"));
				a.setContent(rs.getString("content"));
				a.setCommentCount(rs.getInt("commentCount"));
				a.setBrowsingamount(rs.getInt("Browsingamount"));
				a.setSupportNum(rs.getInt("supportNum"));
				a.setOpposeNum(rs.getInt("opposeNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询id失败",e);
		}finally{
			DBUtil.close(con);
		}

		return a;
	}

	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAricle(Article article) {
		// TODO Auto-generated method stub
		
	}

	public void updateAricle(Article article) {
	
		
	}

	public List<Article> findHotArticle(int number) {
		List<Article> list = new ArrayList<Article>();
		Connection con = DBUtil.getConnection();
		String sql = "select * from article order by Browsingamount desc limit ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, number);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Article a = new Article();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setType(rs.getString("type"));
				a.setWriter(rs.getString("writer"));
				a.setPublishtime(rs.getDate("publishtime"));
				a.setContent(rs.getString("content"));
				a.setCommentCount(rs.getInt("commentCount"));
				a.setBrowsingamount(rs.getInt("Browsingamount"));
				a.setSupportNum(rs.getInt("supportNum"));
				a.setOpposeNum(rs.getInt("opposeNum"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("排序查询失败",e);
		}finally{
			DBUtil.close(con);
		}
		
		return list;
	}

	public List<Article> findPages(int page, int pageSize) {
		List<Article> list = new ArrayList<Article>();
		Connection con = DBUtil.getConnection();
		String sql = "select * from article order by Browsingamount limit ?,?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			int page1 = (page-1)*3;
			ps.setInt(1, page1);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Article a = new Article();
				a.setId(rs.getInt("id"));
				a.setTitle(rs.getString("title"));
				a.setType(rs.getString("type"));
				a.setWriter(rs.getString("writer"));
				a.setPublishtime(rs.getDate("publishtime"));
				a.setContent(rs.getString("content"));
				a.setCommentCount(rs.getInt("commentCount"));
				a.setBrowsingamount(rs.getInt("Browsingamount"));
				a.setSupportNum(rs.getInt("supportNum"));
				a.setOpposeNum(rs.getInt("opposeNum"));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("分页查询失败",e);
		}finally{
			DBUtil.close(con);
		}
		return list;
	}

	public void updateBrowsing(int browsing, int id){
		Connection con = DBUtil.getConnection();
		String sql = "update article set Browsingamount=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, browsing);
			ps.setInt(2, id);
			int ex = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新浏览量失败",e);
		}finally{
			DBUtil.close(con);
		}	
	}
	
	public void updateSup(int sup, int id){
		Connection con = DBUtil.getConnection();
		String sql = "update article set supportNum=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sup);
			ps.setInt(2, id);
			int ex = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新支持量失败",e);
		}finally{
			DBUtil.close(con);
		}	
	}
	public void updateopp(int opp, int id){
		Connection con = DBUtil.getConnection();
		String sql = "update article set opposeNum=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, opp);
			ps.setInt(2, id);
			int ex = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新支持量失败",e);
		}finally{
			DBUtil.close(con);
		}	
	}

	public void updateSricle(Article article) {
		// TODO Auto-generated method stub
		
	}


	

}
