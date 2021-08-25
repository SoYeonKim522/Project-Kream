package com.example.kream.kotlin.src.main.buy_now

import android.content.Intent
import android.content.ServiceConnection
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityBuyNowBinding
import com.example.kream.kotlin.src.main.CheckoutActivity
import com.example.kream.kotlin.src.main.address.AddAddressActivity
import com.example.kream.kotlin.src.main.buy_now.models.AddressResponse
import com.example.kream.kotlin.src.main.buy_now.models.BuyNowRequest
import com.example.kream.kotlin.src.main.buy_now.models.BuyNowResponse

class BuyNowActivity:BaseActivity<ActivityBuyNowBinding> (ActivityBuyNowBinding::inflate), BuyNowView {
    val TAG = "log"
    val userIdx = ApplicationClass.sSharedPreferences.getString(ApplicationClass.USER_IDX, null)
    private var addressAdded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //'구매 전 체크' 액티비티에서 데이터 받기
        val prodName = intent.getStringExtra("prodName")
        val modelNo = intent.getStringExtra("modelNo")
        val size = intent.getStringExtra("size")
        val price = intent.getIntExtra("price", 0)
        val imageUrl = intent.getStringExtra("imageUrl")
        val sellPrice = intent.getStringExtra("sellPrice")
        val bidSaleIdx = intent.getIntExtra("bidSaleIdx", 0)
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
        val name = intent.getStringExtra("name")
//        val address = intent.getStringExtra("address1")
        Log.d(TAG, "onCreate 받아온 주소 이름: $name")
//
//        if (name!=null && address!=null){
//            Log.d(TAG, "onCreate: $name")
//            binding.addressInput.text = name.toString() +"/"+ address.toString()
//            binding.addressInput.setTextColor(Color.parseColor("#000000"))
//        }


        //결제 화면으로 이동 & api 호출
        binding.continueBuyBtn.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("size", size)
            intent.putExtra("price", price)
            intent.putExtra("prodName", prodName)
            intent.putExtra("modelNo", modelNo)
            intent.putExtra("imageUrl", imageUrl)
            Log.d(TAG, "onCreate: buy now 에서 데이터 패스 $size, $price, $prodName, $modelNo")

//            val postRequest = BuyNowRequest(targetBidSaleIdx = bidSaleIdx, purchasePrice = price, point = "FALSE", inspectionFee=0, shippingFee=0, totalPrice=price, addressIdx=)
//            BuyNowService(this).tryPostBuyNowRequest(productIdx = productIdx, postRequest)


            startActivity(intent)
        }

        binding.registerAddressBtn.setOnClickListener {
            val intent = Intent(this, AddAddressActivity::class.java)
            startActivity(intent)
        }


        binding.backBtn.setOnClickListener {
            super.finish()
        }




    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
        val name = intent.getStringExtra("name")
        val idx = intent.getStringExtra("addressIdx")

//        val address = intent.getStringExtra("address1")
        Log.d(TAG, "onCreate 받아온 주소 이름: $name $idx")

        BuyNowService(this).tryGetAddress(userIdx!!.toInt())
    }

    override fun onGetAddressSuccess(response: AddressResponse) {
        val result = response.result[0]
        Log.d(TAG, "onGetAddressSuccess: 결과 $result")
        val name = result.name
        val address = result.address
        val addressIdx = result.idx
        val address2 = result.addressDetail
        val postcode = result.zipCode
        val phoneNo = result.phone
        if(name!=null && address!=null){
            binding.addressInput.text = name.toString() + "/" + address.toString()
            binding.addressInput.setTextColor(Color.parseColor("#000000"))
            binding.addressInput.setTypeface(null, Typeface.NORMAL)
            addressAdded = true
        } else Log.d(TAG, "onGetAddressSuccess: null값")
        if(addressAdded){
            Log.d(TAG, "onGetAddressSuccess: 다음 버튼 활성화")
            binding.continueBuyBtn.setBackgroundResource(R.drawable.login_button_clicked)
            binding.continueBuyBtn.isClickable = true
            binding.continueBuyBtn.isEnabled = true

            //다음 화면으로 배송지 정보 전달
//            intent.putExtra("name", name)
//            intent.putExtra("address1", address)
//            intent.putExtra("address2", address2)
//            intent.putExtra("postcode", postcode)
//            intent.putExtra("phoneNo", phoneNo)
//            Log.d(TAG, "onGetAddressSuccess: 배송지 전달 $name $address")

        } else{
            binding.continueBuyBtn.setBackgroundResource(R.drawable.login_button)
            binding.continueBuyBtn.isClickable = false
            binding.continueBuyBtn.isEnabled = false
        }
        
    }

    override fun onGetAddressFailure(message: String) {
        Log.d(TAG, "onGetAddressFailure: $message")
    }

    override fun onPostBuyNowSuccess(response: BuyNowResponse) {
        TODO("Not yet implemented")
    }

    override fun onPostBuyNowFailure(message: String) {
        TODO("Not yet implemented")
    }


}



