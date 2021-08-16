package com.example.kream.kotlin.src.main.login.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("result") val result: LoginResult
) : BaseResponse()
