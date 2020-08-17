package com.anncode.offersandcoupons.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.view.RecyclerCouponsAdapter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl(): CouponRepository {

    private var coupons = MutableLiveData<List<Coupon>>()
    override fun getCoupons(): MutableLiveData<List<Coupon>> {
        return coupons
    }
    //Subject: MutableLiveData
    //Observers: List Coupons. Change ListCoupons -> mutableLiveData


    //Toda la lógica de conexión
    override fun callCouponsAPI() {
        var couponsList: ArrayList<Coupon>? = ArrayList()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()
        call.enqueue(object: Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.message?.let { Log.e("ERROR", it) }
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                var offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach {jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    couponsList?.add(coupon)
                }
                coupons.value = couponsList
            }

        })
    }


}