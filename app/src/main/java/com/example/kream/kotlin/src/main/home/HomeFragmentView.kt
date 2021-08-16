package com.example.kream.kotlin.src.main.home

import com.example.kream.kotlin.src.main.home.models.SignUpResponse_home
import com.example.kream.kotlin.src.main.home.models.UserResponse
import com.example.kream.kotlin.src.main.home.models.UserSearchResponse

interface HomeFragmentView {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse_home)

    fun onPostSignUpFailure(message: String)

    //실습
    fun onGetUserSearchSuccess(response: UserSearchResponse)  // 성공시 userSearchResponse (data class) 형태로 res를 넘겨줌
    fun onGetUserSearchFailure(message: String)
}