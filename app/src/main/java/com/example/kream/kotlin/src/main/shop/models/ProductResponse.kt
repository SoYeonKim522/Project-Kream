package com.example.kream.kotlin.src.main.shop.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("result") val result: Result
):BaseResponse()

data class Result(
    @SerializedName("productList") val productList: List<ProductResult>
)