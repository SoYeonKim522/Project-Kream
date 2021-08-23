package com.example.kream.kotlin.src.main.shop_product_wishlist

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.AddWishRequest
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.AddWishResponse
import com.example.kream.kotlin.src.main.shop_product_wishlist.models.SizeResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ProdWishlistService (val view: ProdWishlistView) {

    private val wishlistInterface = ApplicationClass.sRetrofit.create((ProdWishlistInterface::class.java))

    fun tryGetAllSizeList(productIdx: Int){
        wishlistInterface.getAllSizeList(productIdx).enqueue(object :retrofit2.Callback<SizeResponse>{
            override fun onResponse(call: Call<SizeResponse>, response: Response<SizeResponse>) {
                view.onGetAllSizeListSuccess(response.body() as SizeResponse)
            }

            override fun onFailure(call: Call<SizeResponse>, t: Throwable) {
                view.onGetAllSizeListFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostWishlist(productIdx: Int, addWishRequest: AddWishRequest){
        wishlistInterface.postWishlist(productIdx, addWishRequest).enqueue(object :retrofit2.Callback<AddWishResponse>{
            override fun onResponse(call: Call<AddWishResponse>, response: Response<AddWishResponse>) {
                view.onPostWishlistSuccess(response.body() as AddWishResponse)
            }
            override fun onFailure(call: Call<AddWishResponse>, t: Throwable) {
                view.onPostWishlistFailure(t.message ?: "통신 오류")
            }
        })


    }





}