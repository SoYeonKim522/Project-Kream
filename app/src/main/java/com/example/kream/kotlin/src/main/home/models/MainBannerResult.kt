package com.example.kream.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName

data class MainBannerResult(
    @SerializedName("image") val image: String,
    @SerializedName("position") val position: Int,
    @SerializedName("productIdx") val productIdx: Int

)