package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.databinding.ActivityMainBinding
import com.anncode.offersandcoupons.model.ApiAdapter
import com.anncode.offersandcoupons.viewmodel.CouponViewModel
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var couponViewModel: CouponViewModel? = null
    private var rvCoupons: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        setupBindings(savedInstanceState)


    }

    //here it is set in action de binding for the app
    fun setupBindings(savedInstanceState: Bundle?) {
        var activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        couponViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)
        activityMainBinding.model = couponViewModel
        setUpListUpdate()
    }

    fun setUpListUpdate() {
        couponViewModel?.callCoupons()
        couponViewModel?.getCoupons()?.observe(this, Observer{ coupons: List<Coupon> ->
            Log.w("COUPON", coupons.get(0).title)
            couponViewModel?.setCouponsInRecyclerAdapter(coupons)
        })
    }

}
