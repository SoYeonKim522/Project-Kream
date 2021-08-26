package com.example.kream.kotlin.src.main.style.models

import com.google.gson.annotations.SerializedName

data class StyleList(
    @SerializedName("commented") val commented: Int,
    @SerializedName("content") val content: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("idx") val idx: Int,
    @SerializedName("images") val images: List<StyleImage>,
    @SerializedName("liked") val liked: Int,
    @SerializedName("products") val products: List<StyleProduct>,
    @SerializedName("userNickName") val userNickName: String,
    @SerializedName("userProfileImage") val userProfileImage: String
)