package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.CombinationfoodDao;
import com.oracleoaec.entity.Combinationfood;
import com.oracleoaec.util.DBUtil;

public class CombinationfoodDaoImp implements CombinationfoodDao {

    public List<Combinationfood> findCombinationfoodByType(String type) {
	String sql = "select * from combinationfood where type=?";
	ArrayList<Combinationfood> list = new ArrayList<Combinationfood>();
	Connection conn = DBUtil.getConnection();
	try {
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, type);
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
		Integer id = rs.getInt("id");
		String foodName = rs.getString("foodName");
		String types = rs.getString("type");
		Combinationfood c = new Combinationfood(id, foodName, types);
		list.add(c);
	    }
	} catch (SQLException e) {
	    throw new RuntimeException("查询失败");
	} finally {
	    DBUtil.close(conn);
	}
	return list;
    }

	public int findAllCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int findCountType(String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addCombinationfood(Combinationfood combination) {
		// TODO Auto-generated method stub
		
	}

	public void updateCombinationfood(Combinationfood combination) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCombinationfood(Combinationfood combination) {
		// TODO Auto-generated method stub
		
	}

}
