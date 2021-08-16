package com.example.kream.kotlin.src.main.home

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.home.models.PostSignUpRequest_home
import com.example.kream.kotlin.src.main.home.models.SignUpResponse_home
import com.example.kream.kotlin.src.main.home.models.UserResponse
import com.example.kream.kotlin.src.main.home.models.UserSearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val view: HomeFragmentView) {

    fun tryGetUsers(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getUsers().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                view.onGetUserSuccess(response.body() as UserResponse)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                view.onGetUserFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest_home){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<SignUpResponse_home>{
            override fun onResponse(call: Call<SignUpResponse_home>, response: Response<SignUpResponse_home>) {
                view.onPostSignUpSuccess(response.body() as SignUpResponse_home)
            }

            override fun onFailure(call: Call<SignUpResponse_home>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?: "통신 오류")
            }
        })
    }

    //실습
    fun tryGetUserSearch(word : String){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getUserSearch(word).enqueue(object : Callback<UserSearchResponse> {
            override fun onResponse(
                call: Call<UserSearchResponse>,response: Response<UserSearchResponse>
            ) {  //home fragment view 에 있는 함수 호출
                view.onGetUserSearchSuccess(response.body() as UserSearchResponse)
            }

            override fun onFailure(call: Call<UserSearchResponse>, t: Throwable) {
                view.onGetUserSearchFailure(t.message ?: "통신 오류")
            }

        })
    }

}
