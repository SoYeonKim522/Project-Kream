package com.example.kream.kotlin.src.main.style

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.style.models.StyleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StyleService (val view: StyleView) {

    private val styleInterface = ApplicationClass.sRetrofit.create((StyleInterface::class.java))

    fun tryGetStyle(){
        styleInterface.getStyleList().enqueue(object : Callback<StyleResponse>{
            override fun onResponse(call: Call<StyleResponse>, response: Response<StyleResponse>) {
                view.onGetStyleSuccess(response.body() as StyleResponse)
            }

            override fun onFailure(call: Call<StyleResponse>, t: Throwable) {
                view.onGetStyleFailure(t.message ?: "통신 오류")
            }
        })
    }

}