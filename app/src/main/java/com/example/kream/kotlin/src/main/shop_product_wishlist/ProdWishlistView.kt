package com.example.kream.kotlin.src.main.shop_product_wishlist

import com.example.kream.kotlin.src.main.shop_product_wishlist.models.AddWishResponse
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.SizeResponse

interface ProdWishlistView {
    fun onGetAllSizeListSuccess(response: SizeResponse)
    fun onGetAllSizeListFailure(message:String)

    fun onPostWishlistSuccess(response: AddWishResponse)
    fun onPostWishlistFailure(message: String)
}