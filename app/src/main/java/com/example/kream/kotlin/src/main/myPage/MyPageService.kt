package com.example.kream.kotlin.src.main.myPage

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.myPage.models.UserInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageService (val view:MyPageView) {

    fun tryGetUserInfo(userIdx: String) {
        val myPageInterface = ApplicationClass.sRetrofit.create((MyPageInterface::class.java))
        myPageInterface.getProductCategory(userIdx).enqueue(object : Callback<UserInfoResponse> {
            override fun onResponse(
                call: Call<UserInfoResponse>,
                response: Response<UserInfoResponse>
            ) {
                view.onTryGetUserInfoSuccess(response.body() as UserInfoResponse)
            }

            override fun onFailure(call: Call<UserInfoResponse>, t: Throwable) {
                view.onTryGetUserInfoFailure(t.message ?: "통신 오류")
            }
        })

    }
}