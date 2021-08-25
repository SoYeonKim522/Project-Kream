package com.example.kream.kotlin.src.main.style.models

import com.google.gson.annotations.SerializedName

data class StyleImage(
    @SerializedName("image") val image: String,
    @SerializedName("position") val position: Int
)