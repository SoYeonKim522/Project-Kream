package com.example.kream.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName
import com.example.kream.kotlin.config.BaseResponse

//실습
data class UserSearchResponse (
//    @SerializedName("isSuccess") val isSuccess: Boolean,
//    @SerializedName("code") val code: Int,
//    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<ResultUserSearch>
    ):BaseResponse()

