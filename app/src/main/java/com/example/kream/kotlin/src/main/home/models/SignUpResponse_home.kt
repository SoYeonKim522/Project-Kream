package com.example.kream.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName
import com.example.kream.kotlin.config.BaseResponse

data class SignUpResponse_home(
        // 베이스 리스폰스를 상속 받았으므로, 아래 내용은 포함이 되었습니다.
        // @SerializedName("isSuccess") val isSuccess: Boolean,
        // @SerializedName("code") val code: Int,
        // @SerializedName("message") val message: String,
        @SerializedName("result") val result: ResultSignUp_home
) : BaseResponse()