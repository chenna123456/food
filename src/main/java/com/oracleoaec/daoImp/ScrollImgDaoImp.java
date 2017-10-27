package com.oracleoaec.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oracleoaec.dao.ScrollImgDao;
import com.oracleoaec.entity.ScrollImg;
import com.oracleoaec.util.DBUtil;

public class ScrollImgDaoImp implements ScrollImgDao{

	public List<ScrollImg> findImg() {
		List<ScrollImg> list = new ArrayList<ScrollImg>();
		Connection con = DBUtil.getConnection();
		String sql = "select * from luboimg";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				ScrollImg img = new ScrollImg();
				img.setId(rs.getInt("id"));
				img.setSrc(rs.getString("imgsrc"));
				list.add(img);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询图片失败",e);
		}finally{
			DBUtil.close(con);
		}
		return list;
	}

}
