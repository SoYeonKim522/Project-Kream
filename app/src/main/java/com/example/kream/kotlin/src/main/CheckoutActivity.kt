package com.example.kream.kotlin.src.main

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivitiyCheckoutBinding

class CheckoutActivity:BaseActivity<ActivitiyCheckoutBinding>(ActivitiyCheckoutBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //data from buy now activity
        val prodName = intent.getStringExtra("prodName")
        val modelNo = intent.getStringExtra("modelNo")
        val size = intent.getStringExtra("size")
        val price= intent.getIntExtra("price", 0)
        val imageUrl = intent.getStringExtra("imageUrl")

        binding.productModel.text = "새상품 • " +modelNo
        binding.productName.text = prodName
        binding.productSize.text = size.toString()
        binding.totalPayment.text = price.toString() + " 원"
        binding.buyNowPrice.text = price.toString() + " 원"
        binding.buyNowPriceRed.text = price.toString() + " 원"
        Glide.with(this).load(imageUrl).error(R.drawable.login_button).into(binding.productImg)


        //체크 리스트 구현
        val checkBoxList = arrayListOf<CheckBox>(binding.checkBox1, binding.checkBox2, binding.checkBox3)
        val checkCount = ArrayList<CheckBox>()
        for(box in checkBoxList){
            box.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    checkCount.add(box)
                } else {
                    checkCount.remove(box)
                }
                if (checkCount.size == 3) {
                    binding.checkoutBtn.setBackgroundResource(R.drawable.login_button_clicked)
                    binding.checkoutBtn.isClickable = true
                    //다음 화면으로 이동
//                    binding.checkoutBtn.setOnClickListener {
//                        val intent = Intent(this, BuyNowActivity::class.java)
//                        intent.putExtra("size", size)
//                        intent.putExtra("price", price)
//                        intent.putExtra("prodName", prodName)
//                        intent.putExtra("modelNo", modelNo)
//                        intent.putExtra("imageUrl", imageUrl)
////                         Log.d(TAG, "onCreate: buy check에서 데이터 패스 $size, $price, $prodName, $modelNo")
//                        startActivity(intent)
//                    }
                } else {
                    binding.checkoutBtn.setBackgroundResource(R.drawable.login_button)
                    binding.checkoutBtn.isClickable = false
                }
            }
        }



        binding.backBtn.setOnClickListener {
            super.finish()
        }
    }
}