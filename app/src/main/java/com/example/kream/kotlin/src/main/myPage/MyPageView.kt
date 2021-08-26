package com.example.kream.kotlin.src.main.myPage

import com.example.kream.kotlin.src.main.myPage.models.UserInfoResponse

interface MyPageView {

    fun onTryGetUserInfoSuccess(response: UserInfoResponse)
    fun onTryGetUserInfoFailure(message:String)
}