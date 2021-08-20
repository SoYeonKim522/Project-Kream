package com.example.kream.kotlin.src.main.shop_product.models

import com.google.gson.annotations.SerializedName

data class BidsResponse(
    @SerializedName("result") val result: BidsResult
)