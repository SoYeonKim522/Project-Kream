package com.example.kream.kotlin.src.main.shop_product.models

import com.google.gson.annotations.SerializedName

data class BidsResult(
    @SerializedName("bidPurchaseList")  val bidPurchaseList: List<BidsList>,
    @SerializedName("first") val first: Boolean,
    @SerializedName("last") val last: Boolean,
    @SerializedName("pageNumber") val pageNumber: Int,
    @SerializedName("totalElements") val totalElements: Int,
    @SerializedName("totalPages") val totalPages: Int
)