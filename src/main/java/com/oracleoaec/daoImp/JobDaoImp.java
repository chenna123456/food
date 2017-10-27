package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.JobDao;
import com.oracleoaec.entity.Job;
import com.oracleoaec.util.DBUtil;

public class JobDaoImp implements JobDao {

	public int findCount() {
		String sql="select count(id) as number from job";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			if(re.next()){
				return re.getInt("number");
			}else{
				return 0;
			}
		} catch (SQLException e) {
			throw new RuntimeException("查询总记录数失败",e);
		}finally{
			DBUtil.close(conn);
		}
	}

	public List<Job> findAllJob(int page, int pageSize) {
		String sql="select * from job limit ?,?";
		List<Job> list=new ArrayList<Job>();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet re = ps.executeQuery();
			while(re.next()){
				Job job=new Job();
				job.setId(re.getInt("id"));
				job.setName(re.getString("name"));
				job.setAddress(re.getString("address"));
				job.setNumber(re.getInt("number"));
				job.setMonery(re.getBigDecimal("monery"));
				list.add(job);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("查询总记录数失败",e);
		}finally{
			DBUtil.close(conn);
		}
	}

}
