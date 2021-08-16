package com.example.kream.kotlin.src.main.signUp.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class SignUpResponse (
    @SerializedName("result") val result: SignUpResult
) : BaseResponse()