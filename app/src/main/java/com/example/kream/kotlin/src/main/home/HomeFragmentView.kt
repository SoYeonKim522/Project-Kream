package com.example.kream.kotlin.src.main.home

import com.example.kream.kotlin.src.main.home.models.MainBannerResponse
import com.example.kream.kotlin.src.main.home.models.ThemeProductResponse

interface HomeFragmentView {

    fun onGetThemeProductSuccess(response: ThemeProductResponse)
    fun onGetThemeProductFailure(message:String)

    fun onGetMainBannerSuccess(response: MainBannerResponse)
    fun onGetMainBannerFailure(message: String)

    //실습
//    fun onGetUserSearchSuccess(response: UserSearchResponse)  // 성공시 userSearchResponse (data class) 형태로 res를 넘겨줌
//    fun onGetUserSearchFailure(message: String)
}