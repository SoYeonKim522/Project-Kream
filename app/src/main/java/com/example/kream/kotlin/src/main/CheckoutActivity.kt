package com.example.kream.kotlin.src.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivitiyCheckoutBinding
import com.example.kream.kotlin.src.main.buy_now.BuyNowService
import com.example.kream.kotlin.src.main.buy_now.BuyNowView
import com.example.kream.kotlin.src.main.buy_now.models.AddressResponse

class CheckoutActivity:BaseActivity<ActivitiyCheckoutBinding>(ActivitiyCheckoutBinding::inflate), BuyNowView {

    private val TAG ="log"
    val userIdx = ApplicationClass.sSharedPreferences.getString(ApplicationClass.USER_IDX, null)

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

        //address data from buy now activity
//        val name = intent.getStringExtra("name")
//        val address1 = intent.getStringExtra("address1")
//        val address2 = intent.getStringExtra("address2")
//        val postcode = intent.getStringExtra("postcode")
//        val phoneNo = intent.getStringExtra("phoneNo")

        //get address data from api
        BuyNowService(this).tryGetAddress(userIdx!!.toInt())



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

    override fun onGetAddressSuccess(response: AddressResponse) {
        val result = response.result[0]
        val name = result.name
        val address = result.address
        val address2 = result.addressDetail
        val postcode = result.zipCode
        val phoneNo = result.phone

        Log.d(TAG, "onCreate: $phoneNo")
        binding.shipTo.text = name
        binding.address.text = "("+postcode+") "+address + address2
        binding.phoneNo.text = phoneNo
    }

    override fun onGetAddressFailure(message: String) {
        Log.d(TAG, "onGetAddressFailure: $message")

    }
}