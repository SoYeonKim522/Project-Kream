package com.example.kream.kotlin.src.main.signUp

import com.example.kream.kotlin.src.main.signUp.models.PostSignUpRequest
import com.example.kream.kotlin.src.main.signUp.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpRetrofitInterface {
    @POST("/api/users/sign-up")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
}