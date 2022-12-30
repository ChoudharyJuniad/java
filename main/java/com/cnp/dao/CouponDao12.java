package com.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cnp.model.Coupon;
import com.cnp.util.ConnectionUtil;

public class CouponDao12 implements CouponDao{

	@Override
	public void save(Coupon cp) {
	 Connection con = ConnectionUtil.getConnection();
	 try {
		 System.out.println("done");
		PreparedStatement st=con.prepareStatement("insert into products(coupon_code,discount,expdate) value(?,?,?)");
		st.setString(1, cp.getCode());
		st.setBigDecimal(2, cp.getDiscount());
		st.setString(3, cp.getExpdate());
		st.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public Coupon findByCode(String code) {
		Coupon cp1=new Coupon();
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement sta = connection.prepareStatement("select * from products where coupon_code=?");
			sta.setString(1, code);
			ResultSet rs = sta.executeQuery();
			while(rs.next()) {
             cp1.setId(rs.getInt(1));
             cp1.setCode(rs.getString(2));
             cp1.setDiscount(rs.getBigDecimal(3));
             cp1.setExpdate(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cp1;
	}


	}


