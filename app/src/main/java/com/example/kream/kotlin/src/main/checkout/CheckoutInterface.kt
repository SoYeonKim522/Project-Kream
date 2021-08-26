package com.example.kream.kotlin.src.main.checkout

import com.example.kream.kotlin.src.main.buy_now.models.BuyNowRequest
import com.example.kream.kotlin.src.main.checkout.models.CheckoutRequest
import com.example.kream.kotlin.src.main.checkout.models.CheckoutResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CheckoutInterface {

    @POST("/api/bids/purchases/{purchaseIdx}/purchase-now")
    fun postBuyNowPayment(@Path("purchaseIdx") purchaseIdx :Int, @Body params: CheckoutRequest) :Call<CheckoutResponse>
}