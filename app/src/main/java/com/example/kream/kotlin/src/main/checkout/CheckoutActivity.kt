package com.example.kream.kotlin.src.main.checkout

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivitiyCheckoutBinding
import com.example.kream.kotlin.src.main.PurchaseDoneActivity
import com.example.kream.kotlin.src.main.checkout.models.CheckoutRequest
import com.example.kream.kotlin.src.main.checkout.models.CheckoutResponse

class CheckoutActivity:BaseActivity<ActivitiyCheckoutBinding>(ActivitiyCheckoutBinding::inflate), CheckoutView {

    private val TAG ="log"
    val userIdx = ApplicationClass.sSharedPreferences.getString(ApplicationClass.USER_IDX, null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //data from buy now activity
        val bidPurchaseIdx = intent.getIntExtra("bidPurchaseIdx",0)
        val targetBidSaleIdx = intent.getIntExtra("targetBidSaleIdx",0)
        val imageUrl = intent.getStringExtra("productImg")
        val modelNo = intent.getStringExtra("modelNo")
        val productName = intent.getStringExtra("productName")
        val size = intent.getStringExtra("size")
        val addressName = intent.getStringExtra("addressName")
        val address1 = intent.getStringExtra("address1")
        val address2 = intent.getStringExtra("address2")
        val postcode = intent.getStringExtra("postcode")
        val totalPrice = intent.getIntExtra("totalPrice",0)
        val buyNowPrice = intent.getIntExtra("buyNowPrice",0)
        val phoneNo = intent.getStringExtra("addressPhone")
//        val inspectionFee = intent.getIntExtra("inspectionFee",0)
//        val shippingFee = intent.getIntExtra("shippingFee",0)


        Log.d(TAG, "bidPurchaseIdx 왔는지!!!: $addressName  $bidPurchaseIdx")

        binding.productModel.text = "새상품 • " +modelNo
        binding.productName.text = productName
        binding.productSize.text = size.toString()
        binding.totalPayment.text = totalPrice.toString() + " 원"
        binding.buyNowPrice.text = buyNowPrice.toString() + " 원"
        binding.buyNowPriceRed.text = totalPrice.toString() + " 원"
        binding.address.text =  "("+postcode+") "+address1 + address2
        binding.shipTo.text = addressName
        binding.phoneNo.text = phoneNo?.substring(0,4)+"****"+phoneNo?.substring(7,11)

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
                    //결제하기 버튼 활성화
                    binding.checkoutBtn.setBackgroundResource(R.drawable.login_button_clicked)
                    binding.checkoutBtn.isClickable = true


                } else {
                    binding.checkoutBtn.setBackgroundResource(R.drawable.login_button)
                    binding.checkoutBtn.isClickable = false
                }
            }
        }

        binding.backBtn.setOnClickListener {
            super.finish()
        }
        
        //결제 api 호출
        binding.checkoutBtn.setOnClickListener {
            val postRequest = CheckoutRequest(targetBidSaleIdx = targetBidSaleIdx, cardIdx = 7)
            CheckoutService(this).tryPostCheckout(bidPurchaseIdx, postRequest)
            Log.d(TAG, "onCreate 결제 액티비티: $postRequest")    //works
            showLoadingDialog(this)
        }

    }

    override fun onPostCheckoutSuccess(response: CheckoutResponse) {
        val result = response.result

        Log.d(TAG, "onPostCheckoutSuccess: RESULT = ${response.result}")  //null
        Log.d(TAG, "onPostCheckoutSuccess: ${response.code}")  //2015
        val productImg = result.thumbnail
        val paidPrice = result.productPrice
        val intent = Intent(this, PurchaseDoneActivity::class.java)
        intent.putExtra("productImg", productImg)
        intent.putExtra("paidPrice", paidPrice)

        Log.d(TAG, "onPostCheckoutSuccess: 마지막페이지로 전달! $productImg $paidPrice")

        if (response.code==2015){
            Log.d(TAG, "없거나 삭제되거나 유저의 결제카드가 아닙니다")
        }
        if (response.code==1000){
            Log.d(TAG, "onPostCheckoutSuccess: 구매 완료 화면으로 이동!")
            startActivity(intent)
        }
        dismissLoadingDialog()
    }

    override fun onPostCheckoutFailure(message: String) {
        Log.d(TAG, "onPostCheckoutFailure: $message")
        dismissLoadingDialog()
    }


}