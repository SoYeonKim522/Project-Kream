package com.example.kream.kotlin.src.main.buy_now

import com.example.kream.kotlin.src.main.buy_now.models.AddressResponse
import com.example.kream.kotlin.src.main.buy_now.models.BuyNowResponse

interface BuyNowView {

    fun onGetAddressSuccess(response: AddressResponse)
    fun onGetAddressFailure(message:String)

    fun onPostBuyNowSuccess(response: BuyNowResponse)
    fun onPostBuyNowFailure(message: String)
}