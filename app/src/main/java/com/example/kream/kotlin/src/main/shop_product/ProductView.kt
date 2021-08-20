package com.example.kream.kotlin.src.main.shop_product

//import com.example.kream.kotlin.src.main.shop_product.models.ProdDescriptionList
import com.example.kream.kotlin.src.main.shop_product.models.AsksResponse
import com.example.kream.kotlin.src.main.shop_product.models.BidsResponse
import com.example.kream.kotlin.src.main.shop_product.models.ProductDescriptionResponse
import com.example.kream.kotlin.src.main.shop_product.models.SalesResponse

interface ProductView {

    fun onGetProdDescriptionSuccess(response : ProductDescriptionResponse)
    fun onGetProdDescriptionFailure(message : String)

    fun onGetSalesSuccess(response: SalesResponse)
    fun onGetSalesFailure(message: String)

    fun onGetAsksSuccess(response: AsksResponse)
    fun onGetAsksFailure(message: String)

    fun onGetBidsSuccess(response: BidsResponse)
    fun onGetBidsFailure(message: String)


}