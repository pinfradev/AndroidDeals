package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponsInteractorImpl
import com.anncode.offersandcoupons.view.CouponView

class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {
    private var couponsInteractor: CouponsInteractorImpl = CouponsInteractorImpl(this)
    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        couponsInteractor.getCouponsAPI()
    }

}