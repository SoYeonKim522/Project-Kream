package com.example.kream.kotlin.src.main.address.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class AddAddressResponse(
    @SerializedName("result") val result: AddAddressResult
) : BaseResponse()