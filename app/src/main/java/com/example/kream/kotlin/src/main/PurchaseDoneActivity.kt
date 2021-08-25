package com.example.kream.kotlin.src.main

import android.content.Intent
import android.os.Bundle
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityPurchaseDoneBinding
import com.example.kream.kotlin.src.main.shop_product.ShopProductActivity

class PurchaseDoneActivity:BaseActivity<ActivityPurchaseDoneBinding> (ActivityPurchaseDoneBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}