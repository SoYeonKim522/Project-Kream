package com.example.kream.kotlin.src.main.shop.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("result") val result: CategoryResult
) : BaseResponse()