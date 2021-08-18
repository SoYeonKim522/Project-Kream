package com.example.kream.kotlin.src.main.shop.models

import com.google.gson.annotations.SerializedName

data class ProductResult(
    @SerializedName("brandLogo") val brandLogo: String,
    @SerializedName("brandName") val brandName: String,
    @SerializedName("buyPrice")val buyPrice: Int,
    @SerializedName("description") val description: String,
    @SerializedName("idx") val idx: Int,
    @SerializedName("liked") val liked: Int,
    @SerializedName("name") val name: String,
    @SerializedName("tagged") val tagged: Int,
    @SerializedName("thumbnail") val thumbnail: String
)