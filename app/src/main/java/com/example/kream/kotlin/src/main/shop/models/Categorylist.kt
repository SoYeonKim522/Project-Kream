package com.example.kream.kotlin.src.main.shop.models

import com.google.gson.annotations.SerializedName

data class Categorylist(
    @SerializedName("category") val category: String,
    @SerializedName("detailCategoryList") val detailCategoryList: List<DetailCategory>,
    @SerializedName("idx") val idx: Int,
    @SerializedName("position") val position: Int
)