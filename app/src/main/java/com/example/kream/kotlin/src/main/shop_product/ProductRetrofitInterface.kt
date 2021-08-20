package com.example.kream.kotlin.src.main.shop_product

import com.example.kream.kotlin.src.main.shop_product.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductRetrofitInterface {

    @GET("/api/products/{productIdx}")
    fun getProductDescription(@Path("productIdx") productIdx:Int) : Call<ProductDescriptionResponse>

    @GET("/api/transactions/{productIdx}")
    fun getProductSalesRecord(@Path("productIdx") productIdx:Int) : Call<SalesResponse>

    @GET("/api/bids/sale/{productIdx}")
    fun getProductAsksRecord(@Path("productIdx") productIdx:Int) : Call<AsksResponse>

    @GET("/api/bids/purchase/{productIdx}")
    fun getProductBidsRecord(@Path("productIdx") productIdx:Int) : Call<BidsResponse>

    @GET("/api/products/{productIdx}/others")
    fun getProductRecommend(@Path("productIdx") productIdx: Int) : Call<RecommendResponse>
}