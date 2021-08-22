package com.example.kream.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ThemeProductList(
    @SerializedName("brandLogo") val brandLogo: String,
    @SerializedName("brandName") val brandName: String,
    @SerializedName("buyPrice") val buyPrice: Int,
    @SerializedName("productIdx") val productIdx: Int,
    @SerializedName("productImage") val productImage: String,
    @SerializedName("productName") val productName: String
)