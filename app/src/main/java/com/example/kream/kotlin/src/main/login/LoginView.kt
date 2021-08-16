package com.example.kream.kotlin.src.main.login

import com.example.kream.kotlin.src.main.login.models.LoginResponse

interface LoginView {

    fun onPostLoginSuccess(response: LoginResponse)
    fun onPostLoginFailure(message:String)

}