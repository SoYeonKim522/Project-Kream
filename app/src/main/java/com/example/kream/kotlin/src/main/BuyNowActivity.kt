package com.example.kream.kotlin.src.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityBuyNowBinding
import com.example.kream.kotlin.src.main.address.AddAddressActivity
import okhttp3.internal.parseCookie

class BuyNowActivity:BaseActivity<ActivityBuyNowBinding> (ActivityBuyNowBinding::inflate) {
    val TAG = "log"
    val userIdx = ApplicationClass.sSharedPreferences.getString(ApplicationClass.USER_IDX, null)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //구매 전 체크 액티비티에서 데이터 받기
        val prodName = intent.getStringExtra("prodName")
        val modelNo = intent.getStringExtra("modelNo")
        val size = intent.getStringExtra("size")
        val price = intent.getIntExtra("price", 0)
        val imageUrl = intent.getStringExtra("imageUrl")
        val sellPrice = intent.getStringExtra("sellPrice")
        Log.d(TAG, " 즉시구매액티비티에서 데이터 받기 $size, $price, $prodName, $modelNo")

        binding.productModel.text = "새상품 • " + modelNo
        binding.productName.text = prodName
        binding.productSize.text = size.toString()
        binding.buyNowPrice.text = price.toString() + " 원"
        binding.buyNowPriceBig.text = price.toString() + " 원"
        binding.buyNowPriceRed.text = price.toString() + " 원"
        binding.sellNowPrice.text = sellPrice + " 원"

        Glide.with(this).load(imageUrl).error(R.drawable.login_button).into(binding.productImg)

//        //주소 추가했을 때 받아오기
//        val name = intent.getStringExtra("name")
//        val address = intent.getStringExtra("address1")
//        Log.d(TAG, "onCreate 받아온 주소: $name")
//
//        if (name!=null && address!=null){
//            Log.d(TAG, "onCreate: $name")
//            binding.addressInput.text = name.toString() +"/"+ address.toString()
//            binding.addressInput.setTextColor(Color.parseColor("#000000"))
//        }


        //결제 화면으로 이동
        binding.continueBuyBtn.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("size", size)
            intent.putExtra("price", price)
            intent.putExtra("prodName", prodName)
            intent.putExtra("modelNo", modelNo)
            intent.putExtra("imageUrl", imageUrl)
            Log.d(TAG, "onCreate: buy now 에서 데이터 패스 $size, $price, $prodName, $modelNo")

            startActivity(intent)
        }

        binding.registerAddressBtn.setOnClickListener {
            val intent = Intent(this, AddAddressActivity::class.java)
            startActivity(intent)
        }


        binding.backBtn.setOnClickListener {
            super.finish()
        }

//        val resultListener =
//            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//
//                if (it.resultCode == 1 && it.resultCode == RESULT_OK) {
//                    val data = it.data
//                    val name = data?.getStringExtra("name")
//                    val address = data?.getStringExtra("address1")
//                    Log.d(TAG, "onCreate 받아온 주소: $name")
//
//                    if (name != null && address != null) {
//                        Log.d(TAG, "onCreate: $name")
//                        binding.addressInput.text = name.toString() + "/" + address.toString()
//                        binding.addressInput.setTextColor(Color.parseColor("#000000"))
//                    }
//                }
//
//            }
//        resultListener.launch(intent)
    }


}



