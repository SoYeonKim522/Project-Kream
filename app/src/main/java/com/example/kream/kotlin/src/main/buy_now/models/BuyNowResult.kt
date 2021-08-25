package com.example.kream.kotlin.src.main.buy_now.models

import com.google.gson.annotations.SerializedName

data class BuyNowResult(
    @SerializedName("address") val address: String,
    @SerializedName("addressDetail") val addressDetail: String,
    @SerializedName("addressName") val addressName: String,
    @SerializedName("bidPurchaseIdx") val bidPurchaseIdx: Int,
    @SerializedName("buyPrice") val buyPrice: Int,
    @SerializedName("inspectionFee") val inspectionFee: Int,
    @SerializedName("productModelNo") val productModelNo: String,
    @SerializedName("productName") val productName: String,
    @SerializedName("productSize") val productSize: String,
    @SerializedName("productThumbnail") val productThumbnail: String,
    @SerializedName("shippingFee") val shippingFee: Int,
    @SerializedName("status") val status: String,
    @SerializedName("targetBidSaleIdx") val targetBidSaleIdx: Int,
    @SerializedName("totalPrice") val totalPrice: Int,
    @SerializedName("zipCode") val zipCode: String
)