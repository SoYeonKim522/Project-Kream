package com.example.kream.kotlin.src.main.signUp.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest (
    @SerializedName("email") val email: String,
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("password") val password: String
)