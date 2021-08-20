package com.example.kream.kotlin.src.main.shop.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("result") val result: ProdResult
):BaseResponse()

data class ProdResult(
    @SerializedName("productList") val productList: List<ProductResult>
)