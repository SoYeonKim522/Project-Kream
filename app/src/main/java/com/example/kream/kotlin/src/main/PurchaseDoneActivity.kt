package com.example.kream.kotlin.src.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityPurchaseDoneBinding
import com.example.kream.kotlin.src.main.shop_product.ShopProductActivity
import kotlin.math.log

class PurchaseDoneActivity:BaseActivity<ActivityPurchaseDoneBinding> (ActivityPurchaseDoneBinding::inflate){

    val TAG = "log"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productImgUrl = intent.getStringExtra("productImg")
        val paidPrice = intent.getIntExtra("paidPrice",0)
        Log.d(TAG, "마지막페이지: $productImgUrl  $paidPrice")

        binding.buyNowPrice.text = paidPrice.toString()
        Glide.with(this).load(productImgUrl).error(R.drawable.login_button).into(binding.productImg)

        binding.backBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}