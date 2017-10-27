package com.oracleoaec.daoImp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.OptionalfoodDao;
import com.oracleoaec.entity.Optionalfood;
import com.oracleoaec.util.DBUtil;

public class OptionalfoodDaoImp implements OptionalfoodDao {

    public List<Optionalfood> findOptionalfoodByPrice(String type,Integer minPrice, Integer maxPrice, Integer page, Integer pageSize) {
	String sql = "select * from optionalfood where type=? and price between ? and ? limit ?,?";
	Connection conn = DBUtil.getConnection();
	ArrayList<Optionalfood> list = new ArrayList<Optionalfood>();
	try {
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, type);
	    ps.setInt(2, minPrice);
	    ps.setInt(3, maxPrice);
	    ps.setInt(4, (page - 1) * pageSize);
	    ps.setInt(5, pageSize);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		Integer id = rs.getInt("id");
		String OptionalfoodName = rs.getString("foodName");
		String types = rs.getString("type");
		BigDecimal price = rs.getBigDecimal("price");
		Integer point = rs.getInt("point");
		String ingredients = rs.getString("ingredients");
		String flavor = rs.getString("flavor");
		Integer count = rs.getInt("count");
		String src = rs.getString("src");
		String describe = rs.getString("describe");
		Optionalfood Optionalfood = new Optionalfood(id, OptionalfoodName, types, price, point, ingredients, flavor, count, src, describe);
		list.add(Optionalfood);
	    }
	} catch (SQLException e) {
	    throw new RuntimeException("查询失败");
	} finally {
	    DBUtil.close(conn);
	}
	return list;
    }

    public List<Optionalfood> findOptionalfoodByType(String type, Integer page, Integer pageSize) {
	String sql = "select * from optionalfood where type=? limit ?,?";
	Connection conn = DBUtil.getConnection();
	ArrayList<Optionalfood> list = new ArrayList<Optionalfood>();
	try {
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, type);
	    ps.setInt(2, (page - 1) * pageSize);
	    ps.setInt(3, pageSize);
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
		Integer id = rs.getInt("id");
		String foodName = rs.getString("foodName");
		String types = rs.getString("type");
		BigDecimal price = rs.getBigDecimal("price");
		Integer point = rs.getInt("point");
		String ingredients = rs.getString("ingredients");
		String flavor = rs.getString("flavor");
		Integer count = rs.getInt("count");
		String src = rs.getString("src");
		String describe = rs.getString("describe");
		Optionalfood Optionalfood = new Optionalfood(id, foodName, types, price, point, ingredients, flavor, count, src, describe);
		list.add(Optionalfood);
	    }
	} catch (SQLException e) {
	    throw new RuntimeException("查询失败");
	} finally {
	    DBUtil.close(conn);
	}
	return list;
    }

    public Integer findOptionalfoodCount(Integer id) {
	String sql = "select count from optionalfood where id=?";
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

    public Integer findListSize(String type, int minPrice, int maxPrice) {
	String sql = "select count(*) cou from optionalfood where type=? and price BETWEEN ? and ?";
	Connection conn = DBUtil.getConnection();
	Integer count = -1;
	try {
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setString(1, type);
	    ps.setInt(2, minPrice);
	    ps.setInt(3, maxPrice);
	    ResultSet rs = ps.executeQuery();
	    rs.next();
	    count = rs.getInt("cou");
	} catch (SQLException e) {
	    throw new RuntimeException("查询失败");
	} finally{
	    DBUtil.close(conn);
	}
	return count;
    }

	public Integer findOptionalfoodCount(String foodName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateOptionalfood(Optionalfood optionalfood) {
		// TODO Auto-generated method stub
		
	}

	public void deleteOptionalfood(Optionalfood optionalfood) {
		// TODO Auto-generated method stub
		
	}

	public void addOptionalfood(Optionalfood optionalfood) {
		// TODO Auto-generated method stub
		
	}

}
