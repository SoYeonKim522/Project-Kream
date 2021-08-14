package com.example.kream.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName

//실습
data class ResultUserSearch (
    @SerializedName("userId") val userId: Int,
    @SerializedName("email") val email: String

        )