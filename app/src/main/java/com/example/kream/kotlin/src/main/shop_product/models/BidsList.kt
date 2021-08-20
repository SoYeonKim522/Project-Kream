package com.example.kream.kotlin.src.main.shop_product.models

import com.google.gson.annotations.SerializedName

data class BidsList(
    @SerializedName("bidPrice") val bidPrice: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("productSize") val productSize: String
)