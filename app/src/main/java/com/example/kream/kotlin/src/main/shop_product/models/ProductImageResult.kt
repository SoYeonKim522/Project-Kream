package com.example.kream.kotlin.src.main.shop_product.models

import com.google.gson.annotations.SerializedName

data class ProductImageResult(
    @SerializedName("image") val imageUrl: String,
    @SerializedName("position") val position: Int
)