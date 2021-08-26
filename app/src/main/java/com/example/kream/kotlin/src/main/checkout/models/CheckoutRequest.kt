package com.example.kream.kotlin.src.main.checkout.models

import com.google.gson.annotations.SerializedName

data class CheckoutRequest(
    @SerializedName("targetBidSaleIdx") val targetBidSaleIdx: Int,
    @SerializedName("cardIdx") val cardIdx: Int
)