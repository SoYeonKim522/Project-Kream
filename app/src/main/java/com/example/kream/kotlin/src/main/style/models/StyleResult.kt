package com.example.kream.kotlin.src.main.style.models

import com.google.gson.annotations.SerializedName

data class StyleResult(
    @SerializedName("first") val first: Boolean,
    @SerializedName("last") val last: Boolean,
    @SerializedName("pageNumber") val pageNumber: Int,
    @SerializedName("styleList") val styleList: List<StyleList>,
    @SerializedName("totalElements") val totalElements: Int,
    @SerializedName("totalPages") val totalPages: Int
)