package com.example.kream.kotlin.src.main.shop_product_wishlist.models

import com.google.gson.annotations.SerializedName

data class SizeList(
    @SerializedName("productSizeIdx") val productSizeIdx: Int,
    @SerializedName("size") val size: String
)