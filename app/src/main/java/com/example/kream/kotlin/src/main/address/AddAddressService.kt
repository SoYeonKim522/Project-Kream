package com.example.kream.kotlin.src.main.address

import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.src.main.address.models.AddAddressResponse
import com.example.kream.kotlin.src.main.address.models.PostAddressRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddAddressService(val view: AddAddressActivityView) {
    private val addAddressInterface = ApplicationClass.sRetrofit.create((AddAddressInterface::class.java))

    fun tryPostAddress(userIdx:Int, addAddressRequest: PostAddressRequest){
        addAddressInterface.postAddress(userIdx, addAddressRequest).enqueue(object :Callback<AddAddressResponse>{
            override fun onResponse(call: Call<AddAddressResponse>, response: Response<AddAddressResponse>) {
                view.onPostAddressSuccess(response.body() as AddAddressResponse)
            }

            override fun onFailure(call: Call<AddAddressResponse>, t: Throwable) {
                view.onPostAddressFailure(t.message ?: "통신 오류")
            }

        })
    }
}