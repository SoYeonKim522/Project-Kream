package com.example.kream.kotlin.src.main.shop.models

import com.google.gson.annotations.SerializedName

data class DetailCategory(
    @SerializedName("idx") val idx: Int,
    @SerializedName("image") val imageUrl: String,
    @SerializedName("name") val name: String,
    @SerializedName("position") val position: Int
)