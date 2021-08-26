package com.example.kream.kotlin.src.main.buy_now

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.kream.kotlin.R
import com.example.kream.kotlin.config.ApplicationClass
import com.example.kream.kotlin.config.BaseActivity
import com.example.kream.kotlin.databinding.ActivityBuyNowBinding
import com.example.kream.kotlin.src.main.checkout.CheckoutActivity
import com.example.kream.kotlin.src.main.address.AddAddressActivity
import com.example.kream.kotlin.src.main.buy_now.models.AddressResponse
import com.example.kream.kotlin.src.main.buy_now.models.BuyNowRequest
import com.example.kream.kotlin.src.main.buy_now.models.BuyNowResponse

class BuyNowActivity:BaseActivity<ActivityBuyNowBinding> (ActivityBuyNowBinding::inflate), BuyNowView {
    val TAG = "log"
    val userIdx = ApplicationClass.sSharedPreferences.getString(ApplicationClass.USER_IDX, null)
    private var addressAdded = false
    private var addressIdx = 0



    override fun onResume() {
        super.onResume()

        //'구매 전 체크' 액티비티에서 데이터 받기
        val prodName = intent.getStringExtra("prodName")
        val modelNo = intent.getStringExtra("modelNo")
        val size = intent.getStringExtra("size")
        val price = intent.getIntExtra("price", 0)
        val imageUrl = intent.getStringExtra("imageUrl")
        val sellPrice = intent.getStringExtra("sellPrice")
        val bidSaleIdx = intent.getStringExtra("bidSaleIdx")
        val productIdx = intent.getIntExtra("productIdx", 0)
        val productSizeIdx = intent.getIntExtra("productSizeIdx", 0)
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
            //여기서 말고 구매등록 api 응답값 통해서 전달 예정
//            val intent = Intent(this, CheckoutActivity::class.java)
//            intent.putExtra("size", size)
//            intent.putExtra("price", price)
//            intent.putExtra("prodName", prodName)
//            intent.putExtra("modelNo", modelNo)
//            intent.putExtra("imageUrl", imageUrl)

            val postRequest = BuyNowRequest(targetBidSaleIdx = bidSaleIdx!!.toInt(),  purchasePrice = price, point = "FALSE", inspectionFee=0, shippingFee=0,
            totalPrice=price, addressIdx=addressIdx, productSizeIdx=productSizeIdx)
            Log.d(TAG, "postRequest - : $postRequest")//works
            BuyNowService(this).tryPostBuyNowRequest(productIdx = productIdx, postRequest)
            showLoadingDialog(this)
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

//        val name = intent.getStringExtra("name")
//        addressIdx = intent.getIntExtra("addressIdx",-1)
        val name = ApplicationClass.sSharedPreferences.getString("addressName", null)
        addressIdx = ApplicationClass.sSharedPreferences.getInt("addressIdx", -1)

        Log.d(TAG, "onRestart - sp 주소 이름: $name $addressIdx") //null

        if (name!=null && addressIdx!=-1){
            Log.d(TAG, "onRestart: 저장된 주소 불러오기 호출")
            BuyNowService(this).tryGetAddress(userIdx!!.toInt())
        }

    }

    override fun onGetAddressSuccess(response: AddressResponse) {
        //result[i] 로 for 문 돌리면서 idx 같을 경우 찾는걸로 수정해야
        val result = response.result[0]

        Log.d(TAG, "onGetAddressSuccess: 결과 $result")
        val name = result.name
        val address = result.address
//        addressIdx = result.idx
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
        val result = response.result
        val bidPurchaseIdx = result.bidPurchaseIdx
        val targetBidSaleIdx = result.targetBidSaleIdx
        val productImg = result.productThumbnail
        val modelNo = result.productModelNo
        val productName = result.productName
        val size = result.productSize
        val addressName = result.addressName
        val address1 = result.address
        val address2 = result.addressDetail
        val postcode = result.zipCode
        val totalPrice = result.totalPrice
        val buyNowPrice = result.buyPrice
        val inspectionFee = result.inspectionFee
        val shippingFee = result.shippingFee
        val phoneNo = result.addressPhone

        Log.d(TAG, "onPostBuyNowSuccess:등록 - 응답코드 ${response.code}")

        intent = Intent(this, CheckoutActivity::class.java)
        intent.putExtra("bidPurchaseIdx", bidPurchaseIdx)
        intent.putExtra("targetBidSaleIdx", targetBidSaleIdx)
        intent.putExtra("productImg", productImg)
        intent.putExtra("modelNo", modelNo)
        intent.putExtra("productName", productName)
        intent.putExtra("size", size)
        intent.putExtra("addressName", addressName)
        intent.putExtra("address1", address1)
        intent.putExtra("address2", address2)
        intent.putExtra("postcode", postcode)
        intent.putExtra("totalPrice", totalPrice)
        intent.putExtra("buyNowPrice", buyNowPrice)
        intent.putExtra("inspectionFee", inspectionFee)
        intent.putExtra("shippingFee", shippingFee)
        intent.putExtra("addressPhone", phoneNo)

        startActivity(intent)

        showCustomToast("구매 등록 완료. 결제로 이동")
        dismissLoadingDialog()

    }

    override fun onPostBuyNowFailure(message: String) {
        Log.d(TAG, "onPostBuyNowFailure: $message")
        dismissLoadingDialog()

    }


}



