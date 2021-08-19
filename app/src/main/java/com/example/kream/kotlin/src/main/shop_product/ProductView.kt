package com.example.kream.kotlin.src.main.shop_product

//import com.example.kream.kotlin.src.main.shop_product.models.ProdDescriptionList
import com.example.kream.kotlin.src.main.shop_product.models.ProductDescriptionResponse

interface ProductView {

    fun onGetProdDescriptionSuccess(response : ProductDescriptionResponse)
    fun onGetProdDescriptionFailure(message : String)

}