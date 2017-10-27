package com.oracleoaec.daoImp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.FixedfoodDao;
import com.oracleoaec.entity.Fixedfood;
import com.oracleoaec.util.DBUtil;

public class FixedfoodDaoImp implements FixedfoodDao {

    public List<Fixedfood> findFixedfoodByType(String type) {
	String sql = "select * from fixedfood where type=?";
	Connection conn = DBUtil.getConnection();
	ArrayList<Fixedfood> list = new ArrayList<Fixedfood>();
	try {
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, type);
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
		Integer id = rs.getInt("id");
		String foodName = rs.getString("foodName");
		String types = rs.getString("type");
		BigDecimal price = rs.getBigDecimal("price");
		Integer point = rs.getInt("point");
		String ingredients = rs.getString("ingredients");
		Integer count = rs.getInt("count");
		String src = rs.getString("src");
		String describe = rs.getString("describe");
		Fixedfood fixedfood = new Fixedfood(id, foodName, types, price, point, ingredients, count, src, describe);
		list.add(fixedfood);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    throw new RuntimeException("查询失败",e);
	} finally{
	    DBUtil.close(conn);
	}
	return list;
    }

    public Integer findFixedfoodCount(Integer id) {
	String sql = "select count from fixedfood where id=?";
	Connection conn = DBUtil.getConnection();
	Integer count = -1;
	try {
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1, id);
	    ResultSet rs = ps.executeQuery();
	    rs.next();
	    count = rs.getInt("count");
	} catch (SQLException e) {
	    throw new RuntimeException("查询失败");
	} finally{
	    DBUtil.close(conn);
	}
	return count;
    }

	public int findAllCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Integer findFixedfoodCount(String foodName, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Fixedfood> findFixedfoodByTypeAndPage(String type, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
