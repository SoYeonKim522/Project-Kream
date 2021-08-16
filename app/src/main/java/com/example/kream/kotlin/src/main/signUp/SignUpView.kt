package com.example.kream.kotlin.src.main.signUp

import com.example.kream.kotlin.src.main.signUp.models.SignUpResponse

interface SignUpView {

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}