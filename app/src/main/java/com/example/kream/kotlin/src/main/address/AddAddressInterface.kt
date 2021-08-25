package com.example.kream.kotlin.src.main.address

import com.example.kream.kotlin.src.main.address.models.AddAddressResponse
import com.example.kream.kotlin.src.main.address.models.PostAddressRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AddAddressInterface {
    @POST("/api/users/{userIdx}/addresses")
    fun postAddress(@Path("userIdx") userIdx: Int, @Body params: PostAddressRequest): Call<AddAddressResponse>

}