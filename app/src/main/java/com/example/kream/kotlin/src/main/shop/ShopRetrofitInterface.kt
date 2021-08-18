package com.example.kream.kotlin.src.main.shop

import com.example.kream.kotlin.src.main.shop.models.CategoryResponse
import com.example.kream.kotlin.src.main.shop.models.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopRetrofitInterface {

    @GET("/api/products/category")
    fun getProductCategory(@Query("exposure") exposure:String) : Call<CategoryResponse>

    @GET("/api/products")
    fun getProducts() : Call<ProductResponse>

}