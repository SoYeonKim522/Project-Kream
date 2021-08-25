package com.example.kream.kotlin.src.main.style

import com.example.kream.kotlin.src.main.style.models.StyleResponse

interface StyleView {

    fun onGetStyleSuccess(response: StyleResponse)
    fun onGetStyleFailure(message:String)

}