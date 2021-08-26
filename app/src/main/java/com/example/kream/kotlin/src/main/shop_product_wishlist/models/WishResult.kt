package com.example.kream.kotlin.src.main.shop_product_wishlist.models

data class WishResult(
    val brandLogo: String,
    val brandName: String,
    val buyOutPrice: Int,
    val productIdx: Int,
    val productName: String,
    val productSize: String,
    val productSizeIdx: Int,
    val productThumbnail: String
)