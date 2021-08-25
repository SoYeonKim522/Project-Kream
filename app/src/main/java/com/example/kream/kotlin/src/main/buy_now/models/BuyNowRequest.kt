package com.example.kream.kotlin.src.main.buy_now.models

import com.google.gson.annotations.SerializedName

data class BuyNowRequest(
    @SerializedName("targetBidSaleIdx") val targetBidSaleIdx: Int,
    @SerializedName("productSizeIdx") val productSizeIdx: Int,
    @SerializedName("purchasePrice") val purchasePrice: Int,
    @SerializedName("point") val point: String,
    @SerializedName("inspectionFee") val inspectionFee: Int,
    @SerializedName("shippingFee") val shippingFee: Int,
    @SerializedName("totalPrice") val totalPrice: Int,
    @SerializedName("addressIdx") val addressIdx: Int
)