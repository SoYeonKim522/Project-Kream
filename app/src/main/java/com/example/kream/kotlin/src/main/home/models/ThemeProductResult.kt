package com.example.kream.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ThemeProductResult(
    @SerializedName("categoryName") val categoryName: String,
    @SerializedName("description") val description: String,
    @SerializedName("position") val position: Int,
    @SerializedName("productList") val productList: List<ThemeProductList>
)