package com.example.kream.kotlin.src.main.shop_product.models

import com.google.gson.annotations.SerializedName

data class SalesTransaction(
    @SerializedName("productSize") val productSize: String,
    @SerializedName("transactedAt")val transactedAt: String,
    @SerializedName("transactedPrice") val transactedPrice: Int
)