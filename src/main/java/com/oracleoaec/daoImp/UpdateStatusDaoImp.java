package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracleoaec.dao.UpdateStatusDao;
import com.oracleoaec.entity.Status;
import com.oracleoaec.util.DBUtil;

public class UpdateStatusDaoImp implements UpdateStatusDao{

	public Status findBy(int vid, int aid) {
		Connection con = DBUtil.getConnection();
		Status s = null;
		String sql = "select * from updatestatus where vid=? and aid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, vid);
			ps.setInt(2, aid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				s = new Status();
				s.setId(rs.getInt("id"));
				s.setVid(rs.getInt("vid"));
				s.setAid(rs.getInt("aid"));
				s.setStatus(rs.getInt("status"));
				return s;
			}else{
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询记录失败",e);
		}finally{
			DBUtil.close(con);
		}
		
	}

	public void updateStatus(Status status) {
		Connection con = DBUtil.getConnection();
		String sql = "insert into updatestatus(vid,aid,status) values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status.getVid());
			ps.setInt(2, status.getAid());
			ps.setInt(3, status.getStatus());
			int ex = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据插入失败",e);
		}finally{
			DBUtil.close(con);
		}
		
	}

	public void updateBy(int id,int status) {
		Connection con = DBUtil.getConnection();
		String sql = "update updatestatus set status = ? where id =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, id);
			int ex = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新状态失败",e);
		}finally{
			DBUtil.close(con);
		}
		
	}
	
	
}
