package com.example.kream.kotlin.src.main.login.models

import com.google.gson.annotations.SerializedName

data class LoginResult(
    @SerializedName("userIdx") val userIdx:String,
    @SerializedName("accessToken") val token:String

)
