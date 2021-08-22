package com.example.kream.kotlin.src.main.home

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.home.models.MainBannerResponse
import com.example.kream.kotlin.src.main.home.models.ThemeProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val view: HomeFragmentView) {

private val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
    fun tryGetThemeProduct(){
        homeRetrofitInterface.getThemeProduct().enqueue(object :Callback<ThemeProductResponse>{
            override fun onResponse(call: Call<ThemeProductResponse>, response: Response<ThemeProductResponse>) {
                view.onGetThemeProductSuccess(response.body() as ThemeProductResponse)
            }

            override fun onFailure(call: Call<ThemeProductResponse>, t: Throwable) {
                view.onGetThemeProductFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryMainBanner(){
        homeRetrofitInterface.getMainBanner().enqueue(object :Callback<MainBannerResponse>{
            override fun onResponse(call: Call<MainBannerResponse>, response: Response<MainBannerResponse>) {
                view.onGetMainBannerSuccess(response.body() as MainBannerResponse)
            }

            override fun onFailure(call: Call<MainBannerResponse>, t: Throwable) {
                view.onGetMainBannerFailure(t.message ?: "통신 오류")
            }
        })
    }

    //실습
//    fun tryGetUserSearch(word : String){
//        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
//        homeRetrofitInterface.getUserSearch(word).enqueue(object : Callback<UserSearchResponse> {
//            override fun onResponse(
//                call: Call<UserSearchResponse>,response: Response<UserSearchResponse>
//            ) {  //home fragment view 에 있는 함수 호출
//                view.onGetUserSearchSuccess(response.body() as UserSearchResponse)
//            }
//
//            override fun onFailure(call: Call<UserSearchResponse>, t: Throwable) {
//                view.onGetUserSearchFailure(t.message ?: "통신 오류")
//            }
//
//        })
//    }

}
