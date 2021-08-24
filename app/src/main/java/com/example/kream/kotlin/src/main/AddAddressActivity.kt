package com.example.kream.kotlin.src.main

import android.os.Bundle
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityAddAddressBinding

class AddAddressActivity:BaseActivity<ActivityAddAddressBinding>(ActivityAddAddressBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding.backBtn.setOnClickListener {
            finish()
        }
    }
}