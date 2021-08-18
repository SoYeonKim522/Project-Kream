package com.example.kream.kotlin.src.main.shop.models

import com.google.gson.annotations.SerializedName

data class CategoryResult(
    @SerializedName("categorylist") val categoryList: List<Categorylist>
)