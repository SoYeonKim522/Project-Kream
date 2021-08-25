package com.example.kream.kotlin.src.main.style.models

import com.example.kream.kotlin.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class StyleResponse(
    @SerializedName("result") val result: StyleResult
):BaseResponse()