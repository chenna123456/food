package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.NavigationDao;
import com.oracleoaec.entity.Navigation;
import com.oracleoaec.util.DBUtil;

public class NavigationDaoImp implements NavigationDao {

	public List<Navigation> findAllNavigation() {
		List<Navigation> list=new ArrayList<Navigation>();
		String sql="select * from navigation";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			while(re.next()){
				Navigation na=new Navigation();
				na.setId(re.getInt("id"));
				na.setTitle(re.getString("title"));
				na.setText(re.getString("content"));
				list.add(na);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("查询失败"+e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public Navigation findContent(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addNavigation(Navigation navigation) {
		// TODO Auto-generated method stub

	}

	public void updateNavigation(Navigation navigation) {
		// TODO Auto-generated method stub

	}

	public void deleteNavigation(Navigation navigation) {
		// TODO Auto-generated method stub

	}

}
