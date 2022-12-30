package com.cnp.dao;

import com.cnp.model.Coupon;

public interface CouponDao {
	public void save(Coupon cp);
	public Coupon findByCode(String code);

}
