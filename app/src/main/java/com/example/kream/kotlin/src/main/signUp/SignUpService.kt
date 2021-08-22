package com.example.kream.kotlin.src.main.signUp

import android.util.Log
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.signUp.models.PostSignUpRequest
import com.example.kream.kotlin.src.main.signUp.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpService(val view: SignUpActivity) {
    private val TAG = "log"

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest){
        val signUpInterface = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        signUpInterface.postSignUp(postSignUpRequest).enqueue(object :
            Callback<SignUpResponse> {
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                Log.d(TAG, "onResponse: 서비스")
                Log.d(TAG, "onResponse2: ${response}")
                Log.d(TAG, "onResponse2: ${response.body()}")

                view.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: 서비스")
                view.onPostSignUpFailure(t.message ?: "통신 오류")
            }

        })
    }
}