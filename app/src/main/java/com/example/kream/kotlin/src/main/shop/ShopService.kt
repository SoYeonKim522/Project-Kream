package com.example.kream.kotlin.src.main.shop

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.shop.models.CategoryResponse
import com.example.kream.kotlin.src.main.shop.models.DetailCategory
import com.example.kream.kotlin.src.main.shop.models.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShopService (val view: ShopView){

//    var catData : CategoryResponse? = null
//    var catList : List<DetailCategory>? =null
    lateinit var catAdapter:ShopCategoryAdapter
    private val shopRetrofitInterface = ApplicationClass.sRetrofit.create((ShopRetrofitInterface::class.java))


    fun tryGetProductCategory(exposure:String, index:Int){
        shopRetrofitInterface.getProductCategory(exposure).enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                view.onGetProdCategorySuccess(response.body() as CategoryResponse, index)
                val res = response.body()

                //catAdapter = ShopCategoryAdapter(it.res)
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                view.onGetProdCategoryFailure(t.message ?: "통신 오류")
            }
        })
    }


    fun tryGetProducts(){
        shopRetrofitInterface.getProducts().enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                view.onGetProductSuccess(response.body() as ProductResponse)
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                view.onGetProductFailure(t.message ?: "통신 오류")
            }
        })
    }




}