package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.oracleoaec.dao.ComplaintDao;
import com.oracleoaec.entity.Complaint;
import com.oracleoaec.util.DBUtil;

public class ComplaintDaoImp implements ComplaintDao {

	public int findAllCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Complaint> findComplaint(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Complaint findComplaintById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addComplaintDao(Complaint complaint) {
		String sql="insert into complaint(title,content,complaintName,"
				+ "gender,vipId,address,complaintDate) values(?,?,?,?,?,?,?);";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, complaint.getTitle());
			ps.setString(2, complaint.getContent());
			ps.setString(3, complaint.getComplaintName());
			ps.setString(4, complaint.getGender());
			ps.setInt(5, complaint.getVipId());
			ps.setString(6, complaint.getAddress());
			ps.setDate(7, new java.sql.Date(complaint.
					getComplaintDate().getTime()));
			int i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
		
		
	}

	public void deleteComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		
	}


	

}
