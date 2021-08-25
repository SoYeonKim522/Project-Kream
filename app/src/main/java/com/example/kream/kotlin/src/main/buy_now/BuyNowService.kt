package com.example.kream.kotlin.src.main.buy_now

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.buy_now.models.AddressResponse
import com.example.kream.kotlin.src.main.buy_now.models.BuyNowRequest
import com.example.kream.kotlin.src.main.buy_now.models.BuyNowResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuyNowService(val view:BuyNowView) {

    private val buyNowInterface = ApplicationClass.sRetrofit.create((BuyNowInterface::class.java))

    fun tryGetAddress(userIdx : Int){
        buyNowInterface.getAddressList(userIdx).enqueue(object : Callback<AddressResponse>{
            override fun onResponse(
                call: Call<AddressResponse>,
                response: Response<AddressResponse>
            ) {
                view.onGetAddressSuccess(response.body() as AddressResponse)
            }

            override fun onFailure(call: Call<AddressResponse>, t: Throwable) {
                view.onGetAddressFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostBuyNowRequest(productIdx:Int, buyNowRequest: BuyNowRequest){
        buyNowInterface.postBuyNowRequest(productIdx, buyNowRequest).enqueue(object : Callback<BuyNowResponse>{
            override fun onResponse(
                call: Call<BuyNowResponse>,
                response: Response<BuyNowResponse>
            ) {
                view.onPostBuyNowSuccess(response.body() as BuyNowResponse)
            }

            override fun onFailure(call: Call<BuyNowResponse>, t: Throwable) {
                view.onPostBuyNowFailure(t.message ?: "통신 오류")

            }
        })
    }
}