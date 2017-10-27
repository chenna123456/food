package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.LeavemessageDao;
import com.oracleoaec.entity.Leavemessage;
import com.oracleoaec.util.DBUtil;
/**
 * 操作数据库中的留言信息表
 * @author 刘飞
 * @date 2017年10月23日
 */
public class LeavemessageDaoImp implements  LeavemessageDao {
	/**
	 * 向数据库中插入留言信息
	 */
	public int addLeavemessage(Leavemessage leavemessage) {
		int rows = 0;
		String sql = "insert into leavemessage(title,vipName,content,publishtime,vipUrl,email,qq,homePage,moodUrl) value(?,?,?,?,?,?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, leavemessage.getTitle());
			ps.setString(2, leavemessage.getVipName());
			ps.setString(3, leavemessage.getContent());
			ps.setDate(4, (Date) leavemessage.getPublishtime());
			ps.setString(5, leavemessage.getVipUrl());
			ps.setString(6, leavemessage.getEmail());
			ps.setString(7, leavemessage.getQq());
			ps.setString(8, leavemessage.getHomePage());
			ps.setString(9, leavemessage.getMoodUrl());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("插入留言失败！",e);
		}finally {
			DBUtil.close(conn);
		}
		return rows;
	}

	public void deleteLeavemessage(Leavemessage leavemessage) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 分页查询
	 * 从数据库中获取所有的留言信息封装到Leavemessage对象中，再把他放到list中返回
	 */
	public List<Leavemessage> findByPage(int page, int pageSize) {
		ArrayList<Leavemessage> list = new ArrayList<Leavemessage>();
		String sql = "select * from leavemessage limit ?,?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Leavemessage lm = new Leavemessage();
				lm.setContent(rs.getString("content"));
				lm.setId(rs.getInt("id"));
				lm.setPublishtime(rs.getDate("publishtime"));
				lm.setTitle(rs.getString("title"));
				lm.setVipid(rs.getInt("vipid"));
				lm.setVipUrl(rs.getString("vipUrl"));
				lm.setVipName(rs.getString("vipName"));
				list.add(lm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("分页查询失败",e);
		}finally {
			DBUtil.close(conn);
		}
		return list;
	}
	
	/**
	 * 获取数据库中留言总记录数
	 */
	public int count() {
		int count = 0;
		String sql = "select count(*) from leavemessage";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取总记录数失败！",e);
		}finally {
			DBUtil.close(conn);
		}
		return count;
	}

	public List<Leavemessage> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
