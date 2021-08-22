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
    fun getMainBanner() : Call<MainBannerResponse>

    @GET("/api/products/ads")
    fun getAdImage() : Call<AdImageResponse>


//    @GET("/users")  //실습
//    fun getUserSearch(@Query ("word") word:String) : Call<UserSearchResponse>

}
