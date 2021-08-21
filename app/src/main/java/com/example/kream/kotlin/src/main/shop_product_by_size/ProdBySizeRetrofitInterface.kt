package com.example.kream.kotlin.src.main.shop_product_by_size

import com.example.kream.kotlin.src.main.shop_product_by_size.models.SellPriceBySizeResponse
import com.example.kream.kotlin.src.main.shop_product_by_size.models.BuyPriceBySizeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProdBySizeRetrofitInterface {
    @GET("/api/products/{productIdx}/purchase")
    fun getBuyPriceBySize(@Path("productIdx") productIdx:Int) : Call<BuyPriceBySizeResponse>

    @GET("/api/products/{productIdx}/sale")
    fun getSellPriceBySize(@Path("productIdx") productIdx:Int) : Call<SellPriceBySizeResponse>

}