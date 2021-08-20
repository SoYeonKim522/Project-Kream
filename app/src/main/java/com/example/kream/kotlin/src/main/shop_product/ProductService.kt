package com.example.kream.kotlin.src.main.shop_product

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.shop_product.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductService (val view: ProductView) {

    private val productInterface = ApplicationClass.sRetrofit.create((ProductRetrofitInterface::class.java))

    fun tryGetProductDescription(productIdx:Int){
        productInterface.getProductDescription(productIdx).enqueue(object : Callback<ProductDescriptionResponse>{

            override fun onResponse(call: Call<ProductDescriptionResponse>, response: Response<ProductDescriptionResponse>) {
                view.onGetProdDescriptionSuccess(response.body() as ProductDescriptionResponse)
            }
            override fun onFailure(call: Call<ProductDescriptionResponse>, t: Throwable) {
                view.onGetProdDescriptionFailure(t.message ?: "통신 오류")
            }
        })
    }

    //체결거래 내역
    fun tryGetProductSales(productIdx: Int){
        productInterface.getProductSalesRecord(productIdx).enqueue(object : Callback<SalesResponse>{
            override fun onResponse(call: Call<SalesResponse>, response: Response<SalesResponse>) {
                view.onGetSalesSuccess(response.body() as SalesResponse)
            }

            override fun onFailure(call: Call<SalesResponse>, t: Throwable) {
                view.onGetSalesFailure(t.message ?: "통신 오류")
            }
        })
    }

    //판매입찰 내역
    fun tryGetProductAsks(productIdx: Int){
        productInterface.getProductAsksRecord(productIdx).enqueue(object :Callback<AsksResponse>{
            override fun onResponse(call: Call<AsksResponse>, response: Response<AsksResponse>) {
                view.onGetAsksSuccess(response.body() as AsksResponse)
            }

            override fun onFailure(call: Call<AsksResponse>, t: Throwable) {
                view.onGetAsksFailure(t.message ?: "통신 오류")
            }
        })
    }

    //구매입찰 내역
    fun tryGetProductBids(productIdx: Int){
        productInterface.getProductBidsRecord(productIdx).enqueue(object :Callback<BidsResponse>{
            override fun onResponse(call: Call<BidsResponse>, response: Response<BidsResponse>) {
                view.onGetBidsSuccess(response.body() as BidsResponse)
            }

            override fun onFailure(call: Call<BidsResponse>, t: Throwable) {
                view.onGetBidsFailure(t.message ?: "통신 오류")
            }
        })
    }


    //추천 상품
    fun tryGetRecommendation(productIdx: Int){
        productInterface.getProductRecommend(productIdx).enqueue(object :Callback<RecommendResponse>{
            override fun onResponse(call: Call<RecommendResponse>, response: Response<RecommendResponse>) {
                view.onGetRecSuccess(response.body() as RecommendResponse)
            }

            override fun onFailure(call: Call<RecommendResponse>, t: Throwable) {
                view.onGetRecFailure(t.message ?: "통신 오류")
            }
        })
    }
}