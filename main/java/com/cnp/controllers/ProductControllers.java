
package com.cnp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnp.dao.CouponDao12;
import com.cnp.dao.ProductDao12;
import com.cnp.model.Coupon;
import com.cnp.model.Product;

@WebServlet("/productsss")
public class ProductControllers extends HttpServlet{
	
	CouponDao12 cd=new CouponDao12();
	ProductDao12 pd=new ProductDao12();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		String coup= req.getParameter("couponcode");
		
	Coupon c = cd.findByCode(coup);

		Product p=new Product();
		p.setName(name);
		p.setDescription(description);
		p.setPrice(new BigDecimal(price).subtract(c.getDiscount()));
		pd.save(p);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print(p);
	
		out.print("<b>Product Create</b>");
		out.print("<br><a href='index.html'>Home</br>");
	}

}
