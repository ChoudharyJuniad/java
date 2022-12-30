package com.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cnp.model.Product;
import com.cnp.util.ConnectionUtil;

public class ProductDao12 implements ProductDao{

	@Override
	public void save(Product p) {
		Connection con = ConnectionUtil.getConnection();
		
		try {
			PreparedStatement st = con.prepareStatement("insert into controller(name,description,price) values(?,?,?)");
			st.setString(1, p.getName());
			st.setString(2, p.getDescription());
			st.setBigDecimal(3, p.getPrice());
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
