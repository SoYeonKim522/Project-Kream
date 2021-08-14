package com.example.kream.kotlin.src.main.home

import com.example.kream.kotlin.src.main.home.models.PostSignUpRequest
import com.example.kream.kotlin.src.main.home.models.SignUpResponse
import com.example.kream.kotlin.src.main.home.models.UserResponse
import com.example.kream.kotlin.src.main.home.models.UserSearchResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {
    @GET("/users")
    fun getUsers() : Call<UserResponse>

    @POST("/users")
    fun postSignUp(@Body params: PostSignUpRequest): Call<SignUpResponse>
    //ㄴ바디로 PostSignUpRequest 에 있는 정보들을 넘겨주면,
    // SignUpResponse 에서 정해준 형식(=ResultSignUp 형식을 포함함)대로 response 를 줄 것이다

    @GET("/users")  //실습
    fun getUserSearch(@Query ("word") word:String) : Call<UserSearchResponse>

}
