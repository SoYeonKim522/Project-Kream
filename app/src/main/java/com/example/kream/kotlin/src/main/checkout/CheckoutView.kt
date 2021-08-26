package com.example.kream.kotlin.src.main.checkout

import com.example.kream.kotlin.src.main.checkout.models.CheckoutResponse

interface CheckoutView {
    fun onPostCheckoutSuccess(response: CheckoutResponse)
    fun onPostCheckoutFailure(message:String)
}