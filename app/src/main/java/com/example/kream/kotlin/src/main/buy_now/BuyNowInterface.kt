package com.example.kream.kotlin.src.main.buy_now

import com.example.kream.kotlin.src.main.buy_now.models.AddressResponse
import com.example.kream.kotlin.src.main.buy_now.models.BuyNowRequest
import com.example.kream.kotlin.src.main.buy_now.models.BuyNowResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BuyNowInterface {

    @GET("/api/users/{userIdx}/addresses")
    fun getAddressList(@Path("userIdx") userIdx:Int) : Call<AddressResponse>

    @POST("/api/products/{productIdx}/purchase-now")
    fun postBuyNowRequest(@Path("productIdx") productIdx :Int, @Body params: BuyNowRequest): Call<BuyNowResponse>

}