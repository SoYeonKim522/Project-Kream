package com.example.kream.kotlin.src.main.shop_product.models

import com.google.gson.annotations.SerializedName

data class RecResult(
    @SerializedName("brandName") val brandName: String,
    @SerializedName("otherList") val otherList: List<RecList>
)