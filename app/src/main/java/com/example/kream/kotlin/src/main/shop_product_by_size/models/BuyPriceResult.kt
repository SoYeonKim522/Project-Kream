package com.example.kream.kotlin.src.main.shop_product_by_size.models

import com.google.gson.annotations.SerializedName

data class BuyPriceResult(
    @SerializedName("bidSaleIdx") val bidSaleIdx: Any,
    @SerializedName("buyPrice") val buyPrice: Int,
    @SerializedName("productSize") val productSize: String
)