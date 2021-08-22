package com.example.kream.kotlin.src.main.home.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class ThemeProductResponse(
    @SerializedName("result") val result: List<ThemeProductResult>
) : BaseResponse()