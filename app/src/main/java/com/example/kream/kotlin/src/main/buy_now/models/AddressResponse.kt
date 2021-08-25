package com.example.kream.kotlin.src.main.buy_now.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class AddressResponse(
    @SerializedName("result") val result: List<AddressResult>
) :BaseResponse()