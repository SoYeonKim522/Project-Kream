package com.example.kream.kotlin.src.main.shop_product_by_size

import com.example.kream.kotlin.src.main.shop_product_by_size.models.SellPriceBySizeResponse
import com.example.kream.kotlin.src.main.shop_product_by_size.models.BuyPriceBySizeResponse
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.SizeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProdBySizeRetrofitInterface {

//    @GET("/api/products/{productIdx}/purchase")
//    fun getBuyPriceBySize(@Path("productIdx") productIdx:Int) : Call<BuyPriceBySizeResponse>

    @GET("/api/bids/sale")
    fun getBuyPriceBySize(@Query("productIdx") productIdx:Int) : Call<BuyPriceBySizeResponse>

//    @GET("/api/products/{productIdx}/sale")
//    fun getSellPriceBySize(@Path("productIdx") productIdx:Int) : Call<SellPriceBySizeResponse>

    @GET("/api/bids/purchase")
    fun getSellPriceBySize(@Query("productIdx") productIdx:Int) : Call<SellPriceBySizeResponse>

}
