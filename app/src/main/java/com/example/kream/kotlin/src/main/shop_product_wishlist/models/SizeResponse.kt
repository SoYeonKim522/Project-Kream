package com.example.kream.kotlin.src.main.shop_product_wishlist.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class SizeResponse(
    @SerializedName("result") val result: SizeResult
) : BaseResponse()