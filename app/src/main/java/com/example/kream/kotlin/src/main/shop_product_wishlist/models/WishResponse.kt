package com.example.kream.kotlin.src.main.shop_product_wishlist.models

data class WishResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<WishResult>
)