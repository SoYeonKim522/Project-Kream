package com.example.kream.kotlin.src.main.shop_product_wishlist

import com.example.kream.kotlin.src.main.shop_product_wishlist.models.AddWishRequest
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.AddWishResponse
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.SizeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProdWishlistInterface {
    @GET("/api/products/{productIdx}/sizes")
    fun getAllSizeList(@Path("productIdx") productIdx:Int) : Call<SizeResponse>

    @POST("/api/products/{productIdx}/like")
    fun postWishlist(@Path("productIdx") productIdx: Int, @Body params : AddWishRequest):Call<AddWishResponse>

}