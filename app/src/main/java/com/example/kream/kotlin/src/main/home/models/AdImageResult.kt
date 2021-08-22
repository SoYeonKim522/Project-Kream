package com.example.kream.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName

data class AdImageResult(
    @SerializedName("description")  val description: String,
    @SerializedName("idx")  val idx: Int,
    @SerializedName("image")  val image: String,
    @SerializedName("name")  val name: String,
    @SerializedName("position")  val position: Int
)