package com.example.kream.kotlin.src.main.checkout.models

import com.google.gson.annotations.SerializedName

data class CheckoutResult(
    @SerializedName("bidPurchaseIdx") val bidPurchaseIdx: Int,
    @SerializedName("inspectionFee") val inspectionFee: Int,
    @SerializedName("paymentAmount") val paymentAmount: Int,
    @SerializedName("pointUsed") val pointUsed: Int,
    @SerializedName("productPrice") val productPrice: Int,
    @SerializedName("shippingFee") val shippingFee: Int,
    @SerializedName("status") val status: String,
    @SerializedName("thumbnail") val thumbnail: String
)