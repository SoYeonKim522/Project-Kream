package com.example.kream.kotlin.src.main.home

import com.example.kream.kotlin.src.main.home.models.AdImageResponse
import com.example.kream.kotlin.src.main.home.models.MainBannerResponse
import com.example.kream.kotlin.src.main.home.models.ThemeProductResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {

    @GET("/api/products/recommend")
    fun getThemeProduct() : Call<ThemeProductResponse>

    @GET("/api/banners")
    fun getMainBanner(@Query ("location") location: String) : Call<MainBannerResponse>

    @GET("/api/products/ads")
    fun getAdImage() : Call<AdImageResponse>

}
