package com.example.kream.kotlin.src.main.shop

import com.example.kream.kotlin.src.main.shop.models.CategoryResponse
import com.example.kream.kotlin.src.main.shop.models.ProductResponse

interface ShopView {

    fun onGetProdCategorySuccess(response: CategoryResponse, index:Int)
    fun onGetProdCategoryFailure(message : String)

    fun onGetProductSuccess(response: ProductResponse)
    fun onGetProductFailure(message: String)
}