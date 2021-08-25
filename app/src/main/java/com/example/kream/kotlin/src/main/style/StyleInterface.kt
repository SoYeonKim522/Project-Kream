package com.example.kream.kotlin.src.main.style

import com.example.kream.kotlin.src.main.style.models.StyleResponse
import retrofit2.Call
import retrofit2.http.GET

interface StyleInterface {
    @GET("/api/styles")
    fun getStyleList(): Call<StyleResponse>
}