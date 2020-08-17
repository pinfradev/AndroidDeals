package com.anncode.offersandcoupons.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponObservable
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CouponViewModel: ViewModel() {
    private var couponObservable: CouponObservable = CouponObservable()
    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null
    fun callCoupons() {
        couponObservable.callCoupons()
    }

    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponObservable.getCoupons()
    }

    fun setCouponsInRecyclerAdapter(coupons: List<Coupon>) {
        recyclerCouponsAdapter?.setCouponsList(coupons)
        recyclerCouponsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCouponsAdapter(): RecyclerCouponsAdapter? {
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this, R.layout.card_coupon)
        return recyclerCouponsAdapter
    }

    fun getCouponAt(position: Int): Coupon? {
        var coupons: List<Coupon>? = getCoupons().value
        return coupons?.get(position)
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: CircleImageView, imageUrl: String?) {
            imageUrl?.let {
                if(it.isNotEmpty()) {
                    Picasso.get().load(it).into(imageView)
                }
            }
        }
    }

/*    fun getUrlAt(position: Int): String? {
        var coupons: List<Coupon>? = getCoupons().value
        var currentCoupon = coupons?.get(position)
        currentCoupon?.imageUrl
        if (currentCoupon?.url != null) {
            Picasso.get().load(currentCoupon?.url).resize(520,520).centerCrop().
        }
    }*/
}