package com.example.kream.kotlin.src.main.checkout.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class CheckoutResponse(
    @SerializedName("result") val result: CheckoutResult
) :BaseResponse()