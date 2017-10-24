package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.ExchangegiftDao;
import com.oracleoaec.entity.Exchangegift;
import com.oracleoaec.util.DBUtil;

public class ExchangegiftDaoImp implements ExchangegiftDao {

	public int findCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int findCountByType(String type){
		Connection conn = DBUtil.getConnection();
		StringBuilder sql=new StringBuilder("select count(id) as number from exchangegift ");
		if(type!=null&&type!=""){
			sql.append("where type='"+type+"'");
		}
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql.toString());
			ResultSet re = ps.executeQuery();
			if(re.next()){
				return re.getInt("number");
			}else{
			return 0;
			}
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
		
	}

	public List<Exchangegift> findExchangegiftBypage(int page, int PageSize) {
		String sql="select * from exchangegift  limit ?,?";
		Connection conn = DBUtil.getConnection();
		try {
			List<Exchangegift> list=new ArrayList<Exchangegift>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*PageSize);
			ps.setInt(2, PageSize);
			ResultSet re = ps.executeQuery();
			while(re.next()){
				Exchangegift ex=new Exchangegift();
				ex.setId(re.getInt("id"));
				ex.setName(re.getString("name"));
				ex.setCount(re.getInt("count"));
				ex.setType(re.getString("type"));
				ex.setExchangepoint(re.getInt("exchangepoint"));
				ex.setExchangetimes(re.getInt("exchangetimes"));
				ex.setSpecifications(re.getString("specifications"));
				ex.setModel(re.getString("model"));
				ex.setDescribe(re.getString("describe"));
				ex.setSrc(re.getString("src"));
				list.add(ex);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
	}

	public Exchangegift findExchangegift(int id,int page,int pageSize) {
		String sql="select * from exchangegift where id=? limit ?,?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, (page-1)*pageSize);
			ps.setInt(3, pageSize);
			ResultSet re = ps.executeQuery();
			if(re.next()){
				Exchangegift ex=new Exchangegift();
				ex.setId(re.getInt("id"));
				ex.setName(re.getString("name"));
				ex.setCount(re.getInt("count"));
				ex.setType(re.getString("type"));
				ex.setExchangepoint(re.getInt("exchangepoint"));
				ex.setExchangetimes(re.getInt("exchangetimes"));
				ex.setSpecifications(re.getString("specifications"));
				ex.setModel(re.getString("model"));
				ex.setDescribe(re.getString("describe"));
				ex.setSrc(re.getString("src"));
				return ex;
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
	}
	
	public Exchangegift findExchangegiftBySrc(String src){
		String sql="select * from exchangegift where src=?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, src);
			ResultSet re = ps.executeQuery();
			if(re.next()){
				Exchangegift ex=new Exchangegift();
				ex.setId(re.getInt("id"));
				ex.setName(re.getString("name"));
				ex.setCount(re.getInt("count"));
				ex.setType(re.getString("type"));
				ex.setExchangepoint(re.getInt("exchangepoint"));
				ex.setExchangetimes(re.getInt("exchangetimes"));
				ex.setSpecifications(re.getString("specifications"));
				ex.setModel(re.getString("model"));
				ex.setDescribe(re.getString("describe"));
				ex.setSrc(re.getString("src"));
				return ex;
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
	}
	public List<Exchangegift> findgiftBySelect(String type, int page, int pageSize, int minPoint, int maxPoint) {
		StringBuilder sql=new StringBuilder("select * from exchangegift ");
		boolean w=false;
		/**
		 * 完整sql
		 */
		if(type!=null&&type!=""){
			sql.append(" where type= '"+type+"'");
			w=true;
		}
		if(w){
			sql.append(" and ( exchangepoint between "+minPoint+" and "+maxPoint+" ) ");
		}else{
			sql.append(" where exchangepoint between "+minPoint+" and "+maxPoint+" ");
		}
		sql.append(" limit ?,?");
		
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, (page-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet re = ps.executeQuery();
			List<Exchangegift> list=new ArrayList<Exchangegift>();
			while(re.next()){
				Exchangegift ex=new Exchangegift();
				ex.setId(re.getInt("id"));
				ex.setName(re.getString("name"));
				ex.setType(re.getString("type"));
				ex.setExchangepoint(re.getInt("exchangepoint"));
				ex.setExchangetimes(re.getInt("exchangetimes"));
				ex.setCount(re.getInt("count"));
				ex.setSpecifications(re.getString("specifications"));
				ex.setModel(re.getString("model"));
				ex.setDescribe(re.getString("describe"));
				ex.setSrc(re.getString("src"));
				list.add(ex);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
	}

	public List<Exchangegift> findType() {
		String sql="select distinct type from exchangegift ";
		Connection conn = DBUtil.getConnection();
		try {
			List<Exchangegift> list=new ArrayList<Exchangegift>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet re = ps.executeQuery();
			while(re.next()){
				Exchangegift ex=new Exchangegift();
				ex.setType(re.getString("type"));
				list.add(ex);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
	}

	public void addExchangegift(Exchangegift exchangegift) {
		// TODO Auto-generated method stub
		
	}

	public List<Exchangegift> findGiftTop(int number) {
		String sql="select id,name,src from exchangegift order by "
				+ "exchangetimes desc limit ?,?";
		Connection conn = DBUtil.getConnection();
		try {
			List<Exchangegift> list=new ArrayList<Exchangegift>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, number);
			ResultSet re = ps.executeQuery();
			while(re.next()){
				Exchangegift ex=new Exchangegift();
				ex.setId(re.getInt("id"));
				ex.setName(re.getString("name"));
				ex.setSrc(re.getString("src"));
				list.add(ex);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
	}

	public int updateCountByid(Exchangegift ex) {
		String sql="update exchangegift set count=? where id=?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ex.getCount());
			ps.setInt(2, ex.getId());
			int i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
		
	}
}
