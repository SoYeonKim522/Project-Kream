package com.example.kream.kotlin.config

import android.app.Application
import android.content.SharedPreferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// 앱이 실행될때 1번만 실행
class ApplicationClass : Application() {

    // 테스트 서버 주소
//     val API_URL = "http://dev.rp3-kream.shop/"

    // 실 서버 주소
     val API_URL = "http://prod.rp3-kream.shop/"

    // 코틀린의 전역변수 문법. 다른 곳에서 [클래스명(ApplicationClass)].[변수명] 으로 참조 가능
    companion object {
        lateinit var sSharedPreferences: SharedPreferences
        lateinit var editor: SharedPreferences.Editor

        // JWT Token Header 키 값
        val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"
        val USER_IDX = "userIdx"

        // Retrofit 인스턴스, 앱 실행시 한번만 생성하여 사용
        lateinit var sRetrofit: Retrofit
    }

    // 앱이 처음 생성되는 순간, SP를 새로 만들어주고, 레트로핏 인스턴스를 생성
    override fun onCreate() {
        super.onCreate()
        sSharedPreferences =
            applicationContext.getSharedPreferences("KREAM_SP", MODE_PRIVATE)

        editor = sSharedPreferences.edit()

        // 레트로핏 인스턴스 생성
        initRetrofitInstance()
    }

    // 레트로핏 인스턴스를 생성하고, 레트로핏에 각종 설정값들을 지정
    // HttpLoggingInterceptor를 붙여서 어떤 요청이 나가고 들어오는지를 보여주기
    private fun initRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)   //읽기 작업의 타임아웃
            .connectTimeout(5000, TimeUnit.MILLISECONDS)   //커넥션 작업의 타임아웃
            // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용 볼 수 있음
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()

        // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson을 넣어주고 빌드
        // 이 전역변수로 http 요청을 서버로 보내기
        sRetrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}