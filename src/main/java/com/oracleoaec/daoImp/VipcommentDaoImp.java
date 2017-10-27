package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.oracleoaec.dao.VipcommentDao;
import com.oracleoaec.entity.Vipcomment;
import com.oracleoaec.util.DBUtil;

public class VipcommentDaoImp implements VipcommentDao {

	public int findCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Vipcomment> findVipcomment(int page, int PageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addVipcomment(Vipcomment vipcomment) {
		int rows = 0;
		String sql = "insert into vipcomment(vipname,content,leaveTime,aTitle) value(?,?,?,?)";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vipcomment.getVipname());
			ps.setString(2, vipcomment.getContent());
			ps.setTimestamp(3, (Timestamp) vipcomment.getLeaveTime());
			ps.setString(4, vipcomment.getaTitle());
			
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("插入评论失败！",e);
		}finally {
			DBUtil.close(conn);
		}
		return rows;
	}

	public void deleteVipcomment(Vipcomment vipcomment) {
		// TODO Auto-generated method stub

	}

}
