package com.example.kream.kotlin.src.main.myPage.models

data class UserInfoResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: UserInfoResult
)