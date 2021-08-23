package com.example.kream.kotlin.src.main.shop_product_by_size

import android.util.Log
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.shop_product_by_size.models.SellPriceBySizeResponse
import com.example.kream.kotlin.src.main.shop_product_by_size.models.BuyPriceBySizeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdBySizeService (val view: ProdBySizeView) {

    private val sizeInterface = ApplicationClass.sRetrofit.create((ProdBySizeRetrofitInterface::class.java))

    fun tryGetBuyPriceBySize(productIdx: Int){
        sizeInterface.getBuyPriceBySize(productIdx).enqueue(object : Callback<BuyPriceBySizeResponse>{
            override fun onResponse(call: Call<BuyPriceBySizeResponse>, response: Response<BuyPriceBySizeResponse>) {
                view.onGetBuyPriceBySizeSuccess(response.body() as BuyPriceBySizeResponse)
                Log.d("log", "서비스 onResponse:  ${response.body()}")
            }

            override fun onFailure(call: Call<BuyPriceBySizeResponse>, t: Throwable) {
                view.onGetBuyPriceBySizeFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryGetSellPriceBySize(productIdx: Int){
        sizeInterface.getSellPriceBySize(productIdx).enqueue(object : Callback<SellPriceBySizeResponse>{
            override fun onResponse(
                call: Call<SellPriceBySizeResponse>,
                response: Response<SellPriceBySizeResponse>
            ) {
                view.onGetSellPriceBySizeSuccess(response.body() as SellPriceBySizeResponse)
            }

            override fun onFailure(call: Call<SellPriceBySizeResponse>, t: Throwable) {
                view.onGetSellPriceBySizeFailure(t.message ?: "통신 오류")
            }

        })
    }



}