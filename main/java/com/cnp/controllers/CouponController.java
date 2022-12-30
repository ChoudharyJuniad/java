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
import com.cnp.model.Coupon;
@WebServlet("/coupons")
public class CouponController extends HttpServlet{
	private CouponDao12 dao=new CouponDao12();

	public CouponController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ac = req.getParameter("action");
		if(ac.equals("create")) {
			createCoupon(req,res);
		}else if(ac.equals("find")){
			String coupon = req.getParameter("couponCode");
			Coupon coupon1 = dao.findByCode(coupon);
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.println(coupon1);
		}
	}

	private void createCoupon(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String couponCode = req.getParameter("coupon_Code");
		String  discount= req.getParameter("discount");
		String  expdate= req.getParameter("expdate");
		Coupon co=new Coupon();
		co.setCode(couponCode);
		co.setDiscount(new BigDecimal(discount));
		co.setExpdate(expdate);
		dao.save(co);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		System.out.println("done");
		out.print("<b>Coupon Create!!!</b>");
		out.print("<b><a href='index.html'>Home</a></b>");
		
	}
	

}
