package com.example.kream.kotlin.src.main.shop_product.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class AsksResponse(
    @SerializedName("result") val result: AsksResult
):BaseResponse()