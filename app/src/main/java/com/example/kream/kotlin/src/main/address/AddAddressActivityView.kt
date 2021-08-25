package com.example.kream.kotlin.src.main.address

import com.example.kream.kotlin.src.main.address.models.AddAddressResponse

interface AddAddressActivityView {
    fun onPostAddressSuccess(response: AddAddressResponse)
    fun onPostAddressFailure(message:String)
}