package com.example.kream.kotlin.src.main.myPage

import com.example.kream.kotlin.src.main.myPage.models.UserInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyPageInterface {

    @GET("api/users/{userIdx}")
    fun getProductCategory(@Path("userIdx") userIdx:String) : Call<UserInfoResponse>

}