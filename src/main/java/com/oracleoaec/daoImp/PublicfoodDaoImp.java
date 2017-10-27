package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.oracleoaec.entity.Publicfood;
import com.oracleoaec.util.DBUtil;

public class PublicfoodDaoImp {
    public List<Publicfood> byTimeFinDall(){
    	ArrayList<Publicfood> list = new ArrayList();
    	 Connection con = DBUtil.getConnection();
    	 String sql="select * from publicfood order by publicdate desc";
    	 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				Publicfood p =new Publicfood();
				p.setId(rs.getInt("id"));
				p.setPulicdate(rs.getDate("publicdate"));
				p.setFoodname(rs.getString("foodname"));
				p.setSrc(rs.getString("src"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("获得连接或结果集失败");
		}finally{
			DBUtil.close(con);;
		}
    	
    	
    }
    public Publicfood byIdfind(Integer id){
    	Publicfood p =null;
        	
        	 Connection con = DBUtil.getConnection();
        	 String sql="select * from publicfood where id=?";
        	 try {
    			PreparedStatement ps = con.prepareStatement(sql);
    			ps.setInt(1, id);
    			ResultSet rs= ps.executeQuery();
    			while(rs.next()){
    				 p =new Publicfood();
    				p.setId(rs.getInt("id"));
    				p.setPulicdate(rs.getDate("publicdate"));
    				p.setFoodname(rs.getString("foodname"));
    				p.setSrc(rs.getString("src"));
    				
    			}	
    			return p;
    		} catch (SQLException e) {
    			throw new RuntimeException("获得连接或结果集失败");
    		}finally{
    			DBUtil.close(con);;
    		}
        	
    	
    }
    public List<Publicfood> byDatefind(String day){
    	Publicfood p =null;
    	 List<Publicfood> list =new  ArrayList<Publicfood>();
   	 Connection con = DBUtil.getConnection();
   	 String sql="SELECT * from publicfood WHERE publicdate=?";
   	 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, day);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				
				 p =new Publicfood();
				p.setId(rs.getInt("id"));
				p.setPulicdate(rs.getDate("publicdate"));
				p.setFoodname(rs.getString("foodname"));
				p.setSrc(rs.getString("src"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("获得连接或结果集失败");
		}finally{
			DBUtil.close(con);;
		}
   
    }
   public List<Publicfood> pagefind(int page){
	   ArrayList<Publicfood> list = new ArrayList();
  	 Connection con = DBUtil.getConnection();
  	 int star =(page-1)*6;
  	 String sql="select * from publicfood order by publicdate  LIMIT ?,6";
  	 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, star);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				Publicfood p =new Publicfood();
				p.setId(rs.getInt("id"));
				p.setPulicdate(rs.getDate("publicdate"));
				
				p.setFoodname(rs.getString("foodname"));
				p.setSrc(rs.getString("src"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("获得连接或结果集失败");
		}finally{
			DBUtil.close(con);;
		}
  	
   }
   public int countfood(){
	   int num=0;
	   Connection con = DBUtil.getConnection();
	   String sql= "select count(*) as number from publicfood ";
	   try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next()){
			num=rs.getInt("number");
		}
		  return num;
	} catch (SQLException e) {
		throw new RuntimeException("获得连接或结果集失败");
	}finally{
		DBUtil.close(con);;
	}
   }
   public List<Publicfood> bydate(int da){
	   ArrayList<Publicfood> list = new ArrayList();
  	 Connection con = DBUtil.getConnection();
  	 int star =(da-1)*2;
  	 String sql="select * from publicfood order by publicdate  LIMIT ?,2";
  	 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, star);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				Publicfood p =new Publicfood();
				p.setId(rs.getInt("id"));
				p.setPulicdate(rs.getDate("publicdate"));
				
				p.setFoodname(rs.getString("foodname"));
				p.setSrc(rs.getString("src"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("获得连接或结果集失败");
		}finally{
			DBUtil.close(con);;
		}
  	
   }
}
