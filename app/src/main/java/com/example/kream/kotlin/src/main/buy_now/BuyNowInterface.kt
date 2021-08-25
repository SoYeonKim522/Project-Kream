package com.example.kream.kotlin.src.main.buy_now

import com.example.kream.kotlin.src.main.buy_now.models.AddressResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BuyNowInterface {

    @GET("/api/users/{userIdx}/addresses")
    fun getAddressList(@Path("userIdx") userIdx:Int) : Call<AddressResponse>

}