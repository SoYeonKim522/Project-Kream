package com.example.kream.kotlin.src.main.buy_now.models

import com.google.gson.annotations.SerializedName

data class AddressResult(
    @SerializedName("address") val address: String,
    @SerializedName("addressDetail") val addressDetail: String,
    @SerializedName("defaultAddress") val defaultAddress: String,
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("zipCode") val zipCode: String
)