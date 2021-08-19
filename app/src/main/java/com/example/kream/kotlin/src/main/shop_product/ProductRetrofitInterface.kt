package com.example.kream.kotlin.src.main.shop_product

import com.example.kream.kotlin.src.main.shop_product.models.ProductDescriptionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductRetrofitInterface {

    @GET("/api/products/{productIdx}")
    fun getProductDescription(@Path("productIdx") productIdx:Int) : Call<ProductDescriptionResponse>

}