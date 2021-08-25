package com.example.kream.kotlin.src.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.CheckBox
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityBuyCheckBinding
import com.example.kream.kotlin.src.main.buy_now.BuyNowActivity

class BuyCheckActivity : BaseActivity<ActivityBuyCheckBinding>(ActivityBuyCheckBinding::inflate) {

    private val TAG ="log"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //상품상세 액티비티에서 데이터 받기
        val prodName = intent.getStringExtra("prodName")
        val modelNo = intent.getStringExtra("modelNo")
        val size = intent.getStringExtra("size")
        val price= intent.getIntExtra("price", 0)
        val imageUrl = intent.getStringExtra("imageUrl")
        val sellPrice = intent.getStringExtra("sellPrice")
        val bidSaleIdx = intent.getStringExtra("bidSaleIdx")
        val productIdx = intent.getIntExtra("productIdx", 0)
        val productSizeIdx = intent.getIntExtra("productSizeIdx", 0)


        Log.d(TAG, "구매전 확인 - 데이터 받기 $size, $price, $prodName, $modelNo $bidSaleIdx")

        binding.productModel.text = "새상품 • " +modelNo
        binding.productName.text = prodName
        binding.productSize.text = size.toString()
        Glide.with(this).load(imageUrl).error(R.drawable.login_button).into(binding.productImg)


        
        //체크 리스트 구현
        val checkBoxList = arrayListOf<CheckBox>(binding.checkBox1, binding.checkBox2, binding.checkBox3, binding.checkBox4)
        val checkCount = ArrayList<CheckBox>()
        for(box in checkBoxList){
             box.setOnCheckedChangeListener { buttonView, isChecked ->
                 if (isChecked) {
                     checkCount.add(box)
                 } else {
                     checkCount.remove(box)
                 }
                 if (checkCount.size == 4) {
                     binding.continueBuyBtn.setBackgroundResource(R.drawable.login_button_clicked)
                     binding.continueBuyBtn.isClickable = true
                     //다음 화면으로 이동. data pass to buy now activity
                     binding.continueBuyBtn.setOnClickListener {
                         val intent = Intent(this, BuyNowActivity::class.java)
                         intent.putExtra("size", size)
                         intent.putExtra("price", price)
                         intent.putExtra("prodName", prodName)
                         intent.putExtra("modelNo", modelNo)
                         intent.putExtra("imageUrl", imageUrl)
                         intent.putExtra("sellPrice", sellPrice)
                         intent.putExtra("bidSaleIdx", bidSaleIdx)
                         intent.putExtra("productIdx", productIdx)
                         intent.putExtra("productSizeIdx", productSizeIdx)
                         Log.d(TAG, "onCreate: buy check에서 데이터 패스 $size, $price, $bidSaleIdx, $productIdx,, $productSizeIdx")
                         startActivity(intent)
                     }

                 } else {
                     binding.continueBuyBtn.setBackgroundResource(R.drawable.login_button)
                     binding.continueBuyBtn.isClickable = false
                 }
             }
        }


        //뒤로가기
        binding.backBtn.setOnClickListener {
            finish()
        }

        //'구매' 글자자색 변경
       redTextSpan()

    }

    //'구매' 색 변경
    private fun redTextSpan() {
        val spannableString = SpannableString("구매하시기 전에 \n꼭 확인하세요.")
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#d9644f")), 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        binding.topNotice.text = spannableString
    }

}