package com.example.kream.kotlin.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultSignUp_home(
        @SerializedName("userId") val userId: Int,
        @SerializedName("jwt") val jwt: String
)