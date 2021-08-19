package com.example.kream.kotlin.src.main.shop_product

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.shop_product.models.ProductDescriptionResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductService (val view: ProductView) {

    fun tryGetProductDescription(productIdx:Int){
        val productInterface = ApplicationClass.sRetrofit.create((ProductRetrofitInterface::class.java))
        productInterface.getProductDescription(productIdx).enqueue(object : Callback<ProductDescriptionResponse>{

            override fun onResponse(
                call: Call<ProductDescriptionResponse>,
                response: Response<ProductDescriptionResponse>
            ) {
                view.onGetProdDescriptionSuccess(response.body() as ProductDescriptionResponse)
            }

            override fun onFailure(call: Call<ProductDescriptionResponse>, t: Throwable) {
                view.onGetProdDescriptionFailure(t.message ?: "통신 오류")
            }


        })
    }
}