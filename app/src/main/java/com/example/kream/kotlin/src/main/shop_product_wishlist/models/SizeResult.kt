package com.example.kream.kotlin.src.main.shop_product_wishlist.models

import com.google.gson.annotations.SerializedName

data class SizeResult(
    @SerializedName("sizeList") val sizeList: List<SizeList>
)