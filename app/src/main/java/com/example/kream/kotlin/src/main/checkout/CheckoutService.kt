package com.example.kream.kotlin.src.main.checkout

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.checkout.models.CheckoutRequest
import com.example.kream.kotlin.src.main.checkout.models.CheckoutResponse
import retrofit2.Call
import retrofit2.Response

class CheckoutService (val view:CheckoutView) {

    fun tryPostCheckout(purchaseIdx:Int, checkoutRequest:CheckoutRequest){
        val checkoutInterface = ApplicationClass.sRetrofit.create((CheckoutInterface::class.java))
        checkoutInterface.postBuyNowPayment(purchaseIdx, checkoutRequest).enqueue(object :retrofit2.Callback<CheckoutResponse>{
            override fun onResponse(
                call: Call<CheckoutResponse>,
                response: Response<CheckoutResponse>
            ) {
                view.onPostCheckoutSuccess(response.body() as CheckoutResponse)
            }

            override fun onFailure(call: Call<CheckoutResponse>, t: Throwable) {
                view.onPostCheckoutFailure(t.message ?: "통신 오류")
            }

        })
    }

}