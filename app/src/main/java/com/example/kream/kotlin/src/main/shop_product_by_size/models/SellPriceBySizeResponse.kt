package com.example.kream.kotlin.src.main.shop_product_by_size.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class SellPriceBySizeResponse(
    @SerializedName("result") val result: List<SellPriceResult>
):BaseResponse()