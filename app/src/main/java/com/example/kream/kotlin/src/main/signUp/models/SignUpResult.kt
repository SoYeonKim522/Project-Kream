package com.example.kream.kotlin.src.main.signUp.models

import com.google.gson.annotations.SerializedName

data class SignUpResult(
    @SerializedName("email") val email:String
)
