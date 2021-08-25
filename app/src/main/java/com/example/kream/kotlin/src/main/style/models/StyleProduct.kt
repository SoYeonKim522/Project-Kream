package com.example.kream.kotlin.src.main.style.models

import com.google.gson.annotations.SerializedName

data class StyleProduct(
    @SerializedName("buyPrice") val buyPrice: Int,
    @SerializedName("idx") val idx: Int,
    @SerializedName("name") val name: String,
    @SerializedName("thumbnail") val thumbnail: String
)