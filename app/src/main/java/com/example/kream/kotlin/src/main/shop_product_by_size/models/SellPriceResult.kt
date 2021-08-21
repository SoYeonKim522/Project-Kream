package com.example.kream.kotlin.src.main.shop_product_by_size.models

import com.google.gson.annotations.SerializedName

data class SellPriceResult(
    @SerializedName("bidSaleIdx") val bidSaleIdx: Any,
    @SerializedName("productSize") val productSize: String,
    @SerializedName("salePrice") val salePrice: Int
)