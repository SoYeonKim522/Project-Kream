package com.example.kream.kotlin.src.main.shop_product_by_size

import com.example.kream.kotlin.src.main.shop_product_by_size.models.SellPriceBySizeResponse
import com.example.kream.kotlin.src.main.shop_product_by_size.models.BuyPriceBySizeResponse

interface ProdBySizeView {

    fun onGetBuyPriceBySizeSuccess(response: BuyPriceBySizeResponse)
    fun onGetBuyPriceBySizeFailure(message:String)

    fun onGetSellPriceBySizeSuccess(response: SellPriceBySizeResponse)
    fun onGetSellPriceBySizeFailure(message: String)
}