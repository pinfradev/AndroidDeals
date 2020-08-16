package com.anncode.offersandcoupons.view

import com.anncode.offersandcoupons.model.Coupon

interface CouponView {
    //Presentador
    fun getCoupons()
    //Vista
    fun showCoupons(coupons: ArrayList<Coupon>?)
}