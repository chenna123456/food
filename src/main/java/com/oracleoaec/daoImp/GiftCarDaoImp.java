package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.GiftCarDao;
import com.oracleoaec.entity.GiftCar;
import com.oracleoaec.util.DBUtil;

public class GiftCarDaoImp implements GiftCarDao {

	public List<GiftCar> findGiftCarByVipid(int vipid) {
		String sql="select * from giftcar where vipid=? order by exchangeDate desc";
		Connection conn = DBUtil.getConnection();
		try { 
			List<GiftCar> list=new ArrayList<GiftCar>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vipid);
			ResultSet re = ps.executeQuery();
			while(re.next()){
				GiftCar gif=new GiftCar();
				gif.setId(re.getInt("id"));
				gif.setVipId(re.getInt("vipId"));
				gif.setNumber(re.getInt("number"));
				gif.setGitfId(re.getInt("giftId"));
				gif.setExchangeDate( re.getTimestamp("exchangeDate"));
				list.add(gif);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
	}

	public List<GiftCar> findGiftCarBygiftid(int gitfid) {
		// TODO Auto-generated method stub
		return null;
	}

	public GiftCar findGiftCar(int vipid, int giftid) {
		String sql="select number from giftcar where vipid=? and giftid=?";
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vipid);
			ps.setInt(2, giftid);
			ResultSet re = ps.executeQuery();
			if(re.next()){
				GiftCar g=new GiftCar();
				g.setNumber(re.getInt("number"));
				return g;
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
	}

	public int addGiftCar(GiftCar giftCar) {
		Integer giftId = giftCar.getGitfId();
		Integer vipId = giftCar.getVipId();
		GiftCar gift = findGiftCar(vipId, giftId);
		System.out.println("gift"+gift);
		String sql="";
		if(gift==null){
			sql="insert into giftcar(number,exchangeDate,vipid,giftid) "
					+ "values(?,?,?,?)";
		}else{
			giftCar.setNumber(giftCar.getNumber()+gift.getNumber());
			sql="update giftcar set number=?,exchangeDate=? where  vipid=? and giftid=?";		}
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, giftCar.getNumber());
			ps.setDate(2, new java.sql.Date(giftCar.getExchangeDate().getTime()));
			ps.setInt(3, giftCar.getVipId());
			ps.setInt(4, giftCar.getGitfId());
			int i = ps.executeUpdate();
			return i;
		} catch (SQLException e) {
			throw new RuntimeException("获取prepareStatement对象或结果集失败"+e);
		}finally {
			DBUtil.close(conn);
		}
	}

	public void deleteGiftCar(GiftCar giftCar) {
		// TODO Auto-generated method stub

	}

	public void updateGiftCar(GiftCar giftCar) {
		// TODO Auto-generated method stub

	}


}
