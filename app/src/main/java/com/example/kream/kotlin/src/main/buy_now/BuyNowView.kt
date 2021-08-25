package com.example.kream.kotlin.src.main.buy_now

import com.example.kream.kotlin.src.main.buy_now.models.AddressResponse

interface BuyNowView {

    fun onGetAddressSuccess(response: AddressResponse)
    fun onGetAddressFailure(message:String)
}