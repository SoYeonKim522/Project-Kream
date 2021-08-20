package com.example.kream.kotlin.src.main.shop_product.models

import com.google.gson.annotations.SerializedName

data class RecList(
    @SerializedName("brandLogo") val brandLogo: String,
    @SerializedName("brandName") val brandName: String,
    @SerializedName("buyPrice") val buyPrice: Int,
    @SerializedName("idx") val idx: Int,
    @SerializedName("name") val name: String,
    @SerializedName("thumbnail") val thumbnail: String
)