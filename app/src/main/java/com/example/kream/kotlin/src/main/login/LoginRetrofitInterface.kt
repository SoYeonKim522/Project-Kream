package com.example.kream.kotlin.src.main.login

import com.example.kream.kotlin.src.main.login.models.LoginResponse
import com.example.kream.kotlin.src.main.login.models.PostLoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {
    @POST("/api/users/sign-in")
    fun postLogin(@Body params : PostLoginRequest): Call<LoginResponse>
}