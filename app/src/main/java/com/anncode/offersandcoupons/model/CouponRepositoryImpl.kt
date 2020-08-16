package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponPresenter

class CouponRepositoryImpl(var couponPresenter: CouponPresenter): CouponRepository {

    //Toda la lógica de conexión
    override fun getCouponsAPI() {
       // couponPresenter.showCoupons()
    }
}